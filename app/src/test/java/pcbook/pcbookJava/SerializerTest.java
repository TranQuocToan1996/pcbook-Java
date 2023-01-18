package pcbook.pcbookJava;

import java.io.IOException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import pcbookJava.Laptop;
import sample.Generator;
import serializer.Serializer;

public class SerializerTest {
    @Test
    void writeAndReadBinaryFile() throws IOException {
        final String binaryFile = "../laptop.bin";
        var laptop1 = new Generator().NewLaptop();

        Serializer serializer = new Serializer();
        serializer.WriteBinaryFile(laptop1, binaryFile);

        Laptop laptop2 = serializer.ReadBinaryFile(binaryFile);
        Assert.assertEquals(laptop1, laptop2);
    }

}
