import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
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
	
	public static void main() {
		new Game();
	}
}
