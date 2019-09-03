package s21;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/s21/regionsEX")
public class CountryList4Dao extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Resource(name = "jdbc/hr")
    private DataSource ds;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String value = (String) request.getParameter("Regions");
        DaoCountry dao = new DaoCountry(ds);
        request.setAttribute("countries", dao.getAll(value));
        request.getRequestDispatcher("/s21/regionsEX.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    
        
    }
}