package patientfile.conf.factory;

import patientfile.domain.Bill;
import patientfile.domain.Patient;

import java.util.List;
import java.util.Map;

/**
 * Created by chantell witbooi on 5/10/2015.
 */
public class PatientFactory {

    public static Patient createPatient(int idNumber,int age, Map<String,String> values, List<Bill> bill){
        Patient patient = new Patient.Builder(idNumber).firstName(values.get("firstName"))
                .lastName(values.get("lastName")).occupation(values.get("occupation")).age(age).build();
        return patient;
    }

}
