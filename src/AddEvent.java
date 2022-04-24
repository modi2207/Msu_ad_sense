import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;


class AddEvent extends JPanel implements ActionListener
{
	 JComboBox faculty_jcb;
	 
	JLabel jfaculty,jevent,jlogo,jdesc,img_lab,fact,event,logo,desc,jm;
	JFileChooser jf;
	BufferedImage img=null,img1=null;
	JButton choose,show,add_event;
	int q;
	JTextField img_text;
	Connection con1=null;
	JTextField jtf;
	JScrollPane jsp;
	JTextArea description;
	Font f1,f2,f3;
	
	  AddEvent()
	  {
		  setLayout(null);
		  
		  this.setBackground(Color.black);
		  this.setBounds(0,0,1200,1400);
		 
		  
		 // f1=new Font("Timesroman",Font.PLAIN,20);
		  
		  f1=new Font("Timesroman",Font.PLAIN,15);
		  f3=new Font("Aerial",Font.PLAIN,15);
			
		  
		   jfaculty=new JLabel();
		   jfaculty.setText("SELECT FACULTY:- ");
		   jfaculty.setForeground(Color.white);
		   jfaculty.setBounds(100,100,300,20);
		   jfaculty.setFont(f1);
		   
		   jevent=new JLabel();
		   jevent.setText("EVENT NAME:- ");
		   jevent.setForeground(Color.white);
		   jevent.setBounds(100,150,300,20);
		   jevent.setFont(f1);
		   
		   jlogo=new JLabel();
		   jlogo.setText("SELECT LOGO FOR EVENT:- ");
		   jlogo.setForeground(Color.white);
		   jlogo.setBounds(100,210,300,20);
		   jlogo.setFont(f1);
		   
		   jdesc=new JLabel();
		   jdesc.setText("DESCRIPTION:- ");
		   jdesc.setForeground(Color.white);
		   jdesc.setBounds(100,600,300,20);
		   jdesc.setFont(f1);
		   
		   event=new JLabel("Please Fill Event");
	       event.setForeground(Color.red);
	       event.setFont(f3);
	       event.setBounds(550,150,300,20);
	       event.setVisible(false);
	      
	       fact=new JLabel("Please Select Faculty");
	       fact.setForeground(Color.red);
	       fact.setFont(f3);
	       fact.setBounds(650,100,300,20);
	       fact.setVisible(false);
	      
	       logo=new JLabel("Please Choose Logo");
	       logo.setForeground(Color.red);
	       logo.setFont(f3);
	       logo.setBounds(780,200,300,20);
	       logo.setVisible(false);

	       desc=new JLabel("Please Fill Description");
	       desc.setForeground(Color.red);
	       desc.setFont(f3);
	       desc.setBounds(820,600,300,20);
	       desc.setVisible(false);
	      
		   
		   faculty_jcb=new JComboBox();
		   faculty_jcb.setBounds(300,100,300,20);
		   faculty_jcb.setBackground(Color.black);
		   faculty_jcb.setForeground(Color.white);
		   faculty_jcb.setFont(f1);
		   
		   File f=new File("C://proj_java");
		   String na[]=f.list();
		   faculty_jcb.addItem("---SELECT FACULTY---"); 

		   for(int i=0;i<na.length;i++)
		   {
			   faculty_jcb.addItem(na[i]);
			   
		   }
		   
		   	jtf=new JTextField();
		   	jtf.setBackground(Color.black);
		   	jtf.setForeground(Color.white);
		   	jtf.setFont(f2);
		   	jtf.setBounds(300,150,200,20);
		   	jtf.setBorder(new LineBorder(Color.white,1));
		   
		   
		   		jf=new JFileChooser();
		   		jf.setCurrentDirectory(new File(System.getProperty("user.home")));
//		   		jf.setBackground(Color.black);
//		   		jf.setForeground(Color.white);
		   		jf.setLocation(200,200);
		
				img_text=new JTextField();
				img_text.setBackground(Color.black);
				img_text.setForeground(Color.white);
				img_text.setFont(f2);
				img_text.setBounds(300,210,250,20);
				img_text.setBorder(new LineBorder(Color.white,1));
			   
				jm=new JLabel();
				jm.setBounds(340,400,200,200);
				ImageIcon ic=new ImageIcon("c:\\proj_pics\\de.jpg");
				jm.setIcon(ic);
				
		   
				choose=new JButton();
				choose.setBounds(560,210,100,20);
				choose.setText("CHOOSE FILE");
				choose.setFont(f2);
				choose.setBackground(Color.black);
				choose.setForeground(Color.white);
				choose.setBorder(new LineBorder(Color.white,1));
				choose.setFocusable(false);
				
				show=new JButton();
				show.setBounds(670,210,80,20);
				show.setText("SHOW");
				show.setFont(f2);
				show.setBackground(Color.black);
				show.setForeground(Color.white);
				show.setBorder(new LineBorder(Color.white,1));
				show.setFocusable(false);
				
				add_event=new JButton();
				add_event.setBounds(400,1050,100,20);
				add_event.setText("ADD EVENT");
				add_event.setFont(f2);
				add_event.setBackground(Color.black);
				add_event.setForeground(Color.white);
				add_event.setBorder(new LineBorder(Color.white,1));
				add_event.setFocusable(false);
				
				img_lab=new JLabel();
				img_lab.setBounds(100,240,500,580);
				img_lab.setVisible(false);
				
				description=new JTextArea();
				JScrollPane jsp=new JScrollPane(description,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				description.setFont(f2);
				description.setLineWrap(true);
				description.setWrapStyleWord(true);
				description.setBorder(new LineBorder(Color.white,1));
				description.setBackground(Color.black);
				description.setForeground(Color.white);
				jsp.setBounds(400,600,400,400);
				
				


 //   setBG( jf.getComponents(), Color.BLACK );

//				jf.setBackground(Color.black);
//				jf.setForeground(Color.white);
		   
		   add(jfaculty); add(jevent);  add(jlogo);  add(jdesc);
		   add(faculty_jcb);
		   add(jtf);  add(img_text); add(choose);  add(show);
		  // add(img_lab);
		   add(jsp);
		   add(add_event); add(fact); add(event);  add(logo);  add(desc);  add(jm);
		   choose.addActionListener(this);
		   show.addActionListener(this);
	       add_event.addActionListener(this);
		  
	  }
	  
//	  public void paint(Graphics g)
//	  {
//		  g.drawImage(img,300,260,null);
//	  }
	  
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
	         g.drawImage(img1,340,270,this); // see javadoc for more info on the parameters
	         q=1;
	        }
	    }
	  
