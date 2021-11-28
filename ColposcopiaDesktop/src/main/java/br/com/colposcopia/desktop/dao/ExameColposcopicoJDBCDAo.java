package br.com.colposcopia.desktop.dao;

import java.sql.PreparedStatement;

import br.com.colposcopia.desktop.bean.ExameColposcopico;
import br.com.colposcopia.desktop.factory.ConexaoBancoFactory;

public class ExameColposcopicoJDBCDAo {

	private static final String SQL_ADD_EXAME = "INSERT INTO exame_colposcopico (achados_colposcopicos_anormais, achados_colposcopicos_normais, avaliacao,conclusao,data_nascimento,descricao_macroscopica,nome_paciente,outros_anormais) VALUES (?,?,?,?)";

	public void adiciona(ExameColposcopico exame) {
		
		ConexaoBancoFactory.getConexao().ifPresent((conn) -> {
			PreparedStatement preparedStatement = conn.prepareStatement(SQL_ADD_EXAME);
			preparedStatement.setString(1, aluno.getNome());
			
			preparedStatement.executeUpdate();
		
		});
	}

}
