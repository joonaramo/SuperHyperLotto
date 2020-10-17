# SuperHyperLotto

A CMD-based lotto app that can calculate how many years it will take you to guess all the numbers correct and to win the jackpot! The app will run until you win the jackpot within a lifetime (120 years). One run is equal to one week.

# Requirements
* Java (JDK14+ recommended)
* Git

# Compiling
1. Clone the repo
```shell 
git clone https://github.com/joonaramo/SuperHyperLotto.git
```
2. Navigate to the src folder
```shell
cd SuperHyperLotto/src
```
3. Compile the app
```shell
javac fi/tuni/tamk/tiko/ramojoona/Lotto.java
```

# Usage
Example usage with user's lotto numbers given as command line arguments:
```shell
java fi/tuni/tamk/tiko/ramojoona/Lotto 1 7 11 12 21 29 34
```
You can also give the numbers within the app by not specifying any arguments:
```shell
java fi/tuni/tamk/tiko/ramojoona/Lotto
```
```shell
Please give unique number between [1, 40]
```
After that you will give the lotto numbers one at a time.

# Screenshot
![Lotto App](https://i.imgur.com/htxN0Sf.png)

# Modifying
If you want to add a little twist to the lotto, you can modify the amount of total number scale (default 1-40) or the amount of lotto numbers generated (default 7).

That is done in the `fi/tuni/tamk/tiko/ramojoona/Lotto.java`file by modifying the variables `LOTTO_NUMBERS_AMOUNT` and `LOTTO_NUMBERS_MAXIMUM`
