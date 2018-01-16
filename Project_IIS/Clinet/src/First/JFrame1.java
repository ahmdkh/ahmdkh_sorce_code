/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package First;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.Port;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author wesam
 */
public class JFrame1 extends javax.swing.JFrame {

    /**
     * Creates new form JFrame1
     */
    File file;
    String file_name, file_path, filechoos;
    long fileSize;
    static byte[] res;
    byte[] resDecryption;
    String allFile;
    String username;
    String password;
    String text_send;
    String publicKey;
    String privateKey;
    String randomNumber;
    Connection con;
    Statement sql;
    ResultSet rs;
    static Socket client;
    PrintWriter out;
    BufferedReader in;
    OutputStream Outfile;
    InputStream Infile;
    //  RSA r;
    // String Public_Keys[] = new String[3];
    int BUFFER_SIZE = 10000;
    static int port = 5787;
    byte[] buffer = new byte[BUFFER_SIZE];
    String[] all_of_publickey;
    String[] arry_name_file;
    String[] all_of_rand;

    public void ListenThread() {
        Thread IncomingReader = new Thread(new IncomingReader());
        IncomingReader.start();
    }
    ////////////////////////

    public class IncomingReader implements Runnable {

        @Override
        public void run() {
            //  String[] data;
            String stream = "";//, done = "Done", connect = "Connect", disconnect = "Disconnect", chat = "Chat";

            try {
                while ((stream = in.readLine()) != null) {
                    String msgin = null;
                    if (stream.equalsIgnoreCase("Login")) {
                        System.out.println("222222222...");
                        if (in.readLine().equalsIgnoreCase("Succes Login")) {
                            System.out.println("Succes Login");

                            jLabel5.setText("Connected");
                            jButton1.setEnabled(true);
                            jButton3.setEnabled(true);
                            jButton4.setEnabled(true);
                            jButton5.setEnabled(true);
                            jButton6.setEnabled(true);
                            jButton7.setEnabled(true);
                            jButton8.setEnabled(true);
                            jButton9.setEnabled(true);
                            jButton10.setEnabled(true);
                        } else {
                            System.out.println("Faild Login");
                            jLabel5.setText("Failed Connected");
                        }
                    } else {

                        if (stream.equalsIgnoreCase("view")) {
                            System.out.println("clint view");
                            String names_of_files = in.readLine();
                            String[] arry_name_file = names_of_files.split("-");
                            for (int i = 0; i < arry_name_file.length; i++) {
                                jComboBox1.addItem(arry_name_file[i]);
                            }
                        } else {//start DOWNLOAD//
                            String ismyname = "";
                            if (stream.equalsIgnoreCase("download")) {
                                //JOptionPane.showMessageDialog(JFrame1.this, "zzzzzzzzz" + stream);
                                String messag_of_files = in.readLine();

                                jTextField5.setText(messag_of_files);
                                ismyname = in.readLine();
                                System.out.println("cleint.....=" + username);
                                if (!(ismyname.equalsIgnoreCase(username))) {
                                    //jTextField5.setEnabled(false);
                                    jButton9.setEnabled(false);
                                } else {
                                    // jTextField5.setEnabled(true);
                                    jButton9.setEnabled(true);
                                }
                            } else {
                                //start UPDATE//
                                if (stream.equalsIgnoreCase("update")) {
                                    JOptionPane.showMessageDialog(JFrame1.this, "Update succesful");
                                } else {//*//*//
                                    if (stream.equalsIgnoreCase("view users")) {
                                        String names_of_user = in.readLine();
                                        String pp = in.readLine();
                                        String nn = in.readLine();
                                        arry_name_file = names_of_user.split("-");
                                        all_of_publickey = pp.split("-");
                                        all_of_rand = nn.split("-");
                                        for (int i = 0; i < arry_name_file.length; i++) {
                                            jComboBox2.addItem(arry_name_file[i]);
                                        }


                                    } else {
                                        if (stream.equalsIgnoreCase("GETKEYRC4")) {
                                            String rc4key = in.readLine();
                                            jTextField1.setText(rc4key);
                                            
                                        } else {
                                        }

                                    }
                                }//*//*//
                            }
                        }
                    }
                }
            } catch (Exception ex) {
            }
            Thread IncomingReader = new Thread(new IncomingReader());
            IncomingReader.stop();
        }
    }
    ////////////////////////

