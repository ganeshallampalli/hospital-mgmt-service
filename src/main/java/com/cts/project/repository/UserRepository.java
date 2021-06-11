package com.cts.project.repository;

import com.cts.project.models.ERole;
import com.cts.project.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    Page<User> findByRoleAndFirstNameOrEmailIdLike(ERole role, String firstName, String emailId, Pageable page);

    Page<User> findAllByRole(ERole role, Pageable page);

    User findOneByUsernameAndPassword(String userName, String password);

}
