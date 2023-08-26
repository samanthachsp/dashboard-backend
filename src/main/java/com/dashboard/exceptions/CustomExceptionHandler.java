package com.dashboard.exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
 
//@SuppressWarnings({"unchecked","rawtypes"})
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler 
{
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add("Server Error");
        ErrorResponse error = new ErrorResponse("Server Error", details);
        return new ResponseEntity<Object>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
 
    @ExceptionHandler(ValidationException.class)
    public final ResponseEntity<Object> handleValidationExceptions(ValidationException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getMessage());
        ErrorResponse error = new ErrorResponse("Client Error", details);
        System.out.println("ex.getMessage() - " + ex.getMessage());
        return new ResponseEntity<Object>(error, HttpStatus.UNPROCESSABLE_ENTITY);
        
    }
    
    @ExceptionHandler(DataIntegrityViolationException.class)
    public final ResponseEntity<Object> handleValidationExceptions(DataIntegrityViolationException ex, WebRequest request) {
    	System.out.println("ConstraintViolationException - ex.getMessage() - " + ex.getMessage());
        List<String> details = new ArrayList<>();
       	details.add(ex.getMessage());
        ErrorResponse error = new ErrorResponse("Client Error", details);    
        return new ResponseEntity<Object>(error, HttpStatus.UNPROCESSABLE_ENTITY);
        
    }
    
    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<Object> handleValidationExceptions(ConstraintViolationException ex, WebRequest request) {
    	System.out.println("ConstraintViolationException - ex.getMessage() - " + ex.getMessage());
        List<String> details = ex.getConstraintViolations().stream().map(key -> key.getMessage()).collect(Collectors.toList());
        ErrorResponse error = new ErrorResponse("Client Error", details);    
        return new ResponseEntity<Object>(error, HttpStatus.UNPROCESSABLE_ENTITY);
        
    }
    
    @ExceptionHandler(ForbiddenException.class)
    public final ResponseEntity<Object> handleForbiddenExceptions(ForbiddenException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getMessage());
        ErrorResponse error = new ErrorResponse(ex.getStatus().getReasonPhrase(), details);
        return new ResponseEntity<Object>(error, ex.getStatus());
        
    }
    
    @ExceptionHandler(InternalServerException.class)
    public final ResponseEntity<Object> handlePasscodeSendExceptions(InternalServerException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("Server Error", details);
        return new ResponseEntity<Object>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        
    }
//    @ExceptionHandler(InternalServerException.class)
//    public void handlePasscodeSendExceptions(HttpServletResponse response) throws IOException {
//        response.sendError(HttpStatus.NOT_FOUND.value());
//    }
 
    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(RecordNotFoundException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("Record Not Found", details);
        return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> handleAccessDenied(HttpServletRequest request, AccessDeniedException ex) {
        List<String> details = new ArrayList<>();

        if (request.getUserPrincipal() == null) {
            details.add(ex.getMessage());
            return new ResponseEntity<Object>(new ErrorResponse("Invalid token", details), HttpStatus.UNAUTHORIZED);
        } else {
            details.add(ex.getMessage());
            return new ResponseEntity<Object>(new ErrorResponse("User has no access to this resource", details), HttpStatus.UNAUTHORIZED);
        }
    }
    
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<?> handleMaxFileSizeExceeded(HttpServletRequest request, MaxUploadSizeExceededException ex) {
        List<String> details = new ArrayList<>();
        details.add(ex.getMessage());
        ErrorResponse error = new ErrorResponse(ex.getMessage(), details);
        return new ResponseEntity<Object>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> details = new ArrayList<>();
        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }
        ErrorResponse error = new ErrorResponse("Validation Failed", details);
        return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(Exception.class)
//    public void handleException(HttpServletResponse response) throws IOException {
//        response.sendError(HttpStatus.NOT_FOUND.value());
//    }
    
    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(
      NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "No handler found for " + ex.getHttpMethod() + " " + ex.getRequestURL();

        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getLocalizedMessage(), error);
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
    }
    

}