    public JFrame1() {
        initComponents();
        try {

            try {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                con = DriverManager.getConnection("jdbc:odbc:ISS_DB");
            } catch (SQLException ex) {
                Logger.getLogger(JFrame1.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JFrame1.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane2 = new javax.swing.JEditorPane();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 159, 112));
        jLabel1.setText("File Sharing System");

        jScrollPane1.setViewportView(jEditorPane1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Text before Encryption");

        jTextField1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField1.setCaretColor(new java.awt.Color(51, 255, 0));
        jTextField1.setDisabledTextColor(new java.awt.Color(51, 255, 0));
        jTextField1.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Public Key");

        jScrollPane2.setViewportView(jEditorPane2);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Text after Encryption");

        jButton1.setText("RC4_Encryption");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("ConnectToServer");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setText("Disconnect");

        jButton3.setText("Upload To Server");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Browser");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("RC4_Descryption");
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel6.setText("username");

        jLabel7.setText("password");

        jButton6.setText("MY Inbox File");
        jButton6.setEnabled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTextField4.setEnabled(false);

        jLabel8.setText("Send To");

        jButton7.setText("download");
        jButton7.setEnabled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("save file");
        jButton8.setEnabled(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Update");
        jButton9.setEnabled(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("DEC_RC4");
        jButton10.setEnabled(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jPasswordField1.setEnabled(false);

        jButton11.setText("GEN_Pub_Priv_Key");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("veiw user");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select User" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton13.setText("Get RC4 Key");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("RSA_Encrption");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setText("RSA_Description");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setText("RSA_DES_Keys");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(51, 255, 0));
        jLabel9.setFont(new java.awt.Font("Traditional Arabic", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 255, 0));
        jLabel9.setText("RSA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addGap(79, 79, 79)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(79, 79, 79))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                            .addComponent(jPasswordField1)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(jLabel5))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(202, 202, 202))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jLabel3)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton12)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton14)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addComponent(jButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton9))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton10)
                                    .addComponent(jButton15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton13)
                            .addComponent(jButton16))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton11))
                        .addGap(3, 3, 3)
                        .addComponent(jLabel5)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        String s = jTextField1.getText();
        byte[] usrKeyB = s.getBytes();
        allFile = jEditorPane2.getText();
        byte[] plainTextByte = new byte[(int) fileSize];
        plainTextByte = allFile.getBytes();
        //JOptionPane.showMessageDialog(JFrame1.this, plainTextByte);
        RC4 r;
        try {
            r = new RC4(usrKeyB);

            res = r.encrypt(plainTextByte);
            FileOutputStream fos = new FileOutputStream("D:\\ISS_File\\E_k.txt");
            fos.write(res);
            fos.close();
            // textAreaCipher.append(res.toString());
            //createSocket();
            String sd = "";
            for (int i = 0; i < res.length; i++) {
                sd = Byte.toString(res[i]);
            }

            JOptionPane.showMessageDialog(JFrame1.this, sd);
            jEditorPane1.setText(sd);
            // textAreaCipher.append(res.toString());

        } catch (Exception ex) {
            Logger.getLogger(JFrame1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            FileReader fr = new FileReader("D:/ISS_File/E_k.txt");
            BufferedReader br = new BufferedReader(fr);
            jEditorPane1.read(br, null);
            br.close();
            jEditorPane1.requestFocus();


        } catch (Exception e) {
            Logger.getLogger(JFrame1.class.getName()).log(Level.SEVERE, null, e);
        }
        jTextField4.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        InputStreamReader streamreader = null;
        try {
            // TODO add your handling code here:
            username = jTextField2.getText().trim();
            password = jPasswordField1.getText().trim();
            client = new Socket("localhost", port);
            streamreader = new InputStreamReader(client.getInputStream());
            in = new BufferedReader(streamreader);
            out = new PrintWriter(client.getOutputStream());
            String E_publickey = publicKey;
            String N_randomNumber = randomNumber;
            //            client = new Socket("localhost", port);
            //            out = new PrintWriter(client.getOutputStream());
            ////
            //            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out.println("login");
            out.println(username);
            out.println(password);
            out.println(E_publickey);
            out.println(N_randomNumber);
            out.flush();
            ListenThread();
//           String msgin = null;
//           
//        try {
//            msgin = in.readLine();
//             if(msgin.equalsIgnoreCase("Login"))
//                {
//                    System.out.println("222222222 ...");
//           if(in.readLine().equalsIgnoreCase("Succes Login"))
//           {
//            System.out.println("Succes Login");
//             jLabel5.setText("Connected");
//           }
//           else
//           {
//              System.out.println("Faild Login"); 
//           jLabel5.setText("Failed Connected");
//           }
//                }
//        } catch (IOException ex) {
//            Logger.getLogger(JFrame1.class.getName()).log(Level.SEVERE, null, ex);
//        }

            //out.flush(); 
            //String z=in.readLine();
            //System.out.println(z);
//            System.out.println("222222222 ...");
//           System.out.println("ServerSay : " + in.readLine());
//            System.out.println("33333333333 ...");
            //   jLabel5.setText("Connected");
            //client.close();
//            in.close();
//          out.close();
        } catch (IOException ex) {
            Logger.getLogger(JFrame1.class.getName()).log(Level.SEVERE, null, ex);
        }
//finally {
//            try {
//                streamreader.close();
//            } catch (IOException ex) {
//                Logger.getLogger(JFrame1.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            // TODO add your handling code here:
            text_send = jEditorPane1.getText();
            String permation = jTextField4.getText();
//         password= jTextField3.getText();
            client = new Socket("127.0.0.1", port);
            out = new PrintWriter(client.getOutputStream(), true);
            System.out.println("00000000000 ...");
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out.println("text_send");
            //    out.println(username);// out.flush();
            out.println(text_send);// out.flush();
            file_name = file_name.replace("\\", "-");
            String[] s = file_name.split("-");
            out.println(username);
            out.println(s[s.length - 1]);
            out.println(permation);
            //out.flush(); 
            //System.out.println("222222222 ...");
            //System.out.println("ServerSay : " + in.readLine());
            //System.out.println("33333333333 ...");
            //jLabel5.setText("Connected"); 
            // client.close();
            // in.close();
            // out.close();
        } catch (UnknownHostException ex) {
            Logger.getLogger(JFrame1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JFrame1.class.getName()).log(Level.SEVERE, null, ex);
        }
        //        try {
//            // TODO add your handling code here:
//                
//                Infile = client.getInputStream();
//                Outfile = client.getOutputStream();
//                
//                InputStream FileInputs = new FileInputStream(Path);
//                BufferedInputStream inf = new BufferedInputStream(FileInputs);
//                BufferedOutputStream outf = new BufferedOutputStream(Outfile);
//                int i = 10;
//                int j = 1;
//                while ((i = inf.read(buffer, 0, i)) != -1) {
//                    outf.write(buffer, 0, i);
//                    outf.flush();
//                    System.out.println("  " + j + " - Sending Of " + i + " Bytes");
//                    j++;
//            } //end loop
//            System.out.println("Finish ...");
//            FileInputs.close(); inf.close(); outf.close(); Infile.close(); Outfile.close();
//        } catch (Exception ex) {
//            Logger.getLogger(JFrame1.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        // TODO add your handling code here:
        //textAreaFile.setEditable(false);
        //textAreaCipher.setEditable(false);
        //textAreaRSACipher.setEditable(false);
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        fc.setFileFilter(filter);
        int returnVal = fc.showOpenDialog(JFrame1.this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            file = fc.getSelectedFile();
            file_name = file.toString();
            file_path = file.getAbsolutePath();
            fileSize = file.length();
            JOptionPane.showMessageDialog(JFrame1.this, file_name);
            try {
                BufferedReader br = new BufferedReader(new FileReader(file_path));
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                allFile = sb.toString();
                br.close();
            } catch (Exception e) {
                Logger.getLogger(JFrame1.class.getName()).log(Level.SEVERE, null, e);
            }
            JOptionPane.showMessageDialog(JFrame1.this, allFile);
        }

        try {

            FileReader fr = new FileReader(file_path);
            BufferedReader br = new BufferedReader(fr);
            jEditorPane2.read(br, null);
            br.close();
            jEditorPane2.requestFocus();

        } catch (Exception e) {
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        String s = jTextField1.getText();
        byte[] usrKeyB = s.getBytes();
        allFile = jEditorPane2.getText();
        byte[] plainTextByte = new byte[(int) fileSize];
        plainTextByte = allFile.getBytes();
        //JOptionPane.showMessageDialog(JFrame1.this, plainTextByte);
        RC4 r;
        try {
            r = new RC4(usrKeyB);

            res = r.encrypt(plainTextByte);
            FileOutputStream fos = new FileOutputStream("D:\\ISS_File\\D_k.txt");
            fos.write(res);
            fos.close();
            // textAreaCipher.append(res.toString());
            //createSocket();
            String sd = "";
            for (int i = 0; i < res.length; i++) {
                sd = Byte.toString(res[i]);
            }

            JOptionPane.showMessageDialog(JFrame1.this, sd);
            jEditorPane1.setText(sd);
            // textAreaCipher.append(res.toString());

        } catch (Exception ex) {
            Logger.getLogger(JFrame1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            FileReader fr = new FileReader("D:/ISS_File/D_k.txt");
            BufferedReader br = new BufferedReader(fr);
            jEditorPane1.read(br, null);
            br.close();
            jEditorPane1.requestFocus();


        } catch (Exception e) {
            Logger.getLogger(JFrame1.class.getName()).log(Level.SEVERE, null, e);
        }


    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        //  try {
        try {
            if (client.isClosed()) {
                System.out.println("are closed Socket 11111111111");
            }
            // TODO add your handling code here:
            jComboBox1.removeAllItems();

            // TODO add your handling code here:

            client = new Socket("127.0.0.1", port);
            InputStreamReader streamreader = new InputStreamReader(client.getInputStream());
            in = new BufferedReader(streamreader);
            out = new PrintWriter(client.getOutputStream());
            // out = new PrintWriter(client.getOutputStream());

            // in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out.println("view");
            out.flush();
            out.println(username);
            out.flush();

            ListenThread();
            //recive();
            // out.println(password);// out.flush();
            //out.flush(); 
            //System.out.println("222222222 ...");
            //System.out.println("ServerSay : "+in.readLine());
            //*********************************
            if (client.isClosed()) {
                System.out.println("are closed Socket 2222222");
            }
           

            //                String sd = null;
            //            
            //                sd = in.readLine();
            //            
            //
            //                System.out.println("............" + sd);
            //                if (sd.equalsIgnoreCase("view")) {
            //                
            //                    String names_of_files = in.readLine();
            //                    String[] arry_name_file = names_of_files.split("-");
            //                    for (int i = 0; i < arry_name_file.length; i++) {
            //                        jComboBox1.addItem(arry_name_file[i]);
            //                    }
            //               
            //                
            //
            //               }
            //jLabel5.setText("Connected"); 
            // client.close();
                    // in.close();
                    // out.close();

            //System.out.println("33333333333 ...");
            //jLabel5.setText("Connected");
        } catch (IOException ex) {
            Logger.getLogger(JFrame1.class.getName()).log(Level.SEVERE, null, ex);
        }



    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:

            client = new Socket("127.0.0.1", port);
            out = new PrintWriter(client.getOutputStream(), true);
            System.out.println("00000000000...");
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out.println("download");
            filechoos = jComboBox1.getSelectedItem().toString();
            out.println(jComboBox1.getSelectedItem().toString());// out.flush();
            ListenThread();
//            String sd = in.readLine();
//            String ismyname = "";
//            System.out.println("............" + sd);
//            if (sd.equalsIgnoreCase("download")) {
//                String messag_of_files = in.readLine();
//                jTextField5.setText(messag_of_files);
//                ismyname = in.readLine();
//                System.out.println("cleint.....=" + username);
//            }
//            if (!(ismyname.equalsIgnoreCase(username))) {
//                //jTextField5.setEnabled(false);
//                jButton9.setEnabled(false);
//            } else {
//                // jTextField5.setEnabled(true);
//                jButton9.setEnabled(true);
//            }
            //System.out.println("33333333333 ...");
            //jLabel5.setText("Connected"); 
//client.close();
            // in.close();
            // out.close();
        } catch (UnknownHostException ex) {
            Logger.getLogger(JFrame1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JFrame1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        File file;

        // create and display dialog box to get file name
        JFileChooser dialog = new JFileChooser();

        // Make sure the user didn't cancel the file chooser
        if (dialog.showSaveDialog(jTextField5) == JFileChooser.APPROVE_OPTION) {

            // Get the file the user selected
            file = dialog.getSelectedFile();

            try {
                // Now write to the file
                PrintWriter output = new PrintWriter(new FileWriter(file));
                output.println(jTextField5.getText());
                output.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(jTextField5, "Can't save file " + e.getMessage());
            }
        }


    }//GEN-LAST:event_jButton8ActionPerformed
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        String s = jTextField1.getText().trim();
        byte[] usrKeyB = s.getBytes();
        allFile = jTextField5.getText().trim();
        byte[] plainTextByte = new byte[(int) fileSize];
        plainTextByte = allFile.getBytes();
        //JOptionPane.showMessageDialog(JFrame1.this, plainTextByte);
        RC4 r;
        try {
            r = new RC4(usrKeyB);

            res = r.encrypt(plainTextByte);
            String ff = new String(res);
            JOptionPane.showMessageDialog(JFrame1.this, ff);
            jTextField5.setText(ff);


        } catch (Exception ex) {
            Logger.getLogger(JFrame1.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:

            // client = new Socket("127.0.0.1", port);
            out = new PrintWriter(client.getOutputStream(), true);
            System.out.println("00000000000...");
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out.println("update");

            out.println(filechoos);// out.flush();
            out.println(jTextField5.getText().trim());// out.flush();

//            String sd = in.readLine();
//            String ismyname = "";
//            System.out.println("............" + sd);
//            if (sd.equalsIgnoreCase("update")) {
//                JOptionPane.showMessageDialog(JFrame1.this, "Update succesful");
//            }
            //client.close();
            // in.close();
            // out.close();
        } catch (UnknownHostException ex) {
            Logger.getLogger(JFrame1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JFrame1.class.getName()).log(Level.SEVERE, null, ex);
        }



    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        try {
            // TODO add your handling code here:
            if (jTextField2.getText() != "") {
                sql = con.createStatement();
                // JOptionPane.showMessageDialog(null,username+".."+password);
                rs = sql.executeQuery("SELECT * FROM ISS_DB where username = '" + jTextField2.getText() + "'");
                if (rs.next() == true) {
                    this.publicKey = rs.getString("public_key").trim();
                    this.privateKey = rs.getString("privet_key").trim();
                    this.randomNumber = rs.getString("random_Number").trim();
                    sql.close();
                    JOptionPane.showMessageDialog(null, "this user have keys");
                    jPasswordField1.setEnabled(true);
                } else {
                    RSA r = new RSA(8);
                    this.publicKey = r.publicKey;
                    this.privateKey = r.privateKey;
                    this.randomNumber = r.randomNumber;
                    PreparedStatement pss = con.prepareStatement("INSERT INTO ISS_DB (username,public_key,privet_key,random_Number) VALUES (?,?,?,?)");
                    pss.setString(1, jTextField2.getText());
                    pss.setString(2, publicKey);
                    pss.setString(3, privateKey);
                    pss.setString(4, randomNumber);

                    pss.executeUpdate();
                    con.commit();
                    jTextField2.setEditable(false);
                    jPasswordField1.setEnabled(true);
                    JOptionPane.showMessageDialog(null, "succefull generated keys");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Entre username");

            }

        } catch (SQLException ex) {
            Logger.getLogger(JFrame1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        InputStreamReader streamreader = null;
        try {

            // TODO add your handling code here:
            jComboBox2.removeAllItems();
            client = new Socket("localhost", port);
            streamreader = new InputStreamReader(client.getInputStream());
            in = new BufferedReader(streamreader);
            out = new PrintWriter(client.getOutputStream());
            out.println("view users");
            out.flush();


            ListenThread();
        } catch (IOException ex) {
            Logger.getLogger(JFrame1.class.getName()).log(Level.SEVERE, null, ex);
        }
//        finally {
//            try {
//                streamreader.close();
//            } catch (IOException ex) {
//                Logger.getLogger(JFrame1.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }


    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        try {
            // TODO add your handling code here:
            if (client.isClosed()) {
                System.out.println("are closed Socket 11111111111");
            }
            // TODO add your handling code here:
            // jComboBox1.removeAllItems();

            // TODO add your handling code here:

            client = new Socket("127.0.0.1", port);
            InputStreamReader streamreader = new InputStreamReader(client.getInputStream());
            in = new BufferedReader(streamreader);
            out = new PrintWriter(client.getOutputStream());
            // out = new PrintWriter(client.getOutputStream());

            // in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out.println("GETKEYRC4");

            out.println(username);
            out.flush();

            ListenThread();
        } catch (UnknownHostException ex) {
            Logger.getLogger(JFrame1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JFrame1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton13ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed

//        String[] all_of_publickey;
//    String[] arry_name_file;
//     String[] all_of_rand;
   jTextField4.setEnabled(false);
        String pub1 = "";
        String rand1 = "";
        String prv = "";
        String ssa = jComboBox2.getSelectedItem().toString();
        for (int i = 0; i < arry_name_file.length; i++) {
            String s = arry_name_file[i].trim();
            if (ssa.equalsIgnoreCase(s)) {
                pub1 = all_of_publickey[i].trim();
                rand1 = all_of_rand[i].trim();

                JOptionPane.showMessageDialog(null, "E=" + pub1 + "\n" + "N=" + rand1);
            }
        }
        //String zozo="hellw word";
        // String f=r.RSAencrypt(zozo, pub1, rand1);
        RSA r = new RSA();
        String sso = jEditorPane2.getText().trim();
        String ss = r.RSAencrypt(sso, pub1, rand1);
        jEditorPane1.setText(ss);
        jTextField4.setText(jComboBox2.getSelectedItem().toString());
        //String z=r.RSAdecrypt(ss,"16517", rand1);
        // JOptionPane.showMessageDialog(null, z);


    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        RSA r = new RSA();
        System.out.println("E=" + privateKey + "\n N=" + randomNumber);
        String sd = r.RSAdecrypt(jTextField5.getText().trim(), privateKey, randomNumber);
        jTextField5.setText(sd);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        RSA r = new RSA();
       // System.out.println("E=" + privateKey + "\n N=" + randomNumber);
        String sd = r.RSAdecrypt(jTextField1.getText().trim(), privateKey, randomNumber);
        jTextField1.setText(sd);
        
    }//GEN-LAST:event_jButton16ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame1().setVisible(true);
                ///



                ////

            }
        });



    }

    void swap(Character i, Character j) {
        char temp;
        temp = i;
        i = j;
        j = temp;
    }//end swap
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private static javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JEditorPane jEditorPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private static javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
