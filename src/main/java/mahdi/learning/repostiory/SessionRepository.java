package mahdi.learning.repostiory;


import mahdi.learning.model.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.UUID;

@Repository
public class SessionRepository {

    @PersistenceContext
    EntityManager entityManager;

    public UUID save(Session session ) {
        entityManager.persist(session);
        return session.getSession_id();
    }

}
