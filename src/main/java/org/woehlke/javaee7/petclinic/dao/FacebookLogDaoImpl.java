package org.woehlke.javaee7.petclinic.dao;


import org.woehlke.javaee7.petclinic.entities.FacebookLog;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;


@Stateless
public class FacebookLogDaoImpl implements FacebookDao {

    private static Logger logger = Logger.getLogger(FacebookLogDaoImpl.class.getName());

    @PersistenceContext(unitName="javaee7petclinic")
    private EntityManager entityManager;

    @Override
    public List<FacebookLog> getAll() {
        TypedQuery<FacebookLog> q = entityManager.createQuery("select o from FacebookLog o order by o.name", FacebookLog.class);
        List<FacebookLog> list = q.getResultList();
        Collections.reverse(list);
        return list;
    }

    @Override
    public void addNew(FacebookLog log) {
        logger.info("addNewFacebookLog: " + log.toString());
        logger.info(entityManager == null ? "entity is null" : "not null");

        entityManager.persist(log);
    }


}
