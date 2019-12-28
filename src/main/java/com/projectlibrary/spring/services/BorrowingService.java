package com.projectlibrary.spring.services;

import com.projectlibrary.spring.models.Book;
import com.projectlibrary.spring.models.Borrowing;
import com.projectlibrary.spring.models.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BorrowingService {

    private List<Borrowing> borrowings;
    @Autowired
    private MemberService memberService;
    @Autowired
    private BookService bookService;


    public BorrowingService() {
        borrowings = new ArrayList<>();
    }

    public List<Borrowing> getAllBorrowing() {
        return this.borrowings;
    }

    public Borrowing getBorrowingById(int borrowingId) {
        for (Borrowing borrowing : borrowings) {
            if (borrowing.getId() == borrowingId) {
                return borrowing;
            }
        }

        return null;
    }

    public void borrow(String memberId, int bookId) {
        Member member = memberService.getMemberById(memberId);
        Book book = bookService.getBookById(bookId);

        Borrowing borrowing = new Borrowing();
        borrowing.setId(borrowings.size());
        borrowing.setMember(member);
        borrowing.setBook(book);
        borrowing.setStartTime(new Date());

        borrowings.add(borrowing);
    }

    public void returnBook(String memberId, int bookId){
        for(Borrowing borrowing : borrowings) {
            String mMemberId = borrowing.getMember().getId();
            int mBookId = borrowing.getBook().getId();

            if (mMemberId.equals(memberId) && mBookId == bookId) {
                borrowing.setReturnTime(new Date());
            }
        }
    }
}
