package co.edu.usa.mintic.ciclo3.api.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Data;

@Data
@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    
    /*@ManyToOne
    @JoinColumn(name = "client")
    @JsonIgnoreProperties("client")
    Room room;*/
    
    //@Temporal(javax.persistence.TemporalType.DATE)
    private Date startDate;
    
    //@Temporal(javax.persistence.TemporalType.DATE)
    private Date devolutionDate;
    
    private String status="created";
    /*
    @Temporal(javax.persistence.TemporalType.DATE)
    Date creationDate;
    */
    @ManyToOne
    @JoinColumn(name = "idRoom")
    @JsonIgnoreProperties("reservations")
    private Room room;
    
    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;
    /*
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "reservation")
    @JsonIgnoreProperties("reservation")
    List<Message> messages;*/
    private String score;
}
