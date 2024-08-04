package by.vodorod.vodorodtesttask.exception;

import org.springframework.util.StringUtils;

import java.util.Map;

public class DomainNotFoundException extends RuntimeException {

    public DomainNotFoundException(Class clazz, Map<String, String> searchParams) {
        super(DomainNotFoundException.generateMessage(clazz.getSimpleName(), searchParams));
    }

    private static String generateMessage(String domain, Map<String, String> searchParams) {
        return StringUtils.capitalize(domain) +
                " was not found for parameters " +
                searchParams;
    }
}
