import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class NewPost extends JFrame implements ActionListener,MouseListener
{
	String lab;
	JButton maximize,minimize,submit;
	Container cont;
	JPanel pan;
	NewPost()
	{
		cont=getContentPane();
		cont.setLayout(null);
		setLayout(null);
		setUndecorated(true);
		setBounds(660,50,500,900);
		setBackground(new Color(0,0,0,150));
		setVisible(true);
		
		ImageIcon img = new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/icon2.png");
		this.setIconImage(img.getImage());
		
		Font f1=new Font("TimesRoman",Font.BOLD,22);
		Font f2=new Font("TimesRoman",Font.PLAIN,20);
		
		maximize=new JButton();
		maximize.setLayout(null);
		maximize.setBounds(10,10,20,20);
		maximize.setFocusable(false);
		maximize.setBackground(Color.black);
		maximize.setBorder(new LineBorder(Color.red,1));
		
		minimize=new JButton();
		minimize.setLayout(null);
		minimize.setBounds(40,10,20,20);
		minimize.setFocusable(false);
		minimize.setBackground(Color.black);
		minimize.setBorder(new LineBorder(Color.yellow,1));
		
		maximize.setActionCommand("x");
		minimize.setActionCommand("-");
		
		maximize.addActionListener(this);
		minimize.addActionListener(this);
		maximize.addMouseListener(this);
		minimize.addMouseListener(this);
		
		cont.add(minimize);
		cont.add(maximize);
	}
	public void actionPerformed(ActionEvent ae)
	{
		
		lab=ae.getActionCommand();
		if(lab.equals("x"))
		{
			this.setVisible(false);
		}
		else if(lab.equals("-"))
		{
			setState(this.ICONIFIED);
		}
		else if(lab.equals("Reset"))
		{
			
		}
	}
	public void mouseClicked(MouseEvent e) 
	{  
		AbstractButton ESource = (AbstractButton)e.getSource();
		if(ESource.equals(maximize))
    	{
    		maximize.setBackground(Color.green);
    	}
    	else if(ESource.equals(minimize))
    	{
    		minimize.setBackground(Color.green);
    	}
    }  
    public void mouseEntered(MouseEvent e) 
    {  
    	AbstractButton ESource = (AbstractButton)e.getSource();
    	if(ESource.equals(maximize))
    	{
    		maximize.setBackground(Color.red);
    	}
    	else if(ESource.equals(minimize))
    	{
    		minimize.setBackground(Color.YELLOW);
    	}
    	else if(ESource.equals(submit))
    	{
    		submit.setBackground(Color.darkGray);
    		submit.setForeground(Color.green);
    	}
    	
    }  
    public void mouseExited(MouseEvent e) 
    {  
    	AbstractButton ESource = (AbstractButton)e.getSource();
    	if(ESource.equals(maximize))
    	{
    		maximize.setBackground(Color.black);
    	}
    	else if(ESource.equals(minimize))
    	{
    		minimize.setBackground(Color.black);
    	}
    	else if(ESource.equals(submit))
    	{
    		submit.setBackground(Color.black);
    		submit.setForeground(Color.decode("#FF4040"));
    	}
    	
    }  
    public void mousePressed(MouseEvent e) 
    {
    	
    }  
    public void mouseReleased(MouseEvent e) 
    {
    	
    }  

}
