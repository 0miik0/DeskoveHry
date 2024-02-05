public class Deskovka {
    private String nazev;
    private boolean zakoupeno;
    private int cislo;

    public Deskovka(String nazev, boolean zakoupeno, int cislo) {
        this.nazev = nazev;
        this.zakoupeno = zakoupeno;
        this.cislo = cislo;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public boolean isZakoupeno() {
        return zakoupeno;
    }

    public void setZakoupeno(boolean zakoupeno) {
        this.zakoupeno = zakoupeno;
    }

    public int getCislo() {
        return cislo;
    }

    public void setCislo(int cislo) {
        this.cislo = cislo;
    }
}
