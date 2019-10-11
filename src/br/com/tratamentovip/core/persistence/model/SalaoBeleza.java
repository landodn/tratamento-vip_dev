package br.com.tratamentovip.core.persistence.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.com.tratamentovip.core.web.util.TimeAdapter;


/**
 * The persistent class for the salao_beleza database table.
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="salao_beleza")
public class SalaoBeleza extends Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length=200)
	private String nomeProprietario;
	
	@Column(length=250)
	private String facebook;

	@Column(name="cpf_cnpj", nullable=false, length=18)
	private String cpfCnpj;
	
	@Column(name="inscricao_estadual", nullable=true, length=14)
	private String inscricaoEstadual;

	@XmlJavaTypeAdapter( TimeAdapter.class) 
	@Column(name="horario_abertura")
	private Time horarioAbertura;

	@XmlJavaTypeAdapter( TimeAdapter.class) 
	@Column(name="horario_fechamento")
	private Time horarioFechamento;

	@Column(name="nome_fantasia", nullable=false, length=200)
	private String nomeFantasia;

	@Column(name="razao_social", nullable=false, length=150)
	private String razaoSocial;

	@Column(name="web_site", nullable=true, length=250)
	private String webSite;
	
	@OneToOne(cascade = {CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="id_endereco")
	private Endereco endereco;

	@ManyToMany(fetch = FetchType.LAZY)
	@Fetch(FetchMode.SUBSELECT)
	@BatchSize(size=10)
	@JoinTable(name = "especialidade_salao", 
	joinColumns = @JoinColumn(name = "id"),
	inverseJoinColumns = @JoinColumn(name = "id_especialidade"))
	private List<Especialidade> especialidadeSalao;


	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
	@JoinTable(name="salao_beleza_telefone", 
		joinColumns=@JoinColumn(name="id"),
		inverseJoinColumns=@JoinColumn(name="id_telefone"))
	private List<Telefone> telefonesSalaoBeleza;

	public SalaoBeleza() {
	}
	
	

	/**
	 * @return the nomeProprietario
	 */
	public String getNomeProprietario() {
		return nomeProprietario;
	}
	
	/**
	 * @param nomeProprietario the nomeProprietario to set
	 */
	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario;
	}

	public String getCpfCnpj() {
		return this.cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	

	/**
	 * @return the inscricaoEstadual
	 */
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	/**
	 * @param inscricaoEstadual the inscricaoEstadual to set
	 */
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public Time getHorarioAbertura() {
		return this.horarioAbertura;
	}

	public void setHorarioAbertura(Time horarioAbertura) {
		this.horarioAbertura = horarioAbertura;
	}

	public Time getHorarioFechamento() {
		return this.horarioFechamento;
	}

	public void setHorarioFechamento(Time horarioFechamento) {
		this.horarioFechamento = horarioFechamento;
	}

	public String getNomeFantasia() {
		return this.nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return this.razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public List<Especialidade> getEspecialidadeSalao() {
		return especialidadeSalao;
	}

	public void setEspecialidadeSalao(List<Especialidade> especialidadeSalao) {
		this.especialidadeSalao = especialidadeSalao;
	}


	/**
	 * @return the telefonesSalaoBeleza
	 */
	public List<Telefone> getTelefonesSalaoBeleza() {
		return telefonesSalaoBeleza;
	}



	/**
	 * @param telefonesSalaoBeleza the telefonesSalaoBeleza to set
	 */
	public void setTelefonesSalaoBeleza(List<Telefone> telefonesSalaoBeleza) {
		this.telefonesSalaoBeleza = telefonesSalaoBeleza;
	}


	/**
	 * @return the webSite
	 */
	public String getWebSite() {
		return webSite;
	}



	/**
	 * @param webSite the webSite to set
	 */
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}


}
