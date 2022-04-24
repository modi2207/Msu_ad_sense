import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;



class ModifyPost extends JPanel implements ActionListener
{
	 JComboBox faculty_jcb,event_jcb,post_jcb;
	   BufferedImage img=null,img1=null;
	  // Image img2;
	   Font f1,f2,f3;
	   JLabel jfaculty,jevent,jpost,jdesc,jm,jfees,jwin,fact,event,post,fee,win,desc;
	   JTextField img_text,jtfee,jtwin;
	   int q;
	   String na,na1,gh;
	   JFileChooser jf;
	   JTextArea description;
	   Connection con1;
	   JButton choose,show,modify_post,change;
	   int flag1=0,flag2=0;
	  
	  ModifyPost()
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
	      
	       post=new JLabel("Please Select Post");
	       post.setForeground(Color.red);
	       post.setFont(f3);
	       post.setBounds(780,200,300,20);
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
	      
	       desc=new JLabel("Please Fill Description");
	       desc.setForeground(Color.red);
	       desc.setFont(f3);
	       desc.setBounds(880,700,300,20);
	       desc.setVisible(false);
	      
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
   	
	   	jm=new JLabel();
		jm.setBounds(340,400,200,200);
		ImageIcon ic=new ImageIcon("c:\\proj_pics\\de.jpg");
		jm.setIcon(ic);
		
   	   
   	     
			
		   	img_text=new JTextField();
		   	img_text.setBackground(Color.black);
		   	img_text.setForeground(Color.white);
		   	img_text.setFont(f2);
		   	img_text.setBounds(450,350,200,20);
		   	img_text.setBorder(new LineBorder(Color.white,1));
		   	img_text.setVisible(false);
		   	
		   
		   	choose=new JButton();
			choose.setBounds(660,350,100,20);
			choose.setText("CHOOSE FILE");
			choose.setFont(f2);
			choose.setBackground(Color.black);
			choose.setForeground(Color.white);
			choose.setBorder(new LineBorder(Color.white,1));
			choose.setFocusable(false);
		    choose.setVisible(false);
			
			show=new JButton();
			show.setBounds(770,350,80,20);
			show.setText("SHOW");
			show.setFont(f2);
			show.setBackground(Color.black);
			show.setForeground(Color.white);
			show.setBorder(new LineBorder(Color.white,1));
			show.setFocusable(false);
			show.setVisible(false);
			
			change=new JButton();
			change.setBounds(600,400,150,20);
			change.setText("CHANGE PICTURE");
			change.setFont(f2);
			change.setBackground(Color.black);
			change.setForeground(Color.white);
			change.setBorder(new LineBorder(Color.white,1));
			change.setFocusable(false);
			
			
			jf=new JFileChooser();
	   		jf.setCurrentDirectory(new File(System.getProperty("user.home")));
//	   		jf.setBackground(Color.black);
//	   		jf.setForeground(Color.white);
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
			   
			    modify_post=new JButton();
			    modify_post.setBounds(300,1150,150,20);
				modify_post.setText("MODIFY POST");
				modify_post.setFont(f2);
				modify_post.setBackground(Color.black);
				modify_post.setForeground(Color.white);
				modify_post.setBorder(new LineBorder(Color.white,1));
				modify_post.setFocusable(false);
				
//				reset=new JButton();
//				reset.setBounds(450,1050,100,20);
//				reset.setText("RESET");
//				reset.setFont(f2);
//				reset.setBackground(Color.black);
//				reset.setForeground(Color.white);
//				reset.setBorder(new LineBorder(Color.white,1));
//				reset.setFocusable(false);
			
   	   
   	   File f=new File("c:\\proj_java");
   	   
   	   String fa[]=f.list();
   	   faculty_jcb.addItem("---SELECT FACULTY---");
   	 event_jcb.addItem("---SELECT EVENT---"); 
   	 post_jcb.addItem("---SELECT POST---"); 
   	   for(int i=0;i<fa.length;i++)
   	   {
   		    faculty_jcb.addItem(fa[i]);
   	   }
   	   
//   	   event_jcb.addItem(" ");
//   	   post_jcb.addItem(" ");
//   	   
   	   faculty_jcb.addActionListener(this);
  	  event_jcb.addActionListener(this);
      post_jcb.addActionListener(this);
  	   
   	   choose.addActionListener(this);
   	   show.addActionListener(this);
   	   change.addActionListener(this);
   	   
