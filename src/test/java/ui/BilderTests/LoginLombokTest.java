package ui.BilderTests;

import org.junit.jupiter.api.Test;
import patterns.bilder.LoginLombok;

import static org.junit.jupiter.api.Assertions.*;

public class LoginLombokTest {

    // Тест 1: Проверка создания объекта через Builder
    @Test
    public void testCreateUserUsingBuilder() {
        // Создание пользователя через Builder
        LoginLombok.User user = LoginLombok.User.builder()
                .user("john_doe")
                .password("initial_password")
                .build();

        // Проверка значений полей
        assertEquals("john_doe", user.getUser());
        assertEquals("initial_password", user.getPassword());
    }

    // Тест 2: Проверка изменения юзера через toBuilder
    @Test
    public void testChangePasswordUsingToBuilder() {
        // Создание пользователя через Builder
        LoginLombok.User user = LoginLombok.User.builder()
                .user("alice_smith")
                .password("old_password")
                .build();

        // Изменение user через toBuilder
        LoginLombok.User updatedUser = user.toBuilder()
                .user("Ira123")
                .build();

        // Проверка изменений
        assertEquals("alice_smith", updatedUser.getUser());
        assertEquals("Ira123", updatedUser.getPassword());  // Новый username должен быть обновлён
        assertNotEquals(user.getUser(), updatedUser.getUser());  // username должен измениться
    }
    }
