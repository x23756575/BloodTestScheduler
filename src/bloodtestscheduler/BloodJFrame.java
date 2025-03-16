/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bloodtestscheduler;

import bloodtestscheduler.Patients;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author samor
 */
public class BloodJFrame extends javax.swing.JFrame {

    File f = new File("patients.dat");
    File missed = new File("missed.dat");
    private ArrayList<Patients> prioQueue = new ArrayList<>();
    private ArrayList<Patients> noShow = new ArrayList<>(); 
    
    PriorityQueue pq = new PriorityQueue();
    Priority priority;
    public BloodJFrame() {
        
        initComponents();
       
        loadPatients();
        loadNoShows();
        this.setSize(1000,800);//sets window size
        this.setTitle("Book your blood test here!");//title..
         pq.checkShownUp();//this method will check users that have missed there appointment by 15 minutes or longer
    }
    boolean shownUp = true;//this will be used to check if the patient has shown up
    
    
public void loadPatients() {
    if (f.exists()) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            Object obj = ois.readObject();
            if (obj instanceof ArrayList) {
                prioQueue = (ArrayList<Patients>) obj;
                pq.setPrioQueue(prioQueue);//calls method in PriorityQueue to update the arraylist so the content is the most recent loaded arraylist
                printArea.setText(prioQueue.get(0).toString());//prints first index of the queue
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }
}

   public void loadNoShows(){
    if(missed.exists()){       
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(missed))) {
            Object obj = ois.readObject();
            StringBuilder ss = new StringBuilder();
           
                noShow = (ArrayList<Patients>) obj;
                pq.setNoShow(noShow);//to update noShow arraylist to the most recent content in PriorityQueue class
                
            if(!noShow.isEmpty()){//check if empty
                for(Patients patient : noShow){//loop through array to print out no shows
                 ss.append(patient);
                 ss.append("\n");
                }
             noShowArea.setText(ss.toString());//
            }else{
                System.out.println("no one has missed there appointment");
            }
                
            
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e);
        }    
        }
    }       
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        ageArea = new javax.swing.JTextArea();
        submit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        nameArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        detailsArea = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        printArea = new javax.swing.JTextArea();
        ward = new javax.swing.JCheckBox();
        jScrollPane5 = new javax.swing.JScrollPane();
        noShowArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ageArea.setColumns(20);
        ageArea.setRows(5);
        jScrollPane4.setViewportView(ageArea);

        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        nameArea.setColumns(20);
        nameArea.setRows(5);
        jScrollPane1.setViewportView(nameArea);

        detailsArea.setColumns(20);
        detailsArea.setRows(5);
        jScrollPane2.setViewportView(detailsArea);

        printArea.setColumns(20);
        printArea.setRows(5);
        jScrollPane3.setViewportView(printArea);

        ward.setText("Did u come from a ward");
        ward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wardActionPerformed(evt);
            }
        });

        noShowArea.setColumns(20);
        noShowArea.setRows(5);
        jScrollPane5.setViewportView(noShowArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addComponent(ward)
                .addContainerGap(675, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(submit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(ward, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(submit)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        String name = nameArea.getText();//takes in info from textAreas
        String strAge = ageArea.getText();//..
        int age = Integer.parseInt(strAge);//..
        String details = detailsArea.getText();//..
        boolean fromWard = ward.isSelected();
        LocalDateTime time;
   

        if(name != null && strAge != null && details != null){
         time = LocalDateTime.now();

        
        
        if(age >= 60 || age == 1 || fromWard == true){// sets priority based on age or if there coming from a ward. i think this is most suitable for a simple application       
             priority = priority.HIGH;
            
        }else if(age < 60 && age >= 35){
             priority = priority.MEDIUM;        
        }else{
             priority = priority.LOW;
        }
        
            Patients temp = new Patients(name,details,age,priority,shownUp,fromWard,time);  
            
            pq.enqueue(name,details,age,priority,shownUp,fromWard,time);
            
            pq.save();
            pq.checkShownUp();            
            loadNoShows();
            System.out.println("Patient added: " + temp);
            System.out.println("Current queue size: " + prioQueue.size());
            
        }    
            printArea.setText(pq.printPriorityQueue());
    }//GEN-LAST:event_submitActionPerformed

    private void wardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wardActionPerformed

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
            java.util.logging.Logger.getLogger(BloodJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BloodJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BloodJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BloodJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BloodJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea ageArea;
    private javax.swing.JTextArea detailsArea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea nameArea;
    private javax.swing.JTextArea noShowArea;
    private javax.swing.JTextArea printArea;
    private javax.swing.JButton submit;
    private javax.swing.JCheckBox ward;
    // End of variables declaration//GEN-END:variables
}
