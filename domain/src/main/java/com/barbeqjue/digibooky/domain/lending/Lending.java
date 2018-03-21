package com.barbeqjue.digibooky.domain.lending;

import com.barbeqjue.digibooky.domain.book.Book;
import com.barbeqjue.digibooky.domain.member.Member;

import java.time.LocalDate;

public class Lending {
    private Integer uuid;
    private LocalDate dueDate;
    private Member member;
    private Book book;

    public Lending() {
    }

    public Lending(Integer uuid, LocalDate dueDate, Member member, Book book) {
        this.uuid = uuid;
        this.dueDate = dueDate;
        this.member = member;
        this.book = book;
    }

    public Integer getuuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public static class LendingBuilder {
        private Integer uuid;
        private LocalDate dueDate;
        private Member member;
        private Book book;

        private LendingBuilder() {
        }

        public static LendingBuilder lending() {return new LendingBuilder(); }

        public Lending build() {
            Lending lending = new Lending();
            lending.setUuid(uuid);
            lending.setDueDate(dueDate);
            lending.setMember(member);
            lending.setBook(book);
            return lending;

        }

        public LendingBuilder withUuid(Integer uuid) {
            this.uuid = uuid;
            return this;
        }

        public LendingBuilder withoutUuid() {
            this.uuid = null;
            return this;
        }

        public LendingBuilder withDueDate(LocalDate dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public LendingBuilder withMember(Member member) {
            this.member = member;
            return this;
        }

        public LendingBuilder withBook(Book book) {
            this.book = book;
            return this;
        }
    }
}
