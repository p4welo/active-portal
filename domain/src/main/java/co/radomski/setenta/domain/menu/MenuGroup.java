package co.radomski.setenta.domain.menu;

import java.io.Serializable;
import java.util.List;

/**
 * Created by parado on 2014-05-14.
 */
public class MenuGroup implements Serializable
{
   private String header;

   private List<MenuItem> items;

   public String getHeader()
   {
      return header;
   }

   public void setHeader(String header)
   {
      this.header = header;
   }

   public List<MenuItem> getItems()
   {
      return items;
   }

   public void setItems(List<MenuItem> items)
   {
      this.items = items;
   }
}
