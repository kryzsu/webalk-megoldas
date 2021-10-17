package hu.me.iit.webalk.dependency;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ServiceImplTest {

    @Mock Dependency dependency;

    @InjectMocks ServiceImpl service;

    @Test
    void calculateTest() {
        // GIVEN

        // WHEN
        service.calculate();

        // THEN
        verify(dependency, times(1)).helpNoParameterNoReturnValue();
    }

    @Test
    void return5() {
        // GIVEN
        final int FIVE = 5;

        // WHEN
        int result = service.return5();

        // THEN
        assertEquals(FIVE, result);
    }

    @Test
    void dependencyReturnValueIsUsed() {
        // GIVEN
        final int FIVE = 5;

        when(dependency.helpNoParameterReturnValue()).thenReturn(FIVE);

        // WHEN
        int result = service.callHelpAndUseReturnValue();

        // THEN
        verify(dependency, times(1)).helpNoParameterReturnValue();
        assertEquals(FIVE, result);
    }
}