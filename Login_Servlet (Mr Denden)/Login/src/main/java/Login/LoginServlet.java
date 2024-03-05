package Login;
import java.io.IOException;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Vérification des informations d'identification (vous devrez implémenter votre propre logique d'authentification)

        if (isValidUser(username, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("welcome.jsp");
        } else {
            response.sendRedirect("login.jsp?error=1");
        }
    }

	private boolean isValidUser(String username, String password) {
	    
		if ("utilisateur1".equals(username) && "motdepasse1".equals(password)) {
	        return true;
	    } else {
	        return false;
	    }
	}

}

