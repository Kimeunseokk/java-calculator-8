package calculator;

import java.util.Scanner;

public class Application { // 예외처리방법 ---> try-catch 
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner scanner = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요 : ");
        String num = scanner.nextLine();

        try{
            int result = plus(num);
            System.out.println("결과 : "+result);
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            throw e;
        }
        scanner.close();
        
    }

    public static int plus(String num){

        String[] number;

         if(num.indexOf("//")!= -1) // Stinrg.indexOf()을 수행했을때 특정 문자를 찾지 못하면 -1값을 반환한다.
         {
            int index = num.indexOf("\n");
            int index2 = num.indexOf("//");

        if(index == -1 ){ 
            index = num.indexOf("\\n");
            String xay = num.substring(index2+2, index);
            String subindex = num.substring(index+2);
            number = subindex.split(xay);
        }    
        else if(index != -1 && index2 != -1){ // \n과 //이 문자열에 모두 존재할떄 
                String xay = num.substring(index2+2, index); // String.substring(x,y) ----> 문자열 일부(인덱스x와 y사이) 잘라내서 추출하기
                //number[index2:index]; ---> 이건 파이썬문법
                String subindex = num.substring(index+1); // String.substring(x) ---> x의 인덱스에서부터 끝까지 추출하기
                number = subindex.split(xay);
            }
            else throw new IllegalArgumentException("잘못된 커스텀 구분자가 입력되었습니다");
        }
        else {
            number = num.split(",|:");
        }

        int[] t = new int[number.length]; 
        int sum = 0;

        for(int i=0; i<number.length; i++){ // String.split() --> 나누기 , String.indexOf() ---> 위치찾기, String.startWith() ---> 시작점찾기
        
            try{
                t[i] = Integer.parseInt(number[i]);
            }
            catch(NumberFormatException e){
                throw new IllegalArgumentException("숫자를 입력해주세요");
            }
            if (t[i] < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다") ;
            }
            sum += t[i];
            }

            return sum;
        }
    
        
    }

