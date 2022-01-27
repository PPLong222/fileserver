package com.pplong.fileserver.mapper;

import com.pplong.fileserver.pojo.SingleFile;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FileMapper {
    List<SingleFile> queryAllFiles();

    int queryTotalCount();

    long queryTotalSize();

    int insertSingleFileRec(SingleFile file);

    int deleteSingleFile(String name);


}

