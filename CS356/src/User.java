import java.util.Random;

// Users are capable of basic interaction, i.e. voting, joining sessions, and leaving sessions.

public class User implements Voter {
	
	private int ID;
	private String credentials;
	
	// This is our connection to the server. 
	private Server server; // Simulates session with server
	private Room ivs; // Room that we join

	public User() {}
	
	public User(String s) {
		credentials = s;
	}
	
	public void submitAnswer(Integer[] i) {
		// Imagine this is a packet or something
		ivs.send(ID, i);
	}
		
	public int getID() {
		return ID;
	}
	
	public void setID(int newID) {
		ID = newID;
	}
	
	public String getCredentials() {
		return credentials;
	}
	
	public void setCredentials(String c) {
		credentials = c;
	}

	public void connectToServer(Server s) {
		server = s;
	}
	
	public void joinRoom(String token) {
		ivs = server.getRoom(token);
	}
	
	
}
