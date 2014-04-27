package me.ederign;

import java.io.File;
import java.util.Arrays;
import java.util.function.Consumer;

public class FileFilter {

    public static void main(String args[]) {
        listRecursive(new File("."));
    }

    /**
     * This method recursively lists all
     * .txt and .java files in a directory
     */
    private static void listRecursive(File dir) {
        Arrays.stream( dir.listFiles( ( f,
                                        n ) ->
                                              !n.startsWith( "." )
                                                      &&
                                                      ( f.isDirectory()
                                                              || n.endsWith( ".txt" )
                                                              || n.endsWith( ".java" ) )
                                    ) )
                .forEach(unchecked((file) -> {
                    System.out.println(
                            file.getCanonicalPath()
                                    .substring(new File(".")
                                                       .getCanonicalPath()
                                                       .length()));

                    if (file.isDirectory()) {
                        listRecursive(file);
                    }
                }));
    }

    /**
     * This utility simply wraps a functional
     * interface that throws a checked exception
     * into a Java 8 Consumer
     */
    private static <T> Consumer<T>
    unchecked(CheckedConsumer<T> consumer) {
        return t -> {
            try {
                consumer.accept(t);
            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    @FunctionalInterface
    private interface CheckedConsumer<T> {
        void accept(T t) throws Exception;
    }
}
