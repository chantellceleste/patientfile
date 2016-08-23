package patientfile.model;

import org.apache.catalina.WebResourceRoot;
import org.springframework.hateoas.ResourceSupport;
import patientfile.domain.Bill;
import patientfile.domain.Diagnosis;

import java.util.List;

/**
 * Created by chantell witbooi on 8/22/2016.
 */
public class PatientResource extends ResourceSupport {
    private Long resId;
    private String lastName;
    private String firstName;
    private int age;
    private int idNumber;
    private String occupation;
    private List<Bill> bill;
    private List<Diagnosis> diagnoses;

    public PatientResource() {

    }

    public PatientResource(Builder builder) {
        resId = builder.resId;
        lastName = builder.lastName;
        firstName = builder.firstName;
        age = builder.age;
        idNumber = builder.idNumber;
        occupation = builder.occupation;
        bill = builder.bills;
    }

    public Long getResId(){
        return resId;
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
        private Long resId;

        private String lastName;
        private String firstName;
        private int age;
        private int idNumber;
        private String occupation;
        private List<Bill> bills;

        public Builder(int idNumber) {
            this.idNumber = idNumber;
        }

        public Builder resId(Long value) {
            this.resId = value;
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


        public Builder bill(List<Bill> value) {
            this.bills = value;
            return this;
        }



        public Builder copy(PatientResource value) {
            this.resId = value.resId;
            this.firstName = value.firstName;
            this.lastName = value.lastName;
            this.age = value.age;
            this.idNumber = value.idNumber;
            this.occupation = value.occupation;
            this.bills = value.bill;
            return this;
        }

        public PatientResource build() {
            return new PatientResource(this);
        }


    }
}
