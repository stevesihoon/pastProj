import java.awt.Point;
import java.awt.Rectangle;

public class MapLoad {
	private int m_col;
	private int m_row;
	private Rectangle[][] m_ppRect;
	MapLoad(int row,int col){
		m_row=row;
		m_col=col;
		m_ppRect=new Rectangle[m_col][m_row];
		int colgap=Default.m_mapsize/m_col;
		Point lt=new Point();
		lt.x=0;
		lt.y=0;
		for(int i=0;i<m_row;i++) {
			for(int j=0;j<m_col;j++) {
				m_ppRect[i][j]=new Rectangle(lt.x,lt.y,40,40);
				lt.x+=colgap;
			}
			lt.x=0;
			lt.y+=colgap;
		}
	}

}
