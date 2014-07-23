package me.ederign.casadocodigo;

public class Capitulo3 {

    Validador<String> validadorCEP = new Validador<String>() {
        @Override
        public boolean valida( String valor ) {
            return valor.matches( "[0-9]{5}-[0-9]{3}" );
        }
    };

    public static void main( String... args ) {

//        Runnable r = new Runnable() {
//            @Override
//            public void run() {
//                for ( int i = 0; i <= 100; i++ ) {
//                    System.out.println( i );
//                }
//            }
//        };
//
//        new Thread( r ).start();
//
        Runnable r1 = () -> {
            for ( int i = 0; i <= 100; i++ ) {
                // System.out.println( i );
            }

        };
        System.out.println(r1);
        System.out.println(r1.getClass());
//
//        new Thread( r ).start();
//
//        new Thread( () -> {
//            for ( int i = 0; i <= 100; i++ ) {
//                System.out.println( i );
//            }
//        } ).start();

        Validador<String> validadorCep1 = valor -> {
            return valor.matches( "[0-9]{5}-[0-9]{3}" );
        };
        System.out.println( validadorCep1.valida( "04101-300" ) );

        Validador<String> validadorCep2 = valor -> valor.matches( "[0-9]{5}-[0-9]{3}" );

        final int numero  = 5;
        


    }

}
