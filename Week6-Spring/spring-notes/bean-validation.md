# JSR (Java Specification Request) 303 - Bean Validation
- Bean Validation API 
- javax.validation api provides us with constraints to validate our beans against 
- we can add annotations from this package (javax.validation.constraints - package summary can be found here: https://javaee.github.io/javaee-spec/javadocs/javax/validation/constraints/package-summary.html) in order to specify certain constraints on the fields of our beans and put @Valid
- this validates the fields when they're sent in a request and will even send a meaningful response with constraint violation back to the client

### Annotations
- @NotNull
- @Size(min,max)
- @Min - num
- @Max - num 
- @Negative @NegativeOrZero
- @Positive @PositiveOrZero
- @Digits - only big decimal, otherwise only whole number values
- @Email
- @Future, @FutureOrPresent
- @Past, @PastOrPresent
- @Pattern
- @NotBlank
- @NotEmpty