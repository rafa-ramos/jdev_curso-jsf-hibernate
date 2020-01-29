package br.com.curso;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.dao.DAOGeneric;
import br.com.entidade.Pessoa;

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
	
	private Pessoa pessoa = new Pessoa();
	private DAOGeneric<Pessoa> daoGeneric = new DAOGeneric<Pessoa>();
	
	public String salvar() {
		pessoa = daoGeneric.merge(pessoa);
		return "";
	}
	
	public String limpar() {
		pessoa = new Pessoa();
		return "";
	}
	
	public String remover() {
		daoGeneric.deletePorId(pessoa);
		
		pessoa = new Pessoa();
		return "";
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public DAOGeneric<Pessoa> getDaoGeneric() {
		return daoGeneric;
	}

	public void setDaoGeneric(DAOGeneric<Pessoa> daoGeneric) {
		this.daoGeneric = daoGeneric;
	}
	

}
