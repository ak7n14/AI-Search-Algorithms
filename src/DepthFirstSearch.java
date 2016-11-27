import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class DepthFirstSearch {
	private ArrayList<Node> expandedNodes;
	private ArrayList<Node> visitedNodes;
	private Stack<Node> toVisit;
	private Node rootNode;
	int depth;
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
		while(!toVisit.isEmpty()){
			Node currentNode = toVisit.pop();
			visitedNodes.add(currentNode);
			currentNode.printNode();
			if(currentNode.goalNode()){
				System.out.printf("No of nodes expanded = %d , number of nodes Visited =%d",expandedNodes.size(),visitedNodes.size());
				return true;
			}
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
	
	public void addExpanded(ArrayList<Node>children){
		for(int i =0;i<children.size();i++){
			expandedNodes.add(children.get(i));
		}
	}
	
}

