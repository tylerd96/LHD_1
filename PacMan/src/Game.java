import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.Timer;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game  extends JPanel{
	
	ArrayList<Character> characters = new ArrayList<Character>();
	ArrayList<BufferedImage> sprites;
	Timer tmr;
	private JFrame window = new JFrame("Meme lord 5000");
	
	public Game() {
		window.setBounds(100,100,800,800 );
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(this);
		window.setVisible(true);
		window.setAlwaysOnTop(false);
		window.setResizable(false);
		loadLevel();
		this.setBackground(Color.BLACK);
		window.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) {
				int kc = e.getKeyCode();
				
				switch(kc) {
				case KeyEvent.VK_W: startMove(Direction.UP); 	repaint(); break;
				case KeyEvent.VK_A: startMove(Direction.LEFT); 	repaint(); break;
				case KeyEvent.VK_S: startMove(Direction.DOWN); 	repaint(); break;
				case KeyEvent.VK_D: startMove(Direction.RIGHT); repaint(); break;
				}
				
			}

			@Override
			public void keyReleased(KeyEvent e) {}
			
		});
		tmr = new Timer(5, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(Character c:characters) {
					c.move();
				}
				repaint();
			}
		});
		
		tmr.start();
		
	}
	public void startMove(Direction dir) {
		for(Character c : characters) {
			if(c instanceof Pacman) {
				c.setDx(dir.getDeltaCol());
				c.setDy(dir.getDeltaRow());
			}
		}
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for(Character c : characters) {
			c.move();
			c.draw(g, c.getImage());
		}
		
	}
	public void loadLevel() {
		loadImages();
//		for(int i = 0; i<2;i++) {
//			characters.add(new Pacman(i*20, i*20, sprites[i]));
//		}
		System.out.println("hi");
		characters.add(new Pacman(100,100,sprites.get(0)));
		//characters.add(new Pacman(0,0,sprites[(spriteRdr.PACMAN.row*(sprites.length/20)) + spriteRdr.PACMAN.col]));
	}
	public void loadImages() {
		try {
			BufferedImage bigImage = ImageIO.read(new File("spriteSheet.png"));
			final int size = 20;
			final int rows = 14;
			final int cols = 40;
			sprites = new ArrayList<BufferedImage>(Collections.nCopies(rows*cols, null));
			for(int i = 0; i<rows; i++) {
				for(int j = 0; j<cols; j++) {
					sprites.set((j*rows)+i, bigImage.getSubimage(j*size, i*size, size, size));
				}
				//System.out.println(i);
			}
			//sprites[0] = bigImage.getSubimage(0, 0, 20, 20);
			
		} catch (Exception e) {
			// TODO: handle exception
			//System.out.println("here");
			e.printStackTrace();
		}
		
	}
	public static void main(String args[]) {
		new Game();
	}
}
