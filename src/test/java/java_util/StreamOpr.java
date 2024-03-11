package java_util;

import org.testng.annotations.Test;

import java.util.stream.Stream;

public class StreamOpr {
    @Test
    public final void createStream(){
        Stream stream=Stream.of("India","Canada","Nepal");
        System.out.println(stream.count());
        System.out.println(stream.findFirst());
    }
}
