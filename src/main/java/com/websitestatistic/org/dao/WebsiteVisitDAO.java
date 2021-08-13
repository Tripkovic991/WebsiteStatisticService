package com.websitestatistic.org.dao;

import com.websitestatistic.org.dto.WebsiteVisitDTO;
import com.websitestatistic.org.entity.WebsiteVisitEntity;
import javax.persistence.*;
import javax.ws.rs.BadRequestException;
import java.util.List;

public class WebsiteVisitDAO {

    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("WebsiteStatisticPersistence");


    public List<WebsiteVisitEntity> getAllWebsiteVisits() {

        EntityManager entityManager = null;

        try {

            String selectQuery = "SELECT wv FROM  WebsiteVisitEntity wv";

            entityManager = entityManagerFactory.createEntityManager();

            TypedQuery<WebsiteVisitEntity> typedQuery = entityManager.createQuery(selectQuery, WebsiteVisitEntity.class);

            return typedQuery.getResultList();

        } catch (Exception e) {

            throw new BadRequestException(e.getMessage());

        } finally {

            entityManager.close();
        }

    }

    public WebsiteVisitEntity saveWebsiteVisit(WebsiteVisitDTO websiteVisitDTO) {

        EntityTransaction entityTransaction = null;

        EntityManager entityManager = null;

        try {

            entityManager = entityManagerFactory.createEntityManager();

            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();

            WebsiteVisitEntity websiteVisitEntity = new WebsiteVisitEntity(websiteVisitDTO);

            entityManager.persist(websiteVisitEntity);

            entityTransaction.commit();

            return websiteVisitEntity;

        } catch (Exception e) {

            entityTransaction.rollback();

            throw new BadRequestException(e.getMessage());
        } finally {

            entityManager.close();
        }

    }

}
