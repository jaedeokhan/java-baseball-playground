package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // 요구사항 1
    // Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.
    @DisplayName("Set의 크기를 확인하는 테스트")
    @Test
    void testSetSize() {

        assertThat(numbers.size()).isEqualTo(3);
    }

    // 요구사항 2
    // Set의 contains() 메소드를 활용해 1,2,3의 값이 존재하는지를 확인하는 학습테스트 구현
    // 구현하고 보니 중복 코드가 발생
    // Junit의 ParameterizedTest를 활용해 중복 코드를 제거
    @DisplayName("Set에 1,2,3의 값이 존재하는지 확인 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testContainSetValues1(int number) {

        assertThat(numbers.contains(number)).isTrue();
    }

    // 요구사항 3
    // 요구사항 2는 contains 메소드 결과 값이 true인 경우만 테스트 가능하다.
    // 입력값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다.
    @DisplayName("Set에 1,2,3이면 true, 4,5이면 false가 반환되는지 테스트")
    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
    void testContainSetValues2(int number, boolean isContain) {

        assertThat(numbers.contains(number)).isEqualTo(isContain);
    }

}
