/**
 * models the data
 * @author Aaron Serpa
 */
public class model 
{
	private int[][] matrix;
	private boolean easy;
	private int[] rows;
	private int[] cols;
	
	private static final int MAX_SIZE = 81;			//the total entries of the matrix
	private static final int MAX_ROW_OR_COLLUMN = 9;//the total number of elements in each row or column
	
	/**
	 * constructs a new model
	 * @param newMatrix the 2D array that houses the Sudoku data
	 * @param easy the difficulty boolean
	 */
	public model(int[][] newMatrix, boolean easy)
	{
		matrix = newMatrix;
		this.easy = easy;
		rows = new int[MAX_SIZE]; //the indices for each row
		cols = new int[MAX_SIZE];//the indices for each column
	}

	/**
	 * populate the matrix with a valid sudoku
	 */
	public void populate()
	{
		for(int i = 0; i<MAX_ROW_OR_COLLUMN;i++)//initialize with zeros
		{
			for(int j = 0; j<MAX_ROW_OR_COLLUMN; j++)
			{matrix[i][j] = 0;}
		}
		fillBox(0, 0, 3, MAX_ROW_OR_COLLUMN);//fill in the first row of boxes
		fillBox(3, 0, 6, MAX_ROW_OR_COLLUMN);//fill in the second row of boxes
		fillBox(6, 0, 9, MAX_ROW_OR_COLLUMN);//fill in the third row of boxes
	}

	/**
	 * check if the row is valid
	 * @param curRow the index of the current row
	 * @param val the value being checked
	 * @return true if the value is valid
	 */
	public boolean checkRow(int curRow, int val)
	{
		for(int i=0; i < MAX_ROW_OR_COLLUMN; i++)// for every entry in this row
		{
			if(matrix[curRow][i]==val) //check to see if the value is present
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
		for(int i=0; i < MAX_ROW_OR_COLLUMN; i++)// for every entry in this column
		{
			if(matrix[i][curCol]==val)//check to see if the value is present
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
				if(matrix[i][j] == val)//check to see if the value is present
				{return false;}//if so then the box is invalid
			}
		}
		return true;//if not than it is valid

	}

	/**
	 * get the matrix of the model
	 * @return the matrix of the model
	 */
	public int[][] getMatrix()
	{return matrix;}

	/**
	 * get the difficulty of the model
	 * @return the difficulty of the model
	 */
	public boolean getDifficulty()
	{return easy;}
	
	/**
	 * get the rows of the matrix in the model
	 * @return the rows of the matrix
	 */
	public int[] getRows()
	{return rows;}
	
	/**
	 * get the columns of the matrix in the model
	 * @return the columns of the matrix
	 */
	public int[] getCols()
	{return cols;}
	
	/**
	 * fills a certain portio of the matrix to ensure the laws of sudoku are upheld
	 * @param row the initial row index
	 * @param col the initial column index
	 * @param iLim the final row index
	 * @param jLim the final column index
	 */
	public void fillBox(int row, int col, int iLim, int jLim)
	{
		int num = (int) ((Math.random() * (10 - 1)) + 1); //get a random number between 1 and 9 inclusively
		for(int i = row; i< iLim;i++)//for every given row
		{
			for(int j = col; j< jLim;j++)//for every given entry in this row
			{
				num = (int) ((Math.random() * (10 - 1)) + 1); //get a random number between 1 and 9 inclusively
				boolean first= true; //to check if this is the firt time in the whie loop
				while(checkRow(i, num) == false || checkCol(j, num) == false || checkBox(i, j, num)==false) //while the number is invalid
				{
					if(num == MAX_ROW_OR_COLLUMN && first ==true)//if the number is 9 for the first time
					{
						num = 1; //et it equal to 1
						first = false; //it is no longer the first pass
					}
						num++;//increment the number
				}
				if(num >= 10)//if the number is 10 or more than there's an issue
				{
					for(int k = row; k< iLim;k++)//for every given row
					{
						for(int l = col; l< jLim;l++)//for every given entry in this row
						{matrix[k][l] = 0;}//set all entries to 0
					}
					num = 1;//set th num equal to 1
					while(checkRow(row, num) == false || checkCol(col, num) == false || checkBox(row, col, num)==false)//while the num is invalid
					{num++;}//increment it until its valid
					matrix[row][col]=num;//place it in the matrix
					i = row; //reset i
					j = col; //reset j
				}

				else//if the value is valid
				{matrix[i][j] = num;}//place it in the matrix
			}
		}
	}
}
