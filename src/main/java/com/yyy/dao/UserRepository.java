/**
 * Author: 老洋
 * Date:  2021/6/5 17:12
 */
package com.yyy.dao;


import com.yyy.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsernameAndPassword(String username, String password);
}