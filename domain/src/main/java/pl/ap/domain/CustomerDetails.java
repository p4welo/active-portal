package pl.ap.domain;

/**
 * Created by parado on 2014-09-24.
 */
public class CustomerDetails
{
   private Customer customer;

   private String email;

   public Customer getCustomer()
   {
      return customer;
   }

   public void setCustomer(Customer customer)
   {
      this.customer = customer;
   }

   public String getEmail()
   {
      return email;
   }

   public void setEmail(String email)
   {
      this.email = email;
   }
}
