import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


class General extends JPanel
{
	BufferedImage img,img1,img2,img3,img4,img5,img6;
	General()
	{
		
		  this.setBackground(Color.DARK_GRAY);
		  this.setLayout(null);
		  this.setBounds(0,0,1200,1730);
		 
		  try
		  {
			  File fg=new File("C:\\proj_pics\\img1.jpg");
			  
		  img=ImageIO.read(new File(fg.getAbsolutePath()));
		  img1=ResizeImage.resizeImage(img,500,500);
		  
		  img=ImageIO.read(new File("C:\\proj_pics\\img2.jpg"));
		  img2=ResizeImage.resizeImage(img,500,500);
		  
		  img=ImageIO.read(new File("C:\\proj_pics\\img3.jpg"));
		  img3=ResizeImage.resizeImage(img,500,500);
		  
		  img=ImageIO.read(new File("C:\\proj_pics\\img4.jpg"));
		  img4=ResizeImage.resizeImage(img,500,500);
		
		  img=ImageIO.read(new File("C:\\proj_pics\\img5.jpg"));
		  img5=ResizeImage.resizeImage(img,500,500);
		
		  img=ImageIO.read(new File("C:\\proj_pics\\img6.jpg"));
		  img6=ResizeImage.resizeImage(img,500,500);
		
		  
		  }
		  catch(Exception e)
		  {
			 System.out.print(e.getMessage()); 
		  }
		  
		  
		  
	}
	
    @Override
    protected void paintComponent(Graphics g)
  {
	  
        super.paintComponent(g);
        
        
        	//System.out.print("hello");
        //g.setColor(Color.blue);
          
        	g.drawImage(img1,50,50,this);
        	g.drawImage(img2,600,50,this);
        	
        	g.drawImage(img3,50,600,this);
        	
        	g.drawImage(img4,600,600,this);
        	g.drawImage(img5,50,1150,this);
        	g.drawImage(img6,600,1150,this);
        	
        
        }


}
