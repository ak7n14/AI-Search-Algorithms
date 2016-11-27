
public class Solver {
	public static void main(String[] args){
		String[][] boardTiles = {{" "," "," "," "},
				            {" "," "," "," "},
				            {" "," "," "," "},
				            {"A","B","C","ag"}};

		Board board=new Board(boardTiles,4);
		Node node = new Node(board);
		IterativeDeepningSearch dfs=new IterativeDeepningSearch (node);
		dfs.ids();
		
	}
}

