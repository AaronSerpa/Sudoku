import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
/**
 * the initial view
 * @author Aaron Serpa
 */
public class DifficultyCheckView extends JFrame
{
	/**
	 * needed for error correction
	 */
	private static final long serialVersionUID = 1L;

	private JFrame frame;
	private JLabel title;
	private JButton easy;
	private JButton hard;
	private JPanel titlePanel;
	private JPanel buttons;
	
	/**
	 * constructs  new DifficultyCheckView
	 */
	public DifficultyCheckView()
	{
		int[][] matrix = new int[9][9];//make a new matrix
		frame = new JFrame("Welcom Screen");
		title = new JLabel("<html><div style='text-align: center;'>Sudoku<br/>by Aaron Serpa<br/>Select Difficulty</div></html>", SwingConstants.CENTER);
		
		title.setFont(title.getFont().deriveFont(32f));//set font size in label
		titlePanel = new JPanel();
		titlePanel.add(title);
		easy = new JButton("EASY");
		hard = new JButton("HARD");
		buttons = new JPanel();
		buttons.setLayout(new GridLayout(1, 2, 1, 0));
		buttons.add(easy);
		buttons.add(hard);
		
		//set action listeners for each button
		//the only difference is the difficulty boolean
		easy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean difficulty = true;
				model myModel = new model(matrix, difficulty);//make a new model with the matrix
				String name = "Sudoku";
				gameView MyView = new gameView(name);//make a new view
				@SuppressWarnings("unused")
				controller myController = new controller(MyView, myModel);//make a new controller with the model and the view
				frame.dispose();//close this frame
			} 
		});
		
		hard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean difficulty = false;
				model myModel = new model(matrix, difficulty);//make a new model with the matrix
				String name = "Sudoku";
				gameView MyView = new gameView(name);//make a new view
				@SuppressWarnings("unused")
				controller myController = new controller(MyView, myModel);//make a new controller with the model and the view
				frame.dispose();//close this frame
			} 
		});
		
		frame.setPreferredSize(new Dimension(318,370));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(title, BorderLayout.CENTER);
		frame.add(buttons, BorderLayout.SOUTH);
		frame.pack(); 
		frame.setLocation(500, 115);//frame appears in middle of screen
		frame.setVisible(true);
		
	}
}