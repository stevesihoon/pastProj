import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class Sline extends Shape{
	private Color Lc;
	private float stroke;
	private Point Spoint,Epoint;
	public Sline() {};
	public Sline(Color Lc,float stroke,Point Spoint,Point Epoint) {
		this.Lc=Lc;
		this.stroke=stroke;
		this.Spoint=Spoint;
		this.Epoint=Epoint;
	}
	public void Draw(Graphics2D g) {
		g.setColor(Lc);
		g.setStroke(new BasicStroke(stroke));
		g.drawLine(Spoint.x, Spoint.y, Epoint.x, Epoint.y);
	}
	public void Clear(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.setStroke(new BasicStroke(stroke));
		g.drawLine(Spoint.x, Spoint.y, Epoint.x, Epoint.y);
	}

}
