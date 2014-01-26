package cool_bar.beans;

import java.util.List;


//import javax.annotation.security.PermitAll;
//import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cool_bar.model.Product;

@Stateless
public class ProductsBean {

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    public List<Product> getAllProducts() {
        return em.createNamedQuery("getAllProducts").getResultList();
    }

    public Product addProduct(Product newProduct) {
        em.persist(newProduct);
        return newProduct;
    }

    public void deleteProduct(long id) {
        Query query = em.createNamedQuery("deleteProduct");
        query.setParameter("id", id);
        query.executeUpdate();
    }

}
