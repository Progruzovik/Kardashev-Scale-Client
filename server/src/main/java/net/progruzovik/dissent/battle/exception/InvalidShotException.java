package net.progruzovik.dissent.battle.exception;

import org.springframework.lang.NonNull;

public final class InvalidShotException extends RuntimeException {

    public InvalidShotException(@NonNull String message) {
        super(message);
    }
}
