package za.dj.budgy.service.impl;

import org.springframework.stereotype.Service;
import za.dj.budgy.model.AppUser;
import za.dj.budgy.repository.UserRepository;
import za.dj.budgy.service.UserService;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<AppUser> getAll() {
        return this.userRepository.findAll();
    }

    @Override
    public void create(AppUser user) {
        this.userRepository.save(user);
    }
}
