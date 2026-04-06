package br.edu.utfpr.pb.pw44s.server.controller;

import br.edu.utfpr.pb.pw44s.server.dto.UserDTO;
import br.edu.utfpr.pb.pw44s.server.mapper.UserMapper;
import br.edu.utfpr.pb.pw44s.server.model.User;
import br.edu.utfpr.pb.pw44s.server.repository.UserRepository;
import br.edu.utfpr.pb.pw44s.server.service.UserService;
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService) {
    public UserController(UserService userService,
                UserMapper userMapper) {
            this.userService = userService;
            this.userMapper = userMapper;
        }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public void create(@RequestBody @Valid User user) {
            userService.save( user );
            public void create(@RequestBody @Valid UserDTO user) {
                userService.save( userMapper.toEntity(user) );

                log.info("User created");
            }