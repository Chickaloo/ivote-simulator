import java.util.Random;
import java.util.Scanner;
import java.util.HashSet;

public class MultiAnswerQuestion implements Question{

	private String question;
	
	// Answers is a string of... well, possible answers.
	// For now, users can only pick the indexes of the answers, but
	// I think a better implementation is allow the Instructor
	// to set "answer shortforms" that map to the indexes, enum style.
	// Then students can pick from those shortforms, like A B YES NO instead of [0] [1] [2] [3]
	private String[] answers;

	public void generateQuestion() {
		
		// Get Question
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a question: ");
		question = in.nextLine();
		
		// Get answers
		String out = "";
		System.out.println("Enter number of answers: ");
		
		// Using in.nextInt() causes problems. This line
		// needs a try/catch, but I'm pushing it at the moment.
		int size = Integer.parseInt(in.nextLine());
		
		answers = new String[size];
		
		for (int i = 0; i < size; i++) {
			System.out.println("Enter answer: ");
			answers[i] = in.nextLine();
		}
		
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String s) {
		question = s;
	}

	public String[] getAnswers() {
		return answers;
	}

	public void setAnswers(String[] h) {
		answers = h;
		
	}

	public Boolean isValidAnswer(Integer[] i) {
		return (i.length >= 1);
	}
	
	// Generates a multi-answer list.
	public Integer[] generateAnswer() {
		Random rng = new Random();
		HashSet<Integer> s = new HashSet<Integer>();
		for (int i = 0; i < answers.length; i++) {
			s.add(rng.nextInt(answers.length));
		}

		Integer[] ret = new Integer[s.size()];
		return s.toArray(ret);
	}


}
