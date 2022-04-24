import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;


 class Admin_page extends JFrame implements ActionListener,MouseListener
 {
	 Admin_top at=null;
	 Admin_mid am;
	 Admin_Bottom ab;
	 Container con;
	 Main2 ma;
	 JTextArea jta1;
	 JScrollPane jsp1;
	 //JMenuBar jmb;
	 int flag=0;
	 Admin_page(Main2 ma)
	 {
		 flag=1;
		 this.ma=ma;
		 this.setSize(1200,800);
		 setUndecorated(true);
		 //setLayout(null);
		 con=getContentPane();
		 con.setLayout(null);
		 
		   at=new Admin_top();
		   con.add(at);

		   ab=new Admin_Bottom();
		 
		   jta1=new JTextArea(110,300);
		   jta1.setLayout(null);
		  
		   jsp1=new JScrollPane(jta1,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		   jsp1.setBounds(0,140,1200,630);
		  
		   con.add(jsp1);
		   jta1.add(ab);
		    
		   am=new Admin_mid();
		   con.add(am);
		  
		 
		    at.close.addActionListener(this);
		    at.minimize.addActionListener(this);
		    at.close.addMouseListener(this);
		    at.minimize.addMouseListener(this);
		    
		    at.m1.addMouseListener(this);
		    at.m2.addMouseListener(this);
		    am.jmt1.addActionListener(this);
		    am.jmt2.addActionListener(this);
		    am.jmt4.addActionListener(this);
		    am.jmt3.addActionListener(this);
		    am.jmt5.addActionListener(this);
		   am.jmt6.addActionListener(this);
		   at.logout.addActionListener(this);
		 
	 }
	 
	 Admin_page(Main2 ma,String fact,String event,int hid,String hname,String hmno,String hemail,String hpword)
	 {
		 this.ma=ma;
		 flag=2;
		 this.setSize(1200,800);
		 setUndecorated(true);
	     con=getContentPane();
		 con.setLayout(null);
		 
		   at=new Admin_top(fact,event);
	
		   con.add(at);

		   ab=new Admin_Bottom(fact,event,hid,hname,hmno,hemail,hpword);
		   
		   jta1=new JTextArea(110,300);
		   jta1.setLayout(null);
		  
		   jsp1=new JScrollPane(jta1,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		   jsp1.setBounds(0,155,1200,630);
		  
		   con.add(jsp1);
		   jta1.add(ab);
		    
		   am=new Admin_mid(1);
		   
		   con.add(am);
		  
		 
		    at.close.addActionListener(this);
		    at.minimize.addActionListener(this);
		    at.close.addMouseListener(this);
		    at.minimize.addMouseListener(this);
		    
		    at.m1.addMouseListener(this);
		    at.m2.addMouseListener(this);
		  //  am.jmt1.addActionListener(this);
		   // am.jmt2.addActionListener(this);
		    am.jmt8.addActionListener(this);
		    am.jmt4.addActionListener(this);
		    am.jmt3.addActionListener(this);
		    am.jmt5.addActionListener(this);
		 //   am.jmt6.addActionListener(this);
		    am.jmt7.addActionListener(this);
		    
		   at.logout.addActionListener(this);  
		  
	 }
	 public void mouseClicked(MouseEvent me)
	   {
		    if(me.getSource().equals(at.minimize))
		    {
		    	at.minimize.setBackground(Color.black);
		    }
		    else if(me.getSource().equals(at.close))
		    {
		    	 at.close.setBackground(Color.black);
		    	 
		    }
		    else if(me.getSource().equals(at.m1))
		    {
		    	 at.m2.setVisible(true);
		    	 at.m1.setVisible(false);
		    	 am.jmb1.setVisible(true);
		   	    }
		    else if(me.getSource().equals(at.m2))
		    {
		    	 at.m1.setVisible(true);
		    	 at.m2.setVisible(false);
		    	 am.jmb1.setVisible(false);
		    	 ab.ae.setVisible(false);
		    	 ab.ap.setVisible(false);
		    	 ab.de.setVisible(false);
		    	 ab.dp.setVisible(false);
		    	 ab.hr.setVisible(false);
		    	 ab.mp.setVisible(false);
		    	 ab.g.setVisible(true);
		    }
		    

		   
	   }
	   
	   public void mouseEntered(MouseEvent me)
	   {
		     if(me.getSource().equals(at.minimize))
		     {
		    	   at.minimize.setBackground(Color.YELLOW);
		    	   
		     }
		     else if(me.getSource().equals(at.close))
		     {
		    	 at.close.setBackground(Color.red);
		     }
		     		     
	   }
	   
	   public void mousePressed(MouseEvent me)
	   {
		   
	   }
	  
	     public void mouseExited(MouseEvent me) 
	     {
	    
	    	    if(me.getSource().equals(at.minimize))
			    {
			    	at.minimize.setBackground(Color.black);
			    }
			    else if(me.getSource().equals(at.close))
			    {
			    	 at.close.setBackground(Color.black);
			    }
			    
			
	     }
	     public void mouseReleased(MouseEvent me)
	     {
	    	 
	     }
	   
	  

	 
	 public void actionPerformed(ActionEvent ae)
	 {
		 
		    if(ae.getSource().equals(at.minimize))
		    {
		    	 setState(this.ICONIFIED);
		    }
		    else if(ae.getSource().equals(at.close))
		    {
		    	 this.dispose();
		    }
		    else if(ae.getSource().equals(at.logout))
		    {
		    	this.setVisible(false);
		    	ma.setVisible(true);
		    }
		    else if(ae.getSource().equals(am.jmt1))
		    {
		    	 
		    	    ab.ae.setVisible(true);
		    	    ab.ap.setVisible(false);
		    	    ab.de.setVisible(false);
		    	    ab.mp.setVisible(false);
		    	    ab.dp.setVisible(false);
		    	    ab.hr.setVisible(false);
		    	    ab.g.setVisible(false);
		    	    
		    }
		    else if(ae.getSource().equals(am.jmt2))
		    {

		    	  ab.de.setVisible(true);
		    	  ab.ae.setVisible(false);
		    	  ab.ap.setVisible(false);
		    	  ab.mp.setVisible(false);
		    	  ab.dp.setVisible(false);  	
		    	  ab.hr.setVisible(false);
		    	  ab.g.setVisible(false);
		    	
		     }
		    else if(ae.getSource().equals(am.jmt3) && flag==1)
		    {
		    	 ab.ap.setVisible(true);
		    	 ab.de.setVisible(false);
		    	 ab.ae.setVisible(false);
		    	 ab.mp.setVisible(false);
		    	 ab.dp.setVisible(false);
		    	 ab.hr.setVisible(false);
		    	 ab.g.setVisible(false);
		    	  //ab.ac.setVisible(false);
		    	  //ab.rs.setVisible(false);
		    
		    }
		    else if(ae.getSource().equals(am.jmt3) && flag==2)
		    {
		    	 ab.ap.setVisible(true);
		    	// ab.de.setVisible(false);
		    	 //ab.ae.setVisible(false);
		    	 ab.mp.setVisible(false);
		    	 ab.dp.setVisible(false);
		    	 //ab.hr.setVisible(false);
		    	 ab.g.setVisible(false);
		    	 ab.ac.setVisible(false);
		    	  ab.rs.setVisible(false);
		    
		    }
		    else if(ae.getSource().equals(am.jmt4) && flag==1)
		    {
		    	//System.out.print("hello");
		    	ab.mp.setVisible(true);
		    	ab.ap.setVisible(false);
		    	 ab.de.setVisible(false);
		    	 ab.ae.setVisible(false);
		    	 ab.dp.setVisible(false);
		    	  ab.hr.setVisible(false);
		    	  ab.g.setVisible(false);
		    	  //ab.ac.setVisible(false);
		    	  //ab.rs.setVisible(false);
		    
		 
		    }
		    else if(ae.getSource().equals(am.jmt4) && flag==2)
		    {
		    	//System.out.print("hello");
		    	ab.mp.setVisible(true);
		    	ab.ap.setVisible(false);
		    	// ab.de.setVisible(false);
		    	 //ab.ae.setVisible(false);
		    	 ab.dp.setVisible(false);
		    	  //ab.hr.setVisible(false);
		    	  ab.g.setVisible(false);
		    	  ab.ac.setVisible(false);
		    	  ab.rs.setVisible(false);
		    
		 
		    }
		 
		    else if(ae.getSource().equals(am.jmt5) && flag==1)
		    {
		     	ab.dp.setVisible(true);
		    	ab.ap.setVisible(false);
		    	 ab.de.setVisible(false);
		    	 ab.ae.setVisible(false);
		    	 ab.mp.setVisible(false);
		    	  ab.hr.setVisible(false);
		    	  ab.g.setVisible(false);
		    	 // ab.ac.setVisible(false);
		    	  //ab.rs.setVisible(false);
		    
		    }
		    else if(ae.getSource().equals(am.jmt5) && flag==2)
		    {
		     	ab.dp.setVisible(true);
		    	ab.ap.setVisible(false);
		    	// ab.de.setVisible(false);
		    	// ab.ae.setVisible(false);
		    	 ab.mp.setVisible(false);
		    	 // ab.hr.setVisible(false);
		    	  ab.g.setVisible(false);
		    	  ab.ac.setVisible(false);
		    	  ab.rs.setVisible(false);
		    
		    }
		   
		    else if(ae.getSource().equals(am.jmt6))
		    {
		    	ab.hr.setVisible(true);
		    	ab.ap.setVisible(false);
		    	 ab.de.setVisible(false);
		    	 ab.ae.setVisible(false);
		    	 ab.mp.setVisible(false);
		    	  ab.dp.setVisible(false);
		    	  ab.g.setVisible(false);
		    	 //ab.ac.setVisible(false);
		    	  //ab.rs.setVisible(false);
		    }
		    else if(ae.getSource().equals(am.jmt7))
		    {
		    	 ab.ac.setVisible(true);
		    	 ab.hr.setVisible(false);
			    	ab.ap.setVisible(false);
			    	// ab.de.setVisible(false);
			    	// ab.ae.setVisible(false);
			    	 ab.mp.setVisible(false);
			    	  ab.dp.setVisible(false);
			    	  ab.g.setVisible(false);
			    	  ab.rs.setVisible(false);
			    	 
		    	
		    }
		    else if(ae.getSource().equals(am.jmt8))
		    {
		    	ab.rs.setVisible(true);
		    	ab.ac.setVisible(false);
		    	 ab.hr.setVisible(false);
			    	ab.ap.setVisible(false);
			    	// ab.de.setVisible(false);
			    	// ab.ae.setVisible(false);
			    	 ab.mp.setVisible(false);
			    	  ab.dp.setVisible(false);
			    	  ab.g.setVisible(false);
			       
		    	
		    }
		    
	 }

}
