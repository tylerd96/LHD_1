import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Ghost extends Character {
	
	private boolean killable;
	
	public Ghost(int x, int y, BufferedImage image, boolean canKill) {
		super(x, y, image);
		setKillable(canKill);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void move() {
		ArrayList<MapBlock> blocks = Game.walls;
		ArrayList<Character> characters = Game.characters;
		x+= dx;
		y+= dy;
		for(MapBlock mb : blocks) {
			if(this.intersects(mb) && !mb.isMoveable()) {
				x+=-dx;
				y+=-dy;
			}
		}
		for(Character c : characters) {
			if(c != this) {
				if(this.intersects(c) && c instanceof Pacman) {
					Game.gameover = true;
				}
			}
		}
		if(dx<0) {
			if(x <0-size) 
				x = sw+size;
		} else if(dx>0) {
			if(x>sw) 
				x=0-size;
			
		}
		
		if(dy>0) {
			if(y+size > sh) 
				y = 0-size;
			
		} else if(dy < 0) {
			if(y+size < 0) 
				y = sh+size;
			
		}
	}
	
	
	public boolean isKillable() 				{return killable;}
	public void setKillable(boolean killable) 	{this.killable = killable;}
	
}
