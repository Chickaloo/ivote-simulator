import java.util.Hashtable;

public class UserDatabase implements Database<RegisteredUser> {
	private static UserDatabase database;
		
	private static Hashtable<String, RegisteredUser> table;
	private static int nextUserID;
	
	private UserDatabase(){
		table = new Hashtable<String, RegisteredUser>();
		nextUserID = 0;
	}
	
	// TODO: Is a UserDatabase really a singleton?
	// A connection to an actual database would be.
	public static UserDatabase getConnection() {
		if (database == null) {
			synchronized(Database.class) {
				if (database == null) {
					database = new UserDatabase();
				}
			}
		}
		return database;
	}
	
	public RegisteredUser get(String credentials) {
		return table.get(credentials);
	}
	
	public boolean contains(String credentials) {
		return table.containsKey(credentials);
	}
	
	public int addEntry(String credentials, RegisteredUser u) {
		u.setID(nextUserID);
		table.put(credentials, u);
		
		return nextUserID++;
	}
	
	public int getNewID() {
		return nextUserID++;
	}
	
	public boolean removeEntry(int key) {
		table.remove(key);
		return table.containsKey(key);
	}
}
