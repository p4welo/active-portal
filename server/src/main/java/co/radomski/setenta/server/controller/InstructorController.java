package co.radomski.setenta.server.controller;

import co.radomski.setenta.service.IInstructorService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by parado on 24.03.14.
 */
@Controller
public class InstructorController
{
   @Resource
   private IInstructorService instructorService;

}
