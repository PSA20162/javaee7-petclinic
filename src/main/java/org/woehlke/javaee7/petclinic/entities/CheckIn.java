package org.woehlke.javaee7.petclinic.entities;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: tw
 * Date: 01.01.14
 * Time: 21:10
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "checkin")
public class CheckIn implements Comparable<CheckIn> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "checkin_date")
    @Temporal( TemporalType.DATE )
    private Date date;

    @NotNull
    @Column(name = "checkout_date")
    @Temporal( TemporalType.DATE )
    private Date dateFinal;

    
    
    @NotEmpty
    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Date getDateFinal() {
        return dateFinal;
    }

    public void setDateFinal(Date dateFinal) {
        this.dateFinal = dateFinal;
    }

    
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CheckIn)) return false;

        CheckIn visit = (CheckIn) o;

        if (date != null ? !date.equals(visit.date) : visit.date != null) return false;
        if (description != null ? !description.equals(visit.description) : visit.description != null) return false;
        if (id != null ? !id.equals(visit.id) : visit.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CheckIn{" +
                "id=" + id +
                ", date=" + date +
                ", dateFinal=" + dateFinal +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public int compareTo(CheckIn o) {
        return date.compareTo(o.getDate());
    }
}
