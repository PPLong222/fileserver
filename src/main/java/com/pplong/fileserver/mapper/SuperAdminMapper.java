package com.pplong.fileserver.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SuperAdminMapper {
    int login(String pwd);
}
