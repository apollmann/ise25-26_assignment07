package de.seuhd.campuscoffee.domain.model.objects;

import lombok.Builder;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.time.LocalDateTime;

/**
 * Domain record that stores a review for a point of sale.
 * Reviews are approved once they received a configurable number of approvals.
 */
@Builder(toBuilder = true)
public record Review(
        @Nullable Long id, // null when the review has not been created yet
        
        @Nullable LocalDateTime createdAt, // set on review creation
        @Nullable LocalDateTime updatedAt, // set on review creation and update

        @NonNull Pos pos, // the POS being reviewed
        @NonNull User author, // the user who authored the review
        @NonNull String review, // the textual content of the review

        @NonNull Integer approvalCount, // is updated by the domain module
        @NonNull Boolean approved // is determined by the domain module
) implements DomainModel<Long> {
    @Override
    public Long getId() {
        return id;
    }
}