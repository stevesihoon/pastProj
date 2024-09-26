import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
public class Srect extends Shape{
	private Color Lc,Fc;
	private int w,h,minx,miny;
	private float stroke;
	private boolean tcheck;
	public Srect() {};
	public Srect(Color Lc,Color Fc,float stroke,int minx,int miny,int w,int h,boolean tcheck) {
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
			g.fillRect(minx, miny, w, h);
		}
	}
	public void Clear(Graphics2D g) {
		if(!tcheck) {
			g.setColor(Color.WHITE);
			g.fillRect(minx, miny, w, h);
		}
		g.setColor(Color.WHITE);
		g.setStroke(new BasicStroke(stroke));
		g.drawRect(minx, miny, w, h);
	}

}
