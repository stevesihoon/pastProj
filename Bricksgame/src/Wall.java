import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
public class Wall {
	public static final int width=70;
	public static final int height=38;
	int x,y;
	int life;
	private static Toolkit tk=Toolkit.getDefaultToolkit();
	public Wall(int x,int y,int life) {
		this.x=x;
		this.y=y;
		this.life=life;
	}
	public void draw(Graphics g) {
		g.drawImage(tk.getImage("wall.png"), x, y, width, height, null);
	}
	public void draw2(Graphics g) {
		g.drawImage(tk.getImage("wall2.png"), x, y, width, height, null);
	}
	public Rectangle getRect() {
		return new Rectangle(x,y,width,height);
	}

}
