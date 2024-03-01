package BookShelf;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;

@WebServlet("/bookshelf")
public class BookShelfServlet extends HttpServlet {

    private static final long serialVersionUID = -9129842164399296305L;
	private BookShelf bookShelf;

    @Override
    public void init() throws ServletException {
        bookShelf = new BookShelf();
        bookShelf.addBooks("Livre 1", "Livre 2", "Livre 3");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setAttribute("books", bookShelf.getBooks());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/bookshelf.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}

