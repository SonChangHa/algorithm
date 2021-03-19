package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] n = new int[]{4,5,2,1,3};
    quick(n, 0, 4);

    System.out.println(Arrays.toString(n));
    }

    public static void quick(int[] n, int left, int right){
        if(left <= right) {
            System.out.println("start");
            int result = part(n, left, right);
            quick(n, left, result - 1);
            quick(n, result+1, right);
        }
    }

    public static int part(int[] n, int l, int r){
        int left = l;
        int right = r;
        int pivot = r; //배열의 길이 - 1 = 배열의 마지막 값이 든 인덱스
        right -= 1;
        while(left < right){
            System.out.println(Arrays.toString(n));
            System.out.print(n[left]);
            System.out.println(n[right]);
            if(n[left] > n[pivot]) { //만약 왼쪽 값이 기준 값 보다 크다면
                if (n[right] > n[pivot]) { //만약 오른쪽 값이 기준 값보다 크다면
                    right -= 1; // right를 한칸 왼쪽으로 옮김.
                    System.out.println("r--");
                }
                else {//만약 오른쪽 값이 기준 값보다 작다면
                    change(n, left, right);
                    left++; // 왼쪽 오른쪽 자리 바꿨으니 왼쪽 값을 한칸 앞으로
                    System.out.println("change");
                }
            }
            else { //만약 왼쪽 값이 기준 값 보다 작다면
                left += 1;
                System.out.println("l++");
            }
        }

        if(n[pivot] > n[right]) { //만약 기준 값이 왼쪽, 오른쪽이 만난 값보다 크다면
            int temp = n[pivot]; //pivot값을 임시 저장
            //pivot 값을 right값의 오른쪽에 삽입하는 과정
            for(int i = pivot ; i > right + 1; i--){
                n[i] = n[i-1];
            }
            n[right + 1] = temp;
            System.out.println(Arrays.toString(n));
            System.out.println("done");
            return right+1;
        } else {
            int temp = n[pivot]; //pivot값을 임시 저장
            //pivot 값을 right값의 오른쪽에 삽입하는 과정
            for(int i = pivot; i > right; i--){
                n[i] = n[i-1];
            }
            n[right] = temp;
            System.out.println(Arrays.toString(n));
            System.out.println("done");
            return right;
        }
    }

    public static void change(int[] n, int a, int b){
        int temp = n[a];
        n[a] = n[b];
        n[b] = temp;
    }
}
