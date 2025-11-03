package top.marchand.sealed.utilities;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.StringJoiner;

/**
 * This class has some methods to help to get instances of a Sealed class or interface.
 */
public class SealedClassHelper {

  /**
   * Return an instance of the first implementation whose name starts with {@code prefix}.
   *
   * {@code clazz} must be a sealed class or interface. It must declare a constructor
   * that has parameters of same types than the ones defined in {@code args}.
   *
   * A matching constructor is first search by {@link java.lang.Class#getDeclaredConstructor Class.getDeclaredConstructor}. Then,
   * if no matching constructor has been found, it tries to convert wrapper parameters to primitives
   * (e.g. Boolean -> boolean, Integer -> int, etc...). If no matching constructor is found, it throws
   * a {@link NoMatchingConstructor} exception.
   *
   * @param clazz The sealed class or interface to search implementations in
   * @param prefix The prefix implementation class name must match
   * @param args Arguments to pass to constructor
   * @return An instance whose class-name starts with {@code prefix}, constructing by calling constructor with correct parameters
   * @param <C> The sealed class or interface
   * @throws NotSealedException if {@code clazz} is not sealed
   * @throws NoMatchingImplementation if no implementationwith name that starts with {@code prefix} is found
   * @throws NoMatchingConstructor if implementation does not declare a constructor that matches {@code args}
   */
  public static <C> C getInstanceofClassByPrefix(Class<C> clazz, String prefix, Object... args) {
    if(!clazz.isSealed()) throw new NotSealedException(clazz.getCanonicalName()+" is not sealed");
    Class<? extends C> aClass = (Class<? extends C>)
        Arrays.stream(clazz.getPermittedSubclasses())
              .filter(ac -> ac
                  .getSimpleName()
                  .startsWith(prefix))
              .findFirst()
              .orElseThrow(() -> new NoMatchingImplementation(clazz.getCanonicalName()+" has no implementation that starts with "+prefix));
    try {
      Constructor<? extends C> matchingConstructor = findMatchingConstructor(args, aClass);
      return matchingConstructor.newInstance(args);
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
      throw new RuntimeException(e);
    }
  }

  private static <C> Constructor<? extends C> findMatchingConstructor(Object[] args, Class<? extends C> aClass) throws NoMatchingConstructor {
    Class<?>[] argsTypes = new Class<?>[args.length];
    for (int i = 0; i < args.length; i++) {
      argsTypes[i] = args[i].getClass();
    }
    Constructor<? extends C> constructor;
    try {
      constructor = aClass.getDeclaredConstructor(argsTypes);
    } catch (NoSuchMethodException firstException) {
      try {
        constructor = findAdaptatedConstructorWithNonWrappedParameters(args, aClass);
      } catch (NoSuchMethodException e2) {
        throw new NoMatchingConstructor(aClass.getCanonicalName()+" has no constructor that matches "+toString(argsTypes), e2);
      }
    }
    return constructor;
  }

  private static String toString(Class<?>[] argsTypes) {
    StringJoiner joiner = new StringJoiner(", ", "[", "]");
    for (Class<?> aClass : argsTypes) {
      joiner.add(aClass.getCanonicalName());
    }
    return joiner.toString();
  }

  private static <C> Constructor<? extends C> findAdaptatedConstructorWithNonWrappedParameters(Object[] args, Class<? extends C> aClass) throws NoSuchMethodException {
    Class<?>[] argsTypes = new Class<?>[args.length];
    for (int i = 0; i < args.length; i++) {
      Class<?> argClass = args[i].getClass();
      if(argClass.equals(Boolean.class)) {
        argsTypes[i] = boolean.class;
      } else if(argClass.equals(Character.class)) {
        argsTypes[i] = char.class;
      } else if(argClass.equals(Byte.class)) {
        argsTypes[i] = byte.class;
      } else if(argClass.equals(Short.class)) {
        argsTypes[i] = short.class;
      } else if(argClass.equals(Integer.class)) {
        argsTypes[i] = int.class;
      } else if(argClass.equals(Long.class)) {
        argsTypes[i] = long.class;
      } else if(argClass.equals(Float.class)) {
        argsTypes[i] = float.class;
      } else if(argClass.equals(Double.class)) {
        argsTypes[i] = double.class;
      } else {
        argsTypes[i] = argClass;
      }
    }
    return aClass.getDeclaredConstructor(argsTypes);
  }
}
