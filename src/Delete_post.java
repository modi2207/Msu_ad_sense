import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;



class Delete_post extends JPanel implements ActionListener
{
	
	JComboBox faculty_jcb,event_jcb,post_jcb;
	JLabel jfaculty,jevent,jpost,fact,event,post;
	Font f1,f2,f3;
	String na,na1,gh;
	JButton delete_post;
	 Delete_post()
	 {
		 
		 setLayout(null);
		  this.setBounds(0,0,1200,1400);
		  this.setBackground(Color.black);
  	   
		  f1=new Font("Timesroman",Font.PLAIN,20);
		   f2=new Font("Timesroman",Font.PLAIN,15);
		   f3=new Font("Aerial",Font.PLAIN,15);
			
		   
		  
		  jfaculty=new JLabel();
		   jfaculty.setText("SELECT FACULTY:- ");
		   jfaculty.setForeground(Color.white);
		   jfaculty.setBounds(100,100,300,20);
		   jfaculty.setFont(f1);
		   
		   jevent=new JLabel();
		   jevent.setText("SELECT EVENT:- ");
		   jevent.setForeground(Color.white);
		   jevent.setBounds(100,150,300,20);
		   jevent.setFont(f1);
		 
		   jpost=new JLabel();
		   jpost.setText("SELECT POST:- ");
		   jpost.setForeground(Color.white);
		   jpost.setBounds(100,200,300,20);
		   jpost.setFont(f1);
		 
		   fact=new JLabel("Please Select Faculty");
	       fact.setForeground(Color.red);
	       fact.setFont(f3);
	       fact.setBounds(780,100,300,20);
	       fact.setVisible(false);
	      
	       event=new JLabel("Please Select Event");
	       event.setForeground(Color.red);
	       event.setFont(f3);
	       event.setBounds(780,150,300,20);
	       event.setVisible(false);
	      
	       post=new JLabel("Please Select Post");
	       post.setForeground(Color.red);
	       post.setFont(f3);
	       post.setBounds(780,200,300,20);
	       post.setVisible(false);
	      
  	   
  	   faculty_jcb=new JComboBox();
  	   faculty_jcb.setForeground(Color.WHITE);
  	   faculty_jcb.setBackground(Color.black);
  	   faculty_jcb.setFont(f2);
  	   faculty_jcb.setBounds(450,100,300,20);
  	   
  	   event_jcb=new JComboBox();
  	   event_jcb.setForeground(Color.WHITE);
  	   event_jcb.setBackground(Color.black);
  	   event_jcb.setFont(f2);
  	   event_jcb.setBounds(450,150,300,20);
  	   event_jcb.setEnabled(false);
  	   
  	   post_jcb=new JComboBox();
  	   post_jcb.setForeground(Color.WHITE);
  	   post_jcb.setBackground(Color.black);
  	   post_jcb.setFont(f2);
  	   post_jcb.setBounds(450,200,300,20);
  	   post_jcb.setEnabled(false);
  	   
  	    delete_post=new JButton();
	    delete_post.setBounds(300,300,150,20);
		delete_post.setText("DELETE POST");
		delete_post.setFont(f2);
		delete_post.setBackground(Color.black);
		delete_post.setForeground(Color.white);
		delete_post.setBorder(new LineBorder(Color.white,1));
	    delete_post.setFocusable(false);
		
  	  File f=new File("c:\\proj_java");
  	   
  	   String fa[]=f.list();
  	 faculty_jcb.addItem("---SELECT FACULTY---");
   	 event_jcb.addItem("---SELECT EVENT---"); 
   	 post_jcb.addItem("---SELECT POST---"); 
   	   
  	   
  	   for(int i=0;i<fa.length;i++)
  	   {
  		    faculty_jcb.addItem(fa[i]);
  	   }
  	   
//  	   event_jcb.addItem(" ");
//  	   post_jcb.addItem(" ");
//  	   
  	   faculty_jcb.addActionListener(this);
 	  event_jcb.addActionListener(this);
     post_jcb.addActionListener(this);
 	   
  	 delete_post.addActionListener(this);
  	  add(jfaculty);  add(jevent);  add(jpost);  add(faculty_jcb); add(event_jcb);  add(post_jcb);
  	  add(delete_post);   add(post);  add(fact);  add(event);
		 
	 }
	 
