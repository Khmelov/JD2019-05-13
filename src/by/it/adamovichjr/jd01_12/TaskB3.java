package by.it.adamovichjr.jd01_12;

import java.util.LinkedList;
import java.util.List;

public class TaskB3 {
    public static void main(String[] args) {

        LinkedList<String> link = new LinkedList<>();
        for (int i = 1; i <= 4096; i++) {
            link.add("n" + i);
        }
        System.out.println(process(link));

    }
    static void deleteFirstAndLast(List<String>peoples){
        peoples.remove(0);
        peoples.remove(peoples.size()-1);
    }
    static void copyAndRemoveFirstAndLast(List<String>peoples,List<String>survivors,int startAdd,int endAdd){
        survivors.add(startAdd, peoples.get(0));
        peoples.remove(0);
        survivors.add(survivors.size() - endAdd, peoples.get(peoples.size() - 1));
        peoples.remove(peoples.size() - 1);
    }
    static void copyFirstDeleteFirstAndLast(List<String>peoples,List<String>survivors,int startAdd){
        peoples.remove(peoples.size() - 1);
        survivors.add(startAdd,peoples.get(0));
        peoples.remove(0);
    }
    static void deleteFirstCopyLastAndDelete(List<String>peoples,List<String>survivors,int endAdd){
        peoples.remove(0);
        survivors.add(survivors.size()-endAdd,peoples.get(peoples.size()-1));
        peoples.remove(peoples.size()-1);
    }

    static boolean firstDelete = false;
    static boolean odd;
    static String result2 = "";

    static String process(LinkedList<String> peoples){

        LinkedList<String> survivors = new LinkedList<>();
        if(peoples.size() % 2 ==0){
            odd = false;
        }else {odd = true;}
        int startAdd = 0;
        int endAdd = 0;
        while (!peoples.isEmpty()){
            int inArrayCount = 1;
            int halfSize = peoples.size()/2;
            if(!odd && !firstDelete){
                for (int i = 0; i < halfSize;i++) {
                    if(inArrayCount % 2 ==1) {
                        copyFirstDeleteFirstAndLast(peoples,survivors,startAdd);
                        startAdd++;
                        inArrayCount++;
                    }
                    else if(inArrayCount % 2 == 0){
                        deleteFirstCopyLastAndDelete(peoples,survivors,endAdd);
                        endAdd++;
                        inArrayCount++;
                    }
                }

            }

            else if (!odd && firstDelete) {
                for (int i = 0; i < halfSize;i++) {
                    if (inArrayCount % 2 == 1) {
                        deleteFirstCopyLastAndDelete(peoples,survivors,endAdd);
                        endAdd++;
                        inArrayCount++;
                    }
                    else if (inArrayCount % 2 == 0) {
                        copyFirstDeleteFirstAndLast(peoples,survivors,startAdd);
                        startAdd++;
                        inArrayCount++;
                    }
                }
            }
            else if(odd && !firstDelete){
                firstDelete = true;
                for (int i = 0; i < halfSize;i++) {
                    if(inArrayCount % 2 ==1){
                        copyAndRemoveFirstAndLast(peoples,survivors,startAdd,endAdd);
                        startAdd++;
                        endAdd++;
                        inArrayCount++;
                        if(peoples.size() ==1){
                            peoples.remove(0);
                        }
                    }
                    else if(inArrayCount % 2 ==0){
                        deleteFirstAndLast(peoples);
                        inArrayCount++;
                        if(peoples.size() ==1){
                            survivors.add(startAdd,peoples.get(0));
                        }
                    }

                }
            }
            else if(odd && firstDelete){
                if(inArrayCount % 2 ==1){
                    deleteFirstAndLast(peoples);
                    inArrayCount++;
                    if(peoples.size() ==1){
                        survivors.add(startAdd,peoples.get(0));
                    }
                }
                else if(inArrayCount %2 == 0){
                    copyAndRemoveFirstAndLast(peoples,survivors,startAdd,endAdd);
                    startAdd++;
                    endAdd++;
                    inArrayCount++;
                    if(peoples.size() ==1){
                        peoples.remove(0);
                    }
                }
            }
        }

        if(peoples.isEmpty() && survivors.size() !=1){
            if(survivors.size() % 2 == 0){odd = false;}
            else {odd = true;}
            process(survivors);
        }
        else if(survivors.size() == 1){
            result2 = survivors.get(0);
        }
        return result2;
    }

}
