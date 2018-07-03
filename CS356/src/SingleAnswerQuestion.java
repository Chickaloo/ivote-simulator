import java.util.Hashtable;
import java.util.Scanner;
import java.util.Random;

public class SingleAnswerQuestion implements Question {

	private String question;
	private String[] answers;
	
	public void generateQuestion() {
		
		// Get Question
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a question: ");
		question = in.nextLine();
		
		// Get answers
		String out = "";
		System.out.println("Enter number of answers: ");
		
		// Using in.nextInt() causes problems
		int size = Integer.parseInt(in.nextLine());
		
		answers = new String[size];
		
		for (int i = 0; i < size; i++) {
			System.out.println("Enter answer: ");
			answers[i] = in.nextLine();
		}
		
	}
	
	@Override
	public String getQuestion() {
		return question;
	}

	@Override
	public void setQuestion(String s) {
		question = s;
	}

	@Override
	public String[] getAnswers() {
		return answers;
	}

	@Override
	public void setAnswers(String[] h) {
		answers = h;
		
	}

	public Boolean isValidAnswer(Integer[] i) {
		return (i.length == 1);
	}
	
	@Override
	public Integer[] generateAnswer() {
		Random rng = new Random();
		Integer[] ret = new Integer[] {rng.nextInt(answers.length)};
		return ret;
	}

}
