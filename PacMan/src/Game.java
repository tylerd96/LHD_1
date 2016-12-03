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
	BufferedImage[] sprites;
	
	
	public Game() {
		
		
		
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}
	public void loadLevel() {
		characters.add(new Pacman(0,0,sprites[(spriteRdr.PACMAN.row*sprites.length) + spriteRdr.PACMAN.col]));
	}
	public void loadImages() {
		try {
			BufferedImage bigImage = ImageIO.read(new File("pacsprites.png"));
			final int size = 20;
			final int rows = 16;
			final int cols = 21;
			sprites = new BufferedImage[rows*cols];
			for(int i = 0; i<rows; i++) {
				for(int j = 0; j<cols; j++) {
					sprites[(i*cols)+j] = bigImage.getSubimage(j*size, i*size, size, size);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	public static void main() {
		new Game();
	}
}
