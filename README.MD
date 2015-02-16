# reCAPTCHA-JSF
## Add the new Google reCaptcha v2 to you JSF projects


1. Add the namespace: 
xmlns:r="http://antoniomallia.it/reCaptcha"

2. Add the tag:
<r:reCaptcha />

3. Check if valid:
FacesContext facesContext = FacesContext.getCurrentInstance();
boolean validCaptcha = ReCaptcha.validate(facesContext);