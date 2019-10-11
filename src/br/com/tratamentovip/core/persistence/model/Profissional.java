package br.com.tratamentovip.core.persistence.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


/**
 * The persistent class for the profissional database table.
 * 
 */
@XmlRootElement
@Entity
@Table(name="profissional")
@NamedQuery(name="Profissional.findAll", query="SELECT p FROM Profissional p")
public class Profissional implements Serializable {
 private static final long serialVersionUID = 1L;
 
 @Id
 @GeneratedValue(generator = "profissional_sequence", strategy = GenerationType.SEQUENCE)	
 @SequenceGenerator(name = "profissional_sequence", sequenceName = "profissional_sequence",allocationSize=1)
 @Column(name="id_profissional", unique=true, nullable=false)
 private Integer id;
 
 private String nome;

 @Column(name="data_cadastro", nullable=false)
 private Date dataCadastro;
 
 @ManyToMany(fetch = FetchType.EAGER)
 @Fetch(FetchMode.SUBSELECT)
 @BatchSize(size=10)
 @JoinTable(name = "profissional_especialidade", 
 joinColumns = @JoinColumn(name = "id_profissional"),
 inverseJoinColumns = @JoinColumn(name = "id_especialidade"))
 private List<Especialidade> profissionalEspecialidade;

 @ManyToOne(fetch=FetchType.EAGER)
 @JoinColumn(name= "id_salao")
  private SalaoBeleza profissionalSalaoBeleza;


 /**
 * @return the nome
 */
 public String getNome() {
 return nome;
 }

/**
 * @param nome the nome to set
 */
 public void setNome(String nome) {
 this.nome = nome;
 }

 

public SalaoBeleza getProfissionalSalaoBeleza() {
 return profissionalSalaoBeleza;
 }

public void setProfissionalSalaoBeleza(SalaoBeleza profissionalSalaoBeleza) {
 this.profissionalSalaoBeleza = profissionalSalaoBeleza;
 }

public List<Especialidade> getProfissionalEspecialidade() {
 return profissionalEspecialidade;
 }

public void setProfissionalEspecialidade(
 List<Especialidade> profissionalEspecialidade) {
 this.profissionalEspecialidade = profissionalEspecialidade;
 }

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public Date getDataCadastro() {
	return dataCadastro;
}

public void setDataCadastro(Date dataCadastro) {
	this.dataCadastro = dataCadastro;
}

 

}
