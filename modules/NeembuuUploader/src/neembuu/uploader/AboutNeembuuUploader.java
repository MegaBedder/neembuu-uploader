/* 
 * Copyright (C) 2015 Shashank Tulsyan <shashaank at neembuu.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package neembuu.uploader;

import java.awt.Desktop;
import java.net.URI;
import java.util.logging.Level;
import neembuu.uploader.utils.NULogger;

/**
 *
 * @author dsivaji
 */
public class AboutNeembuuUploader extends javax.swing.JDialog {

    //Singleton
    private static AboutNeembuuUploader INSTANCE = new AboutNeembuuUploader(NeembuuUploader.getInstance(),true);

    /**
     * 
     * @return Singleton Instance of AboutNeembuuUploader
     */
    public static AboutNeembuuUploader getInstance() {
       // NULogger.getLogger().info("Opening About window");
        return INSTANCE;
    }

    /** 
     * Creates new form AboutNeembuuUploader
     */
    public AboutNeembuuUploader(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //here we will use the UI
        aboutVersionLabel.setText("<html><b>v" + NeembuuUploader.getVersionNumberForUI() + "</b></html>");
    }

    private AboutNeembuuUploader() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aboutPanel = new javax.swing.JPanel();
        aboutProductPanel = new javax.swing.JPanel();
        aboutLogo = new javax.swing.JLabel();
        aboutLabel = new javax.swing.JLabel();
        aboutVersionLabel = new javax.swing.JLabel();
        licenseLabel = new javax.swing.JLabel();
        authorLabel = new javax.swing.JLabel();
        descLabel = new javax.swing.JLabel();
        siteLabel = new javax.swing.JLabel();
        aboutTabbedPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        developersTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        translatorsTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        aboutProductPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Neembuu Uploader"));

        aboutLogo.setToolTipText("Open Source File Splitter and Joiner");

        aboutLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/neembuuuploader/resources/AboutLogo.png"))); // NOI18N

        aboutVersionLabel.setText("...");

        licenseLabel.setText("License: GPLv3.0");

        authorLabel.setText("<html>The project is maintained by volunteers of the NU project. Please find us at <a href='http://neembuu.com/uploader/forums'>http://neembuu.com/uploader/forums</a></html>");

        descLabel.setText("<html><b>Neembuu Uploader</b> is reviewed as the simplest and fastest file uploader program..<br />You can request new features, report bugs or broken plugin at Neembuu Uploader site..<br /><br /><i> P.S. We are in need of developers and translators..</i></html>");

        siteLabel.setText("<html><a href='http://neembuu.com/uploader'>http://neembuu.com/uploader</a></html>");
        siteLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        siteLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                siteLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout aboutProductPanelLayout = new javax.swing.GroupLayout(aboutProductPanel);
        aboutProductPanel.setLayout(aboutProductPanelLayout);
        aboutProductPanelLayout.setHorizontalGroup(
            aboutProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutProductPanelLayout.createSequentialGroup()
                .addGroup(aboutProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(aboutLogo)
                    .addGroup(aboutProductPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(aboutProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(aboutProductPanelLayout.createSequentialGroup()
                                .addComponent(aboutLabel)
                                .addGap(18, 18, 18)
                                .addComponent(aboutVersionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(licenseLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(authorLabel)
                            .addComponent(siteLabel))))
                .addContainerGap())
        );
        aboutProductPanelLayout.setVerticalGroup(
            aboutProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutProductPanelLayout.createSequentialGroup()
                .addGroup(aboutProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aboutProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(aboutVersionLabel)
                        .addComponent(aboutLabel))
                    .addComponent(aboutLogo))
                .addGap(8, 8, 8)
                .addComponent(licenseLabel)
                .addGap(8, 8, 8)
                .addComponent(authorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(descLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(siteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        developersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Davide Pastore", "Plugins and many features"},
                {"Dinesh Sivaji", "Plugins for lots of sites"},
                {"Jeyanthan Inbasekaran", "Community Documentation"},
                {"MNidhal", "Plugins"},
                {"Paralytic", "Plugins"},
                {"Shashaank Tulsyan", "Code Reviewing, Translation Framework"},
                {"Vigneshwaran Raveendran", "Framework, User Interface"}
            },
            new String [] {
                "Developer", "Role"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        developersTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(developersTable);
        developersTable.getColumnModel().getColumn(0).setPreferredWidth(200);
        developersTable.getColumnModel().getColumn(0).setMaxWidth(250);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        aboutTabbedPane.addTab("<html><b>Development Team</b></html>", jPanel1);

        translatorsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Brazilian Portugese", "Maykon da Silva Siqueira"},
                {"Catalan", "Jordi Castells"},
                {"Chinese (Simplified)", "Raullen Qi Chai"},
                {"Chinese (Traditional)", "吳宇軒 (Nathan Wu)"},
                {"French", "Stéphane Rajalu"},
                {"German", "Florian Haag"},
                {"Greek", "Vasilis Lessis"},
                {"Hebrew", "Noam Y. Gherson, Itamar Shoham"},
                {"Hindi", "Shashaank Tulsyan, Vaishnavi Vasanth"},
                {"Hungarian", "Krisztian Mukli"},
                {"Italian", "Salvo Cortesiano"},
                {"Malay", "Natesan Vellaichamy"},
                {"Russian", "Ruslan Matsiev"},
                {"Sourashtra", "Balaji Chithu Sivanath"},
                {"Spanish", "Jordi Castells"},
                {"Tamil", "Vigneshwaran Raveendran"},
                {"Turkish", "Atif Zafrak"},
                {"Vietnamese", "Nguyen Kien"}
            },
            new String [] {
                "Language", "Translators"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(translatorsTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addContainerGap())
        );

        aboutTabbedPane.addTab("<html><b>Translation Team</b></html>", jPanel2);

        javax.swing.GroupLayout aboutPanelLayout = new javax.swing.GroupLayout(aboutPanel);
        aboutPanel.setLayout(aboutPanelLayout);
        aboutPanelLayout.setHorizontalGroup(
            aboutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(aboutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(aboutProductPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(aboutTabbedPane, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        aboutPanelLayout.setVerticalGroup(
            aboutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(aboutProductPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addComponent(aboutTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(aboutPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(aboutPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void siteLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_siteLabelMouseClicked

    if (!Desktop.isDesktopSupported()) {
        return;
    }
    try {
        NULogger.getLogger().log(Level.INFO, "{0}Opening Neembuu Site..", getClass().getName());
        Desktop.getDesktop().browse(new URI("http://neembuuuploader.sourceforge.net/"));
    } catch (Exception ex) {
    }
}//GEN-LAST:event_siteLabelMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
              
                new AboutNeembuuUploader().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aboutLabel;
    private javax.swing.JLabel aboutLogo;
    javax.swing.JPanel aboutPanel;
    private javax.swing.JPanel aboutProductPanel;
    private javax.swing.JTabbedPane aboutTabbedPane;
    private javax.swing.JLabel aboutVersionLabel;
    private javax.swing.JLabel authorLabel;
    private javax.swing.JLabel descLabel;
    private javax.swing.JTable developersTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel licenseLabel;
    private javax.swing.JLabel siteLabel;
    private javax.swing.JTable translatorsTable;
    // End of variables declaration//GEN-END:variables
    }
