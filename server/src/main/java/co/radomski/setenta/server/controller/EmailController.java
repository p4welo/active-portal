package co.radomski.setenta.server.controller;

import co.radomski.setenta.service.IMailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * User: pawel.radomski
 * Date: 26.11.13
 * Time: 17:11
 */

@Controller
public class EmailController
{
   @Resource
   private IMailService mailService;

   @RequestMapping("/hello")
   public String hello(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model)
   {
      model.addAttribute("name", name);
      return "redirect:hello";
   }
}
