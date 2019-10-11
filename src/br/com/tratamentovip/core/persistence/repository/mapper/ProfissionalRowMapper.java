package br.com.tratamentovip.core.persistence.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import br.com.tratamentovip.core.persistence.model.Profissional;

public class ProfissionalRowMapper implements ParameterizedRowMapper<Profissional>{
	
	public Profissional mapRow(ResultSet rs, int rowNum) throws SQLException {
		Profissional profissional = new Profissional();
		profissional.setId(rs.getInt("id"));
		profissional.setNome(rs.getString("nome"));
		return profissional;
	}

}
