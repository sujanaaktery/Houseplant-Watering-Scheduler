
package gui;

import manager.PlantManager;
import plants.Plant;
import plants.Fern;
import plants.Succulent;
import interfaces.Alertable;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.util.List;
import java.awt.Color;
public class MainFrame extends javax.swing.JFrame implements Alertable {
    private PlantManager manager;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainFrame.class.getName());

  public MainFrame() {
    initComponents();
    setIconImage(null);
    manager = PlantManager.getInstance();

    setupTableColors();

    loadPlantsToTable();
}
   
   private String getPlantStatus(Plant plant) {

    LocalDate today = LocalDate.now();
    LocalDate nextDue = plant.getNextDueDate();

    if (today.isAfter(nextDue)) {
        return "Overdue";
    } 
    else if (today.isEqual(nextDue)) {
        return "Needs Water";
    } 
    else {
        return "Healthy";
    }
}

    public void loadPlantsToTable() {

    javax.swing.table.DefaultTableModel model =
            (javax.swing.table.DefaultTableModel) tblPlants.getModel();

    model.setRowCount(0);

    List<Plant> plantList = manager.getAllPlants();

    for (Plant plant : plantList) {

        String status = getPlantStatus(plant);

        model.addRow(new Object[]{
            plant.getName(),
            plant.getClass().getSimpleName(),
            plant.getLastWateredDate(),
            plant.getNextDueDate(),
            status
        });
    }

    tblPlants.repaint();
}
   private void setupTableColors() {

    tblPlants.setDefaultRenderer(Object.class,
        new javax.swing.table.DefaultTableCellRenderer() {

            @Override
            public java.awt.Component getTableCellRendererComponent(
                    javax.swing.JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {

                java.awt.Component component =
                        super.getTableCellRendererComponent(
                                table,
                                value,
                                isSelected,
                                hasFocus,
                                row,
                                column
                        );

                // Get the Status column value
                Object status = table.getValueAt(row, 4);

                // Overdue row
                if ("Overdue".equals(status)) {

                    component.setBackground(new java.awt.Color(255, 220, 220));
                    component.setForeground(java.awt.Color.RED);

                }
                // Needs Water row
                else if ("Needs Water".equals(status)) {

                    component.setBackground(new java.awt.Color(255, 245, 200));
                    component.setForeground(new java.awt.Color(200, 120, 0));

                }
                // Healthy row
                else {

                    component.setBackground(java.awt.Color.WHITE);
                    component.setForeground(java.awt.Color.BLACK);
                }

                // Keep selected row visible
                if (isSelected) {
                    component.setBackground(
                            table.getSelectionBackground()
                    );
                    component.setForeground(
                            table.getSelectionForeground()
                    );
                }

                return component;
            }
        }
    );
}
    @Override
public void showAlert(String message) {

    JOptionPane.showMessageDialog(
            this,
            message,
            "🌿 Plant Water Reminder",
            JOptionPane.WARNING_MESSAGE
    );
}
private void checkWateringReminders() {

    List<Plant> plantList = manager.getAllPlants();

    boolean foundReminder = false;

    for (Plant plant : plantList) {

        String status = getPlantStatus(plant);

        if (status.equals("Overdue")) {

            showAlert(
                "⚠️ " + plant.getName()
                + " is OVERDUE for watering!\n"
                + "It was due on: "
                + plant.getNextDueDate()
            );

            foundReminder = true;
        }
        else if (status.equals("Needs Water")) {

            showAlert(
                "🌿 " + plant.getName()
                + " needs water today!"
            );

            foundReminder = true;
        }
    }

    if (!foundReminder) {

        JOptionPane.showMessageDialog(
                this,
                "🌱 No plants need watering right now.",
                "Water Reminder",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        lnlTitle = new javax.swing.JLabel();
        btnAddPlant = new javax.swing.JButton();
        btnCheckReminder = new javax.swing.JButton();
        btnStatistics = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        scrollPlants = new javax.swing.JScrollPane();
        tblPlants = new javax.swing.JTable();
        lblSearch = new javax.swing.JLabel();
        btnWaterNow = new javax.swing.JButton();
        btnRemovePlant = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlMain.setBackground(new java.awt.Color(204, 255, 204));

        lnlTitle.setBackground(new java.awt.Color(0, 204, 0));
        lnlTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lnlTitle.setText("Houseplant Watering Scheduler");

        btnAddPlant.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddPlant.setText(" Add Plant");
        btnAddPlant.addActionListener(this::btnAddPlantActionPerformed);

        btnCheckReminder.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCheckReminder.setText("Check Reminder");
        btnCheckReminder.addActionListener(this::btnCheckReminderActionPerformed);

        btnStatistics.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnStatistics.setText("Statistics");
        btnStatistics.addActionListener(this::btnStatisticsActionPerformed);

        btnExit.setBackground(new java.awt.Color(255, 0, 0));
        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(this::btnExitActionPerformed);

        txtSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(this::btnSearchActionPerformed);

        tblPlants.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Plant Name", "Plant Type", "Last Watered", "Next Due Date", "Status"
            }
        ));
        scrollPlants.setViewportView(tblPlants);

        lblSearch.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblSearch.setText("Search :");

        btnWaterNow.setBackground(new java.awt.Color(0, 255, 0));
        btnWaterNow.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnWaterNow.setForeground(new java.awt.Color(255, 255, 255));
        btnWaterNow.setText("Water Now");
        btnWaterNow.addActionListener(this::btnWaterNowActionPerformed);

        btnRemovePlant.setBackground(new java.awt.Color(153, 153, 153));
        btnRemovePlant.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRemovePlant.setForeground(new java.awt.Color(255, 255, 255));
        btnRemovePlant.setText("Remove Plant");
        btnRemovePlant.addActionListener(this::btnRemovePlantActionPerformed);

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159))
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(lnlTitle))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(btnSearch))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(scrollPlants, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlMainLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(btnAddPlant)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCheckReminder)
                                .addGap(30, 30, 30)
                                .addComponent(btnStatistics)
                                .addGap(39, 39, 39))))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btnWaterNow)
                        .addGap(44, 44, 44)
                        .addComponent(btnRemovePlant)
                        .addGap(47, 47, 47)
                        .addComponent(btnExit)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lnlTitle)
                .addGap(31, 31, 31)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddPlant)
                    .addComponent(btnCheckReminder)
                    .addComponent(btnStatistics))
                .addGap(39, 39, 39)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSearch)
                .addGap(18, 18, 18)
                .addComponent(scrollPlants, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit)
                    .addComponent(btnWaterNow)
                    .addComponent(btnRemovePlant))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddPlantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPlantActionPerformed
        // TODO add your handling code here:
        AddPlantFrame addFrame = new AddPlantFrame(manager, this);

