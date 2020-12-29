package bnr;

import mvc.CalcController;

import java.awt.event.*;

public class BnrController {
    public BnrModel m_model;
    public BnrView m_view;

    BnrController(BnrModel model, BnrView view){
        m_model = model;
        m_view = view;

        view.addConvertListener(new ConvertListener());
    }

    class ConvertListener implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            String userInput = "";
            try{
                userInput = m_view.getUserInput();
                m_model.convert(userInput, m_view.getFrom(), m_view.getTo());
                m_view.setTotal(m_model.getValue());
            } catch (NumberFormatException ex)
            {
                m_view.showError("Bad input: " + userInput);
            }
        }
    }
}
