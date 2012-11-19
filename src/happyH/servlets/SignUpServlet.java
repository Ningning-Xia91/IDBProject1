package happyH.servlets;

import happyH.models.User;
import happyH.tables.UserTable;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SignUpServlet extends HttpServlet {
	
	//private static long user_id = 1001; 
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = String.valueOf(UserTable.getMaxUserID()+1);
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		//String confirmPassword = request.getParameter("confirmPassword");
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String cuisineType = request.getParameter("cuisineType");
		String area = request.getParameter("area");

		User user = new User();
		user.setU_id(id);
		user.setU_account(account);
		user.setU_password(password);
		user.setU_name(userName);
		user.setU_email(email);
		user.setPref_type(cuisineType);
		user.setArea(area);
		
		try {
			if (user != null) {
				System.out.println(user.getU_id());
				System.out.println(user.getU_account());
				if (UserTable.getUserByAccount(account)!=null)
				{
					String SameAccount = "There is a same account in our system. Please use another one.";
					request.setAttribute("SameAccount", SameAccount);
					RequestDispatcher view = request.getRequestDispatcher("/signUp.jsp");
					view.forward(request,response);
				}
				else{
				UserTable.insertOneUser(user);
				System.out.println("insert a user!");
				request.getSession().setAttribute("user", user);
				RequestDispatcher view = request.getRequestDispatcher("/firstPage.jsp");
				view.forward(request,response);
				}
			}
		} catch (Exception e) {

		}


		
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		doPost(request,response);
	}

}
