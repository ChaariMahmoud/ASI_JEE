package Wrapper_filter_demo;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;
import java.io.CharArrayWriter;
import java.io.PrintWriter;

public class CustomHttpServletResponseWrapper extends HttpServletResponseWrapper {
    private CharArrayWriter charArrayWriter = new CharArrayWriter();

    public CustomHttpServletResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    @Override
    public PrintWriter getWriter() {
        return new PrintWriter(charArrayWriter);
    }

    @Override
    public ServletOutputStream getOutputStream() {
        throw new UnsupportedOperationException("Not implemented");
    }

    public String getResponseContent() {
        return charArrayWriter.toString();
    }
}
