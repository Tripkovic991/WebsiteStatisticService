package com.websitestatistic.org.controller;

import com.websitestatistic.org.dto.WebsiteDTO;
import com.websitestatistic.org.service.WebsiteService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/website")
public class WebsiteController {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<WebsiteDTO> getAllWebsites() {

        WebsiteService websiteService = new WebsiteService();

        return websiteService.getAllWebsites();

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public WebsiteDTO createWebsite(WebsiteDTO websiteDTO) {

        WebsiteService websiteService = new WebsiteService();

        return websiteService.saveWebsite(websiteDTO);
    }

}
