package generics;

public class GenericsChallange {

    public static void main(String[] args) {


        //ArrayList<Team> teams;
        //Collections.sort(teams);
        //Create a generic class to implement a league table for a sport.
        //The class should allow teams to be added to the list, and store
        //a list of teams that belong to the league
        //
        //Your class should have a method to print out the teams in order,
        //with the team at the top of the league printed first
        //
        //Only teams of the same type should be added to any particular
        //instance of the league class - the program should fail to compile
        //if an attempt is made to add an incompatible team.


        League<Team<FootballPlayer>> footballLeague = new League<>("Ekstraklasa");
        Team<FootballPlayer> arkaGdynia = new Team<>("Arka Gdynia");
        Team<FootballPlayer> wislaKrakow = new Team<>("Wisła Kraków");
        Team<FootballPlayer> lechiaGdansk = new Team<>("Lechia Gdańsk");
        Team<BaseballPlayer> whoPlaysThat = new Team<>("Dunno Any");

        lechiaGdansk.matchResult(arkaGdynia, 3, 1);
        arkaGdynia.matchResult(wislaKrakow, 2, 1);
        arkaGdynia.matchResult(lechiaGdansk, 2, 2);

        footballLeague.add(arkaGdynia);
        footballLeague.add(wislaKrakow);
        footballLeague.add(lechiaGdansk);

//        footballLeague.add(whoPlaysThat);

        footballLeague.showLeagueTable();
    }
}
