package co.radomski.setenta.domain;

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

   @Id
   @GeneratedValue
   @Column
   private Long id;

   @Column(nullable = false)
   @NotNull
   private String name;

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
}
