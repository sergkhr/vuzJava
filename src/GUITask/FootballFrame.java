package GUITask;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FootballFrame extends JFrame{
	private int firstTeamScore = 0;
	private int secondTeamScore = 0;
	private String firstTeamName = "AC Milan";
	private String secondTeamName = "Real Madrid";
	JLabel score = new JLabel("0 x 0");
	JLabel winner = new JLabel("winner: DRAW");
	JLabel lastScorer = new JLabel("last scorer: N/A");
	JButton firstTeamGoal = new JButton(firstTeamName);
	JButton secondTeamGoal = new JButton(secondTeamName);

	public FootballFrame(){
		super("Football");
		setSize(600, 400);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		firstTeamGoal.setBounds(0, 150, 100, 50);
		add(firstTeamGoal, BorderLayout.WEST);
		secondTeamGoal.setBounds(0, 150, 100, 50);
		add(secondTeamGoal, BorderLayout.EAST);
		score.setBounds(0, 175, 100, 50);
		add(score, BorderLayout.CENTER);
		winner.setSize(100, 50);
		add(winner, BorderLayout.SOUTH);
		lastScorer.setSize(100, 50);
		add(lastScorer, BorderLayout.NORTH);

		firstTeamGoal.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				firstTeamScore++;
				score.setText(firstTeamScore + " x " + secondTeamScore);
				lastScorer.setText("last scorer: " + firstTeamName);
				if (firstTeamScore > secondTeamScore){
					winner.setText("winner: " + firstTeamName);
				}
				else if (firstTeamScore < secondTeamScore){
					winner.setText("winner: " + secondTeamName);
				}
				else{
					winner.setText("winner: DRAW");
				}
			}
		});

		secondTeamGoal.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				secondTeamScore++;
				score.setText(firstTeamScore + " x " + secondTeamScore);
				lastScorer.setText("last scorer: " + secondTeamName);
				if (firstTeamScore > secondTeamScore){
					winner.setText("winner: " + firstTeamName);
				}
				else if (firstTeamScore < secondTeamScore){
					winner.setText("winner: " + secondTeamName);
				}
				else{
					winner.setText("winner: DRAW");
				}
			}
		});
	}

}
