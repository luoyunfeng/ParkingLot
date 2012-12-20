package entity;


import exception.NoSpaceInBoyException;
import interfaces.ParkLotChooser;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: LuoYunfeng
 * Date: 12-12-2
 * Time: 下午3:32
 * To change this template use File | Settings | File Templates.
 */
public class NormalChooser implements ParkLotChooser {
    @Override
    public ParkLot choose(List<ParkLot> parkLots) throws NoSpaceInBoyException {
        for(ParkLot p : parkLots){
            if(p.getAvailableSpace()>0){
                return p;
            }
        }
        throw new NoSpaceInBoyException();
    }
}
