package com.websitestatistic.org.service;

import com.websitestatistic.org.dao.WebsiteVisitDAO;
import com.websitestatistic.org.dto.WebsiteVisitDTO;

import java.util.List;
import java.util.stream.Collectors;

public class WebsiteVisitService {

    public List<WebsiteVisitDTO> getAllWebsiteVisits() {

        WebsiteVisitDAO websiteVisitDAO = new WebsiteVisitDAO();

        return websiteVisitDAO.getAllWebsiteVisits().stream()
                .map(websiteVisitEntity -> new WebsiteVisitDTO(websiteVisitEntity)).collect(Collectors.toList());

    }

    public WebsiteVisitDTO saveWebsiteVisit(WebsiteVisitDTO websiteVisitDTO) {

        WebsiteVisitDAO websiteVisitDAO = new WebsiteVisitDAO();

        return new WebsiteVisitDTO(websiteVisitDAO.saveWebsiteVisit(websiteVisitDTO));

    }


}
