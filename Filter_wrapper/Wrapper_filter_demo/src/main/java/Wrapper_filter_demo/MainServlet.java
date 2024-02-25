package Wrapper_filter_demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LogFilter logFilter = new LogFilter();
        SecurityFilter securityFilter = new SecurityFilter();

        logFilter.doFilter(request, response, (req, res) -> {
            securityFilter.doFilter(req, res, (req2, res2) -> {
            	 CustomHttpServletRequestWrapper customRequest = new CustomHttpServletRequestWrapper(request);
            	 CustomHttpServletResponseWrapper customResponse = new CustomHttpServletResponseWrapper(response);
                processRequest(customRequest, customResponse);

 
                String responseContent = customResponse.getResponseContent();

             
                res2.setContentType("text/html");
                PrintWriter out = res2.getWriter();
                out.println(responseContent);
                out.close();
            });
        });
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
        doGet(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
    
        try {
            PrintWriter writer = response.getWriter();
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>Main Servlet</title>");
            writer.println("<style>");
            writer.println("body { font-family: Arial, sans-serif; background-color: #f0f0f0; }");
            writer.println("h1 { color: #333; }");
            writer.println("p { font-size: 16px; }");
            writer.println(".container { max-width: 800px; margin: 0 auto; padding: 20px; background-color: #fff; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); border-radius: 5px; }");
            writer.println("</style>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<div class=\"container\">");
            writer.println("<h1>Main Servlet</h1>");
            writer.println("<p>Welcome to the Main Servlet!</p>");
            writer.println("<p>This servlet is protected by log and security filters.</p>");
            writer.println("<button onclick=\"window.location.href='/Wrapper_filter_demo/SomeOtherServlet'\">Go to Another Servlet</button>");
            writer.println("</div>");
            writer.println("</body>");
            writer.println("</html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
