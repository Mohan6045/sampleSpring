package com.tomboy.SpringBoot.LearnTour.Error;

public class DepartmentNotFoundExpection extends Exception{

    public DepartmentNotFoundExpection() {

        super();
    }

    public DepartmentNotFoundExpection(String message) {
        super(message);
    }

    public DepartmentNotFoundExpection(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentNotFoundExpection(Throwable cause) {
        super(cause);
    }

    protected DepartmentNotFoundExpection(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
