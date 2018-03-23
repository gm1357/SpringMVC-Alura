package br.com.casadocodigo.loja.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;
import br.com.casadocodigo.loja.validation.ProdutoValidation;

@Controller
@RequestMapping("produtos")
public class ProdutoController {
	
	@Autowired
    private ProdutoDAO produtoDao;
	
	@InitBinder
	public void InitBinder(WebDataBinder binder) {
	        binder.addValidators(new ProdutoValidation());
	}

	@RequestMapping("/form")
	public String form(Model model) {
		model.addAttribute("tipos", TipoPreco.values());
		return "produtos/form";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String gravar(@Valid Produto produto, BindingResult result, RedirectAttributes redirectAttributes, Model model) {

		if (result.hasErrors()) {
            return form(model);
        }
		
		produtoDao.gravar(produto);
		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso!");
		return "redirect:produtos";
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("produtos", produtoDao.listar());
		return "produtos/lista";
	}
}
