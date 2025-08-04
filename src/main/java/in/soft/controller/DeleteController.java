package in.soft.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.soft.entity.User;
import in.soft.factory.ServicesFactory;
import in.soft.services.UserServices;


@WebServlet("/Delete/*")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		UserServices service=ServicesFactory.getUserServices();
		RequestDispatcher rd=null;
		
		User user=new User();
		
		String label=request.getPathInfo();
		
		
		int sid=Integer.parseInt(label.substring(1));
		
		String del=service.udelete(sid);
		
		if(del!=null)
		{
           List<User> use=service.getStu();
			
			User user1=new User();
			
			if(use !=null)
			{
				request.setAttribute("User",use);
				rd=request.getRequestDispatcher("/display.jsp");
				rd.forward(request, response);
			}
			else
			{
				rd=request.getRequestDispatcher("/failure.html");
				rd.forward(request, response);
			}
		}
		
	}

}
