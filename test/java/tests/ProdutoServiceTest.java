/**
 * 
 */
package tests;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dao.IProdutoDAO;
import dao.mock.ProdutoDaoMock;
import domain.Produto;
import exceptions.DAOException;
import exceptions.TipoChaveNaoEncontradaException;
import services.IProdutoService;
import services.ProdutoService;

public class ProdutoServiceTest {

	private IProdutoService produtoService;

	private Produto produto;

	public ProdutoServiceTest() {
		IProdutoDAO dao = new ProdutoDaoMock();
		produtoService = new ProdutoService(dao);
	}

	@Before
	public void init() {
		produto = new Produto();
		produto.setCodigo("A1");
		produto.setDescricao("Produto 1");
		produto.setNome("Produto 1");
		produto.setValor(BigDecimal.TEN);
		produto.setModelo("A");
	}

	@Test
	public void pesquisar() throws DAOException {
		Produto produtor = this.produtoService.consultar(produto.getCodigo());
		Assert.assertNotNull(produtor);
	}

	@Test
	public void salvar() throws TipoChaveNaoEncontradaException, DAOException {
		Boolean retorno = produtoService.cadastrar(produto);
		Assert.assertTrue(retorno);
	}

	@Test
	public void excluir() throws DAOException {
		produtoService.excluir(produto.getCodigo());
	}

	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		produto.setNome("Raphael Lima");
		produtoService.alterar(produto);

		Assert.assertEquals("Raphael Lima", produto.getNome());
	}
}
