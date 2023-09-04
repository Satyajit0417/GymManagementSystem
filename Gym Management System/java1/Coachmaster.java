import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
 
public class Coachmaster extends JInternalFrame
{
	
public  Coachmaster()

{


								 ImageIcon bkg=new ImageIcon("image/sb3.jpg");
                           JLabel bkg1 = new JLabel("",bkg,JLabel.CENTER);
                           Image img=bkg.getImage();
                           Image temp_img=img.getScaledInstance(1280,800,Image.SCALE_SMOOTH);
                           bkg=new ImageIcon(temp_img);
                           bkg1.setBounds(0,0,1280,700);

                setTitle("Coach Entry ");
				setClosable(true);
				setVisible(true);
					setLayout(null);
					BasicInternalFrameUI basicInternalFrameUI=(( javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI());
					for(MouseListener listener:basicInternalFrameUI.getNorthPane().getMouseListeners())
                 {
                 	basicInternalFrameUI.getNorthPane().removeMouseListener(listener);
                 }

                  Color c = new Color(155,155,204);

                 	JPanel panelco=new JPanel();  
              panelco.setBounds(0,0,1270,660);    
              panelco.setBackground(c);  
               
					/* 
					   ImageIcon bkg=new ImageIcon("image/sb3.jpg");
                           JLabel bkg1 = new JLabel("",bkg,JLabel.CENTER);
                           Image img=bkg.getImage();
                           Image temp_img=img.getScaledInstance(1265,810,Image.SCALE_SMOOTH);
                           bkg=new ImageIcon(temp_img);
                           bkg1.setBounds(3,0,1265,810);*/

					  /* JPanel panel2=new JPanel();  
              panel2.setBounds(3,510,1265,150);    
              panel2.setBackground(c);  */
               
JTable  table = new JTable();
DefaultTableModel model = new DefaultTableModel();
table.setModel(model); 
Object[] column={"coach_id","coach_name","coach_address","contact_no"};
model.setColumnIdentifiers(column);
table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
table.setFillsViewportHeight(true);
JScrollPane scroll = new JScrollPane(table);
scroll.setHorizontalScrollBarPolicy(
JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
scroll.setVerticalScrollBarPolicy(
JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
//String textvalue = textbox.getText();*/
/*model.addColumn("member_id");
model.addColumn("member_name");
model.addColumn("member_address");
model.addColumn("contact_no");
model.addColumn("batch");
model.addColumn("time");
model.addColumn("membership");
model.addColumn("ex_date");*/
try
{ 
 Connection   con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");
String sql = "select * from Coach ORDER BY coach_id DESC ";
PreparedStatement ps = con.prepareStatement(sql);
ResultSet rs = ps.executeQuery();
while(rs.next())
{
model.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)});
}
}catch(Exception ex){JOptionPane.showMessageDialog(null,ex);}
scroll.setBounds(300,525,600,130);
add(scroll);


 // panel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Coach details table"));
  //add(panel2);

   				 
 JLabel labelid=new JLabel("Coach Id");
  labelid.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 15));
  labelid.setBackground(Color.BLACK);
 labelid.setBounds(60,80,150,20);
 labelid.setForeground(Color.MAGENTA);
 add(labelid);
  
 JLabel labelname=new JLabel("Coach Name");
  labelname.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 15));
  labelname.setBackground(Color.BLACK);
 labelname.setBounds(60,190,150,20);
 labelname.setForeground(Color.MAGENTA);
 add(labelname);
 JLabel validname=new JLabel();
 validname.setBounds(240,220,150,20);
  validname.setForeground(Color.red);  
 add(validname);


 JLabel labeladd=new JLabel("Coach Address");
  labeladd.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 15));
  labeladd.setBackground(Color.BLACK);
 labeladd.setBounds(60,310,150,20);
 labeladd.setForeground(Color.MAGENTA);
 add(labeladd);
  
 JLabel labelcont=new JLabel("Contact No.");
  labelcont.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 15));
  labelcont.setBackground(Color.BLACK);
 labelcont.setBounds(60,430,150,20);
 labelcont.setForeground(Color.MAGENTA);
 add(labelcont);
 JLabel validcont=new JLabel();
 validcont.setBounds(240,460,100,20);
 validcont.setForeground(Color.red);
 add(validcont);
 

             JTextField txtId=new JTextField();
			 txtId.setBounds(230,80,200,30);
			  add(txtId);
			   String o="1";
                         try{
						 		Integer max_txtid,new_txtid;
						 		  Connection con;
					      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

						Statement stmt=con.createStatement();

						String sql="Select max(coach_id) from Coach";
						
						PreparedStatement pst;
						 pst=con.prepareStatement(sql);
						 ResultSet rs;
						 rs=pst.executeQuery();
						 if(rs.next())
						 {
                             
						 max_txtid=rs.getInt(1);
						 new_txtid=max_txtid+1;
						 String autono=Integer.toString(new_txtid);
						 txtId.setText(autono);
						 
						 }
						 else{
						 	txtId.setText(o);

						 }
						}catch(Exception en){JOptionPane.showMessageDialog(null,en);}

			 JTextField txtName=new JTextField();
			 txtName.setBounds(230,190,200,30);
			  add(txtName);
			 JTextArea txtAdd=new JTextArea();  
             txtAdd.setBounds(230,310,200,30);  
              add(txtAdd);  
			 JTextField txtCont=new JTextField();
			 txtCont.setBounds(230,430,200,30);
			  add(txtCont);



          Color c1 = new Color(20,60,60,100); 
  
			  JPanel panel1co=new JPanel();  
              panel1co.setBounds(730,50,180,330);   
              panel1co.setBackground(Color.red);  
               
 JButton btninsrt=new JButton("Insert");
 btninsrt.setBounds(750,80,140,40);
 add(btninsrt);
 JButton btnupdt=new JButton("Update");
 btnupdt.setBounds(750,160,140,40);
 add(btnupdt);
 JButton btndlt=new JButton("Delete");
 btndlt.setBounds(750,240,140,40);
 add(btndlt);
 JButton btncnl=new JButton("Cancle");
 btncnl.setBounds(750,320,140,40);
 add(btncnl);
  /*JButton btnext=new JButton("Exit");
 btnext.setBounds(750,400,140,40);
 add(btnext);*/
 //add(panel1co);
  add(panelco);
  //panelco.add(bkg1);


