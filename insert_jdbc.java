//Insert form connected with MYSQL DATABASE

package java_JDBC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class insert_jdbc extends JFrame implements ActionListener {
	
	private JFrame j;
	private JLabel jl,jl1,jl2,jl3;
	private JTextField user,pass,pass2,email;
	private JButton btn;
	
	private String JDBC_DRIVER="com.mysql.jdbc.Driver";
	private String DB_URL="jdbc:mysql://localhost:3307/test";
	
	String USER="root";
	String PASS="";
	
	
	
	
	insert_jdbc()
	{
		
		j= new JFrame();
		j.setSize(400, 500);
		j.setVisible(true);
		j.setLayout(null);
		j.setTitle(" New Registration");
		
		jl= new JLabel("User Name");
		jl.setBounds(50, 70, 100, 30);
		j.add(jl);
		
		jl1= new JLabel("Password");
		jl1.setBounds(50, 110, 100, 30);
		j.add(jl1);
		
		jl3= new JLabel("confirm Password");
		jl3.setBounds(50, 150, 130, 30);
		j.add(jl3);
		
		jl2=new JLabel("Email");
		jl2.setBounds(50, 190, 100, 30);
		j.add(jl2);
		
		user= new JTextField();
		pass= new JTextField();
		pass2= new JTextField();
		email= new JTextField();
		
		user.setBounds(160,70, 200, 30);
		pass.setBounds(160,110 ,200, 30);
		pass2.setBounds(160,150,200,30);
		email.setBounds(160, 190,200,30);
        j.add(user);
        j.add(pass);
        j.add(pass2);
        j.add(email);
        
        btn= new JButton("Click to Register");
        btn.setBounds(160, 240, 170, 30);
        j.add(btn);
        
        
        //action when button is clicked
        
        btn.addActionListener(new ActionListener()
        		{

					@Override
					public void actionPerformed(ActionEvent arg0) {
						
			           try
			           {
			        	   
			        	   String uid=user.getText();
			        	   String pw=pass.getText();
			        	   String pw2=pass2.getText();
			        	   String mail=email.getText();
			        	   int a=uid.length();
			        	   //int b=pw.length();
			        	   
			        	  
				        	  //email validation
				        	  String rgx="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
				        	  Pattern p= Pattern.compile(rgx);
				        	  Matcher m=p.matcher(mail);
				        	  boolean mailresult=m.matches();
			        	   
			        	   
			        	   
			        	  if(!pw.equals(pw2))
			        	  {
			        		  JOptionPane.showMessageDialog(j, "Password Matching fails");
			        		 
			        	  }
			        	  else if(mailresult!=true)
			        	  {
			        		  JOptionPane.showMessageDialog(j, "Provide a valid Email");
			        	  }
			        	   
			        	  else
			        	  {
			        	 //REGISTER TO JDBC DRIVER 
			        	 Class.forName(JDBC_DRIVER); 
			        	 System.out.println("CONNECTING TO DATABASE....");
			        	 Connection con =DriverManager.getConnection(DB_URL,USER,PASS);
			        	 System.out.println("CONNECTION TO DATABASE SUCCESSFUL");
			        	 Statement stm= con.createStatement();
			        	 String sql="INSERT INTO jdbc VALUES('"+uid+"','"+pw+"','"+mail+"')";
			        	 int r=stm.executeUpdate(sql);
			        	 System.out.println(r);
			        	 if(r==1)
			        	 {
			        		 JOptionPane.showMessageDialog(j, "Registration is sucessfully completed"); 
			        	 }
			        	 
			           }
			           }
			           
			           catch(Exception e)
			           {
			        	   e.printStackTrace();
			           }
					}
        	
        		});
        
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new insert_jdbc();

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
