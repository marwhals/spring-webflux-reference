package org.webflux_reference.spring_r2dbc.repository;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {"section=spring_r2dbc", "logging.level.org.springframework.r2dbc=DEBUG"})
public abstract class AbstractTest {

}