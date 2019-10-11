package br.com.tratamentovip.core.persistence.model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the tipo_endereco database table.
 * 
 */
@Entity
@Table(name="tipo_endereco")
public class TipoEndereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "tipoendereco_sequence", strategy = GenerationType.SEQUENCE)	
	@SequenceGenerator(name = "tipoendereco_sequence", sequenceName = "tipoendereco_sequence",allocationSize=1)
	@Column(name = "id_tipo_endereco", unique=true, nullable=false)
	private Integer id;

	@Column(length=50)
	private String descricao;

	public TipoEndereco() {
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

}