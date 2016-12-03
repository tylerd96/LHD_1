
public enum spriteRdr {
	PACMAN(1,1),
	BLINKY(2,2),
	INKY(3,3),
	CLYDE(4,4),
	PINKY(5,5);
	
	final int size = 24;
	int x1,y1,x2,y2;
	
	spriteRdr(int x, int y) {
		setX1(x*size);
		setY1(y*size);
	}
	
	public int getX1() {return x1;}
	public void setX1(int x) {this.x1 = x;}
	public int getY1() {return y1;}
	public void setY1(int y) {this.y1 = y;}
}
