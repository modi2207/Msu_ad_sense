import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;




class Form extends JFrame implements ActionListener,MouseListener,ItemListener
{
	Container con;
	JLabel full_name,add,mno,email,faculty,event,s_event,title,fee,No_per,bdate,jk;
	JTextArea text_name,text_add,text_mno,text_email,text_fee;
	JComboBox<String> jcb_faculty,jcb_event,jcb_sevent;
	String na1,jh;
	JLabel inst_name,inst_mno,inst_email,inst_add,inst_date;
	JLabel logo2;
	JLabel logo,logo1;
	int no;
	Connection con1;
	JDateChooser jdc;  
	int i=0;
	SendMailSSL s;
    JPanel main,top,top1;
    Verification v1;
	JCheckBox c1;
	Statement st1,st2;
	JButton close,minimize,submit;
	Font f1,f2,f3;
	
	Form()
	{
		
		con=getContentPane();
		con.setLayout(null);
		con.setBackground(Color.black);
		
		setUndecorated(true);
		
		main=new JPanel();
		main.setBounds(0,100,1200,700);
		main.setBackground(Color.black);
		main.setLayout(null);
       
		f1=new Font("TimesRoman",Font.BOLD,40);
		f2=new Font("Aerial",Font.PLAIN,20);
		f3=new Font("Aerial",Font.PLAIN,15);
		
		
        top=new JPanel();
        top.setLayout(null);
        top.setBounds(0,0,1200,100);
        top.setBackground(Color.DARK_GRAY);
       
        top1=new JPanel();
        top1.setLayout(null);
        top1.setBounds(0,0,1200,30);
        top1.setBackground(Color.blue);
      
       
       close=new JButton();
       close.setBounds(0,0,30,30);
       close.setBorder(new LineBorder(Color.red,1));
       close.setActionCommand("cl");
       close.setFocusable(false);
       close.setBackground(Color.DARK_GRAY);
       close.setToolTipText("CLOSE");
       
       
       
       minimize=new JButton();
       minimize.setBounds(40,0,30,30);
       minimize.setBorder(new LineBorder(Color.YELLOW,1));
       minimize.setActionCommand("mm");
       minimize.setFocusable(false);
       minimize.setBackground(Color.DARK_GRAY);
       minimize.setToolTipText("MINIMIZE");
       
       
       title=new JLabel();
       title.setText("REGISTRATION FORM");
       title.setForeground(Color.white);
       title.setFont(f1);
       title.setBounds(400,40,600,50);
        
       full_name=new JLabel();
       full_name.setText("FULL NAME:-");
       full_name.setForeground(Color.white);
       full_name.setFont(f2);
       full_name.setFocusable(true);
       full_name.setBounds(330,30,200,30);
       
       
       add=new JLabel();
       add.setText("ADDRESS:- ");
       add.setForeground(Color.white);
       add.setFont(f2);
       add.setBounds(330,80,200,30);
      
       mno=new JLabel();
       mno.setText("MOBILE NUMBER:- ");
       mno.setForeground(Color.white);
       mno.setFont(f2);
       mno.setBounds(330,130,200,30);

       email=new JLabel();
       email.setText("EMAIL_ID:- ");
       email.setForeground(Color.white);
       email.setFont(f2);
       email.setBounds(330,180,200,30);

        bdate=new JLabel(); 
        bdate.setText("BIRTH_DATE");
        bdate.setFont(f2);
        bdate.setForeground(Color.WHITE);
        bdate.setBounds(330,230,200,30);
        
       faculty=new JLabel();
       faculty.setText("SELECT FACULTY:- ");
       faculty.setForeground(Color.white);
       faculty.setFont(f2);
       faculty.setBounds(330,280,200,30);

       event=new JLabel();
       event.setText("SELECT EVENT:- ");
       event.setForeground(Color.white);
       event.setFont(f2);
       event.setBounds(330,330,200,30);
 
       
       s_event=new JLabel();
       s_event.setText("SELECT SUB EVENT:- ");
       s_event.setForeground(Color.white);
       s_event.setFont(f2);
       s_event.setBounds(330,380,250,30);
       
       fee=new JLabel();
       fee.setText("REGISTRATION FEE:- ");
       fee.setFont(f2);
       fee.setForeground(Color.WHITE);
       fee.setBounds(330,430,250,30);
       
      
       
       text_name=new JTextArea();
       text_name.setBorder(new LineBorder(Color.black,1));
       text_name.setBounds(550,30,200,20);
       
       text_add=new JTextArea();
       text_add.setBorder(new LineBorder(Color.black,1));
       text_add.setBounds(550,80,200,30);
       
       text_mno=new JTextArea();
       text_mno.setBorder(new LineBorder(Color.black,1));
       text_mno.setBounds(550,130,200,20);
      
       text_email=new JTextArea();
       text_email.setBorder(new LineBorder(Color.black,1));
       text_email.setBounds(550,180,200,20);
       
       inst_name=new JLabel("PLEASE FILL NAME FIELD");
       inst_name.setForeground(Color.red);
       inst_name.setFont(f3);
       inst_name.setBounds(780,30,300,20);
       inst_name.setVisible(false);
       
       inst_add=new JLabel("PLEASE FILL ADDRESS FIELD");
       inst_add.setForeground(Color.red);
       inst_add.setFont(f3);
       inst_add.setBounds(780,80,300,20);
       inst_add.setVisible(false);
     
       inst_mno=new JLabel("PLEASE FILL MOBILE NUMBER FIELD");
       inst_mno.setForeground(Color.red);
       inst_mno.setFont(f3);
       inst_mno.setBounds(780,130,400,20);
       inst_mno.setVisible(false);
     
       inst_email=new JLabel("PLEASE FILL VALID EMAIL ID ");
       inst_email.setForeground(Color.red);
       inst_email.setFont(f3);
       inst_email.setBounds(780,180,300,20);
       inst_email.setVisible(false);
       
       inst_date=new JLabel("PLEASE CHOOSE VALID DATE ");
       inst_date.setForeground(Color.red);
       inst_date.setFont(f3);
       inst_date.setBounds(780,230,300,20);
       inst_date.setVisible(false);
     
     
       jdc=new JDateChooser();
       jdc.setBounds(550,230,200,20);
       jdc.setDateFormatString("yyyy/MM/dd");
       jdc.setBorder(new LineBorder(Color.black,1));
       
       
        jcb_faculty=new JComboBox();
        File f=new File("c:\\proj_java");
        String na[]=f.list();
        for(int i=0;i<na.length;i++)
        {
        	 jcb_faculty.addItem(na[i]);
        }
        jcb_faculty.setBounds(550,280,250,20);
        jcb_faculty.setBorder(new LineBorder(Color.black,1));
        
        v1=new Verification();
	   	v1.setSize(400,300);
	   	v1.setVisible(false);
	   	v1.setLocation(400,300);
	   	
        
        jcb_event=new JComboBox();
        jcb_event.setBounds(550,330,200,20);
        jcb_event.setEnabled(false);
        jcb_event.setBorder(new LineBorder(Color.black,1));
       
        jcb_sevent=new JComboBox();
        jcb_sevent.setBounds(550,380,200,20);
        jcb_sevent.setEnabled(false);
        jcb_sevent.setBorder(new LineBorder(Color.black,1));
        
        text_fee=new JTextArea();
        text_fee.setBounds(550,430,200,20);
        text_fee.setBorder(new LineBorder(Color.black,1));  
        
        
        logo=new JLabel();
        logo.setIcon(new ImageIcon("img//light.png"));
        logo.setBounds(1000,40,50,50);
        logo.addMouseListener(this);
        logo.setToolTipText("LIGHT MODE");
        logo.setVisible(true);
        
        logo1=new JLabel();
        logo1.setIcon(new ImageIcon("img//dark.png"));
        logo1.setBounds(1000,40,50,50);
        logo1.addMouseListener(this);
        logo1.setToolTipText("DARK MODE");
        logo1.setVisible(false);
        
        logo2=new JLabel();
        logo2.setIcon(new ImageIcon("img//icon1.png"));
        logo2.setBounds(200,30,80,80);
        
        jk=new JLabel("terms and condition");
        jk.setForeground(Color.BLUE);
        c1=new JCheckBox("I agree");
        c1.setBounds(330,480,70,20);
        c1.setBackground(Color.black);
        c1.setForeground(Color.white);
        jk.setBounds(405,480,200,20);
           
        submit=new JButton("SUBMIT");
        submit.setFocusable(false);
        submit.setBounds(350,550,100,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setBorder(new LineBorder(Color.red,1));
        submit.setActionCommand("submit");
        submit.setFont(f2);
        
    	
        top.add(top1);
        top.add(title);
        top.add(logo);
        top.add(logo1);
        top.add(logo2);
        
        top1.add(close);
        top1.add(minimize);
        
        main.add(full_name);
        main.add(add);
        main.add(mno);
        main.add(email);
        main.add(faculty);
        main.add(event);
        main.add(s_event);
        main.add(text_name);
        main.add(fee);
        main.add(text_add);
        main.add(text_mno);
        main.add(text_email);
        main.add(bdate);
        main.add(jdc);
        main.add(jcb_faculty);
        main.add(jcb_event);
        main.add(jcb_sevent);
        main.add(submit);
        main.add(inst_name);
        main.add(inst_email);
        main.add(inst_mno);
        main.add(inst_add);
        main.add(text_fee);
        main.add(c1);
        main.add(jk);
        main.add(inst_date);
        
        
        con.add(main);
        con.add(top);
		
		close.addActionListener(this);
		minimize.addActionListener(this);
		close.addMouseListener(this);
		minimize.addMouseListener(this);
		jcb_faculty.addActionListener(this);
		
   	    jk.addMouseListener(this);
		jcb_event.addActionListener(this);
		jcb_sevent.addActionListener(this);
		submit.addActionListener(this);
		v1.confirm.addActionListener(this);
		
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		try{
		
		   String na=ae.getActionCommand();
		   if(ae.getSource().equals(jcb_faculty))
			{
			  na1=jcb_faculty.getSelectedItem().toString();
			  File f1=new File("c:\\proj_java\\"+na1);
			  String pa[]=f1.list();
			  int a=pa.length;
			  if(a==0)
			  {
	            jcb_event.setEnabled(false);
			  }
			 else
			 {
				 jcb_event.setEnabled(true);
			 }
			 
	          jcb_event.removeAllItems();
	        
	           if(a!=0)
	          {
			  for(int i=0;i<pa.length;i++)
			  {
				     jcb_event.addItem(pa[i]);
			  }
	          }
	          
			}
			else if(ae.getSource().equals(jcb_event))
			{
				jh=jcb_event.getSelectedItem().toString();
				File fi=new File("c:\\proj_java\\"+na1+"\\"+jh+"\\posts");
				String hj[]=fi.list();
		    	int b=hj.length;
				if(b==0)
				{
					 jcb_sevent.setEnabled(false);
				}
				else
				{
					jcb_sevent.setEnabled(true);
				}
				
			    jcb_sevent.removeAllItems();
				
			     if(b!=0)
				{
				for(int i=0;i<hj.length;i++)
				{
					  jcb_sevent.addItem(hj[i]);
				}
				}
			}
			else if(ae.getSource().equals(jcb_sevent))
			{
				
				String jk=jcb_sevent.getSelectedItem().toString();
			    try
				{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		        	con1=DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=Msu_AdEx","sa","chirag2207");
		          	Statement st2,st3,st4;
		        	st3=con1.createStatement();
		        	st2=con1.createStatement();
		        	st4=con1.createStatement();
		        	ResultSet rs1=st2.executeQuery("select sevent_code from s_event  where sevent_name='"+jk+"'");
		        	rs1.next();
		        	int e=rs1.getInt(1);
		        	System.out.println("E: "+e);
		        	ResultSet rs2=st4.executeQuery("select reg_fees from s_event where sevent_code="+e);
		            rs2.next();
		          	text_fee.setText(""+rs2.getInt(1));
		        }
				catch(Exception e)
				{
			    }
			}
			else if(ae.getSource().equals(v1.confirm))
			{
				Connection con1;
				System.out.println("hello");
				try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        	con1=DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=Msu_AdEx","sa","chirag2207");
			
	        	 Statement st1,st2,st3,st4;
	        	  st1=con1.createStatement();
	        	  st2=con1.createStatement();
	        	  st3=con1.createStatement();
	        	  st4=con1.createStatement();
	        	 Random r=new Random();
	    		  
	  		    int h=r.nextInt(999999-99999)+99999;
	  		  
	        	  ResultSet rs1=st1.executeQuery("select faculty_code from faculty where faculty_name='"+jcb_faculty.getSelectedItem().toString()+"'");
	        	  
	        	  rs1.next();
	        	  int f=rs1.getInt(1);
	        	  
	        	  ResultSet rs2=st2.executeQuery("select event_code from event where event_name='"+jcb_event.getSelectedItem().toString()+"'");
	        	  rs2.next();
	        	  int e=rs2.getInt(1);
	        	  ResultSet rs3=st3.executeQuery("select sevent_code from s_event where sevent_name='"+jcb_sevent.getSelectedItem().toString()+"'");
	        	  rs3.next();
	        	  int s=rs3.getInt(1);
	        	  st4.executeUpdate("insert into reg values('"+text_name.getText()+"','"+text_add.getText()+"','"+jdc.getDate().toString()+"','"+text_mno.getText()+"','"+text_email.getText()+"',"+e+","+s+","+h+","+f+")");
	        	  
	        	  final JOptionPane pane = new JOptionPane("Your Registration Is Done Check Your Email");
				    final JDialog d = pane.createDialog((JFrame)null, "info");
				    d.setLocation(300,300);
				    d.setVisible(true);
				    
				    SendMailSSL sml1=new SendMailSSL(text_name.getText(),text_email.getText(),jcb_faculty.getSelectedItem().toString(),jcb_event.getSelectedItem().toString(),jcb_sevent.getSelectedItem().toString());
				    sml1.send1();

	        	 
				}
				catch(Exception e)
				{
					
				}
			
			}
		
	
			else if(na.equals("cl"))
		   {
			   this.setVisible(false);
		   }
		   else if(na.equals("mm"))
		   {
			   setState(this.ICONIFIED);
		   }
		  
		   else if(na.equals("submit"))
		   {
			   
			   int flag=0;
			      String s1=text_name.getText();
			      String s2=text_email.getText();
			      String s3=text_add.getText();
			      String s4=text_mno.getText();
			      String s5;
			      try{
	      		      SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
			         s5=sdf.format(jdc.getDate());
			      } 
			      catch(Exception e)
			      {
			    	  s5="";
			      }
			        inst_email.setVisible(false);
		    	    inst_mno.setVisible(false);
		    	    inst_add.setVisible(false);
		    	    inst_name.setVisible(false);
		    	    inst_date.setVisible(false);
		    	    
		    	    text_add.setBorder(new LineBorder(Color.black,1));
		    	    text_email.setBorder(new LineBorder(Color.black,1));
		    	    text_name.setBorder(new LineBorder(Color.black,1));
		    	    text_mno.setBorder(new LineBorder(Color.black,1));
		    	    jdc.setBorder(new LineBorder(Color.black,1));
			      
		    	    if(s1.equals(""))
			      {
			    	    inst_name.setVisible(true);
			    	    text_name.setBorder(new LineBorder(Color.RED,2));
			    	    flag=1;
			      }
			      if(s2.equals(""))
			      {
			    	  text_email.setBorder(new LineBorder(Color.RED,2));
			    	  inst_email.setVisible(true);
			    	   flag=1;
			      }
			      if(s3.equals(""))
			      {
			    	  text_add.setBorder(new LineBorder(Color.RED,2));
			    	  inst_add.setVisible(true);
			    	   flag=1;
			      }
			      if(s4.equals(""))
			      {
			    	  text_mno.setBorder(new LineBorder(Color.RED,2));
			    	  inst_mno.setVisible(true);
			    	   flag=1;
			      }
			      
			      if(s5.equals(""))
			      {
				           flag=1;
				 		  jdc.setBorder(new LineBorder(Color.red,2));
				    	  inst_date.setVisible(true);
			      }
				 	      
			     if(jcb_event.getSelectedIndex()==-1 || jcb_sevent.getSelectedIndex()==-1)
		         {
			     	 	flag=1;
			     	 	JOptionPane.showMessageDialog(this,"PLEASE SELECT VALID FACULTY","Alert",JOptionPane.WARNING_MESSAGE);
		         }
		     
			     if(!c1.isSelected())
			     {
			    	 flag=1;
			    	 JOptionPane.showMessageDialog(this,"PLEASE CHECK TERMS AND CONDITION","Alert",JOptionPane.WARNING_MESSAGE);
		    	 }
					     
			       if(flag==0)
			      {
			    	     s=new SendMailSSL(s1,s2);
			    	     no=s.sendOtp();
			    	     System.out.println("no: "+no);
			    	     v1.setVisible(true);
			    	     v1.send(no,s1,s2);
			      }
			   }
		}
		catch(Exception e)
		{
			
		}

	}
	public void mouseEntered(MouseEvent me)
	{
		
		 if(me.getSource().equals(jk))
		 {	 }
		 else if(me.getSource().equals(logo))
		 {
			 
		 }
		 else if(me.getSource().equals(logo1))
		 {
			 
		 }
		 
		 else{
			 AbstractButton esource=(AbstractButton)me.getSource();
			 if(esource.equals(close))
			 {
		    	  
		    	    close.setBackground(Color.red);
			 }
		    else if(esource.equals(minimize))
		    {
		    	 minimize.setBackground(Color.yellow);
		    }
		 }
	}
	
