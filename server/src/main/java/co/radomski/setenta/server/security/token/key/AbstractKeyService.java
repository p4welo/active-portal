package co.radomski.setenta.server.security.token.key;

import co.radomski.setenta.server.security.MasterKey;
import co.radomski.setenta.server.security.token.CryptoConstants;
import org.springframework.beans.factory.InitializingBean;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.SecretKeySpec;

public abstract class AbstractKeyService implements InitializingBean
{

   private Cipher masterCipher;

   @Override
   public void afterPropertiesSet() throws Exception
   {
      masterCipher = Cipher.getInstance(CryptoConstants.KEY_ALGORITHM);
      SecretKeySpec masterSecretKey = new SecretKeySpec(MasterKey.MASTER_SECRET,
              CryptoConstants.KEY_ALGORITHM);
      masterCipher.init(getCipherMode(), masterSecretKey);
   }

   protected byte[] doFinal(byte[] input) throws IllegalBlockSizeException, BadPaddingException
   {
      return masterCipher.doFinal(input);
   }

   protected abstract int getCipherMode();
}
