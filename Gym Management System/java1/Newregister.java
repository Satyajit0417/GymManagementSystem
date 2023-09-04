import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Newregister extends JFrame
{
	JButton btnlogin,btncan;
Newregister()
{

				 JLabel l=new JLabel("LOGIN");
				 l.setBounds(190,20,200,100);
				 add(l);
				 l.setForeground(Color.blue);
				 l.setFont(new Font("Serif", Font.BOLD, 30));
				 JLabel username=new JLabel("User Name:-");
				 username.setBounds(80,120,80,20);
				 add(username);
				 username.setForeground(Color.orange);
				 username.setFont(new Font("Serif", Font.BOLD,14));
				 
			     JLabel password=new JLabel("Password:-");
				 password.setBounds(80,170,80,20);
				 add(password);
				 password.setForeground(Color.magenta);
				 password.setFont(new Font("Serif", Font.BOLD,15));

				 JTextField txtname=new JTextField();
				 txtname.setBounds(210,120,100,20);
				 add(txtname);
				 txtname.requestFocus();
				 JPasswordField txtpassword=new JPasswordField();
				 txtpassword.setBounds(210,170,100,20);
				 add(txtpassword);

				 JButton btnlogin=new JButton("Save");
				 btnlogin.setBounds(60,250,80,30);
				 add(btnlogin);
				 JButton btncan=new JButton("Cancle");
				 btncan.setBounds(230,250,80,30);
				 add(btncan);
 
 addWindowListener(new WindowAdapter(){
 	public void closingWindow(WindowEvent e)
 	{
 		System.exit(0);
 	}
 });

 btnlogin.addActionListener(new ActionListener(){
 	public void actionPerformed(ActionEvent e)
 	{     
             if(e.getSource()==btnlogin)
             

				try
				{
                          
					    Connection con;
					    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");
						String sql="Insert into login(username, password) values('"+txtname.getText()+"','"+txtpassword.getText()+"')";
						 PreparedStatement pst;
						 pst=con.prepareStatement(sql);
						 ResultSet rs;
						 rs=pst.executeQuery();
						 if(rs.next())
						 {
						 	JOptionPane.showMessageDialog(null,"Add Successfully");
						 	Login log=new Login();
						 	log.setVisible(true);
						 	setVisible(false);
							}
							else
							{
								JOptionPane.showMessageDialog(null,"Invalid login");
								txtname.setText("");
								txtpassword.setText("");
								txtname.requestFocus();

							}
						
						con.close();
						pst.close();
						rs.close();
                         }catch(SQLException ex)
                         {
                         		System.out.println(ex);
                         }
	}
	
});
 btncan.addActionListener(new ActionListener(){
 	public void actionPerformed(ActionEvent e)
 	{     
             if(e.getSource()==btncan)
             	txtname.setText("");txtpassword.setText("");
         }
     });
 ImageIcon bkg=new ImageIcon("image/my.jpg");
			 JLabel bkg1 = new JLabel("",bkg,JLabel.CENTER);
			 Image img=bkg.getImage();
			 Image temp_img=img.getScaledInstance(500,400,Image.SCALE_SMOOTH);
			 bkg=new ImageIcon(temp_img);
			 bkg1.setBounds(0,0,500,400);
			 add(bkg1);

			 setSize(500,400);
			 setLayout(null);
			 setVisible(true);
			 setDefaultCloseOperation(EXIT_ON_CLOSE);

}


			public static void main(String args[])
							{
							 Newregister  nrg=new Newregister();
							 nrg.setTitle("Newregister");
							}
							} 
