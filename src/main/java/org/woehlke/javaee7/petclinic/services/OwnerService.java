package org.woehlke.javaee7.petclinic.services;

import org.woehlke.javaee7.petclinic.entities.Visit;
import org.woehlke.javaee7.petclinic.entities.CheckIn;

/**
 * Created by tw on 10.03.14.
 */
public interface OwnerService {

    void addNewVisit(Visit visit);
     void addCheckIn(CheckIn checkin);
}
