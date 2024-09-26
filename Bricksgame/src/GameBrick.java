import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameBrick extends JPanel {
	private Image imgbuf=null;
	private Graphics buf=null;
	private int ballXdir;
	private int ballYdir;
	private boolean play=true;
	private Ball ball;
	private Bar bar;
	private MapLoad map;
	private int KK;
	private int score;
	private int level=1;
	private boolean start;
	private String key="";
	private boolean press=false;
	private BSound bgm=new BSound();
	private static Toolkit tk=Toolkit.getDefaultToolkit();
	private int life=2;
		 
	public GameBrick() {
		mkey listener=new mkey();
		addKeyListener(listener);
		setFocusable(true);
		map=new MapLoad(20,20);
		score=0;
		Init();

	}
	void Init() {
		bgm.play("GameStart.wav", false);
		Default.wall.clear();
		ball=new Ball(400,350);
		bar=new Bar(350);
		start=false;
		ballXdir=0;
		ballYdir=0;
		play=true;
		if(level==1) map.pan1();
		else map.pan2();
		new Thread(new PaintThread()).start();
	}
	public void paint(Graphics g) {
		imgbuf=createImage(this.getWidth(),this.getHeight());
		buf=imgbuf.getGraphics();
		DrawBrick(buf);
		update(g);
	}
	public void update(Graphics g) {
		g.drawImage(imgbuf,0, 0, this);
	}
	void DrawBrick(Graphics g) {
		g.drawImage(tk.getImage("bg.jpg"),0,0,800,800,null);
		bar.draw(g);
		ball.draw(g);
		g.setColor(Color.yellow);
		g.setFont(new Font("serif",Font.BOLD,35));
		g.drawString(""+score, 740, 30); 
		
		for(int i=0;i<Default.wall.size();i++) {
			if(Default.wall.get(2).equals(1)) {
				Wall w=Default.wall.get(i);
				w.draw(g);
			}
			else if(Default.wall.get(2).equals(2)) {
			for(int j=0;j<Default.wall.size();j++) {
				Wall w2=Default.wall.get(j);
				w2.draw2(g);
			}
			}
		}
		
		if(Default.wall.isEmpty()) {
			bgm.play("Mission_Success.wav", false);
			play=false;
			ballXdir=0;
			ballYdir=0;
			g.setColor(Color.red);
			g.setFont(new Font("serif",Font.BOLD,50));
			g.drawString("YOU WIN!!! Score : "+score, 170, 300);
			g.setColor(Color.blue);
			g.setFont(new Font("serif",Font.BOLD,40));
			g.drawString("Press Enter to Restart", 230, 350);
			level++;
		}
		if(ball.ballposY>780) {
			bgm.play("bg3.wav", false);
			play=false;
			ballXdir=0;
			ballYdir=0;
			score=0;
			level=1;
			g.setColor(Color.red);
			g.setFont(new Font("serif",Font.BOLD,50));
			g.drawString("Game Over Score : "+score, 190, 300);
			g.setColor(Color.blue);
			g.setFont(new Font("serif",Font.BOLD,40));
			g.drawString("Press Enter to Restart", 230, 350);
		}
		if(!start) {
			g.setColor(Color.yellow);
			g.setFont(new Font("serif",Font.BOLD,40));
			g.drawString("Press 'S' to Start", 300, 450);
		}
	}
	class mkey implements KeyListener{
		public void keyPressed(KeyEvent e) {
			int key1=e.getKeyCode();
					switch(key1)
					{
					case KeyEvent.VK_RIGHT:
						key="right";
						press=true;
						keyupdate();
					break;
					case KeyEvent.VK_LEFT:
						key="left";
						press=true;
						keyupdate();
					break;
					case KeyEvent.VK_ENTER:
						start=false;
						play=false;
						Init();
						repaint();
					break;
					case KeyEvent.VK_S:
						play=true;
						start=true;
						ballXdir=1;
						ballYdir=2;
					break;
					}
		}
		public void keyReleased(KeyEvent e) {
			press=false;
		}
		public void keyTyped(KeyEvent arg0) {
			
		}
	}
	private void keyupdate() {
		if(key=="right"&&press) {
			moveRight();
		}
		else if(key=="left"&&press) {
			moveLeft();
		}
	}

	private void moveRight() {
		if(bar.barX>=710) bar.barX=710;
		else bar.barX+=2;
	}
	private void moveLeft() {
		if(bar.barX<=0) bar.barX=0;
		else bar.barX-=2;
	}
	private class PaintThread implements Runnable{
		public void run() {
			while(play) {
				keyupdate();
				if(ball.getRect().intersects(bar.getRect())) {
					if(ball.ballposX<=bar.barX+25) {
					ballXdir=1;
					ballXdir=-ballXdir;
					}
					else if(ball.ballposX<=bar.barX+49) {
						ballXdir=0;
					}
					else {
						ballXdir=-1;
						ballXdir=-ballXdir;
					}
					ballYdir=-ballYdir;
					bgm.play("pong1.wav", false);
				}
				A:for(int j=0;j<Default.wall.size();j++) {
					Wall w=Default.wall.get(j);
					if(ball.getRect().intersects(w.getRect())) {
						
						Default.wall.remove(j);
						
						bgm.play("pong2.wav", false);
						score+=5;
						if(ball.ballposX+19<=w.getRect().x||ball.ballposX+1>=w.getRect().x+w.getRect().width) {
							ballXdir=-ballXdir;
						}else {
							ballYdir=-ballYdir;
						}
						break;
					}
					Wall w2=Default.wall.get(j);
					if(ball.getRect().intersects(w2.getRect())) {
						w.draw(getGraphics());
						bgm.play("pong2.wav", false);
						score+=5;
						if(ball.ballposX+19<=w.getRect().x||ball.ballposX+1>=w.getRect().x+w.getRect().width) {
							ballXdir=-ballXdir;
						}else {
							ballYdir=-ballYdir;
						}
						break A;
					}
				}
				ball.ballposX+=ballXdir;
				ball.ballposY+=ballYdir;
				if(ball.ballposX<0) ballXdir=-ballXdir;
				if(ball.ballposX>780) ballXdir=-ballXdir;
				if(ball.ballposY<0) ballYdir=-ballYdir;
				repaint();
				try {
					Thread.sleep(2);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
