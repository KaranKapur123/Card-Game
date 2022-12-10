import java.util.ArrayList;
import java.util.Scanner;

public class GameParts {
    ArrayList<Players> Players = new ArrayList<>();
    Manas Mana = new Manas();
    int RoundNumber;
    int Winner = 10;
        void Initialization() {//Takes names of two players, adds them to the player list, shuffles it and initializes health
        RoundNumber = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Player Name: ");
        String Player1Name = scanner.nextLine();
        Players Player1 = new Players(Player1Name);
        Player1.Initialize();
        Players.add(Player1);
        System.out.println("Enter Player Name: ");
        String Player2Name = scanner.nextLine();
        Players Player2 = new Players(Player2Name);
        Player2.Initialize();
        Players.add(Player2);
    }

    void PrintPlayerStats() {//prints stats of both players
        for (Players player : Players) {
            player.PrintStats();
        }
    }

    boolean CanPlayCard(int PlayerIndex, int CardIndex) {//Checks if card mana requirement is met or not
        boolean CanPlay;
        CanPlay = Players.get(PlayerIndex).Hand.PlayerHand.get(CardIndex).Card_Mana_Cost < Mana.Mana;
        System.out.println(CanPlay);
        return CanPlay;
    }

    void Player1Turn() {
        System.out.println(Players.get(0).Name + "'s PLAY TURN");
        Players.get(0).DrawCard();
        Mana.PrintMana();
        int i = 0;
        while (Players.get(0).Battlefield.PlayerBattlefield.size() > i) {
            Players.get(0).Battlefield.PlayerBattlefield.get(i).FirstTurn = false;
            Players.get(0).Battlefield.PlayerBattlefield.get(i).Tapped = false;
            i++;
        }
        Players.get(0).PrintStats();
        Scanner scanner = new Scanner(System.in);
        boolean PlayTurn = true;
        while (PlayTurn) {
            System.out.println("Input 1 to play a card and 2 to skip");
            int UserInput = scanner.nextInt();
            if (UserInput == 1) {
                System.out.println("Enter number of the card that u want to play");
                int UserCardInput = scanner.nextInt();
                int UserCardInputIndex = UserCardInput - 1;
                if (UserCardInput < Players.get(0).Hand.PlayerHand.size() + 1 && UserCardInput > 0) {
                    if (Players.get(0).Hand.PlayerHand.get(UserCardInputIndex).Card_Mana_Cost <= Mana.Mana) {
                        Players.get(0).PlayCard(UserCardInput);
                    } else {
                        System.out.println("Mana requirement not met");
                    }
                } else {
                    System.out.println("Card number id invalid");
                }
                Players.get(0).PrintStats();
            } else if (UserInput == 2) {
                PlayTurn = false;
            } else {
                System.out.println("Invalid Input");
            }
        }
        Players.get(0).PrintStats();
    }

    void Player2Turn() {
        System.out.println(Players.get(1).Name + "'s PLAY TURN");
        Players.get(1).DrawCard();
        Mana.PrintMana();
        int i = 0;
        while (Players.get(1).Battlefield.PlayerBattlefield.size() > i) {
            Players.get(1).Battlefield.PlayerBattlefield.get(i).FirstTurn = false;
            Players.get(1).Battlefield.PlayerBattlefield.get(i).Tapped = false;
            i++;
        }
        Players.get(1).PrintStats();
        Scanner scanner = new Scanner(System.in);
        boolean PlayTurn = true;
        while (PlayTurn) {
            System.out.println("Input 1 to play a card and 2 to skip");
            int UserInput = scanner.nextInt();
            if (UserInput == 1) {
                System.out.println("Enter number of the card that u want to play");
                int UserCardInput = scanner.nextInt();
                int UserCardInputIndex = UserCardInput - 1;
                if (UserCardInput < Players.get(1).Hand.PlayerHand.size() + 1 && UserCardInput > 0) {
                    if (Players.get(1).Hand.PlayerHand.get(UserCardInputIndex).Card_Mana_Cost <= Mana.Mana) {
                        Players.get(1).PlayCard(UserCardInput);
                    } else {
                        System.out.println("Mana requirement not met");
                    }
                } else {
                    System.out.println("Card number id invalid");
                }
                Players.get(1).PrintStats();
            } else if (UserInput == 2) {
                PlayTurn = false;
            } else {
                System.out.println("Invalid Input");
            }
        }
        Players.get(1).PrintStats();
    }