addFrame.setLocationRelativeTo(this);
addFrame.setVisible(true);
this.setVisible(false);
    }//GEN-LAST:event_btnAddPlantActionPerformed

    private void btnCheckReminderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckReminderActionPerformed
        // TODO add your handling code here:
        checkWateringReminders();
    }//GEN-LAST:event_btnCheckReminderActionPerformed

    private void btnWaterNowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWaterNowActionPerformed
        // TODO add your handling code here:
         int selectedRow = tblPlants.getSelectedRow();

    if (selectedRow == -1) {

        JOptionPane.showMessageDialog(
                this,
                "Please select a plant first.",
                "No Plant Selected",
                JOptionPane.WARNING_MESSAGE
        );

        return;
    }

    String plantName =
            tblPlants.getValueAt(selectedRow, 0).toString();

    Plant selectedPlant = null;

    for (Plant plant : manager.getAllPlants()) {

        if (plant.getName().equals(plantName)) {
            selectedPlant = plant;
            break;
        }
    }
    if (selectedPlant != null) {

    selectedPlant.setLastWateredDate(
            LocalDate.now()
    );
    manager.savePlants();
    loadPlantsToTable();

    JOptionPane.showMessageDialog(
            this,
            "💧 " + selectedPlant.getName()
            + " has been watered!",
            "Watering Successful",
            JOptionPane.INFORMATION_MESSAGE
    );
}
        
    }//GEN-LAST:event_btnWaterNowActionPerformed

    private void btnStatisticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatisticsActionPerformed
        // TODO add your handling code here:
        StatisticsFrame statisticsFrame = new StatisticsFrame(manager,this);

statisticsFrame.setLocationRelativeTo(this);
statisticsFrame.setVisible(true);
this.setVisible(false);
    }//GEN-LAST:event_btnStatisticsActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
         System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String keyword = txtSearch.getText().trim();

List<Plant> result = manager.searchPlant(keyword);

javax.swing.table.DefaultTableModel model =
        (javax.swing.table.DefaultTableModel) tblPlants.getModel();

model.setRowCount(0);

for (Plant plant : result) {

    String status = getPlantStatus(plant);

    

    model.addRow(new Object[]{
        plant.getName(),
        plant.getClass().getSimpleName(),
        plant.getLastWateredDate(),
        plant.getNextDueDate(),
        status
    });
}
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnRemovePlantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemovePlantActionPerformed
        // TODO add your handling code here:
         int selectedRow = tblPlants.getSelectedRow();

    if (selectedRow == -1) {

        JOptionPane.showMessageDialog(
                this,
                "Please select a plant first.",
                "No Plant Selected",
                JOptionPane.WARNING_MESSAGE
        );

        return;
    }

    String plantName = tblPlants.getValueAt(selectedRow, 0).toString();

    int choice = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to remove " + plantName + "?",
            "Remove Plant",
            JOptionPane.YES_NO_OPTION
    );

    if (choice == JOptionPane.YES_OPTION) {

        Plant selectedPlant = null;

        for (Plant plant : manager.getAllPlants()) {

            if (plant.getName().equals(plantName)) {
                selectedPlant = plant;
                break;
            }
        }

        if (selectedPlant != null) {

            manager.removePlant(selectedPlant);

            loadPlantsToTable();

            JOptionPane.showMessageDialog(
                    this,
                    plantName + " removed successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
    }//GEN-LAST:event_btnRemovePlantActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MainFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPlant;
    private javax.swing.JButton btnCheckReminder;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnRemovePlant;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnStatistics;
    private javax.swing.JButton btnWaterNow;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lnlTitle;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JScrollPane scrollPlants;
    private javax.swing.JTable tblPlants;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
