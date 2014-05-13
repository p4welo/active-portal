package co.radomski.setenta.server.security.token.converter;

import co.radomski.setenta.server.security.token.TokenParseException;

public interface ITokenConverter<T>
{
   boolean supports(String token);

   boolean supports(Class tokenClass);

   T convert(String token) throws TokenParseException;

   String convert(T token) throws TokenParseException;
}
