package com.vkeline.webJpaDemo.dao;

import com.vkeline.webJpaDemo.entity.UserEntity;
import com.vkeline.webJpaDemo.entity.dto.UserMsgDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserDao extends JpaRepository<UserEntity, String>,
        PagingAndSortingRepository<UserEntity, String>,QuerydslPredicateExecutor<UserEntity> {

    /**
     * 除了此接口中已定义的以外，其他方法可以在这里定义，只要定义的格式符合JPA的定义要求
     * */

    //忽略大小写，通过name查询
    List<UserEntity> findByNameIgnoreCase(String name);

    //倒序，通过name查询
    List<UserEntity> findByNameOrderByAge(String name);

    //查找数据库中前3条记录,以年龄排序
    List<UserEntity> findTop3ByOrderByAgeDesc();

    //
    Page<UserEntity> queryFirst3ByName(String name, Pageable pageable);


    //使用@Query注解
    @Query("select u from UserEntity u where u.name = ?1")
    UserEntity findByName(String name);

    //使用like ... （不谈）

    // 使用原生SQL
    @Query(value = "select * from t_user u where u.name like %?%1", nativeQuery = true)
    UserEntity findByLikeLy_Name(String name);



    /**
     * 利用结果集接口类+@Query注解做复杂查询
     * */

    @Query(value = "select u.id, u.name, h.city from t_user u left join t_hometown h on u.id = h.id_fk where h.city = ?1", nativeQuery = true)
    UserMsgDto findOneByCity(String city);




    /**
     * querydsl 例子在下方
     * */




}
