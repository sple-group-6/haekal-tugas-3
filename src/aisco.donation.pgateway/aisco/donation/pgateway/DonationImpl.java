package aisco.donation.pgateway;
import aisco.donation.core.DonationComponent;
import aisco.donation.core.DonationDecorator;
import payment.page.core.*;
import payment.page.PaymentPageFactory;

public class DonationImpl extends DonationDecorator {
    PaymentPage payment;

    public DonationImpl(DonationComponent record) {
        super(record);
        payment = PaymentPageFactory.createPaymentPage("payment.page.core.PaymentPageImpl");
    }

    public void getDonation(){ 
        payment.getTransaction();
    }

    public void addDonation(){

        payment.addTransaction();
    }

    @Override
    public void printHeader() {
        System.out.println("\nDonation via Payment Gateway");
    }
}
