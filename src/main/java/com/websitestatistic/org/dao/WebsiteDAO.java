package com.websitestatistic.org.dao;

import com.websitestatistic.org.dto.WebsiteDTO;
import com.websitestatistic.org.entity.WebsiteEntity;

import javax.persistence.*;
import javax.ws.rs.BadRequestException;
import java.time.LocalDate;
import java.util.List;

public class WebsiteDAO {

    public WebsiteDAO() {
    }

    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("WebsiteStatisticPersistence");


    public List<WebsiteEntity> getAllWebsites() {

        EntityManager entityManager = null;

        try {

            String selectQuery = "SELECT w FROM  WebsiteEntity w";

            entityManager = entityManagerFactory.createEntityManager();

            TypedQuery<WebsiteEntity> typedQuery = entityManager.createQuery(selectQuery, WebsiteEntity.class);

            return typedQuery.getResultList();

        } catch (Exception e) {

            throw new RuntimeException(e.getMessage());

        } finally {

            entityManager.close();
        }

    }

    public WebsiteEntity getAllWebsitesReportById(Long id) {

        EntityManager entityManager = null;

        try {

            String selectQuery = "SELECT w FROM  WebsiteEntity w left join w.websiteVisitEntity wv WHERE w.id = :wid and wv.visitDate BETWEEN :startDate AND :endDate";

            entityManager = entityManagerFactory.createEntityManager();

            LocalDate initial = LocalDate.now();
            LocalDate start = initial.withDayOfMonth(1);
            LocalDate end = initial.withDayOfMonth(initial.lengthOfMonth());

            TypedQuery<WebsiteEntity> typedQuery = entityManager.createQuery(selectQuery, WebsiteEntity.class);
            typedQuery.setParameter("wid", id);
            typedQuery.setParameter("startDate", start);
            typedQuery.setParameter("endDate", end);

            return typedQuery.getSingleResult();

        } catch (Exception e) {

            throw new BadRequestException(e.getMessage());

        } finally {

            entityManager.close();
        }

    }

    public WebsiteEntity saveWebsite(WebsiteDTO websiteDTO) {

        EntityTransaction entityTransaction = null;

        EntityManager entityManager = null;

        try {

            entityManager = entityManagerFactory.createEntityManager();

            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();

            WebsiteEntity websiteEntity = new WebsiteEntity(websiteDTO);

            entityManager.persist(websiteEntity);

            entityTransaction.commit();

            return websiteEntity;

        } catch (Exception e) {

            entityTransaction.rollback();

            throw new BadRequestException(e.getMessage());
        } finally {

            entityManager.close();
        }


    }
}
