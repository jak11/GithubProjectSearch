# Description
This cod base includes service for searching the github projects on Github based on input query based on coding language. 

# Pre-requisite
- Gradle
- java 8
- Spring Boot

# Instruction to Run the project
`./gradlew bootRun`

# Endpoints
1. **URL** : http://localhost:8080/searchservice/v1/projects?page=10&&pagesize=10&&query=language:java
2. Fields Description:
    1. query: Required field with format language:<coding_language> example language:java 
    2. page(Optional, Default = 1): Page number from which results to be fetched  
    3. pagesize(Optional, Default = 10): No of results to be fetched in a single call 
   
# Testing
1. Valid Call : 
    `curl -v http://localhost:8080/searchservice/v1/projects\?page\=10\&\&pageSize\=4\&\&query\=language:go | json_pp`
2. Invalid call missing query field: 
    `curl -v http://localhost:8080/searchservice/v1/projects?page=10&&pagesize=10` 
3. Invalid call Invalid Query format
    `curl -v http://localhost:8080/searchservice/v1/projects?page=10&&pagesize=10&&query=abcd:abcd`
