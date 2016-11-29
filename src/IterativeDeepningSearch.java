/*
 * Made by Anish Katariya
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class IterativeDeepningSearch {
	//Defines arrayLists for the visited and expanded nodes
	//and stack for the fringe
	// boolean value to keep track of the solution
	private ArrayList<Node> expandedNodes;
	private ArrayList<Node> visitedNodes;
	private Stack<Node> toVisit;
	private Node rootNode;
	int depth;
	Node finalNode;
	boolean foundGoalState;
	
	public IterativeDeepningSearch(Node node){
		this.rootNode=node;
		this.expandedNodes = new ArrayList<Node>();
		this.visitedNodes = new ArrayList<Node>();
		this.toVisit = new Stack<Node>();
		depth=-1;
		foundGoalState=false;
	}
//Repeatedly calls the search method increasing the depth everytime till solution is found
	public void ids(){
		while(!foundGoalState){
			depth+=1;
			this.run(depth);
		}
	}
	
	//Running the search
	public boolean run(int limit){
		int d=0;
		toVisit.add(rootNode);
		expandedNodes.add(rootNode);
		//checking if fringe is empty
		while(!toVisit.isEmpty()){
			
			Node currentNode = toVisit.pop();
			visitedNodes.add(currentNode);
			currentNode.printNode();
			//If goal state indicating to ids methode that solution has been found and printing out values
			if(currentNode.goalNode()){
				foundGoalState=true;
				currentNode=finalNode;
				System.out.printf("No of nodes expanded = %d , number of nodes Visited =%d",expandedNodes.size(),visitedNodes.size());
				return true;
			}
			//only adding the children to the fringe if the depth is lower than the limit
			else if(d<limit){
				ArrayList<Node> children = new ArrayList<Node>();
				children = currentNode.genChildren();
				addExpanded(children);
				Collections.shuffle(children);
				toVisit.addAll(children);
				d++;
			}
			
		}
	return false;
	}
	//Adding nodes to the Expanded nodes arraylist
	public void addExpanded(ArrayList<Node>children){
		for(int i =0;i<children.size();i++){
			expandedNodes.add(children.get(i));
		}
		
	}
	//method to print solution once found
	public void produceSolution(){
		System.out.println("\n\n=====Printing solution======");
		
		Stack<Node>solution = new Stack<Node>();
		while(finalNode!=null){
			solution.add(finalNode);
			Node temp=finalNode;
			finalNode = temp.getParent();
		}
		for(int i=0;i<solution.size();i++){
			Node temp = solution.pop();
			temp.printNode();
		}
	}
}
