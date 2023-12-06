package com.LAP.Database.Model;

import com.LAP.Database.Model.Enums.PropertyStatus;
import com.LAP.Database.Model.Enums.PropertyType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter @Setter
@Table
@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;

    @Enumerated(EnumType.STRING)
    private PropertyStatus propertyStatus;

    private float valuation;

    private float propertyAge;

    private int noOfFloors;

    private String buildingNo;

    private String streetName;

    private String city;

    private String state;

    private long pinCode;

    private String locationURL;

    @OneToMany(mappedBy = "property", cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.MERGE})
    private List<Loan> loanList;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "property_device_map",
            joinColumns ={@JoinColumn(name = "property_id")},
            inverseJoinColumns = {@JoinColumn(name = "device_id")})
    private Set<Device> devices;

    public Property() {
        loanList = new ArrayList<>();
        devices = new HashSet<>();
    }

    public void AddDevice(Device device){
        this.devices.add(device);
    }

    public void removeDevice(Device device){
        device.getProperties().remove(this); // remove the relation from device
        this.devices.remove(device); //remove the relation from property
    }

}











