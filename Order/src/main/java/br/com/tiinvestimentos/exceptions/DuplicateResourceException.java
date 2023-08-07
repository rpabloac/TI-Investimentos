package br.com.tiinvestimentos.exceptions;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DuplicateResourceException extends BaseRuntimeException {	
	private static final long serialVersionUID = 1L;
	private static final String KEY = "custom_message";

    public DuplicateResourceException(String value) {
    	super(Map.of("value", value));
    }
    
    @Override
    public String getExceptionKey() {
        return KEY;
    }

}
