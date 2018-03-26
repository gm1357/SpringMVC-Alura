package br.com.casadocodigo.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.models.CarrinhoCompras;

@Controller
@RequestMapping("/pagamentos")
public class PagamentoController {
	
	@Autowired
    CarrinhoCompras carrinho;
	
	@Autowired
    RestTemplate restTemplate;
	
	@RequestMapping(value="/finalizar", method=RequestMethod.POST)
    public String finalizar(RedirectAttributes model){
        System.out.println(carrinho.getTotal());
        model.addFlashAttribute("sucesso", "Pagamento Realizado com Sucesso");
        return "redirect:/produtos";
    }

}
