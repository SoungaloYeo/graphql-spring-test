### The main point reside on those two files on ```resources/graphql/``` directory 
###talent.graphqls description
```graphql
type Talent {
    id: ID!
    firstname: String!
    lastname: String!
    startDate: String!
    skill: Skill
}

extend type Query {
    findAllTalents: [Talent]!
    countTalents: Int!
}

extend type Mutation {
    newTalent(firstname: String!, lastname: String! skill: ID!) : Talent!
    deleteTalent(id: ID!) : Boolean
    updateTalent(firstname: String!, lastname: String!, id: ID!) : Talent!
}
```
###skill.graphqls description
```graphql
type Skill {
    id: ID!
    designation: String!
}

type Query {
    findAllSkills: [Skill]!
    countSkills: Int!
}

type Mutation {
    newSkill(designation: String!) : Skill!
}
```

##One url for all requests: 
###GraphiQL (native gui)
[http://localhost:9095/graphiql]()

###Playground GraphQL Client
[http://localhost:9095/playground]()

###Altair GraphQL Client
[http://localhost:9095/altair]()

###From Postman or other HTTP client
[http://localhost:9095/graphql]()

## Query: 
#### used to retrieve information
#### Always Using POST HTTP method

```graphql
query {
  findAllTalents {
    id
    firstname
    lastname
    skill {
      id
      designation
    }
  }
}
```

## Mutation
#### Used to save/update or delete information
#### Always using POST HTTP method

---------------------------------
#### MUTATION CREATE new Talent
```graphql
mutation{
  newTalent (
    firstname: "Song2", 
    lastname: "Yo",
    skill: "3"
  ){
    id
    firstname
    lastname
    skill {
      designation
    }
  }
}
```

----
#### AND RESPONSE:
```json
{
  "data": {
    "newTalent": {
      "id": "8",
      "firstname": "Song2",
      "lastname": "Yo",
      "skill": {
        "designation": "JAVA/JEE"
      }
    }
  }
}
```
---------------------------------
#### REQUESTE TO DELETE Talent
```graphql
mutation{
  deleteTalent(id: 8)
}
```
----
####AND RESPONSE:
```json
{
  "data": {
    "deleteTalent": true
  }
}
```

##application.yml
```yaml
graphql:
  servlet:
    mapping: /graphql

spring:
  datasource:
    url: jdbc:h2:mem:test_db;TRACE_LEVEL_FILE=3
    username: sa
    password:
    driverClassName: org.h2.Driver
    initialization-mode: embedded
  h2:
    console:
      enabled: true
      path: /h2-console
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
    hibernate:
      ddl-auto: update
    properties.hibernate.jdbc.time_zone: UTC
    show-sql: false

voyager:
  mapping: /voyager

logging:
  level:
    org.hibernate.SQL: WARN
```
