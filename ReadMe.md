#Application Description 
This application is a simple demo with an embedded h2 database that 
auto populates on restart from  the import.sql file 

##### The project use lombok so in order to compile it from IDEA set enable annotation processing to true in settings (Build , Execution, Deployment -> Compiler -> Annotation Processing)

- there are two valid users: 
  - test1/test1
  - test2/test2 
- it uses basic auth
- it start on port 8080
- it has an endpoint to search movies by name and/or genre 
- you need to provide at least one parameter 
  - example: http://localhost:8080/movies?movie_name=The&genre=Crime
  - the movie_name is searched by contains criteria (%text%')
- you have a limit for each user of request per hour
  - the limit is configurable by setting api.usage.limit in application.yml
  
There are some unit tests also. 
Don't run the tests an the application on the same time !!!