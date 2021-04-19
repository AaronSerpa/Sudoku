import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import javax.swing.*;
/**
 * view of the main game
 * @author Aaron Serpa
 */
public class gameView extends JFrame
{
	/**
	 * needed for error correction
	 */
	private static final long serialVersionUID = 1L;

	private JFrame frame;

	Line2D.Double line;

	private JPanel mypanel;
	private JPanel buttonPanel;
	private JPanel notesPanel1;
	private JPanel notesPanel2;
	private JPanel notesPanel3;


	private JTextArea notes1;
	private JTextArea notes2;
	private JTextArea notes3;
	private JTextArea notes4;
	private JTextArea notes5;
	private JTextArea notes6;
	private JTextArea notes7;
	private JTextArea notes8;
	private JTextArea notes9;
	private JTextArea notes10;
	private JTextArea notes11;

	private JButton enter;
	private JButton getAnswer;
	private JButton reset;
	private JButton goBack;
	private JTextField[][] matrix;


	/**
	 * construct a new view of the sudoku board
	 * @param name the name of the frame
	 */
	public gameView(String name)
	{
		matrix = new JTextField[9][9];
		for(int i = 0; i< 9; i++)
		{
			for(int j = 0; j< 9; j++)//initialize every jtextfield and format them
			{
				matrix[i][j]= new JTextField();
				matrix[i][j].setHorizontalAlignment(JTextField.CENTER);
				matrix[i][j].setFont(matrix[i][j].getFont().deriveFont(28f));
			}
		}
		getAnswer = new JButton("SEE SOLUTION");
		reset = new JButton("RESET");
		notesPanel1 = new JPanel();
		notesPanel2 = new JPanel();
		notesPanel3 = new JPanel();
		notesPanel3.setLayout(new GridLayout(1, 11, 1, 0));
		notes1 = new JTextArea();
		notes1.setPreferredSize(new Dimension(100, 370));

		notes2 = new JTextArea();
		notes2.setPreferredSize(new Dimension(100, 370));

		notes3 = new JTextArea();
		notes3.setPreferredSize(new Dimension(20, 100));
		notes4 = new JTextArea();
		notes4.setPreferredSize(new Dimension(20, 100));
		notes5 = new JTextArea();
		notes5.setPreferredSize(new Dimension(20, 100));
		notes6 = new JTextArea();
		notes6.setPreferredSize(new Dimension(20, 100));
		notes7 = new JTextArea();
		notes7.setPreferredSize(new Dimension(20, 100));
		notes8 = new JTextArea();
		notes8.setPreferredSize(new Dimension(20, 100));
		notes9 = new JTextArea();
		notes9.setPreferredSize(new Dimension(20, 100));
		notes10 = new JTextArea();
		notes10.setPreferredSize(new Dimension(20, 100));
		notes11 = new JTextArea();
		notes11.setPreferredSize(new Dimension(20, 100));

		notesPanel1.add(notes1);
		notesPanel2.add(notes2);

		notesPanel3.setBorder(BorderFactory.createEmptyBorder(0,100,0,100));
		notesPanel3.add(notes3);
		notesPanel3.add(notes4);
		notesPanel3.add(notes5);
		notesPanel3.add(notes6);
		notesPanel3.add(notes7);
		notesPanel3.add(notes8);
		notesPanel3.add(notes9);
		notesPanel3.add(notes10);
		notesPanel3.add(notes11);

		frame = new JFrame(name);
		frame.setResizable(false);
		mypanel = new JPanel(){
			/**
			 * for error correction
			 */
			private static final long serialVersionUID = 1L;

			protected void paintComponent(Graphics g) {//drawing thelines for the game
				super.paintComponent(g);
				g.drawLine(94,0, 94, 1000);
				g.drawLine(95,0, 95, 1000);
				g.drawLine(96,0, 96, 1000);
				g.drawLine(97,0, 97, 1000);

				g.drawLine(193,0, 193, 1000);
				g.drawLine(194,0, 194, 1000);
				g.drawLine(195,0, 195, 1000);
				g.drawLine(196,0, 196, 1000);

				g.drawLine(0,102, 1000, 102);
				g.drawLine(0,103, 1000, 103);
				g.drawLine(0,104, 1000, 104);
				g.drawLine(0,105, 1000, 105);

				g.drawLine(0,207, 1000, 207);
				g.drawLine(0,208, 1000, 208);
				g.drawLine(0,209, 1000, 209);
				g.drawLine(0,210, 1000, 210);
			};
		};
		buttonPanel = new JPanel();
		enter = new JButton("ENTER");

		goBack = new JButton("GO BACK");

		frame.setPreferredSize(new Dimension(518,470));//318
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //display it

		mypanel.setLayout(new GridLayout(9,9,7,7));
		for(int i = 0; i< 9; i++)
		{
			for(int j = 0; j< 9; j++)
			{mypanel.add(matrix[i][j]);}
		}
		buttonPanel.setLayout(new GridLayout(1,4,1,0));
		buttonPanel.add(enter);
		buttonPanel.add(goBack);
		buttonPanel.add(reset);
		buttonPanel.add(getAnswer);
		frame.add(mypanel, BorderLayout.CENTER);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		frame.add(notesPanel1, BorderLayout.EAST);
		frame.add(notesPanel2, BorderLayout.WEST);
		frame.add(notesPanel3, BorderLayout.NORTH);
		frame.pack(); 
		frame.setLocation(400, 115);
		frame.setVisible(true);

	}

