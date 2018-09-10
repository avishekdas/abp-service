package abp.crm.campaign.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CampaignCommandService {

  @Autowired
  private CampaignRepository campaignRepository;

  public List<Campaign> viewAll() {
    List<Campaign> list = new ArrayList<>();
    for(Campaign e : campaignRepository.findAll()) {
      System.out.println(e.getReportId());
      list.add(new Campaign(e.getReportId(), e.getQueryToExecute(), e.getSubjectLine(),
              e.getIsAutomated(), e.getIsAutomated()));
    }
    return list;
  }

  public Campaign create(CreateCampaignRequest createCampaignRequest) {
    Campaign campaign = new Campaign(createCampaignRequest.getQueryToExecute(), createCampaignRequest.getSubjectLine(),
            createCampaignRequest.getIsAutomated(), createCampaignRequest.getIsActive());
    campaign = campaignRepository.save(campaign);

    return campaign;
  }

  public void update(Long id, UpdateCampaignRequest updateCampaignRequest) {
    Campaign campaign = campaignRepository.findOne(id);

    if (campaign == null) {
      throw new CampaignNotFoundException(id);
    }

    campaign.setQueryToExecute(updateCampaignRequest.getQueryToExecute());
    campaign.setSubjectLine(updateCampaignRequest.getSubjectLine());
    campaign.setIsAutomated(updateCampaignRequest.getIsAutomated());
    campaign.setIsActive(updateCampaignRequest.getIsActive());
    campaignRepository.save(campaign);

  }

  public void delete(Long id) {
    campaignRepository.delete(id);
  }
}
