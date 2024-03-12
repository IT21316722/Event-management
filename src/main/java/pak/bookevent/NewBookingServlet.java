package pak.bookevent;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/NewBookingServlet")
public class NewBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("unm");
		String nic = request.getParameter("nic");
		
		
		try {
			List<bookevent> bookDetails = BookingDBUtil.validate(username, nic);
			request.setAttribute("bookDetails", bookDetails);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		RequestDispatcher dis = request.getRequestDispatcher("yourbooking.jsp");
		dis.forward(request, response);
		
	}

}
