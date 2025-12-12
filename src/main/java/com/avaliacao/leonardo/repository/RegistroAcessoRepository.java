package com.avaliacao.leonardo.repository;

import com.avaliacao.leonardo.model.RegistroAcesso;
import com.avaliacao.leonardo.model.Vaga;
import com.avaliacao.leonardo.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RegistroAcessoRepository extends JpaRepository<RegistroAcesso, Long> {

    List<RegistroAcesso> findByVeiculo(Veiculo veiculo);

    List<RegistroAcesso> findByVaga(Vaga vaga);

    List<RegistroAcesso> findByStatus(String status);

    List<RegistroAcesso> findByDataEntradaBetween(LocalDateTime inicio, LocalDateTime fim);

    List<RegistroAcesso> findByDataSaidaBetween(LocalDateTime inicio, LocalDateTime fim);

}
