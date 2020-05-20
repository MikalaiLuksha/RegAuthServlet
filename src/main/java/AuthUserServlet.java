import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/auth")

public class AuthUserServlet extends HttpServlet {

UserStorage userStorage = new UserStorage();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = userStorage.getUserByLogin(login);
        if (user.getPassword().equals(password)){
            req.getSession().setAttribute("currentUser", user);
        }

    }
}
