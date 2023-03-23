package com.example.studentregistration.constant;

public enum Subject {

    ENGLISH("English"),
    MATH("Math"),
    CHEMISTRY("Chemistry"),
    PHYSICS("Physics"),
    BIO("Bio"),
    ECO("Eco");

    private final String value;

    private Subject(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
