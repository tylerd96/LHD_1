import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

public class Character {
	
	private int x,y,dx,dy;
	private final int SIZE = 24;
	private Color color;
	private Image image;
	
	public Character(int x, int y, Color color, String image) {
		setX(x);
		setY(y);
		setColor(color);
		setImage(image);
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
	public Color getColor() 			{return color;}
	public void setColor(Color color) 	{this.color = color;}
	public void setImage(String imageFile) {
		image = Toolkit.getDefaultToolkit().getImage("GameImages/" + imageFile);
	}
	
	
}
