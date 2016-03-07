package zadanie2Server;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import spark.Spark;

public class Server {

	public static void main(String[] args) {
		Spark.get("/:name", (req, res) ->
        {
            String name = req.params("name");
            name = name.replaceAll("\\.", "/");

            File classFile = new File("target/classes/" + name + ".class");
            try {
                return Files.readAllBytes(classFile.toPath());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        });
	}

}
