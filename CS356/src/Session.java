// Not in use by tester. The Simulation driver behaves like a large "Session" anyways. 
// I think that in a web application, the User would simply be a model and all actions 
// would be performed by the session instead, with actions hidden by permissions.

// Class Session represents a connection between a client and a server.
public class Session {

	// SessionID to maintain connection to server
	private int sessionID;
	
	// Location of server
	private Server server;
	
	// Room that is joined
	private IVoteService ivs;
	
	// User information to populate UI, authenticate, etc
	private User user;
		
	// An authentication token or cookie used to maintain login status
	private String credentials;
	
}
