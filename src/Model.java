import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Deskovka> seznamDeskovek = new ArrayList<>();
    public Model(){
        seznamDeskovek.add(new Deskovka("a"));
        seznamDeskovek.add(new Deskovka("b"));
        seznamDeskovek.add(new Deskovka("c"));
    }

    public Deskovka getDeskovka(int index){
        return seznamDeskovek.get(index);
    }
}
