import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import java.util.Date; 
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.*;
import javax.swing.table.JTableHeader;
 

public class Member extends JInternalFrame
{
    
	String gender;
	JTableHeader tableHeader;
	ImageIcon bkg;
	JTable table;


	JButton btninsrt,btnupdt,btndlt,btncnl;

 public Member()
{
								 ImageIcon bkg=new ImageIcon("image/sb3.jpg");
                           JLabel bkg1 = new JLabel("",bkg,JLabel.CENTER);
                           Image img=bkg.getImage();
                           Image temp_img=img.getScaledInstance(1280,800,Image.SCALE_SMOOTH);
                           bkg=new ImageIcon(temp_img);
                           bkg1.setBounds(0,0,1280,700);
                           

					     
				

                         

                    setTitle("Member Entry ");
		            setVisible(true);
					setClosable(true);
					setLayout(null);
					BasicInternalFrameUI basicInternalFrameUI=(( javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI());
					for(MouseListener listener:basicInternalFrameUI.getNorthPane().getMouseListeners())
                 {
                 	basicInternalFrameUI.getNorthPane().removeMouseListener(listener);
                 }

                     
                         
                     	  Color c = new Color(255,20,20); 

                JPanel panel=new JPanel();  
              panel.setBounds(2,0,1265,810);    
            //  panel.setBackground(c);  
               

                   /* JPanel panel2=new JPanel();  
              panel2.setBounds(3,510,1265,150);    
              panel2.setBackground(C);*/  
               
JTable  table = new JTable();
DefaultTableModel model = new DefaultTableModel();
table.setModel(model); 
Object[] column={"member_id","member_name","gender","cont_no","m_address","m_ship","regi_date","batch","weight","height","inch","bmi"};
model.setColumnIdentifiers(column);
table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
table.setFillsViewportHeight(true);
JScrollPane scroll = new JScrollPane(table);
scroll.setHorizontalScrollBarPolicy(
JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
scroll.setVerticalScrollBarPolicy(
JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 

table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
//table.setBackground(bkg);
JTableHeader tableHeader = table.getTableHeader();
tableHeader.setBackground(Color.red);
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
String sql = "select * from Memberinfo ORDER BY member_id DESC";
PreparedStatement ps = con.prepareStatement(sql);
ResultSet rs = ps.executeQuery();
while(rs.next())
{ 
model.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getInt(10),rs.getInt(11),rs.getInt(12)});
}System.out.println("my");
}catch(Exception ex){JOptionPane.showMessageDialog(null,ex);}
scroll.setBounds(100,530,870,100);
add(scroll);


//  panel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Member details table"));
  //add(panel2);

                  

   				
   			
  	        
			 JLabel labelid=new JLabel("Member Id");
			 labelid.setBounds(120,60,80,30);
			 labelid.setFont(new Font("Comic Sans MS/ Sans-serif", Font.BOLD, 15));
		     labelid.setForeground(Color.MAGENTA);
		     add(labelid);

			 JLabel labelname=new JLabel("Member Name");
			  labelname.setFont(new Font("Comic Sans MS/ Sans-serif", Font.BOLD, 15));
		     labelname.setBackground(Color.MAGENTA);
			 labelname.setBounds(120,130,120,20);
			 labelname.setForeground(Color.MAGENTA);
			 add(labelname);

			  JLabel validname=new JLabel();
			 validname.setBounds(300,160,150,20);
			 validname.setForeground(Color.RED);
			 add(validname);

			 JLabel labelgender=new JLabel("Gender");
			  labelgender.setFont(new Font("Comic Sans MS/ Sans-serif", Font.BOLD, 15));
		     labelgender.setBackground(Color.MAGENTA);
			 labelgender.setBounds(120,210,120,20);
			 labelgender.setForeground(Color.MAGENTA);
			 add(labelgender);

			 JLabel labelcont=new JLabel("Contact No.");
			  labelcont.setFont(new Font("Comic Sans MS/ Sans-serif", Font.BOLD, 15));
		     labelcont.setBackground(Color.BLACK);
			 labelcont.setBounds(120,290,120,20);
			 labelcont.setForeground(Color.MAGENTA);
			  add(labelcont);

			   JLabel validcont=new JLabel();
			 validcont.setBounds(300,320,120,15);
              validcont.setForeground(Color.RED);
			  add(validcont);

			 JLabel labeladd=new JLabel("Member Address");
			  labeladd.setFont(new Font("Comic Sans MS/ Sans-serif", Font.BOLD, 15));
		     labeladd.setBackground(Color.BLACK);
			 labeladd.setBounds(650,210,150,20);
			 labeladd.setForeground(Color.MAGENTA);
			 add(labeladd);

			  JLabel labelmebrship=new JLabel("Membership");
			   labelmebrship.setFont(new Font("Comic Sans MS/ Sans-serif", Font.BOLD, 15));
		     labelmebrship.setBackground(Color.BLACK);
			 labelmebrship.setBounds(650,60,120,30);
			 labelmebrship.setForeground(Color.MAGENTA);
			  add(labelmebrship);


			  	 Date date=new Date();
				 SimpleDateFormat fordate=new SimpleDateFormat("dd/MM/YYYY");
				 String strDate=fordate.format(date);
				 JLabel labeldate=new JLabel("Register Date");
				  labeldate.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 15));
		         labeldate.setBackground(Color.BLACK);
				 labeldate.setBounds(650,130,150,30);
				 labeldate.setForeground(Color.MAGENTA);
				 add(labeldate);

				  
			/* JLabel labelexdate=new JLabel("Ex Date");
			   labelexdate.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 15));
		     labelexdate.setBackground(Color.BLACK);
			 labelexdate.setBounds(650,190,100,30);
			  add(labelexdate);*/

			  JLabel labelbatch=new JLabel("Batch");
			    labelbatch.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 15));
		     labelbatch.setBackground(Color.BLACK);
			 labelbatch.setBounds(660,290,80,30);
			 labelbatch.setForeground(Color.MAGENTA);
			 add(labelbatch);

			  JLabel labeltip=new JLabel("Tip :-");
			    labeltip.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 15));
		     labeltip.setBackground(Color.BLACK);
			 labeltip.setBounds(870,430,80,30);
			 labeltip.setForeground(Color.MAGENTA);
			 add(labeltip);
			   JLabel labeltip1=new JLabel();
			   labeltip1.setFont(new Font("Comic Sans MS /Sans-serif", Font.BOLD, 15));
		     labeltip1.setBackground(Color.RED);
			 labeltip1.setBounds(920,435,200,20);
			 labeltip1.setForeground(Color.RED);
			 add(labeltip1);
			 
			  JLabel labelweight=new JLabel("Weight");
			   labelweight.setFont(new Font("Comic Sans MS/ Sans-serif", Font.BOLD, 15));
		     labelweight.setBackground(Color.BLACK);
			 labelweight.setBounds(140,395,80,20);
			 labelweight.setForeground(Color.MAGENTA);
			 add(labelweight);
			
			  JLabel labelheight=new JLabel("Height");
			   labelheight.setFont(new Font("Comic Sans MS/ Sans-serif", Font.BOLD, 15));
		     labelheight.setBackground(Color.BLACK);
			 labelheight.setBounds(415,395,80,20);
			 labelheight.setForeground(Color.MAGENTA);
			 add(labelheight);

			 JLabel labelbmi=new JLabel("BMI");
			  labelbmi.setFont(new Font("Comic Sans MS/ Sans-serif", Font.BOLD, 15));
		     labelbmi.setBackground(Color.BLACK);
			 labelbmi.setBounds(690,395,80,20);
			 labelbmi.setForeground(Color.MAGENTA);
			 add(labelbmi);

           /* JLabel labelfee=new JLabel("Paid Fee");
             labelfee.setFont(new Font("Comic Sans MS/ Sans-serif", Font.BOLD, 15));
		     labelfee.setBackground(Color.BLACK);
			 labelfee.setBounds(590,240,80,20);
			 labelfee.setVisible(false);*/


			/*  JLabel valid1=new JLabel();
			 valid1.setBounds(700,270,150,10);
			 valid1.setForeground(Color.red);  
			 //valid1.setVisible(false);
			 add(valid1);
		//	 add(labelfee);*/


			  JTextField txtid=new JTextField();
			 txtid.setBounds(290,60,200,30);
			 add(txtid);
			// txtid.setText(autono);
			  	 String o="1";
                         try{
						 		Integer max_txtid,new_txtid;
						 		  Connection con;
					      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

						Statement stmt=con.createStatement();

						String sql="Select max(member_id) from Memberinfo  ";
						
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
						 	}
						 catch(Exception en){JOptionPane.showMessageDialog(null,en);}
						

			 JTextField txtname=new JTextField();
			 txtname.setBounds(290,130,200,30);  
			  add(txtname);

               ButtonGroup bg=new ButtonGroup();
              final JRadioButton male=new JRadioButton("Male");
              male.setFont(new Font("Comic Sans MS/ Sans-serif", Font.BOLD, 13));
			  male.setBounds(290,210,100,30);
			   bg.add(male);
			   add(male);
			    final JRadioButton female=new JRadioButton("Female");
			    female.setFont(new Font("Comic Sans MS/ Sans-serif", Font.BOLD, 13));
			  female.setBounds(390,210,100,30);
			  bg.add(female);
			  add(female);

			 JTextField txtcont=new JTextField();
			 txtcont.setBounds(290,290,200,30);
			  add(txtcont);

			 JTextArea txtadd=new JTextArea();  
             txtadd.setBounds(800,210,200,30);  
              add(txtadd);  			 
			 /* txtcont.addKeyListener(new KeyAdapter(){
	public void keyPressed(KeyEvent en)
	{
		try``				
		{ 
			int i= Integer.parseInt(txtcont.getText());
			show_validation_here.setText("");

		}
		catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog( null,"Invalid Number");
		}
	}
});*/




							JComboBox txtmbrsip=new JComboBox();                  
   			                txtmbrsip.setBounds(800,60,200,30);
			                txtmbrsip.setEditable(true);
			                add(txtmbrsip);
			    	try{
              			   Connection con;
					    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

						Statement stmt=con.createStatement();

						String sql="Select membership from Memberinfo";  			 
						PreparedStatement pst;
						 pst=con.prepareStatement(sql);
						 ResultSet rs;
						 rs=pst.executeQuery();
						 while(rs.next())
						 {
			          			txtmbrsip.addItem(rs.getString("membership")) ;	
                         
							}
						
					}
                         catch(Exception ex)
                         {
                         		JOptionPane.showMessageDialog(null,ex);
                         } //data can be retrive in database in combobox 
	
                         														    
																	                                                             
			     JTextField txtDate=new JTextField();
                 txtDate.setBounds(800,130,200,30);
                 txtDate.setText(strDate);
                 txtDate.setEditable(false);
                 add(txtDate);
				/* JComboBox txtexdt=new JComboBox();
			    txtexdt.setBounds(800,190,200,30);
			    txtexdt.setEditable(true);
			    add(txtexdt);
			    	try{
              			   Connection con;
					    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

						Statement stmt=con.createStatement();

						String sql="Select str_date from Memberinfo";  			 
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
                         }	*/

                JComboBox txtbatch=new JComboBox();
			    txtbatch.setBounds(800,290,200,30);
			     txtbatch.setEditable(false);
			     add(txtbatch);
			     try{
              			   Connection con;
					    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

						Statement stmt=con.createStatement();

						String sql="Select batch from Batch";  			 
						PreparedStatement pst;
						 pst=con.prepareStatement(sql);
						 ResultSet rs;
						 rs=pst.executeQuery();
						 while(rs.next())
						 {
			          			txtbatch.addItem(rs.getString("batch")) ;	
                         
							}
						
					}
                         catch(Exception ex)
                         {
                         		JOptionPane.showMessageDialog(null,ex);
                         }
			
			  JTextField txtweight=new JTextField();
			 txtweight.setBounds(100,430,200,30);
			  add(txtweight);
			 JTextField txtheight=new JTextField();
			 txtheight.setBounds(390,430,95,30);
			  add(txtheight);
			   JTextField txtinch=new JTextField();
			 txtinch.setBounds(490,430,95,30);
			  add(txtinch);

			 JTextField txtbmi=new JTextField();
			 txtbmi.setBounds(660,430,200,30);
			  add(txtbmi);
			/* JTextField txtpaidfee=new JTextField();
			 txtpaidfee.setBounds(490,270,200,30);
			 txtpaidfee.setVisible(false);
			  add(txtpaidfee);*/
			 
			 

			   

			
  
			  JPanel panel1=new JPanel();  
              panel1.setBounds(1100,60,158,350);    
              panel1.setBackground(c);  
               
 JButton btninsrt=new JButton("Insert");
 btninsrt.setBounds(1110,80,140,40);
 add(btninsrt);
 JButton btnupdt=new JButton("Update");
 btnupdt.setBounds(1110,170,140,40);
 add(btnupdt);
 JButton btndlt=new JButton("Delete");
 btndlt.setBounds(1110,260,140,40);
 add(btndlt);
 JButton btncnl=new JButton("Cancle");
 btncnl.setBounds(1110,350,140,40);
 add(btncnl);
  //add(panel1); 
 /*JButton btnext=new JButton("Exit");
 btnext.setBounds(1100,410,120,40);
 add(btnext);*/
  
