package jsmSystem;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.beans.JavaBean;
import java.sql.*;

//import database.DataBase1;
//import project2.JavaBean;

public class ViewJewellery extends JFrame implements ActionListener,WindowListener{
    JTable table;
    String[] tableColumns = {"PRODUCT ID", "PRODUCT TYPE", "SUPPLIER ID", "DESCRIPTION", "HSN NO", "GROSS WT", "STONE WT", "NET WT", "STONE VALUE","VA","STOCK AVAILABILITY","PURITY"};
    Object[][] tableRowDate = new Object[][] {};

    ViewJewellery(String s){
        DefaultTableModel model = new DefaultTableModel(tableRowDate, tableColumns);
        table = new JTable(model);
        table.setRowHeight(table.getRowHeight()+20);
        table.getColumnModel().getColumn(0).setPreferredWidth(5);
        table.getColumnModel().getColumn(1).setPreferredWidth(5);
        table.getColumnModel().getColumn(2).setPreferredWidth(5);
        table.getColumnModel().getColumn(3).setPreferredWidth(10);
        table.getColumnModel().getColumn(4).setPreferredWidth(5);
        table.getColumnModel().getColumn(5).setPreferredWidth(5);
        table.getColumnModel().getColumn(6).setPreferredWidth(5);
        table.getColumnModel().getColumn(7).setPreferredWidth(5);
        table.getColumnModel().getColumn(8).setPreferredWidth(5);
        table.getColumnModel().getColumn(9).setPreferredWidth(3);
        table.getColumnModel().getColumn(10).setPreferredWidth(8);
        table.getColumnModel().getColumn(11).setPreferredWidth(5);


        Font f3 = new Font(Font.SANS_SERIF , Font.ROMAN_BASELINE | Font.BOLD , 12);


        table.setFont(f3);

        setData(model, table,s);
        add(new JScrollPane(table));
        table.setBackground(new Color(255, 255, 153));//255, 228, 225
        table.setForeground(new Color(51,51,51));
        setBounds(0,200,1500,450);
        setTitle("JEWELLERY LIST");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void setData(DefaultTableModel model, JTable table,String s){
        try {
            if(s=="GOLD")
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "jsmSystem", "pass");
                String query ="select * from goldjewel";
                PreparedStatement p = con.prepareStatement(query);
                ResultSet result = p.executeQuery();

                while(result.next()){
                    Object[] rowData = {
                            result.getString("ORNAMENT_ID"),
                            result.getString("ORNAMENT_TYPE"),
                            result.getString("SUP_ID"),
                            result.getString("DESCRIPTION"),
                            result.getString("HSN_NO"),
                            result.getString("GROSS_WT"),
                            result.getString("STONE_WEIGHT"),
                            result.getString("NET_WT"),
                            result.getString("STONE_VALUE"),
                            result.getString("VA"),
                            result.getString("STOCK_AVAILABILITY"),
                            result.getString("PURITY")
                    };
                    model.insertRow(table.getRowCount(), rowData);
                }
                con.close();
            }
            else if(s=="SILVER")
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "jsmSystem", "pass");
                String query ="select * from silverjewel";
                PreparedStatement p = con.prepareStatement(query);
                ResultSet result = p.executeQuery();

                while(result.next()){
                    Object[] rowData = {
                            result.getString("ORNAMENT_ID"),
                            result.getString("ORNAMENT_TYPE"),
                            result.getString("SUP_ID"),
                            result.getString("DESCRIPTION"),
                            result.getString("HSN_NO"),
                            result.getString("GROSS_WT"),
                            result.getString("STONE_WT"),
                            result.getString("NET_WT"),
                            result.getString("STONE_VALUE"),
                            result.getString("MC"),
                            result.getString("STOCK_AVAILABILITY")
                    };
                    model.insertRow(table.getRowCount(), rowData);
                }
                con.close();
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    JLabel lbl_ot;
    JComboBox jcb_ot;
    JButton jbtn_submit;
    Container co;
    JavaBean ob;

    public ViewJewellery() {
        co=getContentPane();
        co.setLayout(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lbl_ot=new JLabel("ORNAMENT TYPE");
        jcb_ot=new JComboBox();
        jbtn_submit=new JButton("submit");
        jbtn_submit.addActionListener(this);
        lbl_ot.setBounds(100, 50, 120, 25);
        jbtn_submit.setBounds(100, 100, 80, 25);
        jcb_ot.setBounds(230, 50, 120, 25);
        jbtn_submit.setBounds(240, 180, 110,30);


        co.add(lbl_ot);
        co.add(jcb_ot);
        co.add(jbtn_submit);
        try{
            jcb_ot.addItem("^^^*^");
            jcb_ot.addItem("GOLD");
            jcb_ot.addItem("SILVER");
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(this, " ---------- "+ ex.toString());
        }


        setSize(500,350);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        Object obj_source=ae.getSource();

        if(obj_source==jbtn_submit){

            try{
                String string_ot=jcb_ot.getSelectedItem().toString();
                new ViewJewellery(string_ot);
            }
            catch(Exception ex) {
                JOptionPane.showMessageDialog(this,"^^^^^^^^^^^^^^^^"+ ex.toString());
            }
        }
    }

    public static void main(String[] args) {
        new ViewJewellery();
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