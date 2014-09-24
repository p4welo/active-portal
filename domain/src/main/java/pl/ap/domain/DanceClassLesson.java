package pl.ap.domain;

import org.joda.time.DateTime;

/**
 * Created by parado on 2014-09-24.
 */
public class DanceClassLesson
{

   private DanceClass danceClass;

   private DateTime dateTime;

   public DanceClass getDanceClass()
   {
      return danceClass;
   }

   public void setDanceClass(DanceClass danceClass)
   {
      this.danceClass = danceClass;
   }

   public DateTime getDateTime()
   {
      return dateTime;
   }

   public void setDateTime(DateTime dateTime)
   {
      this.dateTime = dateTime;
   }
}
