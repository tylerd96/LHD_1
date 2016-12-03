
public enum spriteRdr {
	PACMAN(1,1),
	BLINKY(1,5),
	INKY(9,7),
	CLYDE(11,5),
	PINKY(6,5);
	
	final int size = 20;
	int row, col;
	
	spriteRdr(int row, int col) {
		setRow(row);
		setCol(col);
	}
	
	
	public int getRow() {return row;}
	public void setRow(int row) {this.row = row;}
	public int getCol() {return col;}
	public void setCol(int col) {this.col = col;}

	
	
}
