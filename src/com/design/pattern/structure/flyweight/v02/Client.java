package com.design.pattern.structure.flyweight.v02;

/**
 * 享元的应用：
 * 围棋
 *
 * 享元的
 * 内部状态是：颜色；
 * 外部状态时是 坐标
 */
public class Client {


    public static void main(String[] args) {
        IgoChessman black1, black2, black3, white1, white2;
        IgoChessmanFactory factory;

        factory = IgoChessmanFactory.getInstance();

        black1 = factory.getIgoChessman("b");
        black2 = factory.getIgoChessman("b");
        black3 = factory.getIgoChessman("b");
        System.out.println(black1 == black2);
        System.out.println(black3==black1);

        white1 = factory.getIgoChessman("w");
        white2 = factory.getIgoChessman("w");
        System.out.println(white1 == white2);

        black1.display(new Coordinates(1,1));
        black2.display();
        black3.display();
        white1.display();
        white2.display();

    }
}
