package me.ederign.casadocodigo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Capitulo9 {

    public static void main( String... args ) throws IOException {
        Usuario user1 = new Usuario( "user1", 12, true );
        Usuario user2 = new Usuario( "user2", 190, true);
        Usuario user3 = new Usuario( "user3", 190 );
        Usuario user4 = new Usuario( "user4", 3 );
        Usuario user5 = new Usuario( "user5i", 4 );
        Usuario user6 = new Usuario( "user6", 5 );
        Usuario user7 = new Usuario( "user7", 3 );
        Usuario user8 = new Usuario( "user8", 7 );
        Usuario user9 = new Usuario( "user9", 3 );

        List<Usuario> usuarios = Arrays.asList( user1, user2, user3, user4, user5, user6, user7, user8, user9 );

        Path ederign = Paths.get( "src/main/java/me/ederign" );

        Map<Path, List<String>> content =
                Files.list( ederign )
                        .filter( p -> p.toString().endsWith( ".java" ) )
                        .collect( toMap(
                                Function.identity(),
                                p -> lines( p ).collect( toList() ) ) );



        Stream<String> strings = Files.list( ederign ).filter( p -> p.toString().endsWith( ".java" ) ).flatMap( p -> lines( p ) );

        LongStream lines = Files.list( ederign ).filter( p -> p.toString().endsWith( ".java" ) ).mapToLong( p -> lines( p ).count() );

        List<Long> longLines = Files.list( ederign ).filter( p -> p.toString().endsWith( ".java" ) ).mapToLong( p -> lines( p ).count() ).boxed().collect( Collectors.toList() );

        // longLines.forEach( System.out::println );

        Map<Path, Long> linesPerFile = new HashMap<>();

        Files.list( ederign ).filter( p -> p.toString().endsWith( ".java" ) ).forEach( p -> linesPerFile.put( p, lines( p ).count() ) );

//        System.out.println( linesPerFile );

        Map<Path, Long> linesBest = Files.list( ederign ).filter( p -> p.toString().endsWith( ".java" ) ).collect( Collectors.toMap(
                p -> p, p -> lines( p ).count() ) );

        linesBest = Files.list( ederign ).filter( p -> p.toString().endsWith( ".java" ) ).collect( Collectors.toMap(
                Function.identity(), p -> lines( p ).count() ) );
        System.out.println(linesBest);


        Map<String,Usuario> nameToUser = usuarios.stream().collect( Collectors.toMap( Usuario::getNome, Function.identity() ) );

        System.out.println(nameToUser);


        Map<Integer, List<Usuario>> pontuacao = new HashMap<>();
        for(Usuario u: usuarios) {
            if(!pontuacao.containsKey(u.getPontos())) {
                pontuacao.put(u.getPontos(), new ArrayList<>());
            }
            pontuacao.get(u.getPontos()).add(u);

        }
        for(Usuario u: usuarios) {
            pontuacao
                    .computeIfAbsent(u.getPontos(), user -> new ArrayList<>())
                    .add(u);
        }

        Map<Integer, List<Usuario>> pontuacaos = usuarios
                .stream()
                .collect(Collectors.groupingBy(Usuario::getPontos));

//        System.out.println(pontuacaos);

        Map<Boolean, List<Usuario>> moderadores = usuarios
                .stream()
                .collect(Collectors.partitioningBy(Usuario::isModerador));
//        System.out.println(moderadores);


        Map<Boolean, List<String>> nomesPorTipo = usuarios
                .stream()
                .collect(
                        Collectors.partitioningBy(
                                Usuario::isModerador,
                                Collectors.mapping(Usuario::getNome,
        Collectors.toList())));

        System.out.println(nomesPorTipo);

        Map<Boolean, Integer> pontuacaoPorTipo = usuarios
                .stream()
                .collect(
                        Collectors.partitioningBy(
                                Usuario::isModerador,
                                Collectors.summingInt(Usuario::getPontos)));
        System.out.println(pontuacaoPorTipo);

        String nomes = usuarios
                .stream()
                .map(Usuario::getNome)
                .collect(Collectors.joining(", "));
        System.out.println(nomes);



        //Filtrar os usuários com mais de 100 pontos, ordená-los e coletar o resultado em uma lista:

        List<Usuario> filtradosOrdenados = usuarios.stream().filter( p -> p.getPontos() > 100 ).sorted( Comparator.comparing( Usuario::getNome ) ).collect( Collectors.toList() );
//        usuarios.stream().parallel()
        filtradosOrdenados = usuarios.parallelStream().filter( p -> p.getPontos() > 100 ).sorted( Comparator.comparing( Usuario::getNome ) ).collect( Collectors.toList() );

        long sum =
                LongStream.range(0, 1_000_000_000)
                        .parallel()
                        .filter(x -> x % 2 == 0)
                        .sum();
        System.out.println(sum);
    }

    static Stream<String> lines( Path p ) {
        try {
            return Files.lines( p );
        } catch ( IOException e ) {
            throw new RuntimeException();
        }
    }

}