package cool_bar.products.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries({
    @NamedQuery(name = "getAllProducts",
                query = "SELECT p FROM product p"),
    @NamedQuery(name = "deleteProduct",
                query = "DELETE FROM Product p WHERE p.id = :id")
})
@XmlRootElement
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String type;
    private String description;
    private float price;
//    @ManyToOne
//    private Department department;
//    @ManyToMany
//    private List<Course> courses;

    public Product(String name, String type, String description,
            float price) {
        this.name = name;
        this.type = type;
        this.setDescription(description);
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}