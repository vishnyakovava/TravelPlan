package ru.netcracker.travelPlanner.entities;

import org.postgresql.geometric.PGpoint;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="routes")
public class Route implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "routes_seq")
    @SequenceGenerator(name = "routes_seq", sequenceName = "route_id_seq")
    private Integer id;

    @Column(name="creation_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name="start_point", nullable = false)
    private PGpoint startPoint;

    @Column(name="destination_point", nullable = false)
    private PGpoint destinationPoint;

    @Column(name="route_type", nullable = false)
    private Short routeType;

    public Route() {
    }

    public Route(Date creationDate, PGpoint startPoint, PGpoint destinationPoint, Short routeType) {
        this.creationDate = creationDate;
        this.startPoint = startPoint;
        this.destinationPoint = destinationPoint;
        this.routeType = routeType;
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

    public Short getRouteType() {
        return routeType;
    }

    public void setRouteType(Short routeType) {
        this.routeType = routeType;
    }
}
