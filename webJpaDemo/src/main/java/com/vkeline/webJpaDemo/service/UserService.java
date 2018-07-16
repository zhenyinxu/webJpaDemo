package com.vkeline.webJpaDemo.service;

import com.vkeline.webJpaDemo.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {

    //保存一条记录
    int saveOne(UserEntity userEntity);

    //查询一条
    Optional<UserEntity> findOne(String id);

    // 查询所有
    List<UserEntity> findAll();

    //通过名字查询，忽略大小写
    List<UserEntity> findByNameIgnoreCase(String name);

    List<UserEntity> findByNameOrderByAgeDesc(String name);

    List<UserEntity> findTop3ByOrderByAgeDesc();

    Page<UserEntity> queryFirst3ByName(String name, Pageable pageable);

    UserEntity findByName(String name);

    UserEntity findByLikeLy_Name(String name);

    /**
     *
     * querydsl 的例子在下方
     */
    Optional<UserEntity> findOneByNameAndAge(String name,Integer age);
}