	/**
	 * put a certain amount of the values from the models matrix into their corresponding place on the board
	 * @param board the models matrix
	 * @param easy the difficuty setting
	 */
	public void populateView(int[][] board, boolean easy)
	{
		int row = (int) (Math.random() * (9));//generate a number from 0 to 8
		int col = (int) (Math.random() * (9));//generate a number from 0 to 8
		//a boolean 2D array to show what parts of the board have been filled
		boolean[][] availableEntries = {{false, false, false, false, false, false, false, false, false},
				{false, false, false, false, false, false, false, false, false},
				{false, false, false, false, false, false, false, false, false},
				{false, false, false, false, false, false, false, false, false},
				{false, false, false, false, false, false, false, false, false},
				{false, false, false, false, false, false, false, false, false},
				{false, false, false, false, false, false, false, false, false},
				{false, false, false, false, false, false, false, false, false},
				{false, false, false, false, false, false, false, false, false}};
		if(easy == true)//if the player chose easy
		{		
			for(int i = 0; i<60;i++)//have 60 elements
			{
				while(availableEntries[row][col] == true)//if the generated spot is taken
				{
					row = (int) (Math.random() * (9));//generate a number from 0 to 8
					col = (int) (Math.random() * (9));//generate a number from 0 to 8
				}
				matrix[row][col].setText(Integer.toString(board[row][col]));//put the corresponding value into the board
				matrix[row][col].setEditable(false);//don't let the user edit this index
				availableEntries[row][col] = true;//mark this spot as filled
			}
		}

		else//if the player chose hard
		{
			for(int i = 0; i<30;i++)//have 30 elements
			{
				while(availableEntries[row][col] == true)//if the generated spot is taken
				{
					row = (int) (Math.random() * (9));//generate a number from 0 to 8
					col = (int) (Math.random() * (9));//generate a number from 0 to 8
				}
				matrix[row][col].setText(Integer.toString(board[row][col]));//put the corresponding value into the board
				matrix[row][col].setEditable(false);//don't let the user edit this index
				availableEntries[row][col] = true;//mark this spot as filled
			}
		}
	}

	/**
	 * check if the row is valid
	 * @param curRow the index of the current row
	 * @param val the value being checked
	 * @return true if the value is valid
	 */
	public boolean checkRow(int curRow, int val)
	{
		for(int i=0; i < 9; i++)// for every entry in this row
		{
			if(Integer.valueOf(matrix[curRow][i].getText())==val)//check to see if the value is present
			{return false;}//if so then the row is invalid
		}
		return true;//if not than it is valid
	}

