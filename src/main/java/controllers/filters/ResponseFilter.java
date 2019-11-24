package controllers.filters;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class ResponseFilter implements Filter {

    private static final Logger LOGGER = Logger.getLogger(ResponseFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        final CopyPrintWriter writer = new CopyPrintWriter(response.getWriter());
        chain.doFilter(request, new HttpServletResponseWrapper((HttpServletResponse) response) {
            @Override public PrintWriter getWriter() {
                return writer;
            }
        });

        LOGGER.info("Response"
                + "\nStatus: " + ((HttpServletResponse) response).getStatus()
                + "\nBody: " + writer.getCopy()
                + "\n");
    }

    @Override
    public void destroy() {

    }

    public class CopyPrintWriter extends PrintWriter {

        private StringBuilder copy = new StringBuilder();

        public CopyPrintWriter(Writer writer) {
            super(writer);
        }

        @Override
        public void write(int c) {
            copy.append((char) c); // It is actually a char, not an int.
            super.write(c);
        }

        @Override
        public void write(char[] chars, int offset, int length) {
            copy.append(chars, offset, length);
            super.write(chars, offset, length);
        }

        @Override
        public void write(String string, int offset, int length) {
            copy.append(string, offset, length);
            super.write(string, offset, length);
        }

        public String getCopy() {
            return copy.toString();
        }

    }
}
