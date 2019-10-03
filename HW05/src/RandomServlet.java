import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RandomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int count = Integer.parseInt(req.getParameter("count"));

        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < count; i++) {
            json.append(String.valueOf((int) (Math.random() * 10))).append(",");
        }
        json.delete(json.length() - 1, json.length());
        json.append("]");
        resp.getWriter().println(json);
    }
}
