package com.niltech.ShivajiSchool.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

import com.niltech.ShivajiSchool.annotations.PasswordValidator;

public class PasswordStrengthValidator implements ConstraintValidator<PasswordValidator, String> {

	List<String> weakPasswords;

	@Override
	public void initialize(PasswordValidator passwordValidator) {
		weakPasswords = Arrays.asList("12345", "password", "qwerty");
	}

	@Override
	public boolean isValid(String passwordField, ConstraintValidatorContext cxt) {
		return passwordField != null && (!weakPasswords.contains(passwordField));
	}
}
