package co.radomski.setenta.server.security.token.encryptor;

import co.radomski.setenta.server.security.token.CryptoConstants;
import co.radomski.setenta.server.security.token.exception.EncryptorException;
import co.radomski.setenta.server.security.token.key.KeyService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Random;

@Component(BasicEncryptor.BEAN_NAME)
public class BasicEncryptor
{
   public static final String BEAN_NAME = "basicEncryptor";

   @Resource
   private KeyService keyService;

   private Random rnd = new Random();

   public byte[] encrypt(byte[] input) throws EncryptorException
   {
      try
      {
         Cipher cipher = Cipher.getInstance(CryptoConstants.PADDED_ENCRYPTION_ALGORITHM);
         byte index = (byte) rnd.nextInt(keyService.getSize());
         Key tokenKey = keyService.getKey(index);
         cipher.init(Cipher.ENCRYPT_MODE, tokenKey, new IvParameterSpec(new byte[cipher.getBlockSize()]));
         byte[] combinedInput = combineInput(input, tokenKey, getMacLength(cipher));
         byte[] cipherText = cipher.doFinal(combinedInput);
         byte[] cipherTextWithKeyId = new byte[cipherText.length + 1];
         cipherTextWithKeyId[0] = index;
         System.arraycopy(cipherText, 0, cipherTextWithKeyId, 1, cipherText.length);
         return cipherTextWithKeyId;
      }
      catch (Exception e)
      {
         throw new EncryptorException(e.getMessage());
      }
   }

   public byte[] decrypt(byte[] input) throws EncryptorException
   {
      try
      {
         Cipher cipher = Cipher.getInstance(CryptoConstants.PADDED_ENCRYPTION_ALGORITHM);
         Key tokenKey = keyService.getKey(input[0]);
         if (tokenKey == null)
         {
            throw new EncryptorException("Could not find key");
         }
         cipher.init(Cipher.DECRYPT_MODE, tokenKey, new IvParameterSpec(new byte[cipher.getBlockSize()]));
         byte[] bytesToDecrypt = new byte[input.length - 1];
         System.arraycopy(input, 1, bytesToDecrypt, 0, input.length - 1);
         byte[] decryptedBytes = cipher.doFinal(bytesToDecrypt);
         if (decryptedBytes[0] != getVersion())
         {
            throw new EncryptorException("Invalid version number");
         }
         byte[] bytesToMac = new byte[decryptedBytes.length - getMacLength(cipher) - 1];
         System.arraycopy(decryptedBytes, 1, bytesToMac, 0, decryptedBytes.length - getMacLength(cipher) - 1);
         byte[] realMac = getMac(bytesToMac, tokenKey);
         byte[] suppliedMac = new byte[getMacLength(cipher)];
         System.arraycopy(decryptedBytes, decryptedBytes.length - getMacLength(cipher), suppliedMac, 0,
                 getMacLength(cipher));
         if (!compareByteArrays(suppliedMac, realMac))
         {
            throw new EncryptorException("Invalid mac");
         }
         byte[] output = new byte[decryptedBytes.length - getMacLength(cipher) - 1];
         System.arraycopy(decryptedBytes, 1, output, 0, output.length);
         return output;
      }
      catch (Exception e)
      {
         throw new EncryptorException(e.getMessage());
      }
   }

   private boolean compareByteArrays(byte[] suppliedMac, byte[] realMac)
   {
      for (int i = 0; i < suppliedMac.length; i++)
      {
         if (i >= realMac.length || suppliedMac[i] != realMac[i])
         {
            return false;
         }
      }
      return true;
   }

   private int getMacLength(Cipher cipher)
   {
      return cipher.getBlockSize() - 1;
   }

   private byte[] combineInput(byte[] input, Key tokenKey, int macLength) throws EncryptorException
   {
      byte[] output = new byte[1 + input.length + macLength];
      output[0] = getVersion();
      byte[] mac = getMac(input, tokenKey);
      System.arraycopy(input, 0, output, 1, input.length);
      System.arraycopy(mac, 0, output, input.length + 1, macLength);
      return output;
   }

   protected byte[] getMac(byte[] input, Key tokenKey) throws EncryptorException
   {
      try
      {
         Mac mac = Mac.getInstance(CryptoConstants.MAC_ALGORITHM);
         mac.init(new SecretKeySpec(tokenKey.getEncoded(), CryptoConstants.KEY_ALGORITHM));
         return mac.doFinal(input);
      }
      catch (Exception e)
      {
         throw new EncryptorException(e.getMessage());
      }
   }

   protected byte getVersion()
   {
      return 0;
   }

}
