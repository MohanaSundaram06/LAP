package com.LAP.Database.Model;

import com.LAP.Database.Model.Enums.DeviceStatus;
import com.LAP.Database.Model.Enums.DeviceType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter @Setter
@Table
@Entity
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String deviceName;

    @Enumerated(EnumType.STRING)
    private DeviceType deviceType;

    @Enumerated(EnumType.STRING)
    private DeviceStatus deviceStatus;

    @ManyToMany(mappedBy = "devices",cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<Property> properties = new HashSet<>();

    @OneToMany(mappedBy = "device",cascade = CascadeType.ALL)
    private List<DeviceReadings> deviceReadings = new ArrayList<>();
}












