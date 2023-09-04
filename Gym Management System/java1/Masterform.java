import javax.swing.*;  
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Date; 
import java.text.SimpleDateFormat;


public class Masterform extends JFrame   
{  
  
  
   
 Masterform()
   {



                   JDesktopPane dp=new JDesktopPane();
                   dp.setBounds(0,0,1370,720);
                   add(dp); 

                      ImageIcon bkg=new ImageIcon("image/sb1.jpg");
                           JLabel bkg1 = new JLabel("",bkg,JLabel.CENTER);
                          // Image img=bkg.getImage();
                           //Image temp_img=img.getScaledInstance(1280,800,Image.SCALE_SMOOTH);
                          // bkg=new ImageIcon(temp_img);
                           bkg1.setBounds(0,0,1370,720);
                           dp.add(bkg1);


                 

    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent e) {
    int confirmed = JOptionPane.showConfirmDialog(null,
    "Are you sure you want to exit?", "User Confirmation",
    JOptionPane.YES_NO_OPTION);
    if (confirmed == JOptionPane.YES_OPTION)
    System.exit(0);
    }
    });
    

  
          JMenuBar mb=new JMenuBar();
          mb.setBounds(0,0,1620,24);
         bkg1.add(mb);

               
         JMenu master=new JMenu("Master"); 
          mb.add(master);
         master.setForeground(Color.blue); 
         JMenu transaction=new JMenu("Transaction"); 
         mb.add(transaction);
         transaction.setForeground(Color.blue); 
         JMenu purchase=new JMenu("Purchase/Sale");
          mb.add(purchase);
          purchase.setForeground(Color.blue);  
         JMenu report=new JMenu("Report");
         mb.add(report);   
         report.setForeground(Color.blue);

            JMenuItem membermaster=new JMenuItem("Member Master");  
            master.add(membermaster);
            JMenuItem coachmaster=new JMenuItem("Coach Master");
             master.add(coachmaster);   
            JMenuItem batchmaster=new JMenuItem("Batch Master"); 
            master.add(batchmaster);
            JMenuItem suppliermaster=new JMenuItem("Supplier Master");  
            master.add(suppliermaster);
             
           

            JMenuItem membershipscheme=new JMenuItem("Membership Scheme"); 
              transaction.add(membershipscheme); 
           // JMenuItem receipt=new JMenuItem("Receipt");  
           // transaction.add(receipt);
          
            

            JMenuItem purchasemaster=new JMenuItem("Purchase product");  
            purchase.add(purchasemaster); 
            JMenuItem sale=new JMenuItem("Sale Product");  
            purchase.add(sale); 

            JMenuItem memberreport=new JMenuItem("Member Report");  
              report.add(memberreport);
                JMenuItem coachreport=new JMenuItem("Coach Report"); 
              report.add(coachreport); 
               JMenuItem batchreport=new JMenuItem("Batch Report"); 
              report.add(batchreport); 
            JMenuItem supplierreport=new JMenuItem("Supplier Report");
             report.add(supplierreport); 

              JMenuItem memberschemereport=new JMenuItem("Memberscheme Report");
             report.add(memberschemereport); 

           JMenuItem purchasereport=new JMenuItem("Purchase Report");
             report.add(purchasereport);
              JMenuItem salereport=new JMenuItem("Sale Report");
             report.add(salereport); 

            //JMenuItem receiptreport=new JMenuItem("Payment Receipt Report");  
            //  report.add(receiptreport);

            
           
           
           
  membermaster.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent en)
     
    {         if(en.getSource()==membermaster)
      {        
        try{
              Member mber=new Member();
              mber.setVisible(true) ;
              dp.add(mber);
              dp.moveToFront(mber);
              mber.setSize(dp.getWidth(),dp.getHeight());
              mber.setSize(1280,695);  
              mber.setLocation(0,0);

          
               
             }catch(Exception el){el.printStackTrace();}
              
         
    }
  }
  });

 coachmaster.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent en)
     
    {         if(en.getSource()==coachmaster)
      {     
        try{
              Coachmaster cmt=new Coachmaster();
             // cmt.setVisible(true) ;
              dp.add(cmt);
              dp.moveToFront(cmt);
              cmt.setSize(dp.getWidth(),dp.getHeight());
              cmt.setSize(1280,695);  
              cmt.setLocation(0,0);
            }
            catch(Exception e){e.printStackTrace();}   

                      }
              
    }
  });

 
 batchmaster.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent en)
     
    {         if(en.getSource()==batchmaster)
      {
        try{
              Batchmaster bmt=new Batchmaster();
             // bmt.setVisible(true) ;
              dp.add(bmt);
              dp.moveToFront(bmt);
              bmt.setSize(dp.getWidth(),dp.getHeight());
              bmt.setSize(1280,695);  
              bmt.setLocation(0,0);
            }
            catch(Exception e){e.printStackTrace();}   
     }
              
    }
  });
  suppliermaster.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent en)
     
    {         if(en.getSource()==suppliermaster)
      {
        try{
              Suppliermaster spm=new Suppliermaster();
             // spm.setVisible(true) ;
              dp.add(spm);
              dp.moveToFront(spm);
              spm.setSize(dp.getWidth(),dp.getHeight());
              spm.setSize(1280,695);  
              spm.setLocation(0,0);
            }
            catch(Exception e){e.printStackTrace();}   
     }
              
    }
  });

 membershipscheme.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent en)
     
    {         if(en.getSource()==membershipscheme)
      {
           try{
              Membershipscheme mbs=new Membershipscheme();
             // mbs.setVisible(true) ;
              dp.add(mbs);
              dp.moveToFront(mbs);
              mbs.setSize(dp.getWidth(),dp.getHeight());
              mbs.setSize(1280,695);  
              mbs.setLocation(0,0);
            }
            catch(Exception e){e.printStackTrace();}   
                      }
              
    }
  });
