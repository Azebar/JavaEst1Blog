package ee.sda.javaest1blog.controllers;

import ee.sda.javaest1blog.dtos.PostDTO;
import ee.sda.javaest1blog.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/posts")
public class ApiPostController {

    final PostService postService;

    @GetMapping("/all")
    List<PostDTO> allPosts() {
        List<PostDTO> posts = new ArrayList<>();
        postService.getAllPosts().forEach(
                post -> posts.add(PostDTO.builder().text(post.getText()).build())
        );
        return posts;
    }
}
