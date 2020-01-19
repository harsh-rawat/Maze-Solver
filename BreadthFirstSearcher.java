import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Breadth-First Search (BFS)
 * 
 * You should fill the search() method of this class.
 */
public class BreadthFirstSearcher extends Searcher {

	/**
	 * Calls the parent class constructor.
	 * 
	 * @see Searcher
	 * @param maze initial maze.
	 */
	public BreadthFirstSearcher(Maze maze) {
		super(maze);
	}

	/**
	 * Main breadth first search algorithm.
	 * 
	 * @return true if the search finds a solution, false otherwise.
	 */
	public boolean search() {

		// explored list is a 2D Boolean array that indicates if a state associated with a given position in the maze has already been explored.
		boolean[][] explored = new boolean[maze.getNoOfRows()][maze.getNoOfCols()];
		
		for(int r = 0; r < explored.length; r++)
			for(int c = 0; c< explored[0].length; c++)
				explored[r][c] = false;
		
		// Queue implementing the Frontier list
		LinkedList<State> queue = new LinkedList<State>();
		
		State curState = new State(maze.getPlayerSquare(),null,0,0);
		queue.add(curState);
		
		while (!queue.isEmpty()) {
			
			if(queue.size() > maxSizeOfFrontier) maxSizeOfFrontier = queue.size();
			
			curState = queue.pop();
			explored[curState.getX()][curState.getY()] = true;
			
			maxDepthSearched = curState.getDepth() > maxDepthSearched ? curState.getDepth() : maxDepthSearched;
			noOfNodesExpanded++;
			cost = curState.getGValue();
			
			if(curState.isGoal(maze)) {
				
				while(curState.getParent() != null) {
					if(maze.getMazeMatrix()[curState.getX()][curState.getY()] == ' ')
						maze.setOneSquare(curState.getSquare(), '.');
					curState = curState.getParent();
				}
				
				return true;
			}
			
			ArrayList<State> next = curState.getSuccessors(explored, maze);
			
			for(State state : next)
				if(!queue.contains(state)) queue.add(state);

		}

		return false;
	}
}
