/**
 * Created by tavares on 13/11/16.
 */

package org.woehlke.javaee7.petclinic.web;

import facebook4j.Facebook;
import facebook4j.FacebookException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.logging.Logger;

@ManagedBean(name = "facebookSession")
@SessionScoped
public class FacebookBean implements Serializable {

    private static Logger log = Logger.getLogger(FacebookBean.class.getName());

    public Boolean getLogged() throws FacebookException {
        Object faceSession = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("facebook");

        if (faceSession == null) {
            return false;
        }

        Facebook facebook = (Facebook) faceSession;

        return (facebook != null);

    }

    public String getName() throws FacebookException {
        Object faceSession = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("facebook");

        if (faceSession == null) {
            return "";
        }

        Facebook facebook = (Facebook) faceSession;

        if (facebook == null) {
            return "";
        }
        return facebook.getName();
    }
}
