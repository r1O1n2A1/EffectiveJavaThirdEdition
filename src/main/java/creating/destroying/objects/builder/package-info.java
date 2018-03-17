package creating.destroying.objects.builder;

/**
 * Item 2: Consider a builder when faced with many constructor
 * parameters
 * <p>
 * When creating an object:
 * - do not use telescopic constructor pattern
 * because it is hard to write on client side and harder to read it
 * - do not use javabeans pattern: precludes (excludes) the possibility
 * of making a class immutable
 * <p>
 * <br>builder pattern</br>
 * <p>
 * Note: _ Builder pattern simulates named optional parameters as found in
 * Python and Scala
 *       _ Builder pattern well suited to class hierarchies
 */