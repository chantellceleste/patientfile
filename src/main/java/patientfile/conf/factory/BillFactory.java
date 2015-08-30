package patientfile.conf.factory;

import patientfile.domain.Bill;
import patientfile.domain.Patient;

import java.util.Date;

/**
 * Created by chantell witbooi on 5/10/2015.
 */
public class BillFactory {
    public static Bill createBill(int invoiceNum,double amount,Date date) {
        Bill bill = new Bill.Builder(invoiceNum).amount(amount).date(date).build();
        return bill;
    }
}
