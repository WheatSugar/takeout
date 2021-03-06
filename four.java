package rush;

import java.util.Random;
import java.util.Scanner;

public class four {
    //外卖单号数组
    static String[] danhaoArr = new String[100];
    //公司名数组
    static String[] companyArr = new String[100];
    //取件码数组
    static int[] maArr = new int[100];
    //外卖柜中快递数量
    static int index = 0;
    public static Random random = new Random();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("=====欢迎使用吃饱饱外卖柜=====");
        System.out.println("请输入您的身份：1-外卖员，2-用户");
        int shenfen = input.nextInt();
        switch (shenfen) {
            case 1:
                System.out.println("请选择操作:1-存外卖 2-删除外卖 3-修改外卖信息 4-查看所有外卖");
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("请输入外卖单号");
                        String danhao = input.next();
                        danhaoArr[index] = danhao;
                        System.out.println("请输入公司名称");
                        String ming = input.next();
                        companyArr[index] = ming;
                        //自动生成取件码 100-900
                        int ma = 0;
                        //保证取件码不重复
                        do {
                            ma = random.nextInt(900) + 100;
                        } while (isExist(ma) != -1);
                        maArr[index] = ma;
                        index++;
                        System.out.println("外卖已存入，取件码是：" + ma);
                        break;
                    case 2:
                        System.out.println("请输入要删除的外卖单号：");
                        String shan = input.next();
                        int delIndex = findByNumber(shan);
                        if (delIndex == -1) {
                            System.out.println("未找到外卖");
                        } else {
                            del(delIndex);
                            System.out.println("删除成功");
                        }

                        System.out.println("未找到外卖");
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                }
                break;
            case 2:
                System.out.println("请输入取件码：");
                int ma = input.nextInt();
                int maIndex = isExist(ma);
                if (maIndex == -1) {
                    System.out.println("未找到外卖");
                } else {
                    del(maIndex);
                    System.out.println("取件成功");
                }
                break;
            default:
                System.out.println("选择有误");
                break;
        }
    }

    private static int isExist(int ma) {
        for (int i = 0; i < index; i++) {//遍历取件码数组
            if (maArr[i] == ma) {//判断是否重复
                return i;
            }
        }
        return -1;
    }

    private static void del(int delIndex) {
        if (delIndex != danhaoArr.length - 1) {
            for (int i = delIndex; i < index; i++) {
                danhaoArr[i] = danhaoArr[i + 1];
                companyArr[i] = companyArr[i + 1];
                maArr[i] = maArr[i + 1];
            }
        }
        index--;
    }

    private static int findByNumber(String number) {
        for (int i = 0; i < index; i++) {
            if (danhaoArr[i].equals(number)) {
                return i;
            }
        }
        return -1;
    }
}