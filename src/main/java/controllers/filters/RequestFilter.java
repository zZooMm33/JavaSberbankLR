package controllers.filters;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import utils.PropReader;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Фильтр для запросов
 */
public class RequestFilter implements Filter {

    /**
     * Логгер с помощью которого будем записывать логи
     */
    private static final Logger LOGGER = Logger.getLogger(RequestFilter.class);

    /**
     * Метод который будет вызываться до метода doFilter
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * Основной метод фильтра
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        ResettableStreamHttpServletRequest wrappedRequest = new ResettableStreamHttpServletRequest(
                (HttpServletRequest) request);
        HttpServletResponse servletResponse = (HttpServletResponse)response;

        String body = IOUtils.toString(wrappedRequest.getReader());

        LOGGER.info("Request"
                +"\nURL: " + wrappedRequest.getScheme() + "://" + wrappedRequest.getServerName() + ":" + wrappedRequest.getServerPort() + wrappedRequest.getRequestURI()
                +"\nQuery: " + wrappedRequest.getQueryString()
                +"\nBody: " + body
                + "\n");

        wrappedRequest.resetInputStream();

        if (PropReader.getVal(PropReader.MAINTENANCE).equals("true")){
            servletResponse.sendError(503); // отправляем код для режима "техобслуживания"
            return;
        }
        else chain.doFilter(wrappedRequest, response);

    }

    /**
     * Метод будет вызываться после того как отработает метод doFilter
     */
    @Override
    public void destroy() {

    }

    /**
     * Класс который нужен для того что бы прочитать тело запроса несколько раз
     */
    private static class ResettableStreamHttpServletRequest extends
            HttpServletRequestWrapper {

        private byte[] rawData;
        private HttpServletRequest request;
        private ResettableServletInputStream servletStream;

        public ResettableStreamHttpServletRequest(HttpServletRequest request) {
            super(request);
            this.request = request;
            this.servletStream = new ResettableServletInputStream();
        }


        public void resetInputStream() {
            servletStream.stream = new ByteArrayInputStream(rawData);
        }

        @Override
        public ServletInputStream getInputStream() throws IOException {
            if (rawData == null) {
                rawData = IOUtils.toByteArray(this.request.getReader());
                servletStream.stream = new ByteArrayInputStream(rawData);
            }
            return servletStream;
        }

        @Override
        public BufferedReader getReader() throws IOException {
            if (rawData == null) {
                rawData = IOUtils.toByteArray(this.request.getReader());
                servletStream.stream = new ByteArrayInputStream(rawData);
            }
            return new BufferedReader(new InputStreamReader(servletStream));
        }

        private class ResettableServletInputStream extends ServletInputStream {

            private InputStream stream;

            @Override
            public int read() throws IOException {
                return stream.read();
            }

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }
        }
    }

}
