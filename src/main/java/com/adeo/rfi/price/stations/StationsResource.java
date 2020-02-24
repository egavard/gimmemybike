package com.adeo.rfi.price.stations;

import com.adeo.rfi.price.stations.model.StationModel;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameters;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/stations")
public class StationsResource {

    @Inject
    private StationService stationService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Parameters({@Parameter(name = "p", description = "Page number"), @Parameter(name = "s", description = "Page size")})
    public List<StationModel> getStations(@QueryParam("p") Integer page, @QueryParam("s") Integer size) {
        return stationService.getStations(page, size);
    }

    @GET
    @Path("/commune/{commune}")
    @Produces(MediaType.APPLICATION_JSON)
    @Parameters({
            @Parameter(name = "p", description = "Page number"),
            @Parameter(name = "s", description = "Page size"),
            @Parameter(name = "commune", description = "Commune de recherche")})
    public List<StationModel> getStationsByCommune(@PathParam("commune") String commune, @QueryParam("p") Integer page, @QueryParam("s") Integer size) {
        return stationService.getStationsByCommune(commune, page, size);
    }
}
