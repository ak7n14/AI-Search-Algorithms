
public class Board {
	String[][] board;
	int dimension;
	
	public Board(String [][] board, int dimension){
		this.board= board;
		this.dimension=dimension;
	}
	
	public boolean canModeup(){
		int[] agentLocation=getTileLoc("ag");
		return (!(agentLocation[0]==0));
	}
	public boolean canModeDown(){
		int[] agentLocation=getTileLoc("ag");
		return (!(agentLocation[0]==dimension-1));
	}
	public boolean canModeLeft(){
		int[] agentLocation=getTileLoc("ag");
		return (!(agentLocation[1]==0));
	}
	public boolean canModeRight(){
		int[] agentLocation=getTileLoc("ag");
		return (!(agentLocation[1]==dimension-1));
	}
	
	public String getTile(int x,int y){
		return board[x][y];
	}
	
	public int[] getTileLoc(String name){
		int loc[] = new int[2];
		for(int i=0;i<dimension;i++){
			for(int j=0;j<dimension;j++){
				if (board[i][j]==name){
					loc[0]=i;
					loc[1]=j;
					return loc;
				}
			}
		}
		System.err.print("Tile not found\n");
		return null;
	}
	
	public void swap(String operation){
		if(operation == "up"){
			int[] agentLocation = getTileLoc("ag");
			String temp = board[agentLocation[0]-1][agentLocation[1]];
			board[agentLocation[0]-1][agentLocation[1]] = "ag";
			board[agentLocation[0]][agentLocation[1]]=temp;
			
		}
		if(operation == "down"){
			int[] agentLocation = getTileLoc("ag");
			String temp = board[agentLocation[0]+1][agentLocation[1]];
			board[agentLocation[0]+1][agentLocation[1]] = "ag";
			board[agentLocation[0]][agentLocation[1]]=temp;
			
		}
		if(operation == "left"){
			int[] agentLocation = getTileLoc("ag");
			String temp = board[agentLocation[0]][agentLocation[1]-1];
			board[agentLocation[0]][agentLocation[1]-1] = "ag";
			board[agentLocation[0]][agentLocation[1]]=temp;
			
		}
		if(operation == "right"){
			int[] agentLocation = getTileLoc("ag");
			String temp =board[agentLocation[0]][agentLocation[1]+1];
			board[agentLocation[0]][agentLocation[1]+1] = "ag";
			board[agentLocation[0]][agentLocation[1]]=temp;
			
		}
	}
	
	public String[][] getBoard(){
		String[][] temp= new String[dimension][dimension];
		for(int i=0;i<dimension;i++){
			for(int j=0;j<dimension;j++){
				temp[i][j]=board[i][j];
			}
		}
		return temp;
	}
	
	public void printBoard(){
		System.out.println("\n\n\t Printing Board\n");
		for(int i=0;i<dimension;i++){
			for(int j=0;j<dimension;j++){
				System.out.printf("|	%s	|",board[i][j]);
			}
			System.out.print("\n\n");
		}
	}
	
	public int getDimension(){
		return dimension;
	}
	public boolean isGoalNode(){
		if(this.getTile(this.getDimension()-1, 1)=="A"
			    && this.getTile(this.getDimension()-2, 1)=="B"
			    && this.getTile(this.getDimension()-3, 1)=="C"){
				return true;
			}
			else {
				return false;
			}
		}
}
