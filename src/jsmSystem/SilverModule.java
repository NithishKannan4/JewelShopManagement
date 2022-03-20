//package jsmSystem;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.sql.*;
////import java.math.BigInteger;
//
//
//public class SilverModule  extends JFrame implements ActionListener {
//
//    JLabel lbl_product_id,lbl_product_type,lbl_sup_id,lbl_desc,lbl_hsn,lbl_gross_wt,lbl_stone_wt,lbl_net_wt,lbl_stone_value,lbl_MC,lbl_total;
//    JTextField txt_product_id,txt_sup_id,txt_desc,txt_hsn,txt_gross_wt,txt_stone_wt,txt_net_wt,txt_stone_value,txt_MC,txt_total;
//
//    JComboBox jcb_product_type;
//    JButton jbtn_submit;
//    Container co;
//
//    public  SilverModule(){
//        JFrame RForm = new JFrame();
//        co=getContentPane();
//        co.setLayout(null);
//
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        lbl_product_id=new JLabel("PRODUCT ID");
//        lbl_product_type=new JLabel("PRODUCT TYPE");
//        lbl_sup_id=new JLabel("SUPPLIER ID");
//        lbl_desc=new JLabel("DESCRIPTION");
//        lbl_hsn=new JLabel("HSN NUMBER");
//        lbl_gross_wt=new JLabel("GROSS WEIGHT");
//        lbl_stone_wt=new JLabel("STONE WEIGHT");
//        lbl_net_wt=new JLabel("NET WEIGHT");
//        lbl_stone_value=new JLabel("STONE VALUE");
//        lbl_MC =new JLabel("MAKING CHARGES:");
//        lbl_total=new JLabel("STOCK AVAILABILITY");
//
//        txt_product_id=new JTextField();
//        txt_sup_id=new JTextField();
//        txt_desc=new JTextField();
//        txt_hsn=new JTextField();
//        txt_gross_wt=new JTextField();
//        txt_stone_wt=new JTextField();
//        txt_net_wt=new JTextField();
//        txt_stone_value=new JTextField();
//        txt_MC=new JTextField();
//        txt_total=new JTextField();
//
//
//        jcb_product_type=new JComboBox();
//
//
//        jcb_product_type.addItem("^^^^^*^");
//        jcb_product_type.addItem("Anklet");
//        jcb_product_type.addItem("Chain");
//        jcb_product_type.addItem("Bracelet");
//        jcb_product_type.addItem("Broocher");
//        jcb_product_type.addItem("Earing");
//        jcb_product_type.addItem("Necklace");
//        jcb_product_type.addItem("Ring");
//        jcb_product_type.addItem("Utensils");
//        jcb_product_type.addItem("Pooja items");
//        //jcb_product_type.addItem("Necklace");
//
//        jbtn_submit=new JButton("submit");
//
//
//        jbtn_submit.addActionListener(this);
//
//        lbl_product_id.setBounds(100, 50, 120, 25);
//        lbl_product_type.setBounds(100, 100, 120, 25);
//        lbl_sup_id.setBounds(100, 150, 120, 25);
//        lbl_desc.setBounds(100, 200, 120, 25);
//        lbl_hsn.setBounds(100, 250, 120, 25);
//        lbl_gross_wt.setBounds(100, 300, 120, 25);
//        lbl_stone_wt.setBounds(100, 350, 120, 25);
//        lbl_net_wt.setBounds(100, 400, 120, 25);
//        lbl_stone_value.setBounds(100, 450, 120, 25);
//        lbl_MC.setBounds(100, 500, 140, 25);
//        lbl_total.setBounds(100,550,140,25);
//
//        jbtn_submit.setBounds(100,620, 80, 25);
//
//
//        txt_product_id.setBounds(230, 50, 120, 25);
//        jcb_product_type.setBounds(230,100,120,25);
//        txt_sup_id.setBounds(230, 150, 120, 25);
//        txt_desc.setBounds(230, 200, 120, 25);
//        txt_hsn.setBounds(230, 250, 120, 25);
//        txt_gross_wt.setBounds(230, 300, 120, 25);
//        txt_stone_wt.setBounds(230, 350, 120, 25);
//        txt_net_wt.setBounds(230, 400, 120, 25);
//        txt_stone_value.setBounds(230, 450, 120, 25);
//        txt_MC.setBounds(230, 500, 120, 25);
//        txt_total.setBounds(230,550,120,25);
//
//        co.add(lbl_product_id);
//        co.add(lbl_product_type);
//        co.add(lbl_sup_id);
//        co.add(lbl_desc);
//        co.add(lbl_hsn);
//        co.add(lbl_gross_wt);
//        co.add(lbl_stone_wt);
//        co.add(lbl_net_wt);
//        co.add(lbl_stone_value);
//        co.add(lbl_MC);
//        co.add(lbl_total);
//
//        co.add(jbtn_submit);
//
//        co.add(txt_product_id);
//        co.add(jcb_product_type);
//        co.add(txt_sup_id);
//        co.add(txt_desc);
//        co.add(txt_hsn);
//        co.add(txt_gross_wt);
//        co.add(txt_stone_wt);
//        co.add(txt_net_wt);
//        co.add(txt_stone_value);
//        co.add(txt_MC);
//        co.add(txt_total);
//
//        setSize(600,750);
//        setVisible(true);
//    }
//
//    public void actionPerformed(ActionEvent ae){
//
//        Object obj_source=ae.getSource();
//
//        if(obj_source==jbtn_submit){
//
//            try{
//                String str_pid=txt_product_id.getText();
//                String str_pt=jcb_product_type.getSelectedItem().toString();
//                String str_sid=txt_sup_id.getText();
//                String str_desc=txt_desc.getText();
//                String str_hsn=txt_hsn.getText();
//                float gwt=Float.parseFloat(txt_gross_wt.getText());
//                float swt=Float.parseFloat(txt_stone_wt.getText());
//                float net_wt=Float.parseFloat(txt_net_wt.getText());
//                float st_value=Float.parseFloat(txt_stone_value.getText());
//                float MC=Float.parseFloat(txt_MC.getText());
//                int stock=Integer.parseInt(txt_total.getText());
//
//                Class.forName("oracle.jdbc.driver.OracleDriver");
//                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "jsmSystem", "pass");
//                Statement st = con.createStatement();
//                String query="insert into goldjewel values("+str_pid+",'"+str_pt+"','"+str_sid+"','"+str_desc+"','"+str_hsn+"','"+gwt+"','"+swt+"','"+net_wt+"','"+st_value+"','"+MC+"',"+stock+")";
//                st.executeQuery(query);
//                con.close();
//                JOptionPane.showMessageDialog(this, "UPDATION SUCCESS");
//            }
//            catch(Exception ex){
//                JOptionPane.showMessageDialog(this, ex.toString());
//            }
//        }
//    }
//
//    public static void main(String args[]){
//        new SilverModule();
//    }
//}