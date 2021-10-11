
# unit testing

## setup

junit 5

```xml
    <dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.junit</groupId>
            <artifactId>junit-bom</artifactId>
            <version>5.8.1</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
        </dependencies>
    </dependencyManagement>

    <dependencies>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
```

mockito
```xml
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito‚àícore</artifactId>
    <version>1.9.0</version>
    <scope>test</scope>
</dependency>
```

unit test method structure

* instance method
* annotated by: @Test, @RepeatedTest, @ParameterizedTest, @TestFactory, or @TestTemplate
  
```java
@Test
void myTest() {
    // GIVEN

    // WHEN

    // THEN
}
```

junit 4 vs junit5

three sections (pls use the comment lines)

* GIVEN set up preconditions of the method.
  * create instances
  * initialize the local variables (method inputs)
  * setup mockito stubs
* WHEN call the real method
* THEN check the postconditions
  * result of the method
  * appropriate dependency usage (is the dependency method called?) verify, argument captor


## GIVEN section

create mock instance

```java
Flower flowerMock=Mockito.mock(Flower.class);
```

or use annotation


```java
@Mock
    private Flower flowerMock;
```

https://www.baeldung.com/mockito-junit-5-extension


```java

// stubbing appears before the actual execution
when(mockedList.get(0)).thenReturn("first");
```

when(xxx) methods
* thenReturn
* thenThrow
* thenCallRealMethod

the parameter of the Mockito.mock is always .class. Typically the interface is used because of weak dependency.

## WHEN section

## THEN section

checking the content of data

* simple unittest tools
* harmcrest tools (fe. Assertions.assertThat())


```java
import static org.junit.jupiter.api.Assertions.assertEquals;


 @Test
    void addition() {
        assertEquals(2, calculator.add(1, 1));
    }

```

assertEquals parameters:

1. expected value
2. real value (testable)
3. message (optional)

Third parameter lambda function

```java
assertTrue('a' < 'b', () -> "Assertion messages can be lazily evaluated -- "
                + "to avoid constructing complex messages unnecessarily.");
```

asserts:

* assertTrue
* assertFalse
* assertNull
* assertNotNull
* assertSame
* assertAll
* assertThrows

http://junit.sourceforge.net/javadoc/org/junit/Assert.html

https://www.baeldung.com/junit-assertions


## exception checking

```java
@Test
void whenAssertingException_thenThrown() {
    Throwable exception = assertThrows(
      IllegalArgumentException.class, 
      () -> {
          throw new IllegalArgumentException("Exception message");
      }
    );
    assertEquals("Exception message", exception.getMessage());
}
```

## harmcrest

method signature

```java
assertThat(T actual, org.hamcrest.Matcher<T> matcher)
```

```java
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import example.util.Calculator;

import org.junit.jupiter.api.Test;

class HamcrestAssertionsDemo {

    private final Calculator calculator = new Calculator();

    @Test
    void assertWithHamcrestMatcher() {
        assertThat(calculator.subtract(4, 1), is(equalTo(3)));
    }

}
```

### mockito

```java
// GIVEN
WaterSourcewaterSourceMock=mock(WaterSource.class);

// WHEN
waterSourceMock.doSelfCheck();

// THEN
verify(waterSourceMock).doSelfCheck();
```

checking the sub invocation:

* never called : `verify(waterSourceMock, never()).doSelfCheck();`
* exactly once : `verify(waterSourceMock, times(1)).doSelfCheck();`
* at least once : `verify(waterSourceMock, atLeastOnce()).doSelfCheck();`

# References

* https://site.mockito.org/
* https://dzone.com/refcardz/mockito