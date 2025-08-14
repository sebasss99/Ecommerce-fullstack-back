package com.sebastianmatallana.ecommerce.backend.application;

import com.sebastianmatallana.ecommerce.backend.domain.model.User;
import com.sebastianmatallana.ecommerce.backend.domain.port.IUserRepository;

public class UserService {
    private final IUserRepository iUserRepository;

    public UserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    public User save(User user) {
        return this.iUserRepository.save(user);
    }
    public User findById (Integer id) {
        return this.iUserRepository.findById(id);
    }
}
