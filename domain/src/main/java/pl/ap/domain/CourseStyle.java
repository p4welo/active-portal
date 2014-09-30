package pl.ap.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by parado on 18.03.14.
 */
@Entity
@Table(name = "style")
public class CourseStyle extends IdentifiableEntity
{
   public static final String FIELD_NAME = "name";

   public static final String FIELD_CATEGORY = "category";

   public static final int MAX_LENGTH_NAME = 128;

   @Id
   @GeneratedValue
   @Column
   private Long id;

   @Column(length = MAX_LENGTH_NAME, nullable = false)
   @NotBlank
   private String name;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "category_id", nullable = false)
   @NotNull
   private CourseCategory category;

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public CourseCategory getCategory()
   {
      return category;
   }

   public void setCategory(CourseCategory category)
   {
      this.category = category;
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
