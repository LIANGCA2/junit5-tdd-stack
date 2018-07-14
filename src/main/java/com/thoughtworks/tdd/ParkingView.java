package com.thoughtworks.tdd;

public class ParkingView {


    public void showBeginView() {
        System.out.println("1. 停车\n" +
                "2. 取车 \n" +
                "请输入您要进行的操作：");
//        String input = parkingLotInputCommand.input();
//        checkInput(input);
    }


    public Boolean showChooseInputResult(Result result) {
        if(result.getChoice()==1 && result.getParkingLotFullStatus()){
            System.out.println("车已停满，请晚点再来");
            showBeginView();
            return true;
        }else if(result.getChoice()==1 && !result.getParkingLotFullStatus()){
            System.out.println("请输入车牌号:");
            return false;
        }else if(result.getChoice() == 2){
            System.out.println("请输入小票编号：");
            return false;
        }else{
            System.out.println("非法指令，请查证后再输");
            showBeginView();
            return true;

        }

    }

    public void showOperateCarResult(Result operateCarResult) {
        if(operateCarResult.getChoice()==1 ){
            System.out.println("停车成功，您的小票是");
            System.out.println(operateCarResult.getResult());
        }else if(operateCarResult.getResult()!=""){
            System.out.println("车已取出，您的车牌号是: "+operateCarResult.getResult());
        }else{
            System.out.println("非法小票，无法取出车，请查证后再输");
        }
        showBeginView();
    }
}