Object[] row=new Object[4];
btninsrt.addActionListener(new ActionListener(){
 	public void actionPerformed(ActionEvent e)
 	{     
             if(e.getSource()==btninsrt)
                 
                 //  Connection con=null;
                  //  Statement stmt=null;

				try
				{
                          
					     Connection con;
					      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

						Statement stmt=con.createStatement();

						String sql="Insert into Coach(coach_id,coach_name,coach_address,contact_no) Values(" + txtId.getText() + ",'" + txtName.getText() + "','" + txtAdd.getText() + "','" + txtCont.getText() + " ')";
						 
						PreparedStatement pst;
						 pst=con.prepareStatement(sql);
						 ResultSet rs;
						 rs=pst.executeQuery();
						// while(rs.next())
						 {

						 	    row[0]=txtId.getText();
								row[1]=txtName.getText();
								row[2]=txtAdd.getText();
						 	    row[3]=txtCont.getText();
	
						 		 model.addRow(row);
						 	JOptionPane.showMessageDialog(null,"Inserted succesfully...");
							stmt.close();
							con.close();

							}
						
					}
                         catch(Exception ex)
                         {
                         		JOptionPane.showMessageDialog(null,ex);
                         }
                          String o="1";
                         try{
						 		Integer max_txtid,new_txtid;
						 		  Connection con;
					      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

						Statement stmt=con.createStatement();

						String sql="Select max(coach_id) from Coach";
						
						PreparedStatement pst;
						 pst=con.prepareStatement(sql);
						 ResultSet rs;
						 rs=pst.executeQuery();
						 if(rs.next())
						 {
                             
						 max_txtid=rs.getInt(1);
						 new_txtid=max_txtid+1;
						 String autono=Integer.toString(new_txtid);
						 txtId.setText(autono);
						 
						 }
						 else{
						 	txtId.setText(o);

						 }
						}catch(Exception en){JOptionPane.showMessageDialog(null,en);}


                           if(txtId.getText().isEmpty()){	JOptionPane.showMessageDialog(null,"Please enter id");}
	                        	if(txtName.getText().isEmpty()){	JOptionPane.showMessageDialog(null,"Please enter name");} 
	                        		if(txtAdd.getText().isEmpty()){	JOptionPane.showMessageDialog(null,"Please enter address");}
	                        		if(txtCont.getText().isEmpty()){	JOptionPane.showMessageDialog(null,"Please enter contact");}
	                        	                      
								 txtId.setText("");txtName.setText("");txtAdd.setText("");txtCont.setText("");//txtmbrsip.setSelectedItem("");txtbatch.setSelectedItem("");txtexdt.setSelectedItem("");
	                      	

	}
});
	btnupdt.addActionListener(new ActionListener(){
 	public void actionPerformed(ActionEvent e)
 	{     
             if(e.getSource()==btnupdt)
             
				try
				{
                          
					     Connection con;
					      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

						Statement stmt=con.createStatement();

						String sql="Update Coach set coach_name='" + txtName.getText() + "',coach_address='" + txtAdd.getText() + "',contact_no=" + txtCont.getText() + " where coach_id=" + txtId.getText() + " ";
						 
						PreparedStatement pst;
						 pst=con.prepareStatement(sql);
						 ResultSet rs;
						 rs=pst.executeQuery();
						// while(rs.next())
						 int i=table.getSelectedRow();
						 if(i>=0)
						 {   
						 	   model.setValueAt(txtId.getText(), i, 0);
			                   model.setValueAt(txtName.getText(), i, 1);
			                   model.setValueAt(txtAdd.getText(), i, 2);
			                   model.setValueAt(txtCont.getText(), i, 3);
			                        
						
						 	JOptionPane.showMessageDialog(null,"Update succesfully...");
						 	 txtId.setText("");txtName.setText("");txtAdd.setText("");txtCont.setText("");
							//stmt.close();
							//con.close();

							}
						
					}
                         catch(Exception ex)
                         {
                         		JOptionPane.showMessageDialog(null,ex);
                         }
                           String o="1";
                         try{
						 		Integer max_txtid,new_txtid;
						 		  Connection con;
					      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

						Statement stmt=con.createStatement();

						String sql="Select max(coach_id) from Coach";
						
						PreparedStatement pst;
						 pst=con.prepareStatement(sql);
						 ResultSet rs;
						 rs=pst.executeQuery();
						 if(rs.next())
						 {
                             
						 max_txtid=rs.getInt(1);
						 new_txtid=max_txtid+1;
						 String autono=Integer.toString(new_txtid);
						 txtId.setText(autono);
						 
						 }
						 else{
						 	txtId.setText(o);

						 }
						}catch(Exception en){JOptionPane.showMessageDialog(null,en);}
	}
});
btndlt.addActionListener(new ActionListener(){
 	public void actionPerformed(ActionEvent e)
 	{     
             if(e.getSource()==btndlt)
             
				try
				{
                          
					     Connection con;
					      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

						Statement stmt=con.createStatement();

						String sql="Delete from Coach where coach_id=" + txtId.getText() + "";
						 
						PreparedStatement pst;
						 pst=con.prepareStatement(sql);
						 ResultSet rs;
						 rs=pst.executeQuery();
						// while(rs.next())
						 int i=table.getSelectedRow();
						 if(i>=0)
						 {

						    model.removeRow(i);
						 	JOptionPane.showMessageDialog(null,"Delete succesfully...");
					        	 txtId.setText("");txtName.setText("");txtAdd.setText("");txtCont.setText("");

							}
						
					}
                         catch(Exception ex)
                         {
                         		JOptionPane.showMessageDialog(null,ex);
                         }
                           String o="1";
                         try{
						 		Integer max_txtid,new_txtid;
						 		  Connection con;
					      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

						Statement stmt=con.createStatement();

						String sql="Select max(coach_id) from Coach";
						
						PreparedStatement pst;
						 pst=con.prepareStatement(sql);
						 ResultSet rs;
						 rs=pst.executeQuery();
						 if(rs.next())
						 {
                             
						 max_txtid=rs.getInt(1);
						 new_txtid=max_txtid+1;
						 String autono=Integer.toString(new_txtid);
						 txtId.setText(autono);
						 
						 }
						 else{
						 	txtId.setText(o);

						 }
						}catch(Exception en){JOptionPane.showMessageDialog(null,en);}
	}
});


		table.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					int i=table.getSelectedRow();
					        txtId.setText(model.getValueAt(i,0).toString());
						 	txtName.setText(model.getValueAt(i,1).toString());
						 	txtAdd.setText(model.getValueAt(i,2).toString());
						 	txtCont.setText(model.getValueAt(i,3).toString());
						 	
				}
			});

 btncnl.addActionListener(new ActionListener(){
 	public void actionPerformed(ActionEvent e)
 	{
 		if(e.getSource()==btncnl)
 			/*txtId.setText("");*/txtName.setText("");txtAdd.setText("");txtCont.setText("");
 		  String o="1";
                         try{
						 		Integer max_txtid,new_txtid;
						 		  Connection con;
					      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

						Statement stmt=con.createStatement();

						String sql="Select max(coach_id) from Coach";
						
						PreparedStatement pst;
						 pst=con.prepareStatement(sql);
						 ResultSet rs;
						 rs=pst.executeQuery();
						 if(rs.next())
						 {
                             
						 max_txtid=rs.getInt(1);
						 new_txtid=max_txtid+1;
						 String autono=Integer.toString(new_txtid);
						 txtId.setText(autono);
						 
						 }
						 else{
						 	txtId.setText(o);

						 }
						}catch(Exception en){JOptionPane.showMessageDialog(null,en);}
 	}
 });
 /* btnext.addActionListener(new ActionListener(){
			       	public void actionPerformed(ActionEvent e)
			       	{
			       		if(e.getSource()==btnext)
			       		{
			       			System.exit(0);
			       		}
			       	}
			       });*/

  			//validation start

    txtName.addKeyListener(new KeyAdapter(){

             public void keyPressed(KeyEvent ex){

                char ch = ex.getKeyChar();

                if(Character.isLetter(ch)||Character.isWhitespace(ch)||Character.isISOControl(ch))
                {
                	txtName.setEditable(true);
                	validname.setText("");

                }
                else{

                	txtName.setEditable(false);
                   validname.setText("Please Enter Character");
               }
                 
                   }
                      });

