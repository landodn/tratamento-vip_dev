package br.com.tratamentovip.core.persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="uf")
public class UF implements BaseEntity, Serializable {

	private static final long serialVersionUID = 839692149122812164L;

	@Id
	@GeneratedValue(generator = "uf_sequence", strategy = GenerationType.SEQUENCE)	
	@SequenceGenerator(name = "uf_sequence", sequenceName = "uf_sequence",allocationSize=1)
	@Column(name="id_uf")
	private Integer id;

	@Column(name="sigla", length=2)
	private String sigla;

	@Column(name="nome", length=80)
	private String nome;

	@Column(name="capital", length=100)
	private String capital;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final UF other = (UF) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((id == null) ? 0 : id.hashCode());
		return result;
	}

}