    void Player1Attacking() {
        System.out.println(Players.get(0).Name + "'s ATTACKING TURN");
        boolean AttackersDeclarationTurn = true;
        while (AttackersDeclarationTurn == true) {
            System.out.println("Input 1 to set attackers and 2 to skip");
            Scanner scanner = new Scanner(System.in);
            int UserAttackInput = scanner.nextInt();
            int AttackersCount = 0;
            if (UserAttackInput == 1) {
                System.out.println("Enter the card number of the card that u want to attack with");
                int UserAttackingCardNumber = scanner.nextInt();
                int UserAttackingCardNumberIndex = UserAttackingCardNumber - 1;
                if (UserAttackInput <= Players.get(0).Battlefield.PlayerBattlefield.size() && UserAttackingCardNumber > 0) {
                    if (Players.get(0).Battlefield.PlayerBattlefield.get(UserAttackingCardNumberIndex).FirstTurn == true || Players.get(0).Battlefield.PlayerBattlefield.get(UserAttackingCardNumberIndex).Tapped == true) {
                        System.out.println("Tapped cards cannot attack");
                    } else if (Players.get(0).Battlefield.PlayerBattlefield.get(UserAttackingCardNumberIndex).FirstTurn == false && Players.get(0).Battlefield.PlayerBattlefield.get(UserAttackingCardNumberIndex).Tapped == false) {
                        Players.get(0).Battlefield.PlayerBattlefield.get(UserAttackingCardNumberIndex).Tapped = true;
                        Players.get(0).Battlefield.PlayerBattlefield.get(UserAttackingCardNumberIndex).Attacking = true;
                        AttackersCount++;
                        System.out.println(AttackersCount + "cards attacking");
                    }
                } else {
                    System.out.println("Invalid Input");
                }
            } else if (UserAttackInput == 2) {
                AttackersDeclarationTurn = false;
            } else {
                System.out.println("Invalid input");
            }
        }
    }

    void Player2Attacking() {
        System.out.println(Players.get(1).Name + "'s ATTACKING TURN");
        boolean AttackersDeclarationTurn = true;
        while (AttackersDeclarationTurn == true) {
            System.out.println("Input 1 to set attackers and 2 to skip");
            Scanner scanner = new Scanner(System.in);
            int UserAttackInput = scanner.nextInt();
            int AttackersCount = 0;
            if (UserAttackInput == 1) {
                System.out.println("Enter the card number of the card that u want to attack with");
                int UserAttackingCardNumber = scanner.nextInt();
                int UserAttackingCardNumberIndex = UserAttackingCardNumber - 1;
                if (UserAttackInput <= Players.get(1).Battlefield.PlayerBattlefield.size() && UserAttackingCardNumber > 0) {
                    if (Players.get(1).Battlefield.PlayerBattlefield.get(UserAttackingCardNumberIndex).FirstTurn == true || Players.get(1).Battlefield.PlayerBattlefield.get(UserAttackingCardNumberIndex).Tapped == true) {
                        System.out.println("Tapped cards cannot attack");
                    } else if (Players.get(1).Battlefield.PlayerBattlefield.get(UserAttackingCardNumberIndex).FirstTurn == false && Players.get(1).Battlefield.PlayerBattlefield.get(UserAttackingCardNumberIndex).Tapped == false) {
                        Players.get(1).Battlefield.PlayerBattlefield.get(UserAttackingCardNumberIndex).Tapped = true;
                        Players.get(1).Battlefield.PlayerBattlefield.get(UserAttackingCardNumberIndex).Attacking = true;
                        AttackersCount++;
                        System.out.println(AttackersCount + "cards attacking");
                    }
                } else {
                    System.out.println("Invalid Input");
                }
            } else if (UserAttackInput == 2) {
                AttackersDeclarationTurn = false;
            } else {
                System.out.println("Invalid input");
            }
        }
    }

    ArrayList<Cards> PlayerAttackersList(int PlayerIndexNumber) {
        ArrayList<Cards> PlayerAttackersList = new ArrayList<>();
        for (int i = 0; Players.get(PlayerIndexNumber).Battlefield.PlayerBattlefield.size() > i; i++) {
            if (Players.get(PlayerIndexNumber).Battlefield.PlayerBattlefield.get(i).Attacking == true) {
                PlayerAttackersList.add(Players.get(PlayerIndexNumber).Battlefield.PlayerBattlefield.get(i));
                Players.get(PlayerIndexNumber).Battlefield.PlayerBattlefield.get(i).Attacking = false;
            }
        }
        return PlayerAttackersList;
    }


