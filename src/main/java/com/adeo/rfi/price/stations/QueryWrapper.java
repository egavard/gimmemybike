package com.adeo.rfi.price.stations;

public class QueryWrapper {

    private static String communeQuery = "commune=\"%s\"";
    private static String typeQuery = "type=\"AVEC TPE\"";
    private static String joinQuery = "%s AND %s";

    /**
     * Returns the formatted string that allows to search stations by commune
     *
     * @param commune
     * @return
     */
    public static String findByCommune(String commune) {
        return String.format(communeQuery, commune);
    }

    public static String findByHasTPE() {
        return typeQuery;
    }

    /**
     * Returns the string that joins the two queries
     *
     * @param query1
     * @param query2
     * @return
     */
    public static String joinQueries(String query1, String query2) {
        return String.format(joinQuery, query1, query2);
    }
}
