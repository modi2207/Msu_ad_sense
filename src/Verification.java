import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;



class Verification extends JFrame implements ActionListener,MouseListener
{
	JPanel tp,main;
	JButton sb;
	Container con;
	JButton close,minimize;
	JTextField fd1,fd2,fd3,fd4;
     JLabel otp,pass,fail,resend,google,tl,jl;
     Font f;
     SendMailSSL s;
    // CountdownTimer cdt;
     Font f1,f2;
     int no;
     JLabel blink;
    JButton confirm;
     String s1,s2;
      
	Verification()
	{
//		this.no=no;
//		s1=na;
//		s2=email;
		con=getContentPane();
		con.setLayout(null);
        setUndecorated(true);		
		tp=new JPanel();
		tp.setBounds(0,0,400,50);
		tp.setBackground(Color.blue);
		
		f1=new Font("Aerial",Font.PLAIN,20);
		main=new JPanel();
        main.setBackground(Color.DARK_GRAY);
		main.setBounds(0,50,400,250);
		close=new JButton();
	       close.setBounds(0,0,30,30);
	       close.setBorder(new LineBorder(Color.red,1));
	       close.setActionCommand("cl");
	       close.setFocusable(false);
	       close.setBackground(Color.black);
	       close.setToolTipText("CLOSE");
	       
	       
	       
	       minimize=new JButton();
	       minimize.setBounds(40,0,30,30);
	       minimize.setBorder(new LineBorder(Color.YELLOW,1));
	       minimize.setActionCommand("mm");
	       minimize.setFocusable(false);
	       minimize.setBackground(Color.black);
	       minimize.setToolTipText("MINIMIZE");

	       otp=new JLabel("ENTER OTP:- ");
	       otp.setFont(f1);
	       otp.setForeground(Color.white);
	       otp.setBounds(30,30,150,20);
	       
	       f2=new Font("Aerial",Font.PLAIN,15);
	       fd1=new JTextField();
	       fd1.setBorder(new LineBorder(Color.black,1));
	       fd1.setBounds(220,30,30,30);
	       
	       fd2=new JTextField();
	       fd2.setBorder(new LineBorder(Color.black,1));
	       fd2.setBounds(260,30,30,30);
	       
	       fd3=new JTextField();
	       fd3.setBorder(new LineBorder(Color.black,1));
	       fd3.setBounds(300,30,30,30);
	       
	       fd4=new JTextField();
	       fd4.setBorder(new LineBorder(Color.black,1));
	       fd4.setBounds(340,30,30,30);
	       
	       pass=new JLabel();
	       pass.setText("VERIFICATION IS DONE!");
	       pass.setForeground(Color.green);
	       pass.setBounds(50,150,200,20);
	       pass.setVisible(false);
	       
	       fail=new JLabel();
	       fail.setText("OOPS OTP IS NOT VERIFIED!");
	       fail.setForeground(Color.red);
	       fail.setBounds(50,150,200,20);
	       fail.setVisible(false);

	       
	       sb=new JButton();
	       sb.setText("SUBMIT");
	       sb.setBorder(new LineBorder(Color.black,1));
	       sb.setBounds(50,100,100,20);
           sb.setActionCommand("sb");
           sb.setFocusable(false);
           sb.setBackground(Color.BLUE);
	       
           resend=new JLabel();
           resend.setText("Resend OTP");
           resend.setForeground(Color.white);
           resend.setFont(f2);
           resend.setBounds(50,180,200,20);
           
//           google=new JLabel();
//           google.setText("GOOGLE");
//           google.setForeground(Color.blue);
//           google.setBounds(50,210,200,20);
//           
          //  cdt.setEnabled(false);
          
          
           f=new Font("Aerial",Font.PLAIN,10);
            tl=new JLabel("TIME LEFT:- ");
		    tl.setBounds(180,100,100,20);
		    tl.setFont(f);
	        tl.setForeground(Color.white);
	        
		     
       jl=new JLabel("OTP IS EXPIRED");
	         jl.setFont(f);
	         jl.setForeground(Color.white);
	         jl.setBounds(180,100,150,20);
	         jl.setVisible(false);
	         
	           confirm=new JButton();
		       confirm.setText("CONFIRM");
		       confirm.setBorder(new LineBorder(Color.black,1));
		       confirm.setBounds(280,180,100,30);
	           confirm.setActionCommand("confirm");
	           confirm.setFocusable(false);
	           confirm.setBackground(Color.BLUE);
	           confirm.setVisible(false);
	           confirm.setEnabled(false);
		       
	         
		tp.setLayout(null);
		main.setLayout(null);
		main.add(otp);
		main.add(fd1);
		main.add(fd2);
		main.add(fd3);
		main.add(fd4);
		main.add(sb);
		main.add(pass);
		main.add(fail);
		main.add(resend);
		//main.add(google);
	//	main.add(cdt);
		main.add(tl);
		main.add(jl);
		main.add(confirm);
	
		tp.add(close);
		tp.add(minimize);
		
		con.add(tp);
		con.add(main);
		
		
		 close.addMouseListener(this);
		 minimize.addMouseListener(this);
		close.addActionListener(this);
		minimize.addActionListener(this);
		sb.addActionListener(this);
		resend.addMouseListener(this);
	
		//confirm.addActionListener(this);
		
	}
	
