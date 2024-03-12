package pak.bookevent;
//java methods

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BookingInsert")
public class BookingInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//getting data to servlet from jsp
		String username = request.getParameter("unm"); //unm from addfeedback form name
		String nic = request.getParameter("nc");
		String eventname = request.getParameter("evntname");
		String place = request.getParameter("plc");
		String date = request.getParameter("Dt");
		String noofguests = request.getParameter("nog");
		
		
		boolean isTrue;
		
		
		
		isTrue = BookingDBUtil.insertbooking(username, nic, eventname, place, date, noofguests );
		
		if(isTrue == true) {
			
			//redirect from servlet to new jsp
			RequestDispatcher dis = request.getRequestDispatcher("bookingsuccess.jsp");
			dis.forward(request, response);
			
		}else {
			
			RequestDispatcher dis = request.getRequestDispatcher("bookingunsuccess.jsp");
			dis.forward(request, response);
			
		}
		
		
		
	}

}
