package co.radomski.setenta.server.security.token;

public interface IToken
{
   String getPrincipal();

   long getExpiryTime();
}
