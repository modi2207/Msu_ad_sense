import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;

class ImagePan extends JPanel{

    private Image bf;

    public ImagePan()
    {
    	ImageResize ir=new ImageResize();
    	bf=ir.Resize();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bf, 0, 0, this); // see javadoc for more info on the parameters            
    }

}

class fr extends JFrame
{
	Container cont;
	ImagePan Start;
	fr(String s)
	{
		super(s);
		cont=getContentPane();
		cont.setLayout(null);
		setLayout(null);
		setBounds(300,100,1200,800);
		
		Start=new ImagePan();
		Start.setBounds(0,0,1200,800);
		Start.setLayout(null);
		
		
		cont.add(Start);
		getDefaultCloseOperation();
		
	}
}
public class sample {

	public static void main(String[] args) {
		fr f1=new fr("assa");
		f1.setVisible(true);
	}

}
