package cat.itacademy.s04.t02.n03.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "fruit")
public class Fruit {


    @Id
    private String id;
    private String name;

    private int cantidadQuilos;

    public Fruit(){


    }

    public Fruit(String id, int cantidadQuilos, String name) {
        this.id = id;
        this.cantidadQuilos = cantidadQuilos;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCantidadQuilos() {
        return cantidadQuilos;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCantidadQuilos(int cantidadQuilos) {
        this.cantidadQuilos = cantidadQuilos;
    }
}
