package com.example.divistant.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DataResponse<T> {
    private Integer statusCode;
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public static <T> ResponseEntity<DataResponse<T>> ok(@Nullable T data) {
        DataResponse<T> body = new DataResponse<>();
        body.data = data;
        body.statusCode = HttpStatus.OK.value();
        body.message = HttpStatus.OK.name();
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    public static <T> ResponseEntity<DataResponse<T>> created(@Nullable T data) {
        DataResponse<T> body = new DataResponse<>();
        body.data = data;
        body.statusCode = HttpStatus.CREATED.value();
        body.message = HttpStatus.CREATED.name();
        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }
}
