package bnr;

public class BnrModel {

    private float m_total;

    private static final float eur = 1;
    private static final float ron = 4.8649f;
    private static final float usd = 1.22f;

    public BnrModel()
    {
        reset();
    }

    public void reset()
    {
        m_total = 0;
    }

    public void convert(String operand, String from, String to)
    {
        m_total = Float.parseFloat(operand);
        switch(from)
        {
            case "RON":
            {
                m_total = m_total / ron;
                break;
            }

            case "USD":
            {
                m_total = m_total / usd;
                break;
            }

            default:
            {
                m_total = m_total / eur;
            }
        }
        switch(to) {
            case "EUR": {
                m_total = m_total * eur;
                break;
            }

            case "USD": {
                m_total = m_total * usd;
                break;
            }

            default: {
                m_total = m_total * ron;
            }
        }
    }

    public String getValue() {
        return String.valueOf(m_total);
    }
}
