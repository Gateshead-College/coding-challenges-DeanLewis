package calculator;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;

public class OOCalc extends JFrame {

    private JPanel contentPane;
    private JTextField txtOutput;
    double memory;
    double val1;
    double val2;
    String operator;
    boolean decimal;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    OOCalc frame = new OOCalc();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }



    public OOCalc() {
        setForeground(Color.WHITE);
        setBackground(Color.DARK_GRAY);
        setUndecorated(false);
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 345, 419);
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        txtOutput = new JTextField();
        txtOutput.setForeground(Color.WHITE);
        txtOutput.setText("0");
        txtOutput.setFont(new Font("High Tower Text", Font.BOLD, 56));
        txtOutput.setHorizontalAlignment(SwingConstants.RIGHT);
        txtOutput.setBorder(null);
        txtOutput.setBackground(Color.DARK_GRAY);
        txtOutput.setBounds(0, 0, 345, 93);
        contentPane.add(txtOutput);
        txtOutput.setColumns(10);

        JButton btnMC = new JButton("MC");
        btnMC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                memory = 0.0;
            }
        });
        btnMC.setForeground(Color.WHITE);
        btnMC.setBackground(SystemColor.windowBorder);
        btnMC.setBounds(10, 104, 56, 46);
        contentPane.add(btnMC);

        JButton btnMr = new JButton("MR");
        btnMr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                txtOutput.setText("" + memory);
            }
        });
        btnMr.setForeground(Color.WHITE);
        btnMr.setBackground(SystemColor.windowBorder);
        btnMr.setBounds(76, 104, 56, 46);
        contentPane.add(btnMr);

        JButton btnMs = new JButton("MS");
        btnMs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                memory = Double.parseDouble(txtOutput.getText());
            }
        });
        btnMs.setForeground(Color.WHITE);
        btnMs.setBackground(SystemColor.windowBorder);
        btnMs.setBounds(144, 104, 56, 46);
        contentPane.add(btnMs);

        JButton btnMPlus = new JButton("M+");
        btnMPlus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                double value = Double.parseDouble(txtOutput.getText());
                memory = memory + value;
            }
        });
        btnMPlus.setForeground(Color.WHITE);
        btnMPlus.setBackground(SystemColor.windowBorder);
        btnMPlus.setBounds(210, 104, 56, 46);
        contentPane.add(btnMPlus);

        JButton btnMMinus = new JButton("M-");
        btnMMinus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                double value = Double.parseDouble(txtOutput.getText());
                memory = memory - value;
            }
        });
        btnMMinus.setForeground(Color.WHITE);
        btnMMinus.setBackground(SystemColor.windowBorder);
        btnMMinus.setBounds(276, 104, 56, 46);
        contentPane.add(btnMMinus);

        JButton btnBackspace = new JButton("<-");
        btnBackspace.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                String value = txtOutput.getText();
                if(value.length() > 0) {
                    value = value.substring(0, value.length()-1);
                    txtOutput.setText(value);
                }

            }
        });
        btnBackspace.setForeground(Color.WHITE);
        btnBackspace.setBackground(SystemColor.windowBorder);
        btnBackspace.setBounds(10, 154, 56, 46);
        contentPane.add(btnBackspace);

        JButton btnCe = new JButton("CE");
        btnCe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                memory = 0.0;
                val1 = 0.0;
                val2 = 0.0;
                txtOutput.setText("");
            }
        });
        btnCe.setForeground(Color.WHITE);
        btnCe.setBackground(SystemColor.windowBorder);
        btnCe.setBounds(76, 154, 56, 46);
        contentPane.add(btnCe);

        JButton btnC = new JButton("C");
        btnC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                txtOutput.setText("");
            }
        });
        btnC.setForeground(Color.WHITE);
        btnC.setBackground(SystemColor.windowBorder);
        btnC.setBounds(144, 154, 56, 46);
        contentPane.add(btnC);

        JButton btnPosNeg = new JButton("+/-");
        btnPosNeg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                Double value = Double.parseDouble(txtOutput.getText());
                value = value - (value * 2);
                txtOutput.setText(value.toString());
            }
        });
        btnPosNeg.setForeground(Color.WHITE);
        btnPosNeg.setBackground(SystemColor.windowBorder);
        btnPosNeg.setBounds(210, 154, 56, 46);
        contentPane.add(btnPosNeg);

        JButton btnSqrt = new JButton("Sqrt");
        btnSqrt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                Double value = Double.parseDouble(txtOutput.getText());
                Double sqrt = Math.sqrt(value);
                txtOutput.setText(sqrt.toString());

            }
        });
        btnSqrt.setForeground(Color.WHITE);
        btnSqrt.setBackground(SystemColor.windowBorder);
        btnSqrt.setBounds(276, 154, 56, 46);
        contentPane.add(btnSqrt);

        JButton btn7 = new JButton("7");
        btn7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Number(btn7.getText());
            }
        });
        btn7.setForeground(Color.WHITE);
        btn7.setBackground(SystemColor.controlText);
        btn7.setBounds(10, 204, 56, 46);
        contentPane.add(btn7);

        JButton btn8 = new JButton("8");
        btn8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Number(btn8.getText());
            }
        });
        btn8.setForeground(Color.WHITE);
        btn8.setBackground(SystemColor.controlText);
        btn8.setBounds(76, 204, 56, 46);
        contentPane.add(btn8);

        JButton btn9 = new JButton("9");
        btn9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Number(btn9.getText());
            }
        });
        btn9.setForeground(Color.WHITE);
        btn9.setBackground(SystemColor.controlText);
        btn9.setBounds(144, 204, 56, 46);
        contentPane.add(btn9);

        JButton btnDivide = new JButton("/");
        btnDivide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                val1 = Double.parseDouble(txtOutput.getText());
                operator = "/";
                txtOutput.setText("");

            }
        });
        btnDivide.setForeground(Color.WHITE);
        btnDivide.setBackground(SystemColor.windowBorder);
        btnDivide.setBounds(210, 204, 56, 46);
        contentPane.add(btnDivide);

        JButton btnPercent = new JButton("%");
        btnPercent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnPercent.setForeground(Color.WHITE);
        btnPercent.setBackground(SystemColor.windowBorder);
        btnPercent.setBounds(276, 204, 56, 46);
        contentPane.add(btnPercent);

        JButton btn4 = new JButton("4");
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Number(btn4.getText());
            }
        });
        btn4.setForeground(Color.WHITE);
        btn4.setBackground(SystemColor.controlText);
        btn4.setBounds(10, 254, 56, 46);
        contentPane.add(btn4);

        JButton btn5 = new JButton("5");
        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Number(btn5.getText());
            }
        });
        btn5.setForeground(Color.WHITE);
        btn5.setBackground(SystemColor.controlText);
        btn5.setBounds(76, 254, 56, 46);
        contentPane.add(btn5);

        JButton btn6 = new JButton("6");
        btn6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Number(btn6.getText());
            }
        });
        btn6.setForeground(Color.WHITE);
        btn6.setBackground(SystemColor.controlText);
        btn6.setBounds(144, 254, 56, 46);
        contentPane.add(btn6);

        JButton btnMultiply = new JButton("X");
        btnMultiply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                val1 = Double.parseDouble(txtOutput.getText());
                operator = "*";
                txtOutput.setText("");

            }
        });
        btnMultiply.setForeground(Color.WHITE);
        btnMultiply.setBackground(SystemColor.windowBorder);
        btnMultiply.setBounds(210, 254, 56, 46);
        contentPane.add(btnMultiply);

        JButton btnFraction = new JButton("1/x");
        btnFraction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                Double answer = 0.0;
                answer = 1 / Double.parseDouble(txtOutput.getText());
                txtOutput.setText(answer.toString());

            }
        });
        btnFraction.setForeground(Color.WHITE);
        btnFraction.setBackground(SystemColor.windowBorder);
        btnFraction.setBounds(276, 254, 56, 46);
        contentPane.add(btnFraction);

        JButton btn1 = new JButton("1");
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Number(btn1.getText());
            }
        });
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(SystemColor.controlText);
        btn1.setBounds(10, 306, 56, 46);
        contentPane.add(btn1);

        JButton btn2 = new JButton("2");
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Number(btn2.getText());
            }
        });
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(SystemColor.controlText);
        btn2.setBounds(76, 306, 56, 46);
        contentPane.add(btn2);

        JButton btn3 = new JButton("3");
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Number(btn3.getText());
            }
        });
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(SystemColor.controlText);
        btn3.setBounds(144, 306, 56, 46);
        contentPane.add(btn3);

        JButton btnSubtract = new JButton("-");
        btnSubtract.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                val1 = Double.parseDouble(txtOutput.getText());
                operator = "-";
                txtOutput.setText("");
            }
        });
        btnSubtract.setForeground(Color.WHITE);
        btnSubtract.setBackground(SystemColor.windowBorder);
        btnSubtract.setBounds(210, 306, 56, 46);
        contentPane.add(btnSubtract);

        JButton btnZero = new JButton("0");
        btnZero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Number(btnZero.getText());
            }
        });
        btnZero.setForeground(Color.WHITE);
        btnZero.setBackground(SystemColor.controlText);
        btnZero.setBounds(10, 358, 122, 46);
        contentPane.add(btnZero);

        JButton btnDecimal = new JButton(".");
        btnDecimal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                if(!decimal) {
                    txtOutput.setText(txtOutput.getText() + ".");
                    decimal = true;
                }
            }
        });
        btnDecimal.setForeground(Color.WHITE);
        btnDecimal.setBackground(SystemColor.controlText);
        btnDecimal.setBounds(144, 358, 56, 46);
        contentPane.add(btnDecimal);

        JButton btnPlus = new JButton("+");
        btnPlus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                val1 = Double.parseDouble(txtOutput.getText());
                operator = "+";
                txtOutput.setText("");

            }
        });
        btnPlus.setForeground(Color.WHITE);
        btnPlus.setBackground(SystemColor.windowBorder);
        btnPlus.setBounds(210, 358, 56, 46);
        contentPane.add(btnPlus);

        JButton btnEquals = new JButton("=");
        btnEquals.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                Double answer = 0.0;
                val2 = Double.parseDouble(txtOutput.getText());
                if(operator.equals("/")) {
                    if(val2 != 0) {
                        answer = val1 / val2;
                    }
                }
                else if(operator.equals("*")) {
                    answer = val1 * val2;
                }
                else if(operator.equals("+")) {
                    answer = val1 + val2;
                }
                else
                    answer = val1 - val2;

                txtOutput.setText(answer.toString());



            }
        });
        btnEquals.setForeground(Color.WHITE);
        btnEquals.setBackground(new Color(255, 140, 0));
        btnEquals.setBounds(276, 306, 56, 98);
        contentPane.add(btnEquals);
    }

    private void Number(String sender) {
        txtOutput.setText(txtOutput.getText() + sender);
    }




}
