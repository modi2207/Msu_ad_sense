import java.awt.Color;
import java.awt.Font;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;



class Admin_mid extends JPanel
{
	JMenuBar jmb1;
	JMenu jm1,jm2,jm3,jm4;
	JMenuItem jmt1,jmt2,jmt3,jmt4,jmt5,jmt6,jmt7,jmt8;
	
	Font f1,f2;
	  Admin_mid()
	  {
		    this.setLayout(null);
		    this.setBackground(Color.black);
		    this.setBounds(0,110,1200,140);
		  
		    f1=new Font("Timesroman",Font.PLAIN,30);
		     f2=new Font("Timesroman",Font.PLAIN,20);
		     
		     jmb1=new JMenuBar();
		     jmb1.setBackground(Color.black);
		     jmb1.setBounds(0,0,600,30);
		     
		     jmb1.setVisible(false);
		     
			     jm1=new JMenu("Event");
			     jm1.setForeground(Color.white);
			     jm1.setBounds(5,5,100,20);
			     jm1.setFont(f2);
			     
		     	jm2=new JMenu("Post");
			    jm2.setForeground(Color.white);
			    jm2.setFont(f2);
			    jm2.setBounds(120,5,100,20);
			    
			    jm3=new JMenu("REGISTERATION");
			    jm3.setForeground(Color.white);
			    jm3.setFont(f2);
			    jm3.setBounds(235,5,200,20);
			    
			    jm4=new JMenu("ACCOUNT");
			    jm4.setForeground(Color.white);
			    jm4.setFont(f2);
			    jm4.setBounds(450,5,150,20);
			    
			    jmt1=new JMenuItem("Add Event");
			    jmt1.setBackground(Color.black);
			    jmt1.setForeground(Color.white);
			    jmt1.setFont(f2);
			    
			    jmt2=new JMenuItem("Delete Event");
			    jmt2.setBackground(Color.black);
			    jmt2.setForeground(Color.white);
			    jmt2.setFont(f2);
			    
			    jmt3=new JMenuItem("Add Post");
			    jmt3.setBackground(Color.black);
			    jmt3.setForeground(Color.white);
			    jmt3.setFont(f2);
			    
			    jmt4=new JMenuItem("Modify Post");
			    jmt4.setBackground(Color.black);
			    jmt4.setForeground(Color.white);
			    jmt4.setFont(f2);
			    
			    jmt5=new JMenuItem("Delete Post");
			    jmt5.setBackground(Color.black);
			    jmt5.setForeground(Color.white);
			    jmt5.setFont(f2);
			    
			    jmt6=new JMenuItem("Registration For Head");
			    jmt6.setBackground(Color.black);
			    jmt6.setForeground(Color.white);
			    jmt6.setFont(f2);
			    
			    jmt7=new JMenuItem("Account of Admin");
			    jmt7.setBackground(Color.black);
			    jmt7.setForeground(Color.white);
			    jmt7.setFont(f2);
		

			    
			    jm1.add(jmt1);
			    jm1.add(jmt2);
			    jm2.add(jmt3);
			    jm2.add(jmt4);
			    jm2.add(jmt5);
			    jm3.add(jmt6);
			    jm4.add(jmt7);
			    

			    

		     
		     jmb1.setLayout(null);
		     
		     add(jmb1);
		     jmb1.add(jm1);
		     jmb1.add(jm2);
		     jmb1.add(jm3);
		     jmb1.add(jm4);
		     
	  }
	  
	  Admin_mid(int n)
	  {
		  this.setLayout(null);
		    this.setBackground(Color.black);
		    this.setBounds(0,130,1200,25);
		  
		    f1=new Font("Timesroman",Font.PLAIN,30);
		     f2=new Font("Timesroman",Font.PLAIN,20);
		     
		     jmb1=new JMenuBar();
		     jmb1.setBackground(Color.black);
		     jmb1.setBounds(0,0,600,30);
		     
		     jmb1.setVisible(false);
		     
			     
		     	jm2=new JMenu("Post");
			    jm2.setForeground(Color.white);
			    jm2.setFont(f2);
			    jm2.setBounds(5,5,100,20);
			    
			    jm3=new JMenu("REGISTERATION");
			    jm3.setForeground(Color.white);
			    jm3.setFont(f2);
			    jm3.setBounds(120,5,200,20);
			    
			    jm4=new JMenu("ACCOUNT");
			    jm4.setForeground(Color.white);
			    jm4.setFont(f2);
			    jm4.setBounds(335,5,150,20);
			    
			    jmt3=new JMenuItem("Add Post");
			    jmt3.setBackground(Color.black);
			    jmt3.setForeground(Color.white);
			    jmt3.setFont(f2);
			    
			    jmt4=new JMenuItem("Modify Post");
			    jmt4.setBackground(Color.black);
			    jmt4.setForeground(Color.white);
			    jmt4.setFont(f2);
			    
			    jmt5=new JMenuItem("Delete Post");
			    jmt5.setBackground(Color.black);
			    jmt5.setForeground(Color.white);
			    jmt5.setFont(f2);
			    
//			    jmt6=new JMenuItem("Registration For Head");
//			    jmt6.setBackground(Color.black);
//			    jmt6.setForeground(Color.white);
//			    jmt6.setFont(f2);
//			   
			    jmt8=new JMenuItem("Registration For Student");
			    jmt8.setBackground(Color.black);
			    jmt8.setForeground(Color.white);
			    jmt8.setFont(f2);
			   
			    jmt7=new JMenuItem("Account of Head");
			    jmt7.setBackground(Color.black);
			    jmt7.setForeground(Color.white);
			    jmt7.setFont(f2);
		

			    
			    jm2.add(jmt3);
			    jm2.add(jmt4);
			    jm2.add(jmt5);
			 //   jm3.add(jmt6);
			    jm3.add(jmt8);
			    jm4.add(jmt7);
			    

			    

		     
		     jmb1.setLayout(null);
		     
		     add(jmb1);
		     
		     jmb1.add(jm2);
		     jmb1.add(jm3);
		     jmb1.add(jm4);
		     
		  
	  }
}
