/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test2;

import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputListener;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.VirtualEarthTileFactoryInfo;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCenter;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.jxmapviewer.viewer.WaypointPainter;
import waypoint1.EventWaypoint;
import waypoint1.MyWaypoint;
import waypoint1.WaypointRender;

public class MainKhar extends javax.swing.JFrame {

    private final Set<MyWaypoint> waypoints = new HashSet<>();
    private EventWaypoint event;

    public MainKhar() {
        initComponents();
        init();
    }

    private void init() {
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        jXMapViewer.setTileFactory(tileFactory);
        GeoPosition geo = new GeoPosition(19.0685061,72.8386168);
        jXMapViewer.setAddressLocation(geo);
        jXMapViewer.setZoom(4);

        //  Create event mouse move
        MouseInputListener mm = new PanMouseInputListener(jXMapViewer);
        jXMapViewer.addMouseListener(mm);
        jXMapViewer.addMouseMotionListener(mm);
        jXMapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCenter(jXMapViewer));
        event = getEvent();
    }

    private void addWaypoint(MyWaypoint waypoint) {
        for (MyWaypoint d : waypoints) {
            jXMapViewer.remove(d.getButton());
        }
        waypoints.add(waypoint);
        initWaypoint();
    }

    private void initWaypoint() {
        WaypointPainter<MyWaypoint> wp = new WaypointRender();
        wp.setWaypoints(waypoints);
        jXMapViewer.setOverlayPainter(wp);
        for (MyWaypoint d : waypoints) {
            jXMapViewer.add(d.getButton());
        }
    }

    private void clearWaypoint() {
        for (MyWaypoint d : waypoints) {
            jXMapViewer.remove(d.getButton());
        }
        waypoints.clear();
        initWaypoint();
    }

    private EventWaypoint getEvent() {
        return new EventWaypoint() {
            @Override
            public void selected(MyWaypoint waypoint) {
                JOptionPane.showMessageDialog(MainKhar.this, waypoint.getName());
            }
        };
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXMapViewer = new org.jxmapviewer.JXMapViewer();
        ComboMapType = new javax.swing.JComboBox<>();
        cmdAdd = new javax.swing.JButton();
        cmdClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ComboMapType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Open Stree", "Virtual Earth", "Hybrid", "Satellite", " " }));
        ComboMapType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboMapTypeActionPerformed(evt);
            }
        });

        cmdAdd.setText("AddWaypoint");
        cmdAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAddActionPerformed(evt);
            }
        });

        cmdClear.setText("Clear Waypoint");
        cmdClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXMapViewerLayout = new javax.swing.GroupLayout(jXMapViewer);
        jXMapViewer.setLayout(jXMapViewerLayout);
        jXMapViewerLayout.setHorizontalGroup(
            jXMapViewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXMapViewerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdAdd)
                .addGap(28, 28, 28)
                .addComponent(cmdClear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 548, Short.MAX_VALUE)
                .addComponent(ComboMapType, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jXMapViewerLayout.setVerticalGroup(
            jXMapViewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXMapViewerLayout.createSequentialGroup()
                .addComponent(ComboMapType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jXMapViewerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXMapViewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdAdd)
                    .addComponent(cmdClear))
                .addContainerGap(464, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jXMapViewer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jXMapViewer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void ComboMapTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboMapTypeActionPerformed
        TileFactoryInfo info;
        int index = ComboMapType.getSelectedIndex();
        if (index == 0) {
            info = new OSMTileFactoryInfo();
        } else if (index == 1) {
            info = new VirtualEarthTileFactoryInfo(VirtualEarthTileFactoryInfo.MAP);
        } else if (index == 2) {
            info = new VirtualEarthTileFactoryInfo(VirtualEarthTileFactoryInfo.HYBRID);
        } else {
            info = new VirtualEarthTileFactoryInfo(VirtualEarthTileFactoryInfo.SATELLITE);
        }
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        jXMapViewer.setTileFactory(tileFactory);
    }//GEN-LAST:event_ComboMapTypeActionPerformed

    private void cmdAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAddActionPerformed
        //addWaypoint(new MyWaypoint("Bombay Hospital, Churchgate", event, new GeoPosition(18.941358725331405, 72.82742746927654)));
        //addWaypoint(new MyWaypoint("JJ Hospital, Noor Baug, Dongri", event, new GeoPosition(18.96275525998468, 72.83375973973675)));
        //addWaypoint(new MyWaypoint("Gokuldas Tejpal Hospital, Kalbadevi, CST", event, new GeoPosition(18.945767330762635, 72.83185890754591)));
        //addWaypoint(new MyWaypoint("Balaji Hospital, Byculla", event, new GeoPosition(18.9790731151093, 72.83527299499342)));
        //addWaypoint(new MyWaypoint("BYL Nair Hospital, Mumbai Central", event, new GeoPosition(18.97631349216868, 72.82222673088096)));
        //addWaypoint(new MyWaypoint("HN Hospital, Girgaon", event, new GeoPosition(18.960323012521343, 72.81982347129383)));
        //addWaypoint(new MyWaypoint("Saifee Hospital, Charni Road", event, new GeoPosition(18.954153686576785, 72.81810685762264)));
        //addWaypoint(new MyWaypoint("Jaslok Hospital, Peddar Road", event, new GeoPosition(18.973066818394518, 72.80952378926672)));
        //addWaypoint(new MyWaypoint("Bhatia Hospital, Grant Road", event, new GeoPosition(18.968034349027242, 72.8129570166091)));
        //addWaypoint(new MyWaypoint("BD Petit Parsee Hospital, Cumballa Hill", event, new GeoPosition(18.97079410910847, 72.80531808577233)));
        //addWaypoint(new MyWaypoint("Masina Hospital, Byculla", event, new GeoPosition(18.974815882863236, 72.8357909294437)));
        //addWaypoint(new MyWaypoint("Prince Aly Khan Hospital, Mazgaon", event, new GeoPosition(18.97196,72.83682)));
        //addWaypoint(new MyWaypoint("Wockhardt Hospital, Mumbai Central", event, new GeoPosition(18.976034689469227, 72.82360056909343)));
        //addWaypoint(new MyWaypoint("Kasturbha Gandhi Hospital for infectious diseases, Mahalakshmi", event, new GeoPosition(18.98525523034118, 72.83007289036712)));
        //addWaypoint(new MyWaypoint("Podar Hospital, Worli", event, new GeoPosition(19.002161368085375, 72.8161070116935)));
        //addWaypoint(new MyWaypoint("KEM Hospital, Parel", event, new GeoPosition(19.00327307285814, 72.84147562185586)));
        //addWaypoint(new MyWaypoint("Wadia Hospital, Parel", event, new GeoPosition(19.004659911420667, 72.84154598803732)));
        //addWaypoint(new MyWaypoint("Tata Cancer Hospital, Parel", event, new GeoPosition(19.00515476329951, 72.8431930988268)));
        //addWaypoint(new MyWaypoint("Global Hospital, Lalbaug", event, new GeoPosition(18.99987389618924, 72.84060747044106)));
        //addWaypoint(new MyWaypoint("MbPT Hospital, Wadala", event, new GeoPosition(19.01295046822571, 72.86137428162277)));
        //addWaypoint(new MyWaypoint("Hinduja Hospital, Mahim", event, new GeoPosition(19.033642124769468, 72.83906560988494)));
        //addWaypoint(new MyWaypoint("SL Raheja Hospital, Mahim", event, new GeoPosition(19.04674356927179, 72.84269244372999)));
        //addWaypoint(new MyWaypoint("Lilavati Hospital, Bandra", event, new GeoPosition(19.051386071516944, 72.82907993472688)));
        //addWaypoint(new MyWaypoint("Sion Hospital, Sion", event, new GeoPosition(19.037427447577123, 72.86002724043693)));
        //addWaypoint(new MyWaypoint("Lilavati Hospital, Bandra", event, new GeoPosition(19.052100500150157, 72.82900281646596)));
        //addWaypoint(new MyWaypoint("Holy Family Multispeciality Hospital, Bandra", event, new GeoPosition(19.055126576764977, 72.82724003720882)));
        //addWaypoint(new MyWaypoint("Bhabha Hospital, Bandra", event, new GeoPosition(19.057677484677335, 72.83366645485152)));
        //addWaypoint(new MyWaypoint("Guru Nanak Hospital, Bandra", event, new GeoPosition(19.05992288837216, 72.85247852417089)));
        addWaypoint(new MyWaypoint("Ramakrishna Mission Hospital, Khar", event ,new GeoPosition(19.075296600685302, 72.83561195485186)));
        addWaypoint(new MyWaypoint("P.D. Hinduja Hospital & Medical Research Centre, Khar", event ,new GeoPosition(19.068218991797174, 72.83532678184118)));
        addWaypoint(new MyWaypoint("Mahavir Medical Research Centre, Khar", event ,new GeoPosition(19.07425786030391, 72.83279819718162)));
        addWaypoint(new MyWaypoint("Beams Multispecialty Hospital, Khar", event ,new GeoPosition(19.074085834712676, 72.82903461533942)));
        addWaypoint(new MyWaypoint("Dr. Subodh Mehta Medical Centre, Khar", event ,new GeoPosition(19.073219282616446, 72.83094411252202)));

    }//GEN-LAST:event_cmdAddActionPerformed

    private void cmdClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdClearActionPerformed
        clearWaypoint();
    }//GEN-LAST:event_cmdClearActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainKhar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboMapType;
    private javax.swing.JButton cmdAdd;
    private javax.swing.JButton cmdClear;
    private org.jxmapviewer.JXMapViewer jXMapViewer;
    // End of variables declaration//GEN-END:variables
}
