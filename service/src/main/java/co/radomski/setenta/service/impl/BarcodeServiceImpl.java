package co.radomski.setenta.service.impl;

import co.radomski.setenta.service.IBarcodeService;
import co.radomski.setenta.service.util.NumberUtils;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by parado on 15.04.14.
 */
@Service(BarcodeServiceImpl.BEAN_NAME)
public class BarcodeServiceImpl implements IBarcodeService
{
   public static final String BEAN_NAME = "barcodeService";

   @Override
   public void createPdf(OutputStream os) throws IOException, DocumentException
   {
      // step 1
      Document document = new Document(PageSize.A4);
      // step 2
      PdfWriter writer = PdfWriter.getInstance(document, os);
      // step 3
      document.open();
      // step 4
      PdfContentByte cb = writer.getDirectContent();
      // CODE 128
//      document.add(new Paragraph("Barcode 128"));
      Barcode128 code128 = new Barcode128();
      document.add(new Paragraph("Length 32:"));
      code128.setCode(NumberUtils.generate(32));
      document.add(code128.createImageWithBarcode(cb, null, null));
      document.add(new Paragraph("Length 24:"));
      code128.setCode(NumberUtils.generate(24));
      document.add(code128.createImageWithBarcode(cb, null, null));
      document.add(new Paragraph("Length 16:"));
      code128.setCode(NumberUtils.generate(16));
      document.add(code128.createImageWithBarcode(cb, null, null));
      document.add(new Paragraph("Length 9:"));
      code128.setCode(NumberUtils.generate(9));
      document.add(code128.createImageWithBarcode(cb, null, null));
      // step 5
      document.close();
   }
}
