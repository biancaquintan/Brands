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
import com.algaworks.brands.model.Brand;
import com.algaworks.brands.repository.Brands;

@Controller
@RequestMapping("/brands")
public class BrandsController {
	@Autowired
	private Brands brands;
	
	@GetMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("BrandsList");
		mv.addObject("brands", brands.findAll());
	    return mv;
	}
	
	@RequestMapping("/novo")
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView("BrandsForm");
		mv.addObject(new Brand());
		return mv;
	}
	
	@PostMapping("")
	public String salvar(@Validated Brand brand, Errors erros, RedirectAttributes redirectAttributes){
		//ModelAndView mv = new ModelAndView("BrandsForm");
		//mv.addObject("brands", brands.findAll());
		if(erros.hasErrors()){
			return "BrandsForm";
		}
		//try {
			this.brands.save(brand);
			redirectAttributes.addFlashAttribute("mensagem", "Marca salva com sucesso!");
			return "redirect:/brands";
			//return new ModelAndView("redirect:brands");
		//} catch(Exception e) {return mv;}		
	}	

	@RequestMapping(value ="/excluir/{idBrand}")
	public String excluirBrandByPathVariable(@PathVariable Long idBrand, HttpServletRequest request, 
			HttpServletResponse response) {
		this.brands.delete(idBrand);
		//attributes.addFlashAttribute("mensagem", "Marca excluída com sucesso!");
		return "redirect:/brands";
	}
	
	@RequestMapping("/alterar/{idBrand}")
	public ModelAndView alterarBrandByPathVariable(@PathVariable Long idBrand, HttpServletRequest request, 
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("BrandsForm");
		mv.addObject("brands", brands.findAll());
		Brand brand = brands.findOne(idBrand);
		mv.addObject(brand);
		return mv;
	}
	
	@RequestMapping(value="{idBrand}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long idBrand, RedirectAttributes attributes) {
		brands.delete(idBrand);
		attributes.addFlashAttribute("mensagem", "Marca excluída com sucesso!");
		return "redirect:/brands";
	}
}
