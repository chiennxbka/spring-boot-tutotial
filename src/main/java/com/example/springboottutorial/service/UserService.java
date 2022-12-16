package com.example.springboottutorial.service;

import com.example.springboottutorial.payload.UserPayload;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface UserService {

    void save(UserPayload payload, HttpServletRequest request) throws IOException;
}
