package com.aishoppingbuddy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity(name = "T_AISB_PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_produto", nullable = false)
    private long id;

    @Column(name = "nm_produto", nullable = false)
    private String nome;

    @Column(name = "ds_tipo", nullable = false)
    private String tipo;

    @Column(name = "vl_produto", nullable = false)
    private double valor;

    @Column(name = "ds_produto", nullable = false)
    private String descricao;

    @Column(name = "ds_categoria", nullable = false)
    private String categoria;


    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "cd_parceiros")
    private Parceiro parceiro;

    @ManyToMany(mappedBy = "produtoList")
    @ToString.Exclude
    @JsonIgnore
    private List<Recomendacao> recomendacaoList;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "cd_transacao")
    @JsonIgnore
    private Transacao transacao;

}
