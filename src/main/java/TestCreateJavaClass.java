import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;

import java.io.File;
import java.io.IOException;

public class TestCreateJavaClass {

    public static void main(String[] args) {
        File sourcePath = new File("src");



//Generated class will be named SuperHero
        TypeSpec superHero = TypeSpec.classBuilder("SuperHero")
                .build();

//Generated class will have "xyz.ivankocijan.generated" package name
        JavaFile javaFile = JavaFile.builder("xyz.ivankocijan.generated", superHero)
                .build();

        try {
            javaFile.writeTo(sourcePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
