package de.seuhd.campuscoffee.api.dtos;

import lombok.Builder;
import org.jspecify.annotations.Nullable;
import org.jspecify.annotations.NonNull;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

/**
 * DTO record for Review metadata.
 */
@Builder(toBuilder = true)
public record ReviewDto (
    @Nullable Long id,

    @Nullable LocalDateTime createdAt,
    @Nullable LocalDateTime updatedAt,

    @NotNull
    @NonNull Long posId,

    @NotNull
    @NonNull Long authorId,

    @NotBlank(message = "Review content cannot be empty.")
    @NonNull String review,

    @Nullable Boolean approved

) implements Dto<Long> {
    @Override
    public @Nullable Long getId() {
        return id;
    }
}
