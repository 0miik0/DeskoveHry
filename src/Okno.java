import javax.swing.*;

public class Okno extends JFrame{

    private JTextField tfNazev;
    private JButton btnPredchozi;
    private JButton btn2;
    private JButton btnDalsi;
    private JPanel oknoMain;
    private Model model = new Model();
    private int indexAktualniHry = 0;


    public Okno(){
        super("Okno");
        setContentPane(oknoMain);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        zobrazDeskovku();
        btnPredchozi.addActionListener(e -> {
            indexAktualniHry--;
            zobrazDeskovku();
        });
        btnDalsi.addActionListener(e -> {
            indexAktualniHry++;
            zobrazDeskovku();
        });
    }

    public void zobrazDeskovku(){
        //osetrit kdyz je seznam prazdny - if seznam prazdny
        Deskovka aktualniDeskovka = model.getDeskovka(indexAktualniHry);
        tfNazev.setText(aktualniDeskovka.getNazev());
    }

    public static void main(String[] args) {
        Okno okno = new Okno();
        okno.setVisible(true);
    }
}
