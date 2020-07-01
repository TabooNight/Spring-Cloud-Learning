package com.chy.sclzuul.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Zuul请求过滤器
 *
 * @author chy
 * @date 2020-06-30 17:42
 */
public class PreRequestFilter extends ZuulFilter {

    private static final Logger log = LoggerFactory.getLogger(PreRequestFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        log.info("该请求将经过过滤器...");
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        log.info("进行身份认证等处理...");
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("该请求信息为: " + request.getMethod() + " " + request.getRequestURL());
        return null;
    }
}
