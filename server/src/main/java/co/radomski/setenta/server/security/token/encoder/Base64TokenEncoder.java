package co.radomski.setenta.server.security.token.encoder;

import org.springframework.security.crypto.codec.Base64;

public class Base64TokenEncoder implements ITokenEncoder
{

   @Override
   public String convert(byte[] token)
   {
      return new String(Base64.encode(token));
   }

   @Override
   public byte[] convert(String token)
   {
      return Base64.decode(token.getBytes());
   }
}