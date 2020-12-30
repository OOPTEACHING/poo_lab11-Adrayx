package bnr;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BnrView extends JFrame {
    private JTextField m_userInputTf = new JTextField(20);
    private JTextField m_totalTf = new JTextField(20);
    private String[] currency = { "EUR", "RON", "USD"};
    private JComboBox m_fromCombo = new JComboBox(currency);
    private JComboBox m_toCombo = new JComboBox(currency);
    private JButton m_convertButton = new JButton(">>");

    private BnrModel m_model;

    public BnrView(BnrModel model)
    {
        m_model = model;

        m_totalTf.setText(m_model.getValue());
        m_totalTf.setEditable(false);

        JPanel content1 = new JPanel();
        content1.setLayout(new FlowLayout());
        content1.add(m_fromCombo);
        content1.add(m_convertButton);
        content1.add(m_toCombo);

        JPanel content21 = new JPanel();
        content21.setLayout(new FlowLayout());
        content21.add(new JLabel("Suma: "));
        content21.add(m_userInputTf);

        JPanel content22 = new JPanel();
        content22.setLayout(new FlowLayout());
        content22.add(new JLabel("Rezultat: "));
        content22.add(m_totalTf);

        JPanel content2 = new JPanel();
        content2.setLayout(new BoxLayout(content2, BoxLayout.Y_AXIS));
        content2.add(content21);
        content2.add(content22);

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.add(content1);
        content.add(content2);


        this.setContentPane(content);
        this.pack();

        this.setTitle("Bnr - MVC");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void reset() { m_totalTf.setText(""); }

    public String getUserInput(){return m_userInputTf.getText();}

    public void setTotal(String newTotal) { m_totalTf.setText(newTotal);}

    public void showError(String errMessage) { JOptionPane.showMessageDialog(this, errMessage);}

    public void addConvertListener(ActionListener acl) { m_convertButton.addActionListener(acl);}

    public String getFrom()
    {
        return m_fromCombo.getSelectedItem().toString();
    }

    public String getTo()
    {
        return m_toCombo.getSelectedItem().toString();
    }
}
