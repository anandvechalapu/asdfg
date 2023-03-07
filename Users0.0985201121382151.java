
Solution:

1. Generate a Spring Boot application using the Spring Initializr Tool and add the following dependencies:
•	Spring Web
•	Spring Data JPA
•	Spring Security
•	Spring Boot DevTools

2. Create a User model class with the fields, getters and setters.

3. Create a UserRepository interface to extend JpaRepository and add the necessary methods.

4. Create a UserService interface and add the methods to perform CRUD operations.

5. Create a UserController class to handle the HTTP requests and call the Service methods.

6. Create a SecurityConfiguration class to configure the security settings and set the necessary roles and permissions.

7. Create a Validation class to validate the User data before creating or updating.

8. Create a DownloadController class to handle the download request and generate the .csv file.

9. Create a ViewController class to handle the view and edit requests.

10. Create a test class to test the application.