package mahdi.learning.service;

import mahdi.learning.model.Session;
import mahdi.learning.repostiory.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class SessionService {

    @Autowired
    SessionRepository repository;

    public UUID save(Session session ) {
        return repository.save(session);
    }

}
