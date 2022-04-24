import java.awt.Color;

import javax.swing.JPanel;


public class Admin_Bottom extends JPanel
{
	
	AddEvent ae;
   Delete_event de;
   AddPost1 ap;
   ModifyPost mp;
   Delete_post dp;
   Head_Reg hr;
   General g;
   Account ac;
   Reg_Student rs;
   
	Admin_Bottom()
	{
		this.setBackground(Color.black);
		this.setBounds(0,0,1200,1800);
		setLayout(null);
		
		ae=new AddEvent();
		de=new Delete_event();
		ap=new AddPost1();
		mp=new ModifyPost();
		dp=new Delete_post();
		hr=new Head_Reg();
		g=new General();
		
		ae.setVisible(false);
		de.setVisible(false);
		ap.setVisible(false);
		mp.setVisible(false);
		dp.setVisible(false);
		hr.setVisible(false);
		
		
		add(ae);
		add(de);
		add(ap);
		add(mp);
		add(dp);
		add(hr);
		add(g);
		
	}
	
	Admin_Bottom(String fact,String event,int hid,String hname,String hmno,String hemail,String hpword)
	{
	   
		this.setBackground(Color.black);
		this.setBounds(0,0,1200,1800);
		setLayout(null);
		
		ae=new AddEvent();
		de=new Delete_event();
		ap=new AddPost1();
		mp=new ModifyPost();
		dp=new Delete_post();
		hr=new Head_Reg();
		g=new General();
		ac=new Account(fact,event,hid,hname,hmno,hemail,hpword);
		rs=new Reg_Student();
		
		
		//ae.setVisible(false);
		//de.setVisible(false);
		ap.setVisible(false);
		mp.setVisible(false);
		dp.setVisible(false);
		hr.setVisible(false);
		ac.setVisible(false);
		rs.setVisible(false);
		
		
		//add(ae);
		//add(de);
		add(ap);
		add(mp);
		add(dp);
		add(hr);
		add(g);
	    add(ac);
	    add(rs);
	}

	   
}
