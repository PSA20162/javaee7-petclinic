package org.woehlke.javaee7.petclinic.facebook;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.Reading;
import facebook4j.User;
import org.woehlke.javaee7.petclinic.dao.FacebookDao;
import org.woehlke.javaee7.petclinic.dao.FacebookLogDaoImpl;
import org.woehlke.javaee7.petclinic.entities.FacebookLog;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;

public class CallbackServlet extends HttpServlet {
    private static final long serialVersionUID = 6305643034487441839L;
    private static Logger log = Logger.getLogger(CallbackServlet.class.getName());

    @EJB
    private FacebookDao facebookDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Facebook facebook = (Facebook) request.getSession().getAttribute("facebook");
        String oauthCode = request.getParameter("code");
        try {
            facebook.getOAuthAccessToken(oauthCode);
            saveLogin(facebook);
        } catch (FacebookException e) {
            throw new ServletException(e);
        }
        response.sendRedirect(request.getContextPath() + "/");
    }

    private void saveLogin(Facebook facebook) throws FacebookException {
        log.info("SAVING LOG");
        User user = facebook.getMe(new Reading().fields("name", "email", "hometown"));
        log.info(user.toString().replace(",", "\n"));
        FacebookLog facebookLog = new FacebookLog();
        facebookLog.setName(user.getName());
        facebookLog.setEmail(user.getEmail() != null ? user.getEmail() : "no email");
        facebookLog.setDate(new Date());
//        facebookLog.setId(user.getId());
        facebookDao.addNew(facebookLog);

    }
}
