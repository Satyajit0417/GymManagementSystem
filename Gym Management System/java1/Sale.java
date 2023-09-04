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
import java.text.SimpleDateFormat;  
import java.util.Date; 

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.design.*;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.swing.JRViewer;

//for log4j exception  most important
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



public class Sale extends JInternalFrame
{
	final static Logger logger = Logger.getLogger(Sale.class);
 public Sale()
{


								 ImageIcon bkg=new ImageIcon("image/sb3.jpg");
                           JLabel bkg1 = new JLabel("",bkg,JLabel.CENTER);
                           Image img=bkg.getImage();
                           Image temp_img=img.getScaledInstance(1280,800,Image.SCALE_SMOOTH);
                           bkg=new ImageIcon(temp_img);
                           bkg1.setBounds(0,0,1280,700);

 setTitle("Sale");
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

                  /*JPanel panel2=new JPanel();  
              panel2.setBounds(3,480,1265,180);    
              panel2.setBackground(c);*/  
               
JTable  table = new JTable();
DefaultTableModel model = new DefaultTableModel();
table.setModel(model); 
Object[] column={"sale_no","member_name","contact_no","address","equipment","equip_type","quantity","price","discount","amount"};
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
String sql = "select * from sale ORDER BY sale_no DESC ";
PreparedStatement ps = con.prepareStatement(sql);
ResultSet rs = ps.executeQuery();
while(rs.next())
{
model.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10)});
}System.out.println("my");
}catch(Exception ex){JOptionPane.showMessageDialog(null,ex);}
scroll.setBounds(430,500,550,130);
add(scroll);

 // add(panel2);




      
   				

 JLabel labelsaleno=new JLabel("S.No");
 labelsaleno.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 15));
 labelsaleno.setBackground(Color.BLACK);
 labelsaleno.setBounds(120,70,80,20);
 labelsaleno.setForeground(Color.MAGENTA);
 add(labelsaleno);
  
 JLabel labelsname=new JLabel("Member Name");
 labelsname.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 15));
 labelsname.setBackground(Color.BLACK);
 labelsname.setBounds(120,200,150,20);
 labelsname.setForeground(Color.MAGENTA);
 add(labelsname);

  JLabel labelcontno=new JLabel("Contact no");
 labelcontno.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 15));
 labelcontno.setBackground(Color.BLACK);
 labelcontno.setBounds(120,330,80,20);
 labelcontno.setForeground(Color.MAGENTA);
add(labelcontno);
 JLabel validcontno=new JLabel();
 validcontno.setBounds(280,360,150,20);
 validcontno.setForeground(Color.red);
add(validcontno);


  JLabel labeladd=new JLabel("Address");
 labeladd.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 15));
 labeladd.setBackground(Color.BLACK);
 labeladd.setBounds(620,70,80,20);
  labeladd.setForeground(Color.MAGENTA);
add(labeladd);


 JLabel labelprodct=new JLabel("Equipment");
 labelprodct.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 15));
 labelprodct.setBackground(Color.BLACK);
 labelprodct.setBounds(620,200,100,20);
 labelprodct.setForeground(Color.MAGENTA);
 add(labelprodct);

  JLabel labeltype=new JLabel("Equip_Type");
 labeltype.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 15));
 labeltype.setBackground(Color.BLACK);
  labeltype.setBounds(620,330,100,20);
  labeltype.setForeground(Color.MAGENTA);
 add(labeltype);

 JLabel labelqty=new JLabel("Qty");
 labelqty.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 15));
 labelqty.setBackground(Color.BLACK);
 labelqty.setBounds(80,420,80,20);
 labelqty.setForeground(Color.MAGENTA);
 add(labelqty);

 JLabel labelprice=new JLabel("Price");
 labelprice.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 15));
 labelprice.setBackground(Color.BLACK);
 labelprice.setBounds(340,420,80,20);
 labelprice.setForeground(Color.MAGENTA);
 add(labelprice);

