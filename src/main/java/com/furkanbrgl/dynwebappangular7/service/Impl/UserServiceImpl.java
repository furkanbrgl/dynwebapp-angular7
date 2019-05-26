package com.furkanbrgl.dynwebappangular7.service.Impl;

import com.furkanbrgl.dynwebappangular7.config.security.JwtAuthenticationFilter;
import com.furkanbrgl.dynwebappangular7.dto.RegistrationRequest;
import com.furkanbrgl.dynwebappangular7.dto.UserDto;
import com.furkanbrgl.dynwebappangular7.entity.User;
import com.furkanbrgl.dynwebappangular7.repository.UserRepository;
import com.furkanbrgl.dynwebappangular7.service.UserService;
import com.furkanbrgl.dynwebappangular7.util.TPage;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    final static Logger log = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

   @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserDto save(UserDto user) {
        User u = modelMapper.map(user, User.class);
        u = userRepository.save(u);
        user.setId(u.getId());
        return user;
    }

    @Override
    public UserDto getById(Long id) {
        User u = userRepository.getOne(id);
        return modelMapper.map(u, UserDto.class);
    }

    @Override
    public TPage<UserDto> getAllPageable(Pageable pageable) {
        Page<User> data = userRepository.findAll(pageable);
        TPage<UserDto> respnose = new TPage<UserDto>();
        respnose.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), UserDto[].class)));
        return respnose;
    }

    @Override
    public UserDto getByUsername(String username) {
        User u = userRepository.findByUsername(username);
        return modelMapper.map(u, UserDto.class);
    }

    @Transactional
    public Boolean register(RegistrationRequest registrationRequest) {
        try {
            User user = new User();
            user.setEmail(registrationRequest.getEmail());
            user.setNameSurname(registrationRequest.getNameSurname());
            user.setPassword(bCryptPasswordEncoder.encode(registrationRequest.getPassword()));
            user.setUsername(registrationRequest.getUsername());
            userRepository.save(user);
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("REGISTRATION=>", e);
            return Boolean.FALSE;
        }
    }
}
