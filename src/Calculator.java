import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class Calculator extends JFrame {

    JPanel mainPanel;
    JPanel buttonPanel;
    JPanel standard;
    JPanel panel2;
    CardLayout card;
    JButton c1, c2;
    private JTextField standardInput;
    private JButton st1, st2, st3, st4, st5, st6, st7, st8, st9, st0;
    private JButton stAdd, stSub, stMul, stDiv;
    private JButton stEnter, stClear;
    private JButton factCompute;
    Container c;

    Calculator() {
        c = getContentPane();

        card = new CardLayout(10,10);

        mainPanel.setLayout(card);
        mainPanel.add(standard, "p1");
        mainPanel.add(panel2, "p2");

        buttonPanel = new JPanel();
        buttonPanel.add(c1);
        buttonPanel.add(c2);

        c.add(mainPanel,BorderLayout.CENTER);
        c.add(buttonPanel, BorderLayout.PAGE_END);

        c1.addActionListener(e -> card.show(mainPanel, "p1"));
        c2.addActionListener(e -> card.show(mainPanel, "p2"));

        this.standardInputHandler();
    }

    /*
    * Create a Number class that holds each number to be operated on
    *
    * 2 approaches
    *   each button click individually adds to ArrayList
    *   Number objects created as user inputs
    *   Operations are finalized with each input
    * OR
    *   separate numbers and operations after final input
    *   create individual Number objects afterwards
    *   Final calculation is done at the end
    */
    public void onNumPressed (String nextDig) {
        String curInput = standardInput.getText();
        standardInput.setText(curInput + nextDig);
    }

    public void standardInputHandler() {
        ArrayList<String> input = new ArrayList<String>();

        st0.addActionListener(e -> {
            onNumPressed("0");
        });

        st1.addActionListener(e -> {
            onNumPressed("1");
        });

        st2.addActionListener(e -> {
            onNumPressed("2");
        });

        st3.addActionListener(e -> {
            onNumPressed("3");
        });

        st4.addActionListener(e -> {
            onNumPressed("4");
        });

        st5.addActionListener(e -> {
            onNumPressed("5");
        });

        st6.addActionListener(e -> {
            onNumPressed("6");
        });

        st7.addActionListener(e -> {
            onNumPressed("7");
        });

        st8.addActionListener(e -> {
            onNumPressed("8");
        });

        st9.addActionListener(e -> {
            onNumPressed("9");
        });

        stAdd.addActionListener(e -> {
            onNumPressed("+");
        });

        stSub.addActionListener(e -> {
            onNumPressed("-");
        });

        stMul.addActionListener(e -> {
            onNumPressed("x");
        });

        stDiv.addActionListener(e -> {
            onNumPressed("/");
        });

        stClear.addActionListener(e -> {
            standardInput.setText("");
        });

        stEnter.addActionListener(e -> {
            String inputString = standardInput.getText();
            Operations oper = new Operations(inputString);

            standardInput.setText(Double.toString(oper.compute()));
            input.clear();
        });
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Calculator main = new Calculator();
        main.setSize(300, 400);
        main.setVisible(true);
        main.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
