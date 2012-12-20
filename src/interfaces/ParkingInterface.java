package interfaces;

import entity.Car;
import entity.Ticket;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: LuoYunfeng
 * Date: 12-11-25
 * Time: 下午7:11
 * To change this template use File | Settings | File Templates.
 */
public interface ParkingInterface {

    public Ticket push(Car car);

    public Car pull(Ticket ticket);

    public String printInfo();
}