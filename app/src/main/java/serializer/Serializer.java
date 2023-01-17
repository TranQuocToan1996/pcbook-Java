package serializer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.google.protobuf.util.JsonFormat;

import pcbookJava.Laptop;

public class Serializer {
    public void WriteBinaryFile(Laptop laptop, String filename) throws IOException {
        FileOutputStream out = new FileOutputStream(filename);
        laptop.writeTo(out);
        out.close();
    }

    public Laptop ReadBinaryFile(String filename) throws IOException {
        FileInputStream in = new FileInputStream(filename);
        Laptop laptop = Laptop.parseFrom(in);
        in.close();
        return laptop;
    }

    public void WriteJsonFile(Laptop laptop, String filename) throws IOException {
        JsonFormat.Printer printer = JsonFormat.printer()
                .includingDefaultValueFields()
                .preservingProtoFieldNames();

        String jsonString = printer.print(laptop);
        FileOutputStream out = new FileOutputStream(filename);
        out.write(jsonString.getBytes());
        out.close();
    }

    public static void main(String[] args) throws IOException {
        Serializer serializer = new Serializer();
        Laptop laptop = serializer.ReadBinaryFile("laptop.bin");
        serializer.WriteJsonFile(laptop, "laptop.json");
    }

}
