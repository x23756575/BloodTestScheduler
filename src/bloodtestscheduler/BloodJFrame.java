/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bloodtestscheduler;

import bloodtestscheduler.Patients;
import bloodtestscheduler.dll.DLL;
import bloodtestscheduler.queue.Queue;
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
    DLL prioQueueDLL = new DLL();   
    PriorityQueue pq = new PriorityQueue();
    Queue queue = new Queue();
    

    Priority priority;
    public BloodJFrame() {
        
        initComponents();
        loadPatients();     
        loadNoShows();
        this.setSize(1000,800);//sets window size
        this.setTitle("Book your blood test here!");//title..
                hardCodedPatients();
        pq.checkShownUp();//this method will check users that have missed there appointment by 15 minutes or longer on loadup of application
    }
    boolean shownUp = true;//this will be used to check if the patient has shown up
        //hardcoded values for tester to check------------------------------------------
    
    public void hardCodedPatients(){
    Patients patient1 = new Patients("Alex", "heart", 65, Priority.HIGH, true, false, LocalDateTime.now());
    Patients patient2 = new Patients("Sam", "bleeding", 50, Priority.HIGH, true, true, LocalDateTime.now());
    Patients patient3 = new Patients("Bob", "none", 40, Priority.MEDIUM, true, false, LocalDateTime.now());
    Patients patient4 = new Patients("Jack", "stroke", 30, Priority.LOW, true, false, LocalDateTime.now());   
    
//    pq.enqueue(patient1.getName(), patient1.getDetails(), patient1.getAge(), patient1.getPriority(), patient1.getShownUp(), patient1.getFromWard(), patient1.getTime());
//    pq.enqueue(patient2.getName(), patient2.getDetails(), patient2.getAge(), patient2.getPriority(), patient2.getShownUp(), patient2.getFromWard(), patient2.getTime());
//    pq.enqueue(patient3.getName(), patient3.getDetails(), patient3.getAge(), patient3.getPriority(), patient3.getShownUp(), patient3.getFromWard(), patient3.getTime());
//    pq.enqueue(patient4.getName(), patient4.getDetails(), patient4.getAge(), patient4.getPriority(), patient4.getShownUp(), patient4.getFromWard(), patient4.getTime());
//    pq.updateDLL(prioQueueDLL);//tests i ran
    } 
 ///------------------------------------   
    public void loadPatients() {
        if (f.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
                Object obj = ois.readObject();
                if (obj instanceof DLL) {
                    prioQueueDLL = (DLL) obj;
                
                    pq.updateDLL(prioQueueDLL);//i added this method because the dll was being updates consistenly throughout my code, so this updates the prioQueueDLL in PriorityQueue class
                    pq.updateQueue(queue);
                    
                    if (prioQueueDLL.getHead() != null) { 
                        prioQueueDLL.setCurr(prioQueueDLL.getHead());//i had issues with curr being null, so i set it to head to fix that when patients load up so next and back function properly
                        printArea.setText(prioQueueDLL.getPatientInfo());
                    } else {
                        printArea.setText("No patients in the queue.");
                    }
                    pq.checkShownUp();
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
            
            
            if(obj instanceof Queue){//implemented the stack
                queue = (Queue) obj;
                pq.updateQueue(queue);
              noShowArea.setText(queue.displayQueue());//displays all of stack
            }

        }catch(IOException | ClassNotFoundException e){
            System.out.println(e);
        }    
        }
    }     
   
   public Priority checkDetails(Patients temp){
       
       String tempDetails = temp.getDetails().toLowerCase();//takes in details from patient
       
       String[] newDetails = tempDetails.split("\\s+");//splits word so i can compare them with keywords from the array
       Priority originalPrio = temp.getPriority();//stores the original priority so we dont lose it if there details dont match
        String[] highPriority = {"heart", "attack", "stroke", "burns", "trauma","breathing", "bleeding","bleed","poison", "seizure", "chest pain", "anaphylaxis"};
        
        for(int i = 0; i < newDetails.length; i++){
            for(int j = 0;j < highPriority.length;j++){
                if(newDetails[i].equals(highPriority[j])){
                  return priority.HIGH;//givese the user high priority
                    
                }else{
                    System.out.println("the patient priority will be determined by age");
                }
            }
            
        }return originalPrio;// this will return there original priority given by age if none of there details match anything
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
        next = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ageArea.setColumns(20);
        ageArea.setRows(5);
        jScrollPane4.setViewportView(ageArea);

        submit.setText("Request a test");
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

        next.setBackground(java.awt.Color.green);
        next.setForeground(java.awt.Color.black);
        next.setText("Next");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        back.setBackground(java.awt.Color.green);
        back.setForeground(java.awt.Color.black);
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("No show patients");

        jLabel2.setText("Enter your name");

        jLabel4.setText("Enter your details (use keywords)");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Current appointments");

        jLabel6.setText("Enter your age");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ward)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1)
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(next, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                            .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(44, 44, 44))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(ward, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
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
            nameArea.setText("");
            ageArea.setText("");
            detailsArea.setText("");
            ward.setSelected(false);
          
         time = LocalDateTime.now();
         
        if(age >= 60 || age == 1 || fromWard == true){// sets priority based on age or if there coming from a ward. i think this is most suitable for a simple application       
             priority = priority.HIGH;
            
        }else if(age < 60 && age >= 35){
             priority = priority.MEDIUM;        
        }else{
             priority = priority.LOW;
        }
            Patients temp = new Patients(name,details,age,priority,shownUp,fromWard,time);  
            Priority detailsPrio = checkDetails(temp); //this method wil give them high priorty uf they enter important details such as stroke etc
            
            pq.enqueue(name,details,age,detailsPrio,shownUp,fromWard,time);//sends data to PriorityQueue to be added
            
            pq.checkShownUp();//checks if theres any users that havent shownup
            
        }    
            printArea.setText(pq.printPriorityQueue());
    }//GEN-LAST:event_submitActionPerformed

    private void wardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wardActionPerformed

    }//GEN-LAST:event_wardActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        pq.next();
        printArea.setText(pq.getPatientInfo());  
    }//GEN-LAST:event_nextActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        pq.back();
        printArea.setText(pq.getPatientInfo());        
    }//GEN-LAST:event_backActionPerformed

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
    private javax.swing.JButton back;
    private javax.swing.JTextArea detailsArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea nameArea;
    private javax.swing.JButton next;
    private javax.swing.JTextArea noShowArea;
    private javax.swing.JTextArea printArea;
    private javax.swing.JButton submit;
    private javax.swing.JCheckBox ward;
    // End of variables declaration//GEN-END:variables
}
