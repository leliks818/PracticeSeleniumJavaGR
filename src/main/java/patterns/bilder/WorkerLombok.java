package patterns.bilder;

import lombok.AllArgsConstructor;     // Создаёт конструктор со всеми аргументами
import lombok.Builder;                // Позволяет использовать паттерн Builder
import lombok.Data;                   // Генерирует геттеры, сеттеры, toString(), equals(), hashCode()
import lombok.NoArgsConstructor;      // Создаёт конструктор без аргументов

public class WorkerLombok {

    @Data // = генерирует геттеры/сеттеры, toString(), equals(), hashCode()
    @Builder(toBuilder = true) // = позволяет создать объект через .builder() + toBuilder() даёт возможность клонировать и изменять копию
    @NoArgsConstructor // = создаёт пустой конструктор без аргументов
    @AllArgsConstructor // = создаёт конструктор, где параметры — все поля класса
    public static class Worker {
        private String name;     // имя работника
        private String position; // должность
        private int age;         // возраст
        private double salary;   // зарплата
    }

}
