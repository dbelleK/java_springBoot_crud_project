package com.example.crud.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Page {

    // 최소 페이지 번호
    private int min;
    // 최대 페이지 번호
    private int max;

    // 이전 버튼의 페이지 번호
    private int prevPage;
    // 다음 버튼의 페이지 번호
    private int nextPage;

    // 전체 페이지 개수
    private int pageCnt;
    // 현재 페이지 번호
    private int currentPage;

    /*
     1) 1~10 : 1(최소), 10(최대)
        11~20 : 11(최소), 20(최대)
        21~30 : 21(최소), 30(최대)

     2) (currentPage-1) : 최대번호는 최소에 9를 더하므로 (10)-1을 계산해줌

     3) 페이지 당 글의 개수 나눔

     4) 페이지당 글의 개수로 다시 곱함
     */

    //-----------------------------------

    public Page(){

    }
    public Page(String a){

    }

    // contentCnt : 전체글 개수, currentPage : 현재 페이지 번호, contentPageCnt : 페이지당 글의 개수, paginationCnt : 페이지 버튼의 개수
    public Page(int contentCnt, int currentPage, int contentPageCnt, int paginationCnt){

        //현재 페이지 번호
        this.currentPage = currentPage;

        //전체 페이지 개수 (전체 글 개수 / 페이지당 글의 개수)
        pageCnt = contentCnt / contentPageCnt;
        //ex) 533/10=53.3이므로 나머지가 3이므로 1page 더 필요
        if(contentCnt % contentPageCnt > 0){
            pageCnt++;
        }

        //--------------------------------

        //최소값 = ((현재 페이지 번호-1) / 페이지 당 글의 개수) * 페이지 당 글의 개수 + 1
        //ex) ((1-1)/10)*10+1=1
        //    ((2-1)/10)*10+1=2
        //    ((3-1)/10)*10+1=3

        //ex) ((4-1)/11)*11+1=4
        //    ((5-1)/11)*11+1=5
        min = ((currentPage-1) / contentPageCnt) * contentPageCnt +1;

        //최대값 = min +  페이지 버튼의 개수
        //ex) 1 + 2 - 1 = 2 (페이지 버튼의 개수:2, 최소값:1 , 페이지 당 글의 개수:10)
        //(1,2)
        //ex) 4 + 10 -1 = 13 (페이지 버튼의 개수:10, 최소값:4 , 페이지 당 글의 개수:11)
        //(4,5,6,7,8,9,10,11,12,13)
        max = min + paginationCnt -1;

        //1페이지에 1~9번째 글이 존재할경우 max=1+2-1=2, pageCnt=10/9=1.1 -> 2페이지 필요
        //전체페이지를 넘어가지 않도록 세팅함
        if(max > pageCnt){
            max=pageCnt;
        }

        //---------------------------------------

        //이전페이지 누를경우
        prevPage = min-1;
        //다음페이지 누를경우
        nextPage = max+1;

        //마지막페이지를 넘어가지 않도록
        if(nextPage > pageCnt){
            nextPage = pageCnt;
        }

     }
}
