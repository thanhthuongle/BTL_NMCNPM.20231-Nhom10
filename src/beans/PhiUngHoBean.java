package beans;

import java.util.ArrayList;
import java.util.List;

import models.DonationsModel;

public class PhiUngHoBean {

    private DonationsModel donationModel;
    private List<DonationsModel> donationModels;
    
    public PhiUngHoBean() {
        this.donationModel = new DonationsModel();
        this.donationModels = new ArrayList<DonationsModel>();
	}
    
	public PhiUngHoBean(DonationsModel donationModel, List<DonationsModel> donationModels) {
		super();
		this.donationModel = donationModel;
		this.donationModels = donationModels;
	}
    
    public DonationsModel getDonationModel() {
        return donationModel;
    }


}
