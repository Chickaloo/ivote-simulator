
public class RegisteredUser extends User {
	
	public RegisteredUser() {
		super();
	}

	// Creates a new IVoteService room and generates a question+answers
	public String createIVoteService(Server s) {

		Room ivs = new IVoteService();

		// Collect Room information and generate question
		ivs.populate();
		
		return s.newRoom(ivs).getToken();
	}
	
}
