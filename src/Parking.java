import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-11
 * Time: 下午4:21
 * To change this template use File | Settings | File Templates.
 */
public class Parking {
    private String randomNumber;
    private int totalNum;
    private int nowNum;
    List carNameList = new ArrayList();
    public Parking(int totalNum) {
        this.totalNum = totalNum;
        nowNum=0;
    }


    public boolean input(String carName){
        if(getEmptyNum()) {
            carNameList.add(carName);
            nowNum++;
            return true;
        }
        else{
            return false;
        }
    }
    public boolean output(String carName){
        if(nowNum>0){
            carNameList.remove(carName);
            nowNum--;
            return true;
        }
        else{
            return false;
        }
    }
    public boolean getEmptyNum(){
        if(totalNum-nowNum>0)
            return true;
        else
            return false;
    }
}
