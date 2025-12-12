package com.avaliacao.leonardo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avaliacao.leonardo.model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    Veiculo findByPlaca(String placa);

    List<Veiculo> findByModeloContainingIgnoreCase(String modelo);

    List<Veiculo> findByMarcaContainingIgnoreCase(String marca);

}
