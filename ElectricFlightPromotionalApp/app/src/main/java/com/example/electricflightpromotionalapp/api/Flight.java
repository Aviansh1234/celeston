package com.example.electricflightpromotionalapp.api;

public class Flight {
    String icao24, estDepartureAirport, estArrivalAirport, callsign;
    int firstSeen, lastSeen, estDepartureAirportHorizDistance, estDepartureAirportVertDistance, estArrivalAirportHorizDistance, estArrivalAirportVertDistance, departureAirportCandidatesCount, arrivalAirportCandidatesCount;

    public String getIcao24() {
        return icao24;
    }

    public void setIcao24(String icao24) {
        this.icao24 = icao24;
    }

    public String getEstDepartureAirport() {
        return estDepartureAirport;
    }

    public void setEstDepartureAirport(String estDepartureAirport) {
        this.estDepartureAirport = estDepartureAirport;
    }

    public String getEstArrivalAirport() {
        return estArrivalAirport;
    }

    public void setEstArrivalAirport(String estArrivalAirport) {
        this.estArrivalAirport = estArrivalAirport;
    }

    public String getCallsign() {
        return callsign;
    }

    public void setCallsign(String callsign) {
        this.callsign = callsign;
    }

    public int getFirstSeen() {
        return firstSeen;
    }

    public void setFirstSeen(int firstSeen) {
        this.firstSeen = firstSeen;
    }

    public int getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(int lastSeen) {
        this.lastSeen = lastSeen;
    }

    public int getEstDepartureAirportHorizDistance() {
        return estDepartureAirportHorizDistance;
    }

    public void setEstDepartureAirportHorizDistance(int estDepartureAirportHorizDistance) {
        this.estDepartureAirportHorizDistance = estDepartureAirportHorizDistance;
    }

    public int getEstDepartureAirportVertDistance() {
        return estDepartureAirportVertDistance;
    }

    public void setEstDepartureAirportVertDistance(int estDepartureAirportVertDistance) {
        this.estDepartureAirportVertDistance = estDepartureAirportVertDistance;
    }

    public int getEstArrivalAirportHorizDistance() {
        return estArrivalAirportHorizDistance;
    }

    public void setEstArrivalAirportHorizDistance(int estArrivalAirportHorizDistance) {
        this.estArrivalAirportHorizDistance = estArrivalAirportHorizDistance;
    }

    public int getEstArrivalAirportVertDistance() {
        return estArrivalAirportVertDistance;
    }

    public void setEstArrivalAirportVertDistance(int estArrivalAirportVertDistance) {
        this.estArrivalAirportVertDistance = estArrivalAirportVertDistance;
    }

    public int getDepartureAirportCandidatesCount() {
        return departureAirportCandidatesCount;
    }

    public void setDepartureAirportCandidatesCount(int departureAirportCandidatesCount) {
        this.departureAirportCandidatesCount = departureAirportCandidatesCount;
    }

    public int getArrivalAirportCandidatesCount() {
        return arrivalAirportCandidatesCount;
    }

    public void setArrivalAirportCandidatesCount(int arrivalAirportCandidatesCount) {
        this.arrivalAirportCandidatesCount = arrivalAirportCandidatesCount;
    }
}
