## Blood Alcohol Concentration Calculator

Write a program to calculate the estimated blood alcohol concentration (BAC)
after input weight, gender, amount of alcohol (the number of drinks), the amount of alcohol to drink, and the elapsed time after drinking.
In addition, (in the U.S.) Compare the legally operable BAC value, which is less than 0.08, to show whether you can drive.

***EBAC = ((0.806 x SD x 1.2)/(BW x Wt) - 0.017 x DP) x 10***

> SD is the number of standard drinks, that being 10 grams of ethanol each - 44ml 40%, 355ml 5%.
<br>
> BW is a body water constant (0.58 for men and 0.49 for women)
<br>
> Wt is body weight (kilogram)
<br>
> DP is the drinking period in hours.

* Output Example:
  <br>*What is your weight?*
  <br>*What is your gender?*
  <br>*How many did you drink?(glass or shot)*
  <br>*How long did the drink period in hours*

  <br>*Your BAC is 0.08*
  <br>*It is not legal for you to drive.*

  *or*

  <br>*Your BAC is 0.01*
  <br>*It is legal for you to drive.*

* Conditions
  * Ensure that numbers are entered in numeric values.
