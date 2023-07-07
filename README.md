Phone contacts is RESTful webservice application.

Project workflow:
1. User passes registration;
2. Authenticates and receives some custom piece of information, which has to attached to all further requests; 
3. User can create/view/update/delete contacts.

Technology stack:
- Spring Boot;
- Spring Security;
- MySQL;
- Spring Validation (to verify emails and phone number provided by users);
- JUnit 5 + Spring Boot Test;
- Swagger.

All controller documentation was created via swagger and is available on **http://localhost:8080/swagger-ui/index.html**.