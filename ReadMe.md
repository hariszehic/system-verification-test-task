This project has the purpose of completing the task for the job interview at System Verification. In order to run the tests following should be done:

1. Download IntelliJ IDEA :https://www.jetbrains.com/idea/download/#section=windows you can select the community edition
2. Install IntelliJ, in the setup you will be asked to select which languages you want to use, select Java
3. Your PC should have Java installed, the SDK that is used here is 19
4. The following plugins should be installed in IntelliJ you navigate to File -> Settings -> Plugins -> Marketspace: Maven, TestNG
5. Use the SSH from git to import the project
6. On the right side select Maven and refresh to import dependencies
7. Click Build in the top navigation and select Rebuild Project
8. In the Maven window on the right side expand the Lifecyle package and double click install
9. Tests can be run easily by right-clicking on the file and selecting Run, or by editing a configuration in the upper right corner and selecting the class that should be run within TestNG
10. The Web UI test is in the path src/test/java/webTests/testCases
11. If the website is not loading, then edit the path for the HTML file EHS.html within the BaseTest.java file. The HTML file is located in Test Automation Task/Test Automation Task/Application/EHS.html
12. The report of the execution of the test can be found in test-output/index.html