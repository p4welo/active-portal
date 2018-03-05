package pl.ap.domain.validation;

import org.hibernate.Session;

public interface ISessionProvider
{
   Session getCurrentSession();
}
