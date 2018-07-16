package com.vkeline.webJpaDemo.entity;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QHometownEntity is a Querydsl query type for HometownEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHometownEntity extends EntityPathBase<HometownEntity> {

    private static final long serialVersionUID = -652212622L;

    public static final QHometownEntity hometownEntity = new QHometownEntity("hometownEntity");

    public final StringPath city = createString("city");

    public final StringPath id = createString("id");

    public final StringPath userId = createString("userId");

    public QHometownEntity(String variable) {
        super(HometownEntity.class, forVariable(variable));
    }

    public QHometownEntity(Path<? extends HometownEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHometownEntity(PathMetadata metadata) {
        super(HometownEntity.class, metadata);
    }

}

