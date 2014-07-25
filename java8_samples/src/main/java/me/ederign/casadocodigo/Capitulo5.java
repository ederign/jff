package me.ederign.casadocodigo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;

public class Capitulo5 {

    public static void main( String... args ) {

        Comparator<Usuario> comparator = new Comparator<Usuario>() {
            @Override
            public int compare( Usuario o1,
                                Usuario o2 ) {
                return o1.getNome().compareTo( o1.getNome() );
            }
        };

        Usuario user1 = new Usuario( "Paulo Silveira", 150 );
        Usuario user2 = new Usuario( "Rodrigo Turini", 110 );
        Usuario user3 = new Usuario( "Guilherme Silveira", 190 );

        List<Usuario> usuarios = Arrays.asList( user1, user2, user3 );

        Collections.sort( usuarios, comparator );

        Comparator<Usuario> sortUser = ( u1,
                                         u2 ) -> ( u1.getNome().compareTo( user2.getNome() ) );

        Collections.sort( usuarios,
                          ( u1,
                            u2 ) -> u1.getNome().compareTo( u2.getNome() ) );

        usuarios.sort( ( u1,
                         u2 ) -> u1.getNome().compareTo( u2.getNome() ) );

        //???
        // Comparator<Usuario> withComparing = Comparator.comparing( u -> u.getNome() );
        Comparator<Usuario> withComparing = Comparator.comparing( Usuario::getNome );

        usuarios.sort( Comparator.comparing( Usuario::getNome ) );

        List<String> estrings = Arrays.asList( "1", "2", "3" );

        Collections.sort( estrings );

        estrings.sort( Comparator.<String>naturalOrder() );

        usuarios = Arrays.asList( user1, user2, user3 );
        usuarios.sort( Comparator.comparing( Usuario::getPontos ).reversed() );

        usuarios.forEach( u -> System.out.println( u.getPontos() ) );

        Function<Usuario, Integer> extraiPontos = u -> u.getPontos();

        Comparator<Usuario> novoComparator = Comparator.comparing( extraiPontos );

        ToIntFunction<Usuario> extraiPontosSemBoxing = u -> u.getPontos();

        Comparator<Usuario> comparatorBla = Comparator.comparingInt( extraiPontosSemBoxing );

        usuarios.sort( comparatorBla );


        usuarios.sort( Comparator.comparingInt( Usuario::getPontos ) );


    }
}
