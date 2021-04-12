package id.purnama.qris.validation;

import id.purnama.qris.object.QrisDataObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.validation.ConstraintValidatorContext;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TipValuePercentageValidatorTest {

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Test
    void isValidTest(){
        Map map = mock(Map.class);
        QrisDataObject qrisDataObject = mock(QrisDataObject.class);
        when(map.get(57)).thenReturn(qrisDataObject);
        when(qrisDataObject.getValue()).thenReturn("99");
        TipValuePercentageValidator percentageValidator = new TipValuePercentageValidator();
        Assertions.assertTrue(percentageValidator.isValid(map, mock(ConstraintValidatorContext.class)));
    }
}
