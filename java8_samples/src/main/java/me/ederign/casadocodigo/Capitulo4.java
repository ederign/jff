package me.ederign.casadocodigo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Capitulo4 {

    public static void main( String... args ) {

        Usuario user1 = new Usuario( "Paulo Silveira", 150 );
        Usuario user2 = new Usuario( "Rodrigo Turini", 150 );
        Usuario user3 = new Usuario( "Guilherme Silveira", 190 );

        List<Usuario> usuarios = Arrays.asList( user1, user2, user3 );

        Consumer<Usuario> mostraMensagem = u -> System.out.println( "Antes de imprimir os nomes" );

        Consumer<Usuario> imprimeNome = u -> System.out.println( u.getNome() );

        usuarios.forEach( mostraMensagem.andThen( imprimeNome ) );

        Predicate<Usuario> predicado = new Predicate<Usuario>() {
            @Override
            public boolean test( Usuario usuario ) {
                return usuario.getPontos() > 160;
            }
        };


        List<Usuario> usuariosMutable = new ArrayList<>(  );
        usuariosMutable.add( user1 );
        usuariosMutable.add( user2 );
        usuariosMutable.add( user3 );
        usuariosMutable.removeIf( predicado );
        usuariosMutable.forEach( u -> System.out.println( u.getNome() ) );
        usuariosMutable.removeIf( u -> u.getPontos() > 100 );
        usuariosMutable.forEach( u -> System.out.println( u.getNome() ) );



    }
}
