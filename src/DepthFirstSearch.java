/*
 * Made by Anish Katariya
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class DepthFirstSearch {
	//Defines arrayLists for the visited and expanded nodes
			//and stack for the fringe
	private ArrayList<Node> expandedNodes;
	private ArrayList<Node> visitedNodes;
	private Stack<Node> toVisit;
	private Node rootNode;
	int depth;
	Node finalNode;
	//Initialising everything and adding rootNode to ExpandedNodes and fringe
	public DepthFirstSearch(Node node){
		this.rootNode=node;
		this.expandedNodes = new ArrayList<Node>();
		this.visitedNodes = new ArrayList<Node>();
		this.toVisit = new Stack<Node>();
		toVisit.add(rootNode);
		expandedNodes.add(rootNode);
		depth=0;
	}

	public boolean dfs(){
		//Checks That the fringe is not empty and performs the search
		while(!toVisit.isEmpty()){
			Node currentNode = toVisit.pop();
			visitedNodes.add(currentNode);
			currentNode.printNode();
			if(currentNode.goalNode()){
				System.out.printf("No of nodes expanded = %d , number of nodes Visited =%d",expandedNodes.size(),visitedNodes.size());
				finalNode = currentNode;
				return true;
			}
			//generating children and adding them to the fringe
			else{
				
				ArrayList<Node> children = new ArrayList<Node>();
				children = currentNode.genChildren();
				addExpanded(children);
				Collections.shuffle(children);
				toVisit.addAll(children);
				depth++;
			}
			
		}
	return false;
	}
	//method to add all children to expandedNodes arraylist
	public void addExpanded(ArrayList<Node>children){
		for(int i =0;i<children.size();i++){
			expandedNodes.add(children.get(i));
		}
	}
	//methode to print out solution once found
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

