package com.test.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import java.util.ArrayList;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@JsonInclude(value = Include.NON_NULL)
public class Response<T> implements Serializable {
  ArrayList<T> data;
  long recordsTotal;
  int statusCode;
  String message;

  public static <T> Response<T> errorResponse(int code, String message) {
    Response<T> response = new Response<>();
    response.setStatusCode(code);
    response.setMessage(message);
    response.setRecordsTotal(0);
    response.setData(new ArrayList<>());
    return response;
  }

  public static <T> Response<T> okResponse() {
    Response<T> response = new Response<>();
    response.setStatusCode(HttpStatus.OK.value());
    response.setMessage(HttpStatus.OK.name());
    return response;
  }

}
