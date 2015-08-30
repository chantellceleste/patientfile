package patientfile.repository;

import org.springframework.data.repository.CrudRepository;
import patientfile.domain.Patient;

/**
 * Created by chantell witbooi on 5/10/2015.
 */
public interface PatientRepository extends CrudRepository<Patient,Long>{
}
