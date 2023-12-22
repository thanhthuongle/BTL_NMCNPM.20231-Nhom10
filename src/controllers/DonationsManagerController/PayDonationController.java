package controllers.DonationsManagerController;

import java.sql.SQLException;

import models.PayDonationModel;
import services.DonationsService;

public class PayDonationController {
	
	private DonationsService DonationsService;
	
	public PayDonationController() {
		this.DonationsService = new DonationsService();
	}

	public boolean payDonation(PayDonationModel payDonationModel, int idDonation) throws SQLException, ClassNotFoundException{
		if (payDonationModel.getSo_tien()>=0 && payDonationModel.getSo_tien()<=10000000) {
			return DonationsService.payDonation(payDonationModel, idDonation);
		}
		return false;
	}
}
