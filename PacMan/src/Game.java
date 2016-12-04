import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game  extends JPanel{
	
	protected static ArrayList<Character> characters = new ArrayList<Character>();
	ArrayList<BufferedImage> sprites;
	Timer tmr;
	protected static boolean gameover = false;
	protected static ArrayList<MapBlock> walls = new ArrayList<MapBlock>();
	private boolean load = true;
	private JFrame window = new JFrame("Meme lord 5000");
	private int[][] grid;
	static int size = 40;
	static int cols = 16; // 32 squares /2
	static int rows = 10; // 20 squares /2
	
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
				case KeyEvent.VK_UP: startMove(Direction.UP); 		repaint(); break;
				case KeyEvent.VK_LEFT: startMove(Direction.LEFT); 	repaint(); break;
				case KeyEvent.VK_DOWN: startMove(Direction.DOWN); 	repaint(); break;
				case KeyEvent.VK_RIGHT: startMove(Direction.RIGHT); repaint(); break;
				}
				
			}

			@Override
			public void keyReleased(KeyEvent e) {}
			
		});
		tmr = new Timer(10, new ActionListener() {
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
		if(gameover) {
			System.exit(ABORT);
			throw new IllegalArgumentException();
		}
		for(MapBlock mb : walls) {
			mb.draw(g);
		}
		for(Character c : characters) {
			c.move();
			c.draw(g);
		}
		
	}
	public void loadLevel() {
		loadImages();
		loadMap();
//		for(int i = 0; i<2;i++) {
//			characters.add(new Pacman(i*20, i*20, sprites[i]));
//		}
		//walls.add(new MapBlock(0,0, false, sprites.get(0)));
		//System.out.println("hi");
//		int j = 0;
//		for(int i = 0; i<sprites.size(); i++) {
//			
//			characters.add(new Pacman(j*20, 0, sprites.get(i)));
//			j++;
//		}
		//characters.add(new Pacman(100,100,sprites.get(30)));
		//characters.add(new Pacman(0,0,sprites[(spriteRdr.PACMAN.row*(sprites.length/20)) + spriteRdr.PACMAN.col]));
	}
	public void loadImages() {
		try {
			BufferedImage bigImage = ImageIO.read(new File("sprites.png"));
//			final int size = 20;
//			final int rows = 14;
//			final int cols = 40;
			sprites = new ArrayList<BufferedImage>(Collections.nCopies(rows*cols, null));
			for(int i = 0; i<rows; i++) {
				for(int j = 0; j<cols; j++) {
					sprites.set((i*rows)+j, bigImage.getSubimage(j*size, i*size, size, size));
					//System.out.println(j);
				}
				//System.out.println(i);
			}
			//sprites.set(400, bigImage.getSubimage(400, 0, size, size));
			//sprites[0] = bigImage.getSubimage(0, 0, 20, 20);
			
		} catch (Exception e) {
			// TODO: handle exception
			//System.out.println("here");
			e.printStackTrace();
		}
		
	}
	public void loadMap() {
		// col22 row 13
		System.out.println(sprites.size());
		BufferedImage img;
		BufferedImage norm;
		grid = new int[20][20];
		try {
			img = ImageIO.read(new File("tmpWall.png"));
			norm = ImageIO.read(new File("krumpe.jpg"));
			Scanner in = new Scanner(new File("grid.txt"));
			for(int i = 0; i<grid.length; i++) {
				for(int j = 0; j<grid[i].length; j++) {
					grid[i][j] = in.nextInt();
					//System.out.println(grid[i][j]);
					switch(grid[i][j]) {
					case 0: walls.add(new MapBlock(j*40,i*40,false,img)); break;
					case 1: break;
					case 2: characters.add(new Pacman(j*40,i*40,sprites.get(30))); break;
					case 3: walls.add(new MapBlock(j*40, i*40,false,norm)); break;
					case 4: characters.add(new Ghost(j*40,i*40,sprites.get(60),true)); break;
					case 5: characters.add(new Ghost(j*40,i*40,sprites.get(89),true)); break;
					case 6: characters.add(new Ghost(j*40,i*40,sprites.get(80),true)); break;
					case 7: characters.add(new Ghost(j*40,i*40,sprites.get(93),true)); break;
					}
				}
				for(int j = 0; j<20;j++) {
					System.out.print(grid[i][j]);
				}
				System.out.println();
			}
			
//			walls.add(new MapBlock(200,200, false, img));
//			walls.add(new MapBlock(240,200,false, img));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public int getIndex(int row, int col) {
		return (row*40)+col;
	}
	public static void main(String args[]) {
		new Game();
	}
}
