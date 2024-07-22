import random


class Deck:
    Num = [2,3,4,5,6,7,8,9,10,'Jack','Queen','King',"Ace"]
    Suits = ["Clubs", "Spades", "Hearts", "Diamonds"]
    deck = []
    discard = []
    for nums in Num:
        for suit in Suits:
            deck.append(str(nums) + " of " + suit)

    def shuffle(self):
        random.shuffle(Deck.deck)
    def draw(self):
     Card = Deck.deck[0]

     Deck.deck.remove(Deck.deck[0])
     Deck.discard.append(Card)

     #print(Deck.deck)
     #print(Deck.discard)
     return Card

class Player:
    hand = []
    bal = 5.00

class Table:
    pot = 0
    communityCards = []
    dealer = 0
    Players = []
    playing = []
    folded = []
    def dealerNext(self):
        Table.dealer = Table.dealer + 1
    def reset(self):
        Table.pot = 0
        Table.dealerNext(Table)
        i = 0
        for x in Table.folded:
            Table.folded.remove(i)
            i = i + 1



class Ai:
    ai1 = Player
    ai2 = Player
    ai3 = Player
    ai4 = Player
    ai5 = Player
    ai6 = Player
    ai7 = Player
    ai8 = Player


class main:
    turns = 0
    deck = Deck
    table = Table
    minBet = .10

    player1 = Player
    print("How many players would you like to play with?")
    print("6 or 9")
    x = int(input())
    while x != 6 and x != 9:
        print("Please try again, 6 or 9 players?")
        x = int(input())
    table.Players.append(player1)
    Jim = Ai.ai1
    table.Players.append(Jim)
    John = Ai.ai2
    table.Players.append(John)
    Jack = Ai.ai3
    table.Players.append(Jack)
    Benny = Ai.ai4
    table.Players.append(Benny)
    Kenny = Ai.ai5
    table.Players.append(Kenny)
    if x == 9:
        Lopez = Ai.ai6
        table.Players.append(Lopez)
        George = Ai.ai7
        table.Players.append(George)
        Manny = Ai.ai8
        table.Players.append(Manny)

    deck.shuffle(Deck)
    while player1 in table.Players:
        if turns > 0:
            minbet = turns / 10
        print("Dealing Cards")
        i = 0
        for x in table.Players:
            table.playing.append(table.Players[i])
            i = i + 1
        for x in range(0,2):
            i = 0

            for x in table.playing:
                table.playing[i].hand.append(deck.draw(Deck))

                x = table.playing[i]
                i = i + 1
                j = 0



        print("You have a " + table.Players[0].hand[0] + " and a " + table.Players[0].hand[1])

        print("Would you like to bet the blind or fold? Bet or Fold?")
        print("Your balance is " + "%.2f" % table.Players[0].bal)

        x = str.lower(input())
        if x == "bet" or x == "b":
            table.pot = table.pot + minBet
            print("The current pot is " + "%.2f" % table.pot)



        elif x == "fold" or x == "f":
            turns = turns + 1
            table.reset(Table)










