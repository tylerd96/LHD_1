import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game  extends JPanel{
	
	ArrayList<Character> characters = new ArrayList<Character>();
	private JFrame window = new JFrame("Meme lord 5000");
	
	
	public Game() {
		
		
		
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}
	public void loadLevel() {
		characters.add(new Pacman(0,0,Color.YELLOW, "THE DONG.jpg"));
	}
	public void loadImages() {
		try {
			BufferedImage bigImage = ImageIO.read(new File("pacsprites.png"));
			final int size = 24;
			final int rows = 16;
			final int cols = 21;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	public static void main() {
		new Game();
	}
}
