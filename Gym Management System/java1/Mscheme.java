import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

import javax.swing.*;
import java.awt.*;
import javax.swing.JInternalFrame;
import java.sql.*;
import java.awt.event.*;
import java.io.*;
import java.sql.SQLException;

import java.awt.event.MouseListener;
import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;


//importing for jasper reports
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

//for log4j exception  most important
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;




public class MschemeReport extends JInternalFrame {

	
	
	
	
	private JPanel panel;
	//private JTextField textField;
	
	//log4j
	final static Logger logger = Logger.getLogger(BatchReport.class);
	
	public static void main(String[] args) {
		//log4j
			PropertyConfigurator.configure("log4j.properties");
					logger.debug("THis iS DEBUG");
					logger.debug("THis iS INFo");
					logger.debug("THis iS WARN");
					logger.debug("THis iS ERROR");
					logger.debug("THis iS FATAL");
					BatchReport frame = new BatchReport();
					frame.setVisible(true);
					
	}
	 
	public MschemeReport() {
		
		
		
		BasicInternalFrameUI basicInternalFrameUI =((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI());
				for(MouseListener listener:basicInternalFrameUI.getNorthPane().getMouseListeners())
				{ 
					basicInternalFrameUI.getNorthPane().removeMouseListener(listener);
				}
		
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setToolTipText("");
		panel.setForeground(Color.BLACK);
		panel.setBackground(new Color(0, 204, 255));
		panel.setBounds(10, 11, 1244, 114);
		add(panel);
		
		JLabel lblBatchReport = new JLabel("Patient Details Report ");
		lblBatchReport.setForeground(Color.BLACK);
		lblBatchReport.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 22));
		lblBatchReport.setBounds(493, 11, 741, 72);
		panel.add(lblBatchReport);
		
		//JLabel lblRegistrationNo = new JLabel("Registration No");
		///lblRegistrationNo.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 14));
		//lblRegistrationNo.setBackground(Color.WHITE);
		//lblRegistrationNo.setBounds(10, 161, 177, 32);
		//add(lblRegistrationNo);
		
		//textField = new JTextField();
		//textField.setColumns(10);
		//textField.setBounds(206, 161, 128, 31);
		//add(textField);
		
		JButton btnGenerateReport = new JButton("Generate Report");
		btnGenerateReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
			Connection con;
			try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gymmanagement","785");
			System.out.println("Connected_______");
			
			
				InputStream in=new FileInputStream(new File("E:\\java1\\report\\member shceme.jrxml"));         //G:\\HMSFinalwithout database\\Run\\reports
				JasperDesign jd= JRXmlLoader.load(in);																					//G:\\HMSFinalwithout database\\Run\\rprt\\HmsReports
																					//G:\HMSFinalwithout database\Run\lastreport														
				String sql="Select *from memberscheme ";
				JRDesignQuery newQuery =new JRDesignQuery();
				newQuery.setText(sql);
				jd.setQuery(newQuery);
				
				JasperReport jr =JasperCompileManager.compileReport(jd);
				HashMap para = new HashMap();
				JasperPrint j= JasperFillManager.fillReport(jr,para,con);
				JasperViewer.viewReport(j,false);
				OutputStream os = new FileOutputStream(new File ("java\\report"));       //G:\\HMSFinalwithout database\\Run\\generated reports
																			//G:\\print
				JasperExportManager.exportReportToPdfStream(j,os);
				
			} 
			catch (Exception e) {
									System.out.println(e);
								}
		}
		});
		btnGenerateReport.setToolTipText("Click to generate report ");
		btnGenerateReport.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 12));
		btnGenerateReport.setBounds(386, 158, 169, 40);
		add(btnGenerateReport);
		
		
		
		setBounds(0, 0,1280, 800);
		setTitle("Mscheme Report");
		setVisible(true);
		setClosable(true);
		setLayout(null);
		
		
		
		
		
		
		
	}
}
