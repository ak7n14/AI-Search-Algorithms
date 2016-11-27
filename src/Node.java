import java.util.ArrayList;
public class Node {
	Node parent;
	Board nodeState;
	
	public Node(Board state){
		this.nodeState = state;
		this.parent=null;
	}
	
	public Node(Board state,Node parent){
		this.nodeState=state;
		this.parent=parent;
	}
	
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
	
	public void printNode(){
		nodeState.printBoard();
	}
	public Node getParent(){
		return parent;
	}
	
	public boolean goalNode(){
		return nodeState.isGoalNode();
	}
	public Board getBoard(){
		return nodeState;
	}
}
