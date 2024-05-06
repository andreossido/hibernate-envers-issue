package org.example;

import org.example.entity.AbstractComponentEntity;
import org.example.entity.ConfigurationComponentEntity;
import org.example.entity.ConfigurationComponentHasComponentEntity;
import org.example.entity.ProductComponentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
            Session session = sessionFactory.openSession();

            var transaction = session.beginTransaction();

            var productComponentEntity = new ProductComponentEntity();
            var configurationComponentHasComponentEntity = new ConfigurationComponentHasComponentEntity();
            configurationComponentHasComponentEntity.setComponent(productComponentEntity);

            var configurationComponentEntity = new ConfigurationComponentEntity();
            configurationComponentEntity.setChildComponents(List.of(configurationComponentHasComponentEntity));

            session.persist(configurationComponentEntity);
            transaction.commit();

            AuditReader auditReader = AuditReaderFactory.get(sessionFactory.createEntityManager());

            auditReader.createQuery()
                       .forRevisionsOfEntity(AbstractComponentEntity.class, false, false)
                       // .add(AuditEntity.id().eq(1))
                       .getResultList();
        }
    }
}