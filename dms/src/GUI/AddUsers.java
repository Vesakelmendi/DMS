/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BL.Departament;
import BL.User;
import DAL.Departament.DepException;
import DAL.Departament.DepRepository;
import DAL.User.UserException;
import DAL.User.UserRepository;
import Methods.Utils;
import Model.UserTableModel;
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import static java.lang.Character.isAlphabetic;
import static java.lang.Character.isDigit;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import models.CustomComboBoxModel;

/**
 *
 * @author vesa
 */



public class AddUsers extends javax.swing.JInternalFrame {
    
    CustomComboBoxModel departamentComboBoxModel = null;
           
    DepRepository depRepository = new DepRepository();
    UserRepository userRepository = new UserRepository();
    UserTableModel userTableModel = new UserTableModel();
    
    /**
     * Creates new form AddUsers
     */
    public AddUsers() {
        initComponents(); 
        loadComboBoxs();
        getContentPane().setBackground(Color.white);
        tabelaLoad();
        
    }
    
    
    public void emptyObject() {
        tabela.clearSelection();
        txtEmri.setText("");
        txtMbiemri.setText("");
        txtUsername.setText("");
        txtPhoneNr.setText("");
        txtEmail.setText("");
        txtPassword.setText("");
        departmentComboBox.setSelectedItem(null);
        departmentComboBox.repaint();
    }

    private void tabelaLoad() {
        List<User> lista = userRepository.findAll();
        userTableModel.add(lista);
        tabela.setModel(userTableModel);
        userTableModel.fireTableDataChanged();
        tabelaSelectedIndexChange();

    }

