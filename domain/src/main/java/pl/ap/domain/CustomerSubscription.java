package pl.ap.domain;

/**
 * Created by parado on 2014-09-24.
 */
public class CustomerSubscription
{
   private Customer customer;

   private DanceClass danceClass;

   public Customer getCustomer()
   {
      return customer;
   }

   public void setCustomer(Customer customer)
   {
      this.customer = customer;
   }

   public DanceClass getDanceClass()
   {
      return danceClass;
   }

   public void setDanceClass(DanceClass danceClass)
   {
      this.danceClass = danceClass;
   }
}
