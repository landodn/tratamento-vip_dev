package br.com.tratamentovip.core.persistence.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import br.com.tratamentovip.core.web.util.TimeAdapter;


/**
 * The persistent class for the especialidade database table.
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="especialidade")
@NamedQuery(name="Especialidade.findAll", query="SELECT e FROM Especialidade e")
public class Especialidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "especialidade_sequence", strategy = GenerationType.SEQUENCE)	
	@SequenceGenerator(name = "especialidade_sequence", sequenceName = "especialidade_sequence",allocationSize=1)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=150)
	private String descricao;

	@XmlJavaTypeAdapter( TimeAdapter.class) 
	@Column(name="media_atendimento")
	private Time mediaAtendimento;

	@ManyToMany(
			cascade={CascadeType.PERSIST, CascadeType.MERGE},
			mappedBy="especialidadeSalao"
			)
	private List<SalaoBeleza> especialidadeSalao;

	@ManyToMany(
			cascade={CascadeType.PERSIST, CascadeType.MERGE},
			mappedBy="profissionalEspecialidade"
			)
	private List<Profissional> profissionalEspecialidade;

	public Especialidade() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Time getMediaAtendimento() {
		return this.mediaAtendimento;
	}

	public void setMediaAtendimento(Time mediaAtendimento) {
		this.mediaAtendimento = mediaAtendimento;
	}

	public List<Profissional> getProfissionalEspecialidade() {
		return profissionalEspecialidade;
	}

	public void setProfissionalEspecialidade(
			List<Profissional> profissionalEspecialidade) {
		this.profissionalEspecialidade = profissionalEspecialidade;
	}

	public List<SalaoBeleza> getEspecialidadeSalao() {
		return especialidadeSalao;
	}

	public void setEspecialidadeSalao(List<SalaoBeleza> especialidadeSalao) {
		this.especialidadeSalao = especialidadeSalao;
	}



}
