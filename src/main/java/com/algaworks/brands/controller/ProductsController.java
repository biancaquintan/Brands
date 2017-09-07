package com.algaworks.brands.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.brands.model.Festa;
import com.algaworks.brands.repository.Festas;

@Controller
@RequestMapping("/products")
public class ProductsController {
	@Autowired
	private Products products;

	@GetMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ProductList");
		mv.addObject("products",products.findAll());
	return mv;
	}
	
	@RequestMapping("/novo")
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView("ProductForm");
		mv.addObject(new Festa());
		return mv;
	}
	
	@PostMapping("")
	public ModelAndView salvar(@Validated Product product, Errors erros, RedirectAttributes redirectAttributes){
		ModelAndView mv = new ModelAndView("ProductForm");
		mv.addObject("products", products.findAll());
		if(erros.hasErrors()){
			return mv;
		}
		try{
			this.products.save(product);
			return new ModelAndView("redirect:products");
		}catch(Exception e){return mv;}
		
	}
	
	@RequestMapping(value ="/excluir/{idProduct}")
	public String excluirProductByPathVariable(@PathVariable Long idProduct, HttpServletRequest request, 
					HttpServletResponse response) {
		this.products.delete(idProduct);
		return "redirect:/products";
	}
	
	@RequestMapping("/alterar/{idProduct}")
	public ModelAndView alterarProductByPathVariable(@PathVariable Long idProduct, HttpServletRequest request, 
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("ProductForm");
		mv.addObject("products",products.findAll());
		Product product = products.findOne(idProduct);
		mv.addObject(product);
		return mv;
	}
	
	@RequestMapping(value="{idProduct}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long idProduct, RedirectAttributes attributes) {
		products.delete(idProduct);
		attributes.addFlashAttribute("mensagem", "Produto excluído com sucesso!");
		return "redirect:/products";
	}
}
