package br.com.tratamentovip.core.persistence.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import br.com.tratamentovip.core.persistence.model.Cliente;

public class ClienteRowMapper implements ParameterizedRowMapper<Cliente> {
	
	  public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
		  Cliente cliente = new Cliente();
		
		  cliente.setDataNascimento(rs.getDate("data_nascimento"));
		  cliente.setFacebook(rs.getString("facebook"));
		  cliente.setNome(rs.getString("nome"));
		  cliente.setId(rs.getInt("id"));
		  	
		  return cliente;
      }

}
