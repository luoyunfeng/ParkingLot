package entity;

import exception.NoCarForTicketException;
import exception.NoCarInBoyException;
import exception.NoSpaceForCarException;
import exception.NoSpaceInBoyException;
import interfaces.ParkLotChooser;
import utils.PrintHelper;


import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: LuoYunfeng
 * Date: 12-12-17
 * Time: 下午12:23
 * To change this template use File | Settings | File Templates.
 */
public class ParkManager extends ParkingBoy{

    private List<ParkingBoy> parkBoys;

    public ParkManager(ParkLotChooser parkLotChooser, List<ParkLot> parkLots, String number, List<ParkingBoy> parkBoys) {
        super(parkLotChooser, parkLots, number);
        this.setParkBoys(parkBoys);
    }

    public List<ParkingBoy> getParkBoys() {
        return parkBoys;
    }

    public void setParkBoys(List<ParkingBoy> parkBoys) {
        this.parkBoys = parkBoys;
    }

    @Override
    public Ticket push(Car car) throws NoSpaceForCarException {
        Ticket ticket = null;
        for(ParkingBoy pb : this.getParkBoys()){
            try{
                ticket = pb.push(car);
                return ticket;
            }catch (NoSpaceInBoyException e){ }
        }
        try{
            ticket = super.push(car);
            return ticket;
        }catch (NoSpaceInBoyException e){ }
        throw new NoSpaceForCarException();
    }

    @Override
    public Car pull(Ticket ticket) throws NoCarForTicketException {
        Car car = null;
        for(ParkingBoy pb : this.getParkBoys()){
            try{
                car = pb.pull(ticket);
                return car;
            }catch (NoCarInBoyException e){ }
        }
        try{
            car = super.pull(ticket);
            return car;
        }catch (NoCarInBoyException e){ }
        throw new NoCarForTicketException();
    }

    @Override
    public String printInfo() {
        return printInfoWithTabs(0);
    }

    public String printInfoWithTabs(int tabs){
        String message =super.printInfoWithTabsNoTotal(tabs);
        int space = super.getSpace();
        int empty = super.getEmpty();
        for(ParkingBoy pb : this.getParkBoys()){
            message += PrintHelper.getParkBoyLabel(pb.getNumber(), tabs);
            message += pb.printInfoWithTabs(tabs+1);
            space += pb.getSpace();
            empty += pb.getEmpty();
        }
        message += PrintHelper.getStatLabel(space, empty, tabs);
        return message;
    }
}
