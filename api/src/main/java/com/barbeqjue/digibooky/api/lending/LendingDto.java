package com.barbeqjue.digibooky.api.lending;

import com.barbeqjue.digibooky.domain.actor.member.Member;
import com.barbeqjue.digibooky.domain.book.Book;

import java.time.LocalDate;

public class LendingDto {
    private Integer uuid;
    private LocalDate dueDate;
    private Member member;
    private Book book;

    private LendingDto(){}

    public static LendingDto lendingDto(){
        return new LendingDto();
    }

    public LendingDto withUuid(Integer uuid){
        this.uuid = uuid;
        return this;
    }

    public LendingDto withDueDate (LocalDate dueDate){
        this.dueDate = dueDate;
        return this;
    }

    public LendingDto withMember (Member member){
        this.member = member;
        return this;
    }

    public LendingDto withBook (Book book){
        this.book = book;
        return this;
    }

    public Integer getUuid() {
        return uuid;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public Member getMember() {
        return member;
    }

    public Book getBook() {
        return book;
    }
}
