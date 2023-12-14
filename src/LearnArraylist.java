import java.util.ArrayList;

public class LearnArraylist {

    public static void main(String[] args)
    {
        ArrayList<String> studentsName=new ArrayList<>();
        studentsName.add("tejas");
        System.out.println(studentsName);
        ArrayList<Integer>list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        list.add(4);
        System.out.println(list);
        list.add(1,30);
        System.out.println(list);
        ArrayList<Integer>newlist=new ArrayList<>();
        newlist.add(66);
        newlist.add(67);
        list.addAll(newlist);
        System.out.println(list);
        System.out.println(list.get(4));
        list.remove(Integer.valueOf(30));
        System.out.println(list);
        list.remove(3);
        System.out.println(list);
        //clear function remove every element from list
//        list.clear();
//        System.out.println(list);
        list.set(3,1000);//update value at given index
        System.out.println(list);
    }
}
