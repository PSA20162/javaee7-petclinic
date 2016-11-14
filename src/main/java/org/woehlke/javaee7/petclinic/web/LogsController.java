package org.woehlke.javaee7.petclinic.web;


import org.richfaces.component.SortOrder;
import org.woehlke.javaee7.petclinic.dao.FacebookDao;
import org.woehlke.javaee7.petclinic.dao.PetTypeDao;
import org.woehlke.javaee7.petclinic.entities.FacebookLog;
import org.woehlke.javaee7.petclinic.entities.PetType;

import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Fert
 * Date: 06.01.14
 * Time: 11:49
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean
@SessionScoped
public class LogsController implements Serializable {

    @EJB
    private FacebookDao facebookDao;

    public List<FacebookLog> getLogs(){
        return facebookDao.getAll();
    }


}
