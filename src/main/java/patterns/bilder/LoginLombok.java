package patterns.bilder;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

public class LoginLombok {

    @Data // Генерирует геттеры, сеттеры, toString(), equals(), hashCode()
    @Builder(toBuilder = true) // Позволяет использовать Builder и toBuilder для изменения объектов
    @AllArgsConstructor // Генерирует конструктор с параметрами
    public static class User {
        private String user;     // Имя пользователя
        private String password; // Пароль пользователя
    }

    public static void main(String[] args) {
        // Создание объекта пользователя через Builder
        User user1 = User.builder()
                .user("john_doe")
                .password("initial_password")
                .build();
    }
}