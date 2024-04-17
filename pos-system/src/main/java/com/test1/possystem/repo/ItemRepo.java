package com.test1.possystem.repo;

import com.test1.possystem.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping
@EnableJpaRepositories
public interface ItemRepo extends JpaRepository<Item,Integer> {
    List<Item> findAllByItemNameEqualsAndActiveEquals(String itemName, boolean b);


    Page<Item> findAllByActive(boolean activeStatus, Pageable pageable);

    int countAllByActive(boolean activeStatus);
}
