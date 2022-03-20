package jsmSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login {
    JFrame f;
    Login(String pos) {
        String ownerID = "nithish";
        String ownerPass = "pass";
        f = new JFrame("Login");
        f.setBounds(200,200,550,330);
        f.setVisible(true);
        f.setLayout(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel title,userID,pass,error;
        JTextField userT;
        JPasswordField passT;
        Font titleF = new Font("Times New Roman",Font.PLAIN,25);

        title = new JLabel(pos +" Login");
        title.setBounds(30,30,279,45);
        title.setFont(new Font("Times New Roman",Font.BOLD,40));
        f.add(title);

        userID = new JLabel("User ID:");
        userID.setBounds(30,105,87,27);
        userID.setFont(titleF);
        f.add(userID);

        pass = new JLabel("Password:");
        pass.setBounds(30,152,103,27);
        pass.setFont(titleF);
        f.add(pass);

        JButton login = new JButton("Login");
        login.setBounds(211,238,128,51);
        login.setFont(new Font("Times New Roman",Font.BOLD,30));
        f.add(login);

        error = new JLabel("Incorrect Username/Password!");
        error.setBounds(30,197,316,27);
        error.setFont(titleF);
        error.setForeground(Color.RED);
        f.add(error);
        error.setVisible(false);

        userT = new JTextField();
        userT.setBounds(142,105,367,27);
        userT.setFont(titleF);
        f.add(userT);

        passT = new JPasswordField();
        passT.setBounds(142,152,367,27);
        f.add(passT);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pos.equals("Owner")) {
                    if (!(userT.getText().equals(ownerID)) || !(passT.getText().equals(ownerPass)))
                        error.setVisible(true);
                    else
                        error.setVisible(false);
                }
                else if (pos.equals("Manager") || pos.equals("Employee")) {
                    String uname = userT.getText().toUpperCase();
                    String pass = String.valueOf(passT.getPassword());

                    String[] details = login(uname,pass,pos);
                    if(details[2].equals("0"))
                        System.out.println("Invalid");
                    else {
//                        if(pos.equals("Manager"))
////                            call manager dashboard
//                            else
////                                call employee dashboard
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        new Login("Manager");
    }
    String[] login(String id,String pass,String pos) {
        String[] ans = new String[3];
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "jsmSystem", "pass");
            Statement st = con.createStatement();
            String query = "select * from "+ pos + " where (ID='" + id + "' and password='" + pass + "')";
            ResultSet c = st.executeQuery(query);
            while(c.next()) {
                ans[0] = c.getString("name");
                ans[1] = c.getString("id");
            }
            con.close();
            if(ans[0]==null || ans[1]==null)
                ans[2]="0";
            else
                ans[2]="1";
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null,"  Exception   -->"+e);
        }
        return ans;
    }
}