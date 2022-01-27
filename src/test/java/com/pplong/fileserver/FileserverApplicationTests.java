package com.pplong.fileserver;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import javax.sql.DataSource;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;

@SpringBootTest
class FileserverApplicationTests {

    @Autowired
    DataSource dataSource;
    @Test
    void contextLoads() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            System.out.println(dataSource.getClass());
        }
    }
    @Test
    void getTime() {
        String name = DigestUtils.md5DigestAsHex("sdasd12312gfgasdas是打算sdasdasdasd".getBytes(StandardCharsets.UTF_8));
        System.out.println(name);

    }

}
