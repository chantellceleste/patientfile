package patientfile.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import patientfile.domain.Bill;
import patientfile.domain.Patient;
import patientfile.model.PatientResource;
import patientfile.services.PatientService;
import org.springframework.hateoas.Link;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chantell witbooi on 8/22/2016.
 */
@RestController
@RequestMapping("/api/**")
public class PatientPage {

    @Autowired
    PatientService patientService;

    @RequestMapping(value = "/patients/", method = RequestMethod.GET)
    public ResponseEntity<List<Patient>> listAllPatients() {
        List<Patient> patients = patientService.findAll();
        if(patients.isEmpty())
            return new ResponseEntity<List<Patient>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        return new ResponseEntity<List<Patient>>(patients, HttpStatus.OK);
    }

    @RequestMapping(value = "/patient/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Patient> getPatient(@PathVariable("id") long id) {
        System.out.println("Fetching Patient with id " + id);
        Patient patient = patientService.findById(id);
        if (patient == null) {
            System.out.println("Patient with id " + id + " not found");
            return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Patient>(patient,HttpStatus.OK);
    }

    @RequestMapping(value = "/patient/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createPatient(@RequestBody Patient patient, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Patient " + patient.getLastName());

        patientService.save(patient);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/patient/{id}").buildAndExpand(patient.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/patient/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Patient> updatePatient(@PathVariable("id") long id, @RequestBody Patient patient) {
        System.out.println("Updating Patient " + id);

        Patient currentPatient = patientService.findById(id);

        if (currentPatient==null) {
            System.out.println("Patient with id " + id + " not found");
            return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
        }

        Patient updatedPatient = new Patient
                .Builder(currentPatient.getIdNumber())
                .copy(currentPatient)
                .lastName(patient.getLastName())
                .firstName(patient.getFirstName())
                .age(patient.getAge())
                .occupation(patient.getOccupation())
                .bill(patient.getBill())
                .build();
        patientService.update(updatedPatient);
        return new ResponseEntity<Patient>(updatedPatient, HttpStatus.OK);
    }

    @RequestMapping(value = "/patient/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Patient> deletePatient(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Patient with id " + id);

        Patient patient = patientService.findById(id);
        if (patient == null) {
            System.out.println("Unable to delete. Patient with id " + id + " not found");
            return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
        }

        patientService.delete(patient);
        return new ResponseEntity<Patient>(HttpStatus.NO_CONTENT);
    }




}
