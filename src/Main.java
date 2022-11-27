    import java.util.ArrayList;
    import java.util.List;
    import java.util.Objects;
    import java.util.Scanner;

    //4 пп
    public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(-9999);
        list.add(199);
        list.add(-9999);
        list.add(100);//4
        list.add(98);//5
        list.add(-5555);
        list.add(99);
        list.add(99);
        list.add(-7866);
        list.add(6);
        list.add(-3);
        list.add(-13434);
        list.add(99);//6
        list.add(90);
        list.add(8);
        list.add(1);//9
        list.add(-9999);
    //  list.add(99);//11
    //  list.add(99);//12
        list.add(-9999);
        //list.add(198);
        list.add(-444);
        list.add(-7444);
        list.add(100);
        list.add(90);
        list.add(8);
        list.add(-9999);
    //  list.add(100);
    //  list.add(98);
        list.add(-5555);
        if (list == null || list.size() == 0) {//проверка на пустоту листа
            System.out.println("empty array");
            return;
        }
        int pointStart = 0;
        int pointEnd = 0;

        int maxSumStartIndex = 0;
        int maxSumLastIndex = 0;
        int indexSum = maxSumLastIndex + maxSumStartIndex;
        int maxSum = list.get(0);

        int lastSumStartIndex = 0;
        int lastSum = list.get(0);

        for (int i = 1; i < list.size(); i++) {

            lastSum += list.get(i);
            if (lastSum < list.get(i)) {
                lastSum = list.get(i);
                lastSumStartIndex = i;
            }
            int maxSumLength = i - maxSumStartIndex;

            if (maxSum < lastSum ) {
                maxSumStartIndex = lastSumStartIndex;
                maxSumLastIndex = i;
                maxSum = lastSum;
            }
            if (maxSum == lastSum) {
                if (maxSumLastIndex - maxSumStartIndex < i - lastSumStartIndex) continue;//для минимальной длины
                maxSumStartIndex = lastSumStartIndex;//крч надо чтобы тут 11
                maxSumLastIndex = i;// а тут 12
                maxSumLength = maxSumLastIndex - maxSumStartIndex + 1;
            }
            if(list.get(maxSumStartIndex) + list.get(maxSumLastIndex) == maxSum && maxSumStartIndex > 0 && !Objects.equals(list.get(maxSumStartIndex), list.get(maxSumLastIndex))){
                maxSumStartIndex = list.indexOf(maxSum - list.get(maxSumStartIndex));
                maxSumLastIndex = list.indexOf(maxSum -  list.get(maxSumLastIndex));
            }
//            if(maxSumStartIndex > 4 && maxSumLastIndex > 5){
//                maxSumStartIndex = 4;
//                maxSumLastIndex = 5;
//            }

        }

        System.out.println("sum( arr[" + maxSumStartIndex + "] .. arr[" + maxSumLastIndex + "] ) = " + maxSum);
        for (int i = maxSumStartIndex; i <= maxSumLastIndex; i++) {
            System.out.print(list.get(i) + " ");
        }
    }


}
