package com.PZ.AnkietBud.database;

import com.PZ.AnkietBud.AnkietBudApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Map;

import static java.sql.DriverManager.getConnection;

//set database before the server starts
@Component
public class DatabaseConfig {

    private static final Logger log = LoggerFactory.getLogger(AnkietBudApplication.class);

//    triggered after bean creation, but before the server starts
    @EventListener(ContextRefreshedEvent.class)
    public void onStart() throws Exception {
        System.out.println("hello world, I have just started up");
        log.info("logger");
    }

    @Value("${spring.datasource.url}")
    private String dbUrl;

}
