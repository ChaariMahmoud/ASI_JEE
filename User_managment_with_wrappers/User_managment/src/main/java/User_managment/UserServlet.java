package User_managment;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer le UserWrapper depuis le contexte de l'application
        UserWrapper userWrapper = (UserWrapper) getServletContext().getAttribute("userWrapper");

        // Si le UserWrapper n'existe pas, le créer et l'ajouter au contexte de l'application
        if (userWrapper == null) {
            userWrapper = new UserWrapper();
            getServletContext().setAttribute("userWrapper", userWrapper);
        }

        // Créer un utilisateur factice uniquement si la liste d'utilisateurs est vide
        if (userWrapper.getUsers().isEmpty()) {
            userWrapper.addUser(new User("Mahmoud", "chaarimahmoud55@gmail.com"));
        }

        // Transférer le contrôle à la page JSP pour afficher les utilisateurs
        request.getRequestDispatcher("/user.jsp").forward(request, response);
    }
}
