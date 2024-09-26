import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

public class Game extends JPanel {
	private int i=1;

	/**
	 * Create the panel.
	 */
	public Game() {
		mkey listener=new mkey();
		addKeyListener(listener);
		setFocusable(true);

	}
	public void paint(Graphics g) {
		super.paint(g);
		DrawMiro(g);
	}
	class mkey implements KeyListener{
		public void keyPressed(KeyEvent e) {
			int key=e.getKeyCode();
			switch(key) {
			case KeyEvent.VK_RIGHT:
			if(Data.xpos+1<Data.MIRO_BOARD_WIDTH) {
				if(Data.miro[i][Data.ypos][Data.xpos+1]=='0'||Data.miro[i][Data.ypos][Data.xpos+1]=='x') {
					Data.miro[i][Data.ypos][Data.xpos]='0';
					Data.miro[i][Data.ypos][++Data.xpos]='e';
				}
			}
			break;
			case KeyEvent.VK_LEFT:
				if(Data.xpos-1>=0) {
					if(Data.miro[i][Data.ypos][Data.xpos-1]=='0'||Data.miro[i][Data.ypos][Data.xpos-1]=='x') {
						Data.miro[i][Data.ypos][Data.xpos]='0';
						Data.miro[i][Data.ypos][--Data.xpos]='e';
					}
				}
				break;
			case KeyEvent.VK_UP:
				if(Data.ypos-1>=0) {
					if(Data.miro[i][Data.ypos-1][Data.xpos]=='0'||Data.miro[i][Data.ypos-1][Data.xpos]=='x') {
						Data.miro[i][Data.ypos][Data.xpos]='0';
						Data.miro[i][--Data.ypos][Data.xpos]='e';
					}
				}
				break;
			case KeyEvent.VK_DOWN:
				if(Data.ypos+1<Data.MIRO_BOARD_HEIGHT) {
					if(Data.miro[i][Data.ypos+1][Data.xpos]=='0'||Data.miro[i][Data.ypos+1][Data.xpos]=='x') {
						Data.miro[i][Data.ypos][Data.xpos]='0';
						Data.miro[i][++Data.ypos][Data.xpos]='e';
					}
				}
				break;
			}
			repaint();
			Wincheck();
		}
		public void keyReleased(KeyEvent arg0) {
			
		}
		public void keyTyped(KeyEvent arg0) {
			
		}
		
	}
	void Wincheck() {
		if(Data.xpos==5&&Data.ypos==8) {
			JOptionPane.showMessageDialog(null, "탈출성공");
			System.exit(0); //wincheck에서 level, 게임 끝내면 높이기
		}
	}
	public void DrawMiro(Graphics g) {
		for(int y=1;y<=Data.MIRO_BOARD_HEIGHT;y++) {
			for(int x=1;x<=Data.MIRO_BOARD_WIDTH;x++) {
				if(Data.miro[level][y-1][x-1]=='1') {
					g.setColor(Color.BLACK);
					g.fillRect(x*30, y*30, 29, 29);
				}
				else if(Data.miro[i][y-1][x-1]=='0') {
					g.setColor(Color.PINK);
					g.fillRect(x*30, y*30, 29, 29);
				}
				else if(Data.miro[i][y-1][x-1]=='e') {
					g.setColor(Color.BLUE);
					g.fillOval(x*30,y*30,29,29);
					Data.xpos=x-1;
					Data.ypos=y-1;
				}
				else if(Data.miro[i][y-1][x-1]=='x') {
					g.setColor(Color.RED);
					g.drawString("★",x*30+8,y*30+17);
				}
			}
		}
}


}
