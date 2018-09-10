package abp.crm.campaign.command;

public class CampaignNotFoundException extends RuntimeException {
	public CampaignNotFoundException(Long id) {
		super(String.format("Campaign with id=%s not found"));
	}
}
