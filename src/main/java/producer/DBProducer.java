package producer;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DBProducer {


    @Produces
    @PersistenceContext(name = "pushData")
    private EntityManager em;
}
