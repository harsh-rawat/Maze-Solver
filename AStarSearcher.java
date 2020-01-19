import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * A* algorithm search
 * 
 * You should fill the search() method of this class.
 */
public class AStarSearcher extends Searcher {

	/**
	 * Calls the parent class constructor.
	 * 
	 * @see Searcher
	 * @param maze initial maze.
	 */
	public AStarSearcher(Maze maze) {
		super(maze);
	}

	/**
	 * Main a-star search algorithm.
	 * 
	 * @return true if the search finds a solution, false otherwise.
	 */
	public boolean search() {

		// explored list is a Boolean array that indicates if a state associated with a given position in the maze has already been explored. 
		boolean[][] explored = new boolean[maze.getNoOfRows()][maze.getNoOfCols()];
		for(int r = 0; r < explored.length; r++)
			for(int c = 0; c< explored[0].length; c++)
				explored[r][c] = false;
		
		PriorityQueue<StateFValuePair> frontier = new PriorityQueue<StateFValuePair>();

		State curState = new State(maze.getPlayerSquare(),null,0,0);
		StateFValuePair statefvaluepair = new StateFValuePair(curState, curState.getGValue()+getEuclideanDistance(curState.getSquare(), maze.getGoalSquare()));
		frontier.add(statefvaluepair);

		while (!frontier.isEmpty()) {
			
			if(frontier.size() > maxSizeOfFrontier) maxSizeOfFrontier = frontier.size();
			
			statefvaluepair = frontier.poll();
			explored[statefvaluepair.getState().getX()][statefvaluepair.getState().getY()] = true;
			
			maxDepthSearched = statefvaluepair.getState().getDepth() > maxDepthSearched ? statefvaluepair.getState().getDepth() : maxDepthSearched;
			noOfNodesExpanded++;
			cost = statefvaluepair.getState().getGValue();
			
			if(statefvaluepair.getState().isGoal(maze)) {
				State s = statefvaluepair.getState();
				while(s.getParent() != null) {
					if(maze.getMazeMatrix()[s.getX()][s.getY()] == ' ')
						maze.setOneSquare(s.getSquare(), '.');
					s = s.getParent();
				}
				
				return true;
			}
			
			ArrayList<State> next = statefvaluepair.getState().getSuccessors(explored, maze);
			
			for(State state : next) {
				statefvaluepair = new StateFValuePair(state, state.getGValue()+getEuclideanDistance(state.getSquare(), maze.getGoalSquare()));
				if(!frontier.contains(statefvaluepair)) frontier.add(statefvaluepair);
			}
		}

		return false;

	}
	
	private double getEuclideanDistance(Square s1, Square s2) {
		return Math.sqrt(Math.pow(s1.X - s2.X,2) + Math.pow(s1.Y - s2.Y,2));
	}

}
