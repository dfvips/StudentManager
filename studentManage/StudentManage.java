/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package studentManage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class StudentManage extends javax.swing.JFrame {

    private DefaultTableModel tableModel;
    /**
     * Creates new form StudentManage
     */
    public StudentManage() {
         this.setTitle("学生成绩管理系统-学生管理");
         
        initComponents();
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         String driverName =
                "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //String dbURL ="jdbc:sqlserver://localhost:1433;integratedSecurity=true;DatabaseName=employee";
         String dbURL = "jdbc:sqlserver://stu127;DatabaseName=student";
        //定义登录数据库用户名和密码

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
          try {
            Class.forName(driverName);
//使用指定用户名和密码连接数据库
            String username1 = "ceshi";
            String password = "ceshi";
            conn = DriverManager.getConnection(dbURL, username1, password);
            //创建Statement对象
            String sql = "select Sid,Sname,Sgender,Sbirth,Sdepart,Stel,Saddr from Student_info ";
           
            ps = conn.prepareStatement(sql);
            // 执行数据库操作
            rs = ps.executeQuery();
             
		String columnName[]={"学号","姓名","性别","生日","系别","电话","地址"}; 		
                 tableModel=new DefaultTableModel(null,columnName);
           
		      
            
            while(rs.next())
            {
                Vector data1=new Vector();
                data1.add(rs.getString(1));
                data1.add(rs.getString(2));
                 data1.add(rs.getString(3));
                 data1.add(rs.getString(4));
                  data1.add(rs.getString(5));
                   data1.add(rs.getString(6));
                    data1.add(rs.getString(7));
//                jTable1.addRow(data1);
               tableModel.addRow(data1);

                
            }
            jTable1.setModel(tableModel) ; 
           
           

           
           


        } catch (Exception e) {
            e.printStackTrace();

        } try {
                ps.close();
                 rs.close();
                 conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(StudentManage.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("新增用户");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("修改用户");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("删除用户");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addGap(0, 233, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        AddStudent a=new AddStudent(this);
        a.show();
        this.hide();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int row=jTable1.getSelectedRow();
        System.out.println("============"+tableModel.getValueAt(row, 0));
         String driverName =
                "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //String dbURL ="jdbc:sqlserver://localhost:1433;integratedSecurity=true;DatabaseName=employee";
        String dbURL = "jdbc:sqlserver://8d503;DatabaseName=student";
        //定义登录数据库用户名和密码

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            Class.forName(driverName);
//使用指定用户名和密码连接数据库
            String username1 = "ceshi";
            String password = "ceshi";
            conn = DriverManager.getConnection(dbURL, username1, password);
            //创建Statement对象
            String sql = "delete from  Student_info where Sid=";
            sql = sql + "'" + tableModel.getValueAt(row, 0) + "' ";
           

            st = conn.createStatement();
            st.execute(sql);


        } catch (Exception e) {
            e.printStackTrace();

        }
        try {
                st.close();
              
                 conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(StudentManage.class.getName()).log(Level.SEVERE, null, ex);
            }
        tableModel.removeRow(row);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         int row=jTable1.getSelectedRow();
         String sno=(String) tableModel.getValueAt(row, 0);
        updateStudent us=new updateStudent(this,sno);
        us.show();
        this.hide();
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(StudentManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentManage().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
