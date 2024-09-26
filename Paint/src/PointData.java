import java.awt.Color;
import java.io.Serializable;
public class PointData implements Serializable{
	int px,py,w,h;
	Color c;
	PointData(int x,int y,int w,int h,Color c){
		px=x;
		py=y;
		this.h=h;
		this.w=w;
		this.c=c;
	}
}