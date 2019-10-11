package br.com.tratamentovip.core.persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the tipo_endereco database table.
 * 
 */
@XmlRootElement
@Entity
@Table(name="tipo_usuario")
@NamedQuery(name="TipoUsuario.findAll", query="SELECT t FROM TipoUsuario t")
public class TipoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "tipousuario_sequence", strategy = GenerationType.SEQUENCE)	
	@SequenceGenerator(name = "tipousuario_sequence", sequenceName = "tipousuario_sequence",allocationSize=1)
	@Column(name="id_tipo_usuario", unique=true, nullable=false)
	private Integer id;

	@Column(length=50)
	private String descricao;
	
	public TipoUsuario(){
	}
	
	public TipoUsuario(Integer id){
		this.id = id;
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