package com.logiston.services;


import com.logiston.entity.Theme;

public interface ThemeService {
    Iterable<Theme> listAllThemes();

    Theme getThemeById(Long id);

    Theme saveTheme(Theme theme);

    void delete(Long id);
}
