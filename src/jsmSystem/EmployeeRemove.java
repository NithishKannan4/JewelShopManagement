package jsmSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeRemove {
    JFrame f;
    EmployeeRemove(String desgination) {
        f = new JFrame("Remove Employee");
        f.setSize(667,554);
        f.setLayout(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title,desc,prompt,name,fname,address,city,pin,mob,pan,salary,perf,confirm;
        JTextField idT,nameT,fnameT,cityT,pinT,mobT,panT,salaryT,perfT;
        JTextArea addressT;
        JButton submit;

        Font f1 = new Font("Times New Roman",Font.BOLD,20);
        Font f2 = new Font("Times New Roman",Font.PLAIN,20);

        title = new JLabel("Remove " + desgination +" Details");
        title.setFont(f1);
        title.setBounds(223,30,222,22);
        f.add(title);

        desc = new JLabel("Enter the ID of the" + desgination + " to be removed:");
        desc.setBounds(33,74,358,22);
        desc.setFont(f2);
        f.add(desc);

        prompt = new JLabel("Details of the " + desgination + "...");
        prompt.setBounds(33,116,205,22);
        prompt.setFont(f2);
        f.add(prompt);

        name = new JLabel("Name:");
        name.setBounds(33,150,58,22);
        name.setFont(f2);
        f.add(name);

        fname = new JLabel("Father's Name:");
        fname.setBounds(33,187,121,22);
        fname.setFont(f2);
        f.add(fname);

        address= new JLabel("Address:");
        address.setBounds(33,224,76,22);
        address.setFont(f2);
        f.add(address);

        city = new JLabel("City:");
        city.setBounds(33,279,45,22);
        city.setFont(f2);
        f.add(city);

        pin = new JLabel("Pin Code:");
        pin.setBounds(33,316,84,22);
        pin.setFont(f2);
        f.add(pin);

        mob = new JLabel("Mobile Number:");
        mob.setBounds(33,353,139,22);
        mob.setFont(f2);
        f.add(mob);

        pan = new JLabel("PAN:");
        pan.setBounds(33,390,49,22);
        pan.setFont(f2);
        f.add(pan);

        salary = new JLabel("Salary Slab");
        salary.setBounds(33,427,102,22);
        salary.setFont(f2);
        f.add(salary);

        perf = new JLabel("Performance:");
        perf.setFont(f2);
        perf.setBounds(33,464,108,22);
        f.add(perf);
        perf.setVisible(false);

        idT = new JTextField();
        idT.setBounds(401,74,114,22);
        idT.setFont(f2);
        f.add(idT);

        nameT = new JTextField();
        nameT.setBounds(157,150,177,22);
        nameT.setFont(f2);
        f.add(nameT);

        fnameT = new JTextField();
        fnameT.setBounds(157,187,177,22);
        fnameT.setFont(f2);
        f.add(fnameT);

        addressT = new JTextArea();
        addressT.setBounds(157,224,177,40);
        addressT.setFont(new Font("Times New Roman",Font.PLAIN,15));
        f.add(addressT);

        cityT = new JTextField();
        cityT.setBounds(157,279,177,22);
        cityT.setFont(f2);
        f.add(cityT);

        pinT = new JTextField();
        pinT.setBounds(157,316,177,22);
        pinT.setFont(f2);
        f.add(pinT);

        mobT = new JTextField();
        mobT.setBounds(172,353,162,22);
        mobT.setFont(f2);
        f.add(mobT);

        panT = new JTextField();
        panT.setBounds(157,390,177,22);
        panT.setFont(f2);
        f.add(panT);

        salaryT = new JTextField();
        salaryT.setFont(f2);
        salaryT.setBounds(157,427,177,22);
        f.add(salaryT);

        perfT = new JTextField();
        perfT.setBounds(157,464,177,22);
        perfT.setFont(f2);
        f.add(perfT);
        perfT.setVisible(false);

        confirm = new JLabel("<html>Are you sure to <br>remove the " + desgination +"?</html>");
        confirm.setFont(f2);
        confirm.setBounds(420,393,188,45);
        confirm.setHorizontalAlignment(JLabel.CENTER);
        confirm.setVerticalAlignment(JLabel.CENTER);
        f.add(confirm);

        submit = new JButton("Yes");
        submit.setFont(f2);
        submit.setBounds(459,456,110,52);
        f.add(submit);

        f.setVisible(true);
        idT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "jsmSystem", "pass");
                    Statement st = con.createStatement();
                    String query = "select * from " + desgination + " where id='" + idT.getText().toUpperCase() + "'";
                    ResultSet rs = st.executeQuery(query);

                    while (rs.next()) {
                        nameT.setText(rs.getString("name"));
                        fnameT.setText(rs.getString("fname"));
                        addressT.setText(rs.getString("address"));
                        cityT.setText(rs.getString("city"));
                        pinT.setText(rs.getString("pin"));
                        mobT.setText(rs.getString("mobile"));
                        panT.setText(rs.getString("pan"));
                        salaryT.setText(rs.getString("Salary"));
                        if(desgination.equals("Employee")) {
                            System.out.println("Yes");
                            perf.setVisible(true);
                            perfT.setVisible(true);
                            perfT.setText(rs.getString("Performance"));
                        }
                    }
                    con.close();
                }
                catch(Exception e1) {
                    System.out.println(e1);
                }
            }
        });

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "jsmSystem", "pass");
                    Statement st = con.createStatement();
                    String query = "delete from "+ desgination + " where id='" + idT.getText().toUpperCase() + "'";
                    st.executeQuery(query);
                    con.close();
                    JOptionPane.showMessageDialog(null,"Success!");
                }
                catch(Exception e1) {
                    System.out.println(e1);
                }
            }
        });
    }

    public static void main(String[] args) {
        new EmployeeRemove("Manager");
    }
}