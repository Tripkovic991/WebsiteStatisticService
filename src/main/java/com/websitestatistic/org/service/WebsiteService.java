package com.websitestatistic.org.service;

import com.websitestatistic.org.dao.WebsiteDAO;
import com.websitestatistic.org.dto.ReportSiteDTO;
import com.websitestatistic.org.dto.ReportWebsiteVisitDTO;
import com.websitestatistic.org.dto.WebsiteDTO;
import com.websitestatistic.org.entity.WebsiteEntity;

import java.util.List;
import java.util.stream.Collectors;

public class WebsiteService {


    public List<WebsiteDTO> getAllWebsites() {

        WebsiteDAO websiteDAO = new WebsiteDAO();

        return websiteDAO.getAllWebsites().stream()
                .map(websiteEntity -> new WebsiteDTO(websiteEntity))
                .collect(Collectors.toList());

    }

    public WebsiteDTO saveWebsite(WebsiteDTO websiteDTO) {

        WebsiteDAO websiteDAO = new WebsiteDAO();

        return new WebsiteDTO(websiteDAO.saveWebsite(websiteDTO));

    }

    public ReportSiteDTO getReportForWebsite(Long id) {

        WebsiteDAO websiteDAO = new WebsiteDAO();

        WebsiteEntity websiteEntity = websiteDAO.getAllWebsitesReportById(id);

        ReportSiteDTO reportSiteDTO = new ReportSiteDTO(websiteEntity);

        reportSiteDTO.setData(websiteEntity.getWebsiteVisitEntity().stream()
                .map(websiteVisitEntity -> new ReportWebsiteVisitDTO(websiteVisitEntity)).collect(Collectors.toList()));

        return reportSiteDTO;

    }


}
