
public class Board {
	//Contains a 2D array representing the board and the dimensions of the board
	String[][] board;
	int dimension;
	//initialises the board
	public Board(String [][] board, int dimension){
		this.board= board;
		this.dimension=dimension;
	}
/* 			For Extension only
 		Checks if the agent can move in certain directiond
	public boolean canModeup(){
		int[] agentLocation=getTileLoc("ag");
			if(!(agentLocation[0]==0)){
				if(this.getTile(agentLocation[0]-1, agentLocation[1])!="+"){
					return true;
				}
			}
			return false;
	}
	public boolean canModeDown(){
		int[] agentLocation=getTileLoc("ag");
		if(!(agentLocation[0]==dimension-1)){
			if(this.getTile(agentLocation[0]+1, agentLocation[1])!="+"){
				return true;
			}
		}
		return false;
	}
	public boolean canModeLeft(){
		int[] agentLocation=getTileLoc("ag");
		if(!(agentLocation[1]==0)){
			if(this.getTile(agentLocation[0], agentLocation[1]-1)!="+"){
				return true;
			}
		}
		return false;
	}
	public boolean canModeRight(){
		int[] agentLocation=getTileLoc("ag");
		if(!(agentLocation[1]==dimension-1)){
			if(this.getTile(agentLocation[0], agentLocation[1]+1)!="+"){
				return true;
			}
		}
		return false;
	}
*/
	//Methods to check if agent can move in certain directions
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
	//return an array with location of the tile
	int[] getTileLoc(String name){
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
	//peforms swap operation according to the direction received 
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
	//returns the current state of the board
	public String[][] getBoard(){
		String[][] temp= new String[dimension][dimension];
		for(int i=0;i<dimension;i++){
			for(int j=0;j<dimension;j++){
				temp[i][j]=board[i][j];
			}
		}
		return temp;
	}
	//Prints current State of the Board
	public void printBoard(){
		System.out.println("\n\n\t Printing Board\n");
		for(int i=0;i<dimension;i++){
			for(int j=0;j<dimension;j++){
				System.out.printf("|	%s	|",board[i][j]);
			}
			System.out.print("\n\n");
		}
	}
	//Returns dimension
	public int getDimension(){
		return dimension;
	}
	//Checks if current state of the board is the goal board
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
