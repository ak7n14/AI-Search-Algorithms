/*
 * Made by Anish Katariya
 */
import java.util.ArrayList;
public class Node implements Comparable<Node> {
	//Class with the current state of the board,the parent of the current node
	//and depth of the current node
	Node parent;
	Board nodeState;
	int depth;
	int tilesToGoal;
	//for initial node
	public Node(Board state){
		this.nodeState = state;
		this.parent=null;
		this.depth=0;
	}
	//for subsiquent nodes
	public Node(Board state,Node parent){
		this.nodeState=state;
		this.parent=parent;
		this.depth=parent.getDepth()+1;
	}

	//Checks if the agent can move in the directions if yes generating nodes by 
	//shifting the agent and returning them
	public ArrayList<Node>genChildren(){
		ArrayList<Node>children=new ArrayList<Node>();
		if(nodeState.canModeup()){
			Board tempBoard = new Board(nodeState.getBoard(),nodeState.getDimension());
			tempBoard.swap("up");
			children.add(new Node(tempBoard,this));
		}
		if(nodeState.canModeDown()){
			Board tempBoard = new Board(nodeState.getBoard(),nodeState.getDimension());
			tempBoard.swap("down");
			children.add(new Node(tempBoard,this));
		}
		if(nodeState.canModeLeft()){
			Board tempBoard = new Board(nodeState.getBoard(),nodeState.getDimension());
			tempBoard.swap("left");
			children.add(new Node(tempBoard,this));
		}
		if(nodeState.canModeRight()){
			Board tempBoard = new Board(nodeState.getBoard(),nodeState.getDimension());
			tempBoard.swap("right");
			children.add(new Node(tempBoard,this));
		}
		return children;
	}
	//Print the board state of the current node
	public void printNode(){
		nodeState.printBoard();
	}
	//method to get the parent Node
	public Node getParent(){
		return parent;
	}
	//Checks if the current node is the goal node
	public boolean goalNode(){
		return nodeState.isGoalNode();
	}
	//Returns the board
	public Board getBoard(){
		return nodeState;
	}
	//Interface for arraning the nodes according to priority in priority queue
	@Override
	public int compareTo(Node o) {
		int n=o.getPriority();
		int n1=this.getPriority();
		if(n1>n)
			return 1;
		if(n>n1)
			return -1;
		else
			return 0;
	}
	//returns depth of the node from rootNode
	public int getDepth(){
		return depth;
	}
	//Calculates distance of the tiles from their goal location
	public int tilesToGoal(){
		int dimension = nodeState.getDimension();
		int[] A = nodeState.getTileLoc("A");
		int[] B = nodeState.getTileLoc("B");
		int[] C = nodeState.getTileLoc("C");
		int Ax = Math.abs(dimension -1 - A[0]);
		int Bx = Math.abs(dimension -2 - B[0]);
		int Cx = Math.abs(dimension -3 - C[0]);
		int Ay = Math.abs(1-A[1]);
		int By = Math.abs(1-B[1]);
		int Cy = Math.abs(1-C[1]);
		return (Ax+Ay+Bx+By+Cx+Cy);		
	}
	//returns priority of current tile
	public int getPriority(){
		return (this.tilesToGoal() + depth);
		
	}
}
