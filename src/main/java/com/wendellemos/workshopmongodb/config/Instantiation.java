package com.wendellemos.workshopmongodb.config;

import com.wendellemos.workshopmongodb.domain.Post;
import com.wendellemos.workshopmongodb.domain.User;
import com.wendellemos.workshopmongodb.dto.AuthorDTO;
import com.wendellemos.workshopmongodb.repository.PostRepository;
import com.wendellemos.workshopmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;


@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        User wendel = new User(null, "Wendel Lemos", "wendellemosmoura@gmail.com");
        userRepository.saveAll(Arrays.asList(maria, alex, bob, wendel));

        Post post1 = new Post(null, sdf.parse("15/06/2023"), "Partiu viagem!", "Vou viajar para Gramado, abraços!", new AuthorDTO(wendel));
        Post post2 = new Post(null, sdf.parse("15/06/2023"), "Partiu viagem!", "Vou viajar para Paris, abraços!", new AuthorDTO(wendel));

        postRepository.saveAll(Arrays.asList(post1, post2));

    }
}
