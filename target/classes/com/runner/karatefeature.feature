
Feature: To verify Various features of karate Framework

@test1
Scenario: Basic methods of karate

Given url 'http://pokeapi.co/api/v2/pokemon/1'
When method get
Then status 200
And print responseTime 
And assert responseTime <5000
* print 'pretty print:\n' + karate.pretty(response)

@test2
Scenario Outline: using data-provider in karate

Given url 'http://pokeapi.co/api/v2/pokemon/<name>'
When method get
Then status 200
And print responseTime
And print responseStatus

Examples:

| name  |
| pikachu  |
| bulbasaur | 
| charizard | 

@test3
Scenario: passing and receiving data from java DemoClass

Given url 'http://pokeapi.co/api/v2/pokemon/pikachu'
When method get
Then status 200
And print responseTime
And print responseStatus

* def DemoClass = Java.type('com.runner.DemoClass')
* def db = new DemoClass()
* def myVar = db.dc('Im \\ inside/ dc')
* print myVar


@test4
Scenario: Reading data from excel file using  DemoClass

Given url 'http://pokeapi.co/api/v2/pokemon/pikachu'
When method get
Then status 200
And print responseTime
And print responseStatus

* def DemoClass = Java.type('com.runner.DemoClass')
* def myVar = DemoClass.createExcelFile('D://A1.xlsx')
* def myVar = DemoClass.writeExcelFile('D://A1.xlsx')
* def myVar = DemoClass.readExcelFile('D://A1.xlsx')
* print myVar


@test5
Scenario: POST data using API

Given url 'https://reqres.in/api/users'
#And request read('request.json')
And request { "name": "Kushal",  "job": "leader" }
When method post
Then status 201
* print responseTime
* print responseHeaders
## Matching specific header type from header
Then match header Content-Type contains 'application'
## Getting specific header type from header
* def serverType = responseHeaders['Server'][0]
* print serverType
* print response
* def rs = read('expected.json')
* match response == rs
* match response == read('d:/expected.json')


@test6
Scenario: POST data using API

Given url 'https://reqres.in/api/users'
#And request read('request.json')
And request { "name": "Kushal",  "job": "leader" }
When method post
Then status 201
* print responseTime
* print responseHeaders
## Matching specific header type from header
Then match header Content-Type contains 'application'
## Getting specific header type from header
* def serverType = responseHeaders['Server'][0]
* print serverType
* print response
* def rs = read('expected.json')
* match response == rs
* match response == read('d:/expected.json')
