package pl.ap.domain;

import org.joda.time.LocalDate;

/**
 * Created by parado on 2014-09-30.
 */
public class Ticket
{
   private Customer customer;

   private LocalDate validFrom;

   private LocalDate validTo;

   public Customer getCustomer()
   {
      return customer;
   }

   public void setCustomer(Customer customer)
   {
      this.customer = customer;
   }

   public LocalDate getValidFrom()
   {
      return validFrom;
   }

   public void setValidFrom(LocalDate validFrom)
   {
      this.validFrom = validFrom;
   }

   public LocalDate getValidTo()
   {
      return validTo;
   }

   public void setValidTo(LocalDate validTo)
   {
      this.validTo = validTo;
   }
}
