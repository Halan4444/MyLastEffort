package com.diosa.service.quizz.user;



import com.diosa.model.user.User;

import java.util.Optional;

public interface IUserService {
    //tim kiem co ton tai trong DB khong
    Optional<User> findByUsername(String name);
    //kt xem user da co torng DB chua khi tao du lieu
    Boolean existsByUsername(String name);
    //kt xem email da co torng DB chua khi tao du lieu
    Boolean existsByEmail(String email);
    User save(User user);
    void deleteById(Long id);
    Optional<User> findById(Long id);
    Iterable<User> showList();
}
