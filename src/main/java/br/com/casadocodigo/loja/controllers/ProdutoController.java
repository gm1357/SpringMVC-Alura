package br.com.casadocodigo.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;

@Controller
@RequestMapping("produtos")
public class ProdutoController {
	
	@Autowired
    private ProdutoDAO produtoDao;

	@RequestMapping("/form")
	public String form(Model model) {
		model.addAttribute("tipos", TipoPreco.values());
		return "produtos/form";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String gravar(Produto produto) {
		System.out.println(produto);
		produtoDao.gravar(produto);
		return "produtos/ok";
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("produtos", produtoDao.listar());
		return "produtos/lista";
	}
}