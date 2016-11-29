/*
 * Made by Anish Katariya
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BredthFirstSearch {
	//Defines arrayLists for the visited and expanded nodes
		//and queue for the fringe
	private ArrayList<Node> expandedNodes;
	private ArrayList<Node> visitedNodes;
	private Queue<Node>toVisit;
	private Node rootNode;
	Node finalNode;
	//Initialising everything and adding rootNode to ExpandedNodes and fringe
	public BredthFirstSearch(Node node){
		this.rootNode=node;
		this.expandedNodes = new ArrayList<Node>();
		this.visitedNodes = new ArrayList<Node>();
		this.toVisit = new LinkedList<Node>();
		toVisit.add(rootNode);
		expandedNodes.add(rootNode);
		
	}
	public boolean bfs(){
		//Checks That the fringe is not empty and performs the search
		while(!toVisit.isEmpty()){
			Node currentNode = toVisit.remove();
			currentNode.printNode();
			visitedNodes.add(currentNode);
			//Printing out details if its the goal state
			if(currentNode.goalNode()){
				currentNode.printNode();
				finalNode = currentNode;
				System.out.printf("Nodes expanded = %d nodes Visited = %d",expandedNodes.size(),visitedNodes.size());
				return true;
			}
			//Expanding node and adding the children to the queue
			else{
				ArrayList<Node>children;
				children = currentNode.genChildren();
				Collections.shuffle(children);
				expandedNodes.addAll(children);
				toVisit.addAll(children);
			}
		}			
		return false;
	}
	
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
