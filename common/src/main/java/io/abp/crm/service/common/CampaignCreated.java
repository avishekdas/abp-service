package io.abp.crm.service.common;

public class CampaignCreated {

  private String title;

  private boolean completed;

  private int executionOrder;

  public CampaignCreated() {
  }

  public CampaignCreated(String title, boolean completed, int executionOrder) {
    this.title = title;
    this.completed = completed;
    this.executionOrder = executionOrder;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public boolean isCompleted() {
    return completed;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }

  public int getExecutionOrder() {
    return executionOrder;
  }

  public void setExecutionOrder(int executionOrder) {
    this.executionOrder = executionOrder;
  }
}
