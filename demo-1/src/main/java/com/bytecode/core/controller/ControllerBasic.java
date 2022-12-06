package com.bytecode.core.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bytecode.core.components.PostComponent;
import com.bytecode.core.configuration.Page;
import com.bytecode.core.model.Post;

@Controller
@RequestMapping("/home")
public class ControllerBasic {
	
	@Autowired
	private PostComponent _postComponent;
	
	@GetMapping(path = {"/posts","/"})
	public String saludar(Model model) {
		model.addAttribute("posts", this._postComponent.getPost());
		
		return "index";
	}
	
	
	  @GetMapping(path = {"/post" , "/post/p/{post}"}) public ModelAndView
	  getPostIndividual(
	  
	  @PathVariable(required = true, name = "post") int id ) { ModelAndView
	  modelAndView = new ModelAndView(Page.POST); List<Post> postFilter =
	  this._postComponent.getPost().stream() .filter((p) ->{ return p.getId()== id;
	  }).collect(Collectors.toList());
	  
	  modelAndView.addObject("post", postFilter.get(0)); return modelAndView; }
	 												
	
	@GetMapping("/postNew")
	public ModelAndView getForm() {
		return new ModelAndView("form").addObject("post", new Post());
	}
	
	@PostMapping("/addNewPost")
	public String addNewPost(Post post, Model model) {
		List<Post> posts = this._postComponent.getPost();
		posts.add(post);
		model.addAttribute("posts", posts);
		return "index";
		
	}
	
							
	/*
	 * @GetMapping(path = {"/post"}) public ModelAndView getPostIndividual(
	 * 
	 * @RequestParam(defaultValue = "1", name = "id", required = false) int id ) {
	 * ModelAndView modelAndView = new ModelAndView(Page.POST); List<Post>
	 * postFilter = this.getPost().stream() .filter((p) ->{ return p.getId()== id;
	 * }).collect(Collectors.toList());
	 * 
	 * modelAndView.addObject("post", postFilter.get(0)); return modelAndView; }
	 */ 
	
//	@GetMapping(path = "/public")
//	public ModelAndView post () {
//		
//		ModelAndView modelAndView = new ModelAndView(Page.HOME);
//		modelAndView.addObject("posts", this.getPost());
//		
//		return modelAndView;
//	}

}
