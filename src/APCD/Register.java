package APCD;

import business.UserBusiness;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBException;
import utils.CustomException;
import utils.Util;
import xml.Users;

public class Register extends javax.swing.JFrame {

    UserBusiness userBusiness = new UserBusiness();
    /**
     * Creates new form APCdiabetic1
     */
    
    private static Register instance;
    private Register() {
        initComponents();
        initForm();
    }
    
    public static Register getInstance()
    {
        if(instance ==null)
        {
        instance = new Register();
        }
        return instance;
    }

    private void initForm() {
        Util.initializeForm(this);
        maleRadioButton.setSelected(true);
        Type1Daibetic.setSelected(true);
    }


    Register(String name, String email) {
        initComponents();
        initForm();
        this.email.setText(email);
        this.nameField.setText(name);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        Name = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        maleRadioButton = new javax.swing.JRadioButton();
        femaleRadioButton = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Type1Daibetic = new javax.swing.JRadioButton();
        Type2Daibetic = new javax.swing.JRadioButton();
        gestationalDiabetes = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        regCancelButt = new javax.swing.JButton();
        submitButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();

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

        Name.setFont(new java.awt.Font("Comic Sans MS", 1, 22)); // NOI18N
        Name.setForeground(new java.awt.Color(0, 153, 51));
        Name.setText("Name :");

        nameField.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        nameField.setForeground(new java.awt.Color(0, 51, 153));
        nameField.setToolTipText("Write your name here.");
        nameField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 51)));
        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        maleRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        maleRadioButton.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        maleRadioButton.setForeground(new java.awt.Color(0, 51, 153));
        maleRadioButton.setText("Male ");
        maleRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleRadioButtonActionPerformed(evt);
            }
        });

        femaleRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        femaleRadioButton.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        femaleRadioButton.setForeground(new java.awt.Color(0, 51, 153));
        femaleRadioButton.setText("Female");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 51));
        jLabel2.setText("Gender :");

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 51));
        jLabel3.setText("Type of diabetic :");

        Type1Daibetic.setBackground(new java.awt.Color(255, 255, 255));
        Type1Daibetic.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Type1Daibetic.setForeground(new java.awt.Color(0, 51, 153));
        Type1Daibetic.setText("Type 1 Diabetic .");
        Type1Daibetic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Type1DaibeticActionPerformed(evt);
            }
        });

        Type2Daibetic.setBackground(new java.awt.Color(255, 255, 255));
        Type2Daibetic.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Type2Daibetic.setForeground(new java.awt.Color(0, 51, 153));
        Type2Daibetic.setText("Type 2 Diabetic .");

        gestationalDiabetes.setBackground(new java.awt.Color(255, 255, 255));
        gestationalDiabetes.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        gestationalDiabetes.setForeground(new java.awt.Color(0, 51, 153));
        gestationalDiabetes.setText("Gestational Diabetes.");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 51));
        jLabel4.setText("E-mail :");

        email.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        email.setForeground(new java.awt.Color(0, 51, 153));
        email.setToolTipText("Write your email here.");
        email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 51)));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/apc diabeticlogo Register.png"))); // NOI18N

        regCancelButt.setBackground(new java.awt.Color(153, 0, 0));
        regCancelButt.setFont(new java.awt.Font("Californian FB", 1, 18)); // NOI18N
        regCancelButt.setForeground(new java.awt.Color(255, 255, 0));
        regCancelButt.setText("Cancel");
        regCancelButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regCancelButtActionPerformed(evt);
            }
        });

        submitButton.setBackground(new java.awt.Color(153, 0, 0));
        submitButton.setFont(new java.awt.Font("Californian FB", 1, 18)); // NOI18N
        submitButton.setForeground(new java.awt.Color(255, 255, 0));
        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(Name)
                        .addGap(16, 16, 16)
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2)
                        .addGap(48, 48, 48)
                        .addComponent(maleRadioButton)
                        .addGap(52, 52, 52)
                        .addComponent(femaleRadioButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(Type1Daibetic))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(Type2Daibetic))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(gestationalDiabetes))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel4)
                        .addGap(12, 12, 12)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(regCancelButt, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Name)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(maleRadioButton)
                            .addComponent(femaleRadioButton))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel3)
                .addGap(10, 10, 10)
                .addComponent(Type1Daibetic)
                .addGap(1, 1, 1)
                .addComponent(Type2Daibetic)
                .addGap(1, 1, 1)
                .addComponent(gestationalDiabetes)
                .addGap(24, 24, 24)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(submitButton)
                .addGap(7, 7, 7)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(regCancelButt)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        try {
            String nf = nameField.getText();

        } catch (Exception ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nameFieldActionPerformed

    private void maleRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maleRadioButtonActionPerformed

    private void Type1DaibeticActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Type1DaibeticActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Type1DaibeticActionPerformed

    private void regCancelButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regCancelButtActionPerformed
        APCdiabetic main = new APCdiabetic();
        main.setVisible(true);
        this.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_regCancelButtActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed

        try {
            validateNameAndEmail();

            Util.currentLoginUser = userBusiness.getUserByEmail(email.getText());
            if (Util.currentLoginUser != null) {
                boolean result = Util.displayDialogMessage(this, "This Email Is Already registered before, Would you like to Login ");
                if (result) {

                    Util.hideAndShow(this,  DailyMeasurement.getInstance());
                }

            } else {
                Util.currentLoginUser = new Users.UserInfo();
                Util.currentLoginUser.setName(nameField.getText());
                Util.currentLoginUser.setEmail(email.getText());
                //Utils.hideAndShow(this, new DailyMeasurement());
                resetForm();
                Util.hideAndShow(this,  TimeSetting.getInstance());
                if (maleRadioButton.isSelected()) {
                    Util.currentLoginUser.setGender(Util.MALE);
                } else {
                    Util.currentLoginUser.setGender(Util.FEMALE);
                }

                // setting the type
                if (Type1Daibetic.isSelected()) {
                    Util.currentLoginUser.setTypeOfDiabetic(Util.TYPE1);
                } else if (Type2Daibetic.isSelected()) {
                    Util.currentLoginUser.setTypeOfDiabetic(Util.TYPE2);
                } else if (gestationalDiabetes.isSelected()) {
                    Util.currentLoginUser.setTypeOfDiabetic(Util.TYPE2);
                }

                userBusiness.saveUsersBackIntoFile();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            Util.displayMessage(this, ex.getMessage());
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_submitButtonActionPerformed

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String args[]) throws Exception {

        new Register().startApplication();
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
    private javax.swing.JLabel Name;
    private javax.swing.JRadioButton Type1Daibetic;
    private javax.swing.JRadioButton Type2Daibetic;
    private javax.swing.JTextField email;
    private javax.swing.JRadioButton femaleRadioButton;
    private javax.swing.JRadioButton gestationalDiabetes;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JRadioButton maleRadioButton;
    private javax.swing.JTextField nameField;
    private javax.swing.JButton regCancelButt;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables

    public static File xmlFile;
    public static String databaseName="Databaselast.xml";
    
    private void startApplication() {
        try {
            
            xmlFile = new File( new File(Util.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).getParent() + File.separator + "Databaselast.xml");
            xmlFile = new File(getClass().getResource("/"+databaseName).getPath());
            try {
                Util.XmlUsers = Util.unmarchalXmlToUser(xmlFile);
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
                java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new Register().setVisible(true);

                }
            });
        } catch (Exception ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private void validateNameAndEmail() throws CustomException {

        if (Util.isAString(nameField.getText()) == false) {
            throw new CustomException("Please Enter your name");
        }
        if (Util.isEmail(email.getText()) == false) {
            throw new CustomException("Please Enter your Email");
        }
    }
    
    
    public void resetForm()
    {
        nameField.setText("");
        email.setText("");
    
    }
}
