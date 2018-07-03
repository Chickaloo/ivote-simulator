
public class RegisteredUser extends User {
	
	public RegisteredUser(int id) {
		super(id);
	}

	// Creates a new IVoteService room and generates a question+answers
	public String createRoom(Server s) {

		IVoteService ivs = new IVoteService();
		
		// Collect Room information
		ivs.newQuestion();
		
		return s.newRoom(ivs).getToken();
	}
	
}
