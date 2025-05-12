package ui.BilderTests;

import org.junit.jupiter.api.Test;
import patterns.bilder.LoginLombokPage;

import static org.junit.jupiter.api.Assertions.*;

public class LoginLombokTest {

    // Тест 1: Проверка создания объекта через Builder
    @Test
    public void testCreateUserUsingBuilder() {
        // Создание пользователя через Builder
        LoginLombokPage.User user = LoginLombokPage.User.builder()
                .user("john_doe")
                .password("initial_password")
                .build();

        assertEquals("john_doe", user.getUser());
        assertEquals("initial_password", user.getPassword());
    }

    // Тест 2: Проверка изменения юзера через toBuilder
    @Test
    public void testChangePasswordUsingToBuilder() {
        // Создание пользователя через Builder
        LoginLombokPage.User user = LoginLombokPage.User.builder()
                .user("alice_smith")
                .password("old_password")
                .build();

        // Изменение user через toBuilder
        LoginLombokPage.User updatedUser = user.toBuilder()
                .user("Ira123")
                .build();

        assertEquals("Ira123", updatedUser.getUser());             // Проверяем новое имя
        assertEquals("old_password", updatedUser.getPassword());   // Пароль не менялся
        assertNotEquals(user.getUser(), updatedUser.getUser());    // Убедиться, что имя пользователя обновилось
    }
    }