	/**
	 * check if the column is valid
	 * @param curCol the index of the current column
	 * @param val the value being checked
	 * @return true if the value is valid
	 */
	public boolean checkCol(int curCol, int val)
	{
		for(int i=0; i < 9; i++)// for every entry in this column
		{
			if(Integer.valueOf(matrix[i][curCol].getText())==val)//check to see if the value is present
			{return false;}//if so then the column is invalid
		}
		return true;//if not than it is valid
	}

	/**
	 * check if the box of 9 is valid
	 * @param curRow curCol the index of the current row
	 * @param curCol the index of the current column
	 * @param val the value being checked
	 * @return true if the value is valid
	 */
	public boolean checkBox(int curRow, int curCol, int val)
	{
		int row = curRow - curRow % 3; 	//get the first index for the boxes row
		int rowLim = row + 3;			//the last index for the boxes row
		int col = curCol - curCol % 3; 	//get the first index for the boxes column
		int colLim = col + 3;			//the last index for the boxes column
		for(int i = row; i < rowLim; i++)//for every row in this box
		{
			for(int j = col; j<colLim; j++)//for every entry in this boxes row
			{
				if(Integer.valueOf(matrix[i][j].getText()) == val)//check to see if the value is present
				{return false;}//if so then the box is invalid
			}
		}
		return true;//if not than it is valid

	}

