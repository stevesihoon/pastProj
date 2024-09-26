import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Game extends JPanel {
	int Button_SIZE=25;
	int BOMB=9;
	int HIDDEN=10;
	int FLAG=11;
	int CLICK=13;
	boolean game_ended=false;
	boolean mouse_btn_1=false;
	boolean press=false;
	boolean ex=true;
	boolean play=false;
	boolean win=false;
	int timecount=30;
	int flag_cnt=0;
	int bomb_cnt=0;
	int open_cnt=0;
	Button Board[][]=new Button[12][12];
	int dx[]= {0,1,-1,0,0,1,1,-1,-1};
	int dy[]= {0,0,0,1,-1,1,-1,1,-1};
	int x=0,y=0;
	private Image imgbuf=null;
	private Graphics buf=null;
	private BufferedImage tk[]=new BufferedImage[14];
	private BufferedImage nu[]=new BufferedImage[11];
	BufferedImage bufferedImage=new BufferedImage(350,350,BufferedImage.TYPE_INT_ARGB);
	Main fa;
	int timer3,timer2,timer1;

	/**
	 * Create the panel.
	 */
	public Game(Main fa) {
		this.fa=fa;
		for(int i=0;i<12;i++)
			for(int j=0;j<12;j++) Board[i][j]=new Button();
		for(int i=0;i<14;i++) {
			try {
				tk[i]=ImageIO.read(new File(String.valueOf(i)+".png"));
			}catch(IOException e) {
				
			}
		}
		for(int i=0;i<11;i++) {
			try {
				nu[i]=ImageIO.read(new File("d"+String.valueOf(i)+".png"));
			}catch(IOException e) {
				
			}
		}
		new Thread(new TimerThread()).start();
		Init();
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				press=true;
				y=e.getPoint().x/Button_SIZE+1;
				x=e.getPoint().y/Button_SIZE+1;
				if(e.getButton()==MouseEvent.BUTTON1) {
					mouse_btn_1=true;
				}
				else if(e.getButton()==MouseEvent.BUTTON3) {
					if(Board[x][y].open==false) {
						if(Board[x][y].flag==true) {
							Board[x][y].flag=false;
							flag_cnt--;
						}
						else {
							Board[x][y].flag=true;
							flag_cnt++;
						}
						x=y=0;
						repaint();
					}
				}
				if(mouse_btn_1) {
					repaint();
				}
			}
			public void mouseReleased(MouseEvent e) {
				if(mouse_btn_1) {
					mouse_btn_1=false;
					if(Board[x][y].flag==true) return;
					Board[x][y].open=true;
					if(Board[x][y].number==BOMB) {
						game_ended=true;
						fa.btnNewButton.setIcon(new ImageIcon("sm2.png"));
						play=false;
					}
				}
				press=false;
				repaint();
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				if(press&&mouse_btn_1) {
					y=e.getPoint().x/Button_SIZE+1;
					x=e.getPoint().y/Button_SIZE+1;
					repaint();
				}
			}
		});

	}
		
	void display(int r,int c) {
		if(r<1||r>10||c<1||c>10) return;
		if(Board[r][c].number==BOMB) return;
		Board[r][c].open=true;
		if(Board[r][c].number==0) {
			for(int i=1;i<=8;i++)
				if(!Board[r+dx[i]][c+dy[i]].open) display(r+dx[i],c+dy[i]);
		}
		return;
	}
	public void Init() {
		Random rn=new Random();
		open_cnt=0;
		flag_cnt=0;
		bomb_cnt=0;
		timecount=30;
		game_ended=false;
		win=false;
		mouse_btn_1=false;
		press=false;
		for(int i=1;i<=10;i++) {
			for(int j=1;j<=10;j++) {
				Board[i][j].open=false;
				Board[i][j].number=0;
				Board[i][j].flag=false;
				if(rn.nextInt(10)==1) {
					bomb_cnt++;
					Board[i][j].number=BOMB;
				}
			}
		}
		for(int i=1;i<=10;i++) {
			for(int j=1;j<=10;j++) {
				int n=0;
				if(Board[i][j].number==BOMB) continue;
				for(int k=1;k<=8;k++)
					if(Board[i+dx[k]][j+dy[k]].number==BOMB) n++;
				Board[i][j].number=n;
			}	
		}
		for(int i=1;i<=10;i++) {
			for(int j=1;j<=10;j++) {
				System.out.printf("%d",Board[i][j].number);
			}
			System.out.println();
		}
		play=true;
		//boomnum(bomb_cnt);
		repaint();
	}
	void boomnum(int num) {
		int n1,n2,n3;
		if(num==0) {
			fa.b3.setIcon(new ImageIcon(nu[0]));
			fa.b2.setIcon(new ImageIcon(nu[0]));
			fa.b1.setIcon(new ImageIcon(nu[0]));
		}
		else if(num>0) {
			n3=num/100;
			n2=(num%100)/10;
			n1=num%10;
			fa.b3.setIcon(new ImageIcon(nu[n3]));
			fa.b2.setIcon(new ImageIcon(nu[n2]));
			fa.b1.setIcon(new ImageIcon(nu[n1]));
		}
		else {
			n3=num/100;
			n2=(num%100)/10;
			n1=num%10;
			if(num<=-10) {
				fa.b3.setIcon(new ImageIcon(nu[10]));
				fa.b2.setIcon(new ImageIcon(nu[-n2]));
				fa.b1.setIcon(new ImageIcon(nu[-n1]));
			}
			else {
				fa.b3.setIcon(new ImageIcon(nu[0]));
				fa.b2.setIcon(new ImageIcon(nu[10]));
				fa.b1.setIcon(new ImageIcon(nu[-n1]));
			}
		}
	}
	void timenum(int num) {
		int n1,n2,n3;
		if(num==0) {
			fa.t3.setIcon(new ImageIcon(nu[0]));
			fa.t2.setIcon(new ImageIcon(nu[0]));
			fa.t1.setIcon(new ImageIcon(nu[0]));
		}
		else if(num>0) {
			n3=num/100;
			n2=(num%100)/10;
			n1=num%10;
			fa.t3.setIcon(new ImageIcon(nu[n3]));
			fa.t2.setIcon(new ImageIcon(nu[n2]));
			fa.t1.setIcon(new ImageIcon(nu[n1]));
		}
		else {
			n3=num/100;
			n2=(num%100)/10;
			n1=num%10;
			if(num<=-10) {
				fa.t3.setIcon(new ImageIcon(nu[10]));
				fa.t2.setIcon(new ImageIcon(nu[-n2]));
				fa.t1.setIcon(new ImageIcon(nu[-n1]));
			}
			else {
				fa.t3.setIcon(new ImageIcon(nu[0]));
				fa.t2.setIcon(new ImageIcon(nu[10]));
				fa.t1.setIcon(new ImageIcon(nu[-n1]));
			}
		}
	}
		
	
	public void paint(Graphics g) {
		imgbuf=createImage(this.getWidth(),this.getHeight());
		buf=imgbuf.getGraphics();
		boomnum(bomb_cnt-flag_cnt);
		if(!press) Draw(buf,0,0);
		else Draw(buf,x,y);
		if(win)buf.drawImage(tk[12], 0, 0, 250, 300, null);
		update(g);
	}
	public void update(Graphics g) {
		g.drawImage(imgbuf, 0, 0, this);
	}
	public void Draw(Graphics g,int r,int c) {
		open_cnt=0;
		for(int i=1;i<=10;i++) {
			for(int j=1;j<=10;j++) {
				int n;
				if((Board[i][j].open==false)&&(game_ended==false)) n=HIDDEN;
				else {
					n=Board[i][j].number;
					display(i,j);
					repaint();
				}
				if(c==j && r==i) n=CLICK;
				g.drawImage(tk[n], Button_SIZE*(j-1), Button_SIZE*(i-1), 25, 25, null);
				if(Board[i][j].open==true) open_cnt++;
				if(Board[i][j].flag==true) {
					g.drawImage(tk[FLAG], Button_SIZE*(j-1), Button_SIZE*(i-1), 25, 25, null);
				}
				if(Board[i][j].open==true && Board[i][j].number>=0 && Board[i][j].number<=8) {
					n=Board[i][j].number;
					g.drawImage(tk[n], Button_SIZE*(j-1), Button_SIZE*(i-1), 25, 25, null);
				}
			}
		}
		if(open_cnt==100-bomb_cnt&&flag_cnt==bomb_cnt) {
			game_ended=true;
			win=true;
			repaint();
		}
	}
	private class TimerThread implements Runnable{
		public void run() {
			while(ex) {
				while(play) {
					if(timecount<=0) {
						game_ended=true;
						timenum(timecount);
						fa.btnNewButton.setIcon(new ImageIcon("sm2.png"));
						repaint();
						play=false;
					}
					else {
						timenum(timecount);
						timecount--;
					}
					try {
						Thread.sleep(1000);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(1000);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
