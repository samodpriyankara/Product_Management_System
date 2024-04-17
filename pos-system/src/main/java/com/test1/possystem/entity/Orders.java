package com.test1.possystem.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Data

@TypeDefs({
        @TypeDef(name = "json",typeClass = JsonType.class)
})
public class Orders {

    @Id
    @Column(name = "order_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customers;

    @Column(name = "order_date", columnDefinition = "DATETIME")
    private Date date;

    @Column(name = "total")
    private double total;

    @OneToMany(mappedBy = "orders")
    private Set<OdereDetails> odereDetails;

    public Orders(Customer customer, Date date, double total) {
        this.customers = customer;
        this.date = date;
        this.total = total;
    }


}
