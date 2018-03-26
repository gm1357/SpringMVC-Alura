package br.com.casadocodigo.loja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;

@Controller
public class HomeController {
	
	@Autowired
	ProdutoDAO produtoDao;
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Produto> produtos = produtoDao.listar();
		model.addAttribute("produtos", produtos);
		model.addAttribute("contextPath","casadocodigo/");
		return "home";
	}

}
