/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentelproject.lk.ijse.rent.model;

/**
 *
 * @author Nipun
 */
public class Transport {
    private String transport_id ;
    private double transport_cost ;
    private double distance ;

    public Transport() {
    }

    public Transport(String transport_id, double transport_cost, double distance) {
        this.transport_id = transport_id;
        this.transport_cost = transport_cost;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Transport{" + "transport_id=" + getTransport_id() + ", transport_cost=" + getTransport_cost() + ", distance=" + getDistance() + '}';
    }

    /**
     * @return the transport_id
     */
    public String getTransport_id() {
        return transport_id;
    }

    /**
     * @param transport_id the transport_id to set
     */
    public void setTransport_id(String transport_id) {
        this.transport_id = transport_id;
    }

    /**
     * @return the transport_cost
     */
    public double getTransport_cost() {
        return transport_cost;
    }

    /**
     * @param transport_cost the transport_cost to set
     */
    public void setTransport_cost(double transport_cost) {
        this.transport_cost = transport_cost;
    }

    /**
     * @return the distance
     */
    public double getDistance() {
        return distance;
    }

    /**
     * @param distance the distance to set
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    
        
}
