# TFL Challenge: Instructions

1) Add dependencies
   Add the necessary dependencies for Retrofit, Gson, Coroutines, Hilt, and Jetpack Compose to your build.gradle files.
2) Create API Service
   Define an interface for your Retrofit API service with the necessary endpoints.
3) Create Data Classes
   Create data classes that match the JSON structure of the API response. These classes will be used by Retrofit to parse the JSON data.
4) Set up Retrofit Details
   Create a Retrofit instance and configure it with the base URL of the API, the Gson converter, and any other necessary settings.
5) Set Up Hilt for Dependency Injection
   Set up Hilt by annotating your Application class with @HiltAndroidApp, creating a Hilt module with @Module and @InstallIn, and providing the necessary dependencies.
6) Create the Repository
   Create a repository class that uses the Retrofit API service to fetch data from the API.
7) Implement the ViewModel
   Create a ViewModel class that uses the repository to fetch data and exposes the data as LiveData for the UI to observe.
8) Observe the Data in the Main Activity
   In your MainActivity, observe the LiveData from the ViewModel and update the UI accordingly.
9) Create the UI Components
   Use Jetpack Compose to create composable functions for the UI components, such as the screen, list, and list items.
10) Run and Test
    Run the app and test it to ensure that it fetches and displays the data correctly.