JLabel labeldiscount=new JLabel("Discount");
labeldiscount.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 15));
 labeldiscount.setBackground(Color.BLACK);
 labeldiscount.setBounds(580,420,80,20);
 labeldiscount.setForeground(Color.MAGENTA);
 add(labeldiscount);
 
 JLabel labelamont=new JLabel("Amount");
 labelamont.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 15));
 labelamont.setBackground(Color.BLACK);
 labelamont.setBounds(830,420,80,20);
 labelamont.setForeground(Color.MAGENTA);
 add(labelamont);

  JLabel labelavai=new JLabel("Avai_stock");
 labelavai.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 15));
 labelavai.setBackground(Color.BLACK);
 labelavai.setBounds(10,550,80,20);
 labelavai.setForeground(Color.MAGENTA);
 add(labelavai);


 Date date=new Date();
 SimpleDateFormat fordate=new SimpleDateFormat("HH:mm - dd/MM/YYYY");
   String date1=fordate.format(date);

      JLabel txtDate=new JLabel();
      txtDate.setBounds(1100,20,150,30);
       txtDate.setText(date1);
     //  txtDate.setEditable(false);
        add(txtDate);

							
							
							 
			JTextField txtSaleno=new JTextField();
			 txtSaleno.setBounds(280,70,200,30);
			  add(txtSaleno);

							 		 String o="1";
                         try{
						 		Integer max_txtid,new_txtid;
						 		  Connection con;
					      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

						Statement stmt=con.createStatement();

						String sql="Select max(Sale_no) from Sale";
						
						PreparedStatement pst;
						 pst=con.prepareStatement(sql);
						 ResultSet rs;
						 rs=pst.executeQuery();
						 if(rs.next())
						 {
                             
						 max_txtid=rs.getInt(1);
						 new_txtid=max_txtid+1;
						 String autono=Integer.toString(new_txtid);
						 txtSaleno.setText(autono);
						 
						 }
						 else{
						 	txtSaleno.setText(o);

						 }
						}catch(Exception en){JOptionPane.showMessageDialog(null,en);}




			 JComboBox txtName=new JComboBox();
			 txtName.setBounds(280,200,200,30);
			 txtName.setEditable(true);
			  add(txtName);
			  	try{
              			   Connection con;
					    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

						Statement stmt=con.createStatement();

						String sql="Select member_name from Memberinfo";  			 
						PreparedStatement pst;
						 pst=con.prepareStatement(sql);
						 ResultSet rs;
						 rs=pst.executeQuery();
						 while(rs.next())
						 {
			          			txtName.addItem(rs.getString("member_name")) ;	
                         
							}
						
					}
                         catch(Exception ex)
                         {
                         		JOptionPane.showMessageDialog(null,ex);
                         } //data can be retrive in database in combobox 

                         		 JTextField txtCont=new JTextField();
							  txtCont.setBounds(280,330,200,30);
							  add(txtCont);

				              JTextArea txtadd=new JTextArea();
							  txtadd.setBounds(750,70,200,30);
							  add(txtadd);
					
							 

							    JComboBox txtProd=new JComboBox();  
						        txtProd.setBounds(750,200,200,30);  
						        add(txtProd);

						        	try{
						              			   Connection con;
											    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

												Statement stmt=con.createStatement();

												String sql="Select equipment from purchase";  			 
												PreparedStatement pst;
												 pst=con.prepareStatement(sql);
												 ResultSet rs;
												 rs=pst.executeQuery();
												 while(rs.next())
												 {
									          			txtProd.addItem(rs.getString("equipment")) ;	
						                         
													}
												
											}
						                         catch(Exception ex)
						                         {
						                         		JOptionPane.showMessageDialog(null,ex);
						                         } //data can be retrive in database in combobox 

                           JComboBox txtType=new JComboBox();  
					        txtType.setBounds(750,330,200,30); 
					        add(txtType); 

						        	try{
						              			   Connection con;
											    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

												Statement stmt=con.createStatement();

												String sql="Select equip_type from purchase";  			 
												PreparedStatement pst;
												 pst=con.prepareStatement(sql);
												 ResultSet rs;
												 rs=pst.executeQuery();
												 while(rs.next())
												 {
									          			txtType.addItem(rs.getString("equip_type")) ;	
						                         
													}
												
											}
						                         catch(Exception ex)
						                         {
						                         		JOptionPane.showMessageDialog(null,ex);
						                         } //data can be retrive in database in combobox 

							JTextField txtQty=new JTextField();
							 txtQty.setBounds(50,450,200,30);
							  add(txtQty);

				         JTextField txtPrice=new JTextField();
				       txtPrice.setBounds(300,450,200,30);
				        add(txtPrice);

				         JTextField txtDis=new JTextField();
				       txtDis.setBounds(550,450,200,30);
				        add(txtDis);

				       JTextField txtAmt=new JTextField();  
				        txtAmt.setBounds(800,450,200,30);  
				        add(txtAmt);  


				        JTextField txtavai=new JTextField();  
						  txtavai.setBounds(120,550,150,30); 
						 txtavai.setVisible(true); 
						 add(txtavai); 
						 try{
						              			   Connection con;
											    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

												Statement stmt=con.createStatement();

												String sql="Select sum(quantity) from purchase";  			 
												PreparedStatement pst;
												 pst=con.prepareStatement(sql);
												 ResultSet rs;
												 rs=pst.executeQuery();
												 while(rs.next())
												 {
									          			txtavai.setText(rs.getString("sum(quantity)")) ;	
						                         
													}
												
											}
						                         catch(Exception ex)
						                         {
						                         		JOptionPane.showMessageDialog(null,ex);
						                         } 

												   /*txtQty.addKeyListener(new KeyAdapter(){
						             public void keyPressed(KeyEvent en){
						          try{
						                  Connection con;
						              con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

						            Statement stmt=con.createStatement();
						          
						            String sql="Select sum(quantity) from purchase"; 
						            PreparedStatement pst;
						             pst=con.prepareStatement(sql);
						             ResultSet rs;
						             rs=pst.executeQuery();
						             while(rs.next())
						             {
						                      txtavai.setText(rs.getString("sum(quantity)")) ; 
						                      txtavai.setVisible(true);
						                             

						                         
						              }
						            
						          }
						                         catch(Exception ex)
						                         {
						                            JOptionPane.showMessageDialog(null,ex);
						                         }
						                       }
						                       });*/

											               
               


							   /* JPanel panel1co=new JPanel();  
                               panel1co.setBounds(3,270,880,100);    
                               panel1co.setBackground(c);  */
               
							 JButton btnsave=new JButton("Save");
							 btnsave.setBounds(1100,60,150,40);
							 add(btnsave);
							 JButton btnupdt=new JButton("Update");
							 btnupdt.setBounds(1100,120,150,40);
							 add(btnupdt);
							 JButton btndelt=new JButton("Delete");
							 btndelt.setBounds(1100,190,150,40);
							 add(btndelt);
							  JButton btnprnt=new JButton("Print");
							 btnprnt.setBounds(1100,280,150,40);
							 add(btnprnt);
							 JButton btncal=new JButton("Cancle");
							 btncal.setBounds(1100,350,150,40);
							 add(btncal);
							 /*JButton btnext=new JButton("Exit");
							 btnext.setBounds(1100,410,150,40);
							 add(btnext);*/
							// add(panel1co);
							  add(panelco);


            Object[] row=new Object[11];

			btnsave.addActionListener(new ActionListener(){
 	public void actionPerformed(ActionEvent e)
 	{  
 	
   
            if(e.getSource()==btnsave){}
   
                 //  Connection con=null;
                  //  Statement stmt=null;
             	
				try
				{
                          
					     Connection con;
					      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

						Statement stmt=con.createStatement();

						String sql="Insert into sale(sale_no,member_name,contact_no,address,equipment,equip_type,quantity,price,discount,amount,sale_date) Values(" + txtSaleno.getText() + ",'" + txtName.getSelectedItem() + "'," + txtCont.getText() + ",'"+txtadd.getText()+"','" + txtProd.getSelectedItem() + "','"+txtType.getSelectedItem()+"',"+txtQty.getText()+"," +txtPrice.getText()+ ", "+txtDis.getText()+"," +txtAmt.getText()+ ",'"+txtDate.getText()+"')";
												// stmt.executeUpdate(sql);
						PreparedStatement pst;
						pst=con.prepareStatement(sql);
						ResultSet rs;
						rs=pst.executeQuery();
						//while(rs.next())
						 {	
						 		row[0]=txtSaleno.getText();
								row[1]=txtName.getSelectedItem();
								row[2]=txtCont.getText();
								row[3]=txtadd.getText();
							    row[4]=txtProd.getSelectedItem();
							    row[5]=txtType.getSelectedItem();
								row[6]=txtQty.getText();
								row[7]=txtPrice.getText();
								row[8]=txtDis.getText();
								row[9]=txtAmt.getText();
								//row[10]=txtDate.getText();
								
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

						String sql="Select max(Sale_no) from Sale";
						
						PreparedStatement pst;
						 pst=con.prepareStatement(sql);
						 ResultSet rs;
						 rs=pst.executeQuery();
						 if(rs.next())
						 {
                             
						 max_txtid=rs.getInt(1);
						 new_txtid=max_txtid+1;
						 String autono=Integer.toString(new_txtid);
						 txtSaleno.setText(autono);
						 
						 }
						 else{
						 	txtSaleno.setText(o);

						 }
						 	}
						 catch(Exception en){JOptionPane.showMessageDialog(null,en);}


						 if(txtSaleno.getText().isEmpty()){	JOptionPane.showMessageDialog(null,"Please enter Sale_no");}
	                        //	if(txtname.getText().isEmpty()){	JOptionPane.showMessageDialog(null,"Please enter Name");} 
	                        			if(txtCont.getText().isEmpty()){	JOptionPane.showMessageDialog(null,"Please enter contact_no");}
	                        			//if(txtProd.getText().isEmpty()){	JOptionPane.showMessageDialog(null,"Please enter Address");}
	  
	                        	                if(txtQty.getText().isEmpty()){	JOptionPane.showMessageDialog(null,"Please enter quantity");}
	                        	                if(txtPrice.getText().isEmpty()){	JOptionPane.showMessageDialog(null,"Please enter price");}  
	                        	               // if(txtAmt.getText().isEmpty()){	JOptionPane.showMessageDialog(null,"Please enter height");}
	                        	               
								// txtSaleno.setText("");
								txtName.setSelectedItem("");txtCont.setText(""); txtProd.setSelectedItem("");txtType.setSelectedItem("");
								txtQty.setText("");txtPrice.setText("");txtAmt.setText("");txtDis.setText("");txtadd.setText("");
	                      	
	}
});
			btnupdt.addActionListener(new ActionListener(){
 	public void actionPerformed(ActionEvent e)
 	{     
             if(e.getSource()==btnupdt){}

             	

             
				try
				{
                          
					     Connection con;
					      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

						Statement stmt=con.createStatement();

						String sql="Update sale set member_name='" + txtName.getSelectedItem() + "',contact_no="+txtCont.getText()+", address='"+txtadd.getText()+"',equipment='"+txtProd.getSelectedItem()+"',equip_type='"+txtType.getSelectedItem()+"',quantity="+txtQty.getText()+",Price="+txtPrice.getText()+",discount="+txtDis.getText()+",amount="+txtAmt.getText()+" where sale_no=" + txtSaleno.getText() + " ";
						 
						PreparedStatement pst;
						 pst=con.prepareStatement(sql);
						 ResultSet rs;
						 rs=pst.executeQuery();
						 //while(rs.next())
						 int i=table.getSelectedRow();
						 if(i>=0)
						 {   
						 	   model.setValueAt(txtSaleno.getText(), i, 0);
			                   model.setValueAt(txtName.getSelectedItem(), i, 1);
			                    model.setValueAt(txtCont.getText(), i, 2);
			                   model.setValueAt(txtadd.getText(), i, 3);
						 	   model.setValueAt(txtProd.getSelectedItem(), i, 4);
						 	    model.setValueAt(txtType.getSelectedItem(), i, 5);
			                   model.setValueAt(txtQty.getText(), i, 6);
						 	   model.setValueAt(txtPrice.getText(), i, 7);
						 	    model.setValueAt(txtDis.getText(), i, 8);
			                   model.setValueAt(txtAmt.getText(), i, 9);
			                  // model.setValueAt(txtDate.getText(),i,10);
			                   
			                 model.addRow(row);
						 		
						 	JOptionPane.showMessageDialog(null,"Update succesfully...");
						 	 // txtSaleno.setText("");
								txtName.setSelectedItem("");txtCont.setText(""); txtProd.setSelectedItem("");txtType.setSelectedItem("");
								txtQty.setText("");txtPrice.setText("");txtAmt.setText("");txtDis.setText("");txtadd.setText("");
	                      	
	                      	
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

						String sql="Select max(Sale_no) from Sale";
						
						PreparedStatement pst;
						 pst=con.prepareStatement(sql);
						 ResultSet rs;
						 rs=pst.executeQuery();
						 if(rs.next())
						 {
                             
						 max_txtid=rs.getInt(1);
						 new_txtid=max_txtid+1;
						 String autono=Integer.toString(new_txtid);
						 txtSaleno.setText(autono);
						 
						 }
						 else{
						 	txtSaleno.setText(o);

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

						String sql="Delete from sale where Sale_no=" + txtSaleno.getText() + "";
						 
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
						 	
					         
					       // txtSaleno.setText("");
								txtName.setSelectedItem("");txtCont.setText(""); txtProd.setSelectedItem("");txtadd.setText("");
								txtQty.setText("");txtPrice.setText("");txtAmt.setText("");txtDis.setText("");txtType.setSelectedItem("");
	                      	
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

						String sql="Select max(Sale_no) from Sale";
						
						PreparedStatement pst;
						 pst=con.prepareStatement(sql);
						 ResultSet rs;
						 rs=pst.executeQuery();
						 if(rs.next())
						 {
                             
						 max_txtid=rs.getInt(1);
						 new_txtid=max_txtid+1;
						 String autono=Integer.toString(new_txtid);
						 txtSaleno.setText(autono);
						 
						 }
						 else{
						 	txtSaleno.setText(o);

						 }
						}catch(Exception en){JOptionPane.showMessageDialog(null,en);}
	}
});
			table.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					int i=table.getSelectedRow();
					        txtSaleno.setText(model.getValueAt(i,0).toString());
						 	txtName.setSelectedItem(model.getValueAt(i,1).toString());
						    txtCont.setText(model.getValueAt(i,2).toString());
						    txtadd.setText(model.getValueAt(i,3).toString());
						 	txtProd.setSelectedItem(model.getValueAt(i,4).toString());
						 	txtType.setSelectedItem(model.getValueAt(i,5).toString());
						    txtQty.setText(model.getValueAt(i,6).toString());
						 	txtPrice.setText(model.getValueAt(i,7).toString());
						    txtDis.setText(model.getValueAt(i,8).toString());
					 	    txtAmt.setText(model.getValueAt(i,9).toString());
					 	   
						 	
						 

				}
			});


			  btnprnt.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) 
      { 
          if(arg0.getSource()==btnprnt){

      Connection con;
      try {

        Integer p1=Integer.parseInt(txtSaleno.getText());
        Integer sum=p1-1;
        String nstr=Integer.toString(sum);
         HashMap para = new HashMap();
        para.put("Invoice_no",nstr);


      Class.forName("oracle.jdbc.driver.OracleDriver");
      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");
        /*   panel1.removeAll();
           panel1.repaint();
           panel1.revalidate();*/

        InputStream in=new FileInputStream(new File("E:\\java1\\report\\sale.jrxml"));         //G:\\HMSFinalwithout database\\Run\\reports
        JasperDesign jd= JRXmlLoader.load(in);                                          //G:\\HMSFinalwithout database\\Run\\rprt\\HmsReports
        JasperReport jr =JasperCompileManager.compileReport(jd);
       JasperPrint j= JasperFillManager.fillReport(jr,para,con);
        JasperViewer.viewReport(j,false);
        //JRViewer v=new JRViewer(j);
        //panel1.setLayout(new BorderLayout());
        //panel1.add(v);
        OutputStream os = new FileOutputStream(new File ("java\\report"));       
        JasperExportManager.exportReportToPdfStream(j,os);
        
      } 
      catch (Exception e) {System.out.println(e);}
    }
    }
    });



			btncal.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					if(e.getSource()==btncal){
						/*txtid.setText("")*/
					}
					// txtSaleno.setText("");
								txtName.setSelectedItem("");txtCont.setText(""); txtProd.setSelectedItem("");txtadd.setText("");
								txtQty.setText("");txtPrice.setText("");txtAmt.setText("");txtDis.setText("");txtType.setSelectedItem("");
	                      	 String o="1";
                         try{
						 		Integer max_txtid,new_txtid;
						 		  Connection con;
					      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

						Statement stmt=con.createStatement();

						String sql="Select max(Sale_no) from Sale";
						
						PreparedStatement pst;
						 pst=con.prepareStatement(sql);
						 ResultSet rs;
						 rs=pst.executeQuery();
						 if(rs.next())
						 {
                             
						 max_txtid=rs.getInt(1);
						 new_txtid=max_txtid+1;
						 String autono=Integer.toString(new_txtid);
						 txtSaleno.setText(autono);
						 
						 }
						 else{
						 	txtSaleno.setText(o);

						 }
						}catch(Exception en){JOptionPane.showMessageDialog(null,en);}
	                      	
				}
			});
			  /*btnext.addActionListener(new ActionListener(){
			       	public void actionPerformed(ActionEvent e)
			       	{
			       		if(e.getSource()==btnext)
			       		{
			       			System.exit(0);
			       		}
			       	}
			       });*/

			   //validation start
  

  txtQty.addKeyListener(new KeyAdapter(){
	public void keyPressed(KeyEvent en)
	{
		int key=en.getKeyCode();
		if((key>=en.VK_0&&key<=en.VK_9)||(key>=en.VK_NUMPAD0&&key<=en.VK_NUMPAD9)||key==KeyEvent.VK_BACK_SPACE||key==KeyEvent.VK_DELETE)
			{txtQty.setEditable(true);}
		else
			{txtQty.setEditable(false);}
		
	}
});
                txtPrice.addKeyListener(new KeyAdapter(){
	public void keyPressed(KeyEvent en)
	{
		int key=en.getKeyCode();
		if((key>=en.VK_0&&key<=en.VK_9)||(key>=en.VK_NUMPAD0&&key<=en.VK_NUMPAD9)||key==KeyEvent.VK_BACK_SPACE||key==KeyEvent.VK_DELETE)
			{txtPrice.setEditable(true);}
		else
			{txtPrice.setEditable(false);}
		
	}
});
   
            txtAmt.addKeyListener(new KeyAdapter(){
	public void keyPressed(KeyEvent en)
	{
		int key=en.getKeyCode();
		if((key>=en.VK_0&&key<=en.VK_9)||(key>=en.VK_NUMPAD0&&key<=en.VK_NUMPAD9)||key==KeyEvent.VK_BACK_SPACE||key==KeyEvent.VK_DELETE)
			{txtAmt.setEditable(true);}
		else
			{txtAmt.setEditable(false);}
		
	}
});
             txtDis.addKeyListener(new KeyAdapter(){
	public void keyPressed(KeyEvent en)
	{
		int key=en.getKeyCode();
		if((key>=en.VK_0&&key<=en.VK_9)||(key>=en.VK_NUMPAD0&&key<=en.VK_NUMPAD9)||key==KeyEvent.VK_BACK_SPACE||key==KeyEvent.VK_DELETE)
			{txtDis.setEditable(true);}
		else
			{txtDis.setEditable(false);}
		
	}
});

			      txtCont.addKeyListener(new KeyAdapter(){
             public void keyReleased(KeyEvent ex){
             	String expression="^[0-9]{10}$";
             	Pattern p=Pattern.compile(expression);
             	Matcher m=p.matcher(txtCont.getText());
             	if(!m.matches()){
             		validcontno.setText("Invalid Contact");
             	}else{
             		validcontno.setText(null);
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
         });

                txtDis.addFocusListener(new FocusAdapter(){
              public void focusLost(FocusEvent en)
              {
                if(en.getSource()==txtDis){}
                    double quantity,price,amt,discount,total;
   
    try
    { 
      quantity=Double.parseDouble(txtQty.getText());
      price=Double.parseDouble(txtPrice.getText());
      discount=Double.parseDouble(txtDis.getText());
      //total=Double.parseDouble(txtAmt.getText());

      amt=quantity*price;
      total=amt-discount;
      String amount1=Double.toString(total);
      txtAmt.setText(amount1);

     
      }catch(Exception e){}


    }
    });




				
              panelco.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Sale"));
              //panel1co.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Sale"));
              //panel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Member details table"));
 add(bkg1);
 add(panelco);


}
public static void main(String args[])
{

	 PropertyConfigurator.configure("log4j.properties");
          logger.debug("THis iS DEBUG");
          logger.debug("THis iS INFo");
          logger.debug("THis iS WARN");
          logger.debug("THis iS ERROR");
          logger.debug("THis iS FATAL");
  Sale sm=new Sale();
  sm.setTitle("suppliermaster");
}
}

