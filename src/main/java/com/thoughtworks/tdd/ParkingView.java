package com.thoughtworks.tdd;

import java.util.ArrayList;

public class ParkingView {
    private Response response = new Response();


    ParkingView(){
        showBeginView();
    }

    public void showBeginView() {
       response.send("1.停车服务\n" +
               "2.停车场管理\n" +
               "请输入您要进入的页面：");
//        String input = parkingLotInputCommand.input();
//        checkInput(input);
    }

    public void showParkingSevice() {
        response.send("1. 停车\n" +
                "2. 取车 \n" +
                "请输入您要进行的操作：");
    }

    public void showInputReceiptNumber() {
        response.send("请输入小票编号：");
    }

    public void showInputCarLicensePlateNumber() {
        response.send("请输入车牌号:");
    }

    public void showParkingLotFullStatus() {
        response.send("车已停满，请晚点再来");
    }

    public void showErrorInputInfomation() {
        response.send("非法指令，请查证后再输");
    }

    public void showParkingSuccessfully(String receiptNumber) {
        String s = "停车成功，您的小票是";
        response.send(s);
        response.send(receiptNumber);
    }

    public void printsInGUI(String s) {
        System.out.println(s);
    }

    public void showUnparkSuccessfully(String result) {
        String s = "车已取出，您的车牌号是: " + result;
        response.send(s);
    }

    public void showInvaildReceipt() {
        String s = "非法小票，无法取出车，请查证后再输";
        response.send(s);
    }

    public void showParkingManage() {
        response.send("1.查看停车场详情\n" +
                "2.添加停车场\n" +
                "3.删除停车场");
    }
    public void showInputParkingLotInfomation(){
        response.send("请输入你添加的停车场信息（格式为：名称，车位）：");
    }

    public void showAddParkingLotSuccessfully() {
        response.send("停车场添加成功！");
    }

    public void showInputParkingLotId() {
        response.send("请输入需要删除的被管理停车场ID:");
    }

    public void showDeleteParkingLotSuccessfully() {
        response.send("停车场删除成功！");
    }

    public void showDeleteParkingLotUnsucessfully(String reason) {
        response.send("停车场删除失败，原因："+reason);
    }

    public void showParkingDetail(ArrayList<ParkingLot> parkingLotArrayList) {
        response.send("|停车场ID|名称|车位|已停车辆|剩余车位|\n" +
                "======================================");
        parkingLotArrayList.forEach(parkingLot -> {
            response.send("|"+parkingLot.getId()+"|"+parkingLot.getName()+"|"+parkingLot.getSize()+"(个)|"+parkingLot.getParkCarMap().size()+"(辆)|"+(parkingLot.getSize()-parkingLot.getParkCarMap().size())+"(个)|");
        });
        response.send("总车位："+parkingLotArrayList.stream().mapToInt(parkingLot->parkingLot.getSize()).sum()+"(个)\n" +
                "停车总量："+parkingLotArrayList.stream().mapToInt(parkingLot->parkingLot.getParkCarMap().size()).sum()+"（辆）\n" +
                "总剩余车位："+parkingLotArrayList.stream().mapToInt(parkingLot->parkingLot.getSize()-parkingLot.getParkCarMap().size()).sum()+"（个）");
    }
}
