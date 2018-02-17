package stackutils;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GuessingGame extends JPanel {
	private static int FRAME_WIDTH = 750;
	private static int FRAME_HEIGHT = 250;

	public static void main(java.lang.String[] args) {
		JFrame twentyQuestions = new JFrame("Twenty Questions");
		twentyQuestions.add(new TwentyQuestionsGame(args));
		twentyQuestions.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		twentyQuestions.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		twentyQuestions.setVisible(true);

	}

}
