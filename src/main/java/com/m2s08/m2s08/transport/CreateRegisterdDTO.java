package com.m2s08.m2s08.transport;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.m2s08.m2s08.enums.RegisterType;
import com.m2s08.m2s08.model.Register;

import java.time.LocalDateTime;

public record CreateRegisterdDTO(Long id, @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") LocalDateTime registeredAt, RegisterType type) {
    public CreateRegisterdDTO(Register register) {
        this(register.getId(), register.getRegisteredAt(), register.getType());
    }
}