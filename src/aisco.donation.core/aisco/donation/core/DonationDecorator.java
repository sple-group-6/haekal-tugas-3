package aisco.donation.core;

import java.util.List;

public abstract class DonationDecorator extends DonationComponent {
	protected DonationComponent record;

	public DonationDecorator(DonationComponent record) {
		super();
		this.record = record;
	}

	@Override
	public void addDonation() {
		record.addDonation();
	}

	@Override
	public void getDonation() {
		record.getDonation();
	}

	@Override
	public void printHeader(){
		record.printHeader();
	}

	@Override
	public String toString(){
		return record.toString();
	}
}
