package co.radomski.setenta.server.security.token;

public class InvitationToken implements IToken
{
   private String principal;

   private long expiryTime;

   public static final String INVITATION_TOKEN_KEY = "it";

   public InvitationToken(String principal, long expiryTime)
   {
      this.principal = principal;
      this.expiryTime = expiryTime;
   }

   public void setPrincipal(String principal)
   {
      this.principal = principal;
   }

   @Override
   public String getPrincipal()
   {
      return principal;
   }

   public void setExpiryTime(long expiryTime)
   {
      this.expiryTime = expiryTime;
   }

   @Override
   public long getExpiryTime()
   {
      return expiryTime;
   }

}
