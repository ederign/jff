package me.ederign.casadocodigo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Cap8File {

    public static void main( String[] args ) throws Exception {

        Path ederign = Paths.get( "src/main/java/me/ederign" );
        Files.list( ederign ).forEach( System.out::println );

        Files.list( ederign ).filter( p -> p.toString().endsWith( "Test.java" ) ).forEach( System.out::println );

        //nao compila
        // Files.list( ederign ).filter( p -> p.toString().endsWith( "Test.java" ) ).map( p -> Files.lines( p ) ).forEach( System.out::println );

        Files.list( ederign ).filter( p -> p.toString().endsWith( "Test.java" ) ).map( p -> lines( p ) ).forEach( System.out::println );

        Stream<Stream<String>> map = Files.list( ederign ).filter( p -> p.toString().endsWith( "Test.java" ) ).map( p -> lines( p ) );

        Stream<String> stringStream = Files.list( ederign ).filter( p -> p.toString().endsWith( "Test.java" ) ).flatMap( p -> lines( p ) );

        IntStream chars = Files.list( ederign ).filter( p -> p.toString().endsWith( ".java" ) ).flatMap( p -> lines( p ) ).flatMapToInt( ( String s ) -> s.chars() );

        chars.forEach( System.out::println );

        Usuario user1 = new Usuario( "Paulo Silveira", 150 );
        Usuario user2 = new Usuario( "Rodrigo Turini", 150 );
        Usuario user3 = new Usuario( "Guilherme Silveira", 190 );

        Grupo englishSpeakers = new Grupo();
        englishSpeakers.add( user1 );
        englishSpeakers.add( user2 );

        Grupo spanishSpeakers = new Grupo();
        spanishSpeakers.add( user3 );
        spanishSpeakers.add( user2 );

        List<Grupo> grupos = Arrays.asList( englishSpeakers, spanishSpeakers );
        Stream<Stream<Usuario>> map1 = grupos.stream().map( g -> g.getUsuarios().stream() );

        grupos.stream().flatMap( g -> g.getUsuarios().stream() ).distinct().forEach( System.out::println );

    }

    static Stream<String> lines( Path p ) {
        try {
            return Files.lines( p );
        } catch ( IOException e ) {
            throw new RuntimeException();
        }
    }
}
