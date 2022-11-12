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

public class MainParel extends javax.swing.JFrame {

    private final Set<MyWaypoint> waypoints = new HashSet<>();
    private EventWaypoint event;

    public MainParel() {
        initComponents();
        init();
    }

    private void init() {
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        jXMapViewer.setTileFactory(tileFactory);
        GeoPosition geo = new GeoPosition(19.0015817,72.8407516);
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
                JOptionPane.showMessageDialog(MainParel.this, waypoint.getName());
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
        addWaypoint(new MyWaypoint("Bombay Hospital, Churchgate", event, new GeoPosition(18.941358725331405, 72.82742746927654)));
        addWaypoint(new MyWaypoint("JJ Hospital, Noor Baug, Dongri", event, new GeoPosition(18.96275525998468, 72.83375973973675)));
        addWaypoint(new MyWaypoint("Gokuldas Tejpal Hospital, Kalbadevi, CST", event, new GeoPosition(18.945767330762635, 72.83185890754591)));
        addWaypoint(new MyWaypoint("Balaji Hospital, Byculla", event, new GeoPosition(18.9790731151093, 72.83527299499342)));
        addWaypoint(new MyWaypoint("BYL Nair Hospital, Mumbai Central", event, new GeoPosition(18.97631349216868, 72.82222673088096)));
        addWaypoint(new MyWaypoint("HN Hospital, Girgaon", event, new GeoPosition(18.960323012521343, 72.81982347129383)));
        addWaypoint(new MyWaypoint("Saifee Hospital, Charni Road", event, new GeoPosition(18.954153686576785, 72.81810685762264)));
        addWaypoint(new MyWaypoint("Jaslok Hospital, Peddar Road", event, new GeoPosition(18.973066818394518, 72.80952378926672)));
        addWaypoint(new MyWaypoint("Bhatia Hospital, Grant Road", event, new GeoPosition(18.968034349027242, 72.8129570166091)));
        addWaypoint(new MyWaypoint("BD Petit Parsee Hospital, Cumballa Hill", event, new GeoPosition(18.97079410910847, 72.80531808577233)));
        addWaypoint(new MyWaypoint("Masina Hospital, Byculla", event, new GeoPosition(18.974815882863236, 72.8357909294437)));
        addWaypoint(new MyWaypoint("Prince Aly Khan Hospital, Mazgaon", event, new GeoPosition(18.97196,72.83682)));
        addWaypoint(new MyWaypoint("Wockhardt Hospital, Mumbai Central", event, new GeoPosition(18.976034689469227, 72.82360056909343)));
        addWaypoint(new MyWaypoint("Kasturbha Gandhi Hospital for infectious diseases, Mahalakshmi", event, new GeoPosition(18.98525523034118, 72.83007289036712)));
        addWaypoint(new MyWaypoint("Podar Hospital, Worli", event, new GeoPosition(19.002161368085375, 72.8161070116935)));
        addWaypoint(new MyWaypoint("KEM Hospital, Parel", event, new GeoPosition(19.00327307285814, 72.84147562185586)));
        addWaypoint(new MyWaypoint("Wadia Hospital, Parel", event, new GeoPosition(19.004659911420667, 72.84154598803732)));
        addWaypoint(new MyWaypoint("Tata Cancer Hospital, Parel", event, new GeoPosition(19.00515476329951, 72.8431930988268)));
        addWaypoint(new MyWaypoint("Global Hospital, Lalbaug", event, new GeoPosition(18.99987389618924, 72.84060747044106)));
        addWaypoint(new MyWaypoint("MbPT Hospital, Wadala", event, new GeoPosition(19.01295046822571, 72.86137428162277)));
        addWaypoint(new MyWaypoint("Hinduja Hospital, Mahim", event, new GeoPosition(19.033642124769468, 72.83906560988494)));
        addWaypoint(new MyWaypoint("SL Raheja Hospital, Mahim", event, new GeoPosition(19.04674356927179, 72.84269244372999)));
        addWaypoint(new MyWaypoint("Lilavati Hospital, Bandra", event, new GeoPosition(19.051386071516944, 72.82907993472688)));
        addWaypoint(new MyWaypoint("Sion Hospital, Sion", event, new GeoPosition(19.037427447577123, 72.86002724043693)));
        addWaypoint(new MyWaypoint("Lilavati Hospital, Bandra", event, new GeoPosition(19.052100500150157, 72.82900281646596)));
        addWaypoint(new MyWaypoint("Holy Family Multispeciality Hospital, Bandra", event, new GeoPosition(19.055126576764977, 72.82724003720882)));
        addWaypoint(new MyWaypoint("Bhabha Hospital, Bandra", event, new GeoPosition(19.057677484677335, 72.83366645485152)));
        addWaypoint(new MyWaypoint("Guru Nanak Hospital, Bandra", event, new GeoPosition(19.05992288837216, 72.85247852417089)));
        addWaypoint(new MyWaypoint("Ramakrishna Mission Hospital, Khar", event ,new GeoPosition(19.075296600685302, 72.83561195485186)));
        addWaypoint(new MyWaypoint("P.D. Hinduja Hospital & Medical Research Centre, Khar", event ,new GeoPosition(19.068218991797174, 72.83532678184118)));
        addWaypoint(new MyWaypoint("Mahavir Medical Research Centre, Khar", event ,new GeoPosition(19.07425786030391, 72.83279819718162)));
        addWaypoint(new MyWaypoint("Beams Multispecialty Hospital, Khar", event ,new GeoPosition(19.074085834712676, 72.82903461533942)));
        addWaypoint(new MyWaypoint("Dr. Subodh Mehta Medical Centre, Khar", event ,new GeoPosition(19.073219282616446, 72.83094411252202)));
        addWaypoint(new MyWaypoint("B.C.J. Hospital & Asha Parekh Research Centre, Santacruz", event ,new GeoPosition(19.083147885876585, 72.83764143951161)));
        addWaypoint(new MyWaypoint("Sarla Hospital & ICU, Santacruz", event ,new GeoPosition(19.085921068488727, 72.8368255125222)));
        addWaypoint(new MyWaypoint("R.K. Hospital, Santacruz", event ,new GeoPosition(19.08043993874163, 72.84209406650095)));
        addWaypoint(new MyWaypoint("V.N. Desai Hospital, Santacruz", event ,new GeoPosition(19.07903341642419, 72.84494686650099)));
        addWaypoint(new MyWaypoint("Benz Hospital, Santacruz", event ,new GeoPosition(19.07990915474352, 72.84063179718173)));
        addWaypoint(new MyWaypoint("Nanavati Max Super Speciality Hospital, Vile Parle", event ,new GeoPosition(19.09596645617851, 72.84020673951187)));
        addWaypoint(new MyWaypoint("Sujay Hospital And Research Centre, Juhu", event ,new GeoPosition(19.11688538098291, 72.83388541067697)));
        addWaypoint(new MyWaypoint("KLS Memorial Hospital, Vile Parle", event ,new GeoPosition(19.107869403852295, 72.84080566834706)));
        addWaypoint(new MyWaypoint("Advanced Multispecialty Hospital, Vile Parle", event ,new GeoPosition(19.108849541776266, 72.83717715300675)));
        addWaypoint(new MyWaypoint("Bharatiya Arogya Nidhi Hospital, Juhu", event ,new GeoPosition(19.111820786783138, 72.82824908368752)));
        addWaypoint(new MyWaypoint("Kokilaben Dhirubhai Ambani Hospital and Medical Research Institute, Andheri", event ,new GeoPosition(19.131517730261958, 72.82509578368779)));
        addWaypoint(new MyWaypoint("Kulkarni Hospital, Andheri", event ,new GeoPosition(19.14880760832605, 72.82816279718283)));
        addWaypoint(new MyWaypoint("BSES MG Hospital, Andheri", event ,new GeoPosition(19.11964272713947, 72.84497869718237)));
        addWaypoint(new MyWaypoint("CritiCare Asia Multispecialty Hospital, Andheri", event ,new GeoPosition(19.115869569011366, 72.83500971067708)));
        addWaypoint(new MyWaypoint("Bellevue Multispecialty Hospital, Andheri", event ,new GeoPosition(19.129384560835653, 72.8317990971826)));
        addWaypoint(new MyWaypoint("Sanghvi Hospital, Andheri", event ,new GeoPosition(19.14589150731046, 72.82298702601791)));
        addWaypoint(new MyWaypoint("Kokan Hospital, Jogeshwari", event ,new GeoPosition(19.13413107323159, 72.86524812601766)));
        addWaypoint(new MyWaypoint("Shalyak Hospital, Jogeshwari", event ,new GeoPosition(19.137579756497733, 72.85409028184235)));
        addWaypoint(new MyWaypoint("AllCure SuperSpeciality Hospital, Jogeshwari", event ,new GeoPosition(19.136205714788442, 72.85199968184224)));
        addWaypoint(new MyWaypoint("Jogeshwari Hospital, Jogeshwari", event ,new GeoPosition(19.136064914987266, 72.84455998184231)));
        addWaypoint(new MyWaypoint("HBT Trauma Care Centre, Jogeshwari", event ,new GeoPosition(19.141543104081794, 72.85407930622455)));
        addWaypoint(new MyWaypoint("Shree Sai Clinic, Goregaon", event ,new GeoPosition(19.1684806671303, 72.84470152417258)));
        addWaypoint(new MyWaypoint("SRV Hospital, Goregaon", event ,new GeoPosition(19.159173478577824, 72.84918573951276)));
        addWaypoint(new MyWaypoint("Kapadia Multispecialty Hospital, Goregaon", event ,new GeoPosition(19.163326645117262, 72.84338209533735)));
        addWaypoint(new MyWaypoint("Lifeline Medicare Hospitals, Goregaon", event ,new GeoPosition(19.174591160520283, 72.84463715485342)));
        addWaypoint(new MyWaypoint("Vishwa Kripa Hospital, Goregaon", event ,new GeoPosition(19.16682650796939, 72.8513016971831)));
        addWaypoint(new MyWaypoint("Vedant Hospital, Goregaon", event ,new GeoPosition(19.167533368295604, 72.87675396834807)));
        addWaypoint(new MyWaypoint("Matushree Gomati Hospital, Goregaon", event ,new GeoPosition(19.161704241038322, 72.83979723766711)));
        addWaypoint(new MyWaypoint("Suvidha Hospital & Polyclinic, Goregaon", event ,new GeoPosition(19.15684281199225, 72.84667693951283)));
        addWaypoint(new MyWaypoint("Namaha Hospital, Kandivali", event ,new GeoPosition(19.198219027063793, 72.84841325485381)));
        addWaypoint(new MyWaypoint("Oscar Hospital, Kandivali", event ,new GeoPosition(19.204101814192924, 72.82745591067844)));
        addWaypoint(new MyWaypoint("Sanchaiti Superspecialty Hospital, Kandivali", event ,new GeoPosition(19.20159562635673, 72.858710166503)));
        addWaypoint(new MyWaypoint("Lotus Multispeciality Hospital, Kandivali", event ,new GeoPosition(19.2047230721275, 72.83886772601879)));
        addWaypoint(new MyWaypoint("United Multispeciality Hospital, Kandivali", event ,new GeoPosition(19.216646445711987, 72.83908686834883)));
        addWaypoint(new MyWaypoint("Phoenix Hospitals PVT.LTD., Kandivali", event ,new GeoPosition(19.220394664501768, 72.83802467369617)));
        addWaypoint(new MyWaypoint("Vivanta Hospital, Malad", event ,new GeoPosition(19.178940620612536, 72.84280812601844)));
        addWaypoint(new MyWaypoint("Lifeline Multispeciality Hospital - Charitable, Cashless Hospital, Malad", event ,new GeoPosition(19.190277338313457, 72.84783896834841)));
        addWaypoint(new MyWaypoint("Thunga Hospital, Malad", event ,new GeoPosition(19.195533066173358, 72.84611969718361)));
        addWaypoint(new MyWaypoint("Surana Hospital and Research Centre, Malad", event ,new GeoPosition(19.198748990615027, 72.83845391252405)));
        addWaypoint(new MyWaypoint("Suchak Hospital, Malad", event ,new GeoPosition(19.189037974573324, 72.85013964135894)));
        addWaypoint(new MyWaypoint("S.K. Patil Mahanagarpalika General Hospital, Malad", event ,new GeoPosition(19.190274163471482, 72.85479595579098)));
        addWaypoint(new MyWaypoint("Sanjeevani Hospital, Malad", event ,new GeoPosition(19.18507542569513, 72.8526976709713)));
        addWaypoint(new MyWaypoint("Apex Hospital, Borivali", event ,new GeoPosition(19.231521729194892, 72.849647139514)));
        addWaypoint(new MyWaypoint("Karuna Hospital, Borivali", event ,new GeoPosition(19.24167159493768, 72.85296636834921)));
        addWaypoint(new MyWaypoint("Sai Lee Hospital & Diagnostic Centre, Borivali", event ,new GeoPosition(19.227790190497377, 72.84055393368938)));
        addWaypoint(new MyWaypoint("Mangal Murti Hospital, Borivali", event ,new GeoPosition(19.226579095550527, 72.82783422601918)));
        addWaypoint(new MyWaypoint("Shree Ganesha Hospital, Borivali", event ,new GeoPosition(19.22838379332375, 72.84588699718412)));
        addWaypoint(new MyWaypoint("K.J. Somaiya Hospital & Research Center, Sion", event ,new GeoPosition(19.047740905119447, 72.87465042786204)));
        addWaypoint(new MyWaypoint("Lion Tarachand Bapa Hospital, Sion", event ,new GeoPosition(19.038472494468994, 72.85921278368636)));
        addWaypoint(new MyWaypoint("Sion Polyclinic Hospital, Sion", event ,new GeoPosition(19.044341619376574, 72.86420119718117)));
        addWaypoint(new MyWaypoint("Atharva Hospital, Sion", event ,new GeoPosition(19.039976792262884, 72.86429658184069)));
        addWaypoint(new MyWaypoint("Sion Hospital, Sion", event ,new GeoPosition(19.037107706523148, 72.86001898476579)));
        addWaypoint(new MyWaypoint("New Sai Multispeciality Hospital & Research Centre, Sion", event ,new GeoPosition(19.040589428285834, 72.85476853426334)));
        addWaypoint(new MyWaypoint("Criti Care Asia Multispeciality Hospital, Kurla", event ,new GeoPosition(19.076284619958702, 72.88619233766588)));
        addWaypoint(new MyWaypoint("Habib Hospital, Kurla", event ,new GeoPosition(19.078524875994706, 72.88003221885263)));
        addWaypoint(new MyWaypoint("Noor Hospital, Kurla", event ,new GeoPosition(19.076485036959077, 72.8779337818413)));
        addWaypoint(new MyWaypoint("Aryan Hospital & Medical Centre, Kurla", event ,new GeoPosition(19.063194617720786, 72.88247701252183)));
        addWaypoint(new MyWaypoint("Rajawadi Hospital, Ghatkopar", event ,new GeoPosition(19.078875496307212, 72.90122903471224)));
        addWaypoint(new MyWaypoint("Parakh Hospital, Ghatkopar", event ,new GeoPosition(19.084555613526103, 72.90769466834674)));
        addWaypoint(new MyWaypoint("H. J. Doshi Ghatkopar Hindu Sabha Hospital, Ghatkopar", event ,new GeoPosition(19.085518829757973, 72.90608534308218)));
        addWaypoint(new MyWaypoint("Zynova Shalby Hospital, Ghatkopar", event ,new GeoPosition(19.088994375849925, 72.90650512601698)));
        addWaypoint(new MyWaypoint("Sarvodaya Hospital, Ghatkopar", event ,new GeoPosition(19.090697698242806, 72.90728833097903)));
        addWaypoint(new MyWaypoint("Godrej Memorial Hospital, Vikhroli", event ,new GeoPosition(19.104008122257625, 72.92732089718216)));
        addWaypoint(new MyWaypoint("Shushrusha Hospital, Vikhroli", event ,new GeoPosition(19.112495273358167, 72.93473999533659)));
        addWaypoint(new MyWaypoint("Aastha Hospital, Vikhroli", event ,new GeoPosition(19.116363280013427, 72.93147631252275)));
        addWaypoint(new MyWaypoint("Atul Lok Hospital, Vikhroli", event ,new GeoPosition(19.119266027601814, 72.93433605300689)));
        addWaypoint(new MyWaypoint("Ruby Hospital, Vikhroli", event ,new GeoPosition(19.11665065556676, 72.93183623442934)));
        addWaypoint(new MyWaypoint("Sai Samruddhi Hospital, Kanjurmarg", event ,new GeoPosition(19.130238050493375, 72.9346879106772)));
        addWaypoint(new MyWaypoint("Naval Hospital, Kanjurmarg", event ,new GeoPosition(19.132734755899417, 72.92550406834748)));
        addWaypoint(new MyWaypoint("Ankur Hospital, Kanjurmarg", event ,new GeoPosition(19.131132440425773, 72.93597126834749)));
        addWaypoint(new MyWaypoint("Badwaik hospital, Bhandup", event ,new GeoPosition(19.155997799866377, 72.94332728184241)));
        addWaypoint(new MyWaypoint("Saarthi Hospital, Bhandup", event ,new GeoPosition(19.14694149699155, 72.9348863876669)));
        addWaypoint(new MyWaypoint("Bhavsar Multispeciality & ICU Hospital, Bhandup", event ,new GeoPosition(19.15200411228184, 72.9360041971829)));
        addWaypoint(new MyWaypoint("Lotus Multi Speciality Hospital, Bhandup", event ,new GeoPosition(19.153411404952976, 72.94107736650213)));
        addWaypoint(new MyWaypoint("Dr. Meena’s Multispecialty Hospital, Bhandup", event ,new GeoPosition(19.147471192963557, 72.93212358184242)));
        addWaypoint(new MyWaypoint("Fortis Hospital, Mulund", event ,new GeoPosition(19.162011825705637, 72.94178132786381)));
        addWaypoint(new MyWaypoint("Hira Mongi Navneet Hospital, Mulund", event ,new GeoPosition(19.170815130390967, 72.94970491067788)));
        addWaypoint(new MyWaypoint("Apex Hospitals, Mulund", event ,new GeoPosition(19.181175184738414, 72.94252064135881)));
        addWaypoint(new MyWaypoint("Upasani Super Speciality Hospital, Mulund", event ,new GeoPosition(19.174863060999424, 72.94232788184271)));
        addWaypoint(new MyWaypoint("Manisha Universal Multispeciality Hospital, Mulund", event ,new GeoPosition(19.186678044732755, 72.94663047999734)));
        addWaypoint(new MyWaypoint("Aditi Hospital, Mulund", event ,new GeoPosition(19.172209897673643, 72.94870022786402)));
        addWaypoint(new MyWaypoint("Ashwini Hospital and ICCU, Mulund", event ,new GeoPosition(19.175595693404915, 72.95141512601842)));
        addWaypoint(new MyWaypoint("Platinum Hospital, Mulund", event ,new GeoPosition(19.182398016847735, 72.95412669718336)));
        addWaypoint(new MyWaypoint("Aayush Multispecialty Hospital, Thane", event ,new GeoPosition(19.19871595851258, 72.96574421252396)));
        addWaypoint(new MyWaypoint("Jupiter Hospital, Thane", event ,new GeoPosition(19.209912216106154, 72.972414554854)));
        addWaypoint(new MyWaypoint("Bethany Hospital, Thane", event ,new GeoPosition(19.220152026803948, 72.96177689718394)));
        addWaypoint(new MyWaypoint("Horizon Hospital, Thane", event ,new GeoPosition(19.187079875710534, 72.96756568184303)));
        addWaypoint(new MyWaypoint("Medicare Hospital, Thane", event ,new GeoPosition(19.200360956080527, 72.96303114135914)));
        addWaypoint(new MyWaypoint("Horizon Prime Hospital, Thane", event ,new GeoPosition(19.2482868978469, 72.97576929718443)));
        addWaypoint(new MyWaypoint("Thane Noble Hospital, Thane", event ,new GeoPosition(19.25996769619357, 72.96907509718466)));
        addWaypoint(new MyWaypoint("Lifeline Hospital, Thane", event ,new GeoPosition(19.20291581178281, 72.9720602665029)));
        addWaypoint(new MyWaypoint("Metropol Multispeciality Hospital, Thane", event ,new GeoPosition(19.236015374958523, 72.97563769902997)));
        addWaypoint(new MyWaypoint("Oscar Multispecialty Hospital, Thane", event ,new GeoPosition(19.236926123190955, 72.97423741067894)));

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
            java.util.logging.Logger.getLogger(MainParel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainParel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainParel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainParel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainParel().setVisible(true);
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
