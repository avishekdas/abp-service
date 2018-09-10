package abp.crm.campaign.command;

import javax.persistence.*;

@Entity
@Table(name = "abpm_report_master")
public class Campaign {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="reportId")
  private Long reportId;

  @Column(name="queryToExecute")
  private String queryToExecute;

  @Column(name="subjectLine")
  private String subjectLine;

  @Column(name="isAutomated")
  private int isAutomated;

  @Column(name="isActive")
  private int isActive;

  public Campaign() {
  }

  public Campaign(String queryToExecute, String subjectLine, int isAutomated, int isActive) {
    this.queryToExecute = queryToExecute;
    this.subjectLine = subjectLine;
    this.isAutomated = isAutomated;
    this.isActive = isActive;
  }

  public Campaign(Long reportId, String queryToExecute, String subjectLine, int isAutomated, int isActive) {
    this.reportId = reportId;
    this.queryToExecute = queryToExecute;
    this.subjectLine = subjectLine;
    this.isAutomated = isAutomated;
    this.isActive = isActive;
  }

  public Long getReportId() {
    return reportId;
  }

  public void setReportId(Long reportId) {
    this.reportId = reportId;
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
