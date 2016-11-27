import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class IterativeDeepningSearch {
	private ArrayList<Node> expandedNodes;
	private ArrayList<Node> visitedNodes;
	private Stack<Node> toVisit;
	private Node rootNode;
	int depth;
	boolean foundGoalState;
	
	public IterativeDeepningSearch(Node node){
		this.rootNode=node;
		this.expandedNodes = new ArrayList<Node>();
		this.visitedNodes = new ArrayList<Node>();
		this.toVisit = new Stack<Node>();
		depth=-1;
		foundGoalState=false;
	}

	public void ids(){
		while(!foundGoalState){
			depth+=1;
			this.run(depth);
		}
	}
	
	
	public boolean run(int limit){
		int d=0;
		toVisit.add(rootNode);
		expandedNodes.add(rootNode);
		while(!toVisit.isEmpty()){
			
			Node currentNode = toVisit.pop();
			visitedNodes.add(currentNode);
			currentNode.printNode();
			if(currentNode.goalNode()){
				foundGoalState=true;
				System.out.printf("No of nodes expanded = %d , number of nodes Visited =%d",expandedNodes.size(),visitedNodes.size());
				return true;
			}
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
	public void addExpanded(ArrayList<Node>children){
		for(int i =0;i<children.size();i++){
			expandedNodes.add(children.get(i));
		}
	}
}
