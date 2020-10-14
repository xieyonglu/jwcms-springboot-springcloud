package interceptor;

import java.util.concurrent.TimeoutException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

/**
 * 异常处理
 */
@Slf4j
public class ExceptionInterceptor implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
        Exception ex) {
        return decisionException(response, ex);
    }

    private ModelAndView other(HttpServletResponse response, Exception ex) {
        ModelAndView model = new ModelAndView("common/error");
        log.error("ExceptionInterceptor.resolveException error", ex);
        if (ex instanceof TimeoutException) {
            response.setStatus(HttpStatus.REQUEST_TIMEOUT.value());
        } else {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return model;
    }

    /**
     * 处理自定义已出
     */
    private ModelAndView decisionException(HttpServletResponse response, Exception ex) {
        try {
//            if (ex instanceof DecisionBizException) {
//                log.warn("[ExceptionInterceptor] decisionException", ex);
//                response.getOutputStream().println(JsonUtil.toJson(((DecisionBizException)ex).convertResult()));
//            } else if (ex instanceof DecisionException) {
//                log.error("[ExceptionInterceptor] decisionException", ex);
//                response.getOutputStream().println(JsonUtil.toJson(((DecisionException)ex).convertResult()));
//            } else {
                return other(response, ex);
//            }
        } catch (Exception e) {
            log.error("[ExceptionInterceptor] error", e);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }

        return null;
    }
}
