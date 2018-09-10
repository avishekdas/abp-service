package abp.crm.campaign.command;


import io.eventuate.tram.examples.todolist.common.Utils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {CampaignCommandConfiguration.class})
@EnableAutoConfiguration
@ComponentScan
public class CommandModuleTest {

  @Autowired
  private CampaignRepository campaignRepository;

  @Autowired
  private CampaignCommandService campaignCommandService;

  @Test
  public void testCreate() {
    String queryToExecute = Utils.generateUniqueString();
    String subjectLine = Utils.generateUniqueString();
    Long id = campaignCommandService.create(new CreateCampaignRequest(queryToExecute, subjectLine, 0, 0)).getReportId();
    Campaign campaign = campaignRepository.findOne(id);
    Assert.assertNotNull(campaign);
    Assert.assertEquals(queryToExecute, campaign.getQueryToExecute());
  }

  @Test
  public void testUpdate() {
    Campaign campaign = campaignRepository.save(new Campaign(Utils.generateUniqueString(), Utils.generateUniqueString(), 0, 0));
    String queryToExecute = Utils.generateUniqueString();
    String subjectLine = Utils.generateUniqueString();
    campaignCommandService.update(campaign.getReportId(), new UpdateCampaignRequest(queryToExecute, subjectLine, 0, 0));
    campaign = campaignRepository.findOne(campaign.getReportId());
    Assert.assertNotNull(campaign);
    Assert.assertEquals(queryToExecute, campaign.getQueryToExecute());
  }

  @Test
  public void testDelete() {
    Campaign campaign = campaignRepository.save(new Campaign(Utils.generateUniqueString(), Utils.generateUniqueString(), 0, 0));
    campaignCommandService.delete(campaign.getReportId());
    Assert.assertNull(campaignRepository.findOne(campaign.getReportId()));
  }
}
