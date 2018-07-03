package com.test.exception;

import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.test.dto.Response;

@ControllerAdvice
@ResponseBody
@Slf4j
public class ExceptionHandler {

  @org.springframework.web.bind.annotation.ExceptionHandler({BadRequestException.class})
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public Response handleBadRequest(HttpServletRequest req, Exception exception) {
    log.error("A BadRequestException exception occurred ", exception);
    BaseException baseApiException = (BaseException) exception;
    return createErrorResponse(baseApiException.getErrorCode(),
        baseApiException.getMessage());
  }

  @org.springframework.web.bind.annotation.ExceptionHandler({ExpectationFailedException.class})
  @ResponseStatus(value = HttpStatus.EXPECTATION_FAILED)
  public Response handleExpectationFailed(HttpServletRequest req, Exception exception) {
    log.error("An ExpectationFailedException exception occurred ", exception);
    BaseException baseApiException = (BaseException) exception;
    return createErrorResponse(baseApiException.getErrorCode(),
            baseApiException.getMessage());
  }



  private Response createErrorResponse(Integer errorCode, String errorMessage) {
    Response response = new Response();
    response.setStatusCode(errorCode);
    response.setMessage(errorMessage);
    return response;
  }
}
