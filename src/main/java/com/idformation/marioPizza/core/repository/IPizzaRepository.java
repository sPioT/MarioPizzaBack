package com.idformation.marioPizza.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idformation.marioPizza.core.models.Pizza;

public interface IPizzaRepository  extends JpaRepository<Pizza, Long>{

}
