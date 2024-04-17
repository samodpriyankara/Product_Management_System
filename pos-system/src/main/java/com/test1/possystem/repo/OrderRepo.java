package com.test1.possystem.repo;

import com.test1.possystem.dto.queryInterface.OrderDetailsInterface;
import com.test1.possystem.dto.response.ResponseOrderDTO;
import com.test1.possystem.entity.Orders;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface OrderRepo extends JpaRepository<Orders,Integer> {

    @Query(value = "select c.customer_name as customerName,c.customer_address as customerAddress ,c.contact_numbers as contactNumber,o.order_date as date,o.total as total from customer c, orders o where c.active_state = ?1 and c.customer_id = o.customer_id",nativeQuery = true)
    List<OrderDetailsInterface> getAllOrderDetails(boolean status, Pageable pageable);

@Query(value = "select count(*) from customer c,orders o where c.active_state =?1 and c.customer_id = o.customer_id",nativeQuery = true)
    long countAllOrderDetails(boolean status);
}
