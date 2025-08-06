package todo;

import java.awt.Color;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class todo extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(todo.class.getName());

    public todo() {
        initComponents();
        setTitle("To Do List");
        getContentPane().setBackground(Color.white);
        setIcon();
    };

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("todo.png")));
    };

    private void setDatalist() {
        DefaultTableModel dtm = (DefaultTableModel) Tasklist.getModel();
        int rc = dtm.getRowCount();
        while (rc-- != 0) {
            dtm.removeRow(0);
        }
        try {
            FileInputStream f = new FileInputStream("task.txt");
            Scanner sc = new Scanner(f);
            while (true) {
                try {
                    Vector row = new Vector();
                    row.add(sc.nextLine());
                    dtm.addRow(row);
                } catch (Exception ex) {
                    break;
                }
            }
            f.close();
            sc.close();
        } catch (Exception ex) {
        }
    };

    @SuppressWarnings("unchecked")   private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Textlist = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tasklist = new javax.swing.JTable();
        bDel = new javax.swing.JButton();
        blist = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); 
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("To Do List");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Task :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Textlist)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(Textlist))
                .addContainerGap())
        );

        Tasklist.setBackground(new java.awt.Color(204, 204, 204));
        Tasklist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Task"
            }
        ));
        Tasklist.setOpaque(false);
        jScrollPane1.setViewportView(Tasklist);

        bDel.setBackground(new java.awt.Color(204, 204, 204));
        bDel.setFont(new java.awt.Font("Segoe UI", 1, 10)); 
        bDel.setText("Remove");
        bDel.setBorder(null);
        bDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDelActionPerformed(evt);
            }
        });

        blist.setBackground(new java.awt.Color(204, 204, 204));
        blist.setFont(new java.awt.Font("Segoe UI", 1, 10)); 
        blist.setText("Add");
        blist.setBorder(null);
        blist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blistActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(blist, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bDel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(blist, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(bDel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }

    private void blistActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            FileOutputStream f = new FileOutputStream("task.txt", true);
            PrintStream p = new PrintStream(f);
            String task = Textlist.getText();
            p.println(task);
            JOptionPane.showMessageDialog(null, "Task Added Successfully");
            setDatalist();
            p.close();
            f.close();
            Textlist.setText(null);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    private void bDelActionPerformed(java.awt.event.ActionEvent evt) {
        int r = Tasklist.getSelectedRow();
        if (r != -1) {
            String task = (String) Tasklist.getValueAt(r, 0);
            JOptionPane.showMessageDialog(null, task);
            try {
                FileOutputStream f = new FileOutputStream("temp.txt");
                PrintStream p = new PrintStream(f);
                FileInputStream fr = new FileInputStream("task.txt");
                Scanner sc = new Scanner(fr);
                while (true) {
                    try {
                        String s = sc.nextLine();
                        if (!task.equalsIgnoreCase(s)) {
                            p.println(s);
                        }
                    } catch (Exception ex) {
                        break;
                    }
                }
                p.close();
                f.close();
                fr.close();
                sc.close();
                File file = new File("task.txt");
                file.delete();
                File filetemp = new File("temp.txt");
                File newfile = new File("task.txt");
                filetemp.renameTo(newfile);
                setDatalist();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Please select text");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select text");
        }
    }
    
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new todo().setVisible(true));
    }

    private javax.swing.JTable Tasklist;
    private javax.swing.JTextField Textlist;
    private javax.swing.JButton bDel;
    private javax.swing.JButton blist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
}
