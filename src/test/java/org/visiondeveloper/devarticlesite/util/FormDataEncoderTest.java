package org.visiondeveloper.devarticlesite.util;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Test tool - Form Data Encoder")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class FormDataEncoderTest {

    @Autowired
    private FormDataEncoder formDataEncoder;

    @Autowired
    private ObjectMapper objectMapper;
    

    @DisplayName("Encoded Form Data")
    @Test
    void givenObject_whenEncoding_thenReturnsFormEncodedString() {
        // Given
        TestObject obj = new TestObject(
                "This 'is' \"test\" string.",
                List.of("hello", "my", "friend").toString().replace(" ", ""),
                String.join(",", "hello", "my", "friend"),
                null,
                1234,
                3.14,
                false,
                BigDecimal.TEN,
                TestEnum.THREE
        );

        // When
        String result = formDataEncoder.encode(obj);

        // Then
        assertThat(result).isEqualTo(
                "str=This%20'is'%20%22test%22%20string." +
                        "&listStr1=%5Bhello,my,friend%5D" +
                        "&listStr2=hello,my,friend" +
                        "&nullStr" +
                        "&number=1234" +
                        "&floatingNumber=3.14" +
                        "&bool=false" +
                        "&bigDecimal=10" +
                        "&testEnum=THREE"
        );
    }

    record TestObject(
            String str,
            String listStr1,
            String listStr2,
            String nullStr,
            Integer number,
            Double floatingNumber,
            Boolean bool,
            BigDecimal bigDecimal,
            TestEnum testEnum
    ) {}

    enum TestEnum {
        ONE, TWO, THREE
    }

    @Configuration
    static class TestConfig {
        @Bean
        public FormDataEncoder formDataEncoder(ObjectMapper objectMapper) {
            return new FormDataEncoder(objectMapper);
        }

        @Bean
        public ObjectMapper objectMapper() {
            return new ObjectMapper();
        }
    }

}
