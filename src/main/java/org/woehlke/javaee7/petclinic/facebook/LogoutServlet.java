package org.woehlke.javaee7.petclinic.facebook;

import facebook4j.Facebook;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 5357658337449255998L;
    private static Logger log = Logger.getLogger(LogoutServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {      
        Facebook facebook = (Facebook) request.getSession().getAttribute("facebook");
        String accessToken;
        try {
        	accessToken = facebook.getOAuthAccessToken().getToken();

            // Delete permissions for this Facebook App
            facebook.deleteAllPermissions();

        } catch (Exception e) {
            throw new ServletException(e);
        }

        // Invalidate the Session
        request.getSession().invalidate();

        // Logout from the Facebook
        StringBuffer next = request.getRequestURL();
        int index = next.lastIndexOf("/");
        next.replace(index+1, next.length(), "");
        response.sendRedirect(next.toString());
    }
}
