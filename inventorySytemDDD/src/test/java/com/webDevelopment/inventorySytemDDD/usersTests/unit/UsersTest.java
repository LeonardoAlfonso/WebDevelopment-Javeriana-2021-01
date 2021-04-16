package com.webDevelopment.inventorySytemDDD.usersTests.unit;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.webDevelopment.inventorySytemDDD.Shared.Domain.Users.UserId;
import com.webDevelopment.inventorySytemDDD.Users.User.Application.Create.UserCreator;
import com.webDevelopment.inventorySytemDDD.Users.User.Application.Find.UserFinder;
import com.webDevelopment.inventorySytemDDD.Users.User.Application.Update.UserModifier;
import com.webDevelopment.inventorySytemDDD.Users.User.Domain.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Optional;

@SpringBootTest
public class UsersTest {

    @Test
    void should_create_user() {
        UserRepository repository = mock(UserRepository.class);
        ValidateWordService service = mock(ValidateWordService.class);
        Mockito.when(service.validate("PinochoMaderita")).thenReturn(false);

        UserCreator creator = new UserCreator(repository, service);

        User actualUser = new User(new UserId("bb5f8ac3-b90d-40ec-b3e2-e0ca3f432721"), new UserName("Pinocho"), new UserLastName("Ni idea"),
                                    new UserNickName("PinochoMaderita"), new UserPassword("MaderiTa1*23"));

        creator.execute("bb5f8ac3-b90d-40ec-b3e2-e0ca3f432721", "Pinocho", "Ni idea", "PinochoMaderita",                                       "MaderiTa1*23");

        verify(repository, atLeastOnce()).save(actualUser);
    }

    @Test
    void should_find_user() {
        User user = new User(new UserId("bb5f8ac3-b90d-40ec-b3e2-e0ca3f432721"), new UserName("Pinocho"), new UserLastName("Ni idea"),
                new UserNickName("PinochoMaderita"), new UserPassword("MaderiTa1*23"));

        UserRepository repository = mock(UserRepository.class);
        Mockito.when(repository.find("bb5f8ac3-b90d-40ec-b3e2-e0ca3f432721")).thenReturn(Optional.of(user));

        UserFinder finder = new UserFinder(repository);

        assertEquals(user, finder.execute("bb5f8ac3-b90d-40ec-b3e2-e0ca3f432721"));
    }

    @Test
    void should_update_user() {
        User user = new User(new UserId("bb5f8ac3-b90d-40ec-b3e2-e0ca3f432721"),  new UserName("Pinocho"), new UserLastName("Ni idea"),
                             new UserNickName("PinochoMaderita"), new UserPassword("MaderiTa1*23"));
        User userEdited = new User(new UserId("bb5f8ac3-b90d-40ec-b3e2-e0ca3f432721"), new UserName("Caperucita"), new UserLastName("Ni idea2"),
                                   new UserNickName("CaperucitaCapa"), new UserPassword("MaderiTa1*23"));

        UserRepository repository = mock(UserRepository.class);
        ValidateWordService service = mock(ValidateWordService.class);
        Mockito.when(repository.find("bb5f8ac3-b90d-40ec-b3e2-e0ca3f432721")).thenReturn(Optional.of(user));
        Mockito.when(service.validate("CaperucitaCapa")).thenReturn(false);

        UserModifier modifier = new UserModifier(repository, service);

        modifier.execute("bb5f8ac3-b90d-40ec-b3e2-e0ca3f432721", "Caperucita", "Ni idea2", "CaperucitaCapa");

        verify(repository, atLeastOnce()).update("bb5f8ac3-b90d-40ec-b3e2-e0ca3f432721", userEdited);
    }
}
