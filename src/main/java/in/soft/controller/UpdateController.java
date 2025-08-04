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

@WebServlet("/edit/*")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   response.getWriter().append("Served at: ").append(request.getContextPath());
				
		
		RequestDispatcher rd=null;
		
		UserServices services=ServicesFactory.getUserServices();
		
      String label=request.getPathInfo();
      
      if (label == null || !label.substring(1).matches("\\d+")) {
          response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid student ID");
          return;
      }

	   int sid=Integer.parseInt(label.substring(1));
		
		User ss=services.usearch(sid);
		
		if(ss!=null)
		{
			request.setAttribute("stu", ss);
			rd=request.getRequestDispatcher("/edit.jsp");
			rd.forward(request, response);
		}
		else {
			rd=request.getRequestDispatcher("/failure.html");
			rd.forward(request, response);
		}
		
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=null;
		User u=new User();

	    UserServices services = ServicesFactory.getUserServices();
	    
	    String sidParam = request.getParameter("sid");
	    int sid = 0;

	    try {
	        sid = Integer.parseInt(sidParam);
	    } catch (NumberFormatException e) {
	        System.err.println("Invalid sid: " + sidParam);
	        response.sendRedirect("failure.html");
	        return;
	    }

	  
	    u.setSid(sid); 

	    u.setSname(request.getParameter("sname"));
	    u.setSmarks(Float.parseFloat(request.getParameter("smarks")));
	    u.setSadd(request.getParameter("sadd"));
	    u.setSsec(request.getParameter("ssec"));
	    u.setSstd(Integer.parseInt(request.getParameter("sstd")));	    
		
	    String result = services.uupdate(u);

	    if ("success".equals(result)) {
            List<User> use=services.getStu();
			
			User user1=new User();
			
			if(use !=null)
			{
				request.setAttribute("User",use);
				rd=request.getRequestDispatcher("/display.jsp");
				rd.forward(request, response);
			}

	    } else {
	        response.sendRedirect("failure.html");
	    }
	}


}

