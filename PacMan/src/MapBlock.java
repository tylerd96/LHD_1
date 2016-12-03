import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class MapBlock extends Rectangle{
	public static int sw=800,sh=800;
	private boolean moveable;
	BufferedImage img;
	
	public MapBlock(int x, int y, boolean moveable, BufferedImage img) {
		super(x,y,40,40);
		setMoveable(moveable);
		setImg(img);
	}
	
	public void draw(Graphics g) {
		g.drawImage(img, x, y, 40, 40, null);
	}
	
	
	
	
	public boolean isMoveable() {return moveable;}
	public void setMoveable(boolean moveable) {this.moveable = moveable;}
	public double getX() {return x;}
	public void setX(int x) {this.x = x;}
	public double getY() {return y;}
	public void setY(int y) {this.y = y;}
	public BufferedImage getImg() {return img;}
	public void setImg(BufferedImage img) {this.img = img;}
	
}
