package com.bytecode.core.services.imp;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.bytecode.core.model.Post;

@Service
public class PostServiceImp implements com.bytecode.core.services.PostService {

	private final Log log = LogFactory.getLog(getClass());
	
	@Override
	public List<Post> validation(List<Post> posts) {
		log.info("Service one");
		for(Post post : posts) {
			if(post.getTitle()== null) {
				throw new NullPointerException("Title null");
			}
		}
		return posts;
	}

	
	
}
