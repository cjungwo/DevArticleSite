package org.visiondeveloper.devarticlesite.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("Business Logic - Pagination")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ContextConfiguration(classes = {PaginationService.class})
class PaginationServiceTest {

    private final PaginationService sut;

    @Autowired
    public PaginationServiceTest(PaginationService paginationService) {
        this.sut = paginationService;
    }

    @DisplayName("Pagination - Bar List")
    @MethodSource
    @ParameterizedTest(name = "[{index}] {0} => {2}")
    void givenCurrentPageNumberAndTotalPages_whenCalculating_thenReturnsPaginationBarNumbers(int currentPageNumber, int totalPages, List<Integer> expectedPages) {
        // Given

        // When
        List<Integer> actual = sut.getPaginationBarNumbers(currentPageNumber, totalPages);

        // Then
        assertThat(actual).isEqualTo(expectedPages);

    }

    static Stream<Arguments> givenCurrentPageNumberAndTotalPages_whenCalculating_thenReturnsPaginationBarNumbers() {
        return Stream.of(
             arguments(0, 7, List.of(0, 1, 2, 3, 4)),
             arguments(1, 7, List.of(0, 1, 2, 3, 4)),
             arguments(2, 7, List.of(0, 1, 2, 3, 4)),
             arguments(3, 7, List.of(1, 2, 3, 4, 5)),
             arguments(4, 7, List.of(2, 3, 4, 5, 6)),
             arguments(5, 7, List.of(3, 4, 5, 6)),
             arguments(6, 7, List.of(4, 5, 6))
        );
    }

    @DisplayName("Pagination - Bar Length")
    @Test
    void givenNothing_whenCalling_thenReturnsCurrentsBarLength() {
        // Given


        // When
        int barLength = sut.currentBarLength();

        // Then
        assertThat(barLength).isEqualTo(5);

    }

}