import java.util.ArrayList;
import java.util.List;

public class Model {
    private final List<Deskovka> seznamDeskovek = new ArrayList<>();
    public List<Deskovka> ziskejSeznamDeskovek() {
        return seznamDeskovek;
    }
    public Model(){
        seznamDeskovek.add(new Deskovka("Carcassonne", Boolean.TRUE, 2));
        seznamDeskovek.add(new Deskovka("Catan", Boolean.FALSE, 1));
        seznamDeskovek.add(new Deskovka("Dostihy a sázky", Boolean.TRUE, 3));
    }
    public Deskovka getDeskovka(int index){
        return seznamDeskovek.get(index);
    }
}
