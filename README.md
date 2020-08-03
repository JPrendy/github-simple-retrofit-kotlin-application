# Github simple retrofit kotlin application

## Description

A Kotlin Application that uses Guthub public API to show a list of repos name. It uses Retrofit and MockWebServer to mock apis.

## Contents

- [Setup Steps](#setup-steps)
- [How to run the project locally](#how-to-run-the-project-locally)
- [Tools](#tools)
- [Update Dependencies](#update-dependencies)
- [Releases](#releases)
- [Helpful resources](#helpful-resources)

## Setup Steps

Go to the app module build.gradle and add the following dependencies

```kotlin
implementation 'com.github.bumptech.glide:glide:4.11.0'
implementation 'androidx.cardview:cardview:1.0.0'
implementation 'com.squareup.retrofit2:retrofit:2.8.1'
implementation 'com.squareup.retrofit2:converter-gson:2.8.1'
implementation 'com.squareup.retrofit2:converter-moshi:2.4.0'
implementation "androidx.recyclerview:recyclerview:1.1.0"
implementation "com.squareup.okhttp3:okhttp:4.4.0"
androidTestImplementation "com.squareup.okhttp3:mockwebserver:4.4.0"
androidTestImplementation 'com.jakewharton.espresso:okhttp3-idling-resource:1.0.0'
androidTestImplementation 'androidx.test:rules:1.2.0'
androidTestImplementation 'androidx.test:runner:1.2.0'
```

Go to the `AndroidManifest.xml` and allow internet permission

```kotlin
<uses-permission android:name="android.permission.INTERNET"/>
```

In the `AndroidManifest.xml`, make sure you add the name of the application you will use, in this instance it is `GithubApp`.

```kotlin
android:name="GithubApp"
```

In the `AndroidManifest.xml`, make sure you add the following or you may have issues using the MockTestRunner.

```kotlin
android:usesCleartextTraffic="true"
```

The api we are fetching is a normal list, an example of the type of API we are using [link](https://api.github.com/users/octocat/repos)

```kotlin
[
  {
    "id": 132935648,
    "node_id": "MDEwOlJlcG9zaXRvcnkxMzI5MzU2NDg=",
    "name": "boysenberry-repo-1",
    "full_name": "octocat/boysenberry-repo-1",
    "private": false,
    "owner": {
      "login": "octocat",
      "id": 583231,
      "node_id": "MDQ6VXNlcjU4MzIzMQ==",
      "avatar_url": "https://avatars3.githubusercontent.com/u/583231?v=4",
      "gravatar_id": "",
      "url": "https://api.github.com/users/octocat",
      "html_url": "https://github.com/octocat",
      "followers_url": "https://api.github.com/users/octocat/followers",
      "following_url": "https://api.github.com/users/octocat/following{/other_user}",
      "gists_url": "https://api.github.com/users/octocat/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/octocat/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/octocat/subscriptions",
      "organizations_url": "https://api.github.com/users/octocat/orgs",
      "repos_url": "https://api.github.com/users/octocat/repos",
      "events_url": "https://api.github.com/users/octocat/events{/privacy}",
      "received_events_url": "https://api.github.com/users/octocat/received_events",
      "type": "User",
      "site_admin": false
    },
```

## How to run the project locally

To run the unit tests locally.

```kotlin
./gradlew testdebugUnitTest
```

To run the ui tests locally, but first we need an emulator to be open.

```kotlin
./gradlew connectedCheck
```

## Tools

**Linter:** we use the following linter [link](https://github.com/github/super-linter).

**Uploading Artifacts:**  we use the following way to upload Artifacts, they allow you to persist data like test results after a job has completed, see the following documentation [link](https://docs.github.com/en/actions/configuring-and-managing-workflows/persisting-workflow-data-using-artifacts).

**Creating a Mock Server:** we use a mock server with Postman to quickly test apis, to see how to create a mock server, see the following video [link](https://www.youtube.com/watch?v=rJY8uUH2TIk). 

### Mobile Specific Tools:
 
**Fastlane:** Fastlane allows us to automate our development and release process [link](https://docs.fastlane.tools/).

**App Center:** App Center is used to distribute an app, making it very easy to test on a physical device by using a fastlane plugin [link](https://github.com/microsoft/fastlane-plugin-appcenter).

## Update Dependencies

**Npm:** How to update a npm package.
- [link](https://docs.npmjs.com/cli/update).

**Gemfile:** How to update a Gemfile package.
- [link](https://bundler.io/man/bundle-update.1.html#UPDATING-A-LIST-OF-GEMS).

## Releases

How to manage releases in a repository [link](https://help.github.com/en/github/administering-a-repository/managing-releases-in-a-repository). 

## Helpful resources

The following link provides very helpful information on Retrofit and mocking using MockWebServer.
- [link](https://www.raywenderlich.com/10091980-testing-rest-apis-using-mockwebserver).

The following link goes into leveling up your ui tests with MockWebServer
- [link](https://tech.okcupid.com/ui-tests-with-mockwebserver/).

The following link provides a guide on consuming apis with Retrofit
- [link](https://github.com/codepath/android_guides/wiki/Consuming-APIs-with-Retrofit).

The following link helps if you get the following error `Failed to open QEMU pipe 'qemud:network': Invalid argument`.
- [link](https://stackoverflow.com/a/57726127).

The following link provides information if you failed to define the application in the manifest.
- [link](https://stackoverflow.com/a/10607418).

The following link provides information on how to convert from using Gson to Moshi.
- [link](https://proandroiddev.com/moshi-with-retrofit-in-kotlin-%EF%B8%8F-a69c2621708b).

The following link provides Moshi's official github which provides examples on how to use Moshi.
- [link](https://github.com/square/moshi).

The following link provides info on Unresolved reference: kotlinx.
- [link](https://stackoverflow.com/a/34173727).