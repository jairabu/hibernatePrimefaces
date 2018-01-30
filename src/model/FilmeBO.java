package model;

import java.util.ArrayList;
import java.util.List;

public class FilmeBO {
	public static void save(Filme filme) throws Exception {
		List<String> mensagens = new ArrayList();
		
		// Regras de negócio
		if(filme.getNome() == null || filme.getNome().isEmpty()) {
			mensagens.add("nome");
		}
		if(filme.getNota() == null) {
			mensagens.add("nota");
		}
		
		if(mensagens.size()>0) {
			String mensagem = "";
			if(mensagens.size()==1) {
				mensagem = mensagens.get(0);
			} else {
				int last = mensagens.size() - 1;
				mensagem = String.join(" e ", String.join(", ", 
						mensagens.subList(0, last)), mensagens.get(last));
			}
			throw new Exception("Por gentileza preencha o(s) campo(s) "+mensagem+"!");						
		} else {
			FilmeDAO.save(filme);
		}
	}
}
