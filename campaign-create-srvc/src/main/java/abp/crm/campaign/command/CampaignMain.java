package abp.crm.campaign.command;

import io.abp.crm.service.common.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableAutoConfiguration
@Import({CampaignCommandConfiguration.class, SwaggerConfiguration.class})
@ComponentScan
public class CampaignMain {
  public static void main(String[] args) {
    SpringApplication.run(CampaignMain.class, args);
  }
}
