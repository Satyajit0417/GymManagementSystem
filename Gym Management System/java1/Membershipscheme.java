import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.io.*;
import java.util.Date; 
import java.text.SimpleDateFormat;

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



public class Membershipscheme extends JInternalFrame
{
	 final static Logger logger = Logger.getLogger(Membershipscheme.class);
public  Membershipscheme()
{


								 ImageIcon bkg=new ImageIcon("image/sb3.jpg");
                           JLabel bkg1 = new JLabel("",bkg,JLabel.CENTER);
                           Image img=bkg.getImage();
                           Image temp_img=img.getScaledInstance(1280,800,Image.SCALE_SMOOTH);
                           bkg=new ImageIcon(temp_img);
                           bkg1.setBounds(0,0,1280,700);

 setTitle("Membershipscheme ");
					setClosable(true);
					setVisible(true);
					setLayout(null);
					BasicInternalFrameUI basicInternalFrameUI=(( javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI());
					for(MouseListener listener:basicInternalFrameUI.getNorthPane().getMouseListeners())
                 {
                 	basicInternalFrameUI.getNorthPane().removeMouseListener(listener);
                 }

					Color c=new Color(255,153,153);

						JPanel panel=new JPanel();
					panel.setBounds(0,0,1270,660);
				     panel.setBackground(c);

					/*JPanel panel2=new JPanel();  
               panel2.setBounds(3,480,1265,180);    
               panel2.setBackground(c);  */
               
JTable  table = new JTable();
DefaultTableModel model = new DefaultTableModel();
table.setModel(model); 
Object[] column={"member_id","member_name","membership","str_date","ex_date","coach","batch","time","fees","discount","total",};
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
String sql = "select * from memberscheme ORDER BY member_id DESC ";
PreparedStatement ps = con.prepareStatement(sql);
ResultSet rs = ps.executeQuery();
while(rs.next())
{ 
model.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getInt(9),rs.getInt(10),rs.getInt(11)});
}System.out.println("my");
}catch(Exception ex){JOptionPane.showMessageDialog(null,ex);}
scroll.setBounds(500,530,600,125);
add(scroll);


 

				

				 JLabel labelmeId=new JLabel("Membership Id");
				 labelmeId.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 15));
		         labelmeId.setBackground(Color.BLACK);
				 labelmeId.setBounds(80,60,150,30);
				 labelmeId.setForeground(Color.MAGENTA);
				 add(labelmeId);

				  JLabel labelmename=new JLabel("Member name");
				  labelmename.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 15));
		         labelmename.setBackground(Color.BLACK);
				 labelmename.setBounds(80,180,120,30);
				 labelmename.setForeground(Color.MAGENTA);
				 add(labelmename);
                  JLabel validname=new JLabel();
				 validname.setBounds(270,210,150,30);
				 validname.setForeground(Color.red);
				 add(validname);

				  JLabel labelbatch=new JLabel("Batch");
			   labelbatch.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 15));
		     labelbatch.setBackground(Color.BLACK);
			 labelbatch.setBounds(80,300,100,30);
			 labelbatch.setForeground(Color.MAGENTA);
			  add(labelbatch);

			

				 	 Date date=new Date();
				 SimpleDateFormat fordate=new SimpleDateFormat("dd/MM/YYYY");
				 String strDate=fordate.format(date);
				 JLabel labeldate=new JLabel("Str Date");
				  labeldate.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 15));
		         labeldate.setBackground(Color.BLACK);
				 labeldate.setBounds(620,60,150,30);
				 labeldate.setForeground(Color.MAGENTA);
				 add(labeldate);

				  JLabel labelexdate=new JLabel("Ex Date");
			   labelexdate.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 15));
		     labelexdate.setBackground(Color.BLACK);
			 labelexdate.setBounds(620,180,100,30);
			 labelexdate.setForeground(Color.MAGENTA);
			  add(labelexdate);

			     JLabel labelcoach=new JLabel("Coach name");
			   labelcoach.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 15));
		     labelcoach.setBackground(Color.BLACK);
			 labelcoach.setBounds(620,300,100,30);
			 labelcoach.setForeground(Color.MAGENTA);
			  add(labelcoach);
				 
				/* JLabel labelDur=new JLabel("Duration(month)");
				 labelDur.setBounds(40,180,100,20);
				 labelDur.setVisible(false);
				 add(labelDur);*/

				  JLabel labelmeShip=new JLabel("Membership");
				 labelmeShip.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 15));
		         labelmeShip.setBackground(Color.BLACK);
				 labelmeShip.setBounds(60,410,100,30);
				 labelmeShip.setForeground(Color.MAGENTA);
				 add(labelmeShip);

				   

				 JLabel labelFees=new JLabel("Fees");
				  labelFees.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 15));
		         labelFees.setBackground(Color.BLACK);
				 labelFees.setBounds(320,410,100,30);
				 labelFees.setForeground(Color.MAGENTA);
				 add(labelFees);
				 
				 JLabel labeldis=new JLabel("Discount");
				  labeldis.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 15));
		         labeldis.setBackground(Color.BLACK);
				 labeldis.setBounds(580,410,100,30);
				 labeldis.setForeground(Color.MAGENTA);
				 add(labeldis);

				  JLabel labeltotal=new JLabel("Total");
				   labeltotal.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 15));
		         labeltotal.setBackground(Color.BLACK);
				 labeltotal.setBounds(840,410,100,30);
				 labeltotal.setForeground(Color.MAGENTA);
				 add(labeltotal);

				  JLabel labeltime=new JLabel("Batch_Time");
				   labeltime.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 15));
		         labeltime.setBackground(Color.BLACK);
				 labeltime.setBounds(30,540,100,30);
				 labeltime.setForeground(Color.MAGENTA);
				 add(labeltime);


								 
				 JTextField txtId=new JTextField();
				 txtId.setBounds(260,60,200,30);
				  txtId.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 15));
				 add(txtId);
                          String o="1";
                         try{
						 		Integer max_txtid,new_txtid;
						 		  Connection con;
					      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

						Statement stmt=con.createStatement();

						String sql="Select max(member_id) from memberscheme";
						
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
						}catch(Exception en){JOptionPane.showMessageDialog(null,en);}//auto number




				  JTextField txtName=new JTextField();
				 txtName.setBounds(260,180,200,30);
				  txtName.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 13));
				 add(txtName);
				 

				  JTextField txtBatch=new JTextField();
				 txtBatch.setBounds(260,300,200,30);
				  txtBatch.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 13));
				 add(txtBatch);

								
				   JTextField txtDate=new JTextField();
                 txtDate.setBounds(750,60,200,30);
                  txtDate.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 13));
                 txtDate.setText(strDate);
                 txtDate.setEditable(false);
                 add(txtDate);

                 JTextField txtexdt=new JTextField();
			    txtexdt.setBounds(750,180,200,30);
			     txtexdt.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 13));
			    txtexdt.setEditable(true);
			    add(txtexdt);/*try{
              			   Connection con;
					    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

						Statement stmt=con.createStatement();

						String sql="Select str_date from memberscheme";  			 
						PreparedStatement pst;
						 pst=con.prepareStatement(sql);
						 ResultSet rs;
						 rs=pst.executeQuery();
						 while(rs.next())
						 {
			          			txtexdt.addItem(rs.getString("str_date")) ;	
                         
							}
						
					}
                         catch(Exception ex)
                         {
                         		JOptionPane.showMessageDialog(null,ex);
                         }*/

                  JTextField txtCoach=new JTextField();
				 txtCoach.setBounds(750,300,200,30);
				  txtCoach.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 13));
				 add(txtCoach);
				 
							    
				/* JComboBox txtDurtion=new JComboBox();
				 txtDurtion.setBounds(220,180,120,30);
				 txtDurtion.setEditable(true);
				 txtDurtion.setVisible(false);
				 add(txtDurtion);*/

				  JTextField txtMebship=new JTextField();
				 txtMebship.setBounds(40,450,200,30);
				  txtMebship.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 13));
				 txtMebship.setEditable(true);
				 add(txtMebship);

				 
				 JTextField txtFees=new JTextField();
				 txtFees.setBounds(300,450,200,30);
				  txtFees.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 13));
				 add(txtFees);

				  JTextField txtDis=new JTextField();
				 txtDis.setBounds(560,450,200,30);
				  txtDis.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 13));
				 add(txtDis);

				  JTextField txtTotal=new JTextField();
				 txtTotal.setBounds(820,450,200,30);
				  txtTotal.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 13));
				 add(txtTotal);

				  JTextField txtTime=new JTextField();
				 txtTime.setBounds(130,540,180,30);
				  txtTime.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 13));
				 add(txtTime);


                

                 
				
                
                /* JPanel panel1=new JPanel();
					panel1.setBounds(1050,100,200,500);
				     panel1.setBackground(Color.MAGENTA);*/

				 JButton btnsave=new JButton("Save");
				 btnsave.setBounds(1000,30,160,40);
				 add(btnsave);
				 JButton btnupdt=new JButton("Update");
				 btnupdt.setBounds(1000,100,160,40);
				 add(btnupdt);
				 JButton btndelt=new JButton("Delete");
				 btndelt.setBounds(1000,180,160,40);
				 add(btndelt);
				 JButton btnprint=new JButton("Print");
				 btnprint.setBounds(1000,260,160,40);
				 add(btnprint);
				 JButton btncancle=new JButton("Cancle");
				 btncancle.setBounds(1000,340,160,40);
				 add(btncancle);
				 /*JButton btnexit=new JButton("Exit");
				 btnexit.setBounds(1000,420,160,40);
				 add(btnexit);*/
				// add(panel1);

				  add(panel);
				//    add(panel2);
				


				              panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), " membership"));
				           //   panel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), ""));
				              //panel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Membership details table"));
			


				 Object[] row=new Object[11];
			btnsave.addActionListener(new ActionListener(){
 	public void actionPerformed(ActionEvent e)
 	{     
             if(e.getSource()==btnsave)
                 
                 //  Connection con=null;
                  //  Statement stmt=null;

				try
				{        
                        Class.forName("oracle.jdbc.driver.OracleDriver"); 
					     Connection con;
					      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

						Statement stmt=con.createStatement();

						String sql="Insert into memberscheme(member_id,member_name,membership,str_date,ex_date,coach,batch,batch_time,fees,discount,total) Values(" + txtId.getText() + ",'" + txtName.getText() + "','" + txtMebship.getText() + "','" + txtDate.getText() + "'," + txtexdt.getText() + ",'" + txtCoach.getText() + "',"+txtBatch.getText()+",'"+txtTime.getText()+"',"+txtFees.getText()+","+txtDis.getText()+","+txtTotal.getText()+" )";
						 PreparedStatement pst;
						 pst=con.prepareStatement(sql);
						 ResultSet rs;
						 rs=pst.executeQuery();
						// while(rs.next())
						 {
						 	    row[0]=txtId.getText();
								row[1]=txtName.getText();
								row[2]=txtMebship.getText();
								row[3]=txtDate.getText();
								row[4]=txtexdt.getText();
								row[5]=txtCoach.getText();
								row[6]=txtBatch.getText();
								row[7]=txtTime.getText();
							    //row[3]=txtDurtion.getSelectedItem();
								row[8]=txtFees.getText();
								row[9]=txtDis.getText();
								row[10]=txtTotal.getText();
								 model.addRow(row);
						 	JOptionPane.showMessageDialog(null,"Inserted succesfully...");
							//stmt.close();
							//con.close();

							}
						
					}
                         catch(Exception ex)
                         {		JOptionPane.showMessageDialog(null,ex);
                         		
                                JOptionPane.showMessageDialog(null,"Doubliction Occurs...");	
                         		
                         }
                         String o="1";
                         try{
						 		Integer max_txtid,new_txtid;
						 		  Connection con;
					      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

						Statement stmt=con.createStatement();

						String sql="Select max(member_id) from memberscheme";
						
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
	                        	//if(txtName.getText().isEmpty()){	JOptionPane.showMessageDialog(null,"Please enter name");} 
	                        	//	if(txtMebship.getSelectedItem().isEmpty()){	JOptionPane.showMessageDialog(null,"Please enter membership");}
	                        			//if(txtDurtion.setSelectedItem().isEmpty()){	JOptionPane.showMessageDialog(null,"Please enter duration");}
	                        	            if(txtFees.getText().isEmpty()){	JOptionPane.showMessageDialog(null,"Please enter fees");}          
	                        	            if(txtDis.getText().isEmpty()){	JOptionPane.showMessageDialog(null,"Please enter discount");}          
	                        	            if(txtTotal.getText().isEmpty()){	JOptionPane.showMessageDialog(null,"Please enter Total");}          

								 //txtId.setText("");
								 txtName.setText("");txtMebship.setText("");/*txtDurtion.setSelectedItem("");*/txtFees.setText("");txtDis.setText("");txtTotal.setText("");//txtbatch.setSelectedItem("");
								//txtDate.setText("");
								 txtexdt.setText("");txtCoach.setText("");txtBatch.setText("");
	                      		

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

						String sql="Update memberscheme set member_name='" + txtName.getText() + "',membership='" + txtMebship.getText() + "',str_date='"+txtDate.getText()+"',ex_date="+txtexdt.getText()+",coach='"+txtCoach.getText()+"',batch="+txtBatch.getText()+",batch_time='"+txtTime.getText()+"',fees=" + txtFees.getText() +",discount=" + txtDis.getText() +",total=" + txtTotal.getText() +" where member_id="+txtId.getText()+"";
						 
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
			                   model.setValueAt(txtMebship.getText(), i, 2);
			                     model.setValueAt(txtDate.getText(), i, 3);
			                    model.setValueAt(txtexdt.getText(), i, 4);
			                      model.setValueAt(txtCoach.getText(), i, 5);
			                    model.setValueAt(txtBatch.getText(), i, 6);
			                     model.setValueAt(txtTime.getText(), i, 7);
						 	  // model.setValueAt(txtDurtion.getSelectedItem(), i, 3);
			                   model.setValueAt(txtFees.getText(), i, 8);
			                    model.setValueAt(txtDis.getText(), i, 9);
			                     model.setValueAt(txtTotal.getText(), i, 10);
			                 
			               //  model.addRow(row);
						 		
						 	JOptionPane.showMessageDialog(null,"Update succesfully...");
						 	 // txtId.setText("");
						 	  txtName.setText("");txtMebship.setText("");txtFees.setText("");txtDis.setText("");txtTotal.setText("");//txtDate.setText("");
						 	  txtexdt.setText("");txtCoach.setText("");txtBatch.setText("");
						 	
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

						String sql="Select max(member_id) from memberscheme";
						
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

			btndelt.addActionListener(new ActionListener(){
 	public void actionPerformed(ActionEvent e)
 	{     
             if(e.getSource()==btndelt)
             
				try
				{
                          
					     Connection con;
					      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

						Statement stmt=con.createStatement();

						String sql="Delete from memberscheme where member_id=" + txtId.getText() + "";
						 
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
						 	
					         
					        // txtId.setText("");
					         txtName.setText("");txtMebship.setText("");txtFees.setText("");txtDis.setText("");txtTotal.setText("");//txtDate.setText("")
					         txtexdt.setText("");txtCoach.setText("");txtBatch.setText("");


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

						String sql="Select max(member_id) from memberscheme";
						
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
						 	txtMebship.setText(model.getValueAt(i,2).toString());
						 	txtDate.setText(model.getValueAt(i,3).toString());
						 	txtexdt.setText(model.getValueAt(i,4).toString());
						 	txtCoach.setText(model.getValueAt(i,5).toString());
						 	txtBatch.setText(model.getValueAt(i,6).toString());
						 	txtTime.setText(model.getValueAt(i,7).toString());
						 	//txtDurtion.setSelectedItem(model.getValueAt(i,3).toString());
						 	txtFees.setText(model.getValueAt(i,8).toString());
						 		txtDis.setText(model.getValueAt(i,9).toString());
						 			txtTotal.setText(model.getValueAt(i,10).toString());
						 }
			});


			       btncancle.addActionListener(new ActionListener(){
			       	public void actionPerformed(ActionEvent e)
			       	{
			       		if(e.getSource()==btncancle)
			       			//txtId.setText("");
			       		txtName.setText("");txtMebship.setText("");txtFees.setText("");txtDis.setText("");txtTotal.setText("");txtDis.setText("");txtTotal.setText("");	//txtDate.setText("");
			       	txtexdt.setText("");txtCoach.setText("");txtBatch.setText("");

			       	String o="1";
                         try{
						 		Integer max_txtid,new_txtid;
						 		  Connection con;
					      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

						Statement stmt=con.createStatement();

						String sql="Select max(member_id) from memberscheme";
						
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


	  btnprint.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) 
      { 
          if(arg0.getSource()==btnprint){

      Connection con;
      try {

        Integer p1=Integer.parseInt(txtId.getText());
        Integer sum=p1-1;
        String nstr=Integer.toString(sum);
         HashMap para = new HashMap();
        para.put("Invoice_no",nstr);


      Class.forName("oracle.jdbc.driver.OracleDriver");
      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");
        /*   panel1.removeAll();
           panel1.repaint();
           panel1.revalidate();*/

        InputStream in=new FileInputStream(new File("E:\\java1\\report\\purchase.jrxml"));         //G:\\HMSFinalwithout database\\Run\\reports
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



			     /*  btnexit.addActionListener(new ActionListener(){
			       	public void actionPerformed(ActionEvent e)
			       	{
			       		if(e.getSource()==btnexit)
			       		{
			       			System.exit(0);
			       		}
			       	}
			       });*/

			         txtName.addKeyListener(new KeyAdapter(){

             public void keyPressed(KeyEvent ex){

                char ch = ex.getKeyChar();

                if(Character.isLetter(ch)||Character.isWhitespace(ch)||Character.isISOControl(ch))
                {
                	txtName.setEditable(true);
                	validname.setText("");

                }
                else{txtName.setEditable(false);
                	validname.setText("Enter only character");}
                 
                   }
                      });


			          txtCoach.addKeyListener(new KeyAdapter(){

             public void keyPressed(KeyEvent ex){

                char ch = ex.getKeyChar();

                if(Character.isLetter(ch)||Character.isWhitespace(ch)||Character.isISOControl(ch))
                {
                	txtCoach.setEditable(true);
                	

                }
                else{txtCoach.setEditable(false);
				}                 
                   }
                      });


                      	 txtId.addKeyListener(new KeyAdapter(){
	        public void keyPressed(KeyEvent en)
	     {
		       int key=en.getKeyCode();
		         if((key>=en.VK_0&&key<=en.VK_9)||(key>=en.VK_NUMPAD0&&key<=en.VK_NUMPAD9)||key==KeyEvent.VK_BACK_SPACE||key==KeyEvent.VK_DELETE)
			    {
			    	txtId.setEditable(true); }
         		else{
         			txtId.setEditable(false);}
		
	}
});


			 txtBatch.addKeyListener(new KeyAdapter(){
	        public void keyPressed(KeyEvent en)
	     {
		       int key=en.getKeyCode();
		         if((key>=en.VK_0&&key<=en.VK_9)||(key>=en.VK_NUMPAD0&&key<=en.VK_NUMPAD9)||key==KeyEvent.VK_BACK_SPACE||key==KeyEvent.VK_DELETE)
			    {
			    	txtBatch.setEditable(true); }
         		else{
         			txtBatch.setEditable(false);}
		
	}
});

			
			 

			            
			            txtMebship.addKeyListener(new KeyAdapter(){
	        public void keyPressed(KeyEvent en)
	     {
		       int key=en.getKeyCode();
		         if((key>=en.VK_0&&key<=en.VK_9)||(key>=en.VK_NUMPAD0&&key<=en.VK_NUMPAD9)||key==KeyEvent.VK_BACK_SPACE||key==KeyEvent.VK_DELETE)
			    {
			    	txtMebship.setEditable(true); }
         		else{
         			txtMebship.setEditable(false);}
		
	}
});
			 

			 txtFees.addKeyListener(new KeyAdapter(){
	        public void keyPressed(KeyEvent en)
	     {
		       int key=en.getKeyCode();
		         if((key>=en.VK_0&&key<=en.VK_9)||(key>=en.VK_NUMPAD0&&key<=en.VK_NUMPAD9)||key==KeyEvent.VK_BACK_SPACE||key==KeyEvent.VK_DELETE)
			    {
			    	txtFees.setEditable(true); }
         		else{
         			txtFees.setEditable(false);}
		
	}
});

			 txtDis.addKeyListener(new KeyAdapter(){
	        public void keyPressed(KeyEvent en)
	     {
		       int key=en.getKeyCode();
		         if((key>=en.VK_0&&key<=en.VK_9)||(key>=en.VK_NUMPAD0&&key<=en.VK_NUMPAD9)||key==KeyEvent.VK_BACK_SPACE||key==KeyEvent.VK_DELETE)
			    {
			    	txtDis.setEditable(true); }
         		else{
         			txtDis.setEditable(false);}
		
	}
});

			 txtTotal.addKeyListener(new KeyAdapter(){
	        public void keyPressed(KeyEvent en)
	     {
		       int key=en.getKeyCode();
		         if((key>=en.VK_0&&key<=en.VK_9)||(key>=en.VK_NUMPAD0&&key<=en.VK_NUMPAD9)||key==KeyEvent.VK_BACK_SPACE||key==KeyEvent.VK_DELETE)
			    {
			    	txtTotal.setEditable(true); }
         		else{
         			txtTotal.setEditable(false);}
		
	}
});


			   txtDis.addFocusListener(new FocusAdapter(){
              public void focusLost(FocusEvent en)
              {
                if(en.getSource()==txtDis){}
                    double fee,discount,total,amt,mship;
   
    try
    { 
      fee=Double.parseDouble(txtFees.getText());
      discount=Double.parseDouble(txtDis.getText());
       mship=Double.parseDouble(txtMebship.getText());
       //int mship=Integer.valueOf((String)txtMebship.getSelectedItem());                //conversion by wrapper class in combobox
      
     
      //total1=Double.parseDouble(txtAmt.getText());

      total=mship*fee;  
      amt=total-discount;
      String amount1=Double.toString(amt);
      txtTotal.setText(amount1);

     
      }catch(Exception e){}


    }
    });



           //autoselected

			   txtId.addKeyListener(new KeyAdapter(){
	        public void keyReleased(KeyEvent s)
			   	{
			   		if(s.getSource()==txtId){
			   			try{
			   				Class.forName("oracle.jdbc.driver.OracleDriver");
                             Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");
    
			   				String query="select *from Memberinfo where member_id=? ";
			   				PreparedStatement pst=con.prepareStatement(query);
			   				pst.setString(1,(String)txtId.getText());
			   				ResultSet rs=pst.executeQuery();
			   				while(rs.next())
			   				{
			   					txtName.setText(rs.getString("member_name"));
			   					txtBatch.setText(rs.getString("batch"));
			   					txtMebship.setText(rs.getString("membership"));

			   				}
			   				pst.close();
			   			}catch(Exception ex){ex.printStackTrace();}

			   		}

			   	}
			   });

			   try{
			   				Class.forName("oracle.jdbc.driver.OracleDriver");
                             Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");
    
			   				String query="select *from Memberinfo where member_id=? ";
			   				PreparedStatement pst=con.prepareStatement(query);
			   				pst.setString(1,(String)txtId.getText());
			   				ResultSet rs=pst.executeQuery();
			   				while(rs.next())
			   				{
			   					txtName.setText(rs.getString("member_name"));
			   					txtBatch.setText(rs.getString("batch"));
			   					txtMebship.setText(rs.getString("membership"));

			   				}
			   				pst.close();
			   			}catch(Exception ex){ex.printStackTrace();}


						
			   txtId.addKeyListener(new KeyAdapter(){
	        public void keyReleased(KeyEvent s)
			   	{
			   		if(s.getSource()==txtId){
			   			try{
			   				Class.forName("oracle.jdbc.driver.OracleDriver");
                             Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");
    
			   				String query="select *from Batch where batch=?";
			   				PreparedStatement pst=con.prepareStatement(query);
			   				pst.setString(1,(String)txtBatch.getText());
			   				ResultSet rs=pst.executeQuery();
			   				while(rs.next())
			   				{
			   					txtCoach.setText(rs.getString("coach_name"));
			   					txtTime.setText(rs.getString("batch_time"));
			   					//txtMebship.setText(rs.getString("membership"));

			   				}
			   				pst.close();
			   			}catch(Exception ex){ex.printStackTrace();}

			   		}

			   	}
			   });


			   try{
			   				Class.forName("oracle.jdbc.driver.OracleDriver");
                             Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");
    
			   				String query="select *from Batch where batch=?";
			   				PreparedStatement pst=con.prepareStatement(query);
			   				pst.setString(1,(String)txtBatch.getText());
			   				ResultSet rs=pst.executeQuery();
			   				while(rs.next())
			   				{
			   					txtCoach.setText(rs.getString("coach_name"));
			   					txtTime.setText(rs.getString("batch_time"));
			   					//txtMebship.setText(rs.getString("membership"));

			   				}
			   				pst.close();
			   			}catch(Exception ex){ex.printStackTrace();}
			   			 add(bkg1);
			   			 add(panel);




				}
				public static void main(String args[])
				{

		   PropertyConfigurator.configure("log4j.properties");
          logger.debug("THis iS DEBUG");
          logger.debug("THis iS INFo");
          logger.debug("THis iS WARN");
          logger.debug("THis iS ERROR");
          logger.debug("THis iS FATAL");

				  Membershipscheme ms=new Membershipscheme();
				  ms.setTitle("membershipsceheme");
				}
				}

