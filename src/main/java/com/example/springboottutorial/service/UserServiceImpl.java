package com.example.springboottutorial.service;

import com.example.springboottutorial.dao.UserRepository;
import com.example.springboottutorial.model.User;
import com.example.springboottutorial.payload.UserPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Value("${static.file.location}")
    private String staticResource;

    @Override
    public void save(UserPayload payload, HttpServletRequest request) throws IOException {
        // insert user information into database
        User user = new User();
        user.toEntity(payload);
        // save avatar to hard disk
        FileOutputStream stream = null;
        if (StringUtils.hasText(payload.getAvatar().getOriginalFilename())) {
            MultipartFile avatar = payload.getAvatar();
            try {
                Path p = Paths.get(staticResource);
                if (!Files.exists(p))
                    Files.createDirectories(p);
                File file = new File(staticResource + avatar.getOriginalFilename());
                file.createNewFile();
                stream = new FileOutputStream(file);
                stream.write(avatar.getBytes());
            } catch (IOException exception) {
                throw new RuntimeException();
            } finally {
                if (stream != null) stream.close();
            }
            String uri = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
            user.setAvatar(uri.concat(File.separator).concat("public").concat(File.separator).concat(avatar.getOriginalFilename()));
        }
        repository.save(user);
    }
}
