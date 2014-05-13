package co.radomski.setenta.server.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * User: pawel.radomski
 * Date: 06.09.13
 * Time: 15:22
 */
public class TrustedUsernamePasswordAuthenticationToken extends UsernamePasswordAuthenticationToken
{
   public TrustedUsernamePasswordAuthenticationToken(Object principal, Object credentials)
   {
      super(principal, credentials);
   }

}
