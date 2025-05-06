package ui.BilderTests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import patterns.bilder.WorkerLombok.Worker;

public class WorkerLombokTest {

        // Тест 1: Проверка создания объекта через конструктор (с использованием @AllArgsConstructor)
        @Test
        public void testCreateWorkerUsingConstructor() {
            Worker worker = new Worker("John", "Developer", 30, 5000.0);

            // Проверка значений полей
            assertEquals("John", worker.getName());
            assertEquals("Developer", worker.getPosition());
            assertEquals(30, worker.getAge());
            assertEquals(5000.0, worker.getSalary());
        }

        // Тест 2: Проверка создания объекта через Builder (с использованием @Builder)
        @Test
        public void testCreateWorkerUsingBuilder() {
            Worker worker = Worker.builder()
                    .name("Jane")
                    .position("Manager")
                    .age(28)
                    .salary(7000.0)
                    .build();

            // Проверка значений полей
            assertEquals("Jane", worker.getName());
            assertEquals("Manager", worker.getPosition());
            assertEquals(28, worker.getAge());
            assertEquals(7000.0, worker.getSalary());
        }

        // Тест 3: Проверка изменения оклада через toBuilder (с использованием @Builder + toBuilder)
        @Test
        public void testChangeSalaryUsingToBuilder() {
            // Создание объекта через Builder
            Worker worker = Worker.builder()
                    .name("Alice")
                    .position("Engineer")
                    .age(32)
                    .salary(6000.0)
                    .build();

            // Изменение оклада через toBuilder
            Worker updatedWorker = worker.toBuilder()
                    .salary(7500.0) // изменяем только зарплату
                    .build();

            // Проверка изменений
            assertEquals(7500.0, updatedWorker.getSalary());
            assertEquals("Alice", updatedWorker.getName());  // остальные значения должны остаться без изменений
            assertEquals("Engineer", updatedWorker.getPosition());
            assertEquals(32, updatedWorker.getAge());
        }

        // Тест 4: Проверка клонирования объекта и изменения оклада с помощью toBuilder
        @Test
        public void testCloneAndModifySalary() {
            Worker worker = Worker.builder()
                    .name("Bob")
                    .position("Architect")
                    .age(35)
                    .salary(8000.0)
                    .build();

            // Клонируем объект и изменяем только оклад
            Worker clonedWorker = worker.toBuilder()
                    .salary(8500.0)
                    .build();

            // Проверка, что оклад изменился, а остальные параметры остались теми же
            assertNotEquals(worker.getSalary(), clonedWorker.getSalary());
            assertEquals("Bob", clonedWorker.getName());
            assertEquals("Architect", clonedWorker.getPosition());
            assertEquals(35, clonedWorker.getAge());
        }
    }
