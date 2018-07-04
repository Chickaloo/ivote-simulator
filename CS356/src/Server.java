import java.util.Hashtable;

public class Server {

		private static UserDatabase database;
		private static Hashtable<String, Room> rooms;
		
		// Creates a new Server object. For testing purposes, this 
		// also initializes a "database" with users. For production, 
		// however, this would instead create a connection to a live database.
		public Server() {
			database = UserDatabase.getConnection();
			rooms = new Hashtable<String, Room>();
		}
		
		// login simulates logging in using credentials. Returns null if "login" "failed"
		public RegisteredUser login(String credentials) {
			return database.get(credentials);
		}

		// logout simulates logging out using a userID. Not currently in use.
		public Boolean logout(String credentials) {
			return database.contains(credentials);
		}
		
		// register simulates simple registration to db.
		public Boolean register(String c, RegisteredUser u) {
			if (database.contains(c)) {
				return false;
			} else {
				database.addEntry(c, u);
			}
			return true;
		}
		
		public int assignGuestID() {
			return database.getNewID();
		}
		
		// Creates a new Room
		public Room newRoom(Room r) {
			//Generate Token.
			assignToken(r);
			
			// Put room in 
			rooms.put(r.getToken(), r);
			
			return rooms.get(r.getToken());
		}

		// Assigns a token to the given IVoteService.
		// Opted out of generating actual tokens due to increased implementation difficulty
		private void assignToken(Room r) { 
			// If an IVS is removed, this could cause conflicts.
			// Change to CountingHashTable instead, like a DB does.
			r.setToken(Integer.toString(rooms.size()));
		}
	
		// Join the desired room, given a room token
		public Room getRoom(String token) {
			return rooms.get(token);
		}
}
