/**
 * controls and connects the model and view
 * @author Aaron Serpa
 */
public class controller 
{
	
	private gameView view; //the view of the game
	private model model; //the model of thhe game
	
	/**
	 * constructs a new controller
	 * @param view the view of the game
	 * @param modelthe model of thhe game
	 */
	public controller(gameView view, model model)
	{
		this.view = view;
		this.model = model;
		model.populate();//populate the view
		putInView(); // put the values from the model into the view
		view.AddActionisteners(model.getMatrix());//set listeners for view buttons
	}
	
	/**
	 *  put the values from the model into the view
	 */
	public void putInView()
	{
		boolean easy = model.getDifficulty();
		int[][]board = model.getMatrix();
		view.populateView(board, easy);//put a random assortment of elements into the view depending on difficulty
	}	
}