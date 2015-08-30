package patientfile.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by chantell witbooi on 5/10/2015.
 */
@Entity
public class Bill implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double amount;
    private Date date;
    private int invoiceNum;
    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "patient_id")
    //private Patient patient;

    public Bill() {}

    public Bill(Builder builder){
        id = builder.id;
        amount = builder.amount;
        date = builder.date;
        invoiceNum = builder.invoiceNum;
        //patient = builder.patient;
    }
     public Long getId(){
         return id;
     }

    public static class Builder {
        private Long id;
        private double amount;
        private Date date;
        private int invoiceNum;
        private Patient patient;

        public Builder(int invoiceNum){
            this.invoiceNum = invoiceNum;
        }

        public Builder id(Long value){
            this.id = value;
            return this;
        }

        public Builder amount(double value) {
            this.amount = value;
            return this;
        }

        public Builder date(Date value){
            this.date = value;
            return this;
        }

        public Builder patient(Patient value){
            this.patient = value;
            return this;
        }

        public Builder copy(Bill value){
            this.id = value.id;
            this.invoiceNum = value.invoiceNum;
            this.amount = value.amount;
            this.date = value.date;
            //this.patient = value.patient;
            return this;
        }

        public Bill build(){
            return new Bill(this);
        }
    }
}
