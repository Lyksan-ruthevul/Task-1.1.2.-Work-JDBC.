package jm.task.core.jdbc;


import jm.task.core.jdbc.model.User;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {
    public static void main(String[] args) {
        User[] users = {
                new User("Denis", "Pepsi", (byte) 24),
                new User("Ivan", "Oldrus", (byte) 100),
                new User("Sergeo", "Morello", (byte) 40),
                new User("Dude", "Coolov", (byte) 12)};

        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        for (User user : users) {
            userService.saveUser(user.getName(), user.getLastName(), user.getAge());
            System.out.printf("User с именем – %s добавлен в базу данных\n", user.getName());
        }
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
