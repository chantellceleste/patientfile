package patientfile.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import patientfile.App;
import org.testng.annotations.Test;
import patientfile.conf.factory.BillFactory;
import patientfile.domain.Bill;
import patientfile.domain.Patient;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by chantell witbooi on 5/10/2015.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudPatient extends AbstractTestNGSpringContextTests {
    private Long id;
    private Long billId;
    private List<Bill> billList;

    @Autowired
    PatientRepository repository;
    @BeforeMethod
    public void setUp() throws Exception {
        billList = new ArrayList<Bill>();

    }


    @Test
    public void create() throws Exception {
        Bill bill = BillFactory.createBill(1002,5000.00,new Date());
        billList.add(bill);
        Patient patient = new Patient.Builder(7811).firstName("Chantell")
                          .lastName("Witbooi").age(52).occupation("slave").bill(billList).build();
        repository.save(patient);
        id = patient.getId();
        billId = bill.getId();
        Assert.assertNotNull(patient.getId());

    }
    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Patient patient = repository.findOne(id);
        Assert.assertEquals(52, patient.getAge());
    }

//    @Test(dependsOnMethods = "read")
//    public void update() throws Exception {
//        Patient patient = repository.findOne(id);
//        Bill bill = repository.findOne(id).getBill();
//
//        Patient newPatient = new Patient.Builder(7813).id(patient.getId())
//                .firstName("Chantell").lastName("Witbooi").age(36).occupation("slave").bill(bill).build();
//        repository.save(newPatient);
//
//        Patient updatedPatient = repository.findOne(id);
//        Assert.assertEquals(36,updatedPatient.getAge());
//
//    }
//
//    @Test(dependsOnMethods = "update")
//    public void delete() throws Exception {
//        Patient patient = repository.findOne(id);
//        repository.delete(patient);
//        Patient newPatient = repository.findOne(id);
//        Assert.assertNull(newPatient);
//    }


}
