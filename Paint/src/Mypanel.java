import javax.swing.JPanel;
import java.awt.event.MouseMotionAdapter;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mypanel extends JPanel {
	private int w,h,draw=1,minx,miny;
	private float stroke=(float)5;
	private Color Lc=Color.BLACK,Fc=Color.WHITE;
	
	Point Spoint=new Point(0,0);
	Point Epoint=new Point(0,0);
	BufferedImage bufferedImage=new BufferedImage(600,600,BufferedImage.TYPE_INT_ARGB);
	BufferedImage bpre=new BufferedImage(600,600,BufferedImage.TYPE_INT_ARGB);
	private boolean tcheck=true;
	private Srect srpre=null;
	private Scircle scpre=null;
	private Sline slpre=null;
	private boolean load=false;
	
	public void setLc(Color c) {
		this.Lc=c;
	}
	public void setFc(Color c) {
		this.Fc=c;
	}
	public void setDraw(int draw) {
		this.draw=draw;
	}
	public void setTc(boolean tcheck) {
		this.tcheck=tcheck;
	}
	public void setStroke(float stroke) {
		this.stroke=stroke;
	}
	
	
	public Mypanel() {
		Clear();
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Epoint=e.getPoint();
				Spoint=e.getPoint();
				if(load) {
					bufferedImage=deepCopy(bpre);
				}
			}
			public void mouseReleased(MouseEvent e) {
				updatePaint();
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				w=Math.abs(Epoint.x-Spoint.x);
				h=Math.abs(Epoint.y-Spoint.y);
				minx=Math.min(Spoint.x, Epoint.x);
				miny=Math.min(Spoint.y, Epoint.y);
				if(draw==1) {
					if(Epoint.x!=0 && Epoint.y!=0) {
						Spoint=Epoint;
						Data.vd.add(new Spen(Lc,stroke,Spoint));
						repaint();
					}
					Epoint=e.getPoint();
				}
				else if(draw==2) {
					if(load) bufferedImage=deepCopy(bpre);
					Epoint = e.getPoint();
					Data.sl.push(new Sline(Lc,stroke,Spoint,Epoint));
					repaint();
				}
				else if(draw==3) {
					if(load) bufferedImage=deepCopy(bpre);
					Epoint = e.getPoint();
					Data.sd.push(new Srect(Lc,Fc,stroke,minx,miny,w,h,tcheck));
					repaint();
				}
				else if(draw==4) {
					if(load) bufferedImage=deepCopy(bpre);
					Epoint = e.getPoint();
					Data.sc.push(new Scircle(Lc,Fc,stroke,minx,miny,w,h,tcheck));
					repaint();
				}
			}
		});
	}
	public void updatePaint() {
		Graphics2D g=(Graphics2D)bufferedImage.getGraphics();
		switch(draw) {
		case 1:
			Data.vd.add(new Spen(Lc,stroke,Spoint));
			repaint();
			break;
		case 2:
			Data.vd.add(new Sline(Lc,stroke,Spoint,Epoint));
			Data.sl.clear();
			slpre=null;
			if(load)LClear();
			repaint();
			break;
		case 3:
			Data.vd.add(new Srect(Lc,Fc,stroke,minx,miny,w,h,tcheck));
			Data.sd.clear();
			srpre=null;
			if(load)LClear();
			repaint();
			break;
		
		case 4:
			Data.vd.add(new Srect(Lc,Fc,stroke,minx,miny,w,h,tcheck));
			Data.sc.clear();
			scpre=null;
			if(load)LClear();
			repaint();
			break;
		default:
			break;
		}
		g.dispose();
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)bufferedImage.getGraphics();
		if(draw==1) {
			for(Shape s:Data.vd) {
				s.Draw(g2);
			}
		}
		if(draw==2) {
			if(slpre!=null) {
				if(!load)slpre.Clear(g2);
				for(Shape s:Data.vd) {
					s.Draw(g2);
				}
			}
			if(!Data.sl.isEmpty()) {
				Sline temp=Data.sl.pop();
				temp.Draw(g2);
				slpre=temp;
			}
		}
		if(draw==3) {
			if(slpre!=null) {
				if(!load)srpre.Clear(g2);
				for(Shape s:Data.vd) {
					s.Draw(g2);
				}
			}
			if(!Data.sd.isEmpty()) {
				Srect temp=Data.sd.pop();
				temp.Draw(g2);
				srpre=temp;
			}
		}
		if(draw==4) {
			if(slpre!=null) {
				if(!load)scpre.Clear(g2);
				for(Shape s:Data.vd) {
					s.Draw(g2);
				}
			}
			if(!Data.sc.isEmpty()) {
				Scircle temp=Data.sc.pop();
				temp.Draw(g2);
				scpre=temp;
			}
		}
		g.drawImage(bufferedImage, 0, 0, null);
		g.dispose();
		g2.dispose();
	}
	public void LClear() {
		Graphics2D g=(Graphics2D) bufferedImage.getGraphics();
		for(Shape s:Data.vd) {
			s.Draw(g);
		}
		repaint();
	}
	public void Clear() {
		Graphics2D g=(Graphics2D) bufferedImage.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 600, 600);
		load=false;
		Data.vd.clear();
		for(Shape s:Data.vd) {
			s.Draw(g);
		}
		repaint();
	}
	public void Save() {
		JFileChooser jFileChooser;
		jFileChooser=new JFileChooser();
		jFileChooser.setFileFilter(new FileNameExtensionFilter("*.png","png"));
		int rVal=jFileChooser.showSaveDialog(null);
		if(rVal==JFileChooser.APPROVE_OPTION) {
			File file=jFileChooser.getSelectedFile();
			try {
				ImageIO.write(bufferedImage, "png", new File(file.getAbsolutePath()+".png"));
				System.out.println("saved Correctly"+file.getAbsolutePath());
			}catch(IOException el) {
				System.out.println("Failed to save image");
			}
		}
		if(rVal==JFileChooser.CANCEL_OPTION) {
			System.out.println("No file choosen");
		}
	}
	public void Load() {
		JFileChooser jFileChooser;
		jFileChooser=new JFileChooser();
		FileNameExtensionFilter filter=new FileNameExtensionFilter("JPEG","jpeg","jpg","png","bmp","gif");
		jFileChooser.addChoosableFileFilter(filter);
		
		int rVal=jFileChooser.showOpenDialog(null);
		if (rVal== JFileChooser.APPROVE_OPTION) {
			File selectedFile=jFileChooser.getSelectedFile();
			try {
				Clear();
				bufferedImage=ImageIO.read(new File(selectedFile.getAbsolutePath()));
				load=true;
				bpre=deepCopy(bufferedImage);
				Data.vd.clear();
				repaint();
			}catch(IOException el) {
				el.printStackTrace();
			}
		}
	}
	public BufferedImage deepCopy(BufferedImage bi) {
		ColorModel cm=bi.getColorModel();
		boolean isAlphaPremultiplied=cm.isAlphaPremultiplied();
		WritableRaster raster=bi.copyData(null);
		return new BufferedImage(cm,raster,isAlphaPremultiplied,null);
	}

}
