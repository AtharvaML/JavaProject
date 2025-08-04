package in.soft.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.soft.entity.User;
import in.soft.factory.ServicesFactory;
import in.soft.services.UserServices;


@WebServlet("/add")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User student=new User();
		RequestDispatcher rd=null;
		String status;
		
			UserServices services=ServicesFactory.getUserServices();
		
		String button_label=request.getParameter("button");
		
		
		if("submit".equals(button_label))
		{
			
			student.setSid(Integer.parseInt(request.getParameter("sid")));
			student.setSname(request.getParameter("sname"));
			student.setSmarks(Float.parseFloat(request.getParameter("smarks")));
			student.setSadd(request.getParameter("sadd"));
			student.setSsec(request.getParameter("ssec"));
			student.setSstd(Integer.parseInt(request.getParameter("sstd")));
			
			
			status=services.uinsert(student);
			
			if(status.equals("success"))
			{
				rd=request.getRequestDispatcher("/success.html");
				rd.forward(request, response);
			}
			if(status.equals("failure"))
			{
				rd=request.getRequestDispatcher("/failure.html");
				rd.forward(request, response);
			}
		     
		}
		
		if("display".equals(button_label))
		{
			List<User> use=services.getStu();
			
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
