package com.logiston;

import com.logiston.repository.ThemeRepository;
import com.logiston.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration
@ComponentScan(basePackages = "com.logiston")
public class MyApplication {
    private static final Logger log = LoggerFactory.getLogger(MyApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);

    }

    @Bean
    public CommandLineRunner demo(ThemeRepository themeRepository, UserRepository userRepository) {
        return (args) -> {
//            Theme theme = new Theme();
//            theme.setTitle("test insert title");
//            Comment comment = new Comment();
//            comment.setMessage("test insert message");
//            comment.setDateTime(LocalDateTime.now());
//            comment.setUser(userRepository.findOne(2L));
//            theme.getComments().add(comment);
//
//            themeRepository.save(theme);

        };
    }

//    @Bean
//    public CommandLineRunner demoUser(ThemeRepository themeRepository,
//                                      UserRepository userRepository){
//        return (args) ->{
////            User user = new User();
////            user.setName("Adriano225");
////
////
////            User userAny = new User();
////            userAny.setName("Any");
////
////            Theme theme1 = new Theme();
////            theme1.setTitle("Theme 1");
////
////            Theme theme2 = new Theme();
////            theme2.setTitle("Theme M340");
////
////            Set<Comment> comments = new HashSet<>();
////            Comment comment1 = new Comment();
////            comment1.setMessage("dhskljfsdfnsfsdf sdf sd sd ");
////            comment1.setUser(user);
////
////            Comment comment2 = new Comment();
////            comment2.setMessage("This plc is connected to localhost");
////            comment2.setUser(user);
////
////            Set<Comment> commentsPlc = new HashSet<>();
////            Comment commentPlc = new Comment();
////            commentPlc.setMessage("PLC new firmware");
////            commentPlc.setUser(userAny);
////
////            commentsPlc.add(commentPlc);
////            theme2.setComments(commentsPlc);
////
////            comments.add(comment1);
////            comments.add(comment2);
////            theme1.setComments(comments);
//
//
//
//
////            userRepository.save(user);
////            userRepository.save(userAny);
////
////            themeRepository.save(theme1);
////            themeRepository.save(theme2);
//
////            Comment newComment = new Comment();
////            newComment.setMessage("New message ghkhjkjh hjkhjk hjkhj234 234");
////            newComment.setUser(userRepository.findOne(1L));
//////            User oneuser = userRepository.findOne(1L);
//////            System.out.println(oneuser);
////            Theme one = themeRepository.findOne(1L);
//////            Set<Comment> oneComments = one.getComments();
//////            oneComments.add(newComment);
////
////            one.getComments().add(newComment);
////            themeRepository.save(one);
//
//
//
//            Theme theme = new Theme();
//            theme.setTitle("new Topic");
//
//            themeRepository.save(theme);
//
////            for (Theme theme : themeRepository.findAll()) {
////                System.out.println(theme);
////            }
//        };
//    }

}
