import java.util.Hashtable;

public class Server {

		// Normally, db would likely be a connection to a database. But for testing,
		// This is merely a map of credentials to registered users.
		private static Hashtable<String, RegisteredUser> db;
	
		// List of available rooms to join
		private static Hashtable<String, IVoteService> rooms; 
		
		// Creates a new Server object. For testing purposes, this 
		// also initializes a "database" with users. For production, 
		// however, this would instead create a connection to a live database.
		public Server() {
			rooms = new Hashtable<String, IVoteService>();
			db = initSampleDB();
		}
		
		// Inits a database of users for testing purposes.
		private Hashtable<String, RegisteredUser> initSampleDB() {
			
			Hashtable<String, RegisteredUser> d = new Hashtable<String, RegisteredUser>();
			
			register("ckong1/KurisuBestG", new AdminUser(90));
			register("xkcd/CorrectBatteryHorseStaple", new RegisteredUser(91));
			register("reddit/hunter2", new RegisteredUser(92));
			register("equifax/j", new AdminUser(93));
			register("root/", new AdminUser(94));
			
			return d;
		}
		
		// login simulates logging in using credentials.
		public RegisteredUser login(String credentials) {
			return db.get(credentials);
		}
		
		// register simulates simple registration to db.
		public Boolean register(String c, RegisteredUser u) {
			if (db.containsKey(c)) {
				return false;
			} else {
				db.put(c, u);
			}
			return true;
		}
		
		// logout simulates logging out using a userID. Doesn't actually do anything.
		public Boolean logout(String userID) {
			return db.containsKey(userID);
		}
		
		// Creates a new IVote room
		public IVoteService newRoom(IVoteService ivs) {
			//Generate Token.
			assignToken(ivs);
			
			// Put room in 
			rooms.put(ivs.getToken(), ivs);
			
			return rooms.get(ivs.getToken());
		}

		// Assigns a token to the given IVoteService.
		// Opted out of generating actual tokens due to increased implementation difficulty
		private void assignToken(IVoteService ivs) { 
			// If an IVS is removed, this could cause conflicts.
			// Change to CountingHashTable instead, like a DB does.
			ivs.setToken(Integer.toString(rooms.size()));
		}
	
		// Join the desired room, given a room token
		public IVoteService getRoom(String t) {
			return rooms.get(t);
		}
}