	/**
	 * adds actionlisteners to each button in the view
	 * @param board
	 */
	public void AddActionisteners(int[][]board)
	{
		goBack.addActionListener(new ActionListener() {//create an actionlistener 
			public void actionPerformed(ActionEvent e) 
			{
				frame.setEnabled(false);//dont interact with the frame while dialog is open
				JDialog confirmation = new JDialog(frame, "Go Back");
				confirmation.setUndecorated(true);//can't exit normally
				JLabel  label = new JLabel("<html>Do you want to<br/>go to the<br/>previous screen?</html>");
				label.setFont(label.getFont().deriveFont(15f));
				JPanel dPanel = new JPanel();
				dPanel.add(label);
				JPanel dPanel2 = new JPanel();
				JButton yes = new JButton("YES");
				yes.addActionListener(new ActionListener() {//if you go back

					@Override
					public void actionPerformed(ActionEvent arg0)
					{
						new DifficultyCheckView();//make a new DifficultyCheckView
						frame.dispose();//get rid of this frame which will close all related dialogs
					}

				});
				dPanel2.add(yes);
				confirmation.setSize(200,150);
				confirmation.setVisible(true);
				JButton no = new JButton("NO");
				no.addActionListener(new ActionListener() {//if you stay

					@Override
					public void actionPerformed(ActionEvent arg0) {
						frame.setEnabled(true);//interact with fame again
						confirmation.dispose();//close the dialog
					}

				});
				dPanel2.add(no);
				confirmation.add(dPanel, BorderLayout.CENTER);
				confirmation.add(dPanel2, BorderLayout.SOUTH);
				confirmation.pack(); 
				confirmation.setLocationRelativeTo(frame);//dialog appears ontop of frame
			}
		});

		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setEnabled(false);//dont interact with the frame while dialog is open
				boolean win = true;
				for(int i = 0; i < 9; i++)
				{
					for(int j = 0; j < 9; j++)
					{
						if(!matrix[i][j].getText().equals(Integer.toString(board[i][j])))//for every entr on th board
						{																//if an entry doesn't match up with the models matrix
							win = false;//can't win
							matrix[i][j].setBackground(Color.RED);//make this entry red
						}
						else if(matrix[i][j].isEditable()==true)//if the entry is right and input by the user
						{matrix[i][j].setBackground(UIManager.getColor("TextField.background"));}//make the entry the default color

					}
				}
				JDialog confirmation = new JDialog(frame, "Confirmation");//new dialog
				JLabel  label;
				JPanel dPanel = new JPanel();
				JPanel dPanel2 = new JPanel();
				JButton pos;
				JButton neg;
				if(win == true)//if the user won
				{
					label = new JLabel("<html>Congratulations!<br/>You win!<br/>Play again?</html>");
					pos = new JButton("YES");
					pos.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							new DifficultyCheckView();//make a new DifficultyCheckView
							frame.dispose();//get rid of this frame which will close all related dialogs
						}
					});
					neg = new JButton("NO");
					neg.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							frame.dispose();//get rid of this frame which will close all related dialogs
						}
					});
					dPanel2.add(pos);
					dPanel2.add(neg);
				}

				else//if the user lost
				{
					label = new JLabel("<html>The board isn't in<br/>an acceptable state.<br/>Please try again</html>");
					neg = new JButton("OK");
					neg.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent arg0) {
							frame.setEnabled(true);//interact with fame again
							confirmation.dispose();//close the dialog
						}

					});
					dPanel2.add(neg);
				}
				confirmation.setUndecorated(true);
				label.setFont(label.getFont().deriveFont(15f));
				dPanel.add(label);
				confirmation.add(dPanel, BorderLayout.CENTER);
				confirmation.add(dPanel2, BorderLayout.SOUTH);
				confirmation.setSize(200,150);
				confirmation.setVisible(true);
				confirmation.pack(); 
				confirmation.setLocationRelativeTo(frame);//dialog appears ontop of frame

			}

		});

		reset.addActionListener(new ActionListener() {//press the reset button
			public void actionPerformed(ActionEvent e) {
				frame.setEnabled(false);//dont interact with the frame while dialog is open
				JDialog confirmation = new JDialog(frame, "Go Back");
				confirmation.setUndecorated(true);
				JLabel  label = new JLabel("<html>Do you want<br/>to clear the board?</html>");
				label.setFont(label.getFont().deriveFont(15f));
				JPanel dPanel = new JPanel();
				dPanel.add(label);
				JPanel dPanel2 = new JPanel();
				JButton yes = new JButton("YES");//if they want to reset the board
				yes.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0)
					{
						for(int i = 0; i<9; i++)
						{
							for(int j = 0; j<9; j++)//fo every entry
							{
								if(matrix[i][j].isEditable()==true)//if it is not a preset
								{
									matrix[i][j].setText("");//get rid of the users data
									matrix[i][j].setBackground(UIManager.getColor("TextField.background"));////get rid of any possible red
								}
							}
						}
						frame.setEnabled(true);//interact with fame again
						confirmation.dispose();//close the dialog
					}
				});
				dPanel2.add(yes);
				confirmation.setSize(200,150);
				confirmation.setVisible(true);
				JButton no = new JButton("NO");
				no.addActionListener(new ActionListener() {//if they don't want to reset

					@Override
					public void actionPerformed(ActionEvent arg0) {
						frame.setEnabled(true);//interact with fame again
						confirmation.dispose();//close the dialog
					}
				});
				dPanel2.add(no);
				confirmation.add(dPanel, BorderLayout.CENTER);
				confirmation.add(dPanel2, BorderLayout.SOUTH);
				confirmation.pack(); 
				confirmation.setLocationRelativeTo(frame);//dialog appears ontop of frame
			}
		});

		getAnswer.addActionListener(new ActionListener() {//to show the solution in a dialog

			public void actionPerformed(ActionEvent arg0) 
			{
				JDialog dialog = new JDialog(frame, "Solutions");
				JLabel  label = new JLabel("<html>");//begin label
				for(int i = 0; i<9;i++)
				{
					for(int j = 0; j<9; j++)
					{
						label.setText(label.getText()+ board[i][j]+" ");//put every entry into the label
						if(j ==2 || j==5)
						{label.setText(label.getText()+"| ");}//if three consecutive entries have happened put a |
					}
					label.setText(label.getText()+"<br/>");//new line
					if(i ==2 || i==5)//if three consecutive rows have happened, put a spacer
					{label.setText(label.getText()+" -------+-------+-------<br/>");}
				}
				label.setText(label.getText()+"</html>");//finish label
				label.setFont(label.getFont().deriveFont(30f));
				JPanel temp = new JPanel();
				temp.add(label);
				dialog.setSize(300,300);
				dialog.setVisible(true);
				dialog.add(temp, BorderLayout.CENTER);
				dialog.pack(); 
				dialog.setLocationRelativeTo(frame);//dialog appears ontop of frame
			}
		});
	}
}