/*
			      txtCont.addKeyListener(new KeyAdapter(){
             public void keyReleased(KeyEvent ex){
             	String expression="^[0-9]{10}$";
             	Pattern p=Pattern.compile(expression);
             	Matcher m=p.matcher(txtCont.getText());
             	if(!m.matches()){
             		validcont.setText("Invalid Contact");
             	}else{
             		validcont.setText(null);
             	}
             }
         });

			     txtCont.addKeyListener(new KeyAdapter(){
             public void keyReleased(KeyEvent ex){

             	String contactno=txtCont.getText();
             	int length=contactno.length();
             	char ch=ex.getKeyChar();

             	if(ex.getKeyChar()>='0' && ex.getKeyChar()<='9')
             	{
             		if(length<10)
             		{
             			txtCont.setEditable(true);
             		} else
             		{
             			txtCont.setEditable(false);
             		}
             	}else
             	
             		if(ex.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE||ex.getExtendedKeyCode()==KeyEvent.VK_DELETE)
             			{
             				txtCont.setEditable(true);
             	}else
             	{
             		txtCont.setEditable(false);
             	}
             	
             	}
         });*/
			        txtCont.addKeyListener(new KeyAdapter(){
             public void keyReleased(KeyEvent ex){
             	String expression="^[0-9]{10}$";
             	Pattern p=Pattern.compile(expression);
             	Matcher m=p.matcher(txtCont.getText());
             	if(!m.matches()){
             		validcont.setText("Invalid Contact");
             	}else{
             		validcont.setText(null);
             	}
             }
         });

			     txtCont.addKeyListener(new KeyAdapter(){
             public void keyPressed(KeyEvent ex){
             	String contactno=txtCont.getText();
             	int length=contactno.length();
             	char ch=ex.getKeyChar();
             	if(ex.getKeyChar()>='0' && ex.getKeyChar()<='9')
             	{
             		if(length<10)
             		{	
             			txtCont.setEditable(true);

             		} else
             		{
             			txtCont.setEditable(false);
             	

             		}
             	}else
             	
             		if(ex.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE||ex.getExtendedKeyCode()==KeyEvent.VK_DELETE)
             			{
             				txtCont.setEditable(true);
             	}else
             	{

             		txtCont.setEditable(false);

             	}
             	
             	}
         });
				
              panelco.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Coach details"));
           //   panel1co.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Coach details"));
               add(bkg1);
               add(panelco);

    

}
public static void main(String args[])
{
  Coachmaster cm=new Coachmaster();
  cm.setTitle("coachmaster");
}
}

