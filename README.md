# Test automation framework for [Demo Web Shop](http://demowebshop.tricentis.com) application

## Description

The test automation framework has been developed in [Java](https://go.java/) using a modern technology stack. It contains both API and UI tests. 

There are several tools are used:
* [Gradle](https://gradle.org) is a project build management system
* [JUnit 5](https://junit.org/junit5/) is used as a test runner
* [Selenide](https://selenide.org) is the main tool for UI testing
* [REST-Assured](https://rest-assured.io) is the tool for API testing
* [Jenkins](https://www.jenkins.io/) is a continuous integration system to launch the tests
* [Selenoid](https://aerokube.com/selenoid/) is used to run browsers in [Docker containers](https://www.docker.com/resources/what-container)  for UI tests
* [Jira](https://www.atlassian.com/software/jira) is an issue tracking system
* [Allure Report](http://allure.qatools.ru) and [Allure TestOps](https://docs.qameta.io/allure-testops/) are used to visualize test results
* [Telegram Bot](https://core.telegram.org/bots) is a custom bot using to notify about the test results

## UI Tests

:heavy_check_mark: UI Register a new user    
:heavy_check_mark: UI login test    
:heavy_check_mark: UI login test with incorrect credentials    
:heavy_check_mark: Validate authorized users can add a product to cart  
:heavy_check_mark: Validate unauthorized users can add a product to cart   
:heavy_check_mark: Validate the system displays the login form if an unauthorized user want to check out the order  
:heavy_check_mark: Subscribe to the newsletter  <br/>
:heavy_check_mark: Add product to wishlist with UI <br/>
:heavy_check_mark: Search a product by product name <br/>
:heavy_check_mark: Search a nonexistent product <br/>

## API Tests

:heavy_check_mark: Send e-mail from product page with API    
:heavy_check_mark: Add product to wishlist with API    
:heavy_check_mark: Add product to cart with API

## Technology Stack

| <a href="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Intelij_IDEA.svg" width="40" height="40"  alt="IDEA"/></a> | <a href="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Java.svg" width="40" height="40"  alt="Java"/></a> |<a href="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/JUnit5.svg" width="40" height="40"  alt="JUnit 5"/></a> | <a href="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Rest-Assured.svg" width="40" height="40"  alt="RestAssured"/></a> | <a href="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Gradle.svg" width="40" height="40"  alt="Gradle"/></a> |<a href="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Selenide.svg" width="40" height="40"  alt="Selenide"/></a> |
| :---------: | :---------: | :---------: | :---------: | :---------: | :---------: |
| IDEA | Java | Junit 5 | Rest Assured | Gradle | Selenide |

| <a href="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Selenoid.svg" width="40" height="40"  alt="Selenoid"/></a> | <a href="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Allure_Report.svg" width="40" height="40"  alt="Allure"/></a> |<a href="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Allure_EE.svg" width="40" height="40"  alt="Allure TestOps"/></a> | <a href="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Jenkins.svg" width="40" height="40"  alt="Jenkins"/></a> | <a href="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Github.svg" width="40" height="40"  alt="Github"/></a> |<a href="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Jira.svg" width="40" height="40"  alt="Jira"/></a> |
| :---------: | :---------: | :---------: | :---------: | :---------: | :---------: |
| Selenoid | Allure | Allure TO | Jenkins | Github | Jira |

## Launch the tests

### To run the tests locally (default):

```
gradle clean test 
```
### To run the tests remotely:

```
clean test 
-Dbrowser={BROWSER_NAME} 
-DbrowserVersion={BROWSER_VERSION} 
-DremoteDriverUrl={REMOTE_DRIVER_URL} 
-DvideoStorage={VIDEO_STORAGE_URL} 
-DwebUrl={WEB_URL}
-DapiUrl={API_URL}
-Dthreads={THREADS}
```

### Video sample with passing test case:
![Selenoid](./images/register.gif)

### - Jenkins job
![Jenkins](./images/jenkins.png)

### - Allure report
![Allure1](./images/alllure_grapths.png)
![Allure2](./images/allure_report.png)

### - Allure Test Ops
![TestOps1](./images/failed_test.png)

### - Allure Test analytics
![Dashboard1](./images/Overview.png)
![Dashboard2](./images/Automatio-types.png)
![Dashboard3](./images/Dashboard_by_the_team.PNG)

### - Integration with Jira
![Jira_1](./images/jira-ticket.png)

### - Telegram notification
![Telegram_1](./images/telegram_bot.png)