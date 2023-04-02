package com.laioffer.spork.service;

import com.laioffer.spork.dao.MenuInfoDao;
import com.laioffer.spork.entity.MenuItem;
import com.laioffer.spork.entity.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuInfoService {

    private final MenuInfoDao menuInfoDao;

    public MenuInfoService(MenuInfoDao menuInfoDao) {
        this.menuInfoDao = menuInfoDao;
    }

    public List<Restaurant> getRestaurants() {
        return menuInfoDao.getRestaurants();
    }

    public List<MenuItem> getAllMenuItem(int restaurantId) {
        return menuInfoDao.getAllMenuItem(restaurantId);
    }

    public MenuItem getMenuItem(int id) {
        return menuInfoDao.getMenuItem(id);
    }

}
