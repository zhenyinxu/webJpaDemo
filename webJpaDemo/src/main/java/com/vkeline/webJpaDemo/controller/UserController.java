package com.vkeline.webJpaDemo.controller;

import com.vkeline.webJpaDemo.dao.UserDao;
import com.vkeline.webJpaDemo.entity.QHometownEntity;
import com.vkeline.webJpaDemo.entity.QUserEntity;
import com.vkeline.webJpaDemo.entity.UserEntity;
import com.vkeline.webJpaDemo.entity.dto.UserMsgDto;
import com.vkeline.webJpaDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/index")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;

    @RequestMapping("/home")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/index");
        return mv;
    }


    @RequestMapping("/save")
    public void saveAction(){

        UserEntity userEntity = new UserEntity();
        userEntity.setId(UUID.randomUUID().toString());
        userEntity.setAge(23);
        userEntity.setGender(true);
        userEntity.setName("john");

        userService.saveOne(userEntity);
    }

    @RequestMapping("findOne")
    public void findOneAction(){

        Optional<UserEntity> userOptional = userService.findOne("123123");
        System.out.println(userOptional.get());
    }

    @RequestMapping("findAll")
    public void findAll(){
        List<UserEntity> entityList = userService.findAll();
        for (UserEntity entity : entityList) {
            System.out.println(entity);
        }

    }

    @RequestMapping("findByNameIgnoreCase")
    public void findAllByNameIgnoreCase(){

        List<UserEntity> entityList = userService.findByNameIgnoreCase("tom");
        for (UserEntity entity : entityList){
            System.out.println(entity);
        }
    }


    @RequestMapping("findByNameOrderByAgeDesc")
    public void findByNameOrderByAgeDesc(){

        List<UserEntity> entityList = userService.findByNameOrderByAgeDesc("tom");
        for (UserEntity entity : entityList){
            System.out.println(entity);
        }
    }

    @RequestMapping("findTop3ByOrderByAgeDesc")
    public void findTop3(){
        List<UserEntity> entityList = userService.findTop3ByOrderByAgeDesc();
        for (UserEntity entity : entityList){
            System.out.println(entity);
        }
    }

    @RequestMapping("findPaging")
    public void findPaging(){
        Pageable pageable = PageRequest.of(0,3, Direction.DESC,"id");
        Page<UserEntity> userEntityPage = userService.queryFirst3ByName("john", pageable);
        List<UserEntity> content = userEntityPage.getContent();
        for (UserEntity user : content){
            System.out.println(user);
        }
    }

    @RequestMapping("findByName")
    public void findByName(){
        UserEntity userEntity = userService.findByName("joe");
        System.out.println(userEntity);
    }

    @RequestMapping("findByLikeLy_Name")
    public void findByLikeLy_Name(){
        UserEntity userEntity = userService.findByLikeLy_Name("oe");
        System.out.println(userEntity);
    }

    /**
     * 复杂查询... querydsl
     * */

    @RequestMapping("findByNameAndAge")
    public void findByNameAndAge(){

        Optional<UserEntity> john = userService.findOneByNameAndAge("joe", 43);
        System.out.println(john.get());
    }


    /**
     * 使用@Query+结果集接口做复杂操作
     * */

    @RequestMapping("findOneByCity")
    public void findOneByCity(){
        UserMsgDto userMsgDto = userDao.findOneByCity("常州");
        System.out.println(userMsgDto.getCity());
    }


    public void findOneByCityQuerydsl(){
        QUserEntity qUserEntity = QUserEntity.userEntity;
        QHometownEntity qHometownEntity = QHometownEntity.hometownEntity;

    }

}
