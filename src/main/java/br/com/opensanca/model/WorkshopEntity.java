package br.com.opensanca.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "workshop")
public class WorkshopEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "duracao")
  private String duracao;

  @Column(name = "nome")
  private String nome;

  @Column(name = "created")
  private Date dtCriacao;

  public WorkshopEntity() {
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDuracao() {
    return this.duracao;
  }

  public void setDuracao(String duracao) {
    this.duracao = duracao;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Date getDtCriacao() {
    return dtCriacao;
  }

  public void setDtCriacao(Date dtCriacao) {
    this.dtCriacao = dtCriacao;
  }

  @PrePersist
  public void prePersist() {
    this.dtCriacao = new Date();
  }
}