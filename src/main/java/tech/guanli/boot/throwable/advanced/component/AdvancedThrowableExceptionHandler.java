package tech.guanli.boot.throwable.advanced.component;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;
import tech.guanli.boot.internal.model.Returnable;
import tech.guanli.boot.internal.model.implemention.ResponseData;
import tech.guanli.boot.throwable.exception.AuthenticationException;
import tech.guanli.boot.throwable.exception.BusinessException;
import tech.guanli.boot.throwable.exception.ErrorCodeConstant;
import tech.guanli.boot.throwable.exception.ForbbidenException;
import tech.guanli.boot.throwable.exception.IllegalRequestArgumentException;
import tech.guanli.boot.throwable.exception.NotFoundException;
import tech.guanli.boot.throwable.exception.OuterServiceException;
import tech.guanli.boot.throwable.exception.TargetStatusException;

@RestControllerAdvice
@Slf4j
public class AdvancedThrowableExceptionHandler {

	@ExceptionHandler(Exception.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public Returnable handle(Exception exception) {
		log.warn("unknown_exception：", exception);
		return ResponseData.failed(HttpStatus.INTERNAL_SERVER_ERROR.value(), "System is busy!");
	}

	@ExceptionHandler(IllegalRequestArgumentException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public Returnable handle(IllegalRequestArgumentException exception) {
		log.warn("illegal_request_argument：", exception);
		return ResponseData.failed(ErrorCodeConstant.ILLEGAL_REQUEST_ARGUMENT, exception.getMessage());
	}

	@ExceptionHandler(AuthenticationException.class)
	@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
	public Returnable handle(AuthenticationException exception) {
		log.warn("authentication_exception：", exception);
		return ResponseData.failed(ErrorCodeConstant.AUTHENTICATION, exception.getMessage());
	}

	@ExceptionHandler(BusinessException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public Returnable handle(BusinessException exception) {
		log.warn("business_exception:", exception);
		return ResponseData.failed(ErrorCodeConstant.BUSINESS, exception.getMessage());
	}

	@ExceptionHandler(ForbbidenException.class)
	@ResponseStatus(code = HttpStatus.FORBIDDEN)
	public Returnable handle(ForbbidenException exception) {
		log.warn("forbbiden_access:", exception);
		return ResponseData.failed(ErrorCodeConstant.FORBBIDEN, exception.getMessage());
	}

	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public Returnable handle(NotFoundException exception) {
		log.warn("not_found_exception:", exception);
		return ResponseData.failed(ErrorCodeConstant.NOT_FOUNT, exception.getMessage());
	}

	@ExceptionHandler(OuterServiceException.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public Returnable handle(OuterServiceException exception) {
		log.warn("outer_service:", exception);
		return ResponseData.failed(ErrorCodeConstant.OUTER_SERVICE, exception.getMessage());
	}

	@ExceptionHandler(TargetStatusException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public Returnable handle(TargetStatusException exception) {
		log.warn("invaild_target_status", exception);
		return ResponseData.failed(ErrorCodeConstant.TARGET_STATUS, exception.getMessage());
	}
}
