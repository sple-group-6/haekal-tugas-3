package aisco.donation.core;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class DonationImpl extends DonationComponent {
    public DonationImpl()
    {
        donationList = new ArrayList<>();
    }

    public DonationImpl (String name, String email, String phone, int amount, String paymentMethod)
    {
        super(name, email, phone, amount,paymentMethod);
    }

    @Override
    public void printHeader() {
        System.out.println("Donation via AISCO");
    }

    public void getDonation(){
        System.out.println(Arrays.asList(donationList));
    }

    public void addDonation(){
        donationList.add(new DonationImpl("Anisa", "anisa@jmail.com", "+62878 6654 3321", 2500000, "Transfer"));
        donationList.add(new DonationImpl("Dave", "dave@jmail.com", "+62828 2345 3091", 500000, "Cash"));
        donationList.add(new DonationImpl("Edo", "edo@jmail.com", "+62828 2345 3091", 300000, "Payku"));
    }

    public String toString() {
        return "- Donasi " + name + ": " + amount + " Payment Method: " + paymentMethod + "\n";
    }
}