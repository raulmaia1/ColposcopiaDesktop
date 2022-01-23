package br.com.colposcopia.desktop.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.colposcopia.desktop.bean.ExameColposcopico;
import br.com.colposcopia.desktop.factory.ConexaoBancoFactory;

public class ExameColposcopicoJDBCDAo {

	private static final String SQL_ADD_EXAME = "INSERT INTO exame_colposcopico "
			+ "(achados_colposcopicos_anormais, achados_colposcopicos_normais,"
			+ "avaliacao,conclusao,data_nascimento,descricao_macroscopica,nome_paciente,outros_anormais) VALUES (?,?,?,?,?,?,?,?)";

	public void adiciona(ExameColposcopico exame) {
		
		ConexaoBancoFactory.getConexao().ifPresent((conn) -> {
			try {
				PreparedStatement preparedStatement = conn.prepareStatement(SQL_ADD_EXAME);
				preparedStatement.setString(1, exame.getAchadosColpoANormais());
				preparedStatement.setString(2, exame.getAchadosColpoNormais());
				preparedStatement.setString(3, exame.getAvaliacao());
				preparedStatement.setString(4, exame.getConclusao());
				preparedStatement.setString(5, exame.getDataNascimento());
				preparedStatement.setString(6, exame.getDescricaoMacro());
				preparedStatement.setString(7, exame.getNomePaciente());
				preparedStatement.setString(8, exame.getOutroAnormais());

				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		
		});
	}

}
