package ru.netcracker.travelplanner.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity(name="Edges")
@Table(name="edges")
public class Edge {
    @Id
    @Column(name="id", length = 6, nullable = false)
    @GeneratedValue(generator = "increment")
    private long id;
    @Column(name="creation_date", nullable = false)
    private Date CreationDate;
    @Column(name="start_point", nullable = false)
    private String StartPoint;
    @Column(name="destination_point", nullable = false)
    private String DestinationPoint;
    @Column(name="transport_type", nullable = false)
    private int transportType;
    @Column(name="duration", nullable = false)
    private String Duration;
    @Column(name="cost", nullable = false)
    private int cost;
    @Column(name="distance", nullable = false)
    private int distance;
}
