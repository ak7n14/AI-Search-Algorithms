/*
 * Made by Anish Katariya
 */
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
//Defines arrayLists for the visited and expanded nodes
//and priority queue for the fringe
public class AStar {
	
	ArrayList<Node>expandedNodes;
	ArrayList<Node> visitedNodes;
	Set<Board> visited;
	Node rootNode;
	Queue<Node> toVisit;
	Node finalNode;
	//adding rootNode to the expandedNodes arraylist and to the priority queue
	public AStar(Node node){
		rootNode = node;
		expandedNodes = new ArrayList<Node>();
		visitedNodes = new ArrayList<Node>();
		visited = new HashSet<Board>();
		toVisit = new PriorityQueue<Node>();
		toVisit.add(rootNode);
		expandedNodes.add(rootNode);
	}
	
	
	public boolean search(){
		while(!toVisit.isEmpty()){
			//poping nodes accoring to priority
			Node currentNode = toVisit.poll();
			currentNode.printNode();
			visitedNodes.add(currentNode);
			//if goal node printing ot the details
			if(currentNode.goalNode()){
				System.out.printf("Nodes expanded = %d nodes Visited = %d",expandedNodes.size(),visitedNodes.size());
				currentNode = finalNode;
				return true;
			}
			//adding children to the priority queue
			else{
				ArrayList<Node>children = currentNode.genChildren();
				expandedNodes.addAll(children);
				this.addChildren(children);
			}
			
		}
		return false;
	}
	
	
	//adding children to the queue according to the priority
	public void addChildren(ArrayList<Node>children){
		for(int i=0;i<children.size();i++){
			Node node = children.get(i);
			toVisit.add(node);
		}
	}
	//prints solution
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
