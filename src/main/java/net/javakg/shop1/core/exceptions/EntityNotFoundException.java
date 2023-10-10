package net.javakg.shop1.core.exceptions;

public class EntityNotFoundException extends Exception {
    public EntityNotFoundException() {
        super("entity not found");
    }
}
