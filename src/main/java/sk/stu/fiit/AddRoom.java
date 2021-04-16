/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit;

/**
 *
 * @author DADO
 */
public class AddRoom extends javax.swing.JFrame {

    /**
     * Creates new form AddRoom
     */
    public AddRoom() {
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

        setCategoryBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        roomNumber = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        notesArea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        forwardImageBtn = new javax.swing.JButton();
        backImageBtn = new javax.swing.JButton();
        addImageBtn = new javax.swing.JButton();
        createBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        setCategoryBtn.setText("Vybrať Kategóriu");
        getContentPane().add(setCategoryBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 170, 20));
        getContentPane().add(roomNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 130, -1));

        jLabel2.setText("Označenie izby:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        notesArea.setColumns(20);
        notesArea.setRows(5);
        jScrollPane1.setViewportView(notesArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 210, 90));

        jLabel3.setText("Poznámky:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 240, 200));

        forwardImageBtn.setText(">");
        getContentPane().add(forwardImageBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, -1, -1));

        backImageBtn.setText("<");
        getContentPane().add(backImageBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, -1, -1));

        addImageBtn.setText("Pridať obrázok");
        getContentPane().add(addImageBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, -1));

        createBtn.setText("Vytvoriť");
        getContentPane().add(createBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 310, -1, -1));

        cancelBtn.setText("Zrušiť");
        getContentPane().add(cancelBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 310, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(AddRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddRoom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addImageBtn;
    private javax.swing.JButton backImageBtn;
    private javax.swing.JButton cancelBtn;
    public javax.swing.JButton createBtn;
    private javax.swing.JButton forwardImageBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea notesArea;
    private javax.swing.JTextField roomNumber;
    private javax.swing.JButton setCategoryBtn;
    // End of variables declaration//GEN-END:variables
}
