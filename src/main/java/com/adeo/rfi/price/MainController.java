package com.adeo.rfi.price;

import com.adeo.rfi.price.stations.StationService;
import com.adeo.rfi.price.stations.model.StationModel;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateExtension;
import io.quarkus.qute.TemplateInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.List;

@Path("")
public class MainController {

    @Inject
    Template index;

    @Inject
    StationService stationService;

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        return index.instance();
    }

    @GET
    @Path("/search")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance after(@QueryParam("commune") String commune, @QueryParam(value = "p") int page, @QueryParam("s") int size) {
        List<StationModel> stations = stationService.getStationsByCommune(commune, page, size);
        LOGGER.info("Retrieved {} stations", stations.size());
        return index
                .data("commune", commune)
                .data("stations", stations)
                .data("results", stations.size())
                .data("previousLink", StationService.generateLinkPrevious(commune, page, size))
                .data("nextLink", StationService.generateLinkNext(commune, page, size))
                .data("hasNext", stationService.hasNext(commune, page, size))
                .data("hasPrevious", StationService.hasPrevious(page, size));
    }

    @TemplateExtension
    static BigDecimal discountedPrice(StationModel station) {
        return BigDecimal.ZERO;
    }


}

class IndexRequest {
    private String commune;

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }
}
