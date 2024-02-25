package Product_CRUD;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
         
            List<Product> products = ProductDAO.getAllProducts();

      
            request.setAttribute("products", products);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/products.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
         
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erreur lors de la récupération des produits");
        }
    }
}

