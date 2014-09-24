package pl.ap.domain;

/**
 * Created by parado on 2014-09-24.
 */
public class CustomerPresence
{
   private Customer customer;

   private DanceClassLesson lesson;

   private boolean present;

   public Customer getCustomer()
   {
      return customer;
   }

   public void setCustomer(Customer customer)
   {
      this.customer = customer;
   }

   public DanceClassLesson getLesson()
   {
      return lesson;
   }

   public void setLesson(DanceClassLesson lesson)
   {
      this.lesson = lesson;
   }

   public boolean isPresent()
   {
      return present;
   }

   public void setPresent(boolean present)
   {
      this.present = present;
   }
}
