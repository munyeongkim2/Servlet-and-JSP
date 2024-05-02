package com.nhnacademy.day3;

import com.nhnacademy.day3.controller.ControllerFactory;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

@Slf4j
@HandlesTypes(
        value = {
                com.nhnacademy.day3.controller.Command.class
        }
)
public class WebAppInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {

        ControllerFactory controllerFactory = new ControllerFactory();
        controllerFactory.init(c);
        ctx.setAttribute("controllerFactory", controllerFactory);

    }

}
