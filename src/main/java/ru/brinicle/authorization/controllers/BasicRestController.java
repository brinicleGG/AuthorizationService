package ru.brinicle.authorization.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.brinicle.authorization.model.ServiceUser;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api")
public class BasicRestController {

    private List<ServiceUser> SERVICE_USERS = Stream.of(
            new ServiceUser(1L, "Ivan", "Ivanov"),
            new ServiceUser(2L, "Sergey", "Sergeev"),
            new ServiceUser(3L, "Petr", "Petrov")
    ).collect(Collectors.toList());

    @GetMapping
    @PreAuthorize("hasAuthority('read')")
    public List<ServiceUser> getAll() {
        return SERVICE_USERS;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('read')")
    public ServiceUser getById(@PathVariable Long id) {
        return SERVICE_USERS.stream().filter(serviceUser -> serviceUser.getId().equals(id))
                .findFirst().orElse(null);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('write')")
    public ServiceUser create(@RequestBody ServiceUser serviceUser) {
        this.SERVICE_USERS.add(serviceUser);
        return serviceUser;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('write')")
    public void deleteById(@PathVariable Long id) {
        this.SERVICE_USERS.removeIf(serviceUser -> serviceUser.getId().equals(id));
    }

}
