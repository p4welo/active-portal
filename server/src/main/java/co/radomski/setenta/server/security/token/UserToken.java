package co.radomski.setenta.server.security.token;

public class UserToken implements IToken
{
   public static final String USER_TOKEN_KEY = "ut";

   public static long DEFAULT_EXPIRY_TIME = 1209600000l; // two weeks by default;

   private String principal;

   private long expiryTime;

   public UserToken(String principal)
   {
      this(principal, DEFAULT_EXPIRY_TIME);
   }

   public UserToken(String principal, long expiryTime)
   {
      this.principal = principal;
      this.expiryTime = expiryTime;
   }

   @Override
   public String getPrincipal()
   {
      return principal;
   }

   @Override
   public long getExpiryTime()
   {
      return expiryTime;
   }

}
