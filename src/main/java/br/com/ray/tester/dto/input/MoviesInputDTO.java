package br.com.ray.tester.dto.input;

import javax.validation.constraints.NotNull;

public record MoviesInputDTO(
        @NotNull
        String movieName) {
}
