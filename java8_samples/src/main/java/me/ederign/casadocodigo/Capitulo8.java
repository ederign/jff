package me.ederign.casadocodigo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Capitulo8 {

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

        usuarios.sort( Comparator.comparing( Usuario::getNome ) );

        Stream<Usuario> sorted = usuarios.stream().filter( u -> u.getPontos() > 100 ).sorted( Comparator.comparing( Usuario::getNome ) );

        List<Usuario> usuarios1 = sorted.collect( Collectors.toList() );

        Optional<Usuario> usuarioOptional = usuarios.stream().filter( u -> u.getPontos() > 100 ).findAny();

        usuarios.stream().filter( u -> u.getPontos() > 100 ).peek( System.out::println ).findAny();

        usuarios.stream().sorted( Comparator.comparing( Usuario::getNome ) ).peek( System.out::println ).findAny();

        System.out.println( usuarios.stream().mapToInt( Usuario::getPontos ).average().getAsDouble() );

        System.out.println( usuarios.stream().count() );

        Optional<Usuario> max = usuarios.stream().max( Comparator.comparing( Usuario::getPontos ) );

        System.out.println( max.get() );

        System.out.println( usuarios.stream().mapToInt( Usuario::getPontos ).sum() );

        int valorInicial = 0;
        IntBinaryOperator operacao = ( a,
                                       b ) -> a + b;

        int total = usuarios.stream().mapToInt( Usuario::getPontos ).reduce( valorInicial, operacao );
        total = usuarios.stream().mapToInt( Usuario::getPontos ).reduce( 0, ( a,
                                                                              b ) -> a + b );

        total = usuarios.stream().mapToInt( Usuario::getPontos ).reduce( 0, Integer::sum );

        long multiplicacao = usuarios.stream().mapToLong( Usuario::getPontos ).reduce( 1, ( a,
                                                                                            b ) -> a * b );
        System.out.println( multiplicacao );

        total = usuarios.stream().reduce( 0, ( atual,
                                               u ) -> atual + u.getPontos(), Integer::sum );

        Iterator<Usuario> it = usuarios.stream().iterator();

        usuarios.stream().forEach( System.out::println );

        boolean hasModerador = usuarios.stream().anyMatch( Usuario::isModerador );
        System.out.println( hasModerador );
        usuarios.stream().findAny().get().tornaModerador();
        System.out.println( usuarios.stream().anyMatch( Usuario::isModerador ) );
        boolean b = usuarios.stream().allMatch( Usuario::isModerador );
        List<Usuario> collect = usuarios.stream().filter( Usuario::isModerador ).collect( Collectors.toList() );
        System.out.println( collect.size() );
        usuarios.stream().noneMatch( Usuario::isModerador );
        usuarios.stream().skip( 3 );

        Stream.empty();
        Stream.of( user1, user2, user3 );
        Stream.concat( Stream.empty(), Stream.empty() );

        //Pattern.splitAsStream
        //Stream Files.lines
        //Arrays.stream

        System.out.println( IntStream.range( 0, 1000 ).sum() );

        Random random = new Random( 2 );
        Supplier<Integer> supplier = () -> random.nextInt();
        Stream<Integer> stream = Stream.generate( supplier );

        //loop infinito
        //int valor = stream.sum();

        List<Integer> collect1 = IntStream.generate( () -> random.nextInt() ).limit( 100 ).boxed().collect( Collectors.toList() );

        System.out.println(collect1.stream().mapToLong( Integer::intValue ).sum());
    }
}