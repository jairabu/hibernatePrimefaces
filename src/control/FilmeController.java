package control;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.chart.PieChartModel;

import lombok.Data;
import model.Filme;
import model.FilmeBO;
import model.FilmeDAO;

@ManagedBean
@SessionScoped
@Data
public class FilmeController {
	private List<Filme> filmes;
	private Filme filme;
	private Filme filmeSelecionado;
	private boolean modoEdicao;
	private PieChartModel grafico;
	
	@PostConstruct
	public void iniciar() {
		filmes = FilmeDAO.findAll();
		filme = new Filme();
		modoEdicao = false;		
		gerarGrafico();
	}

	private void gerarGrafico() {
		grafico = new PieChartModel();        
		grafico.set("Ruins", FilmeDAO.findBetweenNota(0, 5));
        grafico.set("Bons", FilmeDAO.findBetweenNota(5.1f, 7f));
        grafico.set("Ótimos", FilmeDAO.findBetweenNota(7.1f, 10));
        grafico.setTitle("Classificação de Filmes");
	}
	
	public void selecionar() {
		modoEdicao = true;
		filme = filmeSelecionado;
	}
	
	public void salvar() {
		try {
			FilmeBO.save(filme);
			iniciar();
			mostrarMensagem("Usuário cadastrado com sucesso!");
		} catch (Exception e) {
			mostrarErro("Cadastro de usuário com erro! "+e.getMessage());
		}		
	}
	
	public void atualizar() {
		try {
			FilmeDAO.update(filme);
			iniciar();
			mostrarMensagem("Usuário atualizado com sucesso!");
		} catch (Exception e) {
			mostrarErro("Atualização de usuário com erro! "+e.getMessage());
		}		
	}
	
	public void remover() {
		try {
			FilmeDAO.delete(filme);
			iniciar();
			mostrarMensagem("Usuário removido com sucesso!");
		} catch (Exception e) {
			mostrarErro("Remoção de usuário com erro! "+e.getMessage());
		}
	}
	
	public void cancelar() {
		iniciar();		
	}
	
	public void mostrarMensagem(String mensagem) {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(mensagem, new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, "Atenção!"));
	}
	
	public void mostrarErro(String mensagem) {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(mensagem, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, "Erro!"));
	}
}
