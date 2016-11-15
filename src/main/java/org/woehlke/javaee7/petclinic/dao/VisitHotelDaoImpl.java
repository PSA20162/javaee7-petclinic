package org.woehlke.javaee7.petclinic.dao;

import org.woehlke.javaee7.petclinic.entities.CheckIn;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: tw
 * Date: 07.01.14
 * Time: 12:43
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class VisitHotelDaoImpl implements VisitHotelDao {

    private static Logger log = Logger.getLogger(VisitHotelDaoImpl.class.getName());

    @PersistenceContext(unitName="javaee7petclinic")
    private EntityManager entityManager;

    @Override
    public void addNew(CheckIn checkIn) {
        log.info("addNewCheckIn: "+checkIn.toString());
        entityManager.persist(checkIn);
    }

    @Override
    public void update(CheckIn checkIn) {
        checkIn= entityManager.merge(checkIn);
    }
}
