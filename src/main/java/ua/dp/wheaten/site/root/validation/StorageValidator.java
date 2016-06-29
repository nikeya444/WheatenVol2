package ua.dp.wheaten.site.root.validation;

import ua.dp.wheaten.site.root.dto.DetailDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

/**
 * Created by kkm on 21.06.2016.
 */
@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class StorageValidator implements ConstraintValidator<StorageValidation, DetailDTO> {
    @Override
    public void initialize(StorageValidation storagesValidation) {

    }

    @Override
    public boolean isValid(DetailDTO detail, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = detail.getStorage2() != null && !detail.getStorage().equals(detail.getStorage2());
        System.err.println(isValid);
        return isValid;
    }
}
