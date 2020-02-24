package com.adeo.rfi.price;

import com.adeo.rfi.price.stations.model.ApiResponseWrapper;
import com.adeo.rfi.price.stations.model.StationModel;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@RegisterRestClient(configKey="vlille-api")
@Path("/api/v2/catalog/datasets/vlille-realtime/records")
public interface StationsRestClient {

    @GET
    @Produces(APPLICATION_JSON)
    ApiResponseWrapper<StationModel> get(@QueryParam("rows") Integer rows, @QueryParam("start") Integer start);

    @GET
    @Produces(APPLICATION_JSON)
    ApiResponseWrapper<StationModel> getByWhere(@QueryParam("rows") Integer rows, @QueryParam("start") Integer start, @QueryParam("where") String query);
}
