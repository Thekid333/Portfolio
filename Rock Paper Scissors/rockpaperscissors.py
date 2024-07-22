import random

rock = '''
    _______
---'   ____)
      (_____)
      (_____)
      (____)
---.__(___)
'''

paper = '''
    _______
---'   ____)____
          ______)
          _______)
         _______)
---.__________)
'''

scissors = '''
    _______
---'   ____)____
          ______)
       __________)
      (____)
---.__(___)
'''

# Write your code below this line 👇

# 6. win counter for user and comp
WinCounter = 0
CompCounter = 0
# 7. reset to play again
while True:
    # 1.make a user input that determines if the player chooses rock paper or scissors
    choose = [rock, paper, scissors]
    pick = input("Rock, Paper, or Scissors?\n").lower()
    if pick == "rock" or pick == "r":
        print("You chose Rock\n" + choose[0])
    elif pick == "paper" or pick == "p":
        print("You chose Paper\n" + choose[1])
    elif pick == "scissors" or pick == "s":
        print("You chose Scissors\n" + choose[2])

# 2.have to computer randomly decided if it is going to print rock paper scissors
    comp = random.randint(0, 2)
    CompChoice = choose[comp]
    if CompChoice == choose[0]:
        print("Computer chose Rock\n" + choose[comp])
    elif CompChoice == choose[1]:
        print("Computer chose Paper\n" + choose[comp])
    elif CompChoice == choose[2]:
        print("Computer chose Scissors\n" + choose[comp])
# 3.if the user picked rock, and the comp chose rock = tie paper = print lose; scissors = print user wins
    if pick == "rock" or pick == "r":
        if comp == 0:
            print("YOU TIED\n")
            print(f"Players Won: {WinCounter}.  Computers Won: {CompCounter}.")
            PlayAgain = input("Play Again?\nYes  No?\n").lower()
            if PlayAgain == "no":
                break
        elif comp == 1:
            print("YOU LOSE\n")
            CompCounter += 1
            print(f"Players Won: {WinCounter}.  Computers Won: {CompCounter}.")
            PlayAgain = input("Play Again?\nYes  No?\n").lower()
            if PlayAgain == "no":
                break
        elif comp == 2:
            print("YOU WIN\n")
            WinCounter += 1
            print(f"Players Won: {WinCounter}.  Computers Won: {CompCounter}.")
            PlayAgain = input("Play Again?\nYes  No?\n").lower()
            if PlayAgain == "no":
                break
# 4.if user picked paper, comp chose rock  = print user wins; paper = tie; scissors = lose
    if pick == "paper" or pick == "p":
        if comp == 1:
            print("YOU TIED\n")
            print(f"Players Won: {WinCounter}.  Computers Won: {CompCounter}.")
            PlayAgain = input("Play Again?\nYes  No?\n").lower()
            if PlayAgain == "no":
                break
        elif comp == 2:
            print("YOU LOSE\n")
            CompCounter += 1
            print(f"Players Won: {WinCounter}.  Computers Won: {CompCounter}.")
            PlayAgain = input("Play Again?\nYes  No?\n").lower()
            if PlayAgain == "no":
                break
        elif comp == 0:
            print("YOU WIN\n")
            WinCounter += 1
            print(f"Players Won: {WinCounter}.  Computers Won: {CompCounter}.")
            PlayAgain = input("Play Again?\nYes  No?\n").lower()
            if PlayAgain == "no":
                break
# 5.if user picked scissors, comp chose rock = lose; paper = user win; scissors = tie
    if pick == "scissors" or pick == "s":
        if comp == 2:
            print("YOU TIED\n")
            print(f"Players Won: {WinCounter}.  Computers Won: {CompCounter}.")
            PlayAgain = input("Play Again?\nYes  No?\n").lower()
            if PlayAgain == "no":
                break
        elif comp == 0:
            print("YOU LOSE\n")
            CompCounter += 1
            print(f"Players Won: {WinCounter}.  Computers Won: {CompCounter}.")
            PlayAgain = input("Play Again?\nYes  No?\n").lower()
            if PlayAgain == "no":
                break
        elif comp == 1:
            print("YOU WIN\n")
            WinCounter += 1
            print(f"Players Won: {WinCounter}.  Computers Won: {CompCounter}.")
            PlayAgain = input("Play Again?\nYes  No?\n").lower()
            if PlayAgain == "no":
                break
