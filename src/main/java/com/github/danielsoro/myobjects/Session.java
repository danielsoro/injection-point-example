package com.github.danielsoro.myobjects;

/**
 * @author <a href="mailto:danielsoro@gmail.com">Daniel Cunha (soro)</a>
 */
public class Session {
    private String annotationValue;

    public Session(String annotationValue) {
        this.annotationValue = annotationValue;
    }

    public String getAnnotationValue() {
        return annotationValue;
    }

    public void setAnnotationValue(String annotationValue) {
        this.annotationValue = annotationValue;
    }
}
