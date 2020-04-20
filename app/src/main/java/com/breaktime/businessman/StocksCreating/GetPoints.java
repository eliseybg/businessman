package com.breaktime.businessman.StocksCreating;

public class GetPoints {
    static int points[][] = new int[7][7];
    static String lineX;
    static String lineY;

    public GetPoints(String lineX, String lineY) {
        this.lineX = lineX;
        this.lineY = lineY;
        readLine(lineX, lineY);
    }

    public static void readLine(String lineX, String lineY) {
        for (int i = 0; i < 7; i++) {
            int indexX = Integer.parseInt(lineX.substring(0, lineX.indexOf(" ")));
            lineX = lineX.substring(lineX.indexOf(" ") + 2);
            int indexY = Integer.parseInt(lineY.substring(0, lineY.indexOf(" ")));
            lineY = lineY.substring(lineY.indexOf(" ") + 2);
            points[i][0] = indexX;
            points[i][1] = indexY;
        }

//        points[10][0] = Integer.parseInt(lineX.trim());
//        points[10][1] = Integer.parseInt(lineY.trim());

    }

    public int[][] getPoints(){
        return points;
    }
}
