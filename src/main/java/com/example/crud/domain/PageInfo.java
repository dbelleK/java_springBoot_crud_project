package com.example.crud.domain;

import lombok.Getter;
import lombok.Setter;

import javax.lang.model.type.IntersectionType;

@Getter
@Setter
public class PageInfo {

    private int currentPage = 1;
    private int pageTotal; //페이지 전체 갯수

    private int startPageIndex; //현재 보여지는 페이지의 첫번째 인덱스(1부터 시작)
    private int endPageIndex; //현재 보여지는 페이지의 마지막 인덱스(1부터 시작)
    private int blockPage = 5; //한 화면에 보여줄 페이지의 수(번호수 1페이지, 2페이지,3페이지,4페이지,5페이지)

    private int itemCountPerPage = 12; //페이지 당 아이템 수
    private int itemCountTotal; //전체 아이템 수
    private int start;

    public PageInfo(Integer currentPage){
        //현재 페이지가 1보다 작거나 null이면 1 그렇지 않으면 현재페이지 보여줌
        this.currentPage = currentPage == null || currentPage < 1 ? 1: currentPage;
        this.start = computeStart();
    }

    public PageInfo(Integer currentPage, Integer itemCountPerPage){
        //현재 페이지가 1보다 작으면 1 그렇지 않으면 현재페이지 보여줌
        this.currentPage=currentPage < 1 ? 1 : currentPage;
        this.itemCountPerPage = itemCountPerPage;
        this.start = computeStart();
    }

    private int computeStart(){
        //(현재페이지-1)*페이지 당 아이템 수
        return (currentPage-1) * itemCountPerPage;
    }

    public void setItemCountTatal(int itemCountTotal){
        this.itemCountTotal = itemCountTotal;

        //페이지 전채 갯수 = (전체아이템 수 % 페이지 당 아이템 수)가 0 이면 (전체 아이템 수 / 페이지 당 아이템수)이고
        // 그렇지 않으면 (전체아이템 수 / 페이지 당 아이템 수 +1) 이다.
        this.pageTotal = itemCountTotal % itemCountPerPage == 0 ? (itemCountTotal / itemCountPerPage) : (itemCountTotal / itemCountPerPage + 1);

        //화면에 보여지는 페이지의 첫번째 인덱스 =
        // ((현재페이지-1)/한화면에 보여줄 페이지수(5)) * 5 + 1 //1이면 1, 2이면 2, 3이면 3
        this.startPageIndex = ((currentPage-1)/ this.blockPage) * this.blockPage +1;

        //현재 보여지는 페이지의 마지막 인덱스 =
        //1+5-1=5(최소가1이면5까지), 2+5-1=6(2이면6)
        this.endPageIndex = this.startPageIndex + this.blockPage -1;

        //현재 보여지는 페이지의 마지막 인덱스 =
        //현재 보여지는 페이지의 마지막 인덱스가 페이지 전체 갯수 보다 크면 페이지 전체 갯수
        //그렇지 않으면 현재 보여지는 페이지의 마지막 인덱스
        this.endPageIndex = this.endPageIndex > this.pageTotal ? this.pageTotal : this.endPageIndex;

    }
}
