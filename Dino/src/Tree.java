import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Tree {
	private int width,n;
	public int treeX;
	Toolkit tk=Toolkit.getDefaultToolkit();
	public Tree(int x) {
		treeX=x;
	}
	public void Draw(Graphics g,int n) {
		if(n==0) width=33;
		if(n==1) width=60;
		if(n==2) width=90;
		if(n==0) g.drawImage(tk.getImage("tree.png"), treeX, 240, width, 60, null);
		if(n==1) g.drawImage(tk.getImage("tree2.png"), treeX, 240, width, 60, null);
		if(n==2) g.drawImage(tk.getImage("tree3.png"), treeX, 240, width, 60, null);
	}
	public Rectangle getRect() {
		return new Rectangle(treeX,240,width,60);
	}

}
