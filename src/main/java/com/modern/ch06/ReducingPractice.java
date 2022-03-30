package com.modern.ch06;

import com.modern.ch05.Artist;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import static java.util.stream.Collectors.*;


public class ReducingPractice {
    public static void main(String[] args) {
        List<Artist> artistList = Arrays.asList(
                new Artist("Broken valentine", 5,  Artist.Genre.ROCK, OffsetDateTime.of(LocalDateTime.of(2007, 1, 1, 0, 0, 0), ZoneOffset.UTC)),
                new Artist("Alter bridge", 4, Artist.Genre.ROCK, OffsetDateTime.of(LocalDateTime.of(2004, 1, 1, 0, 0, 0), ZoneOffset.UTC)),
                new Artist("Thornapple", 4, Artist.Genre.INDIE, OffsetDateTime.of(LocalDateTime.of(2009, 1, 1, 0, 0, 0), ZoneOffset.UTC)),
                new Artist("Cotoba", 4, Artist.Genre.INDIE, OffsetDateTime.of(LocalDateTime.of(2018, 1, 1, 0, 0, 0), ZoneOffset.UTC)),
                new Artist("TWICE", 8, Artist.Genre.DANCE, OffsetDateTime.of(LocalDateTime.of(2015, 1, 1, 0, 0, 0), ZoneOffset.UTC)),
                new Artist("IZONE", 12, Artist.Genre.DANCE, OffsetDateTime.of(LocalDateTime.of(2018, 1, 1, 0, 0, 0), ZoneOffset.UTC))
        );

        // get count, sum, min, max, average at once
        IntSummaryStatistics summaryStatistics = artistList.stream().collect(summarizingInt(Artist::getCountOfMember));
        System.out.println(summaryStatistics);

        // get max
        artistList.stream().max(Comparator.comparingInt(Artist::getCountOfMember)).ifPresent(System.out::println);

        // join String 핡 개꿀
        String allNameJoinedString = artistList.stream().map(Artist::getName).collect(joining(" , "));
        System.out.println(allNameJoinedString);

        // same reducing
        artistList.stream().map(artist -> artist.getDebut().getYear()).collect(reducing((a1, a2) -> a1 > a2 ? a1 : a2)).ifPresent(System.out::println);
        artistList.stream().map(artist -> artist.getDebut().getYear()).reduce((a1, a2) -> a1 > a2 ? a1 : a2).ifPresent(System.out::println);
    }
}
