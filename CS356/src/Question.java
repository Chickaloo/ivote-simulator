// Question Interface used by IVoteService

public interface Question {
	
	// Essentially a Constructor
	public void generateQuestion();
	
	// Getter/Setters
	public String getQuestion();

	// Setter for questions when editing the question live
	public void setQuestion(String s);
	
	// Returns list of possible answers
	public String[] getAnswers();;
	
	// Setter for answers when editing a question live
	public void setAnswers(String[] h);
	
	// Checks if answer format is valid
	public Boolean isValidAnswer(Integer[] i);
	
	// Testing purposes only. Generates a valid answer.
	public Integer[] generateAnswer();
}
