package co.radomski.setenta.server.security.token.encoder;

public interface ITokenEncoder
{
   String convert(byte[] token);

   byte[] convert(String token);
}
