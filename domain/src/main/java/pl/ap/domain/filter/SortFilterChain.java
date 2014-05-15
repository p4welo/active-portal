package pl.ap.domain.filter;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class SortFilterChain implements Serializable
{
   private static final long serialVersionUID = -7625899492348081465L;

   private String field;

   private boolean ascending = true;

   private SortFilterChain next;

   public SortFilterChain()
   {
   }

   public SortFilterChain(String field, boolean descending)
   {
      this.field = field;
      this.ascending = descending;
   }

   public SortFilterChain append(SortFilterChain sortFilterChain)
   {
      next = sortFilterChain;
      return this;
   }

   public String getField()
   {
      return field;
   }

   public void setField(String field)
   {
      this.field = field;
   }

   public boolean isAscending()
   {
      return ascending;
   }

   public void setAscending(boolean ascending)
   {
      this.ascending = ascending;
   }

   public SortFilterChain getNext()
   {
      return next;
   }

   public void setNext(SortFilterChain next)
   {
      this.next = next;
   }

   @Override
   public String toString()
   {
      return new ToStringBuilder(this)
              .append("field", field)
              .append("ascending", ascending)
              .append("next", next)
              .toString();
   }
}
