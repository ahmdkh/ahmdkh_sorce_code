/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca_server;

import java.io.*;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import javax.swing.JOptionPane;
//import java.lang.ArrayIndexOutOfBoundsException;

/**
 *
 * @author wesam
 */
public class Task extends Thread {

    private Socket Client = null;
    private PrintWriter OutServer;
    private BufferedReader InServer;
    //private  String SecretKey;
    private String Uni_Name;
    String username, file_name;
    String text_send;
    String owner_name;
    String public_key;
    String randomnumber;
    boolean se_enter = false;
    String password;
    Connection con;
    Statement sql;
    ResultSet rs;
    boolean EX = false;

    public Task(Socket Client) {
        try {
            try {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                // Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:odbc:dbsql");

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }


            this.Client = Client;
            OutServer = new PrintWriter(this.Client.getOutputStream());
            InServer = new BufferedReader(new InputStreamReader(this.Client.getInputStream()));
            

        } catch (Exception ex) {
            Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//end constructor Task

    public void run() {

        try {
            //SecretKey = InServer.readLine();
//            OutServer = new PrintWriter(this.Client.getOutputStream());
//            InServer = new BufferedReader(new InputStreamReader(this.Client.getInputStream()));
          
//            while ( (Uni_Name = InServer.readLine())!=null)  
//            {
            Uni_Name = InServer.readLine();
            if (Uni_Name.equalsIgnoreCase("login")) {
                MD5 m = new MD5();
                username = InServer.readLine();
                password = InServer.readLine();
                public_key = InServer.readLine();
                randomnumber = InServer.readLine();
                password = m.getMD5(password);
                sql = con.createStatement();
                //JOptionPane.showMessageDialog(null,username+".."+password);
                rs = sql.executeQuery("SELECT * FROM login where username = '" + username + "' and password='" + password + "'");

                //JOptionPane.showMessageDialog(null,"good_login");
                System.out.println("good_login");
                if (rs.next() == true) {

                    try {
                        rs = sql.executeQuery("SELECT * FROM rsa_keys where username = '" + username + "'");
                    } catch (SQLException ex) {
                        Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
                        EX = true;
                    }

                    if (EX == true || rs.next() != true) {
                        PreparedStatement pss = con.prepareStatement("INSERT INTO rsa_keys (username,public_key,randomnumber) VALUES (?,?,?)");
                        pss.setString(1, username);
                        pss.setString(2, public_key);
                        pss.setString(3, randomnumber);
                        pss.executeUpdate();
                        con.commit();
                        EX = false;
                    }
                    
                    //
                    System.out.println("cuushkjbls....login");
                    OutServer.println("Login");
                    OutServer.println("Succes Login");
                    OutServer.flush();
                    sql.close();
                    // rs.close(); 
                } else {
                    OutServer.println("Login");
                    OutServer.println("Faild Login");
                    OutServer.flush();
                    sql.close();
                    // rs.close();
                }
            } else {
                if (Uni_Name.equalsIgnoreCase("text_send")) {
                    System.out.println("good_SEND_FILE111");
                    text_send = InServer.readLine();
                    owner_name = InServer.readLine();
                    file_name = InServer.readLine();
                    String permation = InServer.readLine();
                    System.out.println(permation);
                    try {
                        // sql.executeQuery("INSERT INTO dbsql VALUES (?,?)");
                        String s1 = text_send;
                        String s2 = owner_name;
                        String s3 = file_name;
                        PreparedStatement pss = con.prepareStatement("INSERT INTO dbsql (filename,ownername,permations) VALUES (?,?,?)");
                        pss.setString(1, s3);
                        pss.setString(2, s2);
                        pss.setString(3, permation);
                        pss.executeUpdate();
                        con.commit();
                        FileOutputStream fos = new FileOutputStream("D:\\SERVERFILE\\" + file_name + ".txt");
                        byte[] text_sendbyt = text_send.getBytes();
                        System.out.println("good_SENDzzzzzzzzzzzzzzzzz");
                        fos.write(text_sendbyt);
                        fos.close();
                        //sql.close();
                        System.out.println("good_Send_File");
                        // JOptionPane.showMessageDialog(null,"good_Send_File");
                    } catch (SQLException ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    System.out.println("View 1111");
                    if (Uni_Name.equalsIgnoreCase("view")) {
                        System.out.println("view 22222");
                        String k = "";
                        username = InServer.readLine();
                        //password=InServer.readLine();

                        sql = con.createStatement();
                       // JOptionPane.showMessageDialog(null, username + ".." + password);
                        rs = sql.executeQuery("SELECT * FROM dbsql where  permations ='" + username + "'");
                        // JOptionPane.showMessageDialog(null,"good_login");
                        System.out.println("..............viwe");
                        while (rs.next()) {
                            k += rs.getString("filename") + "-";
                        }
                        System.out.println("view");

                        OutServer.println("view");
                        //OutServer.flush();
                        OutServer.println(k);
                        OutServer.flush();
                        sql.close();
                       // InServer.close();
                       // OutServer.close();
                        // rs.close();
                    } else {
                        if (Uni_Name.equalsIgnoreCase("download")) {
                            String filedownload = "";
                            filedownload = InServer.readLine();
                            sql = con.createStatement();
                          //  JOptionPane.showMessageDialog(null,  filedownload);
                            rs = sql.executeQuery("SELECT * FROM dbsql where filename = '" + filedownload + "'");
                            // JOptionPane.showMessageDialog(null,"good_login");
                            String k = "";
                            System.out.println("download");
                            while (rs.next()) {
                                k = rs.getString("ownername");
                                System.out.println("server**ownername=" + k);
                            }
                            //password=InServer.readLine();
                            FileReader fr = new FileReader("D:\\SERVERFILE\\" + filedownload + ".txt");
                            BufferedReader br = new BufferedReader(fr);
                            String line = null;
                            String message = new String();
                            final StringBuffer buffer = new StringBuffer(2048);
                            while ((line = br.readLine()) != null) {
                                //buffer.append(line);
                                message += line;
                            }
                            System.out.println(message);

                            System.out.println("T>>download");

                            OutServer.println("download");
                            OutServer.println(message);
                            OutServer.println(k);
                            OutServer.flush();
                            sql.close();
                            //rs.close();

                        } else if (Uni_Name.equalsIgnoreCase("update")) {
                            System.out.println("UPDATE");
                            String nametext_update = "";
                            String text_update = "";
                            nametext_update = InServer.readLine();
                            text_update = InServer.readLine();
                            FileOutputStream fos = new FileOutputStream("D:\\SERVERFILE\\" + nametext_update + ".txt");
                            fos.write(text_update.getBytes());
                            fos.close();
                            System.out.println("end___update");

                            System.out.println("T>>download");

                            OutServer.println("update");

                            OutServer.flush();

                        } else if (Uni_Name.equalsIgnoreCase("view users")) {

                            String k = "";
                            String pu = "";
                            String rand = "";
                            sql = con.createStatement();

                            rs = sql.executeQuery("SELECT * FROM rsa_keys");
                            // JOptionPane.showMessageDialog(null,"good_login");
                            System.out.println("..............viwe users");
                            while (rs.next()) {
                                k += rs.getString("username").trim() + "-";
                                pu += rs.getString("public_key").trim() + "-";
                                rand += rs.getString("randomnumber").trim() + "-";

                            }
                            //System.out.println("view");

                            OutServer.println("view users");
                            OutServer.println(k);
                            OutServer.println(pu);
                            OutServer.println(rand);
                            OutServer.flush();
                            sql.close();


                        } else if (Uni_Name.equalsIgnoreCase("GETKEYRC4")) {
                            String rc4key="";
                            String m = InServer.readLine();
                            sql = con.createStatement();

                            rs = sql.executeQuery("SELECT * FROM randomkeys where username='" + m + "'");
                            while (rs.next()) {
                                rc4key = rs.getString("randken").trim();
                            }
                            OutServer.println("GETKEYRC4");
                            OutServer.println(rc4key);                           
                            OutServer.flush();
                            sql.close();
                        } else {
                        }



                    }
                    {
                    }
                }
            }


            System.out.println("ZARA&ALI");
       // }

        } //end run
        catch (Exception ex) {
            Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
//             try {
//                 OutServer.close();
//                 InServer.close();
//                 Client.close();
//             } catch (IOException ex) {
//                 Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
//             }
        }
    }//end run
}//end class Task