    void Player1Blocking() {
        System.out.println(Players.get(0).Name + "'s BLOCKING TURN");
        ArrayList<Cards> Player2AttackerList = PlayerAttackersList(1);
        Scanner scanner = new Scanner(System.in);
        if (Player2AttackerList.size() > 0) {
            System.out.println();
            System.out.println(Players.get(1).Name + " is attacking with the following cards");
            for (int i = 0; Player2AttackerList.size() > i; i++) {
                System.out.println(i + 1 + ") " + Player2AttackerList.get(i).Card_Name + " (" + Player2AttackerList.get(i).Card_Power + "/" + Player2AttackerList.get(i).Card_Toughness + ")");
            }
            System.out.println();
            System.out.println("Your cards");
            Players.get(1).Battlefield.PrintCards();

            for (int i = 0; Player2AttackerList.size() > i; i++) {
                boolean BlockerDecided = false;
                while (BlockerDecided == false) {
                    System.out.println();
                    System.out.println("Enter 1 to block " + Player2AttackerList.get(i).Card_Name + " or 2 to skip");
                    int UserBlockNumber = scanner.nextInt();
                    if (UserBlockNumber == 1) {
                        System.out.println("Enter the card number of the card you want to block with");
                        int UserBlockerInput = scanner.nextInt();
                        if (Players.get(1).Battlefield.PlayerBattlefield.size()>=UserBlockNumber) {
                            if (Players.get(0).Battlefield.PlayerBattlefield.get(i).Blocking == true) {
                                System.out.println("This card is already blocking another card");
                            } else if (Players.get(0).Battlefield.PlayerBattlefield.get(i).Tapped == false && Players.get(0).Battlefield.PlayerBattlefield.get(i).Blocking == false) {
                                Players.get(0).Battlefield.PlayerBattlefield.get(i).BlockingCardNumber = UserBlockerInput;
                                Players.get(0).Battlefield.PlayerBattlefield.get(i).Blocking = true;
                                BlockerDecided = true;
                            } else if (Players.get(0).Battlefield.PlayerBattlefield.get(i).Tapped == true) {
                                System.out.println("Tapped Cards cannot block");
                            }
                        }else {
                            System.out.println("Invalid Input");
                        }
                    } else if (UserBlockNumber == 2) {
                        System.out.println("Not Blocking " + Player2AttackerList.get(i).Card_Name);
                        System.out.println(Players.get(1).Name + "'s " + Player2AttackerList.get(i).Card_Name + " dealt " + Player2AttackerList.get(i).Card_Power + " to " + Players.get(0).Name);
                        Players.get(0).Health.PlayerHealth = Players.get(0).Health.PlayerHealth - Player2AttackerList.get(i).Card_Power;
                        System.out.println(Players.get(0).Name + " now has " + Players.get(0).Health.PlayerHealth + " health left");
                        if (Players.get(0).Health.PlayerHealth <= 0) {
                            Winner = 1;
                        }
                        BlockerDecided = true;
                    } else {
                        System.out.println("Invalid Input");
                    }
                }
            }
            if (Players.get(0).Battlefield.PlayerBattlefield.size()>0) {
                for (int i = 0; Players.get(0).Battlefield.PlayerBattlefield.size() > i; i++){
                    Players.get(0).Battlefield.PlayerBattlefield.get(i).Blocking = false;
                }
            }
        }
        for (int i = 0; Players.get(0).Battlefield.PlayerBattlefield.size() > i; i++) {
            if (Players.get(0).Battlefield.PlayerBattlefield.get(i).BlockingCardNumber != 0) {
                int PlayerBlockingCardIndex = Players.get(0).Battlefield.PlayerBattlefield.get(i).BlockingCardNumber - 1;
                for (int k = 0; Players.get(1).Battlefield.PlayerBattlefield.size() > k; k++) {
                    if (Players.get(1).Battlefield.PlayerBattlefield.get(k).Card_Name == Player2AttackerList.get(PlayerBlockingCardIndex).Card_Name) {
                        int BlockingCardToughness = Players.get(0).Battlefield.PlayerBattlefield.get(i).Card_Toughness - Players.get(1).Battlefield.PlayerBattlefield.get(k).Card_Power;
                        int AttackingCardToughness = Players.get(1).Battlefield.PlayerBattlefield.get(k).Card_Toughness - Players.get(0).Battlefield.PlayerBattlefield.get(i).Card_Power;
                        Players.get(0).Battlefield.PlayerBattlefield.get(i).Card_Toughness = Players.get(0).Battlefield.PlayerBattlefield.get(i).Card_Toughness - Players.get(1).Battlefield.PlayerBattlefield.get(k).Card_Toughness;
                        Players.get(1).Battlefield.PlayerBattlefield.get(k).Card_Toughness = Players.get(1).Battlefield.PlayerBattlefield.get(k).Card_Toughness - Players.get(0).Battlefield.PlayerBattlefield.get(i).Card_Power;
                        if (BlockingCardToughness <= 0 && AttackingCardToughness <= 0) {
                            System.out.println(Players.get(0).Name + "'s " + Players.get(0).Battlefield.PlayerBattlefield.get(i).Card_Name + " died from " + Players.get(1).Name + "'s " + Players.get(1).Battlefield.PlayerBattlefield.get(k).Card_Name);
                            System.out.println(Players.get(1).Name + "'s " + Players.get(1).Battlefield.PlayerBattlefield.get(k).Card_Name + " died from " + Players.get(0).Name + "'s " + Players.get(0).Battlefield.PlayerBattlefield.get(i).Card_Name);
                            Players.get(0).Battlefield.PlayerBattlefield.remove(i);
                            Players.get(1).Battlefield.PlayerBattlefield.remove(k);
                        }
                        else if (BlockingCardToughness <= 0) {
                            System.out.println(Players.get(0).Name + "'s " + Players.get(0).Battlefield.PlayerBattlefield.get(i).Card_Name + " died from " + Players.get(1).Name + "'s " + Players.get(1).Battlefield.PlayerBattlefield.get(k).Card_Name);
                            Players.get(0).Battlefield.PlayerBattlefield.remove(i);
                        }
                        if (AttackingCardToughness <= 0) {
                            System.out.println(Players.get(1).Name + "'s " + Players.get(1).Battlefield.PlayerBattlefield.get(k).Card_Name + " died from " + Players.get(0).Name + "'s " + Players.get(0).Battlefield.PlayerBattlefield.get(i).Card_Name);
                            Players.get(1).Battlefield.PlayerBattlefield.remove(k);
                        }
                    }
                }
            }
        }
    }

