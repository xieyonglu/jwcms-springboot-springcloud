package consumer;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;

import lombok.extern.slf4j.Slf4j;
import model.User;


@Component
@Slf4j
public class RabbitmqConsumer {
	
	@RabbitHandler
    //@RabbitListener(queues = "rabbitmq-demo")
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "rabbitmq-demo", durable = "true"),
            exchange = @Exchange(name = "rabbit-springboot-exchange", durable = "true", type = "topic"),
            key = "rabbitmq-demo-routingkey"
    ))
    public void receiveMessage(Message message, Channel channel) throws UnsupportedEncodingException {
        String encoding = message.getMessageProperties().getContentEncoding();
        log.info("接收到string消息:[{}]", new String(message.getBody(), "UTF-8"));
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    @RabbitHandler
    //@RabbitListener(queues = "rabbitmq-demo-bean")
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "rabbitmq-demo-bean", durable = "true"),
            exchange = @Exchange(name = "rabbit-springboot-exchange", durable = "true", type = "topic"),
            key = "rabbitmq-demo-routingkey-bean"
    ))
    public void receiveMessage(User user, Message message, Channel channel) {
        log.info("接收到bean消息:[{}]", user);
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }
}
