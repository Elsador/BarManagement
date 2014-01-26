package cool_bar.model;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int table;
    private double totalPrice;
    private String timeOrder;
    private String status;
    private int bigTip;

    @OneToMany
    private List<Product> products;

    public Order(int table, double totalPrice, String timeOrder,
            String status, int bigTip, List<Product> products){
        this.table = table;
        this.totalPrice = totalPrice;
        this.timeOrder = timeOrder;
        this.status = status;
        this.bigTip = bigTip;
        this.products = products;
    }

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTimeOrder() {
        return timeOrder;
    }

    public void setTimeOrder(String timeOrder) {
        this.timeOrder = timeOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getBigTip() {
        return bigTip;
    }

    public void setBigTip(int bigTip) {
        this.bigTip = bigTip;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
