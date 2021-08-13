package com.websitestatistic.org.controller;

import com.websitestatistic.org.dto.ReportSiteDTO;
import com.websitestatistic.org.service.WebsiteService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/report")
public class VisitReportController {


    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ReportSiteDTO getAllVisitsFromCurrentMount(@PathParam("id") Long id) {

        WebsiteService websiteService = new WebsiteService();


        return websiteService.getReportForWebsite(id);
    }

}
