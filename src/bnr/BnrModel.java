package bnr;

public class BnrModel {
    static final String INITIAL_VALUE = "1";

    private float m_total;

    private final float eur = 1;
    private final float ron = 4.8649f;
    private final float usd = 1.22f;

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
        m_total = Float.valueOf(operand);
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

    public void setValue(float value)
    {
        m_total = value;
    }

    public String getValue() {
        return String.valueOf(m_total);
    }
}
