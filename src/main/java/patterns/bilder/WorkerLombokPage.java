package patterns.bilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class WorkerLombokPage {

    @Data // = генерирует геттеры/сеттеры, toString(), equals(), hashCode()
    @Builder(toBuilder = true) // = позволяет создать объект через .builder() + toBuilder() даёт возможность клонировать и изменять копию
    @NoArgsConstructor // = создаёт пустой конструктор без аргументов
    @AllArgsConstructor // = создаёт конструктор, где параметры — все поля класса
    public static class Worker {
        private String name;
        private String position;
        private int age;
        private double salary;
    }
}
