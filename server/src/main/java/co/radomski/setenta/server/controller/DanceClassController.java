package co.radomski.setenta.server.controller;

import co.radomski.setenta.service.IDanceClassService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by parado on 21.03.14.
 */
@Controller
public class DanceClassController
{
   @Resource
   private IDanceClassService danceClassService;

}
