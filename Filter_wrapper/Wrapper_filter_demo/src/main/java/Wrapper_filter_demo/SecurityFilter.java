package Wrapper_filter_demo;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;



public class SecurityFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        // Initialization code here
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Security code here
        // For example, check authentication
        boolean isAuthenticated = true; // Dummy authentication
        if (isAuthenticated) {
            chain.doFilter(request, response);
        } else {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

    public void destroy() {
        // Cleanup code here
    }
}
