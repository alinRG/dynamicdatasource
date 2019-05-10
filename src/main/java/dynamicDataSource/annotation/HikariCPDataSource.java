package dynamicDataSource.annotation;

import java.lang.annotation.*;

/**
 * Dynamic DataSource annotation
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface HikariCPDataSource {
    String value() default "";
}
