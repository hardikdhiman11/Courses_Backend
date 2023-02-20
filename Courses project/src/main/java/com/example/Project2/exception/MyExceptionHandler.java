package com.example.Project2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Not Found")
// This Will cause tight coupling, hence it is preffered not to use this
public class MyExceptionHandler extends Exception
{

}
