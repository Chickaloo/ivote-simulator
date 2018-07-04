import java.util.Hashtable;
import java.util.Scanner;

// Tracks inputs and returns to owner of room
public class IVoteService implements Room{
	
	private RegisteredUser owner; // Only registered users and above may make/own questions
	private Question question;
	private Hashtable<Integer, Integer[]> results; // Hashtable just in case certain user info needs to be accessed
	private int roomLimit = 0;
	private String token; // Used as a kind of hyperlink/unique ID for joining
		
	public void populate() {
		results = new Hashtable<Integer, Integer[]>();
		
		Scanner s = new Scanner(System.in);
		System.out.println("Select Question Type:\n [1] Single-choice Question\n [2] Multi-choice Question");
		int type = s.nextInt();
		
		// I need to figure out how to not force people to extend this bar
		if (type == 1) {
			question = new SingleAnswerQuestion();	
		} else if (type == 2) {
			question = new MultiAnswerQuestion();	
		} else {
			System.out.println("Invalid input");
			System.exit(1);
		}
		
		question.generateQuestion();		
	
	}
	
	public Question getQuestion() {
		return question;
	}
	
	public String[] getAnswers() {
		return question.getAnswers();
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String s) {
		token = s;
	}
	
	public void send(int id, Integer[] i) {
		results.put(id, i);
	}
	
	public void addSimulatedAnswer(int i) {

		Integer[] b = question.generateAnswer();
				
		results.put(i, b);
			
	}
	
	public String toString() {
		String ret = "";
		String[] answers = question.getAnswers();
		
		// First, append Question
		ret += "Question: " + question.getQuestion() + "\n";
		int[] ratios = new int[answers.length];
		for (int u : results.keySet()) {
			for (int i : results.get(u)) {
				ratios[i]++;
			}
		}
		
		ret += "Answers: \n";
		// Next, append Answers and their frequencies
		for (int i = 0; i < answers.length; i++) {
			ret += "[" + Integer.toString(i) + "] " + answers[i] + " - " + Integer.toString(ratios[i]) + "\n";
		}
		
		ret += "Users - Submitted Answer(s): \n";
		// Finally, append the list of users and their answers
		for (int u : results.keySet()) {
			ret += "User" + Integer.toString(u) + " - ";
			for (int i : results.get(u)) {
				ret += Integer.toString(i) + " ";
			}
			ret += "\n";
		}
		
		
		return ret;
	}
}
