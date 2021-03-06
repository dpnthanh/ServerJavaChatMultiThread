/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverppluschat.test;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stephen
 */
public class OldMainServer extends javax.swing.JFrame {

    int mPort;
    String mStatus;
    mainServerThread mServerThread;
    Thread thread;
    ServerSocket serverSocket;
//    DataInputStream is;
//    DataOutputStream os;
    BufferedReader is;
//    ArrayList<BufferedWriter> lsos = new ArrayList<>();
    BufferedWriter os;
    HashMap<String, BufferedReader> reader = new HashMap<>();
    HashMap<String, BufferedWriter> writer = new HashMap<>();

    /**
     * Creates new form MainServer
     */
    public OldMainServer() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtStatus = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        edtPort = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtErrorPort = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaInfo = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaChat = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        jLabel1.setText("Server Status:");

        txtStatus.setText("Stop");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel2.setText("PPLUS CHAT");

        btnStart.setText("Start");
        btnStart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStartMouseClicked(evt);
            }
        });
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        btnStop.setText("Stop");
        btnStop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStopMouseClicked(evt);
            }
        });

        edtPort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtPortActionPerformed(evt);
            }
        });

        jLabel3.setText("Port:");

        txtErrorPort.setForeground(new java.awt.Color(253, 10, 10));
        txtErrorPort.setText("Please enter a number");

        txaInfo.setColumns(20);
        txaInfo.setRows(5);
        jScrollPane1.setViewportView(txaInfo);

        jLabel4.setText("Info");

        txaChat.setColumns(20);
        txaChat.setRows(5);
        jScrollPane2.setViewportView(txaChat);

        jLabel5.setText("Chat:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(txtStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(edtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtErrorPort)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jLabel2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtStatus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(edtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtErrorPort))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnStart)
                            .addComponent(btnStop))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnStartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStartMouseClicked
        // start thread server
        StartServer();

    }//GEN-LAST:event_btnStartMouseClicked

    private void btnStopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStopMouseClicked
        // Close Thread main server
        StopServer();

    }//GEN-LAST:event_btnStopMouseClicked

    private void edtPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtPortActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtPortActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        btnStop.setEnabled(false);
        txtErrorPort.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnStartActionPerformed

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
            java.util.logging.Logger.getLogger(OldMainServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OldMainServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OldMainServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OldMainServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OldMainServer().setVisible(true);

            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStop;
    private javax.swing.JTextField edtPort;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextArea txaChat;
    private javax.swing.JTextArea txaInfo;
    private javax.swing.JLabel txtErrorPort;
    private javax.swing.JLabel txtStatus;
    // End of variables declaration//GEN-END:variables

    private void StartServer() {
        boolean err = false;

        if (!edtPort.getText().toString().trim().equalsIgnoreCase("")) {
            try {
                mPort = Integer.parseInt(edtPort.getText().toString().trim());
                err = false;
                txtErrorPort.setVisible(false);
            } catch (NumberFormatException numE) {
                err = true;
                txtErrorPort.setVisible(true);
            }
            if (!err) {
                mServerThread = new mainServerThread();
                thread = new Thread(mServerThread);
                thread.start();
                StatusStart(0);
            }

        }

    }

    private void StopServer() {
        StatusStart(1);
        try {
            serverSocket.close();
        } catch (Exception e) {
            txaInfo.append("Stop server error\n");
            System.out.println(e + "");
        }
        thread.stop();
    }

    private class mainServerThread implements Runnable {

        @Override
        public void run() {
            int port = mPort;
            boolean startComplete = false;

            try {
                //start server in port

                serverSocket = new ServerSocket(port);
                //show status 
                txaInfo.setText("");
                txaInfo.append("Start server complete \n");
                startComplete = true;
                while (startComplete) {
                    // waiting client connect
                    Socket clientSocket = serverSocket.accept();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                    BufferedReader buffereaReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    ClientServiceThread clientServiceThread = new ClientServiceThread(clientSocket, bufferedWriter, buffereaReader);
                    clientServiceThread.start();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                txaInfo.append("Start server fail \n");
                txtStatus.setText("Start server fail");
                startComplete = false;
            }

        }

    }

    private class ClientServiceThread extends Thread {

        Socket clientSocket;
        boolean runing = true;
        BufferedWriter clientWriter;
        BufferedReader clientReader;

        public ClientServiceThread(Socket clientSocket, BufferedWriter ClientWriter, BufferedReader ClientReader) {
            this.clientSocket = clientSocket;
            this.clientWriter = ClientWriter;
            this.clientReader = ClientReader;
        }

        @Override
        public void run() {
            String userAddress;
            userAddress = clientSocket.getInetAddress().getHostAddress();
            txaInfo.append("Client connect: " + clientSocket.getInetAddress().getHostAddress() + "\n");

            try {
                is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                os = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                Boolean haveName = false;
                String inMess;
                String nameUser = "";
                while (true) { // nhận tin nhắn
                    if(!haveName){ // nếu chưa có name nhận name bằng luồng bufferreader
                        inMess = is.readLine();
                        haveName = true;
                    } else {// nếu đã có tên nhận từ luồng chứa trong hash map
                        inMess = reader.get(nameUser).readLine();
                    }

                    
                    // hiện info 
                    txaInfo.append("data in: " + inMess + "\n");
                    // phân tích tin nhắn 
                    String data[] = inMess.split("%");
                    //hiển thị nội dung chat lên khung chat 
                    txaInfo.append(data[0] + "--" + data[1] + "--" + data[2] + "\n");
                    if (data[2].equals("name")) {// nếu action trueyefn lên là name
                        //đăng kí luồng đọc ghi có key là tên userr
                        reader.put(data[0], clientReader);
                        writer.put(data[0], clientWriter);
                        //ghi user name
                        nameUser = data[0];
                        txaChat.append("Add user: " + data[0] + "\n");
                    }
                    if (data[2].equals("chat")) { // nếu action là chat
                        //nếu nội dung có dấu ":"
                        if (data[1].indexOf(":") != -1) { // send to one user 
                            // phân tích nội dung tin nhắn
                            String[] userMessage = data[1].split(":");
                            try {
                                
                                //mở luồng ghi dữ liệu cho user có tên trước dấu ":"
                                BufferedWriter sendToUser = (BufferedWriter) writer.get(userMessage[0]);
                                sendToUser.write(data[0] + ": " + userMessage[1]);
                                sendToUser.newLine();
                                sendToUser.flush();
                                //mở luồng ghi dữ liệu cho chính mình 
                                BufferedWriter senToMe = (BufferedWriter) writer.get(data[0]);
                                senToMe.write("-->" + data[1]);
                                senToMe.newLine();
                                senToMe.flush();
                                
                                txaChat.append(data[0] + "-->" + userMessage[0] + ": " + data[0] + ": " + userMessage[1]+"\n");
                            } catch (Exception e) {
                                txaChat.append("không tìm thấy user: " + userMessage[0] + "\n");
                                e.printStackTrace();
                            }

                        } 
                        //nếu trong cấu trúc tin nhắn không có dấu ":"
                        else { // send to all user
//                                Iterator it = writer.keySet().iterator();
//                                while (it.hasNext()) {
//                                    try {
//                                        BufferedWriter sendToUser = (BufferedWriter) it.next();
//                                        sendToUser.write(data[0] + ": " + data[1]);
//                                        sendToUser.newLine();
//                                        sendToUser.flush();
//                                    } catch (Exception e) {
//                                        txaInfo.append("error sent to all user \n");
//                                        e.printStackTrace();
//                                    }
//
//                                }

                                //duyệt mảng luồng writer và gửi cho all user
                                Collection co  = writer.values();
                                Iterator iit = co.iterator();
                                while(iit.hasNext()){
                                    try{
                                    //lấy luồng ra và ghi cho user
                                    BufferedWriter send = (BufferedWriter) iit.next();
                                    //khởi tạo tin nhắn 
                                    String mess = data[0] + ": " + data[1];
                                    send.write(mess);
                                    send.newLine();
                                    send.flush();
                                    txaChat.append(mess + "\n");
                                    }catch(Exception e) {
                                        e.printStackTrace();
                                        txaInfo.append("error sent to all user");
                                    }
                                }
                                
//                            BufferedWriter ww = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
//                            ww.write(data[0] + ": " + data[1]);
//                            ww.newLine();
//                            ww.flush();
                        }

                    }
 
                }
            } catch (IOException ex) {
                Logger.getLogger(OldMainServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void StatusStart(int Start) {
        if (Start == 0) {
            btnStart.setEnabled(false);
            btnStop.setEnabled(true);

            txtStatus.setText("Server running in port: " + mPort);
        } else if (Start == 1) {
            btnStart.setEnabled(true);
            btnStop.setEnabled(false);
            txaChat.setText("");
            txtStatus.setText("Server stop");
            txaInfo.append("Server Stop.\n");

        }

    }

}
