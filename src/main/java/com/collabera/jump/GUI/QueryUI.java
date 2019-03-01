package com.collabera.jump.GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.table.TableModel;

public class QueryUI 
{
	public static JFrame buildUI()
	{
        JFrame queryFrame = new JFrame("<html><div style='background-image: linear-gradient(red, yellow);'></div><html>");
        queryFrame.setTitle("BEAR BITE PRESENTS");
        queryFrame.setSize(600, 550);
        queryFrame.setVisible(true);
        queryFrame.setLayout(new BoxLayout(queryFrame.getContentPane(), BoxLayout.Y_AXIS));
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        queryFrame.setLocation(dim.width/2-queryFrame.getSize().width/2, dim.height/2-queryFrame.getSize().height/2);
        
        JPanel titleBarPanel = new JPanel();
        
        titleBarPanel.setSize(10,10);
        JLabel titleBarBackground = new JLabel();
        ImageIcon titleBarImg = new ImageIcon("bearlogo.png");
        titleBarBackground.setIcon(titleBarImg);
        
        titleBarPanel.add(titleBarBackground);
        
        JPanel titleBar = new JPanel();
        Font font = new Font("menlo", Font.PLAIN, 15);
        JLabel titleLabel = new JLabel();
        titleLabel.setFont(font);
        titleBarPanel.add(titleLabel);
        
        queryFrame.add(titleBarPanel);
        JPanel textFieldPane = new JPanel();
        textFieldPane.setPreferredSize(new Dimension(600, 75));
        
        // TextField Definition
        JLabel lab = new JLabel("Enter Query:");
        Font resultFont = new Font("Menlo", Font.PLAIN, 14);
        lab.setFont(resultFont);
        
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(450, 30));
        textField.setEditable(true);
        textField.setVisible(true);
        textField.setText("");
        textFieldPane.add(lab);
        textFieldPane.add(textField);
        queryFrame.add(textFieldPane);
        JTable table = buildTable();
       
        QueryActionListener actionListener = new QueryActionListener(textField, table);
        JPanel input = buildPanel(actionListener);
        input.setSize(100, 100);
        
        queryFrame.add(input);
        
        JPanel display = new JPanel();
        display.setSize(400, 400);
        queryFrame.add(display);
        
        JLabel lab1 = new JLabel("Results:");
        lab1.setFont(resultFont);
        display.add(lab1);
        queryFrame.add(new JScrollPane(table));
        
        Container c = queryFrame.getContentPane();
      //  c.setBackground(Color.gray);
        
        queryFrame.validate();
        queryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return queryFrame;
    }

	private static JTable buildTable() 
	{
        TableModel dataModel = new ResultsTableModel(0, 0);
        JTable table = new JTable(dataModel);
        
        return table;
    }
	
    public static JPanel buildPanel(QueryActionListener qActionListener) 
    {
        // Panel with Buttons
        Font butFont = new Font("Menlo", Font.BOLD, 12);
        JPanel input = new JPanel();
        input.setLayout(new GridLayout(1, 3));
        input.setMaximumSize(new Dimension(700,700));
        Border rb = BorderFactory.createRaisedBevelBorder();
        
        // Button Definition
        JButton dbConnectBut = new JButton("DB Connect");
        dbConnectBut.setFont(butFont);
        dbConnectBut.setBorder(rb);
        dbConnectBut.setActionCommand("DB");
        dbConnectBut.addActionListener(qActionListener);
        input.add(dbConnectBut);
        
        JButton exeBut = new JButton("Execute");
        exeBut.setBorder(rb);
        exeBut.setFont(butFont);
        exeBut.setActionCommand("Execute");
        exeBut.addActionListener(qActionListener);
        input.add(exeBut);
        
        JButton clearBut = new JButton("Clear");
        clearBut.setFont(butFont);
        clearBut.setBorder(rb);
        clearBut.setActionCommand("Clear");
        clearBut.addActionListener(qActionListener);
        input.add(clearBut);
        
        return input;
    }
    
    public static JFrame dbConnectUI() 
    {
        JFrame dbFrame = new JFrame();
        dbFrame.setTitle("Connect");
        dbFrame.setSize(400, 275);
        dbFrame.setResizable(false);
        dbFrame.setVisible(true);
        dbFrame.setLayout(new BoxLayout(dbFrame.getContentPane(), BoxLayout.Y_AXIS));
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        dbFrame.setLocation(dim.width/2-dbFrame.getSize().width/2, dim.height/2-dbFrame.getSize().height/2);
        JPanel godPanel = new JPanel();
        godPanel.setLayout(new BoxLayout(godPanel, BoxLayout.Y_AXIS));
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        
        JTextField fieldOne = new JTextField();
        fieldOne.setEditable(true);
        fieldOne.setText("");
        JLabel labelOne = new JLabel("<html><div><span style = 'font-family:menlo;'>Host (localhost or ipaddress):</span></div><html>");
        textPanel.add(labelOne);
        textPanel.add(fieldOne);
  
        JTextField fieldTwo = new JTextField();
        fieldTwo.setEditable(true);
        fieldTwo.setPreferredSize(new Dimension(50, 20));
        fieldTwo.setText("");
        
        JLabel labelTwo = new JLabel("<html><div><span style = 'font-family:menlo;'>Port (3306/[DB Name]): </span></div><html>");
        textPanel.add(labelTwo);
        textPanel.add(fieldTwo);
        
        JTextField fieldThree = new JTextField();
        fieldThree.setEditable(true);
        fieldThree.setPreferredSize(new Dimension(50, 20));
        fieldThree.setText("");
        
        JLabel labelThree = new JLabel("<html><div><span style = 'font-family:menlo;'>User Name:</span></div><html>");
        textPanel.add(labelThree);
        textPanel.add(fieldThree);
       
        JTextField fieldFour = new JTextField();
        fieldFour.setEditable(true);
        fieldFour.setPreferredSize(new Dimension(50, 20));
        fieldFour.setText("");
        
        JLabel labelFour = new JLabel("<html><div><span style = 'font-family:menlo;'>Password:</span></div><html>");
        textPanel.add(labelFour);
        textPanel.add(fieldFour);
        godPanel.add(textPanel);
        
        // Define action for button press
        DBConnectActionListener actionListener = new DBConnectActionListener(fieldOne, fieldTwo, fieldThree, fieldFour);
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));
        ButtonGroup dbTypes = new ButtonGroup();
        
        JRadioButton sqlButton = new JRadioButton("SQL");
        JRadioButton pgButton = new JRadioButton("PostGress");
        sqlButton.setActionCommand("mysql");
        sqlButton.addActionListener(actionListener);
        pgButton.setActionCommand("pg");
        pgButton.addActionListener(actionListener);
        dbTypes.add(sqlButton);
        dbTypes.add(pgButton);
        radioPanel.add(sqlButton);
        radioPanel.add(pgButton);
        godPanel.add(radioPanel);
        
        JPanel connectPanel = new JPanel();
        JButton connectButton = new JButton("Connect");
        connectButton.setActionCommand("connect");
        connectButton.addActionListener(actionListener);
        connectPanel.add(connectButton);
        godPanel.add(connectPanel);
        
        dbFrame.add(godPanel);
        
        dbFrame.validate();
        return dbFrame;
    }
    
    public void defaultResults()
    {
    	
    }
}