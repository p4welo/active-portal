package pl.ap.domain;

import pl.ap.domain.enums.GenderEnum;

/**
 * Created by parado on 2014-09-24.
 */
public class Customer
{
   private String firstName;

   private String lastName;

   private String mobile;

   private GenderEnum gender;

   public String getFirstName()
   {
      return firstName;
   }

   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   }

   public String getLastName()
   {
      return lastName;
   }

   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }

   public String getMobile()
   {
      return mobile;
   }

   public void setMobile(String mobile)
   {
      this.mobile = mobile;
   }

   public GenderEnum getGender()
   {
      return gender;
   }

   public void setGender(GenderEnum gender)
   {
      this.gender = gender;
   }
}
