package ee.sda.javaest1blog.services;

import ee.sda.javaest1blog.entities.Post;
import ee.sda.javaest1blog.repositories.PostRepository;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

    @Mock
    PostRepository repository;

    @Mock
    UserService service;

    @InjectMocks
    PostService postService;

    @Test
    void getAllPostsTest() {
        List<Post> posts = new ArrayList<>();
        Iterable<Post> postIterable = new Iterable<Post>() {
            @Override
            public Iterator<Post> iterator() {
                return posts.iterator();
            }
        };
        Post post = new Post();
        post.setText("firstPost");
        Mockito.when(repository.findAll()).thenReturn(postIterable);
        posts.add(post);
        assertEquals(posts, postService.getAllPosts());
    }
}
