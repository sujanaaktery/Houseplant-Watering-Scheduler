
package gui;


import java.time.LocalDate;
import manager.PlantManager;
import plants.Plant;
public class StatisticsFrame extends javax.swing.JFrame {
   
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(StatisticsFrame.class.getName());
    private PlantManager manager;
    private MainFrame mainFrame;
    public StatisticsFrame(PlantManager manager, MainFrame mainFrame) {
    initComponents();
    setIconImage(null);

    this.manager = manager;
    this.mainFrame = mainFrame;

    setDefaultCloseOperation(
        javax.swing.WindowConstants.DISPOSE_ON_CLOSE
    );

    addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosing(java.awt.event.WindowEvent evt) {
            mainFrame.setVisible(true);
        }
    });

    fernLabel.setVisible(false);

    int total = manager.getAllPlants().size();
    totalPlantsLabel.setText("" + total);

    int fern = 0;

    for (Plant p : manager.getAllPlants()) {
        if (p.getClass().getSimpleName().equals("Fern")) {
            fern++;
        }
    }

    jLabel2.setText("" + fern);

    int succulent = 0;

    for (Plant p : manager.getAllPlants()) {
        if (p.getClass().getSimpleName().equals("Succulent")) {
            succulent++;
        }
    }

    succulentLabel.setText("" + succulent);
    int needsWater = 0;
int overdue = 0;
int healthy = 0;

LocalDate today = LocalDate.now();

for (Plant p : manager.getAllPlants()) {

    LocalDate nextDue = p.getNextDueDate();

    if (today.isAfter(nextDue)) {
        overdue++;
    }
    else if (today.isEqual(nextDue)) {
        needsWater++;
    }
    else {
        healthy++;
    }
}

needsWaterLabel.setText("" + needsWater);
overdueLabel.setText("" + overdue);
healthyLabel.setText("" + healthy);
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlStatistics = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        fernLabel = new javax.swing.JLabel();
        lblTotalPlants = new javax.swing.JLabel();
        lblFern = new javax.swing.JLabel();
        lblSucculent = new javax.swing.JLabel();
        lblNeedsWater = new javax.swing.JLabel();
        lblHealthy = new javax.swing.JLabel();
        totalPlantsLabel = new javax.swing.JLabel();
        succulentLabel = new javax.swing.JLabel();
        needsWaterLabel = new javax.swing.JLabel();
        healthyLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        lblOverdue = new javax.swing.JLabel();
        overdueLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlStatistics.setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        lblTitle.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\Downloads\\WhatsApp Image 2026-08-04 at 11.00.07 AM.jpeg")); // NOI18N
        lblTitle.setText("Plant Statistics");

        lblTotalPlants.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTotalPlants.setText("Total Plants  : ");

        lblFern.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFern.setText("Fern  : ");

        lblSucculent.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSucculent.setText("Succulent : ");

        lblNeedsWater.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNeedsWater.setText("Needs Water  : ");

        lblHealthy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblHealthy.setText("Healthy   : ");

        totalPlantsLabel.setText("0");

        succulentLabel.setText("0");

        needsWaterLabel.setText("0");

        healthyLabel.setText("0");

        jLabel2.setText("0");

        btnClose.setBackground(new java.awt.Color(255, 0, 0));
        btnClose.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(this::btnCloseActionPerformed);

        lblOverdue.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblOverdue.setText("      Overdue   :");

        overdueLabel.setText("    0");

        javax.swing.GroupLayout pnlStatisticsLayout = new javax.swing.GroupLayout(pnlStatistics);
        pnlStatistics.setLayout(pnlStatisticsLayout);
        pnlStatisticsLayout.setHorizontalGroup(
            pnlStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStatisticsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlStatisticsLayout.createSequentialGroup()
                        .addComponent(fernLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(pnlStatisticsLayout.createSequentialGroup()
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(132, 132, 132))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlStatisticsLayout.createSequentialGroup()
                .addGroup(pnlStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlStatisticsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblHealthy))
                    .addGroup(pnlStatisticsLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(pnlStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblNeedsWater)
                                .addGroup(pnlStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSucculent)
                                    .addComponent(lblFern))
                                .addComponent(lblTotalPlants))
                            .addComponent(lblOverdue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(pnlStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlStatisticsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addGroup(pnlStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(needsWaterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalPlantsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(succulentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(healthyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79))
                    .addGroup(pnlStatisticsLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(overdueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(pnlStatisticsLayout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(btnClose)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlStatisticsLayout.setVerticalGroup(
            pnlStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStatisticsLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTotalPlants)
                    .addComponent(totalPlantsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFern, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSucculent)
                    .addComponent(succulentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOverdue)
                    .addComponent(overdueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(needsWaterLabel)
                    .addComponent(lblNeedsWater))
                .addGap(12, 12, 12)
                .addGroup(pnlStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(healthyLabel)
                    .addComponent(lblHealthy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fernLabel)
                .addGap(18, 18, 18)
                .addComponent(btnClose)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlStatistics, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlStatistics, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        mainFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JLabel fernLabel;
    private javax.swing.JLabel healthyLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblFern;
    private javax.swing.JLabel lblHealthy;
    private javax.swing.JLabel lblNeedsWater;
    private javax.swing.JLabel lblOverdue;
    private javax.swing.JLabel lblSucculent;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTotalPlants;
    private javax.swing.JLabel needsWaterLabel;
    private javax.swing.JLabel overdueLabel;
    private javax.swing.JPanel pnlStatistics;
    private javax.swing.JLabel succulentLabel;
    private javax.swing.JLabel totalPlantsLabel;
    // End of variables declaration//GEN-END:variables
}
