import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Bar {
	public int width=20;
	public int height=90;
	int barY;
	private static Toolkit tk=Toolkit.getDefaultToolkit();
	public Bar(int y) {
		barY=y;
	}
	public void draw(Graphics g) {
		g.drawImage(tk.getImage("userpaddle.png"), 780, barY, width, height,null);
//		g.drawImage(tk.getImage("compaddle.png"), 0, barY, width, height, null);
	}
	public Rectangle getRect() {
		return new Rectangle(780,barY,width,height);
	}
	public void drawcom(Graphics g) {
		g.drawImage(tk.getImage("compaddle.png"), 0, barY, width, height, null);
	}

}
