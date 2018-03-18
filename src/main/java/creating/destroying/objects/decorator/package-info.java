package creating.destroying.objects.decorator;

/**
 * Decorator
 * Structural Design Pattern
 * <p></p>
 * Alternative way of extending an object's functionality.
 * Different than adding new functionality into an object
 * using inheritance.
 * Provide additional functionality at runtime, as opposite to
 * inheritance, which adds new functionality at compile time
 * <p></p>
 * Note: _ java I/O streams use decorators:
 *  FileReader, BufferedReader
 *  ex: new DataInputStream(new BufferedInputStream(new FileInputStream(new File("myFile.txt"))));
 */