package co.radomski.setenta.server.controller;

import co.radomski.setenta.server.api.ApiKeys;
import co.radomski.setenta.server.api.RestApiMappings;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by parado on 15.04.14.
 */
@Controller
public class MenuController
{
   /*[
   {
      "header": "Aktualności",
           "items": [
      {
         "label": "Lista",
              "uri": "/news",
              "icon": "gi gi-fire",
              "state": "news"
      },
      {
         "label": "Newsletter",
              "uri": "/newsletter",
              "icon": "fa fa-rss",
              "state": "newsletter"
      }
      ]
   },
   {
      "header": "Grafik",
           "items": [
      {
         "label": "Zajęcia",
              "uri": "/classes",
              "icon": "gi gi-table",
              "state": "classes"
      },
      {
         "label": "Nowe grupy",
              "uri": "/newGroups",
              "icon": "gi gi-lightbulb",
              "state": "newGroups"
      }
      ]
   }
   ]*/

   @RequestMapping(value = RestApiMappings.GET_MENU, method = RequestMethod.GET)
   @ResponseStatus(value = HttpStatus.OK)
   @ResponseBody
   public String getMenu()
   {
      return "{\"groups\": [{\"header\":\"Aktualności\",\"items\":[{\"label\":\"Lista\",\"uri\":\"/news\",\"icon\":\"gi gi-fire\",\"state\":\"news\"},{\"label\":\"Newsletter\",\"uri\":\"/newsletter\",\"icon\":\"fa fa-rss\",\"state\":\"newsletter\"}]},{\"header\":\"Grafik\",\"items\":[{\"label\":\"Zajęcia\",\"uri\":\"/classes\",\"icon\":\"gi gi-table\",\"state\":\"classes\"},{\"label\":\"Nowe grupy\",\"uri\":\"/newGroups\",\"icon\":\"gi gi-lightbulb\",\"state\":\"newGroups\"}]}]}";
   }
}
