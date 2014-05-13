package co.radomski.setenta.server.security.token;

public class TokenParseException extends Exception
{

   public TokenParseException(String message)
   {
      super(message);
   }

   public TokenParseException(String message, Throwable cause)
   {
      super(message, cause);
   }
}
