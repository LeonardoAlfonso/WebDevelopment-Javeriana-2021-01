package com.webDevelopment.inventorySytemDDD.usersTests.unit;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.webDevelopment.inventorySytemDDD.Users.User.Application.Create.UserCreator;
import com.webDevelopment.inventorySytemDDD.Users.User.Application.Find.UserFinder;
import com.webDevelopment.inventorySytemDDD.Users.User.Application.Update.UserModifier;
import com.webDevelopment.inventorySytemDDD.Users.User.Domain.User;
import com.webDevelopment.inventorySytemDDD.Users.User.Domain.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class UsersTest {

    @Test
    void should_create_user() {
        UserRepository repository = mock(UserRepository.class);
        UserCreator creator = new UserCreator(repository);

        User actualUser = new User("some-1234", "Pinocho", "Ni idea", "PinochoMaderita", "maderita123");

        creator.execute("some-1234", "Pinocho", "Ni idea", "PinochoMaderita", "maderita123");

        verify(repository, atLeastOnce()).save(actualUser);
    }

    @Test
    void should_find_user() {
        User user = new User("some-1234", "Pinocho", "Ni idea", "PinochoMaderita", "maderita123");
        UserRepository repository = mock(UserRepository.class);
        Mockito.when(repository.find("some-1234")).thenReturn(Optional.of(user));
        UserFinder finder = new UserFinder(repository);

        assertEquals(user, finder.execute("some-1234"));
    }

    @Test
    void should_update_user() {
        User user = new User("some-1234", "Pinocho", "Ni idea", "PinochoMaderita", "maderita123");
        User userEdited = new User("some-1234", "Caperucita", "Ni idea", "PinochoMaderita", "maderita123");
        UserRepository repository = mock(UserRepository.class);
        Mockito.when(repository.find("some-1234")).thenReturn(Optional.of(user));
        Mockito.when(repository.update("some-1234", userEdited)).thenReturn(userEdited);
        UserModifier modifier = new UserModifier(repository);

        assertEquals(userEdited, modifier.execute("some-7894", userEdited));
    }

}
