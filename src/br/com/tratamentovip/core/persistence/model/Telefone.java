package br.com.tratamentovip.core.persistence.model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the telefone database table.
 * 
 */
@Entity
@Table(name="telefone")
public class Telefone implements BaseEntity, Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "telefone_sequence", strategy = GenerationType.SEQUENCE)	
	@SequenceGenerator(name = "telefone_sequence", sequenceName = "telefone_sequence",allocationSize=1)
	@Column(name="id_telefone", unique=true, nullable=false)
	private Integer id;

	private Integer ddd;

	private Integer numero;

	//uni-directional many-to-one association to TipoTelefone
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tipo_telefone")
	private TipoTelefone tipoTelefone;

	public Telefone() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDdd() {
		return this.ddd;
	}

	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}

	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public TipoTelefone getTipoTelefone() {
		return this.tipoTelefone;
	}

	public void setTipoTelefone(TipoTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Telefone other = (Telefone) obj;
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