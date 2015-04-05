package com.github.danielsoro.myobjects;

import com.github.danielsoro.produces.Parameter;

import javax.inject.Inject;

/**
 * @author <a href="mailto:danielsoro@gmail.com">Daniel Cunha (soro)</a>
 */
public class SessionConstructorInjectionWithoutParameter {

    private Session session;

    @Inject
    public SessionConstructorInjectionWithoutParameter(Session session) {
        this.session = session;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
