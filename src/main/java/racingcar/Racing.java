package racingcar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Racing {
    private RacingInput ri;
    private RacingOutput ro;
    private CarMover cm;

    Racing()
    {
        ri = new RacingInput();
        ro = new RacingOutput();
        cm = new CarMover();
    }

    public void startRacing() throws IOException, IllegalArgumentException
    {
        ro.putNameInputStatement();
        List<String> carNames = ri.getNameOfCars();
        int n = carNames.size();

        ro.putTryInputStatement();
        int tries = ri.getCountOfTries();

        ro.putResultStatement();
        List<Integer> carDis = new ArrayList<>();
        for(int i = 0 ; i<tries ; i++)
        {
            List<Boolean> whetherMoveOrNot = cm.decideToMoveCars(n);
            carDis = cm.moveEveryCar(n, carDis, whetherMoveOrNot);
            ro.putResultOfMovement(n, carNames, carDis);
        }

        List<String> winnerList = ro.getResultOfWinner(n, carNames, carDis);
        ro.putResultOfWinner(winnerList);
        ro.closeOutput();
    }
}