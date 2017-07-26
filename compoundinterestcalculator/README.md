## Compound Interest Calculator

Write a program that calculates return on investment through compound interest.
The program receives the principal, the investment period, the annual interest rate, and the number of times the annual income is paid.
Here is the compound interest equation.

A = P(1+r/n)^nt

> P : principal<br>
> r : an annual interest<br>
> t : period (year)<br>
> n : number of times annual interest payments<br>
> A : the principal and interest<br>

* Output Example:
  <br>*What is the principal amount? 1500*
  <br>*What is the rate: 4.3*
  <br>*What is the number of years: 6*
  <br>*What is the number of times the interest is compounded per year: 4*
  <br>*$1500 invested at 4.3% for 6 years compounded 4 times per year is $1939*

* Conditions
  * Annual rate should be calculated by dividing the input value by 100 after the input in percentage.
  * If there is a number after the decimal point based on cents, raise it with respect to cents.