	 public void actionPerformed(ActionEvent ae)
	   {
		 try{
			 
		 
			if(ae.getSource().equals(faculty_jcb))
	    	{
	    		 event_jcb.setEnabled(true);
	    		 
	    		 na=faculty_jcb.getSelectedItem().toString();
	    		 
	    		 File f=new File("c:\\proj_java\\"+na);
	    		 String ch[]=f.list();
	    		 event_jcb.removeAllItems();
	    		 event_jcb.addItem("---SELECT EVENT---"); 
	    		   
	    		 
	    		 for(int i=0;i<ch.length;i++)
	    		 {
	    		 	     event_jcb.addItem(ch[i]);
	    		 }
	    		 
	    	}
	    	else if(ae.getSource().equals(event_jcb))
	    	{
	    		 post_jcb.setEnabled(true);
	    		 
	    		 na1=event_jcb.getSelectedItem().toString();
	    		 
	    		 
	    		 
	    		 File f=new File("c:\\proj_java\\"+na+"\\"+na1+"\\posts");
	    		 String ch[]=f.list();
	    			 	
		    		 post_jcb.removeAllItems();
	    		 
		    		 post_jcb.addItem("---SELECT POST---"); 
		    		   
	    		 for(int i=0;i<ch.length;i++)
	    		 {
	    			     post_jcb.addItem(ch[i]);
	    		 }
	    		 
	    	}
	    
	     	else if(ae.getSource().equals(delete_post))
	    	{
	     		int flag=0;
			     faculty_jcb.setBorder(new LineBorder(Color.white,1));
			     event_jcb.setBorder(new LineBorder(Color.white,1));
			     post_jcb.setBorder(new LineBorder(Color.white,1));
			    
			     fact.setVisible(false);
			     event.setVisible(false);
			     post.setVisible(false);
			     if(faculty_jcb.getSelectedIndex()==0)
				  {
					     flag=1;
					     faculty_jcb.setBorder(new LineBorder(Color.red,1));
					     fact.setVisible(true);
				  }
				  if(event_jcb.getSelectedIndex()==0)
				  {
					     flag=1;
					     event_jcb.setBorder(new LineBorder(Color.red,1));
					     event.setVisible(true);
				  }
				  
				  if(post_jcb.getSelectedIndex()==0)
				  {
					    flag=1;
					    post_jcb.setBorder(new LineBorder(Color.red,1));
					    post.setVisible(true);
				  }
				  
			  
			     if(flag==0)
			     {
	     		 gh=post_jcb.getSelectedItem().toString();
	    	
	     		  File f2=new File("c:\\proj_java\\"+na+"\\"+na1+"\\posts\\"+gh);
	     		  f2.delete();
	     		  
	     		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	  	        	Connection con1=DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=Msu_AdEx","sa","chirag2207");
	  			  
	  	        	Statement st1,st2;
	  	        	st1=con1.createStatement();
	  	            st2=con1.createStatement();
	  	        	System.out.println("gh: "+gh);
	  	        	ResultSet rs=st1.executeQuery("select sevent_code from s_event where sevent_name='"+gh+"'");
	  	        	rs.next();
	  	        	System.out.print("hello");
	  	        	int y=rs.getInt(1);
	  	        	System.out.println("y: "+y);
	  	        	st2.executeUpdate("delete from s_event where sevent_code="+y);
	  	        	rs.close(); 
	  	        	st1.close(); st2.close(); con1.close();
	  	        	
	    	 }
	    
	    	}
	   }
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			
		}
	   }

	 
}
