package co.radomski.setenta.domain.menu;

import java.io.Serializable;

/**
 * Created by parado on 2014-05-14.
 */
public class MenuItem implements Serializable
{
   private String label;

   private String uri;

   private String icon;

   private String state;

   public String getLabel()
   {
      return label;
   }

   public void setLabel(String label)
   {
      this.label = label;
   }

   public String getUri()
   {
      return uri;
   }

   public void setUri(String uri)
   {
      this.uri = uri;
   }

   public String getIcon()
   {
      return icon;
   }

   public void setIcon(String icon)
   {
      this.icon = icon;
   }

   public String getState()
   {
      return state;
   }

   public void setState(String state)
   {
      this.state = state;
   }
}
