package ru.netcracker.travelplanner.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity(name="Routes")
@Table(name="routes")
public class Route {
    @Id
    @Column(name="id", length = 6, nullable = false)
    @GeneratedValue(generator = "increment")
    private long id;
    @Column(name="user_id", nullable = false)
    private long userId;
    @Column(name="creation_date", nullable = false)
    private Date CreationDate;
    @Column(name="start_point", nullable = false)
    private String StartPoint;
    @Column(name="destination_point", nullable = false)
    private String DestinationPoint;
    @Column(name="route_type", nullable = false)
    private int routeType;
}
