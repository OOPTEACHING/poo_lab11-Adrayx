import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MyPanel {

    public static void main(String[] args) {
        final int[] contor = { 0 };

        JFrame frame = new JFrame ("Simple Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 120);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        JLabel l = new JLabel ("Label1 ");
        JTextField tf = new JTextField("TextField1");
        tf.setColumns(10);
        panel1.add(l);
        panel1.add(tf);
        panel1.setLayout(new FlowLayout());

        JButton b1 = new JButton("Button 1");
//        b1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Butonul a fost apasat");
//            }
//        });
        b1.addActionListener(e ->
        {
            contor[0]++;
            l.setText(contor[0] + "");
            System.out.println(l.getText());
        });

        JButton b2 = new JButton("Button 2");
        b2.addActionListener(e -> {
            String text = tf.getText();
            l.setText(text);
        });

        JButton b3 = new JButton("Button 3");
        b3.addActionListener(e -> {
            panel1.setBackground(Color.black);
            panel2.setBackground(Color.cyan);
        });

        panel2.add(b1);
        panel2.add(b2);
        panel2.add(b3);

        JPanel p = new JPanel();
        p.add(panel1);
        p.add(panel2);
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

        frame.setContentPane(p);
        frame.setVisible(true);
    }
}
