package bnr;

public class BnrMVC {
    public static void main(String[] args)
    {
        BnrModel model = new BnrModel();
        BnrView view = new BnrView(model);
        BnrController controller = new BnrController(model, view);
        view.setVisible(true);
    }
}
