// TODO: Figure out what a "Room" actually does.
// Perhaps there could be a Chat room, and an IVoteRoom?
public interface Room {
	
	public String getToken();
	
	public void setToken(String s);
	
	public void send(int id, Integer[] i);
	
	public void populate();
	
	public Question getQuestion();
}
