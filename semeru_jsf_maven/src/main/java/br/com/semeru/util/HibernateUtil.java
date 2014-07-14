package br.com.semeru.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.service.spi.ServiceRegistryImplementor;

/**
 *
 * @author elvio
 */
public class HibernateUtil {
    
    private static final SessionFactory sessionfactory;
    
    public static final String HIBERNATE_SESSION = "hibernate_session";
    
    static {
        try {   
            
            System.out.println("Tentando Configurar a SESSION_FACTORY!!");
            sessionfactory = new AnnotationConfiguration().configure().buildSessionFactory();
            
            System.out.println("Sucesso na criação da SESSION_FACTORY!!");
        
        } catch (Exception ex) {
            
            System.err.println("Falha na inicialização da SessionFactory");
            throw  new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionfactory;
    }
}
