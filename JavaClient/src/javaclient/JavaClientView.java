/*
 * JavaClientView.java
 *
 * Eric J. Bruno
 * eric@ericbruno.com
 * www.ericbruno.com
 * 
 */

package javaclient;

import org.jdesktop.application.Action;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class JavaClientView extends FrameView implements ServerResponses {

    public JavaClientView(SingleFrameApplication app) {
        super(app);
        initComponents();
        statusMessageLabel.setText("Not Connected");
    }

    // Add a line to the top of the listview
    Vector data = new Vector();
    public void addLine(String line) {
        data.add(0, line); // add new lines at top
        final String[] strs = new String[data.size()];
        data.toArray(strs);
        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = strs;
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
    }

    SocketClient client = null;

    // This method is called when the "Connect" button is pressed
    @Action public void onServerConnect() {
        // Attempt to connect to server
        client = new SocketClient(txtAddress.getText(), this);
        if ( client.isConnected() ) {
            String msg = "Connected to server " +  txtAddress.getText();
            statusMessageLabel.setText(msg);
            addLine(msg);

            btnConnect.setEnabled(false);
            txtAddress.setEnabled(false);
        }
        else {
            String msg = "Failed to connect to server " +  txtAddress.getText();
            statusMessageLabel.setText(msg);
            addLine(msg);
        }
    }

    // This method is called when the "Get Hostname" button is pressed
    @Action public void onRequestHostname() {
        client.requestHostname();
    }

    // This method is called when the "Get Memory" button is pressed
    @Action public void onRequestMemory() {
        client.requestMemory();
    }

    // This method is called when the "Get Random Number" button is pressed
    @Action public void onGetRandomNumber() {
        client.requestRandomNumber();
    }

    // Handle server responses
    public void onHostnameResponse(String msg) {
        addLine("Response: " + msg);
    }

    public void onMemoryResponse(String msg) {
        addLine("Response: " + msg);
    }

    public void onRandomNumberResponse(String msg) {
        addLine("Response: " + msg);
    }

    private JDialog aboutBox;
    @Action public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = JavaClientApp.getApplication().getMainFrame();
            aboutBox = new JavaClientAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        JavaClientApp.getApplication().show(aboutBox);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        btnConnect = new javax.swing.JButton();
        btnRequest1 = new javax.swing.JButton();
        btnRequest2 = new javax.swing.JButton();
        btnGetRandom = new javax.swing.JButton();
        txtAddress = new javax.swing.JTextField();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();

        mainPanel.setName("mainPanel"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(javaclient.JavaClientApp.class).getContext().getResourceMap(JavaClientView.class);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.setName("listResponse"); // NOI18N
        jScrollPane1.setViewportView(jList1);

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(javaclient.JavaClientApp.class).getContext().getActionMap(JavaClientView.class, this);
        btnConnect.setAction(actionMap.get("onServerConnect")); // NOI18N
        btnConnect.setText(resourceMap.getString("btnConnect.text")); // NOI18N
        btnConnect.setName("btnConnect"); // NOI18N

        btnRequest1.setAction(actionMap.get("onRequestHostname")); // NOI18N
        btnRequest1.setText(resourceMap.getString("btnRequest1.text")); // NOI18N
        btnRequest1.setName("btnRequest1"); // NOI18N

        btnRequest2.setAction(actionMap.get("onRequestMemory")); // NOI18N
        btnRequest2.setText(resourceMap.getString("btnRequest2.text")); // NOI18N
        btnRequest2.setName("btnRequest2"); // NOI18N

        btnGetRandom.setAction(actionMap.get("onGetRandomNumber")); // NOI18N
        btnGetRandom.setText(resourceMap.getString("btnRandomNumber.text")); // NOI18N
        btnGetRandom.setName("btnRandomNumber"); // NOI18N

        txtAddress.setText(resourceMap.getString("txtAddress.text")); // NOI18N
        txtAddress.setName("txtAddress"); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 346, Short.MAX_VALUE)
                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConnect))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(btnRequest1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRequest2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGetRandom)))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConnect)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRequest2)
                    .addComponent(btnRequest1)
                    .addComponent(btnGetRandom))
                .addContainerGap())
        );

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 657, Short.MAX_VALUE)
                .addComponent(statusAnimationLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusMessageLabel)
                    .addComponent(statusAnimationLabel))
                .addGap(3, 3, 3))
        );

        setComponent(mainPanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConnect;
    private javax.swing.JButton btnGetRandom;
    private javax.swing.JButton btnRequest1;
    private javax.swing.JButton btnRequest2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JTextField txtAddress;
    // End of variables declaration//GEN-END:variables

}
