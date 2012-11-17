package happyH.servlets;

import happyH.models.User;
import happyH.tables.UserTable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AllUsersServlet  extends HttpServlet {
	
	public List<User> userList = new ArrayList<User> ();
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		userList = UserTable.getAllUsers();
		
		if(userList!=null)
		{
			request.setAttribute("userList", userList);
			RequestDispatcher view = request.getRequestDispatcher("/allUsers.jsp");
			view.forward(request,response);
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		doPost(request,response);
	}

}
