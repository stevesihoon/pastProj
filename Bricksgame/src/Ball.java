import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
public class Ball {
	public static final int width=20;
	public static final int height=20;
	int ballposX, ballposY;
	private static Toolkit tk=Toolkit.getDefaultToolkit();
	public Ball(int x,int y) {
		ballposX=x;
		ballposY=y;
	}
	public void draw(Graphics g) {
		g.drawImage(tk.getImage("ball.gif"), ballposX, ballposY, width, height, null);
	}
	public Rectangle getRect() {
		return new Rectangle(ballposX,ballposY,width,height);
	}

}
