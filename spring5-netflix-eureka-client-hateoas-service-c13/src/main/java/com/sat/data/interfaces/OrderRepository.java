package com.sat.data.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sat.bean.Order;

//使用data rest时不自动将该Repository暴露为API
@RepositoryRestResource(exported = false)
public interface OrderRepository extends CrudRepository<Order, Long>{

}
