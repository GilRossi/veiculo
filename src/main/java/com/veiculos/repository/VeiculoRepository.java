package com.veiculos.repository;

import com.veiculos.models.VeiculoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<VeiculoModel, String> {
    VeiculoModel findByCodigo(long codigo);
}
