package pl.ap.rest.filter;

import javax.servlet.ServletOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by parado on 21.03.14.
 */
public class FilterServletOutputStream extends ServletOutputStream
{
   private DataOutputStream stream;

   public FilterServletOutputStream(OutputStream output)
   {
      stream = new DataOutputStream(output);
   }

   public void write(int b) throws IOException
   {
      stream.write(b);
   }

   public void write(byte[] b) throws IOException
   {
      stream.write(b);
   }

   public void write(byte[] b, int off, int len) throws IOException
   {
      stream.write(b, off, len);
   }
}
