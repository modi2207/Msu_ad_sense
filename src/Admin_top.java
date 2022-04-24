import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


 class Admin_top extends JPanel
 {
	 JLabel name,name1,fact,event;
	 Font f1,f2;
	 JButton logout;
	 JLabel m1,m2,logo;
	 JButton minimize,close;
	 String f,e;
	 //JMenuBar jmb;
	 Admin_top()
	 {
		 		this.setLayout(null);
		     this.setBackground(Color.black);
		     this.setBounds(0,0,1200,110);
		     
		    
		     f1=new Font("Timesroman",Font.PLAIN,30);
		     f2=new Font("Timesroman",Font.PLAIN,20);
		     name=new JLabel();
		     name.setText("MSU AdEx-");
		     name.setForeground(Color.green);
		     name.setFont(f1);
		     name.setBounds(400,20,180,30);
		     
		     	name1=new JLabel();
		     	name1.setText("ADMIN");
		     	name1.setForeground(Color.blue);
		     	name1.setFont(f1);
		     	name1.setBounds(580,20,200,30);
		     
		     	close=new JButton(); 
			    close.setBounds(10,10,30,30);
			    close.setBackground(Color.black);
			    close.setToolTipText("CLOSE");
			    close.setFocusable(false);
			    close.setBorder(new LineBorder(Color.blue));
			    
			    minimize=new JButton();
			    minimize.setBounds(50,10,30,30);
			    minimize.setBackground(Color.black);
			    minimize.setToolTipText("MINIMIZE");
			    minimize.setFocusable(false);
			    minimize.setBorder(new LineBorder(Color.blue));
			   
			    
			    m1=new JLabel();
			    m1.setIcon(new ImageIcon("img//menu.png"));
			    m1.setBounds(1000,20,60,60);
			    
			    m2=new JLabel();
			    m2.setIcon(new ImageIcon("img//menu1.png"));
			    m2.setBounds(1000,20,60,60);
			    m2.setVisible(false);
			    
			    logout=new JButton();
			    logout.setText("LOGOUT");
			    logout.setBackground(Color.green);
			    logout.setForeground(Color.black);
			    logout.setBorder(new LineBorder(Color.blue,1));
			    logout.setFocusable(false);
			    logout.setToolTipText("LOGOUT");
			    logout.setBounds(1080,25,100,20);
			    logout.setFont(f2);
			    
			    
			    logo=new JLabel();
			    logo.setIcon(new ImageIcon("img//icon2.png"));
			    logo.setBounds(250,0,100,100);
			    
			    
//			      jmb=new JMenuBar();
//			      jmb.setBounds(0,100,100,20);
//			      jmb.setBackground(Color.blue);
//			      jmb.setLayout(null);
			      
//		      jm1=new JMenu("Event");
//		      jm1.setBounds(5,5,100,10);
//		      jm1.setForeground(Color.white);
		      
//		      jmb.add(jm1);   
			  
//			    add(jmb);
			    add(name);
			    add(name1);
			    add(minimize);
			    add(close);
			    add(m1);
			    add(m2);
			    add(logout);
			    add(logo);
		
			   	    	    
	 }
	 
	 Admin_top(String fact1,String event1)
	 {
		 String e=event1.toUpperCase();
		 
		 f1=new Font("Timesroman",Font.PLAIN,30);
	     f2=new Font("Timesroman",Font.PLAIN,20);
	     
		 System.out.println("hell");
		 setLayout(null);
	     this.setBackground(Color.black);
	     this.setBounds(0,0,1200,130);
	     System.out.print("hell1");
	     
	     name=new JLabel();
	     name.setText("MSU AdEx-");
	     name.setForeground(Color.green);
	     name.setFont(f1);
	     name.setBounds(400,20,180,30);
	     
	        name1=new JLabel();
	     	name1.setText("Head");
	     	name1.setForeground(Color.blue);
	     	name1.setFont(f1);
	     	name1.setBounds(580,20,200,30);
	     	
	     	close=new JButton(); 
		    close.setBounds(10,10,30,30);
		    close.setBackground(Color.black);
		    close.setToolTipText("CLOSE");
		    close.setFocusable(false);
		    close.setBorder(new LineBorder(Color.blue));
		    
		    minimize=new JButton();
		    minimize.setBounds(50,10,30,30);
		    minimize.setBackground(Color.black);
		    minimize.setToolTipText("MINIMIZE");
		    minimize.setFocusable(false);
		    minimize.setBorder(new LineBorder(Color.blue));
		   
	     
	     	    m1=new JLabel();
			    m1.setIcon(new ImageIcon("img//menu.png"));
			    m1.setBounds(1000,20,60,60);
			    
			    m2=new JLabel();
			    m2.setIcon(new ImageIcon("img//menu1.png"));
			    m2.setBounds(1000,20,60,60);
			    m2.setVisible(false);
			    
			    logo=new JLabel();
			    logo.setIcon(new ImageIcon("img//icon2.png"));
			    logo.setBounds(250,0,100,60);
			    
			    logout=new JButton();
			    logout.setText("LOGOUT");
			    logout.setBackground(Color.green);
			    logout.setForeground(Color.black);
			    logout.setBorder(new LineBorder(Color.blue,1));
			    logout.setFocusable(false);
			    logout.setToolTipText("LOGOUT");
			    logout.setBounds(1080,25,100,20);
			    logout.setFont(f2);
			    
			    
			    
			     fact=new JLabel();
			     fact.setText(fact1);
			     fact.setForeground(Color.green);
			     fact.setFont(f2);
			     fact.setBounds(300,60,450,20);
			     
			     event=new JLabel();
			     event.setText(e);
			     event.setForeground(Color.green);
			     event.setFont(f1);
			     event.setBounds(400,90,200,30);
			     
			        add(name);
				    add(name1);
				    add(minimize);
				    add(close);
				    add(m1);
				    add(m2);
				    add(logout);
				    add(logo);  add(fact);  add(event);
			  
			     
			  
	   
		   
	 }

	 
 }
