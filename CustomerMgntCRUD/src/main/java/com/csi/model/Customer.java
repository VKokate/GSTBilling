package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue
    @Column(name = "cust_id")
    private int custId;

    @Column(name = "cust_name")
    private  String custName;

    @Column(name = "cust_address")
    private String custAddress;

    @Column(name = "cust_contact_number", unique = true)
    private  long custContactNumber;

    @Column(name = "cust_acc_balance")
    private  double custAccountBalance;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "cust_dob")
    private Date custDOB;

    @Column(name = "cust_email_id" , unique = true)
    private  String custEmailId;

    @Column(name = "cust_password")
    private  String custPassword;

}
