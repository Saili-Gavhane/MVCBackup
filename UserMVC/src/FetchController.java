import com.lti.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FetchController
 */
@WebServlet("/FetchController")
public class FetchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FetchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id1=request.getParameter("id");
		int id=Integer.parseInt(id1);
		HttpSession session = request.getSession();
		UserDAO ud=new UserDAO();
		User u=ud.getUserById(id);
		if(u!=null)
		{
			session.setAttribute("user", u);
			RequestDispatcher rd = request.getRequestDispatcher("/userdetails.jsp");
			rd.forward(request, response);
		}
		
	}

}
