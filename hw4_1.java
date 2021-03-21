package hw4_1;

import java.util.Scanner;

public class Quick {
	public static void main(String[] args) {
		System.out.println("hw4_1 : 손창하");
		
	    Scanner sc = new Scanner(System.in);
	    System.out.print("단어 수 입력: ");
	    int len = sc.nextInt();
	    String[] n = new String[len];
	    
	    System.out.print(len + "개의 단어 입력: ");
	    for(int i = 0; i < len; i++) {
	    	n[i] = sc.next();
	    }
	    
	    quick(n, 0, len - 1);
	    
	    System.out.print("퀵 정렬 결과 = ");
	    for(int i = 0; i < len; i++) 
	    	System.out.print(n[i] + " ");
	 
	    sc.close();
	    
	    }

	    public static void quick(String[] n, int left, int right){
	        if(left < right) {
	            int result = part(n, left, right);
	            quick(n, left, result - 1);
	            quick(n, result+1, right);
	        }
	    }

	    public static int part(String[] n, int l, int r){
	        int left = l;
	        int right = r - 1;
	        int pivot = r; //배열의 마지막 값이 든 인덱스를 기준으로 설정
	       
	        while(left < right){
	        	//compareTo는 대소문자를 구분하여 비교하지만, IgnoreCase는 대소문자를 구분하지 않음.
	            if(n[left].compareToIgnoreCase(n[pivot]) > 0) { //만약 왼쪽 값이 기준 값 보다 크다면
	                if (n[right].compareToIgnoreCase(n[pivot]) > 0) { //만약 오른쪽 값이 기준 값보다 크다면
	                    right--; // right를 한칸 왼쪽으로 옮김.
	                }
	                else {//만약 오른쪽 값이 기준 값보다 작다면
	                    change(n, left, right);
	                    left++; // 왼쪽 오른쪽 자리 바꿨으니 왼쪽 값을 한칸 앞으로
	                }
	            }
	            else { //만약 왼쪽 값이 기준 값 보다 작다면
	                left++;
	            }
	        }

	        if(n[pivot].compareToIgnoreCase(n[right]) > 0) { //만약 기준 값이 왼쪽, 오른쪽이 만난 값보다 크다면
	            String temp = n[pivot]; //pivot값을 임시 저장
	            //pivot 값을 right값의 오른쪽에 삽입하는 과정
	            for(int i = pivot ; i > right + 1; i--){
	                n[i] = n[i-1];
	            }
	            n[right + 1] = temp;
	            return right+1;
	        } else {
	            String temp = n[pivot]; //pivot값을 임시 저장
	            //pivot 값을 right값의 오른쪽에 삽입하는 과정
	            for(int i = pivot; i > right; i--){
	                n[i] = n[i-1];
	            }
	            n[right] = temp;
	            return right;
	        }
	    }

	    //배열 자리 바꾸기 메소드
	    public static void change(String[] n, int a, int b){
	        String temp = n[a];
	        n[a] = n[b];
	        n[b] = temp;
	    }
}
