package patientfile.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by chantell witbooi on 4/25/2015.
 */
@Entity
public class Patient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String lastName;
    private String firstName;
    private int age;
    private int idNumber;
    private String occupation;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private List<Bill> bill;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private List<Diagnosis> diagnoses;

    public Patient() {

    }

    public Patient(Builder builder) {
        id = builder.id;
        lastName = builder.lastName;
        firstName = builder.firstName;
        age = builder.age;
        idNumber = builder.idNumber;
        occupation = builder.occupation;
        //bill = builder.bill;
    }

    public Long getId(){
        return id;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public int getAge(){
        return age;
    }

    public String getOccupation(){
        return occupation;
    }

    public List<Bill> getBill() {
        return bill;
    }



    public static class Builder {
        private Long id;

        private String lastName;
        private String firstName;
        private int age;
        private int idNumber;
        private String occupation;
        private Bill bill;

        public Builder(int idNumber) {
            this.idNumber = idNumber;
        }

        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder lastName(String value) {
            this.lastName = value;
            return this;

        }

        public Builder firstName(String value) {
            this.firstName = value;
            return this;
        }

        public Builder age(int value) {
            this.age = value;
            return this;
        }

        public Builder occupation(String value) {
            this.occupation = value;
            return this;
        }


        /*public Builder bills(List<Bill> value) {
            this.bills() = value;
            return this;
        }*/



        public Builder copy(Patient value) {
            this.id = value.id;
            this.firstName = value.firstName;
            this.lastName = value.lastName;
            this.age = value.age;
            this.idNumber = value.idNumber;
            this.occupation = value.occupation;
            //this.bill = value.bill;
            return this;
        }

        public Patient build() {
            return new Patient(this);
        }


    }
}