//add(panel);





   
			 

 

 
            Object[] row=new Object[12];

			btninsrt.addActionListener(new ActionListener(){
 	public void actionPerformed(ActionEvent e)
 	{  
 	
   
            if(e.getSource()==btninsrt){}
   
                 //  Connection con=null;
                  //  Statement stmt=null;
 		String gender="male";

 if(female.isSelected())
  {
        gender="Female";}

             	
				try
				{
                          
					     Connection con;
					      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

						Statement stmt=con.createStatement();

						String sql="Insert into Memberinfo(member_id,member_name,gender,contact_no,member_address,membership,regi_date,batch,weight,height,inch,bmi) Values(" + txtid.getText() + ",'" + txtname.getText() + "','"+gender+"'," + txtcont.getText() + ",'" + txtadd.getText() + "','" + txtmbrsip.getSelectedItem() + "','" + txtDate.getText() + "',"+ txtbatch.getSelectedItem() +","+txtweight.getText()+","+txtheight.getText()+","+txtinch.getText()+","+txtbmi.getText()+")";
						// stmt.executeUpdate(sql);
						PreparedStatement pst;
						pst=con.prepareStatement(sql);
						ResultSet rs;
						rs=pst.executeQuery();
						//while(rs.next())
						 {	
						 		row[0]=txtid.getText();
								row[1]=txtname.getText();
								row[2]=gender;
								row[3]=txtcont.getText();
							    row[4]=txtadd.getText();
								row[5]=txtmbrsip.getSelectedItem();
								row[6]=txtDate.getText();
								//row[7]=txtexdt.getSelectedItem();
								row[7]=txtbatch.getSelectedItem();
								row[8]=txtweight.getText();
								row[9]=txtheight.getText();
								row[10]=txtinch.getText();
								row[11]=txtbmi.getText();
								//row[13]=txtpaidfee.getText();
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

						String sql="Select max(member_id) from Memberinfo";
						
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
						 	}
						 catch(Exception en){JOptionPane.showMessageDialog(null,en);}


						 if(txtid.getText().isEmpty()){	JOptionPane.showMessageDialog(null,"Please enter Id");}
	                        	if(txtname.getText().isEmpty()){	JOptionPane.showMessageDialog(null,"Please enter Name");} 
	                        		//if(gender.isEmpty()){	JOptionPane.showMessageDialog(null,"Please select gender ");}
	                        			if(txtcont.getText().isEmpty()){	JOptionPane.showMessageDialog(null,"Please enter Contact_no");}
	                        			if(txtadd.getText().isEmpty()){	JOptionPane.showMessageDialog(null,"Please enter Address");}
	                        	              //  if(txtmbrsip.getSelectedItem().isEmpty()){	JOptionPane.showMessageDialog(null,"Please enter membership");}
	                        	                //if(txtbatch.getSelectedItem().isEmpty()){	JOptionPane.showMessageDialog(null,"Please enter Batch");}
	                        	                if(txtinch.getText().isEmpty()){	JOptionPane.showMessageDialog(null,"Please enter inch");}
	                        	                if(txtweight.getText().isEmpty()){	JOptionPane.showMessageDialog(null,"Please enter weight");}  
	                        	                if(txtheight.getText().isEmpty()){	JOptionPane.showMessageDialog(null,"Please enter height");}
	                        	                if(txtbmi.getText().isEmpty()){	JOptionPane.showMessageDialog(null,"Please enter BMI");}
	                        	               // if(txtpaidfee.getText().isEmpty()){	JOptionPane.showMessageDialog(null,"Please enter paid_fee");}    
							
								/* txtid.setText("");*/txtname.setText("");txtcont.setText(""); txtadd.setText("");txtmbrsip.setSelectedItem("");txtbatch.setSelectedItem("");
								    labeltip1.setText(""); //txtexdt.setSelectedItem("");
								    txtweight.setText("");txtheight.setText("");txtbmi.setText("");txtinch.setText(""); //txtpaidfee.setText("");

	                      	
	}
});
			btnupdt.addActionListener(new ActionListener(){
 	public void actionPerformed(ActionEvent e)
 	{     
             if(e.getSource()==btnupdt){}

             	String gender="male";

 if(female.isSelected())
  {
        gender="Female";}

             
				try
				{
                          
					     Connection con;
					      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

						Statement stmt=con.createStatement();

						String sql="Update Memberinfo set member_name='" + txtname.getText() + "',gender='"+gender+"',contact_no="+txtcont.getText()+",member_address='" + txtadd.getText() + "',membership='" + txtmbrsip.getSelectedItem() + "',batch="+ txtbatch.getSelectedItem() +",weight="+ txtweight.getText() +",height="+ txtheight.getText() +",inch="+ txtinch.getText() +",bmi="+ txtbmi.getText() +" where member_id=" + txtid.getText() + " ";
						 
						PreparedStatement pst;
						 pst=con.prepareStatement(sql);
						 ResultSet rs;
						 rs=pst.executeQuery();
						 //while(rs.next())
						 int i=table.getSelectedRow();
						 if(i>=0)
						 {   
						 	  // model.setValueAt(txtid.getText(), i, 0);
			                   model.setValueAt(txtname.getText(), i, 1);
			                   model.setValueAt(gender, i, 2);
			                   model.setValueAt(txtcont.getText(), i, 3);
						 	   model.setValueAt(txtadd.getText(), i, 4);
			                   model.setValueAt(txtmbrsip.getSelectedItem(), i, 5);
			                   model.setValueAt(txtDate.getText(), i, 6);
			                  // model.setValueAt(txtexdt.getSelectedItem(), i, 7);
			                   model.setValueAt(txtbatch.getSelectedItem(), i, 7);
			                   model.setValueAt(txtweight.getText(), i, 8);
						 	   model.setValueAt(txtheight.getText(), i, 9);
			                   model.setValueAt(txtinch.getText(), i, 10);
			                   model.setValueAt(txtbmi.getText(), i, 11);
			                   //model.setValueAt(txtpaidfee.getText(), i, 13);
			                //model.addRow(row);
						 		
						 	JOptionPane.showMessageDialog(null,"Update succesfully...");
						 	  /*txtid.setText("");*/txtname.setText("");txtcont.setText(""); txtadd.setText("");txtmbrsip.setSelectedItem("");txtbatch.setSelectedItem("");
								                     // txtexdt.setSelectedItem("");
								                      txtweight.setText("");txtheight.setText("");txtbmi.setText("");txtinch.setText(""); 
								                      labeltip1.setText("");//txtpaidfee.setText("");

	                      	
							//stmt.close();
							//con.close();

							}
						
					}
                         catch(Exception en1)
                         {
                         		JOptionPane.showMessageDialog(null,en1);
                         }


                          String o="1";
                         try{
						 		Integer max_txtid,new_txtid;
						 		  Connection con;
					      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

						Statement stmt=con.createStatement();

						String sql="Select max(member_id) from Memberinfo";
						
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
						 	}
						 catch(Exception en){JOptionPane.showMessageDialog(null,en);}


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

						String sql="Delete from Memberinfo where member_id=" + txtid.getText() + "";
						 
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
						 	
					         
					         //txtid.setText("");
					         txtname.setText("");txtcont.setText(""); txtadd.setText("");txtmbrsip.setSelectedItem("");txtbatch.setSelectedItem("");
					         labeltip1.setText("");
						     //txtexdt.setSelectedItem("");
						     txtweight.setText("");txtheight.setText("");txtbmi.setText("");txtinch.setText(""); //txtpaidfee.setText("");

	                      	
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

						String sql="Select max(member_id) from Memberinfo";
						
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
						 	}
						 catch(Exception en){JOptionPane.showMessageDialog(null,en);}


	}
});
			table.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					int i=table.getSelectedRow();
					        txtid.setText(model.getValueAt(i,0).toString());
						 	txtname.setText(model.getValueAt(i,1).toString());
						 	//gender.(model.getValueAt(i,2).toString());
						 	txtcont.setText(model.getValueAt(i,3).toString());
						 	txtadd.setText(model.getValueAt(i,4).toString());
						 	txtmbrsip.setSelectedItem(model.getValueAt(i,5).toString());
						 	txtDate.setText(model.getValueAt(i,6).toString());
						 	 //txtexdt.setSelectedItem(model.getValueAt(i,7).toString());
						 	txtbatch.setSelectedItem(model.getValueAt(i,7).toString());
						 	txtweight.setText(model.getValueAt(i,8).toString());
						 	txtheight.setText(model.getValueAt(i,9).toString());
						 	txtinch.setText(model.getValueAt(i,10).toString());
						 	txtbmi.setText(model.getValueAt(i,11).toString());
						 //	txtpaidfee.setText(model.getValueAt(i,13).toString());
						 

				}
			});



			btncnl.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					if(e.getSource()==btncnl)
						/*txtid.setText("")*/
					txtname.setText("");txtcont.setText(""); txtadd.setText("");txtmbrsip.setSelectedItem("");txtbatch.setSelectedItem("");
		            //txtexdt.setSelectedItem("");
		            txtweight.setText("");txtheight.setText("");txtbmi.setText("");txtinch.setText(""); //
		           labeltip1.setText(""); // txtpaidfee.setText("");

		             String o="1";
                         try{
						 		Integer max_txtid,new_txtid;
						 		  Connection con;
					      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");

						Statement stmt=con.createStatement();

						String sql="Select max(member_id) from Memberinfo ";
						
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
						 	}
						 catch(Exception en){JOptionPane.showMessageDialog(null,en);}


	                      	
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
			    
			    txtname.addKeyListener(new KeyAdapter(){

             public void keyPressed(KeyEvent e){

                char ch = e.getKeyChar();

                if(Character.isLetter(ch)||Character.isWhitespace(ch)||Character.isISOControl(ch))
                {
                	txtname.setEditable(true);
                	validname.setText("");

                }else{txtname.setEditable(false);
                 validname.setText("Please Enter Character");}
                 
                   }
                      });

			   
			       txtinch.addKeyListener(new KeyAdapter(){
	public void keyPressed(KeyEvent en)
	{
		int key=en.getKeyCode();
		if((key>=en.VK_0&&key<=en.VK_9)||(key>=en.VK_NUMPAD0&&key<=en.VK_NUMPAD9)||key==KeyEvent.VK_BACK_SPACE||key==KeyEvent.VK_DELETE)
			{txtinch.setEditable(true);}
		else
			{txtinch.setEditable(false);}
		
	}
});

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

			       txtmbrsip.addKeyListener(new KeyAdapter(){
	public void keyPressed(KeyEvent en)
	{
		int key=en.getKeyCode();
		if((key>=en.VK_0&&key<=en.VK_9)||(key>=en.VK_NUMPAD0&&key<=en.VK_NUMPAD9)||key==KeyEvent.VK_BACK_SPACE||key==KeyEvent.VK_DELETE)
			{txtmbrsip.setEditable(true);}
		else
			{txtmbrsip.setEditable(false);}
		
	}
});
			       /*  txtbatch.addKeyListener(new KeyAdapter(){
	public void keyPressed(KeyEvent en)
	{
		int key=en.getKeyCode();
		if((key>=en.VK_0&&key<=en.VK_9)||(key>=en.VK_NUMPAD0&&key<=en.VK_NUMPAD9)||key==KeyEvent.VK_BACK_SPACE||key==KeyEvent.VK_DELETE)
			{txtbatch.setEditable(true);}
		else
			{txtbatch.setEditable(false);}
		
	}
});*/

    txtweight.addKeyListener(new KeyAdapter(){
	public void keyPressed(KeyEvent en)
	{
		int key=en.getKeyCode();
		if((key>=en.VK_0&&key<=en.VK_9)||(key>=en.VK_NUMPAD0&&key<=en.VK_NUMPAD9)||key==KeyEvent.VK_BACK_SPACE||key==KeyEvent.VK_DELETE)
			{txtweight.setEditable(true);}
		else
			{txtweight.setEditable(false);}
		
	}
});
      txtheight.addKeyListener(new KeyAdapter(){
	public void keyPressed(KeyEvent en)
	{
		int key=en.getKeyCode();
		if((key>=en.VK_0&&key<=en.VK_9)||(key>=en.VK_NUMPAD0&&key<=en.VK_NUMPAD9)||key==KeyEvent.VK_BACK_SPACE||key==KeyEvent.VK_DELETE)
			{txtheight.setEditable(true);}
		else
			{txtheight.setEditable(false);}
		
	}
});
        txtbmi.addKeyListener(new KeyAdapter(){
	public void keyPressed(KeyEvent en)
	{
		int key=en.getKeyCode();
		if((key>=en.VK_0&&key<=en.VK_9)||(key>=en.VK_NUMPAD0&&key<=en.VK_NUMPAD9)||key==KeyEvent.VK_BACK_SPACE||key==KeyEvent.VK_DELETE)
			{txtbmi.setEditable(true);}
		else
			{txtbmi.setEditable(false);}
		
	}
});
																					     /* txtheight.addKeyListener(new KeyAdapter(){
																						public void keyPressed(KeyEvent en)
																						{
																							try
																							{ 
																								int i=Integer.parseInt(txtheight.getText());
																								txtheight.setEditable(true);

																							}
																							catch(NumberFormatException e)
																							{
																							    txtheight.setEditable(false);
																							}
																						}
																					});
																					        txtbmi.addKeyListener(new KeyAdapter(){
																						public void keyPressed(KeyEvent en)
																						{
																							try
																							{ 
																								int i=Integer.parseInt(txtbmi.getText());
																								valid1.setText("");

																							}
																							catch(NumberFormatException e)
																							{
																								valid1.setText("Invalid Number");
																							}
																						}
																					});*/

      /* txttip.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
         if(e.getSource()==txtheight){}
		double feet,kilopgram,inch;
		double height,bmi;
		try
		{ 

			feet=Double.parseDouble(txtheight.getText());
			inch=Double.parseDouble(txttip.getText());
			kilopgram=Double.parseDouble(txtweight.getText());

			height=(feet*12)+inch;
			height=(height*2.5)/100;
			bmi=kilopgram/(height*height);
			String bmi1=Double.toString(bmi);
			txtbmi.setText(bmi1);

		
			}catch(Exception en){}
	}
});*/
        txtinch.addKeyListener(new KeyAdapter(){
				public void keyReleased(KeyEvent e)
				{
         if(e.getSource()==txtheight){}
		double feet,kilopgram,inch;
		double height,bmi;
		try
		{ 

			feet=Double.parseDouble(txtheight.getText());
			inch=Double.parseDouble(txtinch.getText());
			kilopgram=Double.parseDouble(txtweight.getText());

			height=(feet*12)+inch;
			height=(height*2.5)/100;
			bmi=kilopgram/(height*height);
			String bmi1=Double.toString(bmi);
			txtbmi.setText(bmi1);

			if(bmi<18.5){labeltip1.setForeground(Color.red); labeltip1.setText("You Are UnderWeight");}
			else if(bmi>=18.5&&bmi<=24.9){labeltip1.setForeground(Color.green);labeltip1.setText("You Are Normal");}
			else if (bmi>24.9&&bmi<=24.9) {labeltip1.setForeground(Color.red);labeltip1.setText("You Are OverWeight");} 
		    
			else{ labeltip1.setForeground(Color.red);labeltip1.setText("You Are Obser.");}

		
			}catch(Exception en){}
	}
});
        /*  txtinch.addFocusListener(new FocusAdapter(){
              public void focusLost(FocusEvent e)
				{
         if(e.getSource()==txtinch){}
		double feet,kilopgram,inch;
		double height,bmi;
		try
		{ 

			feet=Double.parseDouble(txtheight.getText());
			inch=Double.parseDouble(txtinch.getText());
			kilopgram=Double.parseDouble(txtweight.getText());

			height=(feet*12)+inch;
			height=(height*2.5)/100;
			bmi=kilopgram/(height*height);
			String bmi1=Double.toString(bmi);
			txtbmi.setText(bmi1);

			if(bmi<18.5){labeltip1.setForeground(Color.red); labeltip1.setText("You Are UnderWeight");}
			else if(bmi>=18.5&&bmi<=24.9){labeltip1.setForeground(Color.green);labeltip1.setText("You Are Normal");}
			else if (bmi>24.9&&bmi<=24.9) {labeltip1.setForeground(Color.red);labeltip1.setText("You Are OverWeight");} 
		    
			else{ labeltip1.setForeground(Color.red);labeltip1.setText("You Are Obser.");}



		
			}catch(Exception en){}
	}
});*/

//setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);	

	                    

                            panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Member details"));
                            panel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), ""));
			
                         

                       /*    ImageIcon bkg2=new ImageIcon("image/23.jpg");
                           JLabel bkg3 = new JLabel("",bkg2,JLabel.CENTER);
                           Image img=bkg2.getImage();
                           Image temp_img=img.getScaledInstance(1265,810,Image.SCALE_SMOOTH);
                           bkg2=new ImageIcon(temp_img);
                           bkg3.setBounds(0,0,1280,720);
                           add(bkg3);*/
                             add(bkg1);
                              add(panel);
                       
                          
	 
}      

 




public static void main(java.lang.String args[])
{

 Member mb=new Member();
 mb.setTitle("member");

}
} 
