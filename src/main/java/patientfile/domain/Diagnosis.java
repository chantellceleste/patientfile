package patientfile.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by chantell witbooi on 5/10/2015.
 */
@Entity
public class Diagnosis implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private String name;
    private Date date;


}
