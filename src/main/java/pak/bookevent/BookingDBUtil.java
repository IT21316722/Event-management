package pak.bookevent;

//design pattern in the web development field (MVC)

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookingDBUtil {
	
	
	//RETRIEVING(Read)
	
	
	//making static method called validate,to return book event array list
	
	public static List<bookevent> validate(String username, String nic){
		
		ArrayList<bookevent> book = new ArrayList<>();
		
		String url = "jdbc:mysql://localhost:3306/bookevent";
		String user = "root";
		String pass = "12345678";
		
		
		try {
			
			
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			
			
			
			String sql = "select * from bookings where username='"+username+"' and nic='"+nic+"'";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			
		if(rs.next()) {
			
			int id = rs.getInt(1);
			String name = rs.getNString(2);
			String nc = rs.getNString(3);
			String eventname = rs.getNString(4);
			String place = rs.getNString(5);
			String date = rs.getNString(6);
			String noofguests = rs.getNString(7);
				
			bookevent b = new bookevent(id,name,nc,eventname,place,date,noofguests);
			
			book.add(b);
			
			
		}
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return book;
		
		
	}
		
	//----------------------------------------------------------------------------------------------------
	
	
	//INSERTING(Create)
	
	public static boolean insertbooking(String username, String nic, String eventname, String place, String date, String noofguests) {
		
		boolean isSuccess = false;
		
		
		//db conn
		String url = "jdbc:mysql://localhost:3306/bookevent";
		String user = "root";
		String pass = "12345678";
		
		
		try {
			
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			
			//Query
			String sql = "insert into bookings values(0,'"+username+"', '"+nic+"', '"+eventname+"', '"+place+"', '"+date+"', '"+noofguests+"' )";
			
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				
				isSuccess = true;
	
			}else {
				
				isSuccess = false;
			}
			
	
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		
		return isSuccess;
		
	}
	
	//------------------------------------------------------------------------------------------------------------------
	
	//UPDATE(Update)
	
	public static boolean updatebooking(String id,String username, String nic, String eventname, String place, String date, String noofguests) {
		
		boolean isSuccess = false;
		
		//db conn
				String url = "jdbc:mysql://localhost:3306/bookevent";
				String user = "root";
				String pass = "12345678";
				
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			
			
			//Query
			String sql = "update bookings set username='"+username+"', nic='"+nic+"', eventname='"+eventname+"', place='"+place+"', date='"+date+"', noofguests='"+noofguests+"'"+"where id='"+id+"'";
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				
				isSuccess = true;
	
			}else {
				
				isSuccess = false;
			}
			
			
		}		
		
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
		return isSuccess;
		
	}
	
	
	//----------------------------------------------------------------------------------------------------
	
	
	//DELETE(Delete)
	
	
		public static boolean deletebooking(String id) {
			
			boolean isSuccess = false;
			
			//db conn
			String url = "jdbc:mysql://localhost:3306/bookevent";
			String user = "root";
			String pass = "12345678";
			
			int convId = Integer.parseInt(id); //converting id as an integer value
			
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, user, pass);
				Statement stmt = con.createStatement();
				
				
				//Query
				String sql = "delete from bookings where id='"+convId+"' ";
				int rs = stmt.executeUpdate(sql);
				
				if(rs > 0) {
					
					isSuccess = true;
		
				}else {
					
					isSuccess = false;
				}
				
				
			}		
			
			catch(Exception e) {
				
				e.printStackTrace();
			}
			
			
			return isSuccess;
		}
	
		
	
	
	
}
