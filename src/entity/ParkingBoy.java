package entity;

import entity.Car;
import exception.NoCarInBoyException;
import exception.NoCarInLotException;
import exception.NoSpaceForCarException;
import exception.NoSpaceInBoyException;
import interfaces.ParkLotChooser;
import utils.PrintHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: LuoYunfeng
 * Date: 12-11-25
 * Time: 下午2:48
 * To change this template use File | Settings | File Templates.
 */
public class ParkingBoy {
    private String number;
    private ParkLotChooser parkLotChooser;
    private List<ParkLot> parkLots;
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public ParkLotChooser getParkLotChooser() {
        return parkLotChooser;
    }
    public void setParkLotChooser(ParkLotChooser parkLotChooser) {
        this.parkLotChooser = parkLotChooser;
    }
    public List<ParkLot> getParkLots() {
        return parkLots;
    }
    public void setParkLots(List<ParkLot> parkLots) {
        this.parkLots = parkLots;
    }
    public ParkingBoy(ParkLotChooser parkLotChooser, List<ParkLot> parkLots, String number) {
        this.setParkLotChooser(parkLotChooser);
        this.setParkLots(parkLots);
        this.setNumber(number);
    }

    public Ticket push(Car car)  throws NoSpaceInBoyException {
        ParkLot p = parkLotChooser.choose(this.getParkLots());
        return p.push(car);
    }

    public Car pull(Ticket ticket) throws NoCarInBoyException {
        Car car;
        for(ParkLot p : this.getParkLots()){
            try{
                car = p.pull(ticket);
                return car;
            }catch (NoCarInLotException e){
            }
        }
        throw new NoCarInBoyException();
    }

    public String printInfo() {
        return printInfoWithTabs(0);
    }

    public String printInfoWithTabsNoTotal(int tabs){
        String message = "";
        for(ParkLot pl : this.getParkLots()){
            message += pl.printInfoWithTabs(tabs);
        }
        return message;
    }
    public String printInfoWithTabs(int tabs){
        String message = printInfoWithTabsNoTotal(tabs);
        message += PrintHelper.getStatLabel(this.getSpace(), this.getEmpty(), tabs);
        return message;
    }

    public int getSpace(){
        int space = 0;
        for(ParkLot pl : this.getParkLots()){
            space += pl.getTotalSpace();
        }
        return space;
    }

    public int getEmpty(){
        int empty = 0;
        for(ParkLot pl : this.getParkLots()){
            empty += pl.getAvailableSpace();
        }
        return empty;
    }
}
