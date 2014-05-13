package co.radomski.setenta.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 20.05.13
 * Time: 23:43
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "email")
public class Email extends IdentifiableEntity
{
   public static final String FIELD_SENDER = "sender";

   public static final String FIELD_SUBJECT = "subject";

   public static final String FIELD_CONTENT = "content";

   @Id
   @GeneratedValue
   @Column
   private Long id;

   @Column
   private String sender;

   private String to[];

   private String[] cc = new String[]{};

   private String replyTo = new String();

   @Column
   @NotBlank
   private String subject;

   @Column
   @NotBlank
   private String content;

   public Email()
   {
   }

   public Email(String sender, String[] to, String subject, String content)
   {
      this.sender = sender;
      this.to = to;
      this.subject = subject;
      this.content = content;
   }

   public Long getId()
   {
      return id;
   }

   public void setId(Long id)
   {
      this.id = id;
   }

   public String getSender()
   {
      return sender;
   }

   public void setSender(String sender)
   {
      this.sender = sender;
   }

   public String[] getTo()
   {
      return to;
   }

   public void setTo(String[] to)
   {
      this.to = to;
   }

   public String[] getCc()
   {
      return cc;
   }

   public void setCc(String[] cc)
   {
      this.cc = cc;
   }

   public String getReplyTo()
   {
      return replyTo;
   }

   public void setReplyTo(String replyTo)
   {
      this.replyTo = replyTo;
   }

   public String getSubject()
   {
      return subject;
   }

   public void setSubject(String subject)
   {
      this.subject = subject;
   }

   public String getContent()
   {
      return content;
   }

   public void setContent(String content)
   {
      this.content = content;
   }
}
