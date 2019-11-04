# Web Sites 

**springboot and mongodb app**
  
  ### The endpoints of the api are these: 

    1. Show a web site for id GET URL/api/websites/{id}
        * Curl command:  curl "URL/api/websites/1" -H 'token: 123456789'
        
    2. Add new web sites POST URL/api/websites
        * Curl command:  
            curl -X POST "URL/api/websites" -H 'token: 123456789' -H 'content-type: application/json'-d 
            '{"domain": "www.nuevo.com.ar","ownerId": 97,"leadCount": 0,"plan": "GOLD","labels": ["PRIVATE","UPGRADED"]}'    
    
    3. List all web sites GET URL/api/websites
        * Curl command:  curl "URL/api/websites/" -H 'token: 123456789'
    
    4. Delete a web site for id DELETE URL/api/websites
        * Curl command:  curl -X DELETE "URL/api/websites/1" -H 'token: 123456789' 

