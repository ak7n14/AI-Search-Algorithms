import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BredthFirstSearch {
	
	private ArrayList<Node> expandedNodes;
	private ArrayList<Node> visitedNodes;
	private Queue<Node>toVisit;
	private Node rootNode;
	
	public BredthFirstSearch(Node node){
		this.rootNode=node;
		this.expandedNodes = new ArrayList<Node>();
		this.visitedNodes = new ArrayList<Node>();
		this.toVisit = new LinkedList<Node>();
		toVisit.add(rootNode);
		expandedNodes.add(rootNode);
		
	}
	public boolean bfs(){
		
		while(!toVisit.isEmpty()){
			Node currentNode = toVisit.remove();
			currentNode.printNode();
			visitedNodes.add(currentNode);
			if(currentNode.goalNode()){
				System.out.printf("Nodes expanded = %d nodes Visited = %d",expandedNodes.size(),visitedNodes.size());
				return true;
			}
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
	
	public void addChildren(ArrayList<Node> children){
		for (int i = 0;i<children.size();i++){
			toVisit.offer(children.get(i));
		}
	}
	
	public void addExpanded(ArrayList<Node>children){
		for(int i =0;i<children.size();i++){
			expandedNodes.add(children.get(i));
		}
	}
	
	public void produceSolution(Node currentNode){
		System.out.println("Printing solution");
		
		Stack<Node>solution = new Stack<Node>();
		while(currentNode!=null){
			solution.add(currentNode);
			Node temp=currentNode;
			currentNode = temp.getParent();
		}
		for(int i=0;i<solution.size();i++){
			Node temp = solution.pop();
			temp.printNode();
		}
	}
}
