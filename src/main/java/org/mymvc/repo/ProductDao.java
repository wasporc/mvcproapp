package org.mymvc.repo;

import org.hibernate.cfg.Configuration;
import org.mymvc.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Component
public class ProductDao /*implements Dao<Product>*/ {

    private static Logger logger = LoggerFactory.getLogger(ProductDao.class);

    private static final EntityManagerFactory factory;
    static {
        factory = new Configuration()
                .configure("hibernate.xml")
                .buildSessionFactory();
    }
    private static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }


    // @Override
    public List<Product> findAll(){
        EntityManager em = ProductDao.getEntityManager();
        return em.createQuery("select p from Product p", Product.class).getResultList();
    }

   // @Override
    public Product getById(Integer id) {
        EntityManager em = ProductDao.getEntityManager();
        Product product = em.createQuery("select p from Product p where p.id = :id", Product.class)
                .setParameter("id", id)
                .getSingleResult();
        return product;
    }

    public Product save(Product product){
        EntityManager em = ProductDao.getEntityManager();
        em.persist(product);
        return product;
    }

}
