import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

class ImagePanel extends JPanel{

    private BufferedImage image;

    public ImagePanel() 
    {
       try {                
          image = ImageIO.read(new File("img/ex/dark2.jpg"));
       } catch (IOException ex) {
            // handle exception...
       }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters            
    }

}

public class Main2 extends JFrame implements ActionListener,MouseListener,KeyListener
{
	 String lab;
	Container cont;
	int k=0;
	JPanel main,main_top,main_bottom,Start_next;
	JLabel main_logoname;
	JButton main_logo;
	ImagePanel Start;
	JLabel Start_logo,Start_welcome,Start_softname,Start_power,Start_powername,Start_dev,Start_devname;
	JButton Start_nextlab;
	JButton maximize,minimize,Start_register,Start_post,Login_button;
	NewRegistration n1;
	NewPost n2;
	Login_page lp=null;
	int i=0,j=0;
	Font sp1,sp2,sp3;
	
	Main2()
	{
		
	}
	Main2(String s)
	{
		super(s);
		cont=getContentPane();
		cont.setLayout(null);
		setLayout(null);
		
		setUndecorated(true);
		setBounds(0,0,1200,800);
		
		ImageIcon img = new ImageIcon("img/icon2.png");
		this.setIconImage(img.getImage());
		
		maximize=new JButton();
		maximize.setLayout(null);
		maximize.setBounds(10,10,30,30);
		//maximize.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/cir1.jpg"));
		maximize.setFocusable(false);
		//maximize.setBorderPainted(false);
		maximize.setBackground(Color.black);
		maximize.setBorder(new LineBorder(Color.red,1));
		
		minimize=new JButton();
		minimize.setLayout(null);
		minimize.setBounds(50,10,30,30);
		//minimize.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/cir1.jpg"));
		minimize.setFocusable(false);
		//minimize.setBorderPainted(false);
		minimize.setBackground(Color.black);
		minimize.setBorder(new LineBorder(Color.yellow,1));
		
		/*Start_icon=new JLabel();
		Start_icon.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/ex/01.jpg"));
		Start_icon.setLayout(null);
		Start_icon.setBounds(0,0,1200,800);*/
		Font f1=new Font("Arial",Font.BOLD,18);
		Font f2=new Font("Arial",Font.BOLD,40);
		Font f3=new Font("Arial",Font.BOLD,60);
		Font f4=new Font("TimesRoman",Font.PLAIN,18);
		sp1=new Font("TimesRoman",Font.PLAIN,30);
		sp2=new Font("TimesRoman",Font.BOLD,40);
		sp3=new Font("TimesRoman",Font.BOLD,80);
		
		
		Start_welcome=new JLabel("Welcome! To");
		Start_welcome.setLayout(null);
		Start_welcome.setBounds(440,50,500,70);
		Start_welcome.setFont(f2);
		Start_welcome.setForeground(Color.white);
		
		Start_logo=new JLabel();
		Start_logo.setLayout(null);
		Start_logo.setBounds(450,250,300,300);
		Start_logo.setIcon(new ImageIcon("img/logo5.png"));
		
		Start_softname=new JLabel("AdEx");
		Start_softname.setLayout(null);
		Start_softname.setBounds(520,500,200,100);
		Start_softname.setForeground(Color.decode("#7FFF00"));
		Start_softname.setFont(f3);
		
		Start_register=new JButton("Register");
		Start_register.setLayout(null);
		Start_register.setBounds(430,620,150,50);
		Start_register.setBackground(Color.decode("#7FFF00"));
		Start_register.setForeground(Color.decode("#FF4040"));
		Start_register.setFont(f1);
		Start_register.setFocusable(false);
		Start_register.setBorder(new LineBorder(Color.green,3));
		Start_register.setToolTipText("New Student Registration");
		
		Start_post=new JButton("Post");
		Start_post.setLayout(null);
		Start_post.setBounds(640,620,150,50);
		Start_post.setBackground(Color.decode("#7FFF00"));
		Start_post.setForeground(Color.decode("#FF4040"));
		Start_post.setFont(f1);
		Start_post.setFocusable(false);
		Start_post.setBorder(new LineBorder(Color.green,3));
		Start_post.setToolTipText("Add New Post");
		Start_post.setVisible(false);
		
		Login_button=new JButton("Login");
		Login_button.setActionCommand("Login");
		Login_button.setLayout(null);
		Login_button.setBounds(640,620,150,50);
		Login_button.setBackground(Color.decode("#7FFF00"));
		Login_button.setForeground(Color.decode("#FF4040"));
		Login_button.setFont(f1);
		Login_button.setFocusable(false);
		Login_button.setBorder(new LineBorder(Color.green,3));
		Login_button.setToolTipText("LOGIN");
		Login_button.setVisible(false);
		
		Start_power=new JLabel("Powered By");
		Start_power.setLayout(null);
		Start_power.setBounds(20,700,400,50);
		Start_power.setForeground(Color.green);
		Start_power.setFont(f1);
		
		Start_powername=new JLabel("Maharaja Sayajirao University of Baroda");
		Start_powername.setLayout(null);
		Start_powername.setBounds(20,740,600,50);
		Start_powername.setForeground(Color.white);
		Start_powername.setFont(f4);
		
		Start_dev=new JLabel("Developed By");
		Start_dev.setLayout(null);
		Start_dev.setBounds(1045,700,150,50);
		Start_dev.setForeground(Color.green);
		Start_dev.setFont(f1);
		
		Start_devname=new JLabel("Base Infinity");
		Start_devname.setLayout(null);
		Start_devname.setBounds(1065,740,120,50);
		Start_devname.setForeground(Color.white);
		Start_devname.setFont(f4);
		
		/*Start_next=new JPanel();
		Start_next.setLayout(null);
		Start_next.setBackground(null);
		Start_next.setBounds(1000,0,200,800);
		Start_next.setVisible(true);
		*/
		Start_nextlab = new JButton();
		Start_nextlab.setBounds(1100,0,100,800);
		Start_nextlab.setLayout(null);
		Start_nextlab.setIcon(new ImageIcon("img/2greater.png"));
		Start_nextlab.setBackground(Color.black);
		Start_nextlab.setFont(sp1);
		Start_nextlab.setForeground(Color.white);
		Start_nextlab.setFocusable(false);
		Start_nextlab.setBorder(null);
		Start_nextlab.setContentAreaFilled(false);
		Start_nextlab.setOpaque(false);
		
		Start=new ImagePanel();
		Start.setBounds(0,0,1200,800);
		Start.setLayout(null);
		
		main_top=new JPanel();
		main_top.setBounds(0,0,1200,150);
		main_top.setLayout(null);
		main_top.setVisible(true);
		main_top.setBackground(Color.black);
		
		main_bottom=new JPanel();
		main_bottom.setBounds(0,150,1200,660);
		main_bottom.setLayout(null);
		main_bottom.setVisible(true);
		main_bottom.setBackground(Color.white);
		
		main_logo=new JButton();
		main_logo.setLayout(null);
		main_logo.setBounds(350,0,150,150);
		main_logo.setIcon(new ImageIcon("img/logo4.png"));
		main_logo.setContentAreaFilled(false);
		main_logo.setOpaque(false);
		main_logo.setBorder(null);
		
		main_logo.setActionCommand("back");
		main_logo.addActionListener(this);
		main_logo.addMouseListener(this);
		
		JLabel main_logonameA=new JLabel("A");
		main_logonameA.setLayout(null);
		main_logonameA.setBounds(500,0,100,150);
		main_logonameA.setForeground(Color.green);
		main_logonameA.setFont(sp3);
		
		JLabel main_logonameX=new JLabel("X");
		main_logonameX.setLayout(null);
		main_logonameX.setBounds(640,0,400,150);
		main_logonameX.setForeground(Color.green);
		main_logonameX.setFont(sp3);
		
		
		main_logoname=new JLabel("dE");
		main_logoname.setLayout(null);
		main_logoname.setBounds(570,40,400,100);
		main_logoname.setForeground(Color.green);
		main_logoname.setFont(sp2);
		
		
		JLabel main_logonamemsu=new JLabel("MSU");
		main_logonamemsu.setLayout(null);
		main_logonamemsu.setBounds(555,32,200,50);
		main_logonamemsu.setForeground(Color.magenta);
		main_logonamemsu.setFont(sp1);
		
		main = new JPanel();
		main.setBounds(0,0,1200,800);
		main.setLayout(null);
		main.setVisible(false);
		
		if(s.equals("MSU Ad Sense"))
		{
			Start_post.setVisible(true);
		}
		else if(s.equals("LOGIN"))
		{
			 Login_button.setVisible(true);
		}
		
		
		//Start.add(Start_icon);
		//Start.add(Start_next);
		Start.add(Start_nextlab);
		Start.add(Start_welcome);
		Start.add(Start_logo);
		Start.add(Start_softname);
		Start.add(Start_register);
		Start.add(Start_post);
		Start.add(Start_power);
		Start.add(Start_powername);
		Start.add(Login_button);
		Start.add(Start_dev);
		Start.add(Start_devname);
		
		main_top.add(main_logo);
		main_top.add(main_logoname);
		main_top.add(main_logonameA);
		main_top.add(main_logonamemsu);
		main_top.add(main_logonameX);
		//main_top.add(main_logobtn);
		
		main.add(main_top);
		main.add(main_bottom);
		//Start.add(maximize);
		//Start.add(minimize);
		cont.add(Start);
		cont.add(main);
		cont.add(maximize);
		cont.add(minimize);
		
		maximize.setActionCommand("x");
		minimize.setActionCommand("-");
		
		Start_nextlab.setActionCommand(">");
		Start_nextlab.addActionListener(this);
		Start_nextlab.addMouseListener(this);
		
		maximize.addActionListener(this);
		minimize.addActionListener(this);
		maximize.addMouseListener(this);
		minimize.addMouseListener(this);
		Start_register.addActionListener(this);
		Start_post.addActionListener(this);
		Login_button.addActionListener(this);
	
//	   lp.sub.addActionListener(this);
//		
		Login_button.addMouseListener(this);
		Start_register.addMouseListener(this);
		Start_post.addMouseListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		
		lab=(String)ae.getActionCommand();
		if(lab.equals("x"))
		{
			try{
				n1.dispose();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			try{
				n2.dispose();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			this.setVisible(false);
		}
		else if(lab.equals("-"))
		{
			setState(this.ICONIFIED);
		}
		else if(lab.equals("Register"))
    	{
			try {
				i++;
				if(i==1)
				{
					n1=new NewRegistration();
				}
				else
				{  
					if(n1.isShowing())
					{
						System.out.println("Already in Running");
					}
					else
					{
						n1=new NewRegistration();
					}
				}
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
    	}
    	else if(lab.equals("Post"))
    	{
    		try {
				j++;
				if(j==1)
				{
					n2=new NewPost();
				}
				else
				{
					if(n2.isShowing())
					{
						System.out.println("Already in Running");
					}
					else
					{
						n2=new NewPost();
					}
				}
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
    	}
    	
    	else if(lab.equals(">"))
    	{
    		if(main.isVisible()==false)
        	{
    	    		//cont.remove(Start);
    	    		Start.setVisible(false);
    	    		main.setVisible(true);
    	            System.out.println("In Main Panel after > Pressed:");
        	}
    	}
    	else if(lab.equals("back"))
    	{
    		if(Start.isVisible()==false)
        	{
    	    		//cont.remove(main);
    	    		main.setVisible(false);
    	    		Start.setVisible(true);
    	            System.out.println("In Start Panel after logo Pressed:");
        	}
    	}
    	else if(lab.equals("Login"))
    	{
    		k++;
    		 
    		  if(k==1)
    		  {
    			  lp=new Login_page(this);
 				 lp.setVisible(true);
 				
    		  }
    		  else if(lp.isShowing()==false)
    		  {
    			  lp=new Login_page(this);
 				 lp.setVisible(true);
 				
    			  
    		  }
    		   
    		   
    		   
    			   
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
    	else if(ESource.equals(Start_nextlab))
    	{
    		Start_nextlab.setBackground(Color.black);
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
    	else if(ESource.equals(Start_register))
    	{
    		Start_register.setBackground(Color.black);
    		Start_register.setForeground(Color.green);
    	}
    	else if(ESource.equals(Login_button))
    	{
    		Login_button.setBackground(Color.black);
    		Login_button.setForeground(Color.green);

    		 
    	}
    	else if(ESource.equals(Start_post))
    	{
    		Start_post.setBackground(Color.black);
    		Start_post.setForeground(Color.green);
    	}
    	else if(ESource.equals(Start_nextlab))
    	{
    		Start_nextlab.setIcon(new ImageIcon("img/1greater.png"));
    	}
    	else if(ESource.equals(main_logo))
    	{
    		main_logo.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/logo42.png"));
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
    	else if(ESource.equals(Start_register))
    	{
    		Start_register.setBackground(Color.decode("#7FFF00"));
    		Start_register.setForeground(Color.decode("#FF4040"));
    	}
    	else if(ESource.equals(Login_button))
    	{
    		Login_button.setBackground(Color.decode("#7FFF00"));
    		Login_button.setForeground(Color.decode("#FF4040"));

    	}
    	else if(ESource.equals(Start_post))
    	{
    		Start_post.setBackground(Color.decode("#7FFF00"));
    		Start_post.setForeground(Color.decode("#FF4040"));
    	}
    	else if(ESource.equals(Start_nextlab))
    	{
    		//Start_nextlab.setFont(sp1);
    		//Start_nextlab.setBackground(null);
    		//Start_nextlab.setForeground(Color.white);
    		Start_nextlab.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/2greater.png"));
    	}
    	else if(ESource.equals(main_logo))
    	{
    		main_logo.setIcon(new ImageIcon("/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/logo4.png"));
    	}
    }  
    public void mousePressed(MouseEvent e) 
    {
    	AbstractButton ESource = (AbstractButton)e.getSource();
    	if(ESource.equals(Start_nextlab))
    	{
    		Start_nextlab.setBackground(Color.black);
    	}
    }  
    public void mouseReleased(MouseEvent e) 
    {
    	
    }  
    public void keyPressed(KeyEvent e) 
    {
    	if(main.isVisible()==false)
    	{
	    	if (e.getKeyCode()==KeyEvent.VK_ENTER){
	    		cont.remove(Start);
	    		Start.setVisible(false);
	    		main.setVisible(true);
	            System.out.println("In Main Panel after Enter Pressed:");
	        }
    	}
    }  
    public void keyReleased(KeyEvent e) 
    {  
    
    }  
    public void keyTyped(KeyEvent e) 
    {  
    	
    }  
}
