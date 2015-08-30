package patientfile.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import patientfile.App;
import patientfile.conf.factory.BillFactory;
import patientfile.conf.factory.PatientFactory;
import patientfile.domain.Bill;
import patientfile.domain.Patient;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chantell witbooi on 5/10/2015.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudBill extends AbstractTestNGSpringContextTests{

    private Long id;
    private Long patient_Id;

    @Autowired
    BillRepository repository;

    @Test
    public void create() throws Exception {
        /*Map<String,String> values = new HashMap<String, String>();
        values.put("firstName", "Candice");
        values.put("lastName", "Miller");
        values.put("occupation", "Dentist");
        Patient patient = PatientFactory.createPatient(814,32,values);*/
        Bill bill = BillFactory.createBill(1001,1000.00,new Date());
        repository.save(bill);
        id = bill.getId();
        Assert.assertNotNull(bill.getId());

    }

    /*@Test(dependsOnMethods = "create")
    public void delete() throws Exception {
        Bill bill = repository.findOne(id);
        repository.delete(bill);
        Bill newBill = repository.findOne(id);
        Assert.assertNull(newBill);
    }*/
}
