package stackutils;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import datastructures.BinaryTreeNode;
import datastructures.DefaultBinaryTree;
import datastructures.DefaultBinaryTreeNode;

public class TwentyQuestionsGame extends JPanel implements ActionListener {
	private JButton yes;
	private JButton no;
	private JLabel instructions;
	private JLabel output;
	private String instructionsText;
	private String initialMessage;
	private DefaultBinaryTree<String> tree;
	private BinaryTreeNode<String> currentNode;

	public TwentyQuestionsGame(java.lang.String[] args) {
		super(new BorderLayout());
		instructionsText = "<html>Pick one of the following Roller Derby Teams:<br> "
				+ "Virctorian Roller Derby League, Rose City Rollers, Gotham Girls Roller Derby, Angel City Roller Derby,<br>"
				+ " Denver Roller Derby, Texas Rollergirls, Arch Rival Roller Derby, London Rollergirls,<br> "
				+ "Montreal Roller Derby, Jacksonville Rollergirls, Bay Area Derby, Crime City Rollers, <br> "
				+ "Rainy City Roller Derby, Helsinki Roller Derby, Atlanta Rollergirls, Minnesota RollerGirls.<br><br> Answer the yes or no questions and"
				+ " see if the computer can guess your choice! <br> <br> <br></html>";
		tree = new DerbyFileReader(args).getTree();
		instructions = new JLabel(instructionsText);
		this.add(instructions, BorderLayout.NORTH);
		initialMessage = "Ready to play?";
		output = new JLabel(initialMessage);
		output.setHorizontalAlignment(JLabel.CENTER);
		output.setVerticalAlignment(JLabel.NORTH);
		this.add(output, BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		yes = new JButton("Yes");
		yes.addActionListener(this);
		no = new JButton("No");
		no.addActionListener(this);
		buttonPanel.add(yes);
		buttonPanel.add(no);
		this.add(buttonPanel, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		if (output.getText().equals(initialMessage)) {
			if (e.getSource() == yes) {
				currentNode = tree.getRoot();
				output.setText(currentNode.getData());
			}
		} else {
			if (e.getSource() == yes) {
				if (!currentNode.isLeaf()) {
					currentNode = currentNode.getLeftChild();
					output.setText(currentNode.getData());
				}
			} else {
				if (!currentNode.isLeaf()) {
					currentNode = currentNode.getRightChild();
					output.setText(currentNode.getData());
				}
			}

		}
	}

}
