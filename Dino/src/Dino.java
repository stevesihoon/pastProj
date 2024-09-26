import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
public class Dino {
	public int width=50;
	public int height=53;
	int dinoX,dinoY;
	private static Toolkit tk=Toolkit.getDefaultToolkit();
	public Dino(int x,int y) {
		dinoX=x;
		dinoY=y;
	}
	public void Draw(Graphics g) {
		g.drawImage(tk.getImage("dino.gif"), dinoX, dinoY, width, height, null);
	}
	public Rectangle getRect() {
		return new Rectangle(dinoX,dinoY,width,height);
	}

}
