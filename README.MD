# reCAPTCHA-JSF
## Add the new Google reCaptcha v2 to you JSF projects

[![Build Status](https://travis-ci.org/amallia/reCAPTCHA-jsf.svg)](https://travis-ci.org/amallia/reCAPTCHA-jsf)

1. Add the namespace: 
```xml
xmlns:r="http://antoniomallia.it/reCaptcha"
```
2. Add the tag:
```html
<r:reCaptcha />
```
3. Check if valid:
```java
FacesContext facesContext = FacesContext.getCurrentInstance();
boolean validCaptcha = ReCaptcha.validate(facesContext);
```