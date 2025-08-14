package com.sebastianmatallana.ecommerce.backend.infrastructure.adapter;

import com.sebastianmatallana.ecommerce.backend.domain.model.User;
import com.sebastianmatallana.ecommerce.backend.domain.port.IUserRepository;
import com.sebastianmatallana.ecommerce.backend.infrastructure.mapper.UserMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserCrudRepositoryImpl implements IUserRepository {
    private final IUserCrudRepository iUserCrudRepository;
    private final UserMapper userMapper;

    public UserCrudRepositoryImpl(IUserCrudRepository iUserCrudRepository, UserMapper userMapper) {
        this.iUserCrudRepository = iUserCrudRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User save(User user) {
        return userMapper.toUser(iUserCrudRepository.save(userMapper.toUserEntity(user)));
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User findById(Integer id) {
        return userMapper.toUser(
                iUserCrudRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id))
        );
    }
}
