package aisco.donation.whatsapp;

import aisco.donation.core.Donation;
import aisco.donation.core.DonationComponent;
import aisco.donation.core.DonationDecorator;

import java.util.ArrayList;
import java.util.HashMap;

public class DonationImpl extends DonationDecorator {
    private final HashMap<String, String> whatsAppContact;
    private String receiverName;
    private String receiverWhatsappNumber;

    public DonationImpl(DonationComponent record) {
        super(record);
        this.donationList = new ArrayList<>();
        whatsAppContact = new HashMap<>() {{
            put("6281213180037", "Haekal");
            put("62811171234", "Yodha");
            put("628989823232", "Izi");
            put("62888888888888", "Grace");
        }};
    }

    public DonationImpl(DonationComponent record, HashMap<String, String> whatsAppContact) {
        super(record);
        this.whatsAppContact = whatsAppContact;
    }

    public DonationImpl(DonationComponent record, String receiverName, String receiverWhatsappNumber) {
        super(record);
        this.receiverName = receiverName;
        this.receiverWhatsappNumber = receiverWhatsappNumber;

        whatsAppContact = new HashMap<>() {{
            put("6281213180037", "Haekal");
            put("62811171234", "Yodha");
            put("628989823232", "Izi");
            put("62888888888888", "Grace");
        }};
    }

    public DonationImpl(DonationComponent record, String name, String email, String phone,
                        int amount, String receiverName, String receiverWhatsappNumber) {
        super(record);
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.amount = amount;
        this.paymentMethod = "WhatsApp";
        this.receiverName = receiverName;
        this.receiverWhatsappNumber = receiverWhatsappNumber;

        whatsAppContact = new HashMap<>() {{
            put("6281213180037", "Haekal");
            put("62811171234", "Yodha");
            put("628989823232", "Izi");
            put("62888888888888", "Grace");
        }};
    }

    @Override
    public void addDonation() throws IllegalArgumentException {
        throw new IllegalArgumentException("Donation via WhatsApp need contact phone number");
    }

    @Override
    public void getDonation() {
        for (Donation donation : donationList) {
            System.out.println(donation.toString());
        }
    }

    @Override
    public void printHeader(){
        System.out.println("Donation Via WhatsApp");
        System.out.println("----");
        System.out.println("List Kontak Whatsapp:");
        for (HashMap.Entry<String, String> entry : whatsAppContact.entrySet()) {
            System.out.println("  " + entry.getKey() + " - " + entry.getValue());
        }
        System.out.println("----");
    }

    public HashMap<String, String> getWhatsAppContact() {
        return this.whatsAppContact;
    }

    public void addDonationViaWhatsapp(String phoneNumber, String donorName, String donorEmail, 
                                       String donorPhone, int amount) throws IllegalAccessException {
        if (!this.validatePhoneNumber(phoneNumber)) {
            throw new IllegalAccessException("Invalid WhatsApp phone number format");
        }
        if (!whatsAppContact.containsKey(phoneNumber)) {
            throw new IllegalAccessException("Unknown phone number in WhatsApp contact");
        }

        String receiverName = whatsAppContact.get(phoneNumber);
        if (receiverName == null) {
            throw new IllegalAccessException("Unknown phone number in WhatsApp contact");
        }
        DonationImpl waDonation = new DonationImpl(
                record,
                donorName,
                donorEmail,
                donorPhone,
                amount,
                receiverName,
                phoneNumber
        );
        donationList.add(waDonation);
    }

    private boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || !phoneNumber.startsWith("62")) {
            return false;
        }

        String afterPrefix = phoneNumber.substring(2);
        int length = afterPrefix.length();
        return length >= 9 && length <= 12 && afterPrefix.matches("\\d+");
    }

    @Override
    public String toString() {
        return "- Donasi " + name + ": " + amount + " Payment Method: " + paymentMethod + "\n" +
                "  Penerima: " + receiverName + " (WhatsApp: " + receiverWhatsappNumber + ")";
    }

}
