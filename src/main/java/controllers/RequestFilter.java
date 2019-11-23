package controllers;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RequestFilter implements Filter {

    private static final Logger LOGGER = Logger.getLogger(RequestFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {


        RequestWrapper requestWrapper = new RequestWrapper((HttpServletRequest) request);

        BufferedReader br = new BufferedReader(new InputStreamReader(requestWrapper.getInputStream()));
        String body = br.readLine();
        LOGGER.info("\nUrl: " + requestWrapper.getRemoteAddr()
                +":" + requestWrapper.getRemoteAddr()
                +"\nResource: " + ((HttpServletRequest) requestWrapper).getRequestURI()
                +"\nParameterMap: " + requestWrapper.getParameterMap()
                +"\nBody: " + body);
        br.close();

        chain.doFilter(requestWrapper, response);

    }

    @Override
    public void destroy() {

    }
}
