import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-25
 * Time: 下午2:48
 * To change this template use File | Settings | File Templates.
 */
public class ParkingBoy {
    private Map<Ticket, Car> parkedCarList = new HashMap<Ticket, Car>();
    private Integer maxParkingNum;
    public ParkingBoy(ParkPlace parkPlace){

    }
    public Integer GetAvailableNum() {
        return maxParkingNum - parkedCarList.size();
    }
    public Ticket parking(Car car){
        Ticket ticket = new Ticket();
        if (GetAvailableNum() == 0) {
            throw new NoPlaceException("没有停车位了！");
        }
        parkedCarList.put(ticket, car);
        return ticket;
    }
    public Car GetParkedCar(Ticket pp) throws NoCarException {
        if (parkedCarList.containsKey(pp)) {
            return parkedCarList.remove(pp);
        }
        throw new NoCarException("没有此车 请拨打110！");
    }
}
