package Login;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
    private static final long serialVersionUID = 2L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer le nom d'utilisateur depuis la session
        String username = (String) request.getSession().getAttribute("username");

        // Vérifier si l'utilisateur est connecté (présence de l'attribut "username" dans la session)
        if (username != null && !username.isEmpty()) {
            // Afficher la page de bienvenue avec le nom d'utilisateur
            request.setAttribute("username", username);
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        } else {
            // Redirection vers la page de connexion si l'utilisateur n'est pas connecté
            response.sendRedirect("login"); // Utilisation du servlet LoginServlet via l'URL pattern
        }
    }
}

