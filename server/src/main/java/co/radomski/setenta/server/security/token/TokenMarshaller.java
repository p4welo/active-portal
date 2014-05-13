package co.radomski.setenta.server.security.token;

import co.radomski.setenta.server.security.token.converter.ITokenConverter;
import co.radomski.setenta.server.security.token.encoder.ITokenEncoder;
import co.radomski.setenta.server.security.token.encryptor.BasicEncryptor;
import co.radomski.setenta.server.security.token.exception.EncryptorException;
import org.apache.commons.lang3.StringUtils;

public class TokenMarshaller
{
   public static final String BEAN_NAME = "tokenMarshaller";

   private BasicEncryptor tokenCrypto;

   private ITokenEncoder tokenEncoder;

   private ITokenConverter<IToken> tokenConverter;

   public IToken unmarshall(String token) throws TokenParseException
   {
      assertNotEmpty(token);
      byte[] result = new byte[0];
      try
      {
         result = tokenCrypto.decrypt(tokenEncoder.convert(token));
      }
      catch (EncryptorException e)
      {
         throw new TokenParseException(e.getMessage(), e);
      }
      return tokenConverter.convert(new String(result));
   }

   public String marshall(IToken token) throws TokenParseException
   {
      String convertedTokenString = tokenConverter.convert(token);
      assertNotEmpty(convertedTokenString);
      byte[] result = new byte[0];
      try
      {
         result = tokenCrypto.encrypt(convertedTokenString.getBytes());
      }
      catch (EncryptorException e)
      {
         throw new TokenParseException(e.getMessage(), e);
      }
      return tokenEncoder.convert(result);
   }

   @SuppressWarnings(
           {
                   "rawtypes", "unchecked"
           })
   public void setTokenConverter(ITokenConverter tokenConverter)
   {
      this.tokenConverter = tokenConverter;
   }

   public void setTokenCrypto(BasicEncryptor tokenCrypto)
   {
      this.tokenCrypto = tokenCrypto;
   }

   public void setTokenEncoder(ITokenEncoder tokenEncoder)
   {
      this.tokenEncoder = tokenEncoder;
   }

   private void assertNotEmpty(String token) throws TokenParseException
   {
      if (StringUtils.isEmpty(token))
      {
         throw new TokenParseException("Token cannot be decrypted because it is empty!");
      }
   }
}
