package pl.ap.service;

import com.itextpdf.text.DocumentException;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by parado on 15.04.14.
 */
public interface IBarcodeService {
    void createPdf(OutputStream os) throws IOException, DocumentException;
}
