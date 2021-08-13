package com.websitestatistic.org.controller;

import com.websitestatistic.org.dto.WebsiteVisitDTO;
import com.websitestatistic.org.service.WebsiteVisitService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/websiteVisit")
public class WebsiteVisitController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<WebsiteVisitDTO> getAllWebsiteVisits() {

        WebsiteVisitService websiteVisitService = new WebsiteVisitService();

        return websiteVisitService.getAllWebsiteVisits();

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public WebsiteVisitDTO createWebsiteVisit(WebsiteVisitDTO websiteVisitDTO) {

        WebsiteVisitService websiteVisitService = new WebsiteVisitService();

        return websiteVisitService.saveWebsiteVisit(websiteVisitDTO);
    }


}
