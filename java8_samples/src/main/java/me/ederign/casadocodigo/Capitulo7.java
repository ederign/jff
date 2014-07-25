package me.ederign.casadocodigo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Capitulo7 {

    public static void main( String... args ) {
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

        usuarios.sort( Comparator.comparing( Usuario::getPontos ).reversed() );

        // usuarios.forEach( System.out::println );

        usuarios.subList( 0, 3 ).forEach( Usuario::tornaModerador );

        // usuarios.forEach( System.out::println );

        usuarios.stream().filter( u -> u.getPontos() > 100 ).forEach( Usuario::distornaModerador );

        usuarios.stream().filter( u -> u.getPontos() > 100 ).forEach( System.out::println );

        List<Usuario> collected = usuarios.stream().filter( u -> u.isModerador() ).collect( Collectors.toList() );
        collected.forEach( System.out::println );

        List<Integer> pontos = usuarios.stream().map( Usuario::getPontos ).collect( Collectors.toList() );

        double pontuacaoMedia = usuarios.stream().mapToInt( Usuario::getPontos ).average().orElse( 0 );

        System.out.println( "pontuacaoMedia = " + pontuacaoMedia );

    }
}
