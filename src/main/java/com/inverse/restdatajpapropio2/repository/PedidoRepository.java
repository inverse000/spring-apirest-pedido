package com.inverse.restdatajpapropio2.repository;

import com.inverse.restdatajpapropio2.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