   	   modify_post.addActionListener(this);
   	   
   	   
   	   add(faculty_jcb);  add(event_jcb);   add(jfaculty);  add(jpost);  
   	   add(jevent);    add(img_text);  add(show);  add(choose); add(jf);
   	   add(jdesc);  add(jsp);  add(modify_post);    add(post_jcb); add(jm); 
   	   add(change); add(jfees); add(jtfee);  add(jwin); add(jtwin);
   	   add(fact); add(event);  add(post);  add(fee);  add(win); add(desc);
		   
		   
   
	  }
	  
	  
	   public void actionPerformed(ActionEvent ae)
	   {
		   try
		   {
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
	    	else if(ae.getSource().equals(post_jcb))
	    	{
	    		 gh=post_jcb.getSelectedItem().toString();
	    		try{
	    			jm.setVisible(false);
					img=ImageIO.read(new File("c:\\proj_java\\"+na+"\\"+na1+"\\posts\\"+gh+"\\PICTUREFILES\\image"));
	 				 img1=ResizeImage.resizeImage(img,200,200);
	 				 
	 				 FileReader fr=new FileReader("c:\\proj_java\\"+na+"\\"+na1+"\\posts\\"+gh+"\\TEXTFILE\\description");
	 				 int ch1=(char)fr.read();
	 				 char ch2=(char)ch1;
	 				 while(ch1!=-1)
	 				 {
	 					 
	 					 
	 					   String jk=description.getText();
	 					   String hj=jk+ch2;
	 					   description.setText(hj);
	 					   ch1=fr.read();
	 					   ch2=(char)ch1;
	 				}
	 				    System.out.println("hello2"); 
	 				    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		  	        	con1=DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=Msu_AdEx","sa","chirag2207");
		  			  
		  	        	Statement st1,st2;
		  	        	st1=con1.createStatement();
		  	        	st2=con1.createStatement();
		  	        	 
		  	        	ResultSet rs1=st1.executeQuery("select sevent_code from s_event where sevent_name='"+gh+"'");
		  	        	 
		  	        	 rs1.next();
		  	        	 int p1=rs1.getInt(1);
		  	        	 ResultSet rs2=st2.executeQuery("select reg_fees,winning_price from s_event where sevent_code="+p1);
		  	        	 System.out.println("hello world");
		  	        	 rs2.next();
		  	        	 //System.out.println(""+rs2.getInt(1)+"  "+rs2.getInt(2));
		  	        	 //System.out.println("hello1");
		  	        	 jtfee.setText(""+rs2.getInt(1));
		  	        	 jtwin.setText(""+rs2.getInt(2));
		  	        	 System.out.println("hello2");
		  	        	 rs2.close(); rs1.close();
		  	        	 st1.close(); st2.close(); con1.close();
		  	        	
	 				}
	 				catch(Exception e)
	 				{
	 					System.out.print(e.getMessage());
	 				}
	 		
	    	}
	  
	    
	    	else if(ae.getSource().equals(change))
		   {
			   img_text.setVisible(true);
			   choose.setVisible(true);
			   show.setVisible(true);
			   change.setVisible(false);
			   
		   }
		  
	    	else if(ae.getSource().equals(choose))
			  {
				  jf.showOpenDialog(this);	
				  //jf.setLocation(200,200);
				  File f=jf.getSelectedFile();
				//System.out.println(f.toString());/
				  
				img_text.setText(f.toString());
			  }
	    	else if(ae.getSource().equals(show))
	    	{
	    		 
	    		String ta=img_text.getText();
				
//			      img_lab.setIcon(new ImageIcon(ta));
//			    
//			  img_lab.setVisible(true);
	    		jm.setVisible(false);
				try{
					
			
				img=ImageIO.read(new File(ta));
				
				 img1=ResizeImage.resizeImage(img,200,200);
				 
				 
				
				}
				catch(Exception e)
				{
					
				}
		
	    	}
			
	    	else if(ae.getSource().equals(modify_post))
	    	{
	    		int flag=0;
			     faculty_jcb.setBorder(new LineBorder(Color.white,1));
			     event_jcb.setBorder(new LineBorder(Color.white,1));
			     post_jcb.setBorder(new LineBorder(Color.white,1));
			     jtfee.setBorder(new LineBorder(Color.white,1));
			     jtwin.setBorder(new LineBorder(Color.white,1));
			     //img_text.setBorder(new LineBorder(Color.white,1));
			     description.setBorder(new LineBorder(Color.white,1));
			     
			     fact.setVisible(false);
			     event.setVisible(false);
			     post.setVisible(false);
			     fee.setVisible(false);
			     win.setVisible(false);
			     //post_img.setVisible(false);
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
			  
			  if(post_jcb.getSelectedIndex()==0)
			  {
				    flag=1;
				    post_jcb.setBorder(new LineBorder(Color.red,1));
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
			  
			  if(description.getText().equals(""))
			  {
				  flag=1;
				  description.setBorder(new LineBorder(Color.red,1));
				  desc.setVisible(true);
			  }

	    		
	    		 if(flag==0)
	    		 {

	    		try{
	    			
	    	       FileWriter fw=new FileWriter("c:\\proj_java\\"+na+"\\"+na1+"\\posts\\"+gh+"\\TEXTFILE\\description");
	    	       String lk=description.getText();
	    	       System.out.println(lk);
	    	       BufferedWriter bw=new BufferedWriter(fw);
	    	       bw.write(lk);
	    	       bw.close();
	    	       
	    	       File fg=new File("c:\\proj_java\\"+na+"\\"+na1+"\\posts\\"+gh+"\\PICTUREFILES\\image");
	    	       
	    	       ImageIO.write(img1,"jpg",fg);
	    	       
	    	       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	  	        	con1=DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=Msu_AdEx","sa","chirag2207");
	  			    
	  	        	 Statement st1,st2;
	  	        	 st1=con1.createStatement();
	  	        	 st2=con1.createStatement();
	  	        	 
	  	        	 
	  	        	 ResultSet rs1=st1.executeQuery("select sevent_code from s_event where sevent_name='"+gh+"'");
	  	        	 rs1.next();
	  	        	 
	  	        	 
	  	        	 int p1=rs1.getInt(1);
	  	        	
	  	        	 st2.executeUpdate("update s_event set reg_fees="+Integer.parseInt(jtfee.getText())+" , winning_price="+Integer.parseInt(jtwin.getText())+" where sevent_code="+p1+"");
	  	        	 st2.close();
	  	        	 st1.close();
	  	        	 rs1.close();
	  	        	 con1.close();
	  	        	JOptionPane.showMessageDialog(this,"UPDATED SUCCESSFULLY","",JOptionPane.INFORMATION_MESSAGE);
	        		 
	  	        	
	  	        	
	    	       
	    		}
	    		catch(Exception e)
	    		{
	    			
	    		}
	    	      
	    	}
		   }
		   }
			catch(Exception e)
			{
				
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
	
	  
}

