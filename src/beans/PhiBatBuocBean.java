package beans;

import java.util.ArrayList;
import java.util.List;

import models.FeesModel;

public class PhiBatBuocBean {

    private FeesModel feesModel;
    private List<FeesModel> feesModels;
    
    public PhiBatBuocBean() {
        this.feesModel = new FeesModel();
        this.feesModels = new ArrayList<FeesModel>();
	}
    
	public PhiBatBuocBean(FeesModel feesModel, List<FeesModel> feesModels) {
		super();
		this.feesModel = feesModel;
		this.feesModels = feesModels;
	}
    
    public FeesModel getFeesModel() {
        return feesModel;
    }


}
