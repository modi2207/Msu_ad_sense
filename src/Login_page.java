import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;


 class Login_page extends JFrame implements ActionListener,MouseListener
{
	  JPanel tp,mp;
	  Container con;
	  JButton sub,res;
	  Font f,f1;
	  JButton minimize,close;
	  
	  JLabel lab,icon,user,pass;
	  JTextArea user_field,pass_field;
	  Admin_page ap;
	  Main2 ma;
	   Login_page(Main2 ma)
	   {
		   this.ma=ma;
		    
		    this.setBounds(750,150,350,400);
		    
		    setUndecorated(true);
		    this.setBackground(new Color(0,0,0,100));
		    con=getContentPane();
		    con.setLayout(null);
		    
		    tp=new JPanel();
		    tp.setBounds(0,0,350,100);
		    tp.setLayout(null);
		    tp.setBackground(new Color(0,0,0,100));
		    
		    f=new Font("Timesroman",Font.PLAIN,12);
		    f1=new Font("Timesroman",Font.PLAIN,20);
		    mp=new JPanel();
		    mp.setBounds(0,100,350,300);
		    mp.setBackground(new Color(0,0,0,100));
		    mp.setLayout(null);
		    
		    close=new JButton();
		    close.setBounds(2,2,20,20);
		    close.setBackground(Color.black);
		    close.setToolTipText("CLOSE");
		    close.setFocusable(false);
		    close.setBorder(new LineBorder(Color.blue));
		    
		    minimize=new JButton();
		    minimize.setBounds(25,2,20,20);
		    minimize.setBackground(Color.black);
		    minimize.setToolTipText("MINIMIZE");
		    minimize.setFocusable(false);
		    minimize.setBorder(new LineBorder(Color.blue));
		    
		    
		    lab=new JLabel();
		    lab.setText("LOGIN FOR ADMINISTRATOR AND HEAD OF EACH EVENT");
		    lab.setForeground(Color.white);;
		    lab.setFont(f);
		    lab.setBounds(0,10,350,12);
		    
		    sub=new JButton();
		    sub.setText("LOGIN");
		    sub.setBounds(30,220,100,30);
		    sub.setBackground(Color.blue);
		    sub.setBorder(new LineBorder(Color.red,1));
		    sub.setToolTipText("LOGIN");
		    sub.setFont(f1);
		    sub.setForeground(Color.white);
		    sub.setFocusable(false);
		    
		    res=new JButton();
		    res.setText("RESET");
		    res.setBounds(200,220,100,30);
		    res.setBackground(Color.blue);
		    res.setBorder(new LineBorder(Color.red,1));
		    res.setToolTipText("RESET");
		    res.setFont(f1);
		    res.setForeground(Color.white);
		    res.setFocusable(false);
		    
		    icon=new JLabel();
		    icon.setIcon(new ImageIcon("img//icon2.png"));
		    icon.setBounds(100,15,80,80);
		    
		    user=new JLabel();
		    user.setText("USER NAME:- ");
		    user.setFont(f1);
		    user.setForeground(Color.white);
		    user.setBounds(10,50,200,20);
		    
		    pass=new JLabel();
		    pass.setText("PASSWORD:- ");
		    pass.setFont(f1);
		    pass.setForeground(Color.white);
		    pass.setBounds(10,120,200,20);
		    
		    
		    
		  
		    user_field=new JTextArea();
		    user_field.setBackground(Color.black);
		    user_field.setBounds(10,80,300,30);
		    user_field.setForeground(Color.white);
		    user_field.setFont(f1);
		    user_field.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white));
		    
		    
		    pass_field=new JTextArea();
		    pass_field.setBackground(Color.black);
		    pass_field.setBounds(10,150,300,30);
		    pass_field.setForeground(Color.white);
		    pass_field.setFont(f1);
		    pass_field.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white));
		    
		    
		    minimize.addActionListener(this);
		    minimize.addMouseListener(this);
		    close.addActionListener(this);
		    close.addMouseListener(this);
		    sub.addMouseListener(this);
		    sub.addActionListener(this);
		    res.addMouseListener(this);
		    res.addActionListener(this);
		    
			
		    tp.add(close);
		    tp.add(minimize);
		    tp.add(icon);
		    
		    mp.add(lab);
		    mp.add(user);  
		    mp.add(user_field);
		    mp.add(pass_field);
		    mp.add(pass);
		    mp.add(sub);
		    mp.add(res);
		    con.add(tp);
		    con.add(mp);
	  }
	   
	   public void actionPerformed(ActionEvent ae)
	   {
		   if(ae.getSource().equals(minimize))
		   {
			     setState(this.ICONIFIED);
		   }
		   else if(ae.getSource().equals(close))
		   {
			    this.dispose();
		   }
		   else if(ae.getSource().equals(res))
		   {
			     user_field.setText("");
			     pass_field.setText("");
		   }
		   else if(ae.getSource().equals(sub))
		   {
			   Connection con;
			   try{
			   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			   con=DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=Msu_AdEx","sa","chirag2207");

			   Statement st,st1,st2,st3,st4;
			   st=con.createStatement();
			   st1=con.createStatement();
			   st2=con.createStatement();
			   st3=con.createStatement();
			   st4=con.createStatement();
			   ResultSet rs1=st.executeQuery("select count(*) from admin_master where username='"+user_field.getText()+"' and pword='"+pass_field.getText()+"'");
			   rs1.next(); 
		       int a=rs1.getInt(1);
			   int a1=0;
		       System.out.println("a: "+a);
		       String hj=user_field.getText();
		       int flag=0;
		       
		       for(int i=0;i<hj.length();i++)
		       {
		    	     char ch=hj.charAt(i);
		    	     if((ch>=65 && ch<=90) || (ch>=97 && ch<=122))
		    	     {
		    	    	   flag=1;
		    	     }
		       }
		       
		       if(flag==0)
		       {
			   ResultSet rs2=st1.executeQuery("select count(*) from head_master where h_id="+Integer.parseInt(user_field.getText())+" and h_pword='"+pass_field.getText()+"'");
			   rs2.next();
			   a1=rs2.getInt(1);
		       
			   System.out.println("a1: "+a1);
			   
			   String na=rs2.getString(1);
		       }
			   if(a==1)
			   {
				   
				    System.out.println("hey admin is there");
				   ap=new Admin_page(ma);
			//	   ap.setJMenuBar(ap.at.jmb);
				   ap.setVisible(true);
				   this.setVisible(false);
				   ma.setVisible(false);
				   
				   
			   }
			   else if(a1==1)
			   {
				    //System.out.print("hey head here");
				   ResultSet rs3=st2.executeQuery("select faculty_name from faculty where faculty_code=(select h_faculty from head_master where h_id="+Integer.parseInt(user_field.getText())+")");
				   ResultSet rs4=st3.executeQuery("select event_name from event where event_code=(select h_event from head_master where h_id="+Integer.parseInt(user_field.getText())+")");
				   //System.out.print("hey head here1");
				   ResultSet rs5=st4.executeQuery("select h_id,h_name,h_mno,h_email,h_pword from head_master where h_id="+Integer.parseInt(user_field.getText())); 
				   
				    rs3.next();  rs4.next(); rs5.next();
				    String fact=rs3.getString(1);
				    String event=rs4.getString(1);
				    int hid=rs5.getInt(1);
				    String hname=rs5.getString(2);
				    String hmno=rs5.getString(3);
				    String hemail=rs5.getString(4);
				    String hpword=rs5.getString(5);
				    
				     System.out.print("fact: "+fact+"  event: "+event);
				         ap=new Admin_page(ma,fact,event,hid,hname,hmno,hemail,hpword);
					//	   ap.setJMenuBar(ap.at.jmb);
						   ap.setVisible(true);
						   this.setVisible(false);
						   ma.setVisible(false);
						    
				      
			   }
			  
			   
			   
			   }
			   catch(Exception e)
			   {
				   
			   }
			   
		   }
	   }
	   
	   public void mouseClicked(MouseEvent me)
	   {
		    if(me.getSource().equals(minimize))
		    {
		    	minimize.setBackground(Color.black);
		    }
		    else if(me.getSource().equals(close))
		    {
		    	 close.setBackground(Color.black);
		    	 
		    }
		    else if(me.getSource().equals(sub))
		    {
		    	 sub.setBackground(Color.blue);
		    	 sub.setForeground(Color.white);
		    }
		    else if(me.getSource().equals(res))
		    {
		    	 res.setBackground(Color.blue);
		    	 res.setForeground(Color.white);
		    }

		   
	   }
	   
	   public void mouseEntered(MouseEvent me)
	   {
		     if(me.getSource().equals(minimize))
		     {
		    	   minimize.setBackground(Color.YELLOW);
		    	   
		     }
		     else if(me.getSource().equals(close))
		     {
		    	 close.setBackground(Color.red);
		     }
		     else if(me.getSource().equals(sub))
			    {
			    	 sub.setBackground(Color.green);
			    	 sub.setForeground(Color.black);
			    }
			    else if(me.getSource().equals(res))
			    {
			    	 res.setBackground(Color.green);
			    	 res.setForeground(Color.black);
			    }
	   }
	   
	   public void mousePressed(MouseEvent me)
	   {
		   
	   }
	  
	     public void mouseExited(MouseEvent me)
	     {
	    
	    	    if(me.getSource().equals(minimize))
			    {
			    	minimize.setBackground(Color.black);
			    }
			    else if(me.getSource().equals(close))
			    {
			    	 close.setBackground(Color.black);
			    }
			    else if(me.getSource().equals(sub))
			    {
			    	 sub.setBackground(Color.blue);
			    	 sub.setForeground(Color.white);
			    }
			    else if(me.getSource().equals(res))
			    {
			    	 res.setBackground(Color.blue);
			    	 res.setForeground(Color.white);
			    }
			
	     }
	     public void mouseReleased(MouseEvent me)
	     {
	    	 
	     }
	   
	  

}
