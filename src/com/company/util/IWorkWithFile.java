package com.company.util;

import com.company.model.Anime;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public interface IWorkWithFile<T> {
    List<? super Anime> read(final String filePath) throws FileNotFoundException;

    void write(final String filepath, final  List<? super Anime> animeList) throws IOException;
}

