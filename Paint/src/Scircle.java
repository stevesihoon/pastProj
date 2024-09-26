import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
public class Scircle extends Shape{
	private Color Lc,Fc;
	private int w,h,minx,miny;
	private float stroke;
	private boolean tcheck;
	public Scircle() {};
	public Scircle(Color Lc,Color Fc,float stroke,int minx,int miny,int w,int h,boolean tcheck) {
		this.Lc=Lc;
		this.Fc=Fc;
		this.stroke=stroke;
		this.w=w;
		this.h=h;
		this.minx=minx;
		this.miny=miny;
		this.tcheck=tcheck;
	}
	public void Draw(Graphics2D g) {
		if(!tcheck) {
			g.setColor(Fc);
			g.fillOval(minx, miny, w, h);
		}
			g.setColor(Lc);
			g.setStroke(new BasicStroke(stroke));
			g.drawOval(minx, miny, w, h);
	}
		public void Clear(Graphics2D g) {
			if(!tcheck) {
				g.setColor(Color.WHITE);
				g.fillOval(minx, miny, w, h);
			}
			g.setColor(Color.WHITE);
			g.setStroke(new BasicStroke(stroke));
			g.drawOval(minx, miny, w, h);
		}

}
