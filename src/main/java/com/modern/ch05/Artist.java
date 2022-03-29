package com.modern.ch05;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class Artist {
    private final String name;
    private final int countOfMember;
    private final Genre genre;
    private final OffsetDateTime debut;

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", countOfMember=" + countOfMember +
                ", genre=" + genre +
                ", debut=" + debut +
                '}';
    }

    public enum Genre {
        ROCK,
        BALLAD,
        DANCE,
        INDIE,
        UNKNOWN
    }
}
