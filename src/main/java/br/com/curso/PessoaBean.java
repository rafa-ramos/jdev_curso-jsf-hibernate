package br.com.curso;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlCommandButton;

/**
 * 
 * Principais escopos são:
 * 
 * @RequestScoped (padrão): tem vida curta, começando quando é referenciado em
 *                uma única requisição HTTP e terminando quando a resposta é
 *                enviada de volta ao cliente. (é default do Bean quando não tem
 *                nenhum escopo declarado).
 * 
 * @ViewScoped: a instância permanece ativa até que o usuário para uma próxima
 *              página.
 * 
 * @SessionScoped: mantém a instância durante diversas requisições e até mesmo
 *                 navegações entre páginas, até que a sessão do usuário seja
 *                 invalidada ou o tempo limite é atingido. Cada usuário possui
 *                 sua sessão de navegação, portanto, os objetos não são
 *                 compartilhados entre os usuários.
 * 
 * @ApplicationScoped: mantém a instância durante todo o tempo de execução da
 *                     aplicação. É um escopo que compartilha os objetos para
 *                     todos os usuários do sistema.
 * 
 * @PostCosntruct chama o método toda a vez que o Bean for instânciado.
 *
 * @NoneScoped: o bean será instanciado a cada vez que for referenciado.
 */

@ViewScoped
@ManagedBean(name = "pessoaBean")
public class PessoaBean {
	
	private HtmlCommandButton commandButton;
	private String nome;
	private String senha;
	private String texto;

	private List<String> nomes = new ArrayList<String>();

	public String addNome() {
		
		nomes.add(nome);
		
		if (nomes.size() == 2) {
			
			commandButton.setDisabled(true);
			return "navegacao-dinamica?faces-redirect=true";
		}

		return ""; //null ou vazio fica na mesma página -> chamado de (outcome)
	}


	public HtmlCommandButton getCommandButton() {
		return commandButton;
	}

	public void setCommandButton(HtmlCommandButton commandButton) {
		this.commandButton = commandButton;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getTexto() {
		return texto;
	}


	public void setTexto(String texto) {
		this.texto = texto;
	}


	public List<String> getNomes() {
		return nomes;
	}


	public void setNomes(List<String> nomes) {
		this.nomes = nomes;
	}
	
	

}
