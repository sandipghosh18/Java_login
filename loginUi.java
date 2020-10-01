//THIS ACT AS THE MAIN PAGE OF THE LOGIN INTERFACE
//HAVING TWO CLICK ACTIONLISTENER LOGIN & NEW REGISTRATION

package java_JDBC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class loginUi extends JFrame implements ActionListener {
	
	JLabel l1,l2,l3,l4;
	JTextField t1;
	JPasswordField t2;
	JButton bt1,bt2;
	JFrame f;
	public static String customer_id;
	
	
	loginUi()
	{
		//JFRAME CODE
				 f=new JFrame();
				f.setSize(400, 500);
				f.setLayout(null);
				f.setVisible(true);
				f.setTitle("BANK LOGIN");
				
				//JLABEL
				
				l4=new JLabel("LOGIN PORTAL");
				l4.setBounds(60, 40, 100, 70);
				f.add(l4);
				
				
				
				
				
				l1=new JLabel("USER NAME");
				l1.setBounds(50, 100, 100, 30);
				f.add(l1);
				
				l2=new JLabel("PASSWORD");
				l2.setBounds(50, 150, 100, 30);
				f.add(l2);
				
				
				//JTEXT FIELD
				
				
				t1= new JTextField(16);
				t1.setBounds(140, 100, 200, 30);
		        f.add(t1);
		        
		        
		        t2= new JPasswordField();
		        t2.setBounds(140, 150, 200, 30);
		        f.add(t2);
		        
		        
		        
		        
		        bt1=new JButton("Click to login");
		        bt1.setBounds(140, 198, 130, 40);
		        f.add(bt1);
		        
		        bt2= new JButton("Click to register");
		        bt2.setBounds(140, 260, 170, 40);
		        f.add(bt2);
		        
		        //message label
		        
		        l3= new JLabel();
		        l3.setBounds(140, 300, 150, 30);
		        f.add(l3);
		        //action for register button
		        bt2.addActionListener(new ActionListener()
		        		{

							@Override
							public void actionPerformed(ActionEvent arg0) {
								insert_jdbc sec= new insert_jdbc();
								sec.dispose();
								
							}
		        	     
		        		});
		       
		    //action when clicked
		   bt1.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent ae)
			   { 
			  
				   
				   try
				   {
					   Class.forName("com.mysql.jdbc.Driver");
					   Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3307/test","root","");
					   Statement stmt= c.createStatement();
					   String sql="Select * from jdbc where user='"+t1.getText()+"' and password='"+t2.getText()+"'";
					   ResultSet rs=stmt.executeQuery(sql);
					   customer_id=t1.getText();
					   if(rs.next())
					   {
						 
						  profile p= new profile();
						  p.dispose();
						
					   }
					   else
					   {
						   l3.setText("failed");
					   }
				   }
				   catch(Exception e1)
				   {
					   e1.printStackTrace();
				   }
			   }
		   });
		        
		        
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				
		new loginUi();
		
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
		
		
		
		
		
		
	
		
		
		
	}

}
