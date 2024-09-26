import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ballgame extends JPanel {

	private Image imgbuf=null;
	private Graphics buf=null;
	private int ballXdir;
	private int ballYdir;
	private boolean play=true;
	private Ball ball;
	private Bar bar;
	private MapLoad map;
	private boolean start;
	private String key="";
	private boolean press=false;
	private Sound bgm=new Sound();
	private static Toolkit tk=Toolkit.getDefaultToolkit();
	
	public Ballgame() {
		mkey listener=new mkey();
		addKeyListener(listener);
		setFocusable(true);
		map=new MapLoad(20,20);
		Init();

	}
	void Init() {
		bgm.play("GameStart.wav", false);
		ball=new Ball(400,350);
		bar=new Bar(400);
		start=false;
		ballXdir=0;
		ballYdir=0;
		play=true;
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
		g.drawImage(tk.getImage("bg.png"),0,0,800,600,null);
		bar.draw(g);
		bar.drawcom(g);
		ball.draw(g);
		g.setColor(Color.yellow);

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
					case KeyEvent.VK_UP:
						key="up";
						press=true;
						keyupdate();
					break;
					case KeyEvent.VK_DOWN:
						key="down";
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
						ballYdir=1;
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
		if(key=="up"&&press) {
			moveUp();
		}
		else if(key=="down"&&press) {
			moveDown();
		}
	}

	private void moveDown() {
		if(bar.barY>=500) bar.barY=500;
		else bar.barY+=2;
	}
	private void moveUp() {
		if(bar.barY<=0) bar.barY=0;
		else bar.barY-=2;
	}
	private class PaintThread implements Runnable{
		public void run() {
			while(play) {
				keyupdate();
				if(ball.getRect().intersects(bar.getRect())) {
					if(ball.ballposY<=bar.barY+25) {
					ballYdir=1;
					ballYdir=-ballYdir;
					}
					else if(ball.ballposY<=bar.barY+49) {
						ballYdir=0;
					}
					else {
						ballYdir=-1;
						ballYdir=-ballYdir;
					}
					ballXdir=-ballXdir;
					bgm.play("pong1.wav", false);
				}
				
				ball.ballposX+=ballXdir;
				ball.ballposY+=ballYdir;
				if(ball.ballposY<0) ballYdir=-ballYdir;
				if(ball.ballposY>575) ballYdir=-ballYdir;
				if(ball.ballposX<0) ballXdir=-ballXdir;
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
