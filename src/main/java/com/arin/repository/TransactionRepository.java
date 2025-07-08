package com.arin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arin.entity.Transaction;
import com.arin.entity.User;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	List<Transaction> findBySenderOrReciever(User sender, User reciever);
}
