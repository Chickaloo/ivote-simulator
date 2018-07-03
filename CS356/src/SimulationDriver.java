// Simulates adding users and their votes
import java.util.ArrayList;
import java.util.Random;

public class SimulationDriver {	

	
	public static void main(String[] args) {
		
		final int SIMULATED_USER_COUNT = 15;
		
		// Spin up a new server
		Server s = new Server();
		
		// Simulate the process of an instructor logging in
		RegisteredUser instructor = s.login("ckong1/KurisuBestG");
		
		// Create a new IVote room with a question and answers
		String token = instructor.createRoom(s);
		
		// Save time by getting our own instance of the room, since
		// A normal session would also have this information
		IVoteService ivs = s.getRoom(token); 
		
		// Initialize list of users with which we will simulate actions.
		// Since there isn't a need to use different kinds of lists, 
		ArrayList<User> sessions = new ArrayList<User>();
		
		// Add several prepared accounts to the list of users to simulate.
		// The argument is an unhashed and unsalted user+password entry.
		sessions.add(s.login("reddit/hunter2"));
		sessions.add(s.login("equifax/j"));
		sessions.add(s.login("xkcd/CorrectBatteryHorseStaple"));
		sessions.add(s.login("root/"));
		
		// add several guest users to the room's list of participants
		for (int i = 0; i < SIMULATED_USER_COUNT; i++) {
			sessions.add(new User(i));
		}
		
		// Have all users join 
		for (User u : sessions) {
			u.connectToServer(s);
			u.joinRoom(token);
		}
		
		// Simulate answering!
		// In a real situation, I would definitely not issue a whole refresh with
		// each update.
		while (true) {

			for (User u : sessions) {
				try {

					ivs.addSimulatedAnswer(u.getID());
					System.out.println(ivs.toString());

					Thread.sleep(200);
		
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}	
		}
		
	}
}
