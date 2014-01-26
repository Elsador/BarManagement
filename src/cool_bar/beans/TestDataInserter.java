package cool_bar.beans;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

        em.persist(Product1);
        em.persist(Product2);
        em.persist(Product3);
    }

}