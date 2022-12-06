package com.bytecode.core.components;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bytecode.core.model.Post;

@Component("com.bytecode.core.components.PostComponent")
@Scope("singleton")
public class PostComponent {
	
	public List<Post> getPost(){
		ArrayList<Post> post = new ArrayList<>();
		
		post.add(new Post(1,"Esto es una prueba de desarrollo web para internet","http://localhost/img/a.jpg",new Date(),"Desarrollo Web"));
		post.add(new Post(2,"Esto es una prueba de desarrollo web para internet","http://localhost/img/a.jpg",new Date(),"Desarrollo Front End"));
		post.add(new Post(3,"Esto es una prueba de desarrollo web para internet","http://localhost/img/a.jpg",new Date(),"Desarrollo Web Back End"));
		post.add(new Post(4,"Esto es una prueba de desarrollo web para internet","http://localhost/img/a.jpg",new Date(),"Desarrollo Web Full Sthack"));
		
		return post;
	}

}
