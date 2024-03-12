package pak.bookevent;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//from jsp to servlet
		String username = request.getParameter("unm"); //unm from jsp form name
		String nic = request.getParameter("nic");
		
		
		try {
		//from servlet to db
			
		List<bookevent> bookDetails = BookingDBUtil.validate(username,nic);
		request.setAttribute("bookDetails", bookDetails);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		//redirect from servlet to new jsp
		RequestDispatcher dis = request.getRequestDispatcher("mybooking.jsp");
		dis.forward(request, response);
	

		
	}

}
