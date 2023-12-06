package com.LAP.Database.Model;

import com.LAP.Database.Model.Enums.DeviceReadingKey;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Getter @Setter
@Table
@Entity
public class DeviceReadings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreatedDate
    private LocalDate date;

    private DeviceReadingKey deviceReadingKey;

    private double readingValue;

    @ManyToOne
    @JoinColumn
    private Device device;

}
