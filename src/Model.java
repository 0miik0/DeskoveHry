import java.util.ArrayList;
import java.util.List;

public class Model {
    private final List<Deskovka> seznamDeskovek = new ArrayList<>();
    public Model(){
        seznamDeskovek.add(new Deskovka("a", Boolean.TRUE, 2));
        seznamDeskovek.add(new Deskovka("b", Boolean.FALSE, 1));
        seznamDeskovek.add(new Deskovka("c", Boolean.TRUE, 3));
    }
    public List<Deskovka> ziskejSeznamDeskovek() {
        return seznamDeskovek;
    }
    public Deskovka getDeskovka(int index){
        return seznamDeskovek.get(index);
    }
}
