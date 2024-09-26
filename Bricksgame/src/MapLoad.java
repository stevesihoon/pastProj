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
	void pan1() {
		for(int i=0;i<m_row;i++) {
			for(int j=0;j<m_col;j++) {
				if(Default.pan1[i][j]==1) {
					Wall w1=new Wall(m_ppRect[i][j].x,m_ppRect[i][j].y,1);
					Default.wall.add(w1);
				}
				else if(Default.pan1[i][j]==2) {
					Wall w2=new Wall(m_ppRect[i][j].x,m_ppRect[i][j].y,2);
					Default.wall.add(w2);
				}
			}
		}
	}
	void pan2() {
		for(int i=0;i<m_row;i++) {
			for(int j=0;j<m_col;j++) {
				if(Default.pan2[i][j]==1) {
					Wall w1=new Wall(m_ppRect[i][j].x,m_ppRect[i][j].y,1);
					Default.wall.add(w1);
				}
			}
		}
	}

}
