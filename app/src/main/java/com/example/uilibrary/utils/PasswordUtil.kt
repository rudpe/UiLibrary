package com.example.uilibrary.utils

import java.util.regex.Pattern

object PasswordUtil {
    fun isPasswordValid(password: String): Boolean =
        Pattern.compile("^" +
                "(?=.*[0-9])" +         //at least 1 digit
                "(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[?=#/%])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{8,}" +               //at least 8 characters
                "$").matcher(password).matches()
}