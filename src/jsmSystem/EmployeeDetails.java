package jsmSystem;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class EmployeeDetails  {
    JFrame f;
    EmployeeDetails(){
        f=new JFrame("Employee Details");
        f.setSize(1920,950);
//        f.setLayout(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultTableModel tab = new DefaultTableModel();
        tab.addColumn("ID");
        tab.addColumn("Name");
        tab.addColumn("Father's Name");
        tab.addColumn("Address");
        tab.addColumn("City");
        tab.addColumn("Mobile_no");
        tab.addColumn("PAN");
        tab.addColumn("Salary Slab");
        tab.addColumn("Performance");
        tab.addColumn("Remarks");

        JTable jt = new JTable(tab);
        jt.setFont(new Font("Times New Roman",Font.PLAIN,18));
        jt.setBounds(87,222,1746,609);
        JScrollPane sp = new JScrollPane(jt);
        f.add(sp);
        f.setVisible(true);

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","jsmSystem","pass");
            Statement st = con.createStatement();
            String query = "select * from Employee";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String emp_id = rs.getString("ID");
                String ename = rs.getString("name");
                String fname = rs.getString("fname");
                String eadd = rs.getString("address");
                String ecity = rs.getString("city");
                String emobile = rs.getString("mobile");
                String epan=rs.getString("pan");
                String esalary = rs.getString("Salary");
                String eperformance = rs.getString("Performance");

                String[] arr ={emp_id,ename,fname,eadd,ecity,emobile,epan,esalary,eperformance};
                tab.addRow(arr);
            }
            con.close();
            System.out.println("success");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new EmployeeDetails();
    }
}