package com.github.douglsantos.experiments;


import avro.example.entity.UserAvroEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDomain toDomain(UserAvroEntity userEntity);
}
