package com.LAP.Database.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter @Setter
@Table
@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn
    private User user;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime updatedDate;

    private double loanAmount;

    private float interestRate;

    private float monthlyEMI;

    private double amountPaid ;

    private int tenure;

    private String customerName;

    private String phoneNo;

    private String branchName;

    private String branchCity;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.PERSIST})
    @JoinColumn
    private Property property;

}






