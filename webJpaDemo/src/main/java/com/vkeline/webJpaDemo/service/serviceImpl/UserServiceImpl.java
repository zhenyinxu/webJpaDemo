package com.vkeline.webJpaDemo.service.serviceImpl;

import com.querydsl.core.types.Predicate;
import com.vkeline.webJpaDemo.dao.UserDao;
import com.vkeline.webJpaDemo.entity.QUserEntity;
import com.vkeline.webJpaDemo.entity.UserEntity;
import com.vkeline.webJpaDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int saveOne(UserEntity userEntity) {
        userDao.save(userEntity);
        return 1;
    }

    @Override
    public Optional<UserEntity> findOne(String id) {
        Optional<UserEntity> userEntity = userDao.findById(id);
        return userEntity;
    }

    @Override
    public List<UserEntity> findAll() {
        return userDao.findAll();
    }

    @Override
    public List<UserEntity> findByNameIgnoreCase(String name) {
        return userDao.findByNameIgnoreCase(name);
    }

    @Override
    public List<UserEntity> findByNameOrderByAgeDesc(String name) {
        return userDao.findByNameOrderByAge(name);
    }

    @Override
    public List<UserEntity> findTop3ByOrderByAgeDesc() {
        return userDao.findTop3ByOrderByAgeDesc();
    }

    @Override
    public Page<UserEntity> queryFirst3ByName(String name, Pageable pageable) {
        Page<UserEntity> userEntities = userDao.queryFirst3ByName(name, pageable);
        return userEntities;
    }

    @Override
    public UserEntity findByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public UserEntity findByLikeLy_Name(String name) {
        return userDao.findByLikeLy_Name(name);
    }

    /**
     *
     * querydsl 的例子（下方）
     *
     * */

    @Override
    public Optional<UserEntity> findOneByNameAndAge(String name, Integer age) {
        QUserEntity qUserEntity = QUserEntity.userEntity;
        Predicate predicate = qUserEntity.name.eq(name).and(qUserEntity.age.eq(age));
        return userDao.findOne(predicate);
    }


}
