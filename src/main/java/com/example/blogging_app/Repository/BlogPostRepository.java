package com.example.blogging_app.Repository;

import com.example.blogging_app.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepository extends JpaRepository<BlogPost,Integer> {
}
