package com.thoughtworks.tdd;

public class Entrance {


    public static void main(String[] args) {
        ParkingView parkingView = new ParkingView();
        ParkingLotController parkingLotController = new ParkingLotController(new ParkingBoy(), parkingView);
        Router router = new Router(parkingLotController);
        InputCommand inputCommand = new ParkingLotInputCommand();
        Request request = new Request();
        String currentPage = "main";
        while (true) {
            String command = inputCommand.input();
            request.setCommand(command);
            currentPage = router.choosePage(currentPage, request);
        }
    }
//        parkingLotController.start();
//        parkingLotController.operate(new ParkingLotInputCommand());
//        InputCommand inputCommand = new ParkingLotInputCommand();
//        Request request = new Request();
//        String currentPage = "main";
//        Router router  = initRouter(currentPage,request);
//        router.launch();
//        try {
//            while (true){
//            String command = inputCommand.input();
//            request.setCommand(command);
//            router.processRequest(request);
//            }
//        }catch (Exception e){
//            System.out.println("\n App Exist");
//        }finally {
//            inputCommand.close();
//        }
//    }
//
//    private static Router initRouter(String currentPage, Request request) {
//        ParkingBoy parkingBoy = new ParkingBoy();
//        ParkingView parkingView = new ParkingView();
//        Router router = new Router(currentPage);
////        router.registerRoute("main",new MainController(parkingView));
////        router.registerRoute("main/.*",new MainController(parkingView));
////        router.registerRoute("main/2",new ParkingManageController(parkingBoy,parkingView));
////        router.registerRoute("main/1",new ParkingServiceController(parkingBoy,parkingView));
////        router.registerRoute("main/2/.*/.*",new ParkingManageDetailController(parkingBoy,parkingView));
////        router.registerRoute("main/1/.*/.*",new ParkingServiceDetailController(parkingBoy,parkingView));
////        router.registerRoute("exception/.*",new ExceptionController(parkingView));
//        router.registerRoute("main",new MainController(parkingView));
//        router.registerRoute("main/service",new ParkingServiceController(parkingBoy,parkingView));
//        router.registerRoute("main/manage",new ParkingManageController(parkingBoy,parkingView));
//        router.registerRoute("exception",new ExceptionController(parkingView));
//        router.setCurrentPage(currentPage);
//        return router;
//    }router
}
