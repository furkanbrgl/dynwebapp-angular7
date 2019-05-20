package com.furkanbrgl.dynwebappangular7.service;

import com.furkanbrgl.dynwebappangular7.dto.UserDto;
import com.furkanbrgl.dynwebappangular7.util.TPage;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserDto save(UserDto user);

    UserDto getById(Long id);

    TPage<UserDto> getAllPageable(Pageable pageable);

    UserDto getByUsername(String username);
}