/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FunciontDialog.java
 *
 * Created on Apr 19, 2010, 1:03:08 PM
 */

package buggymastercode;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.logging.Level;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.beanutils.DynaBean;
import org.jdesktop.application.Action;

/**
 *
 * @author jalvarez
 */
public class FunctionDialog extends javax.swing.JDialog {

    /** Creates new form FunciontDialog */
    public FunctionDialog(java.awt.Frame parent) {
        super(parent, true);
        initComponents();

        // Events for jTable
        this.tblVariables.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (e.getClickCount() == 2)
                {
                    Point p = e.getPoint();
                    int row = tblVariables.rowAtPoint(p);
                    int id = Db.getId(tblVariables.getValueAt(row, 0));
                    editVariable(id);
                    G.setRowSelectedById(tblVariables, id);
                }
            }
        });
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txJavaName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txVbName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        cmdAddVar = new javax.swing.JButton();
        cmdRemoveVar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVariables = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txDataType = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N
        setResizable(false);

        txJavaName.setName("txJavaName"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(buggymastercode.BuggyMasterCodeApp.class).getContext().getResourceMap(FunctionDialog.class);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        txVbName.setName("txVbName"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(buggymastercode.BuggyMasterCodeApp.class).getContext().getActionMap(FunctionDialog.class, this);
        jButton1.setAction(actionMap.get("saveFunction")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        jPanel6.setName("jPanel6"); // NOI18N

        jPanel8.setName("jPanel8"); // NOI18N

        cmdAddVar.setAction(actionMap.get("addVariable")); // NOI18N
        cmdAddVar.setText(resourceMap.getString("cmdAddVar.text")); // NOI18N
        cmdAddVar.setName("cmdAddVar"); // NOI18N

        cmdRemoveVar.setAction(actionMap.get("deleteVariable")); // NOI18N
        cmdRemoveVar.setText(resourceMap.getString("cmdRemoveVar.text")); // NOI18N
        cmdRemoveVar.setName("cmdRemoveVar"); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdAddVar)
                .addGap(7, 7, 7)
                .addComponent(cmdRemoveVar)
                .addContainerGap(172, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdAddVar)
                    .addComponent(cmdRemoveVar))
                .addGap(165, 165, 165))
        );

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        tblVariables.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "VB Name", "Java Name", "Data Type", "Is a Parameter"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVariables.setName("tblVariables"); // NOI18N
        jScrollPane2.setViewportView(tblVariables);
        tblVariables.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("tblVariables.columnModel.title0")); // NOI18N
        tblVariables.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("tblVariables.columnModel.title1")); // NOI18N
        tblVariables.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("tblVariables.columnModel.title2")); // NOI18N
        tblVariables.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("tblVariables.columnModel.title3")); // NOI18N
        tblVariables.getColumnModel().getColumn(4).setHeaderValue(resourceMap.getString("tblVariables.columnModel.title4")); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
        );

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        txDataType.setName("txDataType"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel1))
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txVbName, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txJavaName, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txDataType, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1)
                                .addGap(17, 17, 17)))))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1))
                    .addComponent(txVbName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addComponent(txJavaName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txDataType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdAddVar;
    private javax.swing.JButton cmdRemoveVar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblVariables;
    private javax.swing.JTextField txDataType;
    private javax.swing.JTextField txJavaName;
    private javax.swing.JTextField txVbName;
    // End of variables declaration//GEN-END:variables

    private void initDialog () {
        loadVariables();
    }

    public int getId() {
        return m_id;
    }
    
    public boolean edit(int id, int cl_id) {
        m_cl_id = cl_id;
        if (id != Db.CS_NO_ID) {
            String sqlstmt = "select fun_vbname, fun_javaname, fun_datatype from tfunction where fun_id = " + ((Integer)id).toString();
            DBRecordSet rs = new DBRecordSet();
            if (!Db.db.openRs(sqlstmt, rs)) {return false;}

            if (rs.getRows().isEmpty()) {
                m_id = Db.CS_NO_ID;
                this.txVbName.setText("");
                this.txJavaName.setText("");
                this.txDataType.setText("");
            }
            else {
                m_id = id;
                this.txVbName.setText(rs.getRows().get(0).get("fun_vbname").toString());
                this.txJavaName.setText(rs.getRows().get(0).get("fun_javaname").toString());
                this.txDataType.setText(rs.getRows().get(0).get("fun_datatype").toString());
            }
        }
        else {
            m_id = Db.CS_NO_ID;
            this.txVbName.setText("");
            this.txJavaName.setText("");
            this.txDataType.setText("");
        }
        initDialog();
        return true;
    }

    public void editVariable(int id) {
        if (variableDialog == null) {
            JFrame mainFrame = BuggyMasterCodeApp.getApplication().getMainFrame();
            variableDialog = new VariableDialog(mainFrame);
            variableDialog.setLocationRelativeTo(mainFrame);
        }
        variableDialog.edit(id, m_id);
        BuggyMasterCodeApp.getApplication().show(variableDialog);
        loadVariables();
    }

    @Action
    public void saveFunction() {
        if (validateFunction()) {

            FunctionObject fun = new FunctionObject();
            fun.setId(m_id);
            fun.setClId(m_cl_id);
            fun.setVbName(this.txVbName.getText());
            fun.setJavaName(this.txJavaName.getText());
            fun.setDataType(this.txDataType.getText());
            if (fun.saveFunction()) {
                m_id = fun.getId();
            }
        }
    }

    private boolean validateFunction() {

        if (this.txVbName.getText().length() == 0) {
            G.showInfo("The vb name field is required");
            return false;
        }
        if (this.txJavaName.getText().length() == 0) {
            G.showInfo("The java name field is required");
            return false;
        }
        if (this.txDataType.getText().length() == 0) {
            G.showInfo("The data type field is required");
            return false;
        }
        return true;
    }

    private boolean loadVariables() {
        try {
            DefaultTableModel model = (DefaultTableModel)this.tblVariables.getModel();
            model.getDataVector().removeAllElements();

            String sqlstmt = "select var_id, var_vbname, var_javaname, " 
                                + "var_datatype, var_isparameter "
                                + "from tvariable where fun_id = "
                                + ((Integer)m_id).toString() ;

            DBRecordSet rs = new DBRecordSet();
            if (!Db.db.openRs(sqlstmt, rs)) {return false;}

            // print the results
            for (Iterator<DynaBean> i = rs.getRows().iterator(); i.hasNext();) {
                DynaBean row = i.next();
                model.addRow(new Object[]{row.get("var_id").toString(),
                                          row.get("var_vbname").toString(),
                                          row.get("var_javaname").toString(),
                                          row.get("var_datatype").toString(),
                                          Integer.parseInt(row.get("var_isparameter").toString()) == 0 ? false : true});
            }
            return true;
        }
        catch(Exception ex) {
            BuggyMasterCodeApp.getLogger().log(Level.WARNING, "loading functions failed", ex);
            return false;
        }
    }

    @Action
    public void deleteVariable() {
        if (this.tblVariables.getRowCount() > 0) {
            int indexRow = this.tblVariables.getSelectedRow();
            Integer id = Db.getId(this.tblVariables.getValueAt(indexRow, 0));

            VariableObject var = new VariableObject();
            var.setId(id);
            if (var.deleteVariable()) {
                DefaultTableModel model = (DefaultTableModel)this.tblVariables.getModel();
                model.removeRow(indexRow);
            }
        }
    }

    private VariableDialog variableDialog;
    private int m_id;
    private int m_cl_id;
}
