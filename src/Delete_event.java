import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


class Delete_event extends JPanel implements ActionListener,ItemListener
{
	 JComboBox faculty_jcb,event_jcb;
	 
	JLabel jfaculty,jevent,fact,event;
	JButton del,res;
	Connection con1;
	
	Font f1,f2,f3;
	
	  Delete_event()
	  {
		  
		
		  setLayout(null);
		  
		  //System.out.println("hello");
		  
//		  JLabel jl1=new JLabel();
//		  jl1.setText("Hello");
		  
		  
		  
		  this.setBackground(Color.black);
		  this.setBounds(0,0,1200,1400);
		  
//		  jl1.setBounds(20,20,100,20);
//		  add(jl1);
		 //  f1=new Font("Timesroman",Font.PLAIN,20);
		   f1=new Font("Timesroman",Font.PLAIN,15);
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
		   
		   event=new JLabel("Please Select Event");
	       event.setForeground(Color.red);
	       event.setFont(f3);
	       event.setBounds(650,150,300,20);
	       event.setVisible(false);
	      
	       fact=new JLabel("Please Select Faculty");
	       fact.setForeground(Color.red);
	       fact.setFont(f3);
	       fact.setBounds(650,100,300,20);
	       fact.setVisible(false);
	     
		   
		   faculty_jcb=new JComboBox();
		   faculty_jcb.setBounds(300,100,300,20);
		   faculty_jcb.setBackground(Color.black);
		   faculty_jcb.setForeground(Color.white);
		   faculty_jcb.setFont(f1);
		   
		   event_jcb=new JComboBox();
		   event_jcb.setBounds(300,150,300,20);
		   event_jcb.setBackground(Color.black);
		   event_jcb.setForeground(Color.white);
		   event_jcb.setFont(f1);
		   event_jcb.setEnabled(false);
		   
		   
		   File f=new File("C://proj_java");
		   String na[]=f.list();
		   faculty_jcb.addItem("---SELECT FACULTY---"); 
		   event_jcb.addItem("---SELECT EVENT---"); 

		   for(int i=0;i<na.length;i++)
		   {
			   faculty_jcb.addItem(na[i]);
			   
		   }
		     	del=new JButton();
				del.setBounds(100,200,100,20);
				del.setText("DELETE EVENT");
				del.setFont(f2);
				del.setBackground(Color.black);
				del.setForeground(Color.white);
				del.setBorder(new LineBorder(Color.white,1));
				del.setFocusable(false);
				
				res=new JButton();
				res.setBounds(250,200,100,20);
				res.setText("RESET");
				res.setFont(f2);
				res.setBackground(Color.black);
			    res.setForeground(Color.white);
				res.setBorder(new LineBorder(Color.white,1));
				res.setFocusable(false);
				
		   add(jfaculty); add(jevent);    
		   add(faculty_jcb);
		   add(event_jcb);
		   add(del);  add(res); add(event); add(fact);
		   del.addActionListener(this);
		   faculty_jcb.addItemListener(this);
		   res.addActionListener(this);
	      
		  
	  }
	  
	   
	   public void itemStateChanged(ItemEvent ie)
	   {
		   
		        if(ie.getSource().equals(faculty_jcb))
		        {
		        	
		        	        String s=faculty_jcb.getSelectedItem().toString();
		        	        
		        	        File f1=new File("c://proj_java//"+s);
		        	        
		        	        String na[]=f1.list();
		        	        
		        	        event_jcb.setEnabled(true);
		        	        event_jcb.removeAllItems();
		        	        event_jcb.addItem("---SELECT EVENT---"); 

		        	        for(int i=0;i<na.length;i++)
		        	        {
		        	        	  event_jcb.addItem(na[i]);
		        	        }
		        	      
		        }
		   
	   }
	  
	  public void actionPerformed(ActionEvent ae)
	  {
		  
		   int flag=0;
		   faculty_jcb.setBorder(new LineBorder(Color.white,1));
		   fact.setVisible(false);
		   event_jcb.setBorder(new LineBorder(Color.white,1));
		   event.setVisible(false);
		   
		    if(faculty_jcb.getSelectedIndex()==0)
		    {
		    	  faculty_jcb.setBorder(new LineBorder(Color.red,1));
		    	  flag=1;
		    	  fact.setVisible(true);
		    }
		  
		    if(event_jcb.getSelectedIndex()==0)
		    {
		    	  event_jcb.setBorder(new LineBorder(Color.red,1));
		    	  flag=1;
		    	  event.setVisible(true);
		    }
		    if(flag==0)
		    {
		     if(ae.getSource().equals(del))
		     {
			  
			   String na=faculty_jcb.getSelectedItem().toString();
			   System.out.println(na);
			   
			   String hj=event_jcb.getSelectedItem().toString();
			   System.out.println(hj);
			   String gh="c:\\proj_java\\"+na+"\\"+hj;
			   File f=new File(gh);
			   f.delete();
			    
			    JOptionPane.showMessageDialog(this,"EVENT SUCCUSSFULLY DELETE","information",JOptionPane.INFORMATION_MESSAGE);
		    
			    try
			    {
			    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        	con1=DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=Msu_AdEx","sa","chirag2207");
			    Statement st;
			    st=con1.createStatement();
			    st.executeUpdate("delete from event where event_name='"+hj+"'");
			    st.close();
			    con1.close();
			    }
			    catch(Exception e)
			    {
			      	
			    }
			    
			     
			  
		  }
		     else if(ae.getSource().equals(res))
		     {
		    	 faculty_jcb.setSelectedIndex(0);
				    event_jcb.setSelectedIndex(0);
				      
		     }
		    }
	  }
}

