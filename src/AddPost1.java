import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;


  class AddPost1 extends JPanel implements ItemListener,ActionListener
  {
     
	   JComboBox faculty_jcb,event_jcb;
	   BufferedImage img=null,img1=null;
	  // Image img2;
	   Font f1,f2,f3;
	   JLabel jfaculty,jevent,jpost,jimg,jdesc,ji,jm,jfees,jwin,fact,event,post,fee,win,post_img,desc;
	   JTextField jtf,img_text,jtfee,jtwin;
	   Connection con1;
	   int q;
	   JFileChooser jf;
	   JTextArea description;
	   JButton choose,show,add_post,reset;
	   int flag=0;
	    AddPost1()
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
			 
			   jimg=new JLabel();
			   jimg.setText("CHOOSE POST IMAGE:- ");
			   jimg.setForeground(Color.white);
			   jimg.setBounds(100,350,300,20);
			   jimg.setFont(f1);
			  
			   jfees=new JLabel();
			   jfees.setText("ENTER ENROLLMENT FEE:- ");
			   jfees.setForeground(Color.white);
			   jfees.setBounds(100,250,300,20);
			   jfees.setFont(f1);
			   
			  
			   jwin=new JLabel();
			   jwin.setText("ENTER WINNING PRICE:- ");
			   jwin.setForeground(Color.white);
			   jwin.setBounds(100,300,300,20);
			   jwin.setFont(f1);
			   
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
		      
		       post=new JLabel("Please Fill Post");
		       post.setForeground(Color.red);
		       post.setFont(f3);
		       post.setBounds(680,200,300,20);
		       post.setVisible(false);
		      
		       fee=new JLabel("Please Fill Fees Details");
		       fee.setForeground(Color.red);
		       fee.setFont(f3);
		       fee.setBounds(680,250,300,20);
		       fee.setVisible(false);
		      
		       win=new JLabel("Please Fill Winning Details");
		       win.setForeground(Color.red);
		       win.setFont(f3);
		       win.setBounds(680,300,300,20);
		       win.setVisible(false);
		      
		       post_img=new JLabel("Please Choose Image");
		       post_img.setForeground(Color.red);
		       post_img.setFont(f3);
		       post_img.setBounds(880,350,300,20);
		       post_img.setVisible(false);
		      
	    	   
	    	   faculty_jcb=new JComboBox();
	    	   faculty_jcb.setForeground(Color.WHITE);
	    	   faculty_jcb.setBackground(Color.black);
	    	   faculty_jcb.setFont(f2);
	    	   faculty_jcb.setBounds(450,100,300,20);
	    	   
	    	   desc=new JLabel("Please Fill Description");
		       desc.setForeground(Color.red);
		       desc.setFont(f3);
		       desc.setBounds(880,700,300,20);
		       desc.setVisible(false);
		      
	    	   event_jcb=new JComboBox();
	    	   event_jcb.setForeground(Color.WHITE);
	    	   event_jcb.setBackground(Color.black);
	    	   event_jcb.setFont(f2);
	    	   event_jcb.setBounds(450,150,300,20);
	    	   event_jcb.setEnabled(false);
	    	   
	    	   jpost=new JLabel();
			   jpost.setText("ENTER POST NAME:- ");
			   jpost.setForeground(Color.white);
			   jpost.setBounds(100,200,300,20);
			   jpost.setFont(f1);
			 
				jtf=new JTextField();
			   	jtf.setBackground(Color.black);
			   	jtf.setForeground(Color.white);
			   	jtf.setFont(f2);
			   	jtf.setBounds(450,200,200,20);
			   	jtf.setBorder(new LineBorder(Color.white,1));
			   
			   	jtfee=new JTextField();
			   	jtfee.setBackground(Color.black);
			   	jtfee.setForeground(Color.white);
			   	jtfee.setFont(f2);
			   	jtfee.setBounds(450,250,200,20);
			   	jtfee.setBorder(new LineBorder(Color.white,1));
			   
			   	jtwin=new JTextField();
			   	jtwin.setBackground(Color.black);
			   	jtwin.setForeground(Color.white);
			   	jtwin.setFont(f2);
			   	jtwin.setBounds(450,300,200,20);
			   	jtwin.setBorder(new LineBorder(Color.white,1));
			   
			   	img_text=new JTextField();
			   	img_text.setBackground(Color.black);
			   	img_text.setForeground(Color.white);
			   	img_text.setFont(f2);
			   	img_text.setBounds(450,350,200,20);
			   	img_text.setBorder(new LineBorder(Color.white,1));
			   
			   	choose=new JButton();
				choose.setBounds(660,350,100,20);
				choose.setText("CHOOSE FILE");
				choose.setFont(f2);
				choose.setBackground(Color.black);
				choose.setForeground(Color.white);
				choose.setBorder(new LineBorder(Color.white,1));
				choose.setFocusable(false);
				
//				jm=new JLabel();
//				jm.setBounds(340,400,200,200);
//				ImageIcon ic=new ImageIcon("c:\\proj_pics\\de.jpg");
//				
//				img=(BufferedImage)ic.getImage();
//				img1=ResizeImage.resizeImage(img,200,200);
//				
//				ImageIcon ic1=new ImageIcon(img1);
				//jm.setIcon(ic);
//				try
//				{
//				img=ImageIO.read(new File("C:\\proj_pics\\default.jpg"));
//				img1=ResizeImage.resizeImage(img,200,200);
//				}
//				catch(Exception e)
//				{
//					
//				}
//				
				
				jm=new JLabel();
				jm.setBounds(340,400,200,200);
				ImageIcon ic=new ImageIcon("c:\\proj_pics\\de.jpg");
				jm.setIcon(ic);
				
				show=new JButton();
				show.setBounds(770,350,80,20);
				show.setText("SHOW");
				show.setFont(f2);
				show.setBackground(Color.black);
				show.setForeground(Color.white);
				show.setBorder(new LineBorder(Color.white,1));
				show.setFocusable(false);
				
				jf=new JFileChooser();
		   		jf.setCurrentDirectory(new File(System.getProperty("user.home")));
//		   		jf.setBackground(Color.black);
//		   		jf.setForeground(Color.white);
		   		jf.setLocation(200,200);
		   		
		   		description=new JTextArea();
				JScrollPane jsp=new JScrollPane(description,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				description.setFont(f2);
				description.setLineWrap(true);
				description.setWrapStyleWord(true);
				description.setBorder(new LineBorder(Color.white,1));
				description.setBackground(Color.black);
				description.setForeground(Color.white);
				jsp.setBounds(450,700,400,400);
				
				   jdesc=new JLabel();
				   jdesc.setText("DESCRIPTION:- ");
				   jdesc.setForeground(Color.white);
				   jdesc.setBounds(100,700,300,20);
				   jdesc.setFont(f1);
				   
				   add_post=new JButton();
					add_post.setBounds(300,1150,100,20);
					add_post.setText("ADD POST");
					add_post.setFont(f2);
					add_post.setBackground(Color.black);
					add_post.setForeground(Color.white);
					add_post.setBorder(new LineBorder(Color.white,1));
					add_post.setFocusable(false);
					
					reset=new JButton();
					reset.setBounds(450,1150,100,20);
					reset.setText("RESET");
					reset.setFont(f2);
					reset.setBackground(Color.black);
					reset.setForeground(Color.white);
					reset.setBorder(new LineBorder(Color.white,1));
					reset.setFocusable(false);
					
	    	   File f=new File("c:\\proj_java");
	    	   
	    	   String fa[]=f.list();

	    	   faculty_jcb.addItem("---SELECT FACULTY---"); 
	    	   event_jcb.addItem("---SELECT EVENT---");


	    	   for(int i=0;i<fa.length;i++)
	    	   {
	    		    faculty_jcb.addItem(fa[i]);
	    	   }
	    	   
	    	   faculty_jcb.addItemListener(this);
	    	   choose.addActionListener(this);
	    	   show.addActionListener(this);
	    	   
	    	   add_post.addActionListener(this);
	    	   reset.addActionListener(this);
	    	   
	    	   add(faculty_jcb);  add(event_jcb);  add(jtf);  add(jfaculty);  add(jpost);  
	    	   add(jevent);  add(jimg);  add(img_text);  add(show);  add(choose); add(jf);
	    	   add(jdesc);  add(jsp);  add(add_post);  add(reset);  add(jm); add(jfees);
	    	   add(jwin); add(jtfee); add(jtwin); add(fact);  add(event); add(post);
	    	   add(fee); add(win);  add(post_img);  add(desc);
	    	   
	    }
	    
	    public void itemStateChanged(ItemEvent ie)
	    {
	    	if(ie.getSource().equals(faculty_jcb))
	    	{
	    		 event_jcb.setEnabled(true);
	    		 
	    		 String na=faculty_jcb.getSelectedItem().toString();
	    		 event_jcb.removeAllItems();
	    		 event_jcb.addItem("---SELECT EVENT---"); 

	    		 
	    		 File f=new File("c:\\proj_java\\"+na);
	    		 String ch[]=f.list();
	    		 for(int i=0;i<ch.length;i++)
	    		 {
	    			     event_jcb.addItem(ch[i]);
	    		 }  
	    	}
	    }
	    @Override
	    protected void paintComponent(Graphics g)
	  {
		  
	        super.paintComponent(g);
	        if(q==1)
	        {
		   g.setColor(getBackground());
		   g.fillRect(200,260,100,100);
		   q=0;
		   repaint();
	        }
	        else if(q==0)
	        {
	        	//System.out.print("hello");
	       
	        	g.drawImage(img1,340,400,this);
	        	q=1;
	        	
	        }
	        }
	    
	
	    public void actionPerformed(ActionEvent ae)
	    {
	    	
	    	if(ae.getSource().equals(choose))
			  {
				  jf.showOpenDialog(this);	
				  //jf.setLocation(200,200);
				  File f=jf.getSelectedFile();
				//System.out.println(f.toString());
				img_text.setText(f.toString());
			  }
	    	else if(ae.getSource().equals(show))
	    	{
	    		 flag=1;
	    		String ta=img_text.getText();
				System.out.println("ta: "+ta);
//			      img_lab.setIcon(new ImageIcon(ta));
//			    
//			  img_lab.setVisible(true);
	    		jm.setVisible(false);
				try{
			       img=ImageIO.read(new File(ta));
			       img1=ResizeImage.resizeImage(img,200,200);
				   }
				   catch(Exception e)
				  {}
             	}
	    	else if(ae.getSource().equals(add_post))
	    	{
	    		int flag=0;
			     faculty_jcb.setBorder(new LineBorder(Color.white,1));
			     event_jcb.setBorder(new LineBorder(Color.white,1));
			     jtf.setBorder(new LineBorder(Color.white,1));
			     jtfee.setBorder(new LineBorder(Color.white,1));
			     jtwin.setBorder(new LineBorder(Color.white,1));
			     img_text.setBorder(new LineBorder(Color.white,1));
			     description.setBorder(new LineBorder(Color.white,1));
			     
			     fact.setVisible(false);
			     event.setVisible(false);
			     post.setVisible(false);
			     fee.setVisible(false);
			     win.setVisible(false);
			     post_img.setVisible(false);
			     desc.setVisible(false);
			     
				   
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
			  
			  if(jtf.getText().equals(""))
			  {
				    flag=1;
				    jtf.setBorder(new LineBorder(Color.red,1));
				    post.setVisible(true);
			  }
			  
			  if(jtfee.getText().equals(""))
			  {
				    flag=1;
				    jtfee.setBorder(new LineBorder(Color.red,1));
				    fee.setVisible(true);
			  }
			  if(jtwin.getText().equals(""))
			  {
				    flag=1;
				    jtwin.setBorder(new LineBorder(Color.red,1));
				    win.setVisible(true);
			  }
			  if(img_text.getText().equals(""))
			  {
				  flag=1;
				  img_text.setBorder(new LineBorder(Color.red,1));
				  post_img.setVisible(true);
			  }
			  if(description.getText().equals(""))
			  {
				  flag=1;
				  description.setBorder(new LineBorder(Color.red,1));
				  desc.setVisible(true);
			  }

	    		
	    		
	    		if(flag==0)
	    		{
	    		  String f=faculty_jcb.getSelectedItem().toString();
	    		  String e=event_jcb.getSelectedItem().toString();
	    		  String p=jtf.getText();
	    		  
	    		  File f1=new File("c:\\proj_java\\"+f+"\\"+e+"\\posts");
	    		  f1.mkdir();
	    		  
	    		  File f2=new File("c:\\proj_java\\"+f+"\\"+e+"\\posts\\"+p);
	    		  f2.mkdir();
	    		  
	    		  File f3=new File("c:\\proj_java\\"+f+"\\"+e+"\\posts\\"+p+"\\TEXTFILE");
	    		  f3.mkdir();
	    		  
	    		  File f4=new File("c:\\proj_java\\"+f+"\\"+e+"\\posts\\"+p+"\\PICTUREFILES");
	    		  f4.mkdir();
	    		  
	    		  try
	    		  {
	    			  
	    			  FileWriter fw=new FileWriter("c:\\proj_java\\"+f+"\\"+e+"\\posts\\"+p+"\\TEXTFILE\\description");
	    			  String na=description.getText();
	    			  fw.write(na);
	    			  
	    			  File fg=new File("c:\\proj_java\\"+f+"\\"+e+"\\posts\\"+p+"\\PICTUREFILES\\image");
	    			  
	    			  ImageIO.write(img1,"jpg",fg);
	    			  
	    		  }
	    		  catch(Exception ex)
	    		  {
	    			  
	    		  }
	    		  
	    		  try
	    		  {
	    			  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	  	        	con1=DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=Msu_AdEx","sa","chirag2207");
	  			    
	  	        	 Statement st1,st2,st3,st4,st5;
	  	        	 st1=con1.createStatement();
	  	        	 st2=con1.createStatement();
	  	        	 st3=con1.createStatement();
	  	        	 st4=con1.createStatement();
	  	        	 st5=con1.createStatement();
	  	        	 
	  	        	 ResultSet rs1=st1.executeQuery("select event_code from event where event_name='"+e+"'");
	  	        	 rs1.next();
	  	        	 int y=rs1.getInt(1);
	  	        	 ResultSet rs2=st2.executeQuery("select count(*) from s_event where event_code=(select event_code from event where event_name='"+e+"')");
	  	        	 rs2.next();
	  	        	 
	  	        	 ResultSet rs3=st3.executeQuery("select event_code from event where event_name='"+e+"'");
	  	        	 rs3.next();
	  	        	 
	  	        	 ResultSet rs4=st5.executeQuery("select faculty_code from faculty where faculty_name='"+f+"'");
	  	        	 rs4.next();
	  	        	 int p2=rs4.getInt(1);
	  	        	 int p1=rs3.getInt(1);
	  	        	 int x=rs2.getInt(1);
	  	        	 
	  	        	 int z=y*100+x+1;
	  	        	 
	  	        	 System.out.println("z: "+z);
	  	        	 
	  	        	 st4.executeUpdate("insert into s_event (sevent_code,sevent_name,reg_fees,winning_price,event_code,faculty_code) values("+z+",'"+p+"',"+Integer.parseInt(jtfee.getText())+","+Integer.parseInt(jtwin.getText())+","+p1+","+p2+")");
	  	        	 
	  	        	 rs1.close(); rs2.close(); rs3.close(); rs4.close(); con1.close();
	  	        	 
	  	        	
	    		  }
	    		  catch(Exception ex)
	    		  {
	    			  System.out.println(ex.getMessage());
	    		  }
	    		} 
	    	}
	    	else if(ae.getSource().equals(reset))
	    	{
	    		     description.setText("");
	    		     img_text.setText("");
	    		     try{
	    		     img1=ImageIO.read(new File("c:\\proj_pics\\default"));
	    		     repaint();
	    		     }
	    		     catch(Exception e)
	    		     {
	    		    	 
	    		     }
	    	}
	    }
  }
