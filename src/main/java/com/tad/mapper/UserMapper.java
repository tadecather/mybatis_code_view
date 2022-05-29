package com.tad.mapper;

import com.tad.dto.UserInfoDto;

/**
 * UserMapper
 *
 * @author liubin
 * @date 2022/5/29
 */
public interface UserMapper {

    UserInfoDto getUserById(int userId);
}
