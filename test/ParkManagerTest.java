
import entity.*;
import exception.NoCarForTicketException;
import exception.NoSpaceForCarException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertSame;

/**
 * Created with IntelliJ IDEA.
 * User: LuoYunfeng
 * Date: 14-8-16
 * Time: 下午3:05
 * To change this template use File | Settings | File Templates.
 */
public class ParkManagerTest {
    private ParkManager parkManager;

    @Before
    public void initParkManager(){
        ArrayList<ParkingBoy> parkBoys = new ArrayList<ParkingBoy>();

        ArrayList<ParkLot> parkBoyNormalLots = new ArrayList<ParkLot>();
        parkBoyNormalLots.add(new ParkLot(3,"PL.011"));
        parkBoyNormalLots.add(new ParkLot(2,"PL.012"));
        parkBoys.add(new ParkingBoy(new NormalChooser(), parkBoyNormalLots, "PB.001"));

        ArrayList<ParkLot> parkBoySmartLots = new ArrayList<ParkLot>();
        parkBoySmartLots.add(new ParkLot(3,"PL.021"));
        parkBoySmartLots.add(new ParkLot(2,"PL.022"));
        parkBoys.add(new ParkingBoy(new SmartChooser(), parkBoySmartLots, "PB.002"));

        ArrayList<ParkLot> parkBoySuperLots = new ArrayList<ParkLot>();
        parkBoySuperLots.add(new ParkLot(3,"PL.031"));
        parkBoySuperLots.add(new ParkLot(2,"PL.032"));
        parkBoys.add(new ParkingBoy(new SuperChooser(), parkBoySuperLots, "PB.003"));

        ArrayList<ParkLot> parkManagerLots = new ArrayList<ParkLot>();
        parkManagerLots.add(new ParkLot(3,"PL.001"));
        parkManagerLots.add(new ParkLot(2,"PL.002"));

        parkManager = new ParkManager(new SuperChooser(),parkManagerLots,"PM.001",parkBoys);

    }

    @Test
    public void should_push_a_car_if_has_space() {
        Ticket ticket = parkManager.push(new Car());
        assertNotNull(ticket);
    }

    @Test
    public void should_pull_a_car_if_had_park_it(){
        Car car = new Car();
        Ticket ticket = parkManager.push(car);
        assertSame(car, parkManager.pull(ticket));
    }

    @Test (expected = NoSpaceForCarException.class)
    public void should_not_push_a_car_if_has_no_space(){
        for(int i=0;i<20;i++){
            parkManager.push(new Car());
        }
        parkManager.push(new Car());
    }

    @Test (expected = NoCarForTicketException.class)
    public void should_not_pull_a_car_if_has_no_car(){
        Ticket ticket = new Ticket();
        parkManager.pull(ticket);
    }

    @Test
    public void should_print_info_has_one_car(){
        Car car = new Car();
        parkManager.push(car);
        String message =
                "停车场编号：PL.001\n" +
                "\t车位数：3\n" +
                "\t空位数：3\n" +
                "停车场编号：PL.002\n" +
                "\t车位数：2\n" +
                "\t空位数：2\n" +
                "停车仔编号：PB.001\n" +
                    "\t停车场编号：PL.011\n" +
                    "\t\t车位数：3\n" +
                    "\t\t空位数：2\n" +
                    "\t停车场编号：PL.012\n" +
                    "\t\t车位数：2\n" +
                    "\t\t空位数：2\n" +
                    "\tTotal车位数：5\n" +
                    "\tTotal空位数：4\n" +
                "停车仔编号：PB.002\n" +
                    "\t停车场编号：PL.021\n" +
                    "\t\t车位数：3\n" +
                    "\t\t空位数：3\n" +
                    "\t停车场编号：PL.022\n" +
                    "\t\t车位数：2\n" +
                    "\t\t空位数：2\n" +
                    "\tTotal车位数：5\n" +
                    "\tTotal空位数：5\n" +
                "停车仔编号：PB.003\n" +
                    "\t停车场编号：PL.031\n" +
                    "\t\t车位数：3\n" +
                    "\t\t空位数：3\n" +
                    "\t停车场编号：PL.032\n" +
                    "\t\t车位数：2\n" +
                    "\t\t空位数：2\n" +
                    "\tTotal车位数：5\n" +
                    "\tTotal空位数：5\n" +
                "Total车位数：20\n" +
                "Total空位数：19\n";
        assertEquals(message,parkManager.printInfo());
    }

}
