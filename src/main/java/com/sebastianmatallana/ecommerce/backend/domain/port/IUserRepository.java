package com.sebastianmatallana.ecommerce.backend.domain.port;

import com.sebastianmatallana.ecommerce.backend.domain.model.User;

public interface IUserRepository {
    User save(User user);
    User findByEmail(String email);
    User findById(Integer id);
}
