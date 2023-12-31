package com.aishoppingbuddy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity(name = "T_AISB_PARCEIROS_NEGOCIOS")
public class Parceiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_parceiros", nullable = false)
    private long id;

    @Column(name = "nm_fantasia", nullable = false)
    private String nomeFantasia;

    @Column(name = "dt_entrada", nullable = false)
    private LocalDate dataEntrada;

    @Column(name = "dt_saida")
    private LocalDate dataSaida;

    @Column(name = "nr_cnpj", nullable = false)
    private String cnpj;

    @OneToMany(mappedBy = "parceiro")
    @JsonIgnore
    @ToString.Exclude
    private List<Funcionario> funcionarioList;

    @OneToMany(mappedBy = "parceiro")
    @JsonIgnore
    @ToString.Exclude
    private List<Transacao> transacaoList;

    @OneToMany(mappedBy = "parceiro")
    @JsonIgnore
    @ToString.Exclude
    private List<Produto> produtoList;

    @OneToMany(mappedBy = "parceiro")
    @JsonIgnore
    @ToString.Exclude
    private List<Recomendacao> recomendacaoList;

}
