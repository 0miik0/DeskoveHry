import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Okno extends JFrame{

    private JTextField tfNazev;
    private JButton btnPredchozi;
    private JButton btnUlozit;
    private JButton btnDalsi;
    private JPanel oknoMain;
    private JCheckBox zakoupenoCB;
    private JRadioButton RB1;
    private JRadioButton RB2;
    private JRadioButton RB3;
    private Model model = new Model();
    private int indexAktualniHry = 0;
    private final List<Deskovka> seznamDeskovek = model.ziskejSeznamDeskovek();
    private int aktualniOblibenost;

    public Deskovka ziskejDeskovku(int i) {
        return seznamDeskovek.get(i);
    }
    public List<Deskovka> ziskejSeznamDeskovek() {
        return seznamDeskovek;
    }
    private void handleRadioButtonClick(int cislo) {
        aktualniOblibenost = cislo;
    }
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
        btnUlozit.addActionListener(e -> ulozDoSouboru());
        //nactiZeSouboru(); ??
        if (ziskejSeznamDeskovek().isEmpty()){
            zobrazDeskovku();
            JOptionPane.showMessageDialog(this, "Nebyly nalezeny žádné další deskovky.", "Error", JOptionPane.INFORMATION_MESSAGE);
        }


        ButtonGroup oblibenost = new ButtonGroup();
        oblibenost.add(RB1);
        oblibenost.add(RB2);
        oblibenost.add(RB3);
        RB1.addItemListener(e -> handleRadioButtonClick(1));
        RB2.addItemListener(e -> handleRadioButtonClick(2));
        RB3.addItemListener(e -> handleRadioButtonClick(3));
    }


    public void nactiZeSouboru() {
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader("deskovky.txt")))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(";");
                String nazev = (parts[0]);
                boolean zakoupeno = parts[1].equals("zakoupeno");
                int cislo = Integer.parseInt(parts[2]);
                Deskovka deskovka = new Deskovka(nazev, zakoupeno, cislo);
                seznamDeskovek.add(deskovka);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Soubor nebyl nalezen: " + e.getLocalizedMessage());
        } catch (NumberFormatException e) {
            System.err.println("Špatný formát čísla: " + e.getLocalizedMessage());
        }
    }

    public void ulozDoSouboru() {
        Deskovka deskovka = seznamDeskovek.get(indexAktualniHry);
        deskovka.setNazev(tfNazev.getText());
        deskovka.setZakoupeno(zakoupenoCB.isSelected());
        deskovka.setCislo(aktualniOblibenost);

        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("deskovky.txt")))) {
            for (Deskovka deskovka1 : seznamDeskovek) {
                writer.println(deskovka1.getNazev() + ";" + (deskovka1.isZakoupeno() ? "zakoupeno" : "nezakoupeno") + ";" + deskovka1.getCislo());
            }
            JOptionPane.showMessageDialog(this, "Změny byly uloženy do souboru.", "Info", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Při psaní do souboru nastal error", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void zobrazDeskovku() {
        Deskovka aktualniDeskovka = model.getDeskovka(indexAktualniHry);
        tfNazev.setText(aktualniDeskovka.getNazev());
        zakoupenoCB.setSelected(aktualniDeskovka.isZakoupeno());
        switch (aktualniDeskovka.getCislo()) {
            case 1 -> RB1.setSelected(true);
            case 2 -> RB2.setSelected(true);
            case 3 -> RB3.setSelected(true);
        }
    }
    public static void main(String[] args) {
        Okno okno = new Okno();
        okno.setVisible(true);
    }
}
