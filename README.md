For the Bugs in part A I assigned new constraints to the views and changed the logic of the sendMessage such that the fields could distinguish between optional and required.For the animation I added the animator listener for the purpose of detecting when the animation was completed. Upon starting the animation after frame 109 the listener begins the on animation end logic, which in turn starts the logic relating to the second portion of the animation.
As for Part B I was unable to do this part. As a junior engineer I do not have much experience implementing retrofit and in the bank other colleagues have implemented useful aspects such as adapters, rxjava or coroutines, all of which I don't have to worry about on a daily basis. I tried to implement <Call>, the vanilla way of implementing Retrofit but ended up running out of time. If I could improve my solution I would add a recycle adapter to the UserAccountActivity. 



# The Brief:

Create a mini version of the Moneybox app that will allow existing users to login, check their account and add money to their moneybox.

## Part A - Fix current bugs

In this repository you will find LoginActivity that allows users to enter their username, password and optionally their name.  We have implemented a basic screen for you that validates username, password and name against simple regular expressions but makes no calls to the API.

Unfortunately this screen has 3 bugs raised by our testers that they want you to fix and are listed below.  If you are struggling to fix any of these bugs, please give it your best attempt and then move onto the next bug or task.

### Bug 1 - Layout does not look as expected

Please re-arrange the views in the LoginActivity to match the expected layout.

![](/images/correct_layout.png)

### Bug 2 - Validation is incorrect
If the input entered by the user is correct then they should see a toast saying “Input is valid!”.  However if it is not correct we should show an error on the field that is incorrect.  Below is the following validation logic:

- Email is not optional and should match EMAIL_REGEX
- Password is not optional and should match PASSWORD_REGEX
- Name is optional, but if it contains any value it should match NAME_REGEX

There is some validation logic in LoginActivity, but it is currently incorrect. Please implement this feature to match this logic.

### Bug 3 - Animation is looping incorrectly

Above the login button is an animation of an owl and a pig.  We would like this animation to play every time the user starts the activity and then loop indefinitely.  The logic for this animation should be as follows:

- The animation should start from frame **0** to **109** when the user first starts the activity.  See below for animation.
![](/images/firstpig.gif)
- When the first stage of the animation has finished it should then loop from frame **131** to **158** continuously.  See below for animation.<br/>
![](/images/secondpig.gif)

To create animation in our app we use a helpful library called Lottie.  This has been added to the project for you, but currently it just plays the animation once and then stops.  Please implement the logic as described above.

There is lots of helpful documentation on Lottie [here](http://airbnb.io/lottie/#/android).  Please take a look at this page for information on how to loop the animation, play from a min and max frame and detect when an animation ends.

## Part B - Add 2 new screens

We now want to give some useful functionality to our users. To allow them to log into the app, view and edit their account using our sandbox API.

### Screen 2 - User accounts screen
This screen should be shown after the user has successfully logged in and should show have the following functionality:
- Display "Hello {name} **only** if they provided it on previous screen"
- Show the **'TotalPlanValue'** of a user.
- Show the accounts the user holds, e.g. ISA, GIA, LISA, Pension.
- Show all of those account's **'PlanValue'**.
- Shhow all of those account's **'Moneybox'** total.

### Screen 3 - Individual account screen
If a user selects one of those accounts, they should then be taken to this screen.  This screen should have the following functionality:
- Show the **'Name'** of the account.
- Show the account's **'PlanValue'**.
- Show the accounts **'Moneybox'** total.
- Allow a user to add to a fixed value (e.g. £10) to their moneybox total.

A prototype wireframe of all 3 screens is provided as a guideline. You are free to change any elements of the screen and provide additional information if you wish.

![](/images/wireframe.png)

## What we are looking for:
 - An android application written in either Java or Kotlin.
 - Demonstration of coding style and design patterns.
 - Knowledge of common android libraries and any others that you find useful.
 - Storage of data between screens.
 - Consistency of data between screens.
 - Error handling.
 - Any form of unit or integration testing you see fit.
 - The application must run on Android 5.0 and above.
 - The application must compile and run in Android Studio.

Please feel free to refactor the LoginActivity and use any libraries/helper methods to make your life easier.

## How to Submit your solution:
 - Clone this repository
 - Create a public repo in github, bitbucket or a suitable alternative and provide a link to the repository.
 - Provide a readme in markdown which details how you solved the bugs in part A, and explains the structure of your solution in Part B and any libraries that you may have used.

## API Usage
This a brief summary of the api endpoints in the moneybox sandbox environment. There a lot of other additional properties from the json responses that are not relevant, but you must use these endpoints to retrieve the information needed for this application.

#### Base URL & Test User
The base URL for the moneybox sandbox environment is `https://api-test01.moneyboxapp.com/`.
You can log into test your app using the following user:

|  Username          | Password         |
| ------------- | ------------- |
| androidtest@moneyboxapp.com  | P455word12  |

#### Headers

In order to make requests https must be used and the following headers must be included in each request.

|  Key | Value |
| ------------- | ------------- |
| AppId  | 3a97b932a9d449c981b595  |
| Content-Type  | application/json  |
| appVersion | 5.10.0 |
| apiVersion | 3.0.0 |

#### Authentication
To login with this user to retrieve a bearer token you need to call `POST /users/login`.
```
POST /users/login
{
  "Email": "androidtest@moneyboxapp.com",
  "Password": "P455word12",
  "Idfa": "ANYTHING"
}
```
Sample json response
```
"Session": {
        "BearerToken": "TsMWRkbrcu3NGrpf84gi2+pg0iOMVymyKklmkY0oI84=",
        "ExternalSessionId": "4ff0eab7-7d3f-40c5-b87b-68d4a4961983", -- not used
        "SessionExternalId": "4ff0eab7-7d3f-40c5-b87b-68d4a4961983", -- not used
        "ExpiryInSeconds": 0 -- not used
    }
```
After obtaining a bearer token an Authorization header must be provided for all other endpoints along with the headers listed above (Note: The BearerToken has a sliding expiration of 5 mins).

|  Key          | Value         |
| ------------- | ------------- |
| Authorization  | Bearer TsMWRkbrcu3NGrpf84gi2+pg0iOMVymyKklmkY0oI84=  |

#### Investor Products
Provides product and account information for a user that will be needed for the two additional screens.
```
GET /investorproducts
```
### One off payments
Adds a one off amount to the users moneybox.
```
POST /oneoffpayments
{
  "Amount": 20,
  "InvestorProductId": 3230 ------> The InvestorProductId from /investorproducts endpoint
}
```
Good luck!
