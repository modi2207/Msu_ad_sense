import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
public class ImageResize{

	ImageResize()
	{
		
	}
	Image Resize()
	{
		Image tempJPG=null;
		try 
		{
			File folder = new File("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/ex/Image/dark1.jpg");
			Image img = null;
			File newFileJPG = null;
			img = ImageIO.read(folder);
			tempJPG = resizeImage(img, 1200, 800);
			//newFileJPG = new File("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/ex/Image/"+folder.getName()+"_New.jpg");
			//ImageIO.write(tempJPG, "jpg", newFileJPG);
			System.out.println("DONE");
		}
		catch(Exception e)
		{
			
		}
		finally {
			return tempJPG;
		}
	}

	/**
	 * This function resize the image file and returns the BufferedImage object that can be saved to file system.
	 */
	public static BufferedImage resizeImage(final Image image, int width, int height) {
        final BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        final Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setComposite(AlphaComposite.Src);
        //below three lines are for RenderingHints for better image quality at cost of higher processing time
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.drawImage(image, 0, 0, width, height, null);
        graphics2D.dispose();
        return bufferedImage;
    }
}