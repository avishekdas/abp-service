package abp.crm.campaign.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/campaign")
public class CampaignCommandController {

  @Autowired
  private CampaignCommandService campaignCommandService;

  @RequestMapping(method = RequestMethod.GET)
  public List<Campaign> create() {
    List<Campaign> campaignList = campaignCommandService.viewAll();
    return campaignList;
  }

  @RequestMapping(method = RequestMethod.POST)
  public CreateCampaignResponse create(@RequestBody CreateCampaignRequest createCampaignRequest) {
    Campaign campaign = campaignCommandService.create(createCampaignRequest);
    return new CreateCampaignResponse(campaign.getReportId());
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public void update(@PathVariable Long id, @RequestBody UpdateCampaignRequest updateCampaignRequest) {
    campaignCommandService.update(id, updateCampaignRequest);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void delete(@PathVariable Long id) {
    campaignCommandService.delete(id);
  }
}
