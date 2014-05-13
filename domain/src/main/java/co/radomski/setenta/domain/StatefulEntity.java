package co.radomski.setenta.domain;

import co.radomski.setenta.domain.enums.ObjectStateEnum;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 22.04.13
 * Time: 20:46
 * To change this template use File | Settings | File Templates.
 */
@MappedSuperclass
public abstract class StatefulEntity extends DataEntity
{
   public static final String FIELD_OBJECT_STATE = "objectState";

   @Column(name = "object_state", nullable = false)
   @Enumerated(value = EnumType.STRING)
   @NotNull
   protected ObjectStateEnum objectState;

   public ObjectStateEnum getObjectState()
   {
      return objectState;
   }

   public void setObjectState(ObjectStateEnum objectState)
   {
      this.objectState = objectState;
   }
}
