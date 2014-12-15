package APCD;

import business.UserBusiness;
import java.awt.Toolkit;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBException;
import util.Utils;

public class APCdiabetic extends javax.swing.JFrame {

    /**
     * Creates new form APCdiabetic1
     */
    public APCdiabetic() {
        initComponents();
        initForm();
    }

    private void initForm() {
        Utils.initializeForm(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        registerButton1 = new javax.swing.JToggleButton();
        loginButton1 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("A.P.C.D");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/apc diabeticlogo.png"))); // NOI18N

        registerButton1.setBackground(new java.awt.Color(153, 0, 0));
        registerButton1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        registerButton1.setForeground(new java.awt.Color(255, 255, 0));
        registerButton1.setLabel("Register");
        registerButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButton1ActionPerformed(evt);
            }
        });

        loginButton1.setBackground(new java.awt.Color(153, 0, 0));
        loginButton1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        loginButton1.setForeground(new java.awt.Color(255, 255, 0));
        loginButton1.setText("log in");
        loginButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(53, 53, 53))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registerButton1))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel3)
                .addGap(70, 70, 70)
                .addComponent(loginButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(registerButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButton1ActionPerformed

        //انشاء الداتاييز مع معلومات اليوزر كامله
        // users user = new users();
        //userInfo user1=new userInfo();
        //user.List.add(user1);
        //Serializer serializer = new Persister();
        //File file = new File("/Users/nadaasghar/Desktop/Database.xml");
        // db
        try {
            // مهم السطر جدا جدا
            //    serializer.write(user, file);

            Register reg =  Register.getInstance();
            reg.setVisible(true);
            this.setVisible(false);
        } catch (Exception ex) {
            Logger.getLogger(APCdiabetic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_registerButton1ActionPerformed

    private void loginButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButton1ActionPerformed
        Login log =  Login.getInstance();
        log.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_loginButton1ActionPerformed

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String args[]) throws Exception {

        new APCdiabetic().startApplication();
        /*
       
         //register main 
         java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
         try {
                    
         new Register().setVisible(true);
         } catch (Exception ex) {
         Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
         }
         }
         });
                
         //lonin main
         java.awt.EventQueue.invokeLater(new Runnable() {
         @Override
         public void run() {
         new Login().setVisible(true);
         }
         });
                        
         //time sitting main
         java.awt.EventQueue.invokeLater(new Runnable() {
         @Override
         public void run() {
         new TimeSetting().setVisible(true);
         } 
         });
                    
         //daily mesurement
         java.awt.EventQueue.invokeLater(new Runnable() {
         @Override
         public void run() {
         new DailyMeasurement().setVisible(true);
         }
         });
                          
         //table of mesurment
         java.awt.EventQueue.invokeLater(new Runnable() {
         @Override
         public void run() {
                
         new TableOfMeasurements().setVisible(true);
                
         }
         });
                                  
   
         */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton loginButton1;
    private javax.swing.JToggleButton registerButton1;
    // End of variables declaration//GEN-END:variables

    public static File xmlFile;
    public static String databaseName="Databaselast.xml";
    
    private void startApplication() {
        try {
            
            xmlFile = new File( new File(Utils.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).getParent() + File.separator + "Databaselast.xml");
            xmlFile = new File(getClass().getResource("/"+databaseName).getPath());
            try {
                Utils.XmlUsers = Utils.unmarchalXmlToUser(xmlFile);
            } catch (JAXBException exception) {
                exception.printStackTrace();
                JOptionPane.showMessageDialog(this, "Unable to parse XML file please contact Programmer");
                System.exit(0);
            }
            

            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
             * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
             */
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(APCdiabetic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(APCdiabetic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(APCdiabetic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(APCdiabetic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new APCdiabetic().setVisible(true);

                }
            });
        } catch (Exception ex) {
            Logger.getLogger(APCdiabetic.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
