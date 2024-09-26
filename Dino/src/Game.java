import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.Font;
import java.util.Random;

public class Game extends JPanel {
	private Dino dino;
	private Tree tree;
	private Image imgbuf=null;
	private Graphics buf=null;
	private static Toolkit tk=Toolkit.getDefaultToolkit();
	private boolean jump=false;
	private boolean ex=true;
	private boolean play=true,start;
	private int gravity=2;
	private int bg1X,bg2X,sc,n;
	private double score;
	
	
	public Game() {
		mkey listener=new mkey();
		addKeyListener(listener);
		setFocusable(true);
		play=false;
		start=false;
		new Thread(new PaintThread()).start();
		Init();
	}
	public void Init() {
		bg1X=0;
		bg2X=800;
		sc=0;
		n=0;
		tree=new Tree(830);
		score=0;
		dino=new Dino(40,240);
		play=true;
		start=false;
	}
	public void paint(Graphics g) {
		imgbuf=createImage(this.getWidth(),this.getHeight());
		buf=imgbuf.getGraphics();
		Draw(buf);
		update(g);
	}
	public void update(Graphics g) {
		g.drawImage(imgbuf, 0, 0, this);
	}
	void Draw(Graphics g) {
		g.drawImage(tk.getImage("bg1.png"), bg1X, 0, 800, 300, null);
		g.drawImage(tk.getImage("bg2.png"), bg2X, 0, 800, 300, null);
		dino.Draw(g);
		tree.Draw(g, n);
		g.setColor(Color.black);
		g.setFont(new Font("serif",Font.BOLD,35));
		g.drawString(""+String.format("%.0f", score), 640, 30);
		if(!start) {
			g.setColor(Color.black);
			g.setFont(new Font("serif",Font.BOLD,40));
			g.drawString("Press 'S' to Start", 230, 150);
		}
	}
	class mkey implements KeyListener{
		public void keyPressed(KeyEvent e) {
			int key1=e.getKeyCode();
			switch(key1) {
			case KeyEvent.VK_S:
				sc=2;
				start=true;
				break;
			case KeyEvent.VK_SPACE:
				if(!jump) {
					jump=true;
				}
				break;
			}
		}
		public void keyReleased(KeyEvent e) {
			
		}
		public void keyTyped(KeyEvent arg0) {
			
		}
	}
	private void moveUp() {
		if(jump) {
			dino.dinoY-=gravity;
			if(dino.dinoY<=120) {
				gravity=-gravity;
			}
			if(dino.dinoY>240) {
				dino.dinoY=240;
				jump=false;
				gravity=2;
			}
		}
	}
	private class PaintThread implements Runnable{
		public void run() {
			while(ex) {
				while(play) {
					moveUp();
					if(bg1X<-780) bg1X=800;
					else bg1X-=sc;
					if(bg2X<-780) bg2X=800;
					else bg2X-=sc;
					if(tree.treeX<0) {
						tree.treeX=830;
						Random rn=new Random();
						n=rn.nextInt(3);
					}
					else tree.treeX-=sc;
					if(dino.getRect().intersects(tree.getRect())) {
						Init();
					}
					repaint();
					
					try {
						Thread.sleep(4);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
					if(start) score+=0.01;
				}
			}
		}
	}


}
