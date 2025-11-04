package top.marchand.sealed.utilities;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import top.marchand.sealed.utilities.cases.NonSealedInterface;
import top.marchand.sealed.utilities.cases.SealedInterface;

public class HelperByPrefixTests {
  @Test
  @DisplayName("Given a non-sealed interface, it should throw exception")
  public void test_01() {
    // Given
    Class<NonSealedInterface> clazz = NonSealedInterface.class;
    // When
    Assertions
        .assertThatThrownBy(
            () -> SealedClassHelper.getInstanceofClassByPrefix(clazz, "A")
        )
        .isInstanceOf(NotSealedException.class)
        .hasMessage("top.marchand.sealed.utilities.cases.NonSealedInterface is not sealed");
  }

  @Test
  @DisplayName("no matching prefix")
  public void test_02() {
    // Given
    Class<SealedInterface> clazz = SealedInterface.class;
    // When
    Assertions.assertThatThrownBy(
        () -> SealedClassHelper.getInstanceofClassByPrefix(clazz, "ZZ")
    )
        .isInstanceOf(NoMatchingImplementation.class)
        .hasMessage("top.marchand.sealed.utilities.cases.SealedInterface has no implementation that starts with ZZ");
    // Then
  }

  @Test
  @DisplayName("no matching constructor")
  public void test_03() {
    // Given
    Class<SealedInterface> clazz = SealedInterface.class;
    // When
    Assertions.assertThatThrownBy(
        () -> SealedClassHelper.getInstanceofClassByPrefix(clazz, "A", "argument")
    )
        .isInstanceOf(NoMatchingConstructor.class)
        .hasMessage("top.marchand.sealed.utilities.cases.SealedInterface.A has no constructor that matches [java.lang.String]");
    // Then
  }

  @Test
  @DisplayName("Given a implementation with private matching constructor, should throw a RuntimeException")
  public void test_04() {
    // Given
    Class<SealedInterface> clazz = SealedInterface.class;
    // When
    Assertions.assertThatThrownBy(
                  () -> SealedClassHelper.getInstanceofClassByPrefix(clazz, "PRIVATE")
              )
              .isInstanceOf(RuntimeException.class);
  }

  @Test
  @DisplayName("Given a Sealed interface and a prefix that has a matching impl & constructor, should instanciate")
  public void test_05() {
    // Given
    Class<SealedInterface> clazz = SealedInterface.class;
    String prefix = "A";
    // When
    SealedInterface instance = SealedClassHelper.getInstanceofClassByPrefix(clazz, prefix);
    // Then
    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(instance).isNotNull();
    softly.assertThat(instance).isInstanceOf(SealedInterface.A.class);
    softly.assertAll();
  }

  @Test
  @DisplayName("Given a Sealed interface and a constructor with Integer param, should instanciate")
  public void test_06() {
    // Given
    Class<SealedInterface> clazz = SealedInterface.class;
    String prefix = "C";
    Integer param = Integer.valueOf(1);
    // When
    SealedInterface instance = SealedClassHelper.getInstanceofClassByPrefix(clazz, prefix, param);
    // Then
    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(instance).isNotNull();
    softly.assertThat(instance).isInstanceOf(SealedInterface.C.class);
    softly.assertAll();
  }
  @Test
  @DisplayName("Given a Sealed interface and a constructor with int param, should instanciate")
  public void test_07() {
    // Given
    Class<SealedInterface> clazz = SealedInterface.class;
    String prefix = "D";
    int param = 1;
    // When
    SealedInterface instance = SealedClassHelper.getInstanceofClassByPrefix(clazz, prefix, param);
    // Then
    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(instance).isNotNull();
    softly.assertThat(instance).isInstanceOf(SealedInterface.D.class);
    softly.assertAll();
  }
  @Test
  @DisplayName("Given a Sealed interface and a constructor with boolean param, should instanciate")
  public void test_08() {
    // Given
    Class<SealedInterface> clazz = SealedInterface.class;
    String prefix = "E";
    boolean param = true;
    // When
    SealedInterface instance = SealedClassHelper.getInstanceofClassByPrefix(clazz, prefix, param);
    // Then
    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(instance).isNotNull();
    softly.assertThat(instance).isInstanceOf(SealedInterface.E.class);
    softly.assertAll();
  }
  @Test
  @DisplayName("Given a Sealed interface and a constructor with char param, should instanciate")
  public void test_09() {
    // Given
    Class<SealedInterface> clazz = SealedInterface.class;
    String prefix = "F";
    char param = 'a';
    // When
    SealedInterface instance = SealedClassHelper.getInstanceofClassByPrefix(clazz, prefix, param);
    // Then
    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(instance).isNotNull();
    softly.assertThat(instance).isInstanceOf(SealedInterface.F.class);
    softly.assertAll();
  }
  @Test
  @DisplayName("Given a Sealed interface and a constructor with byte param, should instanciate")
  public void test_10() {
    // Given
    Class<SealedInterface> clazz = SealedInterface.class;
    String prefix = "G";
    byte param = 1;
    // When
    SealedInterface instance = SealedClassHelper.getInstanceofClassByPrefix(clazz, prefix, param);
    // Then
    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(instance).isNotNull();
    softly.assertThat(instance).isInstanceOf(SealedInterface.G.class);
    softly.assertAll();
  }
  @Test
  @DisplayName("Given a Sealed interface and a constructor with short param, should instanciate")
  public void test_11() {
    // Given
    Class<SealedInterface> clazz = SealedInterface.class;
    String prefix = "H";
    short param = 1;
    // When
    SealedInterface instance = SealedClassHelper.getInstanceofClassByPrefix(clazz, prefix, param);
    // Then
    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(instance).isNotNull();
    softly.assertThat(instance).isInstanceOf(SealedInterface.H.class);
    softly.assertAll();
  }
  @Test
  @DisplayName("Given a Sealed interface and a constructor with long param, should instanciate")
  public void test_12() {
    // Given
    Class<SealedInterface> clazz = SealedInterface.class;
    String prefix = "I";
    long param = 1l;
    // When
    SealedInterface instance = SealedClassHelper.getInstanceofClassByPrefix(clazz, prefix, param);
    // Then
    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(instance).isNotNull();
    softly.assertThat(instance).isInstanceOf(SealedInterface.I.class);
    softly.assertAll();
  }
  @Test
  @DisplayName("Given a Sealed interface and a constructor with float param, should instanciate")
  public void test_13() {
    // Given
    Class<SealedInterface> clazz = SealedInterface.class;
    String prefix = "J";
    float param = 1f;
    // When
    SealedInterface instance = SealedClassHelper.getInstanceofClassByPrefix(clazz, prefix, param);
    // Then
    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(instance).isNotNull();
    softly.assertThat(instance).isInstanceOf(SealedInterface.J.class);
    softly.assertAll();
  }
  @Test
  @DisplayName("Given a Sealed interface and a constructor with double param, should instanciate")
  public void test_14() {
    // Given
    Class<SealedInterface> clazz = SealedInterface.class;
    String prefix = "K";
    double param = 1d;
    // When
    SealedInterface instance = SealedClassHelper.getInstanceofClassByPrefix(clazz, prefix, param);
    // Then
    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(instance).isNotNull();
    softly.assertThat(instance).isInstanceOf(SealedInterface.K.class);
    softly.assertAll();
  }
}
