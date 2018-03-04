package creating.destroying.objects.flyweight;
/**
 * <b>Structural design-pattern Flyweight<b>
 * <p>
 * - Structural design pattern like Facade, Adapter, Decorator
 * <p>
 * Advantages:
 * - Primarily used to decrease the number of objects and to
 * decrease memory footprint to increase performance. It's
 * used
 * <p>
 * Wen considering this pattern you need to think about intrinsic
 * and extrinsic data.
 * Intrinsic data is the data that makes this object instance unique.
 * Extrinsic data is information that can be passed in through arguments
 * <p>
 * Would I use this pattern?
 * - many similar objects and the storage cost is high
 * - majority of each object's state can be done extrinsic
 * - identity of each object does not matter
 * <p>
 * typical case with system resources, icons or folders are good
 * candidates
 * <p>
 * Drawbacks:
 * All instances of the class are related.
 */