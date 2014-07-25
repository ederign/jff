package me.ederign.casadocodigo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.util.Comparator.*;

public class Capitulo6 {

    public static void main( String... args ) {
        Usuario user1 = new Usuario( "Paulo Silveira", 150 );
        Usuario user2 = new Usuario( "Rodrigo Turini", 190 );
        Usuario user3 = new Usuario( "Guilherme Silveira", 190 );

        List<Usuario> usuarios = Arrays.asList( user2, user3, user1 );

        usuarios.forEach( u -> u.tornaModerador() );
        usuarios.forEach( u -> System.out.println( u.isModerador() ) );

        usuarios.forEach( Usuario::distornaModerador );
        usuarios.forEach( u -> System.out.println( u.isModerador() ) );

        Consumer<Usuario> tornaModerador = Usuario::tornaModerador;

//        usuarios.sort( Comparator.comparing( Usuario::getNome) );
        usuarios.sort( comparing( Usuario::getNome ) );

        Function<Usuario, String> byName = Usuario::getNome;

        usuarios.sort( comparing( byName ) );

        usuarios = Arrays.asList( user1, user2, user3 );

        usuarios.sort( nullsLast( comparingInt( Usuario::getPontos ).thenComparing( Usuario::getNome ) ).reversed() );
        usuarios.forEach( u -> System.out.println( u.getNome() ) );

        usuarios.forEach( System.out::println );

        Supplier<Usuario> criadorDeUsuarios = Usuario::new;

        Usuario novo = criadorDeUsuarios.get();

        //pq nao compila
//        Function<String, Usuario> criadorDeUsuarios2 = Usuario::new;


    }
}
