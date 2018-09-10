package abp.crm.campaign.command;


public class UpdateCampaignRequest {
  private String queryToExecute;
  private String subjectLine;
  private int isAutomated;
  private int isActive;

  public UpdateCampaignRequest() {
  }

  public UpdateCampaignRequest(String queryToExecute, String subjectLine, int isAutomated, int isActive) {
    this.queryToExecute = queryToExecute;
    this.subjectLine = subjectLine;
    this.isAutomated = isAutomated;
    this.isActive = isActive;
  }

  public String getQueryToExecute() {
    return queryToExecute;
  }

  public void setQueryToExecute(String queryToExecute) {
    this.queryToExecute = queryToExecute;
  }

  public String getSubjectLine() {
    return subjectLine;
  }

  public void setSubjectLine(String subjectLine) {
    this.subjectLine = subjectLine;
  }

  public int getIsAutomated() {
    return isAutomated;
  }

  public void setIsAutomated(int isAutomated) {
    this.isAutomated = isAutomated;
  }

  public int getIsActive() {
    return isActive;
  }

  public void setIsActive(int isActive) {
    this.isActive = isActive;
  }
}
