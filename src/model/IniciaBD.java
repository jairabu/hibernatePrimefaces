package model;

import java.util.List;

public class IniciaBD {
	public static void main(String[] args) {
		List<ConfiguracaoSistema> configuracoes;
		configuracoes = GenericDAO.findAll(ConfiguracaoSistema.class);
		for (ConfiguracaoSistema configuracao : configuracoes) {
			GenericDAO.delete(configuracao);
		}

		ConfiguracaoSistema configuracao = new ConfiguracaoSistema();
		configuracao.setTema("eggplant");
		GenericDAO.save(configuracao);
	}
}