    void Player2Blocking() {
        System.out.println(Players.get(1).Name + "'s BLOCKING TURN");
        ArrayList<Cards> Player1AttackerList = PlayerAttackersList(0);
        Scanner scanner = new Scanner(System.in);
        if (Player1AttackerList.size() > 0) {
            System.out.println();
            System.out.println(Players.get(0).Name + " is attacking with the following cards");
            for (int i = 0; Player1AttackerList.size() > i; i++) {
                System.out.println(i + 1 + ") " + Player1AttackerList.get(i).Card_Name + " (" + Player1AttackerList.get(i).Card_Power + "/" + Player1AttackerList.get(i).Card_Toughness + ")");
            }
            System.out.println();
            System.out.println("Your cards");
            Players.get(1).Battlefield.PrintCards();

            for (int i = 0; Player1AttackerList.size() > i; i++) {
                boolean BlockerDecided = false;
                while (BlockerDecided == false) {
                    System.out.println();
                    System.out.println("Enter 1 to block " + Player1AttackerList.get(i).Card_Name + " or 2 to skip");
                    int UserBlockNumber = scanner.nextInt();
                    if (UserBlockNumber == 1) {
                        System.out.println("Enter the card number of the card you want to block with");
                        int UserBlockerInput = scanner.nextInt();
                        if (Players.get(1).Battlefield.PlayerBattlefield.size()>=UserBlockNumber) {
                            if (Players.get(1).Battlefield.PlayerBattlefield.get(i).Blocking == true) {
                                System.out.println("This card is already blocking another card");
                            } else if (Players.get(1).Battlefield.PlayerBattlefield.get(i).Tapped == false && Players.get(1).Battlefield.PlayerBattlefield.get(i).Blocking == false) {
                                Players.get(1).Battlefield.PlayerBattlefield.get(i).BlockingCardNumber = UserBlockerInput;
                                Players.get(1).Battlefield.PlayerBattlefield.get(i).Blocking = true;
                                BlockerDecided = true;
                            } else if (Players.get(1).Battlefield.PlayerBattlefield.get(i).Tapped == true) {
                                System.out.println("Tapped Cards cannot block");
                            }
                        }else {
                            System.out.println("Invalid Input");
                        }
                    } else if (UserBlockNumber == 2) {
                        System.out.println("Not Blocking " + Player1AttackerList.get(i).Card_Name);
                        System.out.println(Players.get(0).Name + "'s " + Player1AttackerList.get(i).Card_Name + " dealt " + Player1AttackerList.get(i).Card_Power + " to " + Players.get(1).Name);
                        Players.get(1).Health.PlayerHealth = Players.get(1).Health.PlayerHealth - Player1AttackerList.get(i).Card_Power;
                        System.out.println(Players.get(1).Name + " now has " + Players.get(1).Health.PlayerHealth + " health left");
                        if (Players.get(1).Health.PlayerHealth <= 0) {
                            Winner = 0;
                        }
                        BlockerDecided = true;
                    } else {
                        System.out.println("Invalid Input");
                    }
                }
            }
            if (Players.get(1).Battlefield.PlayerBattlefield.size()>0) {
                for (int i = 0; Players.get(1).Battlefield.PlayerBattlefield.size() > i; i++) {
                    Players.get(1).Battlefield.PlayerBattlefield.get(i).Blocking = false;
                }
            }


            for (int i = 0; Players.get(1).Battlefield.PlayerBattlefield.size() > i; i++) {
                if (Players.get(1).Battlefield.PlayerBattlefield.get(i).BlockingCardNumber != 0) {
                    int PlayerBlockingCardIndex = Players.get(1).Battlefield.PlayerBattlefield.get(i).BlockingCardNumber;
                    PlayerBlockingCardIndex = PlayerBlockingCardIndex - 1;
                    for (int k = 0; Players.get(0).Battlefield.PlayerBattlefield.size() > k; k++) {
                        if (Players.get(0).Battlefield.PlayerBattlefield.get(k).Card_Name == Player1AttackerList.get(PlayerBlockingCardIndex).Card_Name) {
                            int BlockingCardToughness = Players.get(1).Battlefield.PlayerBattlefield.get(i).Card_Toughness - Players.get(0).Battlefield.PlayerBattlefield.get(k).Card_Power;
                            int AttackingCardToughness = Players.get(0).Battlefield.PlayerBattlefield.get(k).Card_Toughness - Players.get(1).Battlefield.PlayerBattlefield.get(i).Card_Power;
                            Players.get(1).Battlefield.PlayerBattlefield.get(i).Card_Toughness = Players.get(1).Battlefield.PlayerBattlefield.get(i).Card_Toughness - Players.get(0).Battlefield.PlayerBattlefield.get(k).Card_Toughness;
                            Players.get(0).Battlefield.PlayerBattlefield.get(k).Card_Toughness = Players.get(0).Battlefield.PlayerBattlefield.get(k).Card_Toughness - Players.get(1).Battlefield.PlayerBattlefield.get(i).Card_Power;
                            if (BlockingCardToughness <= 0 && AttackingCardToughness <= 0) {
                                System.out.println(Players.get(1).Name + "'s " + Players.get(1).Battlefield.PlayerBattlefield.get(i).Card_Name + " died from " + Players.get(0).Name + "'s " + Players.get(0).Battlefield.PlayerBattlefield.get(k).Card_Name);
                                System.out.println(Players.get(0).Name + "'s " + Players.get(0).Battlefield.PlayerBattlefield.get(k).Card_Name + " died from " + Players.get(1).Name + "'s " + Players.get(1).Battlefield.PlayerBattlefield.get(i).Card_Name);
                                Players.get(1).Battlefield.PlayerBattlefield.remove(i);
                                Players.get(0).Battlefield.PlayerBattlefield.remove(k);
                            }
                            else if (BlockingCardToughness <= 0) {
                                System.out.println(Players.get(1).Name + "'s " + Players.get(1).Battlefield.PlayerBattlefield.get(i).Card_Name + " died from " + Players.get(0).Name + "'s " + Players.get(0).Battlefield.PlayerBattlefield.get(k).Card_Name);
                                Players.get(1).Battlefield.PlayerBattlefield.remove(i);
                            } else if (AttackingCardToughness <= 0) {
                                System.out.println(Players.get(0).Name + "'s " + Players.get(0).Battlefield.PlayerBattlefield.get(k).Card_Name + " died from " + Players.get(1).Name + "'s " + Players.get(1).Battlefield.PlayerBattlefield.get(i).Card_Name);
                                Players.get(0).Battlefield.PlayerBattlefield.remove(k);
                            }
                        }
                    }
                }
            }

        }
    }

    boolean ContinueGame() {
        boolean WinnerStatus;
        if (Winner != 10) {
            if (Winner == 0) {
                System.out.println(Players.get(0).Name + " Wins");
            } else if (Winner == 1) {
                System.out.println(Players.get(1).Name + " Wins");
            }
            WinnerStatus = false;
        } else {
            WinnerStatus = true;
        }
        return WinnerStatus;
    }
}