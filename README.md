# Mini Lånesoknad Spring boot application

### About the Service
 This service has an endpoint that can take loan application 
 as json and save it, with a response that includes the soknad id.
 Other endpoint that can receive an soknad id and respond with
 status e.g “Mottat” or ”Ukjent”. The service has H2 in memory database.
 
 ### Save a soknad
 
 ```
 POST /soknad
Location http://localhost:8080/soknad
 Accept: application/json
 Content-Type: application/json
 
 {
   "lanetakere": [{ "fnr" : "01056000069", "navn" : "Kari Nordmann" } , { "fnr" : "01056000301", "navn" : "Ola Nordmann" }],
   "lanebelop": 2450000,
   "behov": "Vi skal låne penger til........",
   "lopetid": 300,
   "avdragsfriPeriode": 12,
   "type": "annuitet"
 }
 
 RESPONSE: HTTP 200 (OK)
 RESPONSE Body: 1 (soknadId)
 ```
 
 ### Get status for soknadId
 
 ```
 http://localhost:8080/soknad/1
 
 Response: HTTP 200
 Content: "Mottatt" 
 ```

