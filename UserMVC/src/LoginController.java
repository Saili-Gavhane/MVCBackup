
import com.lti.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String email =request.getParameter("email");
		String password =request.getParameter("password");
		
		User u=new User();
		u.setEmail(email);
		u.setPassword(password);
		UserDAO userDao=new UserDAO();
		User user=userDao.authentication(u);
		if(user!=null)
		{
			session.setAttribute("user", user);
			RequestDispatcher rd = request.getRequestDispatcher("/loginsuccess.jsp");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp?message=failed");
			rd.forward(request, response);
		}
	}

}