//	  public static  void setBG( Component[] jc, Color bg )
//	  {
//	       for( int i = 0; i < jc.length; i++ )
//	       {
//	             Component c = jc[i];
//	             if( c instanceof Container )
//	                   setBG(((Container) c).getComponents(),bg);
//	             c.setBackground( bg );
//	       }
//	  }

	  
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
				String ta=img_text.getText();
				
//			      img_lab.setIcon(new ImageIcon(ta));
//			    
//			  img_lab.setVisible(true);
				try{
					
			jm.setVisible(false);
				img=ImageIO.read(new File(ta));
				
				 img1=ResizeImage.resizeImage(img,200,200);
				 
				 
				
				}
				catch(Exception e)
				{
					
				}
		
		  }
		  else if(ae.getSource().equals(add_event))
		  {
			  int flag=0;
			     faculty_jcb.setBorder(new LineBorder(Color.white,1));
			     fact.setVisible(false);
				    jtf.setBorder(new LineBorder(Color.white,1));
				    event.setVisible(false);
					  img_text.setBorder(new LineBorder(Color.white,1));
					  logo.setVisible(false);
					  description.setBorder(new LineBorder(Color.white,1));
					  desc.setVisible(false);
				  
			  if(faculty_jcb.getSelectedIndex()==0)
			  {
				     flag=1;
				     faculty_jcb.setBorder(new LineBorder(Color.red,1));
				     fact.setVisible(true);
			  }
			  
			  if(jtf.getText().equals(""))
			  {
				    flag=1;
				    jtf.setBorder(new LineBorder(Color.red,1));
				    event.setVisible(true);
			  }
			  if(img_text.getText().equals(""))
			  {
				  flag=1;
				  img_text.setBorder(new LineBorder(Color.red,1));
				  logo.setVisible(true);
			  }
			  if(description.getText().equals(""))
			  {
				  flag=1;
				  description.setBorder(new LineBorder(Color.red,1));
				  desc.setVisible(true);
			  }
			  
			  if(flag==0)
			  {
			   String na=faculty_jcb.getSelectedItem().toString();
			   System.out.print(na);
			   
			   String hj=jtf.getText();
			    File f=new File("C:\\proj_java\\"+na+"\\"+hj);
			    f.mkdir();
			    File f1=new File("C:\\proj_java\\"+na+"\\"+hj+"\\TEXT FILES");
			    f1.mkdir();
			    File f2=new File("C:\\proj_java\\"+na+"\\"+hj+"\\PICTURE FILES");
			    f2.mkdir();
			    try{

		    	    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		        	con1=DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=Msu_AdEx","sa","chirag2207");
		        	Statement st1,st2,st3;
		        	
		        	st1=con1.createStatement();
		        	ResultSet rs=st1.executeQuery("select faculty_code from faculty where faculty_name='"+na+"'");
		        	rs.next();
		            int y=rs.getInt(1);
		            st2=con1.createStatement();
		            ResultSet rs1=st2.executeQuery("select count(*) from event where faculty_code="+y);
		            rs1.next();
		            int x=rs1.getInt(1);
		            int t=y*100+x+1;
		              
		           st3=con1.createStatement();
		           st3.executeUpdate("insert into event (event_code,event_name,faculty_code) values("+t+",'"+hj+"',"+y+")");
		           
		           st1.close(); st2.close(); st3.close(); con1.close();
		     
		    			      
			    	 FileWriter fw=new FileWriter("C:\\proj_java\\"+na+"\\"+hj+"\\TEXT FILES\\description");
			    	 String st=description.getText();
			      	 
			    	 
			    	 fw.write(st);
			    	 fw.close();
			    	 
			    	 File output=new File("C:\\proj_java\\"+na+"\\"+hj+"\\PICTURE FILES\\image");
			    	 ImageIO.write(img1,"jpg",output);
			    	 
			    	   
			    }
			    catch(Exception e)
			    {
			    	e.printStackTrace();
			    }
				
			    
			    JOptionPane.showMessageDialog(this,"EVENT SUCCUSSFULLY INSERT","information",JOptionPane.INFORMATION_MESSAGE);
			    
			    
			    
			    description.setText("");
			    jtf.setText("");
			    faculty_jcb.setSelectedItem(1);
			    img_text.setText("");
			    img1=null;
			    
			     
			  }
		  }
	  }
}

//class CustomChooser extends JFileChooser
//{
//public CustomChooser(){
//super();
//setUI( new CustomChooserUI(this));
//}
//}
//class CustomChooserUI extends MetalFileChooserUI{
//public CustomChooserUI(JFileChooser filechooser) {
//super(filechooser);
//}
//public void installComponents(JFileChooser fc) {
//super.installComponents(fc);
//getBottomPanel().setBackground(Color.white);
//getButtonPanel().setBackground(Color.white);
//this.get
//}
//}

