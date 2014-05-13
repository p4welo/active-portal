package co.radomski.setenta.server.controller;

import co.radomski.setenta.service.IBarcodeService;
import com.itextpdf.text.DocumentException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by parado on 15.04.14.
 */
@Controller
public class BarcodeController
{
   @Resource
   private IBarcodeService barcodeService;

   @RequestMapping(value = "/test", method = RequestMethod.GET)
   @ResponseStatus(value = HttpStatus.OK)
   public void getNewsList(HttpServletResponse res) throws IOException, DocumentException
   {
      barcodeService.createPdf(res.getOutputStream());
   }
}
