
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class DeleteAccountServlet
 */
@WebServlet("/DeleteAccountServlet")
public class DeleteAccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        String dbURL = "jdbc:mysql://localhost:3306/social_media_db";
        String dbUser = "root";
        String dbPassword = "1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(dbURL, dbUser, dbPassword);
            String sql = "DELETE FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.executeUpdate();

            // Invalidate the session to logout the user
            session.invalidate();

            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
