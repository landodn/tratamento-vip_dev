package br.com.tratamentovip.core.persistence.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import br.com.tratamentovip.core.persistence.model.Especialidade;

public class EspecialidadeRowMapper implements ParameterizedRowMapper<Especialidade> {
	
	  public Especialidade mapRow(ResultSet rs, int rowNum) throws SQLException {
          Especialidade esp = new Especialidade();
          esp.setId(rs.getInt("id"));
          esp.setDescricao(rs.getString("descricao"));
          return esp;
      }

}
