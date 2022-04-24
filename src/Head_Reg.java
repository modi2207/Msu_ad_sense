import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


class Head_Reg extends JPanel implements ActionListener
{
	JLabel hname,hmno,hemail,hfaculty,hevent,hid,pword1,pword2,jname,jpword,jmno,jemail,jfaculty,jevent;
	
	JTextField jhname,jhmno,jhemail,jhid;
	JComboBox faculty_jcb,event_jcb;
	JPasswordField jp1,jp2;
	Random r;
	JButton sub,res;
	Font f1,f2,f3;
	String na,na1;
	Head_Reg()
	{
		  this.setBackground(Color.black);
		  this.setBounds(0,0,1200,1400);
		  this.setLayout(null);
		  
		  f1=new Font("Timesroman",Font.PLAIN,20);
		   f2=new Font("Timesroman",Font.PLAIN,15);
		   f3=new Font("Aerial",Font.PLAIN,15);
			
		    r=new Random();
		  
		    int h=r.nextInt(999999-99999)+99999;
		    
		   hname=new JLabel();
		   hname.setText("Head Name:- ");
		   hname.setForeground(Color.white);
		   hname.setBounds(100,100,300,20);
		   hname.setFont(f1);
		   
		   hmno=new JLabel();
		   hmno.setText("Mobile Number:- ");
		   hmno.setForeground(Color.white);
		   hmno.setBounds(100,150,300,20);
		   hmno.setFont(f1);
		   
		   hemail=new JLabel();
		   hemail.setText("Email_ID:- ");
		   hemail.setForeground(Color.white);
		   hemail.setBounds(100,200,300,20);
		   hemail.setFont(f1);
		   
		   hfaculty=new JLabel();
		   hfaculty.setText("Faculty Name:- ");
		   hfaculty.setForeground(Color.white);
		   hfaculty.setBounds(100,250,300,20);
		   hfaculty.setFont(f1);
		   
		   hevent=new JLabel();
		   hevent.setText("Event Name:- ");
		   hevent.setForeground(Color.white);
		   hevent.setBounds(100,300,300,20);
		   hevent.setFont(f1);
		   
		   hid=new JLabel();
		   hid.setText("User Name:- ");
		   hid.setForeground(Color.white);
		   hid.setBounds(100,350,300,20);
		   hid.setFont(f1);
		   
		   
		   pword1=new JLabel();
		   pword1.setText("Enter Password:- ");
		   pword1.setForeground(Color.white);
		   pword1.setBounds(100,400,300,20);
		   pword1.setFont(f1);
		   
		   pword2=new JLabel();
		   pword2.setText("Confirm Password:- ");
		   pword2.setForeground(Color.white);
		   pword2.setBounds(100,450,300,20);
		   pword2.setFont(f1);
		   
		   jname=new JLabel("PLEASE FILL NAME FIELD");
	       jname.setForeground(Color.red);
	       jname.setFont(f3);
	       jname.setBounds(680,100,300,20);
	       jname.setVisible(false);
	       
	       jpword=new JLabel("PLEASE PASSWORD FIELD");
	       jpword.setForeground(Color.red);
	       jpword.setFont(f3);
	       jpword.setBounds(680,400,300,20);
	       jpword.setVisible(false);
	      
	      
	       jmno=new JLabel("PLEASE FILL MOBILE NUMBER FIELD");
	       jmno.setForeground(Color.red);
	       jmno.setFont(f3);
	       jmno.setBounds(680,150,300,20);
	       jmno.setVisible(false);
	      
	       jemail=new JLabel("PLEASE FILL EMAIL_ID FIELD");
	       jemail.setForeground(Color.red);
	       jemail.setFont(f3);
	       jemail.setBounds(680,200,300,20);
	       jemail.setVisible(false);
	      
	       jfaculty=new JLabel("PLEASE SELECT FACULTY");
	       jfaculty.setForeground(Color.red);
	       jfaculty.setFont(f3);
	       jfaculty.setBounds(780,250,300,20);
	       jfaculty.setVisible(false);
	      
	       jevent=new JLabel("PLEASE FILL EVENT");
	       jevent.setForeground(Color.red);
	       jevent.setFont(f3);
	       jevent.setBounds(780,300,300,20);
	       jevent.setVisible(false);
	      
		   jp1=new JPasswordField();
		   jp1.setBounds(450,400,200,20);
		   jp1.setForeground(Color.white);
		   jp1.setBackground(Color.black);
		   jp1.setBorder(new LineBorder(Color.white,1));   
		  
		   jp2=new JPasswordField();
		   jp2.setBounds(450,450,200,20);
		   jp2.setForeground(Color.white);
		   jp2.setBackground(Color.black);
		   jp2.setBorder(new LineBorder(Color.white,1));   
		  
		    jhname=new JTextField();
		   	jhname.setBackground(Color.black);
		   	jhname.setForeground(Color.white);
		   	jhname.setFont(f2);
		   	jhname.setBounds(450,100,200,20);
		   	jhname.setBorder(new LineBorder(Color.white,1));
		   
		   	jhmno=new JTextField();
		   	jhmno.setBackground(Color.black);
		   	jhmno.setForeground(Color.white);
		   	jhmno.setFont(f2);
		   	jhmno.setBounds(450,150,200,20);
		   	jhmno.setBorder(new LineBorder(Color.white,1));
		   
		   	jhemail=new JTextField();
		   	jhemail.setBackground(Color.black);
		   	jhemail.setForeground(Color.white);
		   	jhemail.setFont(f2);
		   	jhemail.setBounds(450,200,200,20);
		   	jhemail.setBorder(new LineBorder(Color.white,1));
		   	
		   	jhid=new JTextField();
		   	jhid.setBackground(Color.black);
		   	jhid.setForeground(Color.white);
		   	jhid.setFont(f2);
		   	jhid.setBounds(450,350,200,20);
		   	jhid.setBorder(new LineBorder(Color.white,1));
		    jhid.setEnabled(false);
		    jhid.setText(""+h);
		   	
		   	   faculty_jcb=new JComboBox();
	    	   faculty_jcb.setForeground(Color.WHITE);
	    	   faculty_jcb.setBackground(Color.black);
	    	   faculty_jcb.setFont(f2);
	    	   faculty_jcb.setBounds(450,250,300,20);
	    	   
	    	   event_jcb=new JComboBox();
	    	   event_jcb.setForeground(Color.WHITE);
	    	   event_jcb.setBackground(Color.black);
	    	   event_jcb.setFont(f2);
	    	   event_jcb.setBounds(450,300,300,20);
	    	   event_jcb.setEnabled(false);
	    	   
	    	   sub=new JButton();
				sub.setBounds(260,500,100,20);
				sub.setText("Submit");
				sub.setFont(f2);
				sub.setBackground(Color.black);
				sub.setForeground(Color.white);
				sub.setBorder(new LineBorder(Color.white,1));
				sub.setFocusable(false);
				
				res=new JButton();
				res.setBounds(400,500,100,20);
				res.setText("Reset");
				res.setFont(f2);
				res.setBackground(Color.black);
				res.setForeground(Color.white);
				res.setBorder(new LineBorder(Color.white,1));
				res.setFocusable(false);
				
				File f=new File("c:\\proj_java");
				String ch[]=f.list();
				faculty_jcb.addItem("---SELECT FACULTY---");
				event_jcb.addItem("---SELECT EVENT---");
				
				for(int i=0;i<ch.length;i++)
				{
					  faculty_jcb.addItem(ch[i]);
				}
				
		   
		   add(faculty_jcb);  add(event_jcb);  add(hid);  add(hname);  add(hemail);  add(hmno);
		   add(hfaculty); add(hevent);  add(jhid); add(jhname);  add(jhmno);  add(jhemail);
		   add(sub); add(res);  add(jp1);  add(jp2); add(pword1); add(pword2); add(jname);
		   add(jmno); add(jemail);  add(jfaculty); add(jevent); add(jpword);
		
		    faculty_jcb.addActionListener(this);
		    sub.addActionListener(this);
		    event_jcb.addActionListener(this);
		    res.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		try{
		if(ae.getSource().equals(faculty_jcb))
		{
			   na=faculty_jcb.getSelectedItem().toString();
			   File f1=new File("c:\\proj_java\\"+na);
			   String gh[]=f1.list();
			   event_jcb.setEnabled(true);
			   
			   event_jcb.removeAllItems();
			   event_jcb.addItem("---SELECT EVENT---");
			   
			   for(int i=0;i<gh.length;i++)
			   {
				      event_jcb.addItem(gh[i]);
			   }
			    
			   
		}
		else if(ae.getSource().equals(sub))
		{
			 int flag=0;
			 
			String st1,st2,st3;
			st1=jhname.getText();
			st2=jhmno.getText();
			st3=jhemail.getText();
			
		  jname.setVisible(false);
		  jmno.setVisible(false);
		  jemail.setVisible(false);
		  jfaculty.setVisible(false);
		  jevent.setVisible(false);
		  jpword.setVisible(false);
		  
		  faculty_jcb.setBorder(new LineBorder(Color.white,1));
		  event_jcb.setBorder(new LineBorder(Color.white,1));
		  jhname.setBorder(new LineBorder(Color.white,1));
		  jhmno.setBorder(new LineBorder(Color.white,1));
		  jhemail.setBorder(new LineBorder(Color.white,1));
		  jp1.setBorder(new LineBorder(Color.white,1));
		  
			
			if(faculty_jcb.getSelectedIndex()==0)
			{
				     jfaculty.setVisible(true);
				     faculty_jcb.setBorder(new LineBorder(Color.red,1));
				     flag=1;
				     
			}
			if(event_jcb.getSelectedIndex()==0)
			{
				flag=1;
				jevent.setVisible(true);
		     event_jcb.setBorder(new LineBorder(Color.red,1));
		    }
			if(st1.equals(""))
			{
				 flag=1;
				  jname.setVisible(true);
				  jhname.setBorder(new LineBorder(Color.red,1));
			}
			if(st2.equals(""))
			{
				 flag=1;
				  jmno.setVisible(true);
				  jhmno.setBorder(new LineBorder(Color.red,1));
			}if(st3.equals(""))
			{
				 flag=1;
				  jemail.setVisible(true);
				  jhemail.setBorder(new LineBorder(Color.red,1));
			}
			
		  String x=jp1.getText();
		  String y=jp2.getText();
		  if(!x.equals(y))
		  {
			 // JOptionPane.showMessageDialog(this,"PASSWORD MISMATCH","Alert",JOptionPane.WARNING_MESSAGE);
			 	
			  flag=1;
			  final JOptionPane pane = new JOptionPane("PASSWORD MISMATCH");
			    final JDialog d = pane.createDialog((JFrame)null, "Alert");
			    d.setLocation(300,300);
			    d.setVisible(true);

		  }
		  if(x.equals(""))
		  {
			   flag=1;
			  jpword.setVisible(true);
			  jp1.setBorder(new LineBorder(Color.red,1));
		
			     
		  }
		  
		  if(flag==0)
		  {
			    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        	Connection con1=DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=Msu_AdEx","sa","chirag2207");
			    
	        	Statement st=con1.createStatement();
	        	Statement st4=con1.createStatement();
	        	Statement st5=con1.createStatement();
	        	Statement st6=con1.createStatement();
	        	
	        	ResultSet rs1=st4.executeQuery("select faculty_code from faculty where faculty_name='"+faculty_jcb.getSelectedItem().toString()+"'");
	        	rs1.next();
	        	int y1=rs1.getInt(1);
	        	
	        	ResultSet rs2=st5.executeQuery("select event_code from event where event_name='"+event_jcb.getSelectedItem().toString()+"'");
	        	rs2.next();
	        	int y2=rs2.getInt(1);
	        	
	        	ResultSet rs3=st6.executeQuery("select count(*) from head_master where h_event="+y2);
	        	rs3.next();
	        	int y3=rs3.getInt(1);
	        	
	        	if(y3==0)
	        	{
	        	st.executeUpdate("insert into head_master values("+Integer.parseInt(jhid.getText())+",'"+jhname.getText()+"','"+jhmno.getText()+"','"+jhemail.getText()+"',"+y1+","+y2+",'"+jp1.getText()+"')");
	        	}
	        	else
	        	{
	        		st.executeUpdate("update head_master set h_id="+Integer.parseInt(jhid.getText())+",h_name='"+jhname.getText()+"',h_mno='"+jhmno.getText()+"',h_email='"+jhemail.getText()+"',h_faculty="+y1+",h_pword='"+jp1.getText()+"' where h_event="+y2+"");
	        		
		        		
	        	}
	        	System.out.print("email:"+jhemail.getText());
	        	SendMailSSL sml=new SendMailSSL(jhname.getText(),jhemail.getText(),faculty_jcb.getSelectedItem().toString(),event_jcb.getSelectedItem().toString(),Integer.parseInt(jhid.getText()),jp1.getText());
	        	sml.sendotp1();
	        	
			  final JOptionPane pane = new JOptionPane("Registration is Done");
			    final JDialog d = pane.createDialog((JFrame)null, "information");
			    d.setLocation(300,300);
			    d.setVisible(true);
   
		  }
			   
		}
		else if(ae.getSource().equals(res))
		{
			jhname.setText("");
			jhmno.setText("");
			jhemail.setText("");
			jp1.setText("");
			jp2.setText("");
			faculty_jcb.setSelectedIndex(0);
			event_jcb.setSelectedIndex(0);
			
			int h=r.nextInt(999999-99999)+99999;
			
			jhid.setText(""+h);
			
			   
		}
		
		}
		catch(Exception e)
		{
			  
		}
	}

}
