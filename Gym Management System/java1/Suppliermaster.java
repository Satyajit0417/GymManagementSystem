import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*; 
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.*;

public class Suppliermaster extends JInternalFrame
{
 public Suppliermaster()
{


								 ImageIcon bkg=new ImageIcon("image/sb3.jpg");
                           JLabel bkg1 = new JLabel("",bkg,JLabel.CENTER);
                           Image img=bkg.getImage();
                           Image temp_img=img.getScaledInstance(1280,800,Image.SCALE_SMOOTH);
                           bkg=new ImageIcon(temp_img);
                           bkg1.setBounds(0,0,1280,700);

 setTitle("Supplier Entry ");
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

              /* JPanel panel2=new JPanel();  
              panel2.setBounds(3,480,1265,180);    
              panel2.setBackground(c);  */
               
JTable  table = new JTable();
DefaultTableModel model = new DefaultTableModel();
table.setModel(model); 
Object[] column={"supplier_id","supplier_Name","address","contact_no"};
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
String sql = "select * from supplier ORDER BY supplier_id DESC";
PreparedStatement ps = con.prepareStatement(sql);
ResultSet rs = ps.executeQuery();
while(rs.next())
{
model.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)});
}
}catch(Exception ex){JOptionPane.showMessageDialog(null,ex);}
scroll.setBounds(290,495,600,160);
add(scroll);


  //panel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Batch details table"));
  //add(panel2);





   			

							 JLabel supid=new JLabel("Supplier id");
							   supid.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 15));
		                       supid.setBackground(Color.BLACK);
							 supid.setBounds(90,80,120,20);
							 supid.setForeground(Color.MAGENTA);
							 add(supid);

							 JLabel name=new JLabel("Name");
							   name.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 15));
		                       name.setBackground(Color.BLACK);
							 name.setBounds(90,170,80,20);
							 name.setForeground(Color.MAGENTA);
							 add(name);
							JLabel validname=new JLabel();
							 validname.setBounds(290,190,150,20);
							 validname.setForeground(Color.red);
							 add(validname);

							 JLabel add=new JLabel("Address");
							  add.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 15));
		                       add.setBackground(Color.BLACK);
							 add.setBounds(90,250,150,20);
							 add.setForeground(Color.MAGENTA);
							 add(add);

							 JLabel cont=new JLabel("Contact no");
							  cont.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 15));
		                       cont.setBackground(Color.BLACK);
							 cont.setBounds(90,330,80,20);
							 cont.setForeground(Color.MAGENTA);
							 add(cont);
							 JLabel validcont=new JLabel();
							  validcont.setBounds(290,360,150,20);
							 validcont.setForeground(Color.red);
							 add(validcont);
							 
							 
							 JTextField txtid=new JTextField();
							 txtid.setBounds(280,80,200,30);
							 add(txtid);
								String o="1";
                         try{
						 		Integer max_txtid,new_txtid;
						 		  Connection con;
					      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

						Statement stmt=con.createStatement();

						String sql="Select max(supplier_id) from supplier";
						
						PreparedStatement pst;
						 pst=con.prepareStatement(sql);
						 ResultSet rs;
						 rs=pst.executeQuery();
						 if(rs.next())
						 {
                             
						 max_txtid=rs.getInt(1);
						 new_txtid=max_txtid+1;
						 String autono=Integer.toString(new_txtid);
						 txtid.setText(autono);
						 
						 }
						 else{
						 	txtid.setText(o);

						 }
						}catch(Exception en){JOptionPane.showMessageDialog(null,en);}//auto numbering




							 JTextField txtname=new JTextField();
							 txtname.setBounds(280,160,200,30);
							 add(txtname);
							 JTextArea txtadd=new JTextArea();
							 txtadd.setBounds(280,240,200,30);
							 add(txtadd);
							 JTextField txtcont=new JTextField();
							 txtcont.setBounds(280,320,200,30);
							 add(txtcont);
							


							   /* JPanel panel1co=new JPanel();  
                               panel1co.setBounds(40,750,500,850);    
                               panel1co.setBackground(Color.red);  */
               
							 JButton btnsave=new JButton("Save");
							 btnsave.setBounds(750,60,140,40);
							 add(btnsave);
							 JButton btnupdt=new JButton("Update");
							 btnupdt.setBounds(750,140,140,40);
							 add(btnupdt);
							 JButton btndelt=new JButton("Delete");
							 btndelt.setBounds(750,220,140,40);
							 add(btndelt);
							 JButton btncal=new JButton("Cancle");
							 btncal.setBounds(750,300,140,40);
							 add(btncal);
							/* JButton btnext=new JButton("Exit");
							 btnext.setBounds(750,390,140,40);
							 add(btnext);*/
							 //add(panel1co);

				 Object[] row=new Object[4];				 
	 btnsave.addActionListener(new ActionListener(){
 	public void actionPerformed(ActionEvent e)
 	{     
             if(e.getSource()==btnsave)
                

				try
				{
                          
					     Connection con;
					      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

						Statement stmt=con.createStatement();

						String sql="Insert into supplier(supplier_id,name,address,contact_no) Values(" + txtid.getText() + ",'" + txtname.getText() + "','" + txtadd.getText() + "',"+txtcont.getText()+")";
						//stmt.executeQuery(sql);
						PreparedStatement pst;
						 pst=con.prepareStatement(sql);
						 ResultSet rs;
						 rs=pst.executeQuery();
						 // System.out.println("my");
						// while(rs.next())
						 {

						 	    row[0]=txtid.getText();
								row[1]=txtname.getText();
								row[2]=txtadd.getText();
								row[3]=txtcont.getText();
								
						 		 model.addRow(row);
						 	JOptionPane.showMessageDialog(null,"Inserted succesfully...");
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

						String sql="Select max(supplier_id) from supplier";
						
						PreparedStatement pst;
						 pst=con.prepareStatement(sql);
						 ResultSet rs;
						 rs=pst.executeQuery();
						 if(rs.next())
						 {
                             
						 max_txtid=rs.getInt(1);
						 new_txtid=max_txtid+1;
						 String autono=Integer.toString(new_txtid);
						 txtid.setText(autono);
						 
						 }
						 else{
						 	txtid.setText(o);

						 }
						}catch(Exception en){JOptionPane.showMessageDialog(null,en);}//auto numbering




                         if(txtid.getText().isEmpty()){	JOptionPane.showMessageDialog(null,"Please enter id");}
	                        	if(txtname.getText().isEmpty()){	JOptionPane.showMessageDialog(null,"Please enter name");} 
	                        		if(txtadd.getText().isEmpty()){	JOptionPane.showMessageDialog(null,"Please enter address");}
	                        		if(txtcont.getText().isEmpty()){	JOptionPane.showMessageDialog(null,"Please enter address");}
	                        	                      
								 txtadd.setText("");txtcont.setText("");txtname.setText("");//txtcont.setText("");//txtmbrsip.setSelectedItem("");txtbatch.setSelectedItem("");txtexdt.setSelectedItem("");
	                      	

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

						String sql="Update supplier set name='" + txtname.getText() + "',address='" + txtadd.getText() + "',contact_no="+txtcont.getText()+" where supplier_id=" + txtid.getText() + " ";
						 
						PreparedStatement pst;
						 pst=con.prepareStatement(sql);
						 ResultSet rs;
						 rs=pst.executeQuery();
						 //while(rs.next())
						 int i=table.getSelectedRow();
						 if(i>=0)
						 {   
						 	  model.setValueAt(txtid.getText(), i, 0);
			                   model.setValueAt(txtname.getText(), i, 1);
			                   model.setValueAt(txtadd.getText(), i, 2);
			                       model.setValueAt(txtcont.getText(), i, 3);
			                  
						
						 	JOptionPane.showMessageDialog(null,"Update succesfully...");
						  txtname.setText("");txtadd.setText("");txtcont.setText("");
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

						String sql="Select max(supplier_id) from supplier";
						
						PreparedStatement pst;
						 pst=con.prepareStatement(sql);
						 ResultSet rs;
						 rs=pst.executeQuery();
						 if(rs.next())
						 {
                             
						 max_txtid=rs.getInt(1);
						 new_txtid=max_txtid+1;
						 String autono=Integer.toString(new_txtid);
						 txtid.setText(autono);
						 
						 }
						 else{
						 	txtid.setText(o);

						 }
						}catch(Exception en){JOptionPane.showMessageDialog(null,en);}
	}
});

			btndelt.addActionListener(new ActionListener(){
 	public void actionPerformed(ActionEvent e)
 	{     
             if(e.getSource()==btndelt)
             
				try
				{
                          
					     Connection con;
					      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

						Statement stmt=con.createStatement();

						String sql="Delete from supplier where supplier_id=" + txtid.getText() + "";
						 
						PreparedStatement pst;
						 pst=con.prepareStatement(sql);
						 ResultSet rs;
						 rs=pst.executeQuery();
							 int i=table.getSelectedRow();
						 if(i>=0)
						 {

						    model.removeRow(i);
						 	JOptionPane.showMessageDialog(null,"Delete succesfully...");
					        	 txtname.setText("");txtadd.setText("");txtcont.setText("");

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

						String sql="Select max(supplier_id) from supplier";
						
						PreparedStatement pst;
						 pst=con.prepareStatement(sql);
						 ResultSet rs;
						 rs=pst.executeQuery();
						 if(rs.next())
						 {
                             
						 max_txtid=rs.getInt(1);
						 new_txtid=max_txtid+1;
						 String autono=Integer.toString(new_txtid);
						 txtid.setText(autono);
						 
						 }
						 else{
						 	txtid.setText(o);

						 }
						}catch(Exception en){JOptionPane.showMessageDialog(null,en);}
	}
});

			table.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					int i=table.getSelectedRow();
					        txtid.setText(model.getValueAt(i,0).toString());
						 	txtname.setText(model.getValueAt(i,1).toString());
						 	txtadd.setText(model.getValueAt(i,2).toString());
				 			txtcont.setText(model.getValueAt(i,3).toString());
	
				}
			});

			  btncal.addActionListener(new ActionListener(){
			       	public void actionPerformed(ActionEvent e)
			       	{
			       		if(e.getSource()==btncal)
			       			txtid.setText("");txtname.setText("");txtadd.setText("");txtcont.setText("");
			       		  String o="1";
                         try{
						 		Integer max_txtid,new_txtid;
						 		  Connection con;
					      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

						Statement stmt=con.createStatement();

						String sql="Select max(supplier_id) from supplier";
						
						PreparedStatement pst;
						 pst=con.prepareStatement(sql);
						 ResultSet rs;
						 rs=pst.executeQuery();
						 if(rs.next())
						 {
                             
						 max_txtid=rs.getInt(1);
						 new_txtid=max_txtid+1;
						 String autono=Integer.toString(new_txtid);
						 txtid.setText(autono);
						 
						 }
						 else{
						 	txtid.setText(o);

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

			         txtname.addKeyListener(new KeyAdapter(){

             public void keyPressed(KeyEvent ex){

                char ch = ex.getKeyChar();

                if(Character.isLetter(ch)||Character.isWhitespace(ch)||Character.isISOControl(ch))
                {
                	txtname.setEditable(true);
                	validname.setText("");

                }
                else{txtname.setEditable(false);
                	validname.setText("Enter only character");}
                 
                   }
                      });

			      /*txtcont.addKeyListener(new KeyAdapter(){
             public void keyReleasd(KeyEvent ex){
             	String expression="^[0-9]{10}$";
             	Pattern p=Pattern.compile(expression);
             	Matcher m=p.matcher(txtcont.getText());
             	if(!m.matches()){
             		validcont.setText("Invalid Contact");
             	}else{
             		validcont.setText(null);
             	}
             }
         });

			     txtcont.addKeyListener(new KeyAdapter(){
             public void keyReleasd(KeyEvent ex){
             	String contactno=txtcont.getText();
             	int length=contactno.length();
             	char ch=ex.getKeyChar();
             	if(ex.getKeyChar()>='0' && ex.getKeyChar()<='9')
             	{
             		if(length<10)
             		{
             			txtcont.setEditable(true);
             		} else
             		{
             			txtcont.setEditable(false);
             		}
             	}else
             	
             		if(ex.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE||ex.getExtendedKeyCode()==KeyEvent.VK_DELETE)
             			{
             				txtcont.setEditable(true);
             	}else
             	{
             		txtcont.setEditable(false);
             	}
             	
             	}
         });*/

          txtcont.addKeyListener(new KeyAdapter(){
             public void keyReleased(KeyEvent ex){
             	String expression="^[0-9]{10}$";
             	Pattern p=Pattern.compile(expression);
             	Matcher m=p.matcher(txtcont.getText());
             	if(!m.matches()){
             		validcont.setText("Invalid Contact");
             	}else{
             		validcont.setText(null);
             	}
             }
         });

			     txtcont.addKeyListener(new KeyAdapter(){
             public void keyPressed(KeyEvent ex){
             	String contactno=txtcont.getText();
             	int length=contactno.length();
             	char ch=ex.getKeyChar();
             	if(ex.getKeyChar()>='0' && ex.getKeyChar()<='9')
             	{
             		if(length<10)
             		{	
             			txtcont.setEditable(true);

             		} else
             		{
             			txtcont.setEditable(false);
             	

             		}
             	}else
             	
             		if(ex.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE||ex.getExtendedKeyCode()==KeyEvent.VK_DELETE)
             			{
             				txtcont.setEditable(true);
             	}else
             	{

             		txtcont.setEditable(false);

             	}
             	
             	}
         });






    
				
              panelco.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Supplier"));
             // panel1co.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Supplier"));
                   add(bkg1);
                  add(panelco);

}
/*public static void main(String args[])
{
  Suppliermaster sm=new Suppliermaster();
  sm.setTitle("suppliermaster");
}*/
}

