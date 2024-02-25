package Wrapper_filter_demo;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;



public class LogFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        // Initialization code here
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Logging code here
        System.out.println("Request intercepted: " + ((HttpServletRequest)request).getRequestURI());
        // Pass the request along the filter chain
        chain.doFilter(request, response);
    }

    public void destroy() {
        // Cleanup code here
    }
}
