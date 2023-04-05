package com.luv2code.springboot.demo.mycoolapp.rest;

import com.luv2code.springboot.demo.mycoolapp.exception.customException.AppException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/")
public class FunRestController {

    @GetMapping("/hello")
    public ResponseEntity<User> sayHello(@RequestParam int id) {

        User user = findUserById(id);
        return ResponseEntity.ok(user);
    }

    private User findUserById(int id) {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User(1, "Vũ Ngọc Long", 23, "Chính Kinh"));
        users.add(new User(2, "Vũ Thị Chà My", 29, "Duy Tân"));
        users.add(new User(3, "Phan Khánh Huyền", 24, "Duy Tân"));
        users.add(new User(4, "Phạm Thúy Nga", 22, "Thị Trấn Vôi"));
        users.add(new User(5, "Phan Hiền", 23, "Thị Trấn Vôi"));

        User user = users.stream().filter(x -> x.id == id).collect(Collectors.toList()).get(0);
        if(user == null)
            throw new AppException(404, "User not found");

        return user;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class User {
        private int id;
        private String name;
        private int age;
        private String address;
    }

    private ArrayList<User> userList() {
        ArrayList<User> users = new ArrayList<User>();

        return users;
    }
}
