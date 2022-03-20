package jsmSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class ManagerDetails {
    JFrame f;
    JButton add_m,remove_m;
    ManagerDetails() {
        f=new JFrame("Manager Details");
        f.setSize(1920,950);
//        f.setLayout(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultTableModel tab=new DefaultTableModel();
        tab.addColumn("ID");
        tab.addColumn("Name");
        tab.addColumn("Father's Name");
        tab.addColumn("Address");
        tab.addColumn("City");
        tab.addColumn("Mobile_no");
        tab.addColumn("PAN");
        tab.addColumn("Salary Slab");

        JTable jt = new JTable(tab);
        jt.setBounds(30, 40, 200, 200);
        JScrollPane sp = new JScrollPane(jt);

        add_m=new JButton("add employee");
        add_m.setBounds(300,300,100,40);
        f.add(add_m);

        remove_m=new JButton("remove employee");
        remove_m.setBounds(420,300,130,40);
        f.add(remove_m);

        add_m.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jt.setBackground(Color.yellow);
            }
        });

        remove_m.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jt.setBackground(Color.cyan);
            }
        });

        f.add(sp);
        f.setSize(500, 500);
        f.setVisible(true);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "CMRakshaya@15");
            Statement st = con.createStatement();
            String query = "select * from Manager";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String man_id = rs.getString("ID");
                String man_name = rs.getString("name");
                String man_add = rs.getString("address");
                String man_city = rs.getString("city");
                String man_pin = rs.getString("Pin");
                String man_mobile = rs.getString("mobile");
                String man_pan=rs.getString("pan");
                String man_pass = rs.getString("password");
                String man_salary = rs.getString("Salary");



                String arr[]={man_id,man_name,man_add,man_city,man_pin,man_mobile,man_pan,man_salary};
                tab.addRow(arr);

            }

            con.close();
            System.out.println("success");
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public static void main(String[] args) {
        new ManagerDetails();
    }
}