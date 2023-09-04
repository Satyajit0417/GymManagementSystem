import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class welcome extends JFrame
{  
	public JProgressBar pb;
	welcome()
	{

					 Color c = new Color(136,77,255); 

		        JPanel panel=new JPanel();  
              panel.setBounds(0,0,1200,800);   
              panel.setBackground(Color.RED);   
              
               ImageIcon bkg=new ImageIcon("image/d1.gif");
			 JLabel bkg1 = new JLabel("",bkg,JLabel.CENTER);
			 Image img=bkg.getImage();
			 Image temp_img=img.getScaledInstance(1200,500,Image.SCALE_SMOOTH);
			 bkg=new ImageIcon(temp_img);
			 bkg1.setBounds(0,0,1200,500);
               

                 JLabel lb=new JLabel("0%");
                lb.setFont(new Font("Comic Sans MS/ Sans-serif", Font.BOLD, 30));
                 lb.setForeground(Color.RED);
				 lb.setBounds(520,150,200,50);
				bkg1.add(lb);


                 JLabel lb1=new JLabel("Welcome  To  GYM");
                lb1.setFont(new Font("Comic Sans MS/ Sans-serif", Font.BOLD, 40));
                 lb1.setForeground(c);
				 lb1.setBounds(400,30,400,50);
				bkg1.add(lb1);

				JProgressBar pb=new JProgressBar();
				 pb.setForeground(Color.green);
				pb.setBounds(1,580,1181,20);
				bkg1.add(pb);

				
			 
               
             
               

              

				 

             setSize(1200,650);
			setLayout(null);
			setVisible(true);
			setLocation(40,35);
			 add(panel);
			panel.add(bkg1);
			
			
		  

				
				 try{
				 	for(int i=0;i<=100;i++)
				 	{
				 		Thread.sleep(60);
				 		 // int mship=Integer.valueOf((String)txtMebship.getSelectedItem());
				 	lb.setText(Integer.toString(i)+"%");
				 	//pb.setText(Integer.toString(i)+"%");
				 	pb.setValue(i);
				 		if(i==100)
				 		{
				 			setVisible(false);
				 			Login lg=new Login();
				 			lg.setVisible(true);
				 		}
				 	}

				 }catch(Exception e){System.out.println(e);}
				  
           
			

          
			
			 setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String args[])
		{
			welcome wel=new welcome();
				}
			}
	