	public void mouseExited(MouseEvent me)
	{
		 if(me.getSource().equals(jk))
		 {
			 
		 }
		 else if(me.getSource().equals(logo))
		 {
			 
		 }
		 else if(me.getSource().equals(logo1))
		 {
			 
		 }
		 else
		 {
		    AbstractButton ab=(AbstractButton)me.getSource();
		    if(ab.equals(close))
		    {
		    	 close.setBackground(Color.black);
		    	 
		    }
		    else if(ab.equals(minimize))
		    {
		    	minimize.setBackground(Color.black);
		    }
		 }
	}
	
	public void mousePressed(MouseEvent me)
	{
		 
	}
	
	public void mouseClicked(MouseEvent me)
	{
	  
		 if(me.getSource().equals(jk))
		 {
			 Terms t1=null;
			 i++;
			 if(i==1)
			 {
			  t1=new Terms();
			 t1.setSize(600,400);
			 t1.setVisible(true);
			 }
			 else
			 {
				
				if(t1.isShowing()==false)
				{
					 t1=new Terms();
					 t1.setSize(600,400);
					 t1.setVisible(true);
			    }
			 }
		 }
	    
	     
		 else if(me.getSource().equals(logo))
		 {
			   //System.out.println("HELLO");
			       logo.setVisible(false);
			       logo1.setVisible(true);
			     main.setBackground(Color.white);
			     full_name.setForeground(Color.black);
			     add.setForeground(Color.black);
			     mno.setForeground(Color.black);
			     email.setForeground(Color.black);
			     faculty.setForeground(Color.black);
			     event.setForeground(Color.black);
			     s_event.setForeground(Color.black);
			     title.setForeground(Color.black);
			     fee.setForeground(Color.black);
			     bdate.setForeground(Color.black);
			     top.setBackground(Color.LIGHT_GRAY);
			     submit.setBackground(Color.white);
			     submit.setForeground(Color.black);
			     c1.setBackground(Color.white);
			        c1.setForeground(Color.black);
			        
		 }
		 else if(me.getSource().equals(logo1))
		 {
			    logo1.setVisible(false);
			    logo.setVisible(true);
			    main.setBackground(Color.black);
			     full_name.setForeground(Color.white);
			     add.setForeground(Color.white);
			     mno.setForeground(Color.white);
			     email.setForeground(Color.white);
			     faculty.setForeground(Color.white);
			     event.setForeground(Color.white);
			     s_event.setForeground(Color.white);
			     title.setForeground(Color.white);
			     fee.setForeground(Color.white);
			     bdate.setForeground(Color.white);
			     top.setBackground(Color.DARK_GRAY);
			     submit.setBackground(Color.black);
			     submit.setForeground(Color.white);
			     c1.setBackground(Color.black);
			        c1.setForeground(Color.white);
			        
		 }
	  
	  
		 
	}
	
	public void mouseReleased(MouseEvent me)
	{}
	
	public void itemStateChanged(ItemEvent ie)
	{
		  
			}
	
}
public class Form_all
{
	public static void main(String[] st)
	{
	   
		   Form f=new Form();
		   f.setSize(1200,800);
		   f.setVisible(true);
	}
}