purchasemaster.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent en)
     
    {         if(en.getSource()==purchasemaster)
      {
             try{
              Purchase pur=new Purchase();
              //pur.setVisible(true) ;
              dp.add(pur);
              dp.moveToFront(pur);
              pur.setSize(dp.getWidth(),dp.getHeight());
              pur.setSize(1280,695);  
              pur.setLocation(0,0);
            }
            catch(Exception e){e.printStackTrace();}   
                      }
              
    }
  });
sale.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent en)
     
    {         if(en.getSource()==sale)
      {
             try{
              Sale  sale=new Sale();
              //sale.setVisible(true) ;
              dp.add(sale);
              dp.moveToFront(sale);
              sale.setSize(dp.getWidth(),dp.getHeight());
              sale.setSize(1280,695);  
          //setLayout(null);  
          //setVisible(true);
              sale.setLocation(0,0);
            }
            catch(Exception e){e.printStackTrace();}   
                      }
              
    }
  });


memberreport.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent en)
     
    {         if(en.getSource()==memberreport)
      {
             try{
              MemberReport mbreport=new MemberReport();
//              mbreport.setVisible(true) ;
              dp.add(mbreport);
              dp.moveToFront(mbreport);
              sale.setSize(dp.getWidth(),dp.getHeight());
              mbreport.setSize(1280,695);  
          //setLayout(null);  
          //setVisible(true);
              mbreport.setLocation(0,0);
            }
            catch(Exception e){e.printStackTrace();}   
                      }
              
    }
  });

coachreport.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent en)
     
    {         if(en.getSource()==coachreport)
      {
             try{
              CoachReport chreport=new CoachReport();
            //  chreport.setVisible(true) ;
              dp.add(chreport);
              dp.moveToFront(chreport);
              sale.setSize(dp.getWidth(),dp.getHeight());
               chreport.setSize(1280,695);  
          //setLayout(null);  
          //setVisible(true);
              chreport.setLocation(0,0);
            }
            catch(Exception e){e.printStackTrace();}   
                      }
              
    }
  });


