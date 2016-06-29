package ua.dp.wheaten.site.root.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by kkm on 12.06.2016.
 */
public class NotBlankValidator
            implements ConstraintValidator<NotBlank, CharSequence> {

    @Override
    public void initialize(NotBlank notBlank) {

    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        if (value instanceof String)
            return ((String) value).trim().length() > 0;
        return value.toString().trim().length() > 0;
    }
}
