package abp.crm.campaign.command;


public class CreateCampaignResponse {
  private Long id;

  public CreateCampaignResponse() {
  }

  public CreateCampaignResponse(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
