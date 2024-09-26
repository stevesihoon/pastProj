import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Bar {
	public int width=90;
	public int height=20;
	int barX;
	private static Toolkit tk=Toolkit.getDefaultToolkit();
	public Bar(int x) {
		barX=x;
	}
	public void draw(Graphics g) {
		g.drawImage(tk.getImage("bar.gif"), barX, 780, width, height,null);
	}
	public Rectangle getRect() {
		return new Rectangle(barX,780,width,height);
	}

}
