# KiwilandTrain
Little project of railroad calculations
First of all, we have three files:
- KiwiLandTrainTest.java: This file does the JUnit tests for the validation process
- KiwiLandTrain.java: This file creates the system which calculate all distances with the input given routes
- KiwiLandRoute.java: This file stores the information of the origin station, destination station and distance between the two stations

HOW TO USE IT:
I worked on Eclipse with the Java EE perspective, so I ran the KiwiLandTrain application with the next configuration:
https://gyazo.com/0c70e68ec44e4b0a6e0241a527e18600
Then the system will ask for the routes that we want to compute the distances, you can input for example the test input distances:
ABC
AD
ADC
AEBCD
AED
Then you put -1 to close the scanner

After doing that, the program will compute the distances and show the output on the console screen:
Graph: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7
Expected Output:
Output #1: 9
Output #2: 5
Output #3: 13
Output #4: 22
Output #5: NO SUCH ROUTE

For the Unit Test part, you may enter the file located /tests and execute it as JUnit. It may appear the next log:

TEST ABC:

Graph: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7
Expected Output:
Output #1: 9

TEST ADC:

Graph: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7
Expected Output:
Output #1: 13

TEST AED:

Graph: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7
Expected Output:
Output #1: NO SUCH ROUTE

TEST INPUT:

Graph: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7
Expected Output:
Output #1: 9
Output #2: 5
Output #3: 13
Output #4: 22
Output #5: NO SUCH ROUTE

TEST AD:

Graph: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7
Expected Output:
Output #1: 5

TEST AEBCD:

Graph: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7
Expected Output:
Output #1: 22


Thank you very much for letting me work with this little test, it took me 6h and it was fun to do and explore the possibilities



