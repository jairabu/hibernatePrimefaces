package model;

import java.util.List;

public class TestarBD {
	public static void main(String[] args) {
		List<Filme> filmes = FilmeDAO.findAll();
		for (Filme filme : filmes) {
			FilmeDAO.delete(filme);
		}
		
		Filme filme1 = new Filme();
		filme1.setNome("Frozen: O Reino do Gelo");
		filme1.setAno(2013);
		filme1.setNota(5.5f);
		
		Filme filme2 = new Filme();
		filme2.setNome("Ghost in the Shell - Agente do Futuro");
		filme2.setAno(2017);
		filme2.setNota(10f);
		
		FilmeDAO.save(filme1);
		FilmeDAO.save(filme2);		
		mostrarFilmes();
		
		filme1.setNome("Frozen Teste");
		FilmeDAO.update(filme1);
		mostrarFilmes();
		
	}

	private static void mostrarFilmes() {
		List<Filme> filmes = FilmeDAO.findAll();
		for (Filme filme : filmes) {
			System.out.println("Nome: "+filme.getNome()+" Ano: "+filme.getAno()+" Nota: "+filme.getNota());
		}
	}
}
