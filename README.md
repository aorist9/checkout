# Checkout
A Java Command Line Checkout Utility

## Problem Statement
Shopping cart
* You are building a checkout system for a shop which only sells apples and
oranges.
* Apples cost 60p and oranges cost 25p.
* Build a checkout system which takes a list of items scanned at the till and outputs
the total cost
* For example: [ Apple, Apple, Orange, Apple ] => £2.05
* Make reasonable assumptions about the inputs to your solution; for example, many
candidates take a list of strings as input

Step 2: Simple offers
* The shop decides to introduce two new offers
  * buy one, get one free on Apples
  * 3 for the price of 2 on Oranges
* Update your checkout functions accordingly

## How to Run
* Pull down the project
* [Setup gradle](https://gradle.org/install/) if it's not already setup
* run `./gradlew build`
* then run `./gradlew run --args="(your arguments separated by spaces)"`

e.g. `./gradlew run --args="Apple Apple Orange Apple"` which should print `Your total is £2.05`

