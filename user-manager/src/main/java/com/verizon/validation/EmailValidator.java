/*import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.constraints.Email;

import org.springframework.messaging.handler.annotation.Payload;

@Email(regexp = ".+@.+\\..+|")
@Target({METHOD, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = {})
@Documented
public @interface EmailValidator {

  @OverridesAttribute(constraint = Email.class, name = "message")
  String message() default "{javax.validation.constraints.Email.message}";

  @OverridesAttribute(constraint = Email.class, name = "groups")
  Class<?>[] groups() default {};

  @OverridesAttribute(constraint = Email.class, name = "payload")
  Class<? extends Payload>[] payload() default {};
}*/