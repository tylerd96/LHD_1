import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class Character {
	
	public static int sw, sh;
	
	private int x,y,dx,dy;
	private final int size = 20;
	private BufferedImage image;
	
	public Character(int x, int y, BufferedImage image) {
		setX(x);
		setY(y);
		setImage(image);
	}
	
	public void move() {
		x+= dx;
		y+= dy;
		if(dx<0) {
			if(x+size < 0) 
				x = sw;
			if(x-size>sw)
				x += size;
		} else if(dx>0) {
			if(x>sw) 
				x = 0-size;
			if(x<0-size)
				x = sw+size;
			
		}
		
		if(dy>0) {
			if(y+size > sh) 
				y = 0-size;
			
		} else if(dy < 0) {
			if(y-size < 0) 
				y = sh+size;
			
		}
	}
	public void draw(Graphics g, Image img) {
		
	}
	
	//================================================ Getters / Setters
	public int getX() 					{return x;}
	public void setX(int x)				{this.x = x;}
	public int getY() 					{return y;}
	public void setY(int y) 			{this.y = y;}
	public int getDx() 					{return dx;}
	public void setDx(int dx) 			{this.dx = dx;}
	public int getDy() 					{return dy;}
	public void setDy(int dy) 			{this.dy = dy;}
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	
}
