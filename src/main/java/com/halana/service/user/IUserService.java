package com.halana.service.user;

import com.halana.model.user.User;
import com.halana.service.IBaseService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface IUserService extends IBaseService<User>, UserDetailsService {
    Optional<User> findByUsername(String username);

    List<User> findUsersByProjectId(Long projectId);

    Optional<User> findByEmail(String email);

    List<String> findAllEmail();

    List<User> findAllByBoardId(Long boardId);

    List<User> findAllByTaskId(Long taskId);
}
