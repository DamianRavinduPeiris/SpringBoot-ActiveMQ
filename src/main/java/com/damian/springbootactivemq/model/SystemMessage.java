package com.damian.springbootactivemq.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class SystemMessage implements Serializable {
    private String source;
    private String message;
}
