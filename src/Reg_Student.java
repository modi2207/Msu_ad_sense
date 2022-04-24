import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
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


class Reg_Student extends JPanel implements ActionListener,MouseListener
{
	JLabel full_name,add,mno,email,bdate,faculty,event,s_event,fee,inst_add,inst_name,inst_mno,inst_email,inst_date,jk;
	JTextArea text_add,text_name,text_mno,text_email;
	JDateChooser jdc;
	int no;
	String jh,na1;
	int i=0;
	Connection con1;
	Verification v1;
	SendMailSSL s;
	JCheckBox c1;
	JComboBox jcb_faculty,jcb_event,jcb_sevent;
	JTextArea text_fee;
	Font f1,f2,f3;
	JButton submit;
	  Reg_Student()
	  {
		  this.setBackground(Color.black);
		  this.setBounds(0,0,1200,1400);
		  this.setLayout(null);
		  
		  f1=new Font("TimesRoman",Font.BOLD,40);
			f2=new Font("TimesRoman",Font.PLAIN,20);
			f3=new Font("Aerial",Font.PLAIN,15);
			
		  full_name=new JLabel();
	       full_name.setText("Full Name:-");
	       full_name.setForeground(Color.white);
	       full_name.setFont(f2);
	       full_name.setFocusable(true);
	       full_name.setBounds(330,30,200,30);
	       
	       
	       add=new JLabel();
	       add.setText("Address:- ");
	       add.setForeground(Color.white);
	       add.setFont(f2);
	       add.setBounds(330,80,200,30);
	      
	       mno=new JLabel();
	       mno.setText("Mobile Number:- ");
	       mno.setForeground(Color.white);
	       mno.setFont(f2);
	       mno.setBounds(330,130,200,30);

	       email=new JLabel();
	       email.setText("Email_Id:- ");
	       email.setForeground(Color.white);
	       email.setFont(f2);
	       email.setBounds(330,180,200,30);

	        bdate=new JLabel();
	        bdate.setText("Birth_Date");
	        bdate.setFont(f2);
	        bdate.setForeground(Color.WHITE);
	        bdate.setBounds(330,230,200,30);
	        
	       faculty=new JLabel();
	       faculty.setText("Select Faculty:- ");
	       faculty.setForeground(Color.white);
	       faculty.setFont(f2);
	       faculty.setBounds(330,280,200,30);

	       event=new JLabel();
	       event.setText("Select Event:- ");
	       event.setForeground(Color.white);
	       event.setFont(f2);
	       event.setBounds(330,330,200,30);
	 
	       
	       s_event=new JLabel();
	       s_event.setText("Select Sub Event:- ");
	       s_event.setForeground(Color.white);
	       s_event.setFont(f2);
	       s_event.setBounds(330,380,250,30);
	       
	       fee=new JLabel();
	       fee.setText("Registration Fee:- ");
	       fee.setFont(f2);
	       fee.setForeground(Color.WHITE);
	       fee.setBounds(330,430,250,30);
	       
	      	v1=new Verification();
    	   	v1.setSize(400,300);
    	   	v1.setVisible(true);
    	   	v1.setLocation(400,300);
     
	      
	       
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
	       
	       inst_name=new JLabel("Please Fill Name Field");
	       inst_name.setForeground(Color.red);
	       inst_name.setFont(f3);
	       inst_name.setBounds(780,30,300,20);
	       inst_name.setVisible(false);
	       
	       inst_add=new JLabel("Please Fill Address Field");
	       inst_add.setForeground(Color.red);
	       inst_add.setFont(f3);
	       inst_add.setBounds(780,80,300,20);
	       inst_add.setVisible(false);
	     
	       inst_mno=new JLabel("Please Fill Mobile Number Field");
	       inst_mno.setForeground(Color.red);
	       inst_mno.setFont(f3);
	       inst_mno.setBounds(780,130,400,20);
	       inst_mno.setVisible(false);
	     
	       inst_email=new JLabel("Please Fill Valid Email ID ");
	       inst_email.setForeground(Color.red);
	       inst_email.setFont(f3);
	       inst_email.setBounds(780,180,300,20);
	       inst_email.setVisible(false);
	       
	       inst_date=new JLabel("Please Choose Valid Date ");
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
	        
	        jcb_faculty.addItem("---Select Faculty---");
		       
	        for(int i=0;i<na.length;i++)
	        {
	        	 jcb_faculty.addItem(na[i]);
	        }
	        jcb_faculty.setBounds(550,280,250,20);
	        jcb_faculty.setBorder(new LineBorder(Color.black,1));
	        
	        
	        jcb_event=new JComboBox();
	        jcb_event.setBounds(550,330,200,20);
	        jcb_event.setEnabled(false);
	        jcb_event.setBorder(new LineBorder(Color.black,1));
	       
	        jcb_sevent=new JComboBox();
	        jcb_sevent.setBounds(550,380,200,20);
	        jcb_sevent.setEnabled(false);
	        jcb_sevent.setBorder(new LineBorder(Color.black,1));
	       
	        jcb_event.addItem("---Select Event---");
	        jcb_sevent.addItem("---Select Sub Event---");
	       
	        text_fee=new JTextArea();
	        text_fee.setBounds(550,430,200,20);
	        text_fee.setBorder(new LineBorder(Color.black,1));
	        
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
	        
	        add(full_name);
	        add(add);
	        add(mno);
	        add(email);
	        add(faculty);
	        add(event);
	        add(s_event);
	        add(text_name);
	        add(fee);
	        add(text_add);
	        add(text_mno);
	        add(text_email);
	        add(bdate);
	        add(jdc);
	        add(jcb_faculty);
	        add(jcb_event);
	        add(jcb_sevent);
	        add(submit);
	        add(inst_name);
	        add(inst_email);
	        add(inst_mno);
	        add(inst_add);
	        add(text_fee);
	        add(c1);
	        add(jk);
	        add(inst_date);
	        
	        jcb_faculty.addActionListener(this);
	        jcb_event.addActionListener(this);
			jcb_sevent.addActionListener(this);

	   	    jk.addMouseListener(this);
			submit.addActionListener(this);
			v1.confirm.addActionListener(this);
			
	  }
	  public void actionPerformed(ActionEvent ae)
		{
		  String na=ae.getActionCommand();
		
			try{
			    if(ae.getSource().equals(jcb_faculty))
			    {
			    	 jcb_event.setEnabled(true);
				  na1=jcb_faculty.getSelectedItem().toString();
				  File f1=new File("c:\\proj_java\\"+na1);
				  String pa[]=f1.list();
				 
				//  int a=pa.length;
				 
					
				
				 
		         jcb_event.removeAllItems();
		          
		         jcb_event.addItem("---Select Event---");
		          
		          for(int i=0;i<pa.length;i++)
				  {
					     jcb_event.addItem(pa[i]);
				  }
		           
			      
				}
				else if(ae.getSource().equals(jcb_event))
				{
	       		   jcb_sevent.setEnabled(true);
					jh=jcb_event.getSelectedItem().toString();
					File fi=new File("c:\\proj_java\\"+na1+"\\"+jh+"\\posts");
					String hj[]=fi.list();
			//    	int b=hj.length;
						
					
					
				    jcb_sevent.removeAllItems();
				    jcb_sevent.addItem("---Select Sub Event---");
					
				     
					for(int i=0;i<hj.length;i++)
					{
						  jcb_sevent.addItem(hj[i]);
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
			        	ResultSet rs3=st3.executeQuery("select count(*) from s_event where sevent_name='"+jk+"'");
			        	rs3.next();
			        	int f=rs3.getInt(1);
			        	if(f==1)
			        	{
			        	ResultSet rs1=st2.executeQuery("select sevent_code from s_event  where sevent_name='"+jk+"'");
			        	rs1.next();
			        	int e=rs1.getInt(1);
			        	System.out.println("E: "+e);
			        	ResultSet rs2=st4.executeQuery("select reg_fees from s_event where sevent_code="+e);
			            rs2.next();
			          	text_fee.setText(""+rs2.getInt(1));
			        	}
			        	else 
			        	{
			        		  text_fee.setText("");
			        	}
			        	
			        }
					catch(Exception e)
					{
						System.out.println(e.getMessage());
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
					 	
				      if(jcb_faculty.getSelectedIndex()==0)
				      {
				    	   flag=1;
				    		 final JOptionPane pane = new JOptionPane("Please Select  Faculty");
							    final JDialog d = pane.createDialog((JFrame)null, "Alert");
							    d.setLocation(300,300);
							    d.setVisible(true);
  
				      }
				     if(jcb_event.getSelectedIndex()==0)
			         {
				     	 	flag=1;
				     	 	 final JOptionPane pane = new JOptionPane("Please Select Event");
							    final JDialog d = pane.createDialog((JFrame)null, "Alert");
							    d.setLocation(300,300);
							    d.setVisible(true);

				     	 //	JOptionPane.showMessageDialog(this,"PLEASE SELECT VALID FACULTY","Alert",JOptionPane.WARNING_MESSAGE);
			         }
				     if(jcb_sevent.getSelectedIndex()==0)
				     {
				    	 flag=1;
		     	 	 final JOptionPane pane = new JOptionPane("Please Select Sub Event");
					    final JDialog d = pane.createDialog((JFrame)null, "Alert");
					    d.setLocation(300,300);
					    d.setVisible(true);

				    	 
				     }
			     
				     if(!c1.isSelected())
				     {
				    	 flag=1;
				    	 final JOptionPane pane = new JOptionPane("PLEASE CHECK TERMS AND CONDITION");
						    final JDialog d = pane.createDialog((JFrame)null, "Alert");
						    d.setLocation(300,300);
						    d.setVisible(true);

				    	// JOptionPane.showMessageDialog(this,"PLEASE CHECK TERMS AND CONDITION","Alert",JOptionPane.WARNING_MESSAGE);
			    	 }
						     
				       if(flag==0)
				      {
				    	     s=new SendMailSSL(s1,s2);
				    	     no=s.sendOtp();
				    	     v1.setVisible(true);
				    	     v1.send(no,s1,s2);
				    	 }
				   }
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}

		}
		public void mouseEntered(MouseEvent me)
		{
			
			 if(me.getSource().equals(jk))
			 {	 }
			 
			 
		}
		
		public void mouseExited(MouseEvent me)
		{
			 if(me.getSource().equals(jk))
			 {
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
		    
		     
			
		  
			 
		}
		
		public void mouseReleased(MouseEvent me)
		{}
		
		public void itemStateChanged(ItemEvent ie)
		{
			  
				}
		


}
