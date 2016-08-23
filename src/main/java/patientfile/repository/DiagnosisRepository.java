package patientfile.repository;

import org.springframework.data.repository.CrudRepository;
import patientfile.domain.Diagnosis;

/**
 * Created by chantell witbooi on 8/30/2015.
 */
public interface DiagnosisRepository extends CrudRepository<Diagnosis,Long> {
}
