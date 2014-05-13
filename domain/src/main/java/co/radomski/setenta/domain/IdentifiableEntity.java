package co.radomski.setenta.domain;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

/**
 * User: pawel
 * Date: 12.04.13
 * Time: 23:16
 */
@MappedSuperclass
public abstract class IdentifiableEntity extends DataEntity
{
   public static final String NON_UNIQUE_SID_MESSAGE = "sid.not.unique";

   public static final String FIELD_SID = "sid";

   @Column(nullable = false, length = 32)
   @Length(max = 32)
   @NotNull
   protected String sid;

   public String getSid()
   {
      return sid;
   }

   public void setSid(String sid)
   {
      this.sid = sid;
   }

   @Override
   public boolean equals(Object obj)
   {
      if (obj instanceof IdentifiableEntity)
      {
         return StringUtils.equals(sid, ((IdentifiableEntity) obj).getSid());
      }
      else if (obj instanceof DataEntity)
      {
         return getId() == ((DataEntity) obj).getId();
      }
      else
      {
         return super.equals(obj);
      }
   }
}
