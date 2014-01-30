package cool_bar.beans;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cool_bar.model.TheOrder;
import cool_bar.model.Product;

/**
 * Session Bean implementation class TestDataInserter
 */
@Singleton
@Startup
public class TestDataInserter {

    @PersistenceContext
    private EntityManager em;

    @PostConstruct
    public void insertTestData() {

        Product Product1 = new Product("Kafe", "pitie", "bez kofeinovo",1.30);
        Product Product2 = new Product("Vode", "pitie", "gazirana",1.70);
        Product Product3 = new Product("Kebap4e", "qdeniieee", "ot meso",1.00);
        Product Product4 = new Product("Kebap4e", "qdeniieee", "ot meso",100.00);

        TheOrder newOrder = new TheOrder();
        newOrder.setTable(34);
        newOrder.setProducts(new ArrayList<Product>());
        newOrder.setBigTip(1);
        newOrder.setTimeOrder("oh male kolkko e 4asa");
        newOrder.setTotalPrice(213);
        newOrder.setStatus("nqma pyk");
        em.persist(Product1);
        em.persist(Product2);
        em.persist(Product3);
        em.persist(Product4);
//        em.persist(newOrder);
    }

}