package jsmSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

//import database.DataBase1;

public class Main  extends JFrame implements ActionListener {

    static int manager_count=0,employee_count=0,cust_count=0;
    JLabel lbl_title;
    JButton jbtn_owner,jbtn_manager,jbtn_employee;


    public  Main(){

        setTitle("**** JEWELRY");
        //setLocationRelativeTo(null);

        setLayout(new BorderLayout());
        JLabel co=new JLabel(new ImageIcon("D:\\Nithish Kannan\\Docs\\Edu\\College\\Bootcamp\\Bootathon 1\\images"));
        add(co);

        String s1="D:\\Nithish Kannan\\Docs\\Edu\\College\\Bootcamp\\Bootathon 1\\images";
        JLabel jewel=new JLabel(new ImageIcon(s1));
        co.add(jewel);

        jewel.setBounds(0,180,500, 600);
        //co.setLayout(new FlowLayout());
	    	/*co.setAlignmentX(LEFT_ALIGNMENT);
	    	co.setAlignmentY(CENTER_ALIGNMENT);

	    	co.setSize(1550,830);*/

        JFrame JForm = new JFrame();


        // co=getContentPane();
        // co.setLayout(null);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lbl_title=new JLabel("WELCOME TO XYZ JEWELRY");


        Font f1 = new Font("Comic Sans MS",Font.ROMAN_BASELINE|Font.BOLD,45);
        Font f3 = new Font("Times New Roman",Font.BOLD,25);



        lbl_title.setFont(f1);

        jbtn_owner=new JButton("OWNER");
        jbtn_manager=new JButton("MANAGER");
        jbtn_employee=new JButton("EMPLOYEE");

        //  jbtn_owner.setBackground(Color.DARK_GRAY);

        jbtn_owner.setFont(f3);
        jbtn_manager.setFont(f3);
        jbtn_employee.setFont(f3);

        jbtn_owner.addActionListener(this);
        jbtn_manager.addActionListener(this);
        jbtn_employee.addActionListener(this);


        lbl_title.setBounds(100,80,750,90);

	       /* jbtn_owner.setBounds(1157,382,372,117);
	        jbtn_manager.setBounds(1157,482,372,117);
	        jbtn_employee.setBounds(1157,582,372,117);*/

        jbtn_owner.setBounds(1200,400,200,50);
        jbtn_manager.setBounds(1200,500,200,50);
        jbtn_employee.setBounds(1200,600,200,50);

        co.add(lbl_title);


        co.add(jbtn_owner);
        co.add(jbtn_employee);
        co.add(jbtn_manager);


        // setSize(100,500);
        setSize(1550,825);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        Object obj_source=ae.getSource();

        if(obj_source==jbtn_owner)
        {
            Login ob=new Login("Owner");
        }
        if(obj_source==jbtn_manager)
        {
            Login ob=new Login("Manager");
        }
        if(obj_source==jbtn_employee)
        {
            Login ob=new Login("Employee");
        }
    }

    public static void main(String args[]){
        new Main();
    }
}