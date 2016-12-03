import java.awt.Color;
import java.awt.image.BufferedImage;

public class Ghost extends Character {
	
	private boolean killable;
	
	public Ghost(int x, int y, BufferedImage image, boolean canKill) {
		super(x, y, image);
		setKillable(canKill);
		// TODO Auto-generated constructor stub
	}

	
	
	public boolean isKillable() 				{return killable;}
	public void setKillable(boolean killable) 	{this.killable = killable;}
	
}
