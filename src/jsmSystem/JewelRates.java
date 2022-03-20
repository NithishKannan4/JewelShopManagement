package jsmSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class JewelRates implements WindowListener{
    JFrame f;
    float t1,t2;
    JewelRates() {
        f = new JFrame("Rate Updation");
        f.setBounds(200,200,550,330);
        f.setResizable(false);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.addWindowListener(this);

        Font f1 = new Font("Times New Roman",Font.BOLD,30);
        Font f2 = new Font("Times New Roman",Font.PLAIN,25);

        JLabel desc = new JLabel("Enter the rate to be updated...");
        desc.setBounds(40,40,400,33);
        desc.setFont(f1);
        f.add(desc);

        JTextField rate = new JTextField();
        rate.setFont(f2);
        rate.setBounds(40,98,150,40);
        f.add(rate);

        JRadioButton gold,silver;

        gold = new JRadioButton("Gold",true);
        gold.setBounds(250,91,80,27);
        gold.setFont(f2);
        f.add(gold);

        silver = new JRadioButton("Silver");
        silver.setBounds(250,135,90,27);
        silver.setFont(f2);
        f.add(silver);

        ButtonGroup selection = new ButtonGroup();
        selection.add(gold);
        selection.add(silver);

        JButton submit = new JButton("Update");
        submit.setBounds(184,200,182,73);
        submit.setFont(f1);
        f.add(submit);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(gold.isSelected())
                        rateUpdate("gold",Float.parseFloat(rate.getText()));
                    else if(silver.isSelected())
                        rateUpdate("silver",Float.parseFloat(rate.getText()));

                }
                catch (Exception e1) {
                    rate.setText("");
                }
            }
        });

        f.setVisible(true);
    }

    public static void main(String[] args) {
        new JewelRates();
    }

    void rateUpdate(String type,float rate) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "jsmSystem", "pass");
            Statement st = con.createStatement();
            String query = "update Rates set " + type + "=" + rate;
            st.executeUpdate(query);
            String query2 = "select * from Rates";
            ResultSet rs = st.executeQuery(query2);

            while(rs.next()) {
                System.out.println(rs.getFloat("gold") + " " + rs.getFloat("silver"));
                t1 = rs.getFloat("gold");
                t2 = rs.getFloat("silver");
            }
            con.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {}

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}
}