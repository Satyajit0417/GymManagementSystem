import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.io.*;

public class Batchmaster extends JInternalFrame
{

 public Batchmaster()
{


								 ImageIcon bkg=new ImageIcon("image/sb3.jpg");
                           JLabel bkg1 = new JLabel("",bkg,JLabel.CENTER);
                           Image img=bkg.getImage();
                           Image temp_img=img.getScaledInstance(1280,800,Image.SCALE_SMOOTH);
                           bkg=new ImageIcon(temp_img);
                           bkg1.setBounds(0,0,1280,700);

 setTitle("Batch ");
					setClosable(true);
					setVisible(true);
					setLayout(null);
					BasicInternalFrameUI basicInternalFrameUI=(( javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI());
					for(MouseListener listener:basicInternalFrameUI.getNorthPane().getMouseListeners())
                 {
                 	basicInternalFrameUI.getNorthPane().removeMouseListener(listener);
                 }


								Color c=new Color(204,255,153);
			
								 JPanel panel=new JPanel();
					     		 panel.setBounds(0,0,1270,660);
							     panel.setBackground(c);

              /*JPanel panel2=new JPanel();  
              panel2.setBounds(3,480,1265,180);    
              panel2.setBackground(c);  */
               
JTable  table = new JTable();
DefaultTableModel model = new DefaultTableModel();
table.setModel(model); 
Object[] column={"batch","batch_time","coach_name"};
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
String sql = "select * from Batch ORDER BY batch DESC";
PreparedStatement ps = con.prepareStatement(sql);
ResultSet rs = ps.executeQuery();
while(rs.next())
{
model.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3)});
}
}catch(Exception ex){JOptionPane.showMessageDialog(null,ex);}
scroll.setBounds(310,500,600,150);
add(scroll);


 // panel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Batch details table"));








  								

							 JLabel labelbatch=new JLabel("Batch ");
							  labelbatch.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 15));
		                      labelbatch.setBackground(Color.BLACK);
							 labelbatch.setBounds(200,80,150,20);
							 labelbatch.setForeground(Color.MAGENTA);
							 add(labelbatch);

							 JLabel labeltime=new JLabel("Batch Time");
							  labeltime.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 15));
		                      labeltime.setBackground(Color.BLACK);
							 labeltime.setBounds(200,200,150,20);
							 labeltime.setForeground(Color.MAGENTA);
							 add(labeltime);

							 JLabel labelname=new JLabel("Coach Name");
							  labelname.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 15));
		                      labelname.setBackground(Color.BLACK);
							 labelname.setBounds(200,320,150,20);
							 labelname.setForeground(Color.MAGENTA);
							 add(labelname);

							 
							 JTextField txtBatch=new JTextField();
							 txtBatch.setBounds(320,80,200,30);
							 add(txtBatch);
							  String o="1";
                         try{
						 		Integer max_txtid,new_txtid;
						 		  Connection con;
					      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

						Statement stmt=con.createStatement();

						String sql="Select max(batch) from Batch";
						
						PreparedStatement pst;
						 pst=con.prepareStatement(sql);
						 ResultSet rs;
						 rs=pst.executeQuery();
						 if(rs.next())
						 {
                             
						 max_txtid=rs.getInt(1);
						 new_txtid=max_txtid+1;
						 String autono=Integer.toString(new_txtid);
						 txtBatch.setText(autono);
						 
						 }
						 else{
						 	txtBatch.setText(o);

						 }
						}catch(Exception en){JOptionPane.showMessageDialog(null,en);}

							 JTextField txtTime=new JTextField();
							 txtTime.setBounds(320,200,200,30);
							 add(txtTime);

							 JComboBox txtName=new JComboBox();
							 txtName.setEditable(true);
							 txtName.setBounds(320,320,200,30);
							 add(txtName);
							 	try{
              			   Connection con;
					    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

						Statement stmt=con.createStatement();

						String sql="Select coach_name from Coach";  			 
						PreparedStatement pst;
						 pst=con.prepareStatement(sql);
						 ResultSet rs;
						 rs=pst.executeQuery();
						 while(rs.next())
						 {
			          			txtName.addItem(rs.getString("coach_name")) ;	
                         
							}
						
					}
                         catch(Exception ex)
                         {
                         		JOptionPane.showMessageDialog(null,ex);
                         } //data can be retrive in database in combobox 
	


							JPanel panel1=new JPanel();
								panel1.setBounds(730,50,180,350);
							     panel1.setBackground(Color.MAGENTA);



												 JButton btnSave=new JButton("Save");
												 btnSave.setBounds(750,70,140,40);
												 add(btnSave);
												 JButton btnUpdate=new JButton("Update");
												 btnUpdate.setBounds(750,160,140,40);
												 add(btnUpdate);
												 JButton btnDelete=new JButton("Delete");
												 btnDelete.setBounds(750,250,140,40);
												 add(btnDelete);
												 JButton btnCancle=new JButton("Cancle");
												 btnCancle.setBounds(750,340,140,40);
												 add(btnCancle);
												/* JButton btnExit=new JButton("Exit");
												 btnExit.setBounds(750,410,140,40);
												 add(btnExit);*/
											
			Object[] row=new Object[3];									 

			btnSave.addActionListener(new ActionListener(){
 	public void actionPerformed(ActionEvent e)
 	{     
             if(e.getSource()==btnSave)
                

				try
				{
                          
					     Connection con;
					      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

						Statement stmt=con.createStatement();

						String sql="Insert into Batch(batch,batch_time,coach_name) Values(" + txtBatch.getText() + ",'" + txtTime.getText() + "','" + txtName.getSelectedItem() + "')";
						//stmt.executeQuery(sql);
						PreparedStatement pst;
						 pst=con.prepareStatement(sql);
						 ResultSet rs;
						 rs=pst.executeQuery();
						  //System.out.println("my");
						// while(rs.next())
						 {

						 	    row[0]=txtBatch.getText();
								row[1]=txtTime.getText();
								row[2]=txtName.getSelectedItem();
								
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

						String sql="Select max(batch) from Batch";
						
						PreparedStatement pst;
						 pst=con.prepareStatement(sql);
						 ResultSet rs;
						 rs=pst.executeQuery();
						 if(rs.next())
						 {
                             
						 max_txtid=rs.getInt(1);
						 new_txtid=max_txtid+1;
						 String autono=Integer.toString(new_txtid);
						 txtBatch.setText(autono);
						 
						 }
						 else{
						 	txtBatch.setText(o);

						 }
						}catch(Exception en){JOptionPane.showMessageDialog(null,en);}




                         if(txtBatch.getText().isEmpty()){	JOptionPane.showMessageDialog(null,"Please enter Batch");}
	                        	if(txtTime.getText().isEmpty()){	JOptionPane.showMessageDialog(null,"Please enter Time");} 
	                        		//if(txtName.getText().isEmpty()){	JOptionPane.showMessageDialog(null,"Please enter name");}
	                        	                      
								 txtBatch.setText("");txtTime.setText("");txtName.setSelectedItem("");//txtcont.setText("");//txtmbrsip.setSelectedItem("");txtbatch.setSelectedItem("");txtexdt.setSelectedItem("");
	                      	

	}
});
			btnUpdate.addActionListener(new ActionListener(){
 	public void actionPerformed(ActionEvent e)
 	{     
             if(e.getSource()==btnUpdate)
             
				try
				{
                          
					     Connection con;
					      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

						Statement stmt=con.createStatement();

						String sql="Update Batch set batch_time='" + txtTime.getText() + "',coach_name='" + txtName.getSelectedItem() + "' where batch=" + txtBatch.getText() + " ";
						 
						PreparedStatement pst;
						 pst=con.prepareStatement(sql);
						 ResultSet rs;
						 rs=pst.executeQuery();
						 //while(rs.next())
						 int i=table.getSelectedRow();
						 if(i>=0)
						 {   
						 	  //model.setValueAt(txtBatch.getText(), i, 0);
			                   model.setValueAt(txtTime.getText(), i, 1);
			                   model.setValueAt(txtName.getSelectedItem(), i, 2);
			                  
						
						 	JOptionPane.showMessageDialog(null,"Update succesfully...");
						 	 txtBatch.setText("");txtTime.setText("");txtName.setSelectedItem("");
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

						String sql="Select max(batch) from Batch";
						
						PreparedStatement pst;
						 pst=con.prepareStatement(sql);
						 ResultSet rs;
						 rs=pst.executeQuery();
						 if(rs.next())
						 {
                             
						 max_txtid=rs.getInt(1);
						 new_txtid=max_txtid+1;
						 String autono=Integer.toString(new_txtid);
						 txtBatch.setText(autono);
						 
						 }
						 else{
						 	txtBatch.setText(o);

						 }
						}catch(Exception en){JOptionPane.showMessageDialog(null,en);}


	}
});

			btnDelete.addActionListener(new ActionListener(){
 	public void actionPerformed(ActionEvent e)
 	{     
             if(e.getSource()==btnDelete)
             
				try
				{
                          
					     Connection con;
					      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

						Statement stmt=con.createStatement();

						String sql="Delete from Batch where batch=" + txtBatch.getText() + "";
						 
						PreparedStatement pst;
						 pst=con.prepareStatement(sql);
						 ResultSet rs;
						 rs=pst.executeQuery();
							 int i=table.getSelectedRow();
						 if(i>=0)
						 {

						    model.removeRow(i);
						 	JOptionPane.showMessageDialog(null,"Delete succesfully...");
					        	 txtBatch.setText("");txtTime.setText("");txtName.setSelectedItem("");

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

						String sql="Select max(batch) from Batch";
						
						PreparedStatement pst;
						 pst=con.prepareStatement(sql);
						 ResultSet rs;
						 rs=pst.executeQuery();
						 if(rs.next())
						 {
                             
						 max_txtid=rs.getInt(1);
						 new_txtid=max_txtid+1;
						 String autono=Integer.toString(new_txtid);
						 txtBatch.setText(autono);
						 
						 }
						 else{
						 	txtBatch.setText(o);

						 }
						}catch(Exception en){JOptionPane.showMessageDialog(null,en);}


	}
});

			table.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					int i=table.getSelectedRow();
					        txtBatch.setText(model.getValueAt(i,0).toString());
						 	txtTime.setText(model.getValueAt(i,1).toString());
						 	txtName.setSelectedItem(model.getValueAt(i,2).toString());
						 	
				}
			});


			       btnCancle.addActionListener(new ActionListener(){
			       	public void actionPerformed(ActionEvent e)
			       	{
			       		if(e.getSource()==btnCancle)
			       			txtName.setSelectedItem("");txtBatch.setText("");txtTime.setText("");
			       		String o="1";
                         try{
						 		Integer max_txtid,new_txtid;
						 		  Connection con;
					      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

						Statement stmt=con.createStatement();

						String sql="Select max(batch) from Batch";
						
						PreparedStatement pst;
						 pst=con.prepareStatement(sql);
						 ResultSet rs;
						 rs=pst.executeQuery();
						 if(rs.next())
						 {
                             
						 max_txtid=rs.getInt(1);
						 new_txtid=max_txtid+1;
						 String autono=Integer.toString(new_txtid);
						 txtBatch.setText(autono);
						 
						 }
						 else{
						 	txtBatch.setText(o);

						 }
						}catch(Exception en){JOptionPane.showMessageDialog(null,en);}


			       	}
			       });


			     /*  btnExit.addActionListener(new ActionListener(){
			       	public void actionPerformed(ActionEvent e)
			       	{
			       		if(e.getSource()==btnExit)
			       		{
			       			System.exit(0);
			       		}
			       	}
			       });*/



												              panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Batch master details"));
												            //  panel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Batch master details"));
												 add(bkg1);			
												 add(panel1);
												 add(panel);

												  // add(panel2);
												 //setVisible(false);
												

								}
								public static void main(String args[])
								{
								  Batchmaster bm=new Batchmaster();
								  bm.setTitle("batchmaster");
								}
								}

