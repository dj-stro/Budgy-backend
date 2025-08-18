package za.dj.budgy.service;

import za.dj.budgy.model.AppUser;
import za.dj.budgy.repository.UserRepository;

import java.util.List;

public interface UserService {
    List<AppUser> getAll();
    void create(AppUser user);
}
