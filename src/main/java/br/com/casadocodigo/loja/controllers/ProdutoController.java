package br.com.casadocodigo.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;

@Controller
public class ProdutoController {
	
	@Autowired
    private ProdutoDAO produtoDao;

	@RequestMapping("produtos/form")
	public String form() {
	public String form(Model model) {
		model.addAttribute("tipos", TipoPreco.values());
		return "produtos/form";
	}
	
	@RequestMapping("produtos")
	public String gravar(Produto produto) {
		System.out.println(produto);
		produtoDao.gravar(produto);
		return "produtos/ok";
		
	}
}
