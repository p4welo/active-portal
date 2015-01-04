package pl.ap.service.impl;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.springframework.stereotype.Service;
import pl.ap.domain.Course;
import pl.ap.domain.enums.DayEnum;
import pl.ap.service.IBarcodeService;
import pl.ap.service.util.NumberUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by parado on 15.04.14.
 */
@Service(BarcodeServiceImpl.BEAN_NAME)
public class BarcodeServiceImpl implements IBarcodeService {
    public static final String BEAN_NAME = "barcodeService";

    @Override
    public void createPdf(OutputStream os) throws IOException, DocumentException {
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

    @Override
    public void createSchedulePdf(List<Course> courses, OutputStream outputStream) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter writer = PdfWriter.getInstance(document, outputStream);
        document.open();
        Map<DayEnum, List<Course>> schedule = prepareMapForSchedule(courses);

        BaseFont courier = BaseFont.createFont(BaseFont.COURIER, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font font = new Font(courier, 12, Font.NORMAL);
        Chunk chunk = new Chunk("",font);
        document.add(chunk);
        for (DayEnum key : DayEnum.values()) {
            List<Course> cList = schedule.get(key);
            document.add(new Paragraph(key.toString()));
            PdfPTable table = new PdfPTable(2);
            for (Course course : cList) {
                table.addCell(course.getStartTime() + " - " + course.getEndTime());
                table.addCell(course.getStyle().getName());
            }
            document.add(table);
        }
        document.close();
    }

    private Map<DayEnum, List<Course>> prepareMapForSchedule(List<Course> courses) {
        Map<DayEnum, List<Course>> result = new HashMap<>();
        for (DayEnum day : DayEnum.values()) {
            result.put(day, new ArrayList<Course>());
        }

        for (Course course : courses) {
            result.get(course.getDay()).add(course);
        }

        return result;
    }
}
