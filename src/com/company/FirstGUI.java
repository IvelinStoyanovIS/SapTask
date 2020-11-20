package com.company;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstGUI extends JFrame implements ActionListener {
    private JPanel rootPanel;
    JButton btnSelect;
    JButton btnSwapLines;
    JButton btnSwapWords;
    JButton btnPlay;
    JTextField textLine1;
    JTextField textLine2;
    JTextField textLine3;
    JTextField textLine4;
    JLabel lblLine1;
    JLabel lblLine2;
    JLabel lblLine3;
    JLabel lblLine4;
    JLabel txtBackground;
    Font ButtonFont = new Font("y", Font.ITALIC + Font.BOLD, 15);
    File obj = new File();
    String filepath;
    byte Swapctr = 0;
    byte SWAPctr = 0;
    private static final byte txtWIDTH = 35;
    private static final byte txtHEIGHT = 20;
    private static final byte btnHEIGHT = 25;

    FirstGUI() {
        txtBackground = new JLabel("", new ImageIcon("new_background.jpg"), JLabel.CENTER);
        txtBackground.setBounds(0, 0, 440, 300);

        //fourth pear
        lblLine4 = new JLabel();
        lblLine4.setText("Word number in this line:");
        lblLine4.setForeground(Color.WHITE);
        lblLine4.setBounds(10, 200, 150, txtHEIGHT);
        lblLine4.setVisible(false);
        textLine4 = new JFormattedTextField();
        textLine4.setBounds(160, 200, txtWIDTH, txtHEIGHT);
        textLine4.setVisible(false);
        //third pear
        lblLine2 = new JLabel();
        lblLine2.setText("Second line:");
        lblLine2.setForeground(Color.WHITE);
        lblLine2.setBounds(10, 165, 80, txtHEIGHT);
        textLine2 = new JFormattedTextField();
        lblLine2.setVisible(false);
        textLine2.setBounds(90, 165, txtWIDTH, txtHEIGHT);
        textLine2.setVisible(false);
        textLine2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                methodforListener();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                methodforListener();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                methodforListener();
            }
        });
        //second pear
        lblLine3 = new JLabel();
        lblLine3.setText("Word number in this line:");
        lblLine3.setForeground(Color.WHITE);
        lblLine3.setBounds(10, 70, 150, txtHEIGHT);
        lblLine3.setVisible(false);
        textLine3 = new JFormattedTextField();
        textLine3.setBounds(160, 70, txtWIDTH, txtHEIGHT);
        textLine3.setVisible(false);
        //first pear
        lblLine1 = new JLabel();
        lblLine1.setText("First line:");
        lblLine1.setForeground(Color.WHITE);
        lblLine1.setBounds(10, 35, 80, txtHEIGHT);
        lblLine1.setVisible(false);
        textLine1 = new JFormattedTextField();
        textLine1.setBounds(70, 35, txtWIDTH, txtHEIGHT);
        textLine1.setVisible(false);


        Icon next = new ImageIcon("play.png");
        btnPlay = new JButton();
        btnPlay.setIcon(next);
        btnPlay.setHorizontalTextPosition(JButton.RIGHT);
        btnPlay.setText("Swap now!");
        btnPlay.setBounds(67, 225, 290, btnHEIGHT+10);
        btnCSS(btnPlay);

        btnSelect = new JButton("Select File");
        btnSelect.setBounds(147, 2, 146, btnHEIGHT);
        btnCSS(btnSelect);
        btnSelect.setVisible(true);

        btnSwapLines = new JButton("Swap Lines");
        btnSwapLines.setBounds(0, 2, 147, btnHEIGHT);
        btnCSS(btnSwapLines);


        btnSwapWords = new JButton("Swap Words");
        btnSwapWords.setBounds(293, 2, 146, btnHEIGHT);
        btnCSS(btnSwapWords);

        txtBackground.add(btnPlay);
        txtBackground.add(lblLine4);
        txtBackground.add(textLine4);
        txtBackground.add(lblLine3);
        txtBackground.add(textLine3);
        txtBackground.add(lblLine2);
        txtBackground.add(textLine2);
        txtBackground.add(lblLine1);
        txtBackground.add(textLine1);
        txtBackground.add(btnSwapWords);
        txtBackground.add(btnSelect);
        txtBackground.add(btnSwapLines);
        this.add(txtBackground);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(rootPanel);
        this.setTitle("SAP");
        this.setSize(440, 300);
        this.setVisible(true);
        this.setLocation(550, 300);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSwapLines) {
            ++Swapctr;
            if (Swapctr % 2 == 1 && SWAPctr % 2 == 0) {
                btnSwapLines.setBackground(Color.GRAY);
                btnSwapLines.setForeground(Color.WHITE);
                lblLine1.setVisible(true);
                lblLine2.setVisible(true);
                textLine1.setVisible(true);
                textLine2.setVisible(true);
            } else if (Swapctr % 2 == 1 && SWAPctr % 2 == 1) {
                btnSwapLines.setBackground(Color.GRAY);
                btnSwapLines.setForeground(Color.WHITE);
                btnSwapWords.setBackground(Color.WHITE);
                btnSwapWords.setForeground(Color.BLACK);
                ++SWAPctr;
                lblLine3.setVisible(false);
                lblLine4.setVisible(false);
                textLine3.setVisible(false);
                textLine4.setVisible(false);

            } else {
                btnSwapLines.setBackground(Color.WHITE);
                btnSwapLines.setForeground(Color.BLACK);
                lblLine1.setVisible(false);
                lblLine2.setVisible(false);
                textLine1.setVisible(false);
                textLine2.setVisible(false);
            }
        }
        if (e.getSource() == btnSwapWords) {
            ++SWAPctr;
            if (SWAPctr % 2 == 1 && Swapctr % 2 == 0) {
                btnSwapWords.setBackground(Color.GRAY);
                btnSwapWords.setForeground(Color.WHITE);
                lblLine1.setVisible(true);
                lblLine2.setVisible(true);
                textLine1.setVisible(true);
                textLine2.setVisible(true);
                lblLine3.setVisible(true);
                lblLine4.setVisible(true);
                textLine3.setVisible(true);
                textLine4.setVisible(true);
            } else if (SWAPctr % 2 == 1 && Swapctr % 2 == 1) {
                btnSwapWords.setBackground(Color.GRAY);
                btnSwapWords.setForeground(Color.WHITE);
                btnSwapLines.setBackground(Color.WHITE);
                btnSwapLines.setForeground(Color.BLACK);
                ++Swapctr;
                lblLine3.setVisible(true);
                lblLine4.setVisible(true);
                textLine3.setVisible(true);
                textLine4.setVisible(true);
            } else {
                btnSwapWords.setBackground(Color.WHITE);
                btnSwapWords.setForeground(Color.BLACK);
                lblLine1.setVisible(false);
                lblLine2.setVisible(false);
                textLine1.setVisible(false);
                textLine2.setVisible(false);
                lblLine3.setVisible(false);
                lblLine4.setVisible(false);
                textLine3.setVisible(false);
                textLine4.setVisible(false);
            }
        }
        if (e.getSource() == btnSelect) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new java.io.File("."));   //open my folder
            int response = fileChooser.showOpenDialog(null);    //select file to open
            if (response == JFileChooser.APPROVE_OPTION) {
                filepath = fileChooser.getSelectedFile().getAbsolutePath();
                if (filepath.contains("txt")) {
                    obj.readFileData(filepath);                           //read text
                    btnSelect.setEnabled(false);
                    btnSwapLines.setVisible(true);
                    btnSwapWords.setVisible(true);
                    btnSelect.setText("File Selected");
                } else {
                    JOptionPane.showMessageDialog(null, "Please select txt file!!!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please select file!");
            }
        }
        if (e.getSource() == btnPlay) {
            if (textLine1.getText().equals("0") || textLine2.getText().equals("0") || textLine3.getText().equals("0") || textLine4.getText().equals("0")) {
                JOptionPane.showMessageDialog(null, "Text Fields can't be Zero");
            } else {
                if (Swapctr % 2 == 1) {                                               //case swapping Lines
                    if (textLine1.getText().matches("^[0-9]+$")
                            && textLine2.getText().matches("^[0-9]+$")) {        //chek 2 TextFields
                        if (Integer.parseInt(textLine1.getText()) <= obj.getLine().size()
                                && Integer.parseInt(textLine2.getText()) <= obj.getLine().size()) {
                            obj.swapLines(Byte.parseByte(textLine1.getText()), Byte.parseByte(textLine2.getText()), filepath);  //passing 2 TextFields and path to method
                            msgforEnd();
                        } else {
                            JOptionPane.showMessageDialog(null, "Incorrect input! Selected file don't have so many lines or words.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Text Fields must contain numbers!");
                    }
                }
                if (SWAPctr % 2 == 1) {                                               // case swapping Words
                    if (textLine1.getText().matches("^[0-9]+$")
                            && textLine2.getText().matches("^[0-9]+$")
                            && textLine3.getText().matches("^[0-9]+$")
                            && textLine4.getText().matches("^[0-9]+$")) {        //if all TextFields
                        if (Integer.parseInt(textLine1.getText()) <= obj.getLine().size()
                                && Integer.parseInt(textLine2.getText()) <= obj.getLine().size()
                                && Integer.parseInt(textLine3.getText()) <= obj.getLine().get(Integer.parseInt(textLine1.getText()) - 1).length
                                && Integer.parseInt(textLine4.getText()) <= obj.getLine().get(Integer.parseInt(textLine2.getText()) - 1).length) { // gives error
                            obj.swapWords(Byte.parseByte(textLine1.getText()), Byte.parseByte(textLine2.getText()),
                                    Byte.parseByte(textLine3.getText()), Byte.parseByte(textLine4.getText()), filepath);    // passing 4 TextFields amd path to method
                            msgforEnd();
                        } else {
                            JOptionPane.showMessageDialog(null, "Incorrect input! Selected file don't have so many lines or words.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Text Fields must contain numbers!");
                    }
                }
            }
        }
    }

    void methodforListener() {
        btnPlay.setVisible(true);
    }

    void msgforEnd() {
        int confirmed = JOptionPane.showConfirmDialog(null,
                "Close?", "Swapping completed!",
                JOptionPane.YES_NO_OPTION);

        if (confirmed == JOptionPane.YES_OPTION) {
            dispose();
        }
        if (confirmed == JOptionPane.NO_OPTION) {
            btnSelect.setText("Select file");
            btnSelect.setEnabled(true);
            btnSwapWords.setVisible(false);
            btnSwapLines.setVisible(false);
            btnPlay.setVisible(false);
            textLine1.setVisible(false);
            textLine2.setVisible(false);
            textLine3.setVisible(false);
            textLine4.setVisible(false);
            lblLine1.setVisible(false);
            lblLine2.setVisible(false);
            lblLine3.setVisible(false);
            lblLine4.setVisible(false);
            btnSwapLines.setBackground(Color.WHITE);
            btnSwapLines.setForeground(Color.BLACK);
            btnSwapWords.setBackground(Color.WHITE);
            btnSwapWords.setForeground(Color.BLACK);
            textLine1.setText("");
            textLine2.setText("");
            textLine3.setText("");
            textLine4.setText("");
            Swapctr = 0;
            SWAPctr = 0;
        }
    }

    void btnCSS(JButton btn){
        btn.setForeground(Color.black);
        btn.setBackground(Color.WHITE);
        btn.setFont(ButtonFont);
        btn.setVisible(false);
        btn.setFocusable(false);
        btn.addActionListener(this);
    }
}
