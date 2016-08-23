package patientfile.services.Impl;

import patientfile.domain.Bill;
import patientfile.domain.Patient;
import patientfile.repository.PatientRepository;
import patientfile.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chantell witbooi on 8/22/2016.
 */
@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient findById(Long Id) {
        return patientRepository.findOne(Id);
    }

    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient update(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void delete(Patient patient) {
      patientRepository.delete(patient);
    }

    @Override
    public List<Patient> findAll() {
        List<Patient> allPatients = new ArrayList<>();
        Iterable<Patient> patients = patientRepository.findAll();
        for (Patient patient : patients) {
            allPatients.add(patient);
        }
        return allPatients;
    }
}
