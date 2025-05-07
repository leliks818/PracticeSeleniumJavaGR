package patterns.bilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

public class LoginLombok {

    @Data /// Генерирует геттеры, сеттеры, toString(), equals(), hashCode()
    @Builder(toBuilder = true) /// Позволяет использовать Builder и toBuilder для изменения объектов и клона
    @AllArgsConstructor // Генерирует конструктор с параметрами
    public static class User {
        private String user;
        private String password;
    }

//    public static void main(String[] args) {
//        // Создание объекта пользователя через Builder
//        User user1 = User.builder()
//                .user("user")
//                .password("user")
//                .build();
    }
//        System.out.println(user1);