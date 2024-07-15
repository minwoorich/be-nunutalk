package com.minwoo.nunutalk.domain.uuid;

import org.hibernate.annotations.IdGeneratorType;
import org.hibernate.annotations.ValueGenerationType;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@IdGeneratorType(UuidV7Generator.class)
@ValueGenerationType(generatedBy = UuidV7Generator.class)
@Retention(RUNTIME)
@Target({FIELD, METHOD})
public @interface GeneratedUuid {
}
