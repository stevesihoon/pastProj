import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
public class Spen extends Shape{
	private Color Lc;
	private float stroke;
	private Point Spoint;
	public Spen(Color Lc,float stroke,Point Spoint) {
		this.Lc=Lc;
		this.stroke=stroke;
		this.Spoint=Spoint;
	}
	public void Draw(Graphics2D g) {
		g.setColor(Lc);
		g.setStroke(new BasicStroke(stroke));
		g.fillOval(Spoint.x, Spoint.y, (int)stroke, (int)stroke);
	}

}
