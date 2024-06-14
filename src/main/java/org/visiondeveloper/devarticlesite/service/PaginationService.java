package org.visiondeveloper.devarticlesite.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class PaginationService {

    private static final int BAR_LENGTH = 5;

    public List<Integer> getPaginationBarNumbers(int currentPageNumber, int totalPages) {
        int startIndex = Math.max(currentPageNumber - (BAR_LENGTH / 2), 0);
        int endIndex = Math.min(startIndex + BAR_LENGTH, totalPages);

        return IntStream.range(startIndex, endIndex).boxed().toList();
    }

    public int currentBarLength() {
        return BAR_LENGTH;
    }
}
