package com.algaworks.brands.controller;

import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.algaworks.brands.model.Brand;
import com.algaworks.brands.model.Product;
import com.algaworks.brands.repository.Brands;
import com.algaworks.brands.repository.Products;

@Controller
@RequestMapping("/products")
public class ProductsController {
	@Autowired
	private Products products;
	private Brands brands;
	
	@GetMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ProductsList");
		mv.addObject("products", products.findAll());
	    return mv;
	}
	
	@RequestMapping("/novo")
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView("ProductsForm");
		mv.addObject(new Product());		
		return mv;
	}
	
	@PostMapping("")
	public String salvar(@Validated Product product, Errors erros, RedirectAttributes redirectAttributes) {
		//ModelAndView mv = new ModelAndView("ProductsForm");
		//mv.addObject("products", products.findAll());
		if(erros.hasErrors()){
			return "ProductsForm";
		}
		//try {
			this.products.save(product);
			redirectAttributes.addFlashAttribute("mensagem", "Salvo com sucesso!");
			return "redirect:/prducts";
		//} catch(Exception e){return mv;}		
	}
	
	@RequestMapping(value ="/excluir/{idProduct}")
	public String excluirProductByPathVariable(@PathVariable Long idProduct, HttpServletRequest request, 
					HttpServletResponse response) {
		this.products.delete(idProduct);
		return "redirect:/products";
	}
	
	@RequestMapping("{idProduct}")
	public ModelAndView alterarProductByPathVariable(@PathVariable("idProduct") Long idProduct, HttpServletRequest request, 
			HttpServletResponse response, RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView("ProductsForm");
		Product product = products.findOne(idProduct);
		mv.addObject(product);
		//redirectAttributes.addFlashAttribute("mensagem", "Atualizado com sucesso!");
		//return "redirect:/products";
		return mv;
	}
	
	@RequestMapping(value="{/products/idProduct}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long idProduct, RedirectAttributes attributes) {
		products.delete(idProduct);
		attributes.addFlashAttribute("mensagem", "Excluído com sucesso!");
		return "redirect:/products";
	}
}