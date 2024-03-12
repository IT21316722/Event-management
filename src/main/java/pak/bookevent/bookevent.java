package pak.bookevent;
//Declaring book event class

public class bookevent {

	//Encapsulation method
		private int id;
		private String username;
		private String nic;
		private String eventname;
		private String place;
		private String date;
		private String noofguests;
		
		
		
		public bookevent(int id, String username, String nic, String eventname, String place, String date,
				String noofguests) {
			
			this.id = id;
			this.username = username;
			this.nic = nic;
			this.eventname = eventname;
			this.place = place;
			this.date = date;
			this.noofguests = noofguests;
		}

		public int getId() {
			return id;
		}

		public String getUsername() {
			return username;
		}

		public String getNic() {
			return nic;
		}

		public String getEventname() {
			return eventname;
		}

		public String getPlace() {
			return place;
		}

		public String getDate() {
			return date;
		}

		public String getNoofguests() {
			return noofguests;
		}

	}
		