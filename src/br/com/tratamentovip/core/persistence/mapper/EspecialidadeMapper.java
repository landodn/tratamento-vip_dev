package br.com.tratamentovip.core.persistence.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.tratamentovip.core.persistence.model.Especialidade;

public class EspecialidadeMapper implements RowMapper<Especialidade>{
	
	@Override
	public Especialidade mapRow(ResultSet rs, int rowNumber) throws SQLException {
		Especialidade especialidade = new Especialidade();
		especialidade.setId(rs.getInt("id"));
		especialidade.setDescricao(rs.getString("descricao"));
		especialidade.setMediaAtendimento(rs.getTime("media_atendimento"));
		return especialidade;
	}

}
