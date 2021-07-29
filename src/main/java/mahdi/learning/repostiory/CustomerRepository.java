package mahdi.learning.repostiory;


import mahdi.learning.model.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CustomerRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Long save( Customer customer ) {
        entityManager.persist(customer);
        return customer.getId();
    }




}
