package br.com.tratamentovip.core.persistence.model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the url_foto_salao_beleza database table.
 * 
 */
@Entity
@Table(name="url_foto_salao_beleza")
@NamedQuery(name="UrlFotoSalaoBeleza.findAll", query="SELECT u FROM UrlFotoSalaoBeleza u")
public class UrlFotoSalaoBeleza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "urlfoto_sequence", strategy = GenerationType.SEQUENCE)	
	@SequenceGenerator(name = "urlfoto_sequence", sequenceName = "urlfoto_sequence",allocationSize=1)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(length=250)
	private String path;

	private Integer seq;

	//uni-directional many-to-one association to SalaoBeleza
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_url_salao_beleza")
	private SalaoBeleza salaoBeleza;

	public UrlFotoSalaoBeleza() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getSeq() {
		return this.seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public SalaoBeleza getSalaoBeleza() {
		return this.salaoBeleza;
	}

	public void setSalaoBeleza(SalaoBeleza salaoBeleza) {
		this.salaoBeleza = salaoBeleza;
	}

}