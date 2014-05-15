package pl.ap.domain;

import pl.ap.domain.enums.UserTypeEnum;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * User: pawel
 * Date: 17.12.12
 * Time: 19:16
 */
@Entity
@Table(name = "user")
public class User extends IdentifiableEntity
{
   public static final String FIELD_FIRST_NAME = "firstName";

   public static final String FIELD_LAST_NAME = "lastName";

   public static final String FIELD_LOGIN = "login";

   public static final String FIELD_PASSWORD = "password";

   public static final String FIELD_EMAIL = "email";

   public static final String FIELD_TYPE = "type";

   public static final int MAX_LENGTH_FIRST_NAME = 25;

   public static final int MAX_LENGTH_LAST_NAME = 35;

   public static final int MAX_LENGTH_LOGIN = 15;

   @Id
   @GeneratedValue
   @Column
   private Long id;

   @Column(name = "first_name", nullable = false, length = MAX_LENGTH_FIRST_NAME)
   @Length(max = MAX_LENGTH_FIRST_NAME)
   @NotBlank
   private String firstName;

   @Column(name = "last_name", nullable = false, length = MAX_LENGTH_LAST_NAME)
   @Length(max = MAX_LENGTH_LAST_NAME)
   @NotBlank
   private String lastName;

   @Column(nullable = false, length = MAX_LENGTH_LOGIN)
   @Length(max = MAX_LENGTH_LOGIN)
   @NotBlank
   private String login;

   @Column(nullable = false)
   @NotBlank
   private String password;

   @Column(nullable = false)
   private String email;

   @Column(nullable = false)
   @Enumerated(value = EnumType.ORDINAL)
   @NotNull
   private UserTypeEnum type;

   public Long getId()
   {
      return id;
   }

   public void setId(Long id)
   {
      this.id = id;
   }

   public String getLogin()
   {
      return login;
   }

   public void setLogin(String login)
   {
      this.login = login;
   }

   public String getPassword()
   {
      return password;
   }

   public void setPassword(String password)
   {
      this.password = password;
   }

   public String getEmail()
   {
      return email;
   }

   public void setEmail(String email)
   {
      this.email = email;
   }

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

   public UserTypeEnum getType()
   {
      return type;
   }

   public void setType(UserTypeEnum type)
   {
      this.type = type;
   }
}
