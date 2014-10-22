package pl.ap.domain.validation.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pl.ap.domain.validation.ISessionProvider;

public class SessionProviderImpl implements ISessionProvider
{
   private SessionFactory sessionFactory;

   @Override
   public Session getCurrentSession()
   {
      return sessionFactory.getCurrentSession();
   }

   public SessionFactory getSessionFactory()
   {
      return sessionFactory;
   }

   public void setSessionFactory(SessionFactory sessionFactory)
   {
      this.sessionFactory = sessionFactory;
   }
}
