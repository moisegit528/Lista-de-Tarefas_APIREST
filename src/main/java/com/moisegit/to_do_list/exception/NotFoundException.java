package com.moisegit.to_do_list.exception;

import org.springframework.data.crossstore.ChangeSetPersister;

public class NotFoundException extends Exception {
    public NotFoundException(String message) {
        super(message);
    }
}
