# stcodechallenge
P/S: Aside from Java, I am totally new to IntelliJ, Maven projects, Cucumber, GitHub and Appium mobile test automation. It's my deepest regret on not able to solved the Appium session failed to start on Straits Times app (com.buuuk.st) on my phone which delayed my time and not able to pickup Appium Java and to develop its feature test on time. It's a challenging and FUN 48 hours of learning experience while developing this test automation framework from scratch along with tonnes of tutorials!


Info: 
i) I am using chromedriver 2.37 to interacts with Google Chrome Version 65.0.3325.181 (Official Build) (64-bit)
https://chromedriver.storage.googleapis.com/index.html?path=2.37/

ii) ST android installer package obtained from Play store using APK.Tools - Downloader
https://chrome.google.com/webstore/detail/apktools-downloader/pcekcjhdijdhaoklkkmaocbcpdnjaglm




Note: 
1. The given login credentials (Id: digitaltest1 / Password: Password1) hits "User Name and Password are already in use" error, I have closed browsers and restarted PC. Issue still occurs. Suspecting a BUG in session validation in backend in different web browsers.
      However issue not reproducible in android mobile app.

2. I don't see video in main article, I assume the video element would be within the same div class='pane-content' for main article in homepage.

3. Currently I wrote a temporary workaround to get rid of the homepage advertisement frame by refreshing the page. This written in "Given" Login.feature step. 

4. There's a bug found with the following steps in Android ST app: 
(1) Launch ST app
(2) Navigate to "LATEST" tab
(3) Tap on one article
(4) Without waiting the tapped article to load on screen, tap on another article
(Issue) ST app crashed immediately. 



Features settings
-----------------
Feature: steps.desktop
Glue to: <custom path>/stcodechallenge/StraitsTimesTest/src/test/java/features/desktop/DesktopLogin.feature

Feature: steps.mobile
Glue to: <custom path>/stcodechallenge/StraitsTimesTest/src/test/java/features/mobile/MobileLogin.feature