	public void send(int no,String s1,String s2)
	
	{
		
		  this.s1=s1;
		  this.s2=s2;
		  this.no=no;
		 CountdownTimer cdt=new CountdownTimer(0,60,this);
          cdt.setBounds(300,100,50,20);
         main.add(cdt);
         cdt.setFont(f);
	       cdt.setForeground(Color.white);
		 
         
		 //cdt.setEnabled(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource().equals(close))
		{
			
			this.dispose();
		}
		else if(ae.getSource().equals(minimize))
		{
			  setState(this.ICONIFIED);
		}
		else if(ae.getSource().equals(sb))
		{
			  int s=Integer.parseInt(fd1.getText())*1000+Integer.parseInt(fd2.getText())*100+Integer.parseInt(fd3.getText())*10+Integer.parseInt(fd4.getText());
			  
			  if(s==no)
			  {
				  pass.setVisible(true);
				  fail.setVisible(false);
				  
				  confirm.setVisible(true);
				  confirm.setEnabled(true);
				  
				   
			  }
			  else
			  {
				  fail.setVisible(true);
				  pass.setVisible(false);
			  }
			 
			 
		}
		
		
		
	}
	
	public void mouseEntered(MouseEvent me)
	{
		if(me.getSource().equals(resend))
		{
			
			 resend.setFont(f1);
			 
		}
		
		else if(me.getSource().equals(close))
		{
			close.setBackground(Color.red);
		}
		else if(me.getSource().equals(minimize))
		{
			minimize.setBackground(Color.yellow);
		}
	}
	public void mouseClicked(MouseEvent me)
	{
		
		 if(me.getSource().equals(resend))
		 {
			 fd1.setText("");
			 fd2.setText("");
			 fd3.setText("");
			 fd4.setText("");
			 s=new SendMailSSL(s1,s2);
		      no=s.sendOtp();	
		     // cdt.setVisible(false);
		      tl.setVisible(true);
		      CountdownTimer cdt1 = new CountdownTimer(0,60,this);
		      cdt1.setFont(f);
		       cdt1.setForeground(Color.white);
		       jl.setVisible(false);
	           cdt1.setBounds(300,100,50,20);
	           main.add(cdt1);
	           
		      
	           
		 }
		 else if(me.getSource().equals(google))
		 {
			 try
			 {
				 Desktop.getDesktop().browse(new URI("http://www.google.com"));
			 }
			 catch(Exception e)
			 {
				 
			 }
		 }
	}
	public void mousePressed(MouseEvent me)
	{
		
	}
	public void mouseReleased(MouseEvent me)
	{
		
	}
	public void mouseExited(MouseEvent me)
	{
		   
		
		if(me.getSource().equals(close))
		{
			close.setBackground(Color.black);
		}
		else if(me.getSource().equals(minimize))
		{
			minimize.setBackground(Color.black);
		}
		else if(me.getSource().equals(resend))
		{
			 resend.setFont(f2);
		}
	}
}
