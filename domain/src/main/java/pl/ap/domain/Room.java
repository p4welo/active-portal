package pl.ap.domain;

import org.hibernate.validator.constraints.Length;
import pl.ap.domain.common.IdentifiableEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by parado on 24.03.14.
 */
@Entity
@Table(name = "room")
public class Room extends IdentifiableEntity
{
   public static final String FIELD_NAME = "name";
   public static final String FIELD_CODE = "code";

   public static final int MAX_LENGTH_CODE = 16;

   @Id
   @GeneratedValue
   @Column
   private Long id;

   @Column(nullable = false)
   @NotNull
   private String name;

   @Column(nullable = false, length = MAX_LENGTH_CODE)
   @Length(max = MAX_LENGTH_CODE)
   @NotNull
   private String code;

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public Long getId()
   {
      return id;
   }

   public void setId(Long id)
   {
      this.id = id;
   }

   public String getCode()
   {
      return code;
   }

   public void setCode(String code)
   {
      this.code = code;
   }
}
