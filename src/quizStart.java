import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author acer
 */
public class quizStart extends javax.swing.JFrame {
    
    public String Id="1";
    public String Answer;
    public int min=0;
    public int sec=0;
    public int marks=0;
    
    public void answerCheck()
    {
      String studentAnswer="";
      if(opt1RadioButton.isSelected())
      {
          studentAnswer=opt1RadioButton.getText();
      }
      else if(opt2RadioButton.isSelected())
      {
          studentAnswer=opt2RadioButton.getText();
      }
      else if(opt3RadioButton.isSelected())
      {
          studentAnswer=opt3RadioButton.getText();
      }
      else
      {
          studentAnswer=opt4RadioButton.getText();
      }
      
      if(studentAnswer.equals(Answer))
      {
          marks=marks+1;
          String marks1=String.valueOf(marks);
          scoreLabel.setText(marks1);
      }
      
      int Id1=Integer.parseInt(Id);
      Id1=Id1+1;
      Id=String.valueOf(Id1);
      
      opt1RadioButton.setSelected(false);
      opt2RadioButton.setSelected(false);
      opt3RadioButton.setSelected(false);
      opt4RadioButton.setSelected(false);
      
      if(Id.equals("10"))
      {
          nextButton.setVisible(false);
      }
    }
    public void question()
    {
       try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/technicalshow","root","Aman.komal2122");
            Statement st=connection.createStatement();
            ResultSet rs1=st.executeQuery("select *from add_question where Id='"+Id+"'");
            while(rs1.next())
            {
                idLabel.setText(rs1.getString(1));
                questionLabel.setText(rs1.getString(2));
                opt1RadioButton.setText(rs1.getString(3));
                opt2RadioButton.setText(rs1.getString(4));
                opt3RadioButton.setText(rs1.getString(5));
                opt4RadioButton.setText(rs1.getString(6));
                Answer=rs1.getString(7);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void submit()
    {
       String PId=pidLabel.getText();
       answerCheck();
       try
       {
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/technicalshow","root","Aman.komal2122");
           Statement st=connection.createStatement();
           st.executeUpdate("update participant set marks='"+marks+"' where PId='"+PId+"'");
           String marks1=String.valueOf(marks);
           setVisible(false);
           new showResult(marks1).setVisible(true);
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, e);
       }
    }
    
    /**
     * Creates new form quizStart
     */
    public quizStart() {
        initComponents();
        
    }
    Timer time;
     public quizStart(String PId) {
        initComponents();
        pidLabel.setText(PId);
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/technicalshow","root","Aman.komal2122");
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery("select *from participant where PId='"+PId+"'");
            while(rs.next())
            {
                nameLabel.setText(rs.getString(2));
            }
            ResultSet rs1=st.executeQuery("select *from add_question where Id='"+Id+"'");
            while(rs1.next())
            {
                idLabel.setText(rs1.getString(1));
                questionLabel.setText(rs1.getString(2));
                opt1RadioButton.setText(rs1.getString(3));
                opt2RadioButton.setText(rs1.getString(4));
                opt3RadioButton.setText(rs1.getString(5));
                opt4RadioButton.setText(rs1.getString(6));
                Answer=rs1.getString(7);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
        setLocationRelativeTo(this);
        time=new Timer(1000,new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                secLabel.setText(String.valueOf(sec));
                minLabel.setText(String.valueOf(min));
                
                if(sec==60)
               {
                  sec=0;
                  min++;
                  if(min==2)
                  {
                     time.stop();
                     answerCheck();
                     submit();
                  }
               }
               sec++;
            }
        });
        time.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        secLabel = new javax.swing.JLabel();
        minLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        questionLabel = new javax.swing.JLabel();
        opt1RadioButton = new javax.swing.JRadioButton();
        opt2RadioButton = new javax.swing.JRadioButton();
        opt3RadioButton = new javax.swing.JRadioButton();
        opt4RadioButton = new javax.swing.JRadioButton();
        nextButton = new javax.swing.JButton();
        submitButton = new javax.swing.JButton();
        pidLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        secLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        secLabel.setForeground(new java.awt.Color(255, 51, 0));
        secLabel.setText("00");
        getContentPane().add(secLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 70, 30, 30));

        minLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        minLabel.setForeground(new java.awt.Color(255, 51, 0));
        minLabel.setText("00");
        getContentPane().add(minLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 70, 20, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 0));
        jLabel4.setText(":");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 70, 10, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("2 min");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 20, 60, 40));

        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(51, 51, 51));
        nameLabel.setText("Kanwaljeet kaur");
        getContentPane().add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 180, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("10");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 20, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("10");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, -1, -1));

        scoreLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        scoreLabel.setForeground(new java.awt.Color(204, 51, 0));
        scoreLabel.setText("00");
        getContentPane().add(scoreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, -1, 40));

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel1.setText("Question");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, -1, -1));

        idLabel.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        idLabel.setText("00");
        getContentPane().add(idLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, -1, -1));

        jLabel12.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel12.setText(":");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 10, 20));

        questionLabel.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        questionLabel.setText("Demo ?");
        getContentPane().add(questionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, 840, -1));

        opt1RadioButton.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        opt1RadioButton.setText("Option 1");
        opt1RadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt1RadioButtonActionPerformed(evt);
            }
        });
        getContentPane().add(opt1RadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, -1, -1));

        opt2RadioButton.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        opt2RadioButton.setText("Option 2");
        opt2RadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt2RadioButtonActionPerformed(evt);
            }
        });
        getContentPane().add(opt2RadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, -1, -1));

        opt3RadioButton.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        opt3RadioButton.setText("Option 3");
        opt3RadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt3RadioButtonActionPerformed(evt);
            }
        });
        getContentPane().add(opt3RadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, -1, -1));

        opt4RadioButton.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        opt4RadioButton.setText("Option 4");
        opt4RadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt4RadioButtonActionPerformed(evt);
            }
        });
        getContentPane().add(opt4RadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 400, -1, -1));

        nextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/next btn test.png"))); // NOI18N
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        getContentPane().add(nextButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 490, 95, 40));

        submitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/submit btn test.png"))); // NOI18N
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 490, 95, 40));

        pidLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pidLabel.setForeground(new java.awt.Color(51, 51, 51));
        pidLabel.setText("00");
        getContentPane().add(pidLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exit btn test.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1305, 0, 60, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/start quiz bckgrd.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 768));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opt3RadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt3RadioButtonActionPerformed
        // TODO add your handling code here:
        if(opt3RadioButton.isSelected())
        {
            opt2RadioButton.setSelected(false);
            opt1RadioButton.setSelected(false);
            opt4RadioButton.setSelected(false);
        }
    }//GEN-LAST:event_opt3RadioButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        // TODO add your handling code here:
        answerCheck();
        question();
    }//GEN-LAST:event_nextButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
        int a=JOptionPane.showConfirmDialog(null, "Do you really want to Submit ?","Select",JOptionPane.YES_NO_OPTION);
        if(a==0)
        {
            answerCheck();
            submit();
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void opt1RadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt1RadioButtonActionPerformed
        // TODO add your handling code here:
        if(opt1RadioButton.isSelected())
        {
            opt2RadioButton.setSelected(false);
            opt3RadioButton.setSelected(false);
            opt4RadioButton.setSelected(false);
        }
    }//GEN-LAST:event_opt1RadioButtonActionPerformed

    private void opt2RadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt2RadioButtonActionPerformed
        // TODO add your handling code here:
        if(opt2RadioButton.isSelected())
        {
            opt1RadioButton.setSelected(false);
            opt3RadioButton.setSelected(false);
            opt4RadioButton.setSelected(false);
        }
    }//GEN-LAST:event_opt2RadioButtonActionPerformed

    private void opt4RadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt4RadioButtonActionPerformed
        // TODO add your handling code here:
        if(opt4RadioButton.isSelected())
        {
            opt2RadioButton.setSelected(false);
            opt3RadioButton.setSelected(false);
            opt1RadioButton.setSelected(false);
        }
    }//GEN-LAST:event_opt4RadioButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new quizerHome().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(quizStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(quizStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(quizStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(quizStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new quizStart().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel idLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel minLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton nextButton;
    private javax.swing.JRadioButton opt1RadioButton;
    private javax.swing.JRadioButton opt2RadioButton;
    private javax.swing.JRadioButton opt3RadioButton;
    private javax.swing.JRadioButton opt4RadioButton;
    private javax.swing.JLabel pidLabel;
    private javax.swing.JLabel questionLabel;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JLabel secLabel;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
