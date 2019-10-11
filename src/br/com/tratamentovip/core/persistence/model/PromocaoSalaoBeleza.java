package br.com.tratamentovip.core.persistence.model;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.math.BigDecimal;
import java.sql.Time;


/**
 * The persistent class for the promocao_salao_beleza database table.
 * 
 */
@Entity
@Table(name="promocao_salao_beleza")
@NamedQuery(name="PromocaoSalaoBeleza.findAll", query="SELECT p FROM PromocaoSalaoBeleza p")
public class PromocaoSalaoBeleza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "promocao_sequence", strategy = GenerationType.SEQUENCE)	
	@SequenceGenerator(name = "promocao_sequence", sequenceName = "promocao_sequence",allocationSize=1)
	@Column(unique=true, nullable=false)
	private Integer id;
	
	@Column(length=250)
	private String descricao;

	@Column(name="dias_semana", length=150)
	private String diasSemana;

	private Timestamp fim;

	@Column(name="horario_fim")
	private Time horarioFim;

	@Column(name="horario_inicio")
	private Time horarioInicio;

	private Timestamp inicio;

	@Column(name="percentual_desconto")
	private Integer percentualDesconto;

	@Column(name="valor_desconto", precision=6, scale=2)
	private BigDecimal valorDesconto;

	//uni-directional many-to-one association to Especialidade
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_especialidade_prom", nullable=false, insertable=false, updatable=false)
	private Especialidade especialidade;

	//uni-directional many-to-one association to SalaoBeleza
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_salao_prom", nullable=false, insertable=false, updatable=false)
	private SalaoBeleza salaoBeleza;

	public PromocaoSalaoBeleza() {
	}

	

	public Integer getId() {
		return id;
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

	public String getDiasSemana() {
		return this.diasSemana;
	}

	public void setDiasSemana(String diasSemana) {
		this.diasSemana = diasSemana;
	}

	public Timestamp getFim() {
		return this.fim;
	}

	public void setFim(Timestamp fim) {
		this.fim = fim;
	}

	public Time getHorarioFim() {
		return this.horarioFim;
	}

	public void setHorarioFim(Time horarioFim) {
		this.horarioFim = horarioFim;
	}

	public Time getHorarioInicio() {
		return this.horarioInicio;
	}

	public void setHorarioInicio(Time horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public Timestamp getInicio() {
		return this.inicio;
	}

	public void setInicio(Timestamp inicio) {
		this.inicio = inicio;
	}

	public Integer getPercentualDesconto() {
		return this.percentualDesconto;
	}

	public void setPercentualDesconto(Integer percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public BigDecimal getValorDesconto() {
		return this.valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public Especialidade getEspecialidade() {
		return this.especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public SalaoBeleza getSalaoBeleza() {
		return this.salaoBeleza;
	}

	public void setSalaoBeleza(SalaoBeleza salaoBeleza) {
		this.salaoBeleza = salaoBeleza;
	}

}