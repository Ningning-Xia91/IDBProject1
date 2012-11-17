package happyH.servlets;

import happyH.models.User;
import happyH.tables.UserTable;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		User user = null;
		if (account!=null)
		{
			user = UserTable.getUserByAccount(account);
			if(password.equals(user.getU_password()))
			{
				System.out.println(password);
				System.out.println(user.getU_password());
				user=null;
			}
		}
		else
		{
			throw new ServletException("user was not specified");
		}
		
		if(user != null){
			System.out.println("user");
			try {
				request.setAttribute("user",user);
			    request.getSession().setAttribute("user", user);
				RequestDispatcher view = request.getRequestDispatcher("/firstPage.jsp");
				view.forward(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else
		{
			try {
				RequestDispatcher view = request.getRequestDispatcher("/error.jsp");
				view.forward(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		doPost(request,response);
	}

}
