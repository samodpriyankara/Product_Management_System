package com.test1.possystem.repo;

import com.test1.possystem.entity.OdereDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@EnableJpaRepositories
public interface OrderDetailsRepo extends JpaRepository<OdereDetails,Integer> {
}
