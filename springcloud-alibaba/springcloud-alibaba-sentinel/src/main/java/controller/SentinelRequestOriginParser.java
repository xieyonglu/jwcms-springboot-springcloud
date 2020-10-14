package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;

@Component
public class SentinelRequestOriginParser implements RequestOriginParser{

    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        String server = httpServletRequest.getParameter("server");
        return server;
    }
}
