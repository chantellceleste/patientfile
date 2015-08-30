package patientfile.repository;

import org.springframework.data.repository.CrudRepository;
import patientfile.domain.Bill;

/**
 * Created by chantell witbooi on 5/10/2015.
 */
public interface BillRepository extends CrudRepository<Bill,Long> {
}
