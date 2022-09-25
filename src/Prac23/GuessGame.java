package Prac23;

import javax.swing.*;
import java.awt.*;

public final class GuessGame extends JFrame {
	private int number = (int)(Math.random() * 21);
	private int turn = 0;

	public GuessGame() {
		super("Guess Game");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		JTextArea textArea = new JTextArea();
		add(textArea, BorderLayout.CENTER);
		JButton button = new JButton("Guess");
		add(button, BorderLayout.SOUTH);
		JLabel label = new JLabel("Guess the number from 0 to 20");
		add(label, BorderLayout.NORTH);
		setVisible(true);
		button.addActionListener(e -> {
			String input = textArea.getText();
			try{
				int guess = Integer.parseInt(input);
				if (guess == number) {
					JOptionPane.showMessageDialog(null, "You guessed the number!");
					System.exit(0);
				}
				else if (guess > number) {
					label.setText("Guess the number from 0 to 20    " + "Your guess is too high");
				}
				else {
					label.setText("Guess the number from 0 to 20    " + "Your guess is too low");
				}
				turn++;
				if (turn == 3) {
					JOptionPane.showMessageDialog(null, "You lost!");
					System.exit(0);
				}
			}
			catch (NumberFormatException ex) {
				label.setText("Guess the number from 0 to 20\n" + "You entered not a number");
			}
		});

	}
}
