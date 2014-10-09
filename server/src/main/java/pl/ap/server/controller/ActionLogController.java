package pl.ap.server.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.ap.server.api.PublicApiMappings;

/**
 * Created by parado on 2014-10-09.
 */
@RestController
public class ActionLogController
{
   private static final Logger LOGGER = Logger.getLogger(ActionLogController.class);

   @RequestMapping(value = PublicApiMappings.ACTION_NEWS_PAGE, method = RequestMethod.GET)
   public void actionNews()
   {
      LOGGER.info("action: NEWS");
   }

   @RequestMapping(value = PublicApiMappings.ACTION_INSTRUCTORS_PAGE, method = RequestMethod.GET)
   public void actionInstructors()
   {
      LOGGER.info("action: INSTRUCTORS");
   }

   @RequestMapping(value = PublicApiMappings.ACTION_SCHEDULE_PAGE, method = RequestMethod.GET)
   public void actionSchedule()
   {
      LOGGER.info("action: SCHEDULE");
   }

   @RequestMapping(value = PublicApiMappings.ACTION_PRICELIST_PAGE, method = RequestMethod.GET)
   public void actionPriceList()
   {
      LOGGER.info("action: PRICE_LIST");
   }

   @RequestMapping(value = PublicApiMappings.ACTION_SHOWS_PAGE, method = RequestMethod.GET)
   public void actionShows()
   {
      LOGGER.info("action: SHOWS");
   }

   @RequestMapping(value = PublicApiMappings.ACTION_CONTACT_PAGE, method = RequestMethod.GET)
   public void actionContact()
   {
      LOGGER.info("action: CONTACT");
   }
}
