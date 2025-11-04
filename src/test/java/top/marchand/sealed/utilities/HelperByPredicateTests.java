package top.marchand.sealed.utilities;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import top.marchand.sealed.utilities.cases.NonSealedInterface;
import top.marchand.sealed.utilities.cases.SealedInterface;

public class HelperByPredicateTests {
  @Test
  @DisplayName("Given a predicate that matches by prefix, it should instantiate")
  public void test_10() {
    // Given
    Class<SealedInterface> clazz = SealedInterface.class;
    String prefix = "A";
    // When
    SealedInterface actual = SealedClassHelper
        .getInstanceofClassByPredicate(
            clazz,
            c -> c.getSimpleName()
                  .startsWith(prefix));
    // Then
    Assertions.assertThat(actual)
              .isNotNull()
              .isInstanceOf(SealedInterface.class);
  }

  @Test
  @DisplayName("no matching prefix")
  public void test_20() {
    // Given
    Class<SealedInterface> clazz = SealedInterface.class;
    // When
    Assertions.assertThatThrownBy(
                  () -> SealedClassHelper.getInstanceofClassByPredicate(clazz, c -> false)
              )
              .isInstanceOf(NoMatchingImplementation.class)
              .hasMessage("top.marchand.sealed.utilities.cases.SealedInterface has no implementation that matches predicate");
  }
  @Test
  @DisplayName("Given a non-sealed interface, it should throw exception")
  public void test_01() {
    // Given
    Class<NonSealedInterface> clazz = NonSealedInterface.class;
    // When
    Assertions
        .assertThatThrownBy(
            () -> SealedClassHelper.getInstanceofClassByPredicate(clazz, c -> false)
        )
        .isInstanceOf(NotSealedException.class)
        .hasMessage("top.marchand.sealed.utilities.cases.NonSealedInterface is not sealed");
  }

}
