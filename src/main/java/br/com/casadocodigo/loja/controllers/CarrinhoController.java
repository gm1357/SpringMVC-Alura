package br.com.casadocodigo.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.models.CarrinhoCompras;
import br.com.casadocodigo.loja.models.CarrinhoItem;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;

@Controller
@RequestMapping("/carrinho")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class CarrinhoController {

	@Autowired
	private ProdutoDAO produtoDao;
	@Autowired
    private CarrinhoCompras carrinho;

	private CarrinhoItem criaItem(Integer produtoId, TipoPreco tipo){
	    Produto produto = produtoDao.find(produtoId);
	    CarrinhoItem carrinhoItem = new CarrinhoItem(tipo, produto);
	    return carrinhoItem;
	}
	
	@RequestMapping("add")
	public String add(Model model, Integer produtoId, TipoPreco tipo) {
		CarrinhoItem carrinhoItem = criaItem(produtoId, tipo);
		carrinho.add(carrinhoItem);
		return "redirect:/produtos";
	}
}
