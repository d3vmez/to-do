package com.todo.serviceSOA.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	public static SessionFactory buildSessionFactory() {
		
		// Crear una instancia de configuración y linkear el archivo
		// de configuración xml
		Configuration configObj = new Configuration();
		configObj.configure("hibernate.cfg.xml");
		
		// Crear la sesión
		SessionFactory sessionFactory = null;
		// En la versión 5.6.1 de Hibernate es necesario usar StandardServiceRegistry y MetadaData
		StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder() .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();
        return sessionFactory;

	}

}
