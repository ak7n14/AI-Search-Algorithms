
public class Solver {
	public static void main(String[] args){
		//Defining The Board
		String[][] boardTiles = {	
									{" "," "," "," "},
									{" "," "," "," "},
									{" "," "," "," "},
									{"A","B","C","ag"}
									
								};
//Instantiating new Board and calling various searches
		Board board=new Board(boardTiles,4);
		Node node = new Node(board);
		node.printNode();
//		IterativeDeepningSearch ids=new IterativeDeepningSearch (node);
//		ids.ids();
		DepthFirstSearch dfs = new DepthFirstSearch(node);
		dfs.dfs();
//		BredthFirstSearch bfs = new BredthFirstSearch(node);
//		bfs.bfs();
//		AStar ast = new AStar(node);
//		ast.search();
	}
}

