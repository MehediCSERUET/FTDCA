/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ftdca;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mehedi Hasan
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuLabel = new javax.swing.JLabel();
        TwitterButton = new javax.swing.JButton();
        FacebookButton = new javax.swing.JButton();
        JSON2MySQLButton = new javax.swing.JButton();
        PreProcessButton = new javax.swing.JButton();
        EditButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(3840, 2160));
        setMinimumSize(new java.awt.Dimension(1200, 700));

        MenuLabel.setFont(new java.awt.Font("Lucida Calligraphy", 2, 24)); // NOI18N
        MenuLabel.setText(" Choose Your Desired Option");

        TwitterButton.setFont(new java.awt.Font("Lucida Calligraphy", 0, 14)); // NOI18N
        TwitterButton.setText("Twitter");
        TwitterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TwitterButtonActionPerformed(evt);
            }
        });

        FacebookButton.setFont(new java.awt.Font("Lucida Calligraphy", 0, 14)); // NOI18N
        FacebookButton.setText("Facebook");
        FacebookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FacebookButtonActionPerformed(evt);
            }
        });

        JSON2MySQLButton.setFont(new java.awt.Font("Lucida Calligraphy", 0, 14)); // NOI18N
        JSON2MySQLButton.setText("JSON2MySQL");
        JSON2MySQLButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JSON2MySQLButtonActionPerformed(evt);
            }
        });

        PreProcessButton.setFont(new java.awt.Font("Lucida Calligraphy", 0, 14)); // NOI18N
        PreProcessButton.setText("Pre-Process");
        PreProcessButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreProcessButtonActionPerformed(evt);
            }
        });

        EditButton.setFont(new java.awt.Font("Lucida Calligraphy", 0, 14)); // NOI18N
        EditButton.setText("Edit Credentials");
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MenuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(387, 387, 387))
            .addGroup(layout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addComponent(TwitterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(FacebookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(PreProcessButton, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(JSON2MySQLButton, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(EditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(MenuLabel)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 283, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PreProcessButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JSON2MySQLButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(200, 200, 200))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TwitterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FacebookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TwitterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TwitterButtonActionPerformed
        //setting menu unvisible
        this.setVisible(false);
        //creating a twitter Credential form    
        TwitterResult t = null;
        try {
            t = new TwitterResult();
            t.setVisible(true);   
        } catch (Exception ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_TwitterButtonActionPerformed

    private void FacebookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FacebookButtonActionPerformed
        //setting menu unvisible
        this.setVisible(false);
        //Creating a new facebook credential form
        
        FacebookResult f = new FacebookResult();
        f.setVisible(true);
    }//GEN-LAST:event_FacebookButtonActionPerformed

    private void JSON2MySQLButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JSON2MySQLButtonActionPerformed
        JSON2MySQL jm = new JSON2MySQL();
        this.setVisible(false);
        jm.setVisible(true);
    }//GEN-LAST:event_JSON2MySQLButtonActionPerformed

    private void PreProcessButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreProcessButtonActionPerformed
        this.setVisible(false);
        PreProcess p = new PreProcess();
        p.setVisible(true);
    }//GEN-LAST:event_PreProcessButtonActionPerformed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
       this.setVisible(false);
       EditInfo e = new EditInfo();
       e.setVisible(true);
    }//GEN-LAST:event_EditButtonActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EditButton;
    private javax.swing.JButton FacebookButton;
    private javax.swing.JButton JSON2MySQLButton;
    private javax.swing.JLabel MenuLabel;
    private javax.swing.JButton PreProcessButton;
    private javax.swing.JButton TwitterButton;
    // End of variables declaration//GEN-END:variables
}
