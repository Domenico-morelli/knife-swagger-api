package it.its.nttdata.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.its.nttdata.demo.database.Order;

public interface StoreRepo extends JpaRepository<Order, Long>{

}
