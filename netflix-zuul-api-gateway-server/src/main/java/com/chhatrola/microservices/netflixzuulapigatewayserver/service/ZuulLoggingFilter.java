package com.chhatrola.microservices.netflixzuulapigatewayserver.service;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by niv214 on 7/5/20.
 */
public class ZuulLoggingFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return null;  // mainly three types of filter "pre , post and error". you can choose one of it.
    }

    @Override
    public int filterOrder() {
        return 1;   // you can define in which order filter should execute in case of multiple filters
    }

    @Override
    public boolean shouldFilter() {
        return false;   // you can decide wether you want to filter or not based on some busiiness logic or requirement
    }

    @Override
    public Object run() throws ZuulException {  // write your filter service here

        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();

        System.out.println("-------------Request uri : "+request.getRequestURI());

        return null;
    }
}
