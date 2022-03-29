package com.modern.ch05;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        List<Artist> artistList = Arrays.asList(
                new Artist("Broken valentine", 5,  Artist.Genre.ROCK, OffsetDateTime.of(LocalDateTime.of(2007, 1, 1, 0, 0, 0), ZoneOffset.UTC)),
                new Artist("Alter bridge", 4, Artist.Genre.ROCK, OffsetDateTime.of(LocalDateTime.of(2004, 1, 1, 0, 0, 0), ZoneOffset.UTC)),
                new Artist("Thornapple", 4, Artist.Genre.INDIE, OffsetDateTime.of(LocalDateTime.of(2009, 1, 1, 0, 0, 0), ZoneOffset.UTC)),
                new Artist("Cotoba", 4, Artist.Genre.INDIE, OffsetDateTime.of(LocalDateTime.of(2018, 1, 1, 0, 0, 0), ZoneOffset.UTC)),
                new Artist("TWICE", 8, Artist.Genre.DANCE, OffsetDateTime.of(LocalDateTime.of(2015, 1, 1, 0, 0, 0), ZoneOffset.UTC)),
                new Artist("IZONE", 12, Artist.Genre.DANCE, OffsetDateTime.of(LocalDateTime.of(2018, 1, 1, 0, 0, 0), ZoneOffset.UTC))
        );

        List<Artist> rockArtistList = artistList.stream()
                                                .filter(artist -> artist.getGenre().equals(Artist.Genre.ROCK))
                                                .collect(Collectors.toList());

        List<Artist> indieArtistList = artistList.stream()
                                                 .filter(artist -> artist.getGenre().equals(Artist.Genre.INDIE))
                                                 .collect(Collectors.toList());

        List<List<Artist>> mixedList = List.of(rockArtistList, indieArtistList);

        Stream.of("Hello", "world").map(s -> s.split("")).flatMap(Arrays::stream).collect(Collectors.toList());

        // flatmap
        mixedList.stream()
                .map(List::toArray)
                .flatMap(Arrays::stream)
                .map(Artist.class::cast)
                .forEach(System.out::println);


    }
}
