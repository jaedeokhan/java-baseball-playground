package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void testReplace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    // 요구사항 1
    // "1, 2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
    // "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
    @Test
    void testSplitTwoNumber() {
        String[] splitNumbers = "1,2".split(",");
        assertThat(splitNumbers).contains("1", "2");
    }

    @Test
    void testSplitOneNumber() {
        String[] splitNumber = "1".split(",");
        assertThat(splitNumber).containsExactly("1");
    }

    //  요구사항 2
    // "(1,2)"의 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
    @Test
    void testSubstring() {

        String value = "(1,2)";
        String actual = value.substring(1, value.length() - 1);

        assertThat(actual).isEqualTo("1,2");
    }

    // 요구사항 3
    // "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
    // String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때
    // 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
    // Junit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
    @DisplayName("문자열의 특정 위치의 문자를 가져오는 성공 테스트")
    @Test
    void testSuccessGetCharAt() {
        char actual = "abc".charAt(2);

        assertThat(actual).isEqualTo('c');
    }

    @DisplayName("문자열의 특정 위치의 문자를 가져오는 실패 테스트 - assertThatExceptionOfType 사용")
    @Test
    void testFailGetCharAt1() {

        // 위치 값을 벗어나는 테스트 => StringIndexOutOfBoundsException
        String actualValue = "abc";
        int actualIndex = 10;

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                actualValue.charAt(actualIndex);
            }).withMessageContaining("assertThatExceptionOfType => index : %d", actualIndex);
    }

    @DisplayName("문자열의 특정 위치의 문자를 가져오는 실패 테스트 - assertThatThrownBy 사용")
    @Test
    void testFailGetCharAt2() {

        String actualValue = "abc";
        int actualIndex = 10;

        assertThatThrownBy(() -> {
            actualValue.charAt(actualIndex);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
          .hasMessageContaining("assertThatThrownBy => index : %d", actualIndex);

    }
}
