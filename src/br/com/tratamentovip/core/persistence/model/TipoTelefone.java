package br.com.tratamentovip.core.persistence.model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the tipo_telefone database table.
 * 
 */
@Entity
@Table(name="tipo_telefone")
@NamedQuery(name="TipoTelefone.findAll", query="SELECT t FROM TipoTelefone t")
public class TipoTelefone implements BaseEntity, Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "tipotelefone_sequence", strategy = GenerationType.SEQUENCE)	
	@SequenceGenerator(name = "tipotelefone_sequence", sequenceName = "tipotelefone_sequence",allocationSize=1)
	@Column(name="id_tipo_telefone", unique=true, nullable=false)
	private Integer id;

	@Column(length=20)
	private String descricao;

	public TipoTelefone() {
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final TipoTelefone other = (TipoTelefone) obj;
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