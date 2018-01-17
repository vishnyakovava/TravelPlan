package ru.netcracker.travelPlanner.entities;

import org.postgresql.geometric.PGpoint;
import org.postgresql.util.PGInterval;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="edges")
public class Edge implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "edges_seq")
    @SequenceGenerator(name = "edges_seq", sequenceName = "edge_id_seq")
    private Integer id;

    @Column(name="creation_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name="start_point", nullable = false)
    private PGpoint startPoint;

    @Column(name="destination_point", nullable = false)
    private PGpoint destinationPoint;

    @Column(name="transport_type", nullable = false)
    private Short transportType;

    @Column(nullable = false)
    private PGInterval duration;

    @Column(nullable = false)
    private Integer cost;

    @Column(nullable = false)
    private Integer distance;

    @Column(name = "start_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    public Edge() {
    }

    public Edge(Date creationDate, PGpoint startPoint, PGpoint destinationPoint, short transportType, PGInterval duration, int cost, int distance, Date startDate, Date endDate) {
        this.creationDate = creationDate;
        this.startPoint = startPoint;
        this.destinationPoint = destinationPoint;
        this.transportType = transportType;
        this.duration = duration;
        this.cost = cost;
        this.distance = distance;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public PGpoint getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(PGpoint startPoint) {
        this.startPoint = startPoint;
    }

    public PGpoint getDestinationPoint() {
        return destinationPoint;
    }

    public void setDestinationPoint(PGpoint destinationPoint) {
        this.destinationPoint = destinationPoint;
    }

    public Short getTransportType() {
        return transportType;
    }

    public void setTransportType(short transportType) {
        this.transportType = transportType;
    }

    public PGInterval getDuration() {
        return duration;
    }

    public void setDuration(PGInterval duration) {
        this.duration = duration;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
