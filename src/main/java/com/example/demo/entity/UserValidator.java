package com.example.demo.entity;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User st = (User) o;
        if(st.getUsername().equals("Truong")){
            errors.rejectValue("username",null,"Rieng anh ko dang ky dc");
        }
    }
}
