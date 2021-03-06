package Others;

import JDBC.MoviesDAO;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/addMovie")
public class Movies extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String title = request.getParameter("title");
        String director = request.getParameter("director");
        String URL = request.getParameter("url");
        String year = request.getParameter("year");

        if (title.isEmpty() || director.isEmpty() || URL.isEmpty() || year.isEmpty()) {
            request.getRequestDispatcher("/empty.jsp").forward(request, response);
        } else {

            MoviesDAO moviesDAO = null;
            moviesDAO = Browse.getMoviesDAO(moviesDAO);
            Movie movie = new Movie(title, director, URL, year);
            moviesDAO.addMovie(movie);
            request.getRequestDispatcher("/confirmAdded.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
