package com.ljb.sbdemo.dao;

import com.ljb.sbdemo.models.model.UserDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UserMapper extends Mapper<UserDTO> {



}
