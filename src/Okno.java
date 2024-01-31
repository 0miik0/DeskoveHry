import javax.swing.*;

public class Okno extends JFrame{

    private JTextField textField1;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JPanel oknoMain;
    private Model model = new Model();
    private int indexAktualniHry = 0;


    public Okno(){
        super("Okno");
        setContentPane(oknoMain);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
    }

    public void zobrazDeskovku(){
        Deskovka aktualniDeskovka = model.getDeskovka(indexAktualniHry);
    }

    public static void main(String[] args) {
        Okno okno = new Okno();
        okno.setVisible(true);
    }
}
