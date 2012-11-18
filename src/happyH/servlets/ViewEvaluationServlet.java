package happyH.servlets;

import happyH.models.EvaluationFromUser;
import happyH.tables.EvaluationFromUserTable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewEvaluationServlet  extends HttpServlet {
	
	public List<EvaluationFromUser> evalist = new ArrayList<EvaluationFromUser> ();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String rid = request.getParameter("rid");
		evalist = EvaluationFromUserTable.getEvaluationByRID(rid);
		
		if(evalist!=null)
		{
			request.setAttribute("evalist", evalist);
			RequestDispatcher view = request.getRequestDispatcher("/viewEvaluations.jsp");
			view.forward(request,response);
		}
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		doPost(request,response);
	}

}
