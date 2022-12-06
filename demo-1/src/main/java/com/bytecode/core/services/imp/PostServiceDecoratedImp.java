package com.bytecode.core.services.imp;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bytecode.core.model.Post;
import com.bytecode.core.services.PostService;

@Service("decorated")
public class PostServiceDecoratedImp implements PostService{

	private final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private PostServiceImp postServiceImp;
	
	@Autowired
	private PostServiceTwoImp postServiceTwoImp;
	
	
	@Override
	public List<Post> validation(List<Post> posts) {
		
		log.debug(posts);
		posts = postServiceImp.validation(posts);
		posts = postServiceTwoImp.validation(posts);
		
		for(Post post : posts) {
			if(post.getDescription()== null) {
				throw new NullPointerException("Description null");
			}
			if(post.getDate()== null) {
				throw new NullPointerException("Date null");
			}
		}
		log.info("Service Decorated");
		return posts;
	}

}
