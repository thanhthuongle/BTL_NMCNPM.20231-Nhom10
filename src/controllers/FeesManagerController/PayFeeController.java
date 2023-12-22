package controllers.FeesManagerController;

import java.sql.SQLException;

import models.PayFeeModel;
import services.FeesService;

public class PayFeeController {
	
	private FeesService feesService;
	
	public PayFeeController() {
		this.feesService = new FeesService();
	}

	public boolean payFee(PayFeeModel payFeeModel, int idFee) throws SQLException, ClassNotFoundException{
		if (payFeeModel.getSo_tien()>=0 && payFeeModel.getSo_tien()<=1000000) {
			return feesService.payFee(payFeeModel, idFee);			
		}
		return false;
	}
}
