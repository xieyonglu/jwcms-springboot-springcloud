package filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class MyFilter extends ZuulFilter{

    /**
     * 返回一个布尔值，表示过滤器是否执行，true执行，false不执行
     */
    @Override
    public boolean shouldFilter() {
        // TODO Auto-generated method stub
        return true;
    }
    /**
     * 过滤器的业务逻辑
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {
            ctx.setSendZuulResponse(false);//过滤该请求，不进行路由
            ctx.setResponseStatusCode(401);//设置响应状态码
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){}
            return null;
        }
        return null;
    }
    /**
     * 通过返回的int来定义过滤器的执行顺序，数字越小优先级越高
     */
    @Override
    public int filterOrder() {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     *   过滤器类型
     * pre:请求被路由之前执行
     * routing:在路由时调用
     * post:在routing和error之后调用
     * error:处理请求发生错误时调用
     */
    @Override
    public String filterType() {
        // TODO Auto-generated method stub
        return "pre";
    }

}