batchreport.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent en)
     
    {         if(en.getSource()==batchreport)
      {
             try{
              BatchReport coachreport=new BatchReport();
              //coachreport.setVisible(true) ;
              dp.add(coachreport);
              dp.moveToFront(coachreport);
              sale.setSize(dp.getWidth(),dp.getHeight());
               coachreport.setSize(1280,695);  
          //setLayout(null);  
          //setVisible(true);
              coachreport.setLocation(0,0);
            }
            catch(Exception e){e.printStackTrace();}   
                      }
              
    }
  });
supplierreport.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent en)
     
    {         if(en.getSource()==supplierreport)
      {
             try{
              SupplierReport spreport=new SupplierReport();
             // spreport.setVisible(true) ;
              dp.add(spreport);
              dp.moveToFront(spreport);
              sale.setSize(dp.getWidth(),dp.getHeight());
               spreport.setSize(1280,695);  
          //setLayout(null);  
          //setVisible(true);
              spreport.setLocation(0,0);
            }
            catch(Exception e){e.printStackTrace();}   
                      }
              
    }
  });
memberschemereport.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent en)
     
    {         if(en.getSource()==memberschemereport)
      {
             try{
              MschemeReport mbscreport=new MschemeReport();
             // mbscreport.setVisible(true) ;
              dp.add(mbscreport);
              dp.moveToFront(mbscreport);
              sale.setSize(dp.getWidth(),dp.getHeight());
               mbscreport.setSize(1280,695);  
          //setLayout(null);  
          //setVisible(true);
              mbscreport.setLocation(0,0);
            }
            catch(Exception e){e.printStackTrace();}   
                      }
              
    }
  });
purchasereport.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent en)
     
    {         if(en.getSource()==purchasereport)
      {
             try{
              PurchaseReport pureport=new PurchaseReport();
             // pureport.setVisible(true) ;
              dp.add(pureport);
              dp.moveToFront(pureport);
              sale.setSize(dp.getWidth(),dp.getHeight());
               pureport.setSize(1280,695);  
          //setLayout(null);  
          //setVisible(true);
              pureport.setLocation(0,0);
            }
            catch(Exception e){e.printStackTrace();}   
                      }
              
    }
  });
salereport.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent en)
     
    {         if(en.getSource()==salereport)
      {
             try{
              SaleReport slreport=new SaleReport();
            //  slreport.setVisible(true) ;
              dp.add(slreport);
              dp.moveToFront(slreport);
             sale.setSize(dp.getWidth(),dp.getHeight());
               slreport.setSize(1280,695);  
          //setLayout(null);  
          //setVisible(true);
              slreport.setLocation(0,0);
            }
            catch(Exception e){e.printStackTrace();}   
                      }
              
    }
  });





addWindowListener(new WindowAdapter(){
  public void WindowClosing(WindowEvent e)
  {
    dispose();
    System.exit(0);
  }
});
  

         // setJMenuBar(mb); 
          setBounds(0,0,1370,720);
             setLayout(null);
          setSize(1370,720);
          setLocation(0,0);
           setVisible(true);

            Date date=new Date();
                SimpleDateFormat fordate=new SimpleDateFormat("HH:mm - dd/MM/YYYY");
                  String date1=fordate.format(date);
                 JLabel txtDate=new JLabel("");
                    txtDate.setBounds(1130,20,500,30);
                 txtDate.setText(date1);
                bkg1.add(txtDate);
                txtDate.setFont(new Font("Comic Sans MS/ Sans-serif", Font.BOLD, 15));
                  txtDate.setForeground(Color.blue);
                       txtDate.setBackground(Color.BLACK);
         // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

          public static void main( String args[])  
      {
        Masterform mf=new Masterform();
        mf.setVisible(true);
        mf.setTitle("GOLD GYM");
      }    
        
         

}
