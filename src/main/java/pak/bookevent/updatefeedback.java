package pak.bookevent;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/updatefeedback")
public class updatefeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id"); 
		String username = request.getParameter("unm"); 
		String nic = request.getParameter("nc");
		String eventname = request.getParameter("evntname");
		String place = request.getParameter("plc");
		String date = request.getParameter("Dt");
		String noofguests = request.getParameter("nog");
		
		
		boolean isTrue;
		
		isTrue = BookingDBUtil.updatebooking(id,username, nic, eventname, place, date, noofguests);
		
		if(isTrue== true) {
			
			//redirect from servlet to new jsp
			RequestDispatcher dis = request.getRequestDispatcher("updsuccess.jsp");
			dis.forward(request, response);
			
		}else {
			
			//redirect from servlet to new jsp
			RequestDispatcher dis = request.getRequestDispatcher("updunsuccess.jsp");
			dis.forward(request, response);
		}
	
		
		
		
		
	}

}
