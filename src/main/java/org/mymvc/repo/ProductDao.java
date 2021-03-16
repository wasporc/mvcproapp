package org.mymvc.repo;

import org.hibernate.cfg.Configuration;
import org.mymvc.entity.Product;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Component
public class ProductDao implements Dao<Product> {

    private static final EntityManagerFactory factory;
    // Из фабрики создаем EntityManager
    static {
        factory = new Configuration()
                .configure("hibernate.xml")
                .buildSessionFactory();
    }

    private static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    @Override
    public List<Product> findAll(){
        EntityManager em = ProductDao.getEntityManager();
        return em.createQuery("select p from Product p", Product.class).getResultList();
    }

    @Override
    public Product getById(Long id) {
        EntityManager em = ProductDao.getEntityManager();
        return em.find(Product.class, id);
    }

}
