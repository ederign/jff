package me.ederign.casadocodigo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Capitulo9 {

    public static void main( String... args ) throws IOException {
        Usuario user1 = new Usuario( "user1", 12 );
        Usuario user2 = new Usuario( "user2", 190 );
        Usuario user3 = new Usuario( "user3", 101 );
        Usuario user4 = new Usuario( "user4", 3 );
        Usuario user5 = new Usuario( "user5i", 4 );
        Usuario user6 = new Usuario( "user6", 5 );
        Usuario user7 = new Usuario( "user7", 11 );
        Usuario user8 = new Usuario( "user8", 7 );
        Usuario user9 = new Usuario( "user9", 3 );

        List<Usuario> usuarios = Arrays.asList( user1, user2, user3, user4, user5, user6, user7, user8, user9 );

        Path ederign = Paths.get( "src/main/java/me/ederign" );

        Map<Path, List<String>> content =
                Files.list( ederign )
                        .filter( p -> p.toString().endsWith( ".java" ) )
                        .collect( Collectors.toMap(
                                Function.identity(),
                                p -> lines( p ).collect( Collectors.toList() ) ) );

        Map<String, Usuario> nameToUser = usuarios
                .stream().collect( Collectors.toMap(
                        Usuario::getNome,
                        Function.identity() ) );

    }

    static Stream<String> lines( Path p ) {
        try {
            return Files.lines( p );
        } catch ( IOException e ) {
            throw new RuntimeException();
        }
    }

}