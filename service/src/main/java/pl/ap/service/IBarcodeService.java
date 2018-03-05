package pl.ap.service;

import com.itextpdf.text.DocumentException;
import pl.ap.domain.Course;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by parado on 15.04.14.
 */
public interface IBarcodeService {
    void createPdf(OutputStream os) throws IOException, DocumentException;

    void createSchedulePdf(List<Course> courses, OutputStream outputStream) throws DocumentException, IOException;
}