    private void tabelaSelectedIndexChange() {
        final ListSelectionModel rowSM = tabela.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) { 
                    User useri = userTableModel.getUser(selectedIndex);
                    Departament d = null;
                    try{
                    d = depRepository.findById(useri.getDepartment());
                    }catch (DepException ex) {
                        Logger.getLogger(AddUsers.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    txtEmri.setText(useri.getFirstName());
                    txtMbiemri.setText(useri.getLastName());
                    txtUsername.setText(useri.getUsername());
                    txtPhoneNr.setText(useri.getPhone());
                    txtEmail.setText(useri.getEmail());
//                     txtPassword.setText(useri.getPassword());
                    if(adminButton.isSelected()){
                        adminButton.setSelected(useri.getIsAdmin());
                    }else{
                        adminButton.setSelected(useri.getIsAdmin());
                    }
                    
                    departmentComboBox.setSelectedItem(d); // mbushen comboboxes 
                    departmentComboBox.repaint(); // refresh 
                    
                    revComboBox.setSelectedItem(d);
                    revComboBox.repaint();
                    
                    if(canAddButton.isSelected()){
                         canAddButton.setSelected(useri.getCanAdd());
                    }else{
                        canAddButton.setSelected(useri.getCanAdd());
                    }
                     
                    if(CanCheckInButton.isSelected()){
                        CanCheckInButton.setSelected(useri.getCanCheckin());
                    }else{
                        CanCheckInButton.setSelected(useri.getCanCheckin());
                    }
                }
            }
        });
    }
    
    public void loadComboBoxs(){
        List <Departament> departaments = depRepository.findAll();
        departamentComboBoxModel = new CustomComboBoxModel(departaments);
        departmentComboBox.setModel(departamentComboBoxModel);
        revComboBox.setModel(departamentComboBoxModel);  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DMSPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("DMSPU").createEntityManager();
        userQuery = java.beans.Beans.isDesignTime() ? null : DMSPUEntityManager.createQuery("SELECT u FROM User u");
        userList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : userQuery.getResultList();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtPhoneNr = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        txtEmri = new javax.swing.JTextField();
        txtMbiemri = new javax.swing.JTextField();
        CanCheckInButton = new javax.swing.JCheckBox();
        canAddButton = new javax.swing.JCheckBox();
        revComboBox = new javax.swing.JComboBox<>();
        adminButton = new javax.swing.JCheckBox();
        departmentComboBox = new javax.swing.JComboBox<>();
        AddUserButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
        emptyFieldsButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Users Options", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 2, 12)))); // NOI18N
        setClosable(true);
        setIconifiable(true);

        jScrollPane1.setViewportView(tabela);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtPhoneNr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPhoneNrKeyPressed(evt);
            }
        });

        txtEmri.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmriKeyPressed(evt);
            }
        });

        txtMbiemri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMbiemriActionPerformed(evt);
            }
        });
        txtMbiemri.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMbiemriKeyPressed(evt);
            }
        });

        revComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        revComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                revComboBoxActionPerformed(evt);
            }
        });

        adminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminButtonActionPerformed(evt);
            }
        });

        AddUserButton.setText("Add User");
        AddUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddUserButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Last Name:");

        jLabel2.setText("First Name:");

        deleteButton.setText("Delete User");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        emptyFieldsButton.setText("Cancel");
        emptyFieldsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emptyFieldsButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Username:");

        jLabel4.setText("Phone Number:");

        jLabel6.setText("Password:");

        jLabel7.setText("E-Mail Address:");

        jLabel8.setText("Department:");

        jLabel9.setText("Is Admin?");

        jLabel10.setText("Dept. reviewer for:");

        jLabel11.setText("Can Add Documents?");

        jLabel12.setText("Can Check-In Documents?");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(29, 29, 29)
                        .addComponent(departmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(44, 44, 44)
                        .addComponent(adminButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(7, 7, 7)
                        .addComponent(revComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(canAddButton)
                            .addComponent(CanCheckInButton))
                        .addGap(129, 129, 129)
                        .addComponent(AddUserButton)
                        .addGap(23, 23, 23)
                        .addComponent(deleteButton)
                        .addGap(21, 21, 21)
                        .addComponent(emptyFieldsButton))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(35, 35, 35)
                            .addComponent(txtEmri, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMbiemri, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(jLabel3)
                            .addGap(8, 8, 8)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(16, 16, 16)
                            .addComponent(txtPhoneNr, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(jLabel7)
                            .addGap(6, 6, 6)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(jLabel6)
                            .addGap(10, 10, 10)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtEmri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtMbiemri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtPhoneNr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(departmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel9))
                    .addComponent(adminButton))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(revComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(canAddButton)
                        .addGap(9, 9, 9)
                        .addComponent(CanCheckInButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AddUserButton)
                            .addComponent(deleteButton)
                            .addComponent(emptyFieldsButton)))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adminButtonActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void AddUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddUserButtonActionPerformed
        // TODO add your handling code here:
       Departament departament = (Departament) departmentComboBox.getSelectedItem();
         try {
            int row = tabela.getSelectedRow();
            if (txtEmri.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Enter Name:", "First Name:", JOptionPane.ERROR_MESSAGE); 
            }else if (txtMbiemri.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Enter Surname:", "Last Name:", JOptionPane.ERROR_MESSAGE);
            }else if (txtUsername.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Enter Username:", "Username:", JOptionPane.ERROR_MESSAGE);
            }else if (txtPhoneNr.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Enter Your Phone Number:", "Phone Number:", JOptionPane.ERROR_MESSAGE);
            }
            else if (txtEmail.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Enter Email:", "E-Mail Address:", JOptionPane.ERROR_MESSAGE);
            }else if ((new String(txtPassword.getPassword())).isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Password:", "Password:", JOptionPane.ERROR_MESSAGE);
            }else if (departmentComboBox.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(this, "Please select the department:", "Department:", JOptionPane.ERROR_MESSAGE);
            }else if (!Utils.validateEmail(txtEmail.getText())) {
                JOptionPane.showMessageDialog(this, "Please type valide Email:", "E-Mail Address:", JOptionPane.ERROR_MESSAGE);
            }else {
                String hash = MD5.getHash(String.valueOf(txtPassword.getPassword()));
                if (row == -1) {
                    User user = new User();
                                      
                    user.setUsername(txtUsername.getText());
                    user.setPassword(hash);
                    user.setPhone(txtPhoneNr.getText());
                    user.setDepartment(departament.getId());
                    user.setEmail(txtEmail.getText());
                    user.setLastName(txtMbiemri.getText());
                    user.setFirstName(txtEmri.getText());
                    if(adminButton.isSelected()){
                        user.setIsAdmin(true);
                    }else{
                        user.setIsAdmin(false);
                    }

                    if(canAddButton.isSelected()){
                        user.setCanAdd(true);
                    }else{
                        user.setCanAdd(false);
                    }

                    if(CanCheckInButton.isSelected()){
                        user.setCanCheckin(true);
                    }else{
                        user.setCanCheckin(false);
                    }
                     
                     
                    userRepository.create(user);
                    JOptionPane.showMessageDialog(this, "User has been saved!");
                } else {
                    User user = this.userTableModel.getUser(row);

                    user.setUsername(txtUsername.getText());
                    user.setPassword(hash);
                    user.setPhone(txtPhoneNr.getText());
                    user.setDepartment(departament.getId());
                    user.setEmail(txtEmail.getText());
                    user.setLastName(txtMbiemri.getText());
                    user.setFirstName(txtEmri.getText());

                     if(adminButton.isSelected()){
                        user.setIsAdmin(true);
                    }else{
                        user.setIsAdmin(false);
                    }

                    if(canAddButton.isSelected()){
                        user.setCanAdd(true);
                    }else{
                        user.setCanAdd(false);
                    }

                    if(CanCheckInButton.isSelected()){
                        user.setCanCheckin(true);
                    }else{
                        user.setCanCheckin(false);
                    }
                     
                    userRepository.edit(user);
                    JOptionPane.showMessageDialog(this, "User was successfully edited.");
                }
                emptyObject();
                tabelaLoad();
            };

        } catch (UserException pe) {
            JOptionPane.showMessageDialog(this, "Username exists");
        }

    }//GEN-LAST:event_AddUserButtonActionPerformed

    private void revComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_revComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_revComboBoxActionPerformed

    private void txtMbiemriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMbiemriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMbiemriActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
         try{
            int row = tabela.getSelectedRow();
            if(row > -1){
                Object [] ob = {"Yes","No"};
                int i = javax.swing.JOptionPane.showOptionDialog(this, "Do you want to delete it?", "Delete:", JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
                if(i==0){
                    User user = this.userTableModel.getUser(row);
                    userRepository.remove(user);
                    tabelaLoad();
                    emptyObject();
                    JOptionPane.showMessageDialog(this, "User has been deleted succesfully!");
                }
            }
            else{
                JOptionPane.showMessageDialog(this,"You haven't selected anything to delete!");
            }
        }catch(UserException pe){
            JOptionPane.showMessageDialog(this,"This user cant be deleted because he is attached to other data");
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void emptyFieldsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emptyFieldsButtonActionPerformed
        // TODO add your handling code here:    
       emptyObject();
    }//GEN-LAST:event_emptyFieldsButtonActionPerformed

    private void txtEmriKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmriKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        
        if(isAlphabetic(c) || c == KeyEvent.VK_BACKSPACE){
            txtEmri.setEditable(true);
        }
        else{
            txtEmri.setEditable(false);
        }
    }//GEN-LAST:event_txtEmriKeyPressed

    private void txtMbiemriKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMbiemriKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        
        if(isAlphabetic(c) || c == KeyEvent.VK_BACKSPACE){
            txtMbiemri.setEditable(true);
        }
        else{
            txtMbiemri.setEditable(false);
        }
    }//GEN-LAST:event_txtMbiemriKeyPressed

    private void txtPhoneNrKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneNrKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        
        if(isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_PLUS || c == KeyEvent.VK_ADD){
            txtPhoneNr.setEditable(true);
        }
        else{
            txtPhoneNr.setEditable(false);
        }
    }//GEN-LAST:event_txtPhoneNrKeyPressed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddUserButton;
    private javax.swing.JCheckBox CanCheckInButton;
    private javax.persistence.EntityManager DMSPUEntityManager;
    private javax.swing.JCheckBox adminButton;
    private javax.swing.JCheckBox canAddButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JComboBox<String> departmentComboBox;
    private javax.swing.JButton emptyFieldsButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> revComboBox;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmri;
    private javax.swing.JTextField txtMbiemri;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPhoneNr;
    private javax.swing.JTextField txtUsername;
    private java.util.List<BL.User> userList;
    private javax.persistence.Query userQuery;
    // End of variables declaration//GEN-END:variables
}
