package br.com.tratamentovip.core.persistence.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import br.com.tratamentovip.core.persistence.model.Endereco;
import br.com.tratamentovip.core.persistence.model.SalaoBeleza;
import br.com.tratamentovip.core.web.util.TimeAdapter;

public class SalaoBelezaRowMapper implements ParameterizedRowMapper<SalaoBeleza> {
	
	  public SalaoBeleza mapRow(ResultSet rs, int rowNum) throws SQLException {
		  SalaoBeleza sal = new SalaoBeleza();
		
		  sal.setFacebook(rs.getString("facebook"));
		  sal.setCpfCnpj(rs.getString("cpf_Cnpj"));
		  sal.setHorarioAbertura(rs.getTime("horario_Abertura"));
		  sal.setHorarioFechamento(rs.getTime("horario_Fechamento"));
		  sal.setNomeFantasia(rs.getString("nome_Fantasia"));
		  sal.setRazaoSocial(rs.getString("razao_Social"));
		  	
		  return sal;
      }

}
