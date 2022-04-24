import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class Sample4 
{
	JMenuBar jmb;
	JMenu jm;
	JPanel tp;
	JLabel jk;
	JMenuItem ji1,ji2,ji3;
	JFrame jf;
	Container con;
	BufferedImage img=null;
	Sample4()
	{
		
		
		jf=new JFrame();
		jf.setLayout(null);
		
		con=jf.getContentPane();
		con.setLayout(null);
		jf.setSize(1200,800);
		jf.setVisible(true);
		
		tp=new JPanel();
		tp.setBounds(0,0,1200,200);
		
		try{
			
		
		img=ImageIO.read(new File("C:\\proj_pics\\default"));
		
//		 jk=new JLabel();
//		jk.setIcon(new ImageIcon("C:\\proj_pics\\default"));
//		jk.setBounds(0,300,400,400);
		}
		catch(Exception e)
		{
			
		}
		
		con.add(tp);
		//con.add(jk);
		tp.setLayout(null);
		
		jmb=new JMenuBar();
	    jmb.setBounds(0,100,1200,20);
	    jmb.setBackground(Color.blue);
		
		jf.setJMenuBar(jmb);
		
		
		tp.add(jmb);
		jm=new JMenu("MENU");
		jmb.add(jm);
		
		  
	}
	
	@Override
	
	protected void paintComponent(Graphics g)
	{
		  super.paintComponent(g);
		    g.drawImage(img,500,500,this);
	}
	
	public static void main(String[] st)
	{
		new Sample4();
		
	}

}
