package com.poly.lab5.service.impl;

import com.poly.lab5.dao.AccountDAO;
import com.poly.lab5.entity.Account;
import com.poly.lab5.service.AccoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Optional;
@SessionScope
@Service
public class AccoutServiceImpl implements AccoutService {
    @Autowired
    AccountDAO accountDAO;

    @Override
    public Boolean chechlogin(String username, String password) {
        Optional<Account> optionalAccount = accountDAO.findById(username);
        if (optionalAccount.isPresent() && optionalAccount.get().getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}
