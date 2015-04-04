package com.github.danielsoro.produces;

import com.github.danielsoro.myobjects.Session;
import com.github.danielsoro.qualifiers.Parameter;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 * @author <a href="mailto:danielsoro@gmail.com">Daniel Cunha (soro)</a>
 */
public class SessionProduce {

    @Produces
    public Session createSession(InjectionPoint injectionPoint) {
        Parameter annotation = injectionPoint.getAnnotated().getAnnotation(Parameter.class);
        if (annotation == null) {
            return new Session(null);
        }
        return new Session(annotation.value());
    }
}
