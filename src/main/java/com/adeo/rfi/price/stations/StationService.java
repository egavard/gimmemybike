package com.adeo.rfi.price.stations;

import com.adeo.rfi.price.StationsRestClient;
import com.adeo.rfi.price.stations.model.ApiResponseWrapper;
import com.adeo.rfi.price.stations.model.StationModel;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

import static java.util.stream.Collectors.toList;

@ApplicationScoped
public class StationService {

    @Inject
    @RestClient
    StationsRestClient stationsRestClient;

    public List<StationModel> getStations(Integer page, Integer size) {
        ApiResponseWrapper<StationModel> response = stationsRestClient.get(size, page);
        return response.getRecords().stream().map(recordW -> recordW.getRecord().getFields()).collect(toList());
    }

    public List<StationModel> getStationsByCommune(String commune, Integer page, Integer size) {
        ApiResponseWrapper<StationModel> response = stationsRestClient.getByWhere(size, page, QueryWrapper.findByCommune(commune.toUpperCase()));
        return response.getRecords().stream().map(recordW -> recordW.getRecord().getFields()).collect(toList());
    }

    public boolean hasNext(String commune, int page, int size) {
        ApiResponseWrapper<StationModel> response = stationsRestClient.getByWhere(size, page, QueryWrapper.findByCommune(commune.toUpperCase()));

        return (page + 2) * size <= response.getTotal_count();
    }

    public static boolean hasPrevious(int page, int size) {
        return (page - 1) >= 0;
    }

    public static String generateLinkPrevious(String commune, int page, int size) {
        return String.format("/search?commune=%s&p=%d&s=%d", commune, --page, size);
    }

    public static String generateLinkNext(String commune, int page, int size) {
        return String.format("/search?commune=%s&p=%d&s=%d", commune, ++page, size);
    }